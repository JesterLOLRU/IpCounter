package ru.tsvirko;

public interface UniqueIp {

    long COUNT_OF_IP_ADDRESSES = 256L * 256 * 256 * 256;

    /**
     * Method represents String value of IP address to Long .
     * @param ipString String with IP address.
     * @return Represented long value of IP address.
     */
    static long ipToLong(String ipString) {
        String[] ip = ipString.split("\\.");
        return Long.parseLong(ip[0]) << 24 |
                Long.parseLong(ip[1]) << 16 |
                Long.parseLong(ip[2]) <<  8 |
                Long.parseLong(ip[3]);
    }

    /**
     * Method count number of unique IP addresses from file.
     * @param fileName Name of file with IP addresses
     * @return Number of unique IP addresses in file.
     */
    long countUniqueIp(String fileName);
}
