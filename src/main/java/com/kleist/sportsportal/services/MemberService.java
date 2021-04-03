package com.kleist.sportsportal.services;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.*;
import com.kleist.sportsportal.exceptions.UserExistsException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.neo4j.ogm.session.Session;
import org.yaml.snakeyaml.reader.StreamReader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

@Slf4j
public class MemberService implements IMemberService {

    private Session session;
    private  SecutityService secutityService;
    @Inject
    public MemberService(Session session, SecutityService secutityService) {
        this.session = session;
        this.secutityService = secutityService;
    }


    @Override
    public void CreateMember(Member member) throws Exception {
        try {
            val map = new HashMap<String , Object>();
            map.put("memberUsername", member.getMemberUsername());
            map.put("email", member.getEmail());
            map.put("mobil", member.getMobil());
            val res = session.query("match (m:Member) where m.memberUsername=$memberUsername and m.email=$email and m.mobil=$mobil return m" ,map);
            if(res.queryResults().iterator().hasNext()){
                throw new UserExistsException("User with Username " + member.getMemberUsername() + " and email " + member.getEmail() + " and mobil " +  member.getMobil() +"  already exist");
            } else {
                session.save(member);
            }
        } catch (Exception ex) {
            log.debug(ex.getMessage());
            throw new Exception(ex.getMessage());

        }
    }

    @Override
    public Member GetMemberById(Long id) throws Exception {
        try {
            return session.load(Member.class, id);

        } catch (Exception ex) {
            log.debug(ex.getMessage());
            throw new Exception();
        }
    }

    @Override
    public Optional<Member> GetMemberById(String userid) throws Exception {
        try {
            val map = new HashMap<String, Object>();
            map.put("userid", userid);
            return Optional.ofNullable(session.queryForObject(Member.class, "MATCH (m:Member) where m.userid= $userid", map));
        } catch (Exception ex) {
            log.debug(ex.getMessage());
            throw new Exception();
        }
    }

    @Override
    public Optional<Member> AddAdress(Long member, Address address) throws Exception {
        try {
            val mem = this.session.load(Member.class, member);
            mem.getAddresses().add(address);
            session.save(mem);
            return Optional.ofNullable(mem);

        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex.getCause());
        }

    }

    @Override
    public Optional<Member> AddCreditPayment(Long member, Payment payment) throws Exception {
        try {
        val mem = this.session.load(Member.class, member);
        session.save(payment);
        mem.getPayments().add(payment);
        session.save(mem);
        return  Optional.ofNullable(mem);
        }catch (Exception ex) {
            log.debug(ex.getMessage());
            throw  new Exception(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<Member> AddChild(Long id, Child child) throws Exception {
        try {
            val mem = this.session.load(Member.class,id);
            mem.getChildren().add(child);
            session.save(mem);
            return  Optional.of(mem);
        } catch (Exception ex){
            log.debug(ex.getMessage());
            throw  new Exception(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<Member> Login(String username, String password) throws Exception {
        try {
            val map = new HashMap<String, Object>();

            map.put("memberUsername", username);
            map.put("password", password);
            val s =  this.session.query(Member.class, "optional Match (c:Club)-[ms:MEMBER_BELONGS_TO_CLUBS]-(m:Member {username:$memberUsername,password:$password})-[sr:MEMBER_HAS_SHOP]-(s:Shop) return m,c,ms,sr,s" , map);

           return Optional.of(s.iterator().next());
        }catch (Exception ex) {
            log.debug(ex.getMessage());
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<HasPaied> hasPaid(HasPaied hasPaied, Long memberid) throws Exception {
       try {
         val membner =   session.load(Member.class, memberid);

         hasPaied.addMember(membner);
         session.save(hasPaied);
         return  Optional.of(hasPaied);
       }catch (Exception ex){
           log.debug(ex.getMessage());
           throw  new Exception(ex.getMessage(), ex.getCause());
       }
    }



    @Override
    public Optional<HasPaied> updateHasPaid(Long paiedID, Boolean paid) throws Exception {
        try {
            val hasPaid = session.load(HasPaied.class, paiedID);
            hasPaid.setHasPaied(paid);
            return  Optional.of(hasPaid);
        }catch (Exception ex){
            log.debug(ex.getMessage());
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<CreditCard> addCreditCard(Long memberid, CreditCard creditCard) throws Exception {
       try {
           val member = this.session.load(Member.class, memberid);
           creditCard.addMember(member);
           this.session.save(creditCard);
           return Optional.of(creditCard);
       }catch (Exception ex){
           log.debug(ex.getMessage());
           throw new Exception(ex.getMessage(), ex.getCause());
       }

    }

    @Override
    public Optional<Set<CreditCard>> GetCreditCardByMemberId(Long memerid) throws Exception {
        try {
            val member= this.session.load(Member.class, memerid, 3);
            return Optional.of(member.getCreditCards());
        }catch (Exception ex){
            log.debug(ex.getMessage());
            throw new Exception(ex.getMessage(), ex.getCause());
        }
        }

    @Override
    public Optional<HasPaied> SetHasMemberPaid(HasPaied hasPaied, Long memberid) throws Exception {
    try {
        val member = this.session.load(Member.class, memberid);
        hasPaied.addMember(member);
        this.session.save(hasPaied);
        return Optional.of(hasPaied);
    } catch (Exception ex){
        log.debug(ex.getMessage());
        throw new Exception(ex.getMessage(), ex.getCause());
    }
    }

    @Override
    public Optional<BufferedOutputStream> streamVideo(String videolink, String type) throws Exception {
       try {
          return  Optional.of(null);
       } catch (Exception ex){
            throw  new Exception();
       }
    }


    @Override
    public Optional<Member> AddShop(Long memberid, Shop shop) throws Exception {
        try {
            val member = session.load(Member.class, memberid);
        shop.addMember(member);
        session.save(shop);
            return  Optional.of(member);
        } catch (Exception ex){
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }
}



