package com.kleist.sportsportal.services;

import com.kleist.sportsportal.entites.Score;

import java.util.Optional;

public interface IScoreService {
    public Optional<Score> addScore(Long memberId, Long activity, Score score) throws  Exception;
}
