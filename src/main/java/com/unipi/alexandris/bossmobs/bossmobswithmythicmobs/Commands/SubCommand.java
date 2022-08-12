package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Commands;


import org.bukkit.command.CommandSender;

import java.util.List;

public interface SubCommand {

    boolean onCommand(CommandSender sender, String[] args);

    List<String> onTabComplete(CommandSender sender, String[] args);

    String getUsage();

    String getDescription();

    default boolean inGameOnly() {
        return false;
    }
}
