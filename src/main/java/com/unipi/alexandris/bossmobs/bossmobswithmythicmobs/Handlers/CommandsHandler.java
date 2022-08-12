package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.BossMobsWithMythicMobs;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Commands.HelpCmd;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Commands.SubCommand;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class CommandsHandler implements TabExecutor {

    private final BossMobsWithMythicMobs plugin;

    private final HashMap<String, SubCommand> commands = new HashMap<>();

    public CommandsHandler(BossMobsWithMythicMobs plugin) {
        this.plugin = plugin;
        commands.put("help", new HelpCmd(this));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.AQUA + "Wave Mini Game" + ChatColor.GRAY + " is a plugin that uses Mythic Mobs, Corpse Reborn and other, " +
                    "designed by Antitonius to implement a CoD-like Mini Game for theNRK Minecraft server. To check the help page, type "
                    + ChatColor.YELLOW + "/zombies help" + ChatColor.GRAY + ".");
            return true;
        }

        SubCommand command = commands.get(args[0].toLowerCase());

        if (command == null) {
            sender.sendMessage(ChatColor.RED + "Unknown command. To check out the help page, type " + ChatColor.GRAY + "/zombies help" + ChatColor.RED + ".");
            return true;
        }

        if (command.inGameOnly() && !(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Console cannot run this command.");
            return true;
        }

        String[] subCmdArgs = new String[args.length - 1];
        System.arraycopy(args, 1, subCmdArgs, 0, subCmdArgs.length);

        if (!command.onCommand(sender, subCmdArgs)) {
            sender.sendMessage(ChatColor.RED + "Command usage: /zombies " + ChatColor.GRAY + command.getUsage() + ChatColor.RED + ".");
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }

    public BossMobsWithMythicMobs getPlugin() {
        return plugin;
    }

    public Collection<SubCommand> getCommands() {
        return commands.values();
    }
}
