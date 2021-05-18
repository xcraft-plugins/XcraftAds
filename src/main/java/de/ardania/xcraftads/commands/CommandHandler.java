package de.ardania.xcraftads.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static de.ardania.xcraftads.handlers.MessageHandler.MESSAGE;

public class CommandHandler implements CommandExecutor, TabCompleter {

    HelpCommand helpCommand;
    CreateCommand createCommand;
    ListCommand listCommand;

    public CommandHandler() {
        helpCommand = new HelpCommand();
        createCommand = new CreateCommand();
        listCommand = new ListCommand();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        Player player = commandSender instanceof Player ? (Player) commandSender : null;

        if (player != null) {
            if (args.length < 1 || args[0].equals("help")) {
                if (player.hasPermission("xcraftads.help")) {
                    helpCommand.pluginInfo(player);
                } else {
                    player.sendMessage(MESSAGE.getString("PLUGIN_PREFIX") + MESSAGE.getString("NO_PERMISSIONS"));
                }
            } else if (args[0].equals("create")) {
                if (player.hasPermission("xcraftads.create")) {
                    createCommand.createAd(player, args);
                } else {
                    player.sendMessage(MESSAGE.getString("PLUGIN_PREFIX") + MESSAGE.getString("NO_PERMISSIONS"));
                }
            } else if (args[0].equals("list")) {
                if (player.hasPermission("xcraftads.list")) {
                    listCommand.listAds(player);
                } else {
                    player.sendMessage(MESSAGE.getString("PLUGIN_PREFIX") + MESSAGE.getString("NO_PERMISSIONS"));
                }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        Player player;
        if (sender instanceof Player) {
            player = (Player) sender;
            if (args.length == 1) {
                if (player.hasPermission("xcraftads.help")) {
                    completions.add("help");
                }
                if (player.hasPermission("xcraftads.create")) {
                    completions.add("create");
                }
                if (player.hasPermission("xcraftads.list")) {
                    completions.add("list");
                }
                return completions;
            } else if (args.length == 2 && args[0].equals("create") && player.hasPermission("xcraftads.create")) {
                completions.add("<Nachricht>");
                return completions;
            }
        }
        return completions;
    }
}
