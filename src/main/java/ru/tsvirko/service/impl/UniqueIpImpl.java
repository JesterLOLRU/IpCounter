package ru.tsvirko.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.tsvirko.service.UniqueIp;
import ru.tsvirko.utils.IpConverter;
import ru.tsvirko.utils.IpFileReader;
import ru.tsvirko.utils.IpValidator;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicLong;

public class UniqueIpImpl implements UniqueIp {
    private static final Logger logger = LogManager.getLogger();
    private final BitSet bitSetLow = new BitSet(Integer.MAX_VALUE);
    private final BitSet bitSetHigh = new BitSet(Integer.MAX_VALUE);
    private long count = 0;

    private void addLongValueOfIp(long bitStorage) {
        int intValue = (int) bitStorage;
        BitSet set = bitSetLow;
        if (bitStorage > Integer.MAX_VALUE) {
            intValue = (int) (bitStorage - Integer.MAX_VALUE);
            set = bitSetHigh;
        }

        if (!set.get(intValue)) {
            count++;
            set.set(intValue);
        }
    }

    @Override
    public long countUniqueIp(String fileName) {
        logger.info("Catching IP addresses from file {}", fileName);
        var fileStream = IpFileReader.getFileLines(fileName);
        if (fileStream != null) {
            AtomicLong executedLines = new AtomicLong();
            fileStream
                .takeWhile(s -> count <= COUNT_OF_IP_ADDRESSES)
                .forEach(s -> {
                    if (IpValidator.checkValidIp(s)) {
                        addLongValueOfIp(IpConverter.ipToLong(s));
                        executedLines.getAndIncrement();
                    }
                });
            logger.info( "Total lines in file: {} ", executedLines);
        }
        return count;
    }
}
