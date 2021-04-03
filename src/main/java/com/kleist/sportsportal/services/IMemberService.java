package com.kleist.sportsportal.services;

import com.kleist.sportsportal.entites.*;
import ratpack.exec.Promise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;

public interface IMemberService {

   void CreateMember(Member member) throws Exception;
   Member GetMemberById(Long entity) throws Exception;
   Optional<Member> GetMemberById(String userid) throws Exception;
    Optional<Member> AddAdress(Long member, Address address) throws Exception;
   Optional<Member> AddCreditPayment(Long id, Payment payment) throws Exception;
    Optional<Member> AddChild(Long Id, Child child) throws Exception;
  Optional<Member> Login(String username, String password) throws  Exception;
  Optional<HasPaied> hasPaid(HasPaied hasPaied, Long memberid) throws  Exception;
  Optional<HasPaied> updateHasPaid(Long paiedID, Boolean paid) throws  Exception;
  Optional<CreditCard> addCreditCard(Long memberid, CreditCard creditCard) throws  Exception;
  Optional<Set<CreditCard>> GetCreditCardByMemberId(Long memerid) throws  Exception;
  Optional<HasPaied> SetHasMemberPaid(HasPaied hasPaied, Long memberid) throws  Exception;
  Optional<Member> AddShop(Long memberid , Shop Shop) throws  Exception;
  Optional<BufferedOutputStream> streamVideo(String videolink, String type) throws Exception;
}
