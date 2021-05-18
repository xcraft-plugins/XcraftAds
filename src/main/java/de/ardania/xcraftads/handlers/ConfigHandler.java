package de.ardania.xcraftads.handlers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

import static de.ardania.xcraftads.XcraftAds.PLUGIN;

/**
 * Handler class for the default config of this plugin
 */
public class ConfigHandler {

    FileConfiguration config;

    public ConfigHandler() {
        PLUGIN.saveDefaultConfig();
        this.config = PLUGIN.getConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public int getCost() {
        return config.getInt("cost");
    }

    public int getInterval() {
        return config.getInt("interval");
    }

    public int getBroadcasts() {
        return config.getInt("broadcasts");
    }

    public String getOrder() {
        return config.getString("order");
    }
}
