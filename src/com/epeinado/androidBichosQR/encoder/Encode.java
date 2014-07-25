package com.epeinado.androidBichosQR.encoder;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * User: Esther
 * Date: 02/02/14
 * Time: 00:35
 */
public class Encode {

    private final String CLAVE_ENCRYPT = "C'thulhu";

    public String encrypt(String cadena, String clave) {
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword(clave);
        return s.encrypt(cadena);
    }

    public String encrypt(String cadena) {
        return encrypt(cadena, CLAVE_ENCRYPT);
    }

    public String decrypt(String cadena, String clave) {
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword(clave);
        String devuelve = "";
        try {
            devuelve = s.decrypt(cadena);
        } catch (Exception e) {
        }
        return devuelve;
    }

    public String decrypt(String cadena) {
        return decrypt(cadena, CLAVE_ENCRYPT);
    }

    public String encryptURL(String cadena) {
        String encrypt = encrypt(cadena, CLAVE_ENCRYPT);
        String encode = "";
        try {
            encode = URLEncoder.encode(encrypt, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }

}
