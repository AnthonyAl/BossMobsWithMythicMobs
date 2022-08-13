package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.BossMobsWithMythicMobs;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core.Config;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

import java.util.List;

@SuppressWarnings("unused")
public final class ConfigHandler {

    private final Config config = new Config();

    public ConfigHandler(BossMobsWithMythicMobs plugin) {
        FileConfiguration fileConfiguration = plugin.getConfig();

        config.setPlayer_kill_only(fileConfiguration.getBoolean("player_kill_only"));
        config.setEmpty_space_spawn(fileConfiguration.getInt("empty_space_spawn"));
        config.setRadius_min(fileConfiguration.getInt("radius.min"));
        config.setRadius_max(fileConfiguration.getInt("radius.max"));
        config.setLevel_common_min(fileConfiguration.getInt("level_range.common.min"));
        config.setLevel_common_max(fileConfiguration.getInt("level_range.common.max"));
        config.setLevel_rare_min(fileConfiguration.getInt("level_range.rare.min"));
        config.setLevel_rare_max(fileConfiguration.getInt("level_range.rare.max"));
        config.setLevel_legendary_min(fileConfiguration.getInt("level_range.legendary.min"));
        config.setLevel_legendary_max(fileConfiguration.getInt("level_range.legendary.max"));
        config.setProb_common(fileConfiguration.getDouble("probabilities.common"));
        config.setProb_rare(fileConfiguration.getDouble("probabilities.rare"));
        config.setProb_legendary(fileConfiguration.getDouble("probabilities.legendary"));

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

    public boolean contains(EntityType key) {
        return config.contains(key);
    }

    public List<String> get_mobs(EntityType key, int rarity) {
        return config.get_mobs(key, rarity);
    }


    public boolean isPlayer_kill_only() {
        return config.isPlayer_kill_only();
    }

    public int getEmpty_space_spawn() {
        return config.getEmpty_space_spawn();
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

    public double getProb_common() {
        return config.getProb_common();
    }

    public double getProb_rare() {
        return config.getProb_rare();
    }

    public double getProb_legendary() {
        return config.getProb_legendary();
    }

}
