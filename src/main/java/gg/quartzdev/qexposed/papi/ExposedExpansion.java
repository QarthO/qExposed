package gg.quartzdev.qexposed.papi;

import gg.quartzdev.qexposed.qExposed;
import gg.quartzdev.qexposed.util.PdcUtil;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ExposedExpansion extends PlaceholderExpansion {

    private final qExposed plugin;

    public ExposedExpansion(){
        this.plugin = qExposed.getInstance();
    }

    @Override
    public @NotNull String getIdentifier() {
        return "qexposed";
    }

    @Override
    public @NotNull String getAuthor() {
        return "quartzdev.gg";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer offlinePlayer, @NotNull String params){
        if(offlinePlayer == null || offlinePlayer.getPlayer() == null) return null;
        Player player = offlinePlayer.getPlayer();
        if(params.equalsIgnoreCase("murderer")){
            return "" + PdcUtil.isMurderer(player);
        }
        if(params.equalsIgnoreCase("duration")){
            long durationAsMurder = PdcUtil.getDuration(player);
            return durationAsMurder == -1 ? "null" : "" + PdcUtil.getDuration(player);
        }
        return null;
    }
}
