package org.livius.spawnPlugin.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.livius.spawnPlugin.SpawnPlugin;

public class SpawnListener implements Listener {

    private final SpawnPlugin plugin;

    public SpawnListener(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("spawn");
            if (plugin.getConfig().getLocation("spawn") != null){
                p.teleport(location);
            }
        }

    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        Location location = plugin.getConfig().getLocation("spawn");
        if (location != null) {
            e.setRespawnLocation(location);
        }
    }
}
