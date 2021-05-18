package de.ardania.xcraftads.handlers;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static de.ardania.xcraftads.XcraftAds.PLUGIN;

public class MessageHandler {
    public static FileConfiguration MESSAGE;

    public MessageHandler() {
        createCustomConfig();
    }

    /**
     * @return the messages.yml file with messages of this plugin
     */
    private File createCustomConfig() {
        File file = new File(PLUGIN.getDataFolder(), "messages.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            PLUGIN.saveResource("messages.yml", false);
        }

        MESSAGE = new YamlConfiguration();
        try {
            MESSAGE.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return file;
    }
}
