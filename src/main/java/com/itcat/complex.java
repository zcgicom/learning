package com.itcat;

public class complex {
    //获取验证过的随机密码
    public static String  getRandomPassword(String password) {
        int len = password.length();
        while(len>=8){
            if (password.matches(".*[a-z]{1,}.*") && password.matches(".*[A-Z]{1,}.*") &&
                    password.matches(".*\\d{1,}.*") && password.matches(".*[~!_@#$%^&*\\.?]{1,}.*")) {
                return "OK";
            }else return "Irregular Password";
        }
        return "Irregular Password";
    }

    public static void main(String[] args) {
        String str = "passwof^sada12";
        System.out.println(getRandomPassword(str));
        System.out.println(valPaw(str));
    }

    public static boolean valPaw(String password){
        if (password.length() >= 8){
            if(password.matches(".*[a-z]{1,}.*")&&password.matches(".*[A-Z]{1,}.*")
                    &&password.matches(".*[0-9]{1,}.*")&&password.matches(".*[!*&^%$#\\.@?]{1,}.*")){
                return true;
            }
        }
        return false;
    }
}
