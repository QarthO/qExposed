package gg.quartzdev.qexposed.papi;

import gg.quartzdev.qexposed.qExposed;
import gg.quartzdev.qexposed.util.PdcUtil;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
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
    public String onRequest(OfflinePlayer player, @NotNull String params){
        if(params.equalsIgnoreCase("murderer")){
            return (player == null || player.getPlayer() == null) ? null : "" + PdcUtil.isMurderer(plugin.murdererKey, player.getPlayer());
        }


        return null;
    }
}
