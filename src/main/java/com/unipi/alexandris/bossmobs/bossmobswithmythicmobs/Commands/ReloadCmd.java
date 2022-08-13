package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Commands;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.BossMobsWithMythicMobs;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.ConfigHandler;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

public class ReloadCmd implements SubCommand{

    private final BossMobsWithMythicMobs plugin;

    public ReloadCmd(BossMobsWithMythicMobs plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        plugin.config = new ConfigHandler(plugin);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return Collections.emptyList();
    }

    @Override
    public String getUsage() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reloads the config.yml for the plugin.";
    }
}
