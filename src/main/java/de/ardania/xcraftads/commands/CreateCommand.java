package de.ardania.xcraftads.commands;

import de.ardania.xcraftads.handlers.TaskHandler;
import de.ardania.xcraftads.persistence.Ad;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.ardania.xcraftads.XcraftAds.CONFIGHANDLER;
import static de.ardania.xcraftads.handlers.MessageHandler.MESSAGE;
import static de.ardania.xcraftads.utils.Registry.ECONOMY;

public class CreateCommand {

    public void createAd(Player player, String[] message) {
        if (ECONOMY.has(player, CONFIGHANDLER.getCost())) {
            List<String> messageList = new ArrayList<>(Arrays.asList(message));
            messageList.remove(0);

            StringBuffer stringBuffer = new StringBuffer();

            for (int i = 0; i < messageList.size(); i++) {
                if (i < messageList.size() - 1) {
                    stringBuffer.append(messageList.get(i));
                    stringBuffer.append(" ");
                } else {
                    stringBuffer.append(messageList.get(i));
                }
            }

            Ad ad = new Ad();
            ad.setMessage(ChatColor.translateAlternateColorCodes('&', stringBuffer.toString()));
            ad.setBroadcasts(CONFIGHANDLER.getBroadcasts());
            ad.setUuid(player.getUniqueId());

            List<Ad> adList = TaskHandler.loadJson();
            adList.add(ad);

            TaskHandler.saveJson(adList);
            ECONOMY.withdrawPlayer(player, CONFIGHANDLER.getCost());
            player.sendMessage(MESSAGE.getString("PLUGIN_PREFIX") +
                                       MESSAGE.getString("CREATE_CREATED_TEXT")
                                               .replace("{MESSAGE}", ad.getMessage())
                                               .replace("{BROADCASTS}", Integer.toString(ad.getBroadcasts())));
        } else {
            player.sendMessage(MESSAGE.getString("PLUGIN_PREFIX") + MESSAGE.getString("CREATE_NOT_ENOUGH_MONEY"));
        }
    }
}
