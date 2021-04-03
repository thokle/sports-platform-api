package com.kleist.sportsportal.services;

import java.io.File;
import java.util.Optional;

public interface ICopyFileService {
public Optional<Boolean> CopyPicture(File src, File dst) throws  Exception;
}
