package ru.tsvirko.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class IpFileReader {
    private static final Logger logger = LogManager.getLogger();

    public static Stream<String> getFileLines(String filename) {
        try {
            return Files.lines(Path.of(filename));
        } catch (IOException ioe) {
            logger.error("File with name {} not found", filename);
        }
            return null;
    }
}
