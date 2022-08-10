package ru.tsvirko;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UniqueIpImpl implements UniqueIp {

    private final Logger logger = Logger.getLogger("BitSetUniqueIpCounter");
    private final BitSet bitSetLow = new BitSet(Integer.MAX_VALUE);
    private final BitSet bitSetHigh = new BitSet(Integer.MAX_VALUE);
    private long count = 0;

    private void addLongValueOfIp(long longValue) {
        int intValue = (int) longValue;
        BitSet set = bitSetLow;
        if (longValue > Integer.MAX_VALUE) {
            intValue = (int) (longValue - Integer.MAX_VALUE);
            set = bitSetHigh;
        }

        if (!set.get(intValue)) {
            count++;
            set.set(intValue);
        }
    }

    @Override
    public long countUniqueIp(String fileName) {
        logger.log(Level.INFO, "Catching IP addresses from file : " + fileName);
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            long executedLines = 0;
            String line;
            while ((line = in.readLine()) != null
                    && count <= COUNT_OF_IP_ADDRESSES) {
                addLongValueOfIp(UniqueIp.ipToLong(line));
                executedLines++;
            }
            logger.log(Level.INFO, "Total lines in file: " + executedLines);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "File '" + fileName + "' not found", e);
            count = -1;
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException occurs", e);
            count = -1;
        }
        return count;
    }
}