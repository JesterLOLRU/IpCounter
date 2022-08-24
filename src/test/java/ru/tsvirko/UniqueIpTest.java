package ru.tsvirko;

import org.junit.jupiter.api.Test;
import ru.tsvirko.service.UniqueIp;
import ru.tsvirko.service.impl.UniqueIpImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueIpTest {

    @Test
    public void shouldCountIpsAndReturnTheirCount(){
        String fileName = "D:\\IpCounter\\src\\test\\java\\resources\\test_case1.txt";
        UniqueIp uniqueIp = new UniqueIpImpl();
        long res = uniqueIp.countUniqueIp(fileName);
        assertEquals(99206, res);
    }

    @Test
    public void shouldReturnZeroCuzWrongFilePath() {
        String fileName = "abrakadabra";
        UniqueIp uniqueIp = new UniqueIpImpl();
        long res = uniqueIp.countUniqueIp(fileName);
        assertEquals(0, res);
    }

    @Test
    public void shouldReturnZeroCuzIpValidationFailed() {
        String fileName = "D:\\IpCounter\\src\\test\\java\\resources\\test_case2.txt";
        UniqueIp uniqueIp = new UniqueIpImpl();
        long res = uniqueIp.countUniqueIp(fileName);
        assertEquals(0, res);
    }
}
