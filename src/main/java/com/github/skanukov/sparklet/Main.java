package com.github.skanukov.sparklet;

import com.github.skanukov.sparklet.config.AppRouter;
import com.github.skanukov.sparklet.core.config.Settings;

public class Main {
    public static void main(String[] args) {
        Settings settings = Settings.load();
        new AppRouter().route();
    }
}
