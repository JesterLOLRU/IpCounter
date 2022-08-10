package ru.tsvirko;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UniqueIpTest {

    @Test
    public void testCountIp1(){
        String fileName = "test_case1.txt";
        UniqueIp uniqueIp = new UniqueIpImpl();
        long res = uniqueIp.countUniqueIp(fileName);
        assertEquals(99206, res);
    }

    @Test
    public void testCountIp2(){
        String fileName = "test_case2.txt";
        UniqueIp uniqueIp = new UniqueIpImpl();
        long res = uniqueIp.countUniqueIp(fileName);
        assertEquals(999169, res);
    }

    @Test
    public void testCountIp3(){
        String fileName = "test_case3.txt";
        UniqueIp uniqueIp = new UniqueIpImpl();
        long res = uniqueIp.countUniqueIp(fileName);
        assertEquals(2997843, res);
    }

    @Test
    public void testCountIpWrongFileName(){
        String fileName = "blabla123.txt";
        UniqueIp uniqueIp = new UniqueIpImpl();
        long res = uniqueIp.countUniqueIp(fileName);
        assertEquals(-1, res);
    }

}
