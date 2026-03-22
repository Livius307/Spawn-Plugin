package org.livius.spawnPlugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.livius.spawnPlugin.SpawnPlugin;

public class SpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p){
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {
                p.teleport(location);
                p.sendMessage("Teleported to spawn successfully!");
            }else {
                p.sendMessage("You need to set your spawnpoint first!");
                p.sendMessage("Do this with /setspawn!");
            }
        }else{
            System.out.println("bro what yo tryna do?");
        }
        return true;
    }
}
