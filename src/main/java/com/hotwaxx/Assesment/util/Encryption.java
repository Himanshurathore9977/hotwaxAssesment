package com.hotwaxx.Assesment.util;

public class Encryption {


    private static String getDecryptedValue(String encrypt, int secret_key) {
        String decrypted = "";
        for(int i =0; i < encrypt.length();i++) {
            char ch = encrypt.charAt(i);
            ch -= secret_key;
            decrypted = decrypted + ch;
        }
        return decrypted;
    }

    private static String getEncryptedValue(String value, int secret_key) {
        String encrypt = "";
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            ch += secret_key;
            encrypt = encrypt + ch;
        }
        return encrypt;
    }

}
