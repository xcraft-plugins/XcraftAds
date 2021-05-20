package de.ardania.xcraftads.handlers;

import de.ardania.xcraftads.persistence.Ad;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import static de.ardania.xcraftads.XcraftAds.CONFIGHANDLER;
import static de.ardania.xcraftads.XcraftAds.PLUGIN;
import static de.ardania.xcraftads.handlers.MessageHandler.MESSAGE;
import static de.ardania.xcraftads.persistence.Order.RANDOM;
import static de.ardania.xcraftads.persistence.Order.SORTED;
import static de.ardania.xcraftads.utils.Registry.LOGGER;

public class SchedulerHandler {

    private Random random = new Random();

    public void startScheduler() {
        PLUGIN.getServer().getScheduler().runTaskTimer(PLUGIN, () -> {
            List<Ad> adList = TaskHandler.loadJson();
            if (!adList.isEmpty()) {
                if (CONFIGHANDLER.getOrder().equals(RANDOM)) {
                    randomBroadcaster(adList);
                } else if (CONFIGHANDLER.getOrder().equals(SORTED)) {
                    sortedBroadcaster(adList);
                } else {
                    randomBroadcaster(adList);
                    LOGGER.log(Level.WARNING, MESSAGE.getString("ERROR_WRONG_ORDER_STRING"));
                }
            }
        }, (long) CONFIGHANDLER.getInterval() * 60 * 20, (long) CONFIGHANDLER.getInterval() * 60 * 20);
    }

    private void randomBroadcaster(List<Ad> adList) {
        int index = random.nextInt(adList.size());

        PLUGIN.getServer().broadcastMessage(adList.get(index).getMessage());

        checkBroadcastsLeft(adList, index);
        TaskHandler.saveJson(adList);
    }

    private void sortedBroadcaster(List<Ad> adList) {
        adList.sort(Comparator.comparingInt(Ad::getBroadcasts));

        PLUGIN.getServer().broadcastMessage(adList.get(0).getMessage());

        checkBroadcastsLeft(adList, 0);
        TaskHandler.saveJson(adList);
    }

    private void checkBroadcastsLeft(List<Ad> adList, int index) {
        if (adList.get(index).getBroadcasts() - 1 > 0) {
            adList.get(index).setBroadcasts(adList.get(index).getBroadcasts() - 1);
        } else {
            adList.remove(index);
        }
    }
}
