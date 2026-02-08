package org.example.util;

import net.datafaker.Faker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public class TestUtil {

    public static final Faker DATA_FAKER = new Faker();
    public static final String SPLITTER = ",";
    public static final String LARGE_ARRAY_DATA_FILE = "large_array.txt";

    public static List<String> processFile(String filePath) {
        Path path = getPath(filePath);

        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            return lines
                    .filter(line -> !line.trim().isEmpty())
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Path getPath(String filePath) {
        try {
            URL resourceUrl = TestUtil.class.getClassLoader().getResource(filePath);
            return Paths.get(requireNonNull(resourceUrl).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}