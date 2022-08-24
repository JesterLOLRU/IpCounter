package ru.tsvirko.utils;

public class IpConverter {

    public static long ipToLong(String ipString) {
        String[] ip = ipString.split("\\.");
        return Long.parseLong(ip[0]) << 24 |
                Long.parseLong(ip[1]) << 16 |
                Long.parseLong(ip[2]) <<  8 |
                Long.parseLong(ip[3]);
    }
}
