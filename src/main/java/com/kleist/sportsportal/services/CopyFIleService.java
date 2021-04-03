package com.kleist.sportsportal.services;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Optional;
@Slf4j
public class CopyFIleService implements  ICopyFileService{
    @Override
    public Optional<Boolean> CopyPicture(File src, File dst) throws Exception {
        com.google.common.io.Files.copy(src, dst);
        return Optional.empty();
    }
}
