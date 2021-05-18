package de.ardania.xcraftads.commands;

import de.ardania.xcraftads.handlers.TaskHandler;
import de.ardania.xcraftads.persistence.Ad;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

import static de.ardania.xcraftads.handlers.MessageHandler.MESSAGE;

public class ListCommand {

    public void listAds(Player player) {
        List<Ad> adList = TaskHandler.loadJson().stream()
                                  .filter(ad -> ad.getUuid().equals(player.getUniqueId()))
                                  .collect(Collectors.toList());

        if (!adList.isEmpty()) {
            player.sendMessage(MESSAGE.getString("PLUGIN_PREFIX") + MESSAGE.getString("LIST_TITLE"));
            adList.forEach(ad -> {
                player.sendMessage(MESSAGE.getString("LIST_AD_MESSAGE").replace("{MESSAGE}", ad.getMessage()));
                player.sendMessage(MESSAGE.getString("LIST_AD_BROADCASTS").replace("{BROADCASTS}", Integer.toString(ad.getBroadcasts())));
            });
        } else {
            player.sendMessage(MESSAGE.getString("PLUGIN_PREFIX") + MESSAGE.getString("LIST_NO_ADS"));
        }
    }
}
