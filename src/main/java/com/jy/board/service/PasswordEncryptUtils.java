package com.jy.board.service;

import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Service
public class PasswordEncryptUtils implements PasswordUtils{

    @Override
    public String SHA256Encrypt(String plainText) {
        String sha256 = "";
        MessageDigest mdSHA256;

        {
            try {
                mdSHA256 = MessageDigest.getInstance("SHA-256");
                try {
                    mdSHA256.update(plainText.getBytes("UTF-8"));

                    byte[] sha256HASH = mdSHA256.digest();

                    StringBuffer hexSHA256HASH = new StringBuffer();
                    for(byte b : sha256HASH){
                        String hexString = String.format("%02x", b);
                        hexSHA256HASH.append(hexString);
                    }
                    sha256 = hexSHA256HASH.toString();

                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }

            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        return sha256;
    }

    }



