package de.ardania.xcraftads;

import de.ardania.xcraftads.commands.CommandHandler;
import de.ardania.xcraftads.handlers.ConfigHandler;
import de.ardania.xcraftads.handlers.MessageHandler;
import de.ardania.xcraftads.handlers.SchedulerHandler;
import de.ardania.xcraftads.handlers.TaskHandler;
import org.bukkit.plugin.java.JavaPlugin;

import static de.ardania.xcraftads.utils.Registry.LOGGER;
import static de.ardania.xcraftads.utils.Registry.initVault;

public class XcraftAds extends JavaPlugin {

    public static JavaPlugin PLUGIN;
    public static ConfigHandler CONFIGHANDLER;

    public CommandHandler commandHandler;
    public MessageHandler messageHandler;
    public SchedulerHandler schedulerHandler;

    @Override
    public void onEnable() {
        //Initialization
        PLUGIN = this;
        commandHandler = new CommandHandler();
        messageHandler = new MessageHandler();
        schedulerHandler = new SchedulerHandler();
        CONFIGHANDLER = new ConfigHandler();
        LOGGER = getLogger();
        initVault(getServer().getPluginManager(), getServer().getServicesManager());
        TaskHandler.initFile();

        //Commands & Listeners
        getCommand("ads").setExecutor(commandHandler);

        //starting scheduler
        schedulerHandler.startScheduler();
    }

    @Override
    public void onDisable() {

    }
}
