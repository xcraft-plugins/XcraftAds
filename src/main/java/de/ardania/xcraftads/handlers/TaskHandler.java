package de.ardania.xcraftads.handlers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.ardania.xcraftads.persistence.Ad;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static de.ardania.xcraftads.XcraftAds.PLUGIN;

public class TaskHandler {

    private static File file = new File(PLUGIN.getDataFolder(), "ads.json");

    public static void initFile() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            PLUGIN.saveResource("ads.json", false);
        }
    }

    public static void saveJson(List<Ad> adList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, adList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Ad> loadJson() {
        ObjectMapper mapper = new ObjectMapper();
        List<Ad> adList;
        try {
            adList = mapper.readValue(file, new TypeReference<List<Ad>>() {});
        } catch (IOException e) {
            adList = new ArrayList<>();
        }

        return adList;
    }

}
