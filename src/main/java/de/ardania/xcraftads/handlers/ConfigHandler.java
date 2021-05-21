package de.ardania.xcraftads.handlers;

import de.ardania.xcraftads.persistence.Order;
import org.bukkit.configuration.file.FileConfiguration;

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

    public int getBroadcastCount() {
        return config.getInt("broadcastCount");
    }

    public Order getOrder() {
        return Order.fromString(config.getString("order"));
    }
}
