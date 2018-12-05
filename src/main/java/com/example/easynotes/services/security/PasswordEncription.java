package com.example.easynotes.services.security;

import java.util.concurrent.ThreadLocalRandom;

public class PasswordEncription {

    private char[] password;

    private int key;

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public void setKey(){
        this.key = generateRandomInt(1, 255);
    }

    public int getKey(){
        return key;
    }
    public String encript(char[] pass){
        StringBuilder encriptedPass = null;
        int[] numericPass = new int[pass.length];
        for (int i=0; i< pass.length; i++){
            numericPass[i] = pass[i] + key;
            encriptedPass.append(Character.toString((char)numericPass[i]));
        }
        return encriptedPass.toString();
    }

    public String decript(String pass){

        int length = pass.length();
        StringBuilder decriptedPass = null;
        int[] intPass = new int[length];
        for (int i=0; i<length; i++){
            intPass[i] = (int) pass.charAt(i) - key;
            decriptedPass.append(Character.toString((char) intPass[i]));
        }
        return decriptedPass.toString();
    }

    private static int generateRandomInt(int min, int max){
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }
}
