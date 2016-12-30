package com.github.skanukov.reason.core.lang;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Helpers for file handling.
 */
public final class FileUtils {
    public static String readAllText(String path) throws IOException {
        Path settingFilePath = Paths.get(path);
        return new String(Files.readAllBytes(settingFilePath), StandardCharsets.UTF_8);
    }
}
