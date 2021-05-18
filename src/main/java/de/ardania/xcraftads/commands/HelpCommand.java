package de.ardania.xcraftads.commands;

import org.bukkit.entity.Player;

import static de.ardania.xcraftads.XcraftAds.CONFIGHANDLER;
import static de.ardania.xcraftads.XcraftAds.PLUGIN;
import static de.ardania.xcraftads.handlers.MessageHandler.MESSAGE;

public class HelpCommand {
    public void pluginInfo(Player player) {
        player.sendMessage(MESSAGE.getString("PLUGIN_PREFIX") +
                                   "§7" +
                                   PLUGIN.getDescription().getVersion() +
                                   " §2by §6§n" +
                                   PLUGIN.getDescription().getAuthors().get(0));

        player.sendMessage(MESSAGE.getString("HELP_HELP_TEXT"));

        player.sendMessage(MESSAGE.getString("HELP_CREATE_TEXT")
                                   .replace("{COST}", Integer.toString(CONFIGHANDLER.getCost()))
                                   .replace("{CURRENCY}", MESSAGE.getString("CURRENCY")));

        player.sendMessage(MESSAGE.getString("HELP_LIST_TEXT"));
    }
}
