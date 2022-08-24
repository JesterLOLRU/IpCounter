package ru.tsvirko;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.tsvirko.service.UniqueIp;
import ru.tsvirko.service.impl.UniqueIpImpl;

import java.util.Scanner;
import java.util.logging.Level;

public class IpCounter {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println("Enter file path: \n");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        if (fileName == null) {
            logger.warn("Wrong file path. Try again.");
            return;
        }

        UniqueIp counter = new UniqueIpImpl();
        long uniqueIp = counter.countUniqueIp(fileName);
        if (uniqueIp != -1) {
            System.out.println("Found " + uniqueIp + " unique IP.");
        } else {
            System.out.println("Error. Check logs.");
        }
    }
}
