package gg.quartzdev.qexposed;

import gg.quartzdev.qexposed.listeners.PlayerKillListener;
import gg.quartzdev.qexposed.papi.ExposedExpansion;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class qExposed extends JavaPlugin {

    static qExposed instance;

    public NamespacedKey murdererKey;

    public static qExposed getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.murdererKey = new NamespacedKey(instance, "murderer");

        registerEventHandlers();
        hookPAPI();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void hookPAPI(){
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null){
            this.getLogger().info("Install PlaceholderAPI if you'd like to use the provided placeholders");
            return;
        }
        this.getLogger().info("PAPI found, registering placeholders...");
        new ExposedExpansion().register();

    }

    public void registerEventHandlers(){
        Bukkit.getPluginManager().registerEvents(new PlayerKillListener(), this);
    }
}
