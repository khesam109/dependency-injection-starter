package com.khesam.inject.hello.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    private final MessageDigest messageDigest;

    public HashUtil() throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance("SHA-256");;
    }

    public String doHash(String toHash) {
        messageDigest.update(toHash.getBytes());
        return new String(messageDigest.digest());
    }
}
