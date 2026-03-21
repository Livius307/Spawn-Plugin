package org.livius.spawnPlugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.livius.spawnPlugin.SpawnPlugin;

public class SetSpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SetSpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {

            Location location = p.getLocation();

            plugin.getConfig().set("spawn", location);

            plugin.saveConfig();

            p.sendMessage("Spawn location set");
        } else {
            System.out.println("bro what yo tryna do?");
        }
        return true;
    }
}
