package ru.tsvirko.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpValidator {

    public static boolean checkValidIp(String ip) {
        Pattern pattern = Pattern.compile("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$");
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
