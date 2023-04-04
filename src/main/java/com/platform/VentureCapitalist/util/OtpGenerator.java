package com.platform.VentureCapitalist.util;

import java.util.Random;

public class OtpGenerator {

    private static final int OTP_LEN = 7;
//    private int ot=2182;
    public static String generateOTP() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < OTP_LEN; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
