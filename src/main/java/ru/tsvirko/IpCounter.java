package ru.tsvirko;

import java.util.Scanner;

public class IpCounter {

    public static void main(String[] args) {
        System.out.println("Enter file path: \n");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        if (fileName == null) {
            System.out.println("Wrong file path. Try again.");
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
