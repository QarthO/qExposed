package gg.quartzdev.qexposed.listeners;

import gg.quartzdev.qexposed.qExposed;
import gg.quartzdev.qexposed.MurderManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    qExposed plugin;
    MurderManager murderManager;
    public PlayerListener(){
        this.plugin = qExposed.getInstance();
        this.murderManager = this.plugin.murderManager;
    }

    @EventHandler
    public void onPlayerKillPlayer(PlayerDeathEvent event){
        Player player = event.getPlayer();
        if(player.getKiller() == null) return;
        Player killer = player.getKiller();
        murderManager.make(killer);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!murderManager.is(player)) return;

    }
}
