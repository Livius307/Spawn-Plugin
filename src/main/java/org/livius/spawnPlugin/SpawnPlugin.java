package org.livius.spawnPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.livius.spawnPlugin.commands.SetSpawnCommand;
import org.livius.spawnPlugin.commands.SpawnCommand;
import org.livius.spawnPlugin.listeners.SpawnListener;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getServer().getPluginManager().registerEvents(new SpawnListener(this), this);
    }
}
