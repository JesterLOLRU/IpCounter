package ru.tsvirko.service;

public interface UniqueIp {

    long COUNT_OF_IP_ADDRESSES = 256L * 256 * 256 * 256;

    /**
     * Method count number of unique IP addresses from file.
     * @param fileName Name of file with IP addresses
     * @return Number of unique IP addresses in file.
     */
    long countUniqueIp(String fileName);
}
