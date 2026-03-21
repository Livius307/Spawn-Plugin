package org.livius.spawnPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.livius.spawnPlugin.commands.SetSpawnCommand;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
    }
}
