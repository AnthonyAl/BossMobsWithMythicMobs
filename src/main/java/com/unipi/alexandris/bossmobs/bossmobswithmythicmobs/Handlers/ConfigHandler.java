package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.BossMobsWithMythicMobs;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core.Config;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public final class ConfigHandler {

    private final BossMobsWithMythicMobs plugin;
    private final Config config = new Config();
    private final FileConfiguration fileConfiguration;

    public ConfigHandler(BossMobsWithMythicMobs plugin) {
        this.plugin = plugin;
        fileConfiguration = plugin.getConfig();

        config.setRadius_min(fileConfiguration.getInt("radius.min"));
        config.setRadius_max(fileConfiguration.getInt("radius.max"));
        config.setLevel_common_min(fileConfiguration.getInt("level_range.common.min"));
        config.setLevel_common_max(fileConfiguration.getInt("level_range.common.max"));
        config.setLevel_rare_min(fileConfiguration.getInt("level_range.rare.min"));
        config.setLevel_rare_max(fileConfiguration.getInt("level_range.rare.max"));
        config.setLevel_legendary_min(fileConfiguration.getInt("level_range.legendary.min"));
        config.setLevel_legendary_max(fileConfiguration.getInt("level_range.legendary.max"));
        config.setProb_common(fileConfiguration.getInt("probabilities.common"));
        config.setProb_rare(fileConfiguration.getInt("probabilities.rare"));
        config.setProb_legendary(fileConfiguration.getInt("probabilities.legendary"));

        for(EntityType type : EntityType.values()) {
            String path = "mobs.";
            if(!fileConfiguration.contains(path += type.toString().toLowerCase())) continue;
            List<String>[] mobs = new List[3];
            mobs[0] = (List<String>) fileConfiguration.getList(path+".common");
            mobs[1] = (List<String>) fileConfiguration.getList(path+".rare");
            mobs[2] = (List<String>) fileConfiguration.getList(path+".legendary");
            config.put_to_map(type, mobs);
        }
    }

    public void readConfig() {
        getLogger().info(config.getLevel_common_min() + ".");
        getLogger().info(config.getLevel_common_max() + ".");
        getLogger().info(config.getLevel_rare_min() + ".");
        getLogger().info(config.getLevel_rare_max() + ".");
        getLogger().info(config.getLevel_legendary_min() + ".");
        getLogger().info(config.getLevel_legendary_max() + ".");
        getLogger().info(config.getRadius_min() + ".");
        getLogger().info(config.getRadius_max() + ".");
        getLogger().info(config.getProb_common() + ".");
        getLogger().info(config.getProb_rare() + ".");
        getLogger().info(config.getProb_legendary() + ".");
        getLogger().info(config.get_mobs(EntityType.SKELETON, 0) + ".");
        getLogger().info(config.get_mobs(EntityType.SKELETON, 1) + ".");
        getLogger().info(config.get_mobs(EntityType.SKELETON, 2) + ".");
    }

    public boolean contains(EntityType key) {
        return config.contains(key);
    }

    public List<String> get_mobs(EntityType key, int rarity) {
        return config.get_mobs(key, rarity);
    }

    public int getRadius_min() {
        return config.getRadius_min();
    }

    public int getRadius_max() {
        return config.getRadius_max();
    }

    public int getLevel_common_min() {
        return config.getLevel_common_min();
    }

    public int getLevel_common_max() {
        return config.getLevel_common_max();
    }

    public int getLevel_rare_min() {
        return config.getLevel_rare_min();
    }

    public int getLevel_rare_max() {
        return config.getLevel_rare_max();
    }

    public int getLevel_legendary_min() {
        return config.getLevel_legendary_min();
    }

    public int getLevel_legendary_max() {
        return config.getLevel_legendary_max();
    }

    public int getProb_common() {
        return config.getProb_common();
    }

    public int getProb_rare() {
        return config.getProb_rare();
    }

    public int getProb_legendary() {
        return config.getProb_legendary();
    }

}
