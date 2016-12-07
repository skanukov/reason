package com.github.skanukov.sparklet.core.lang;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Helpers for file handling.
 */
public final class Files {
    public static String readAllText(String path) throws IOException {
        Path settingFilePath = Paths.get(path);
        return new String(java.nio.file.Files.readAllBytes(settingFilePath), StandardCharsets.UTF_8);
    }
}
