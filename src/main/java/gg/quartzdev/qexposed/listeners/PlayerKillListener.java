package gg.quartzdev.qexposed.listeners;

import gg.quartzdev.qexposed.qExposed;
import gg.quartzdev.qexposed.util.PdcUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerKillListener implements Listener {

    qExposed plugin;
    public PlayerKillListener(){
        this.plugin = qExposed.getInstance();
    }

    @EventHandler
    public void onPlayerKillPlayer(PlayerDeathEvent event){
        Player player = event.getPlayer();
        if(player.getKiller() == null) return;
        Player killer = player.getKiller();
        PdcUtil.makeMurderer(killer);
    }
}
