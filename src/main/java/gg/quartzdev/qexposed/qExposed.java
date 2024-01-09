package gg.quartzdev.qexposed;

import gg.quartzdev.qexposed.listeners.PlayerListener;
import gg.quartzdev.qexposed.papi.ExposedExpansion;
import gg.quartzdev.qexposed.storage.Confiq;
import gg.quartzdev.qexposed.util.Loqqer;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;

public final class qExposed extends JavaPlugin {

    private static qExposed instance;
    public Loqqer logger;
    public Confiq config;
    public MurderManager murderManager;

    public static qExposed getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.logger = new Loqqer();
        this.config = new Confiq();
        this.murderManager = new MurderManager();

        enableMetrics();
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

    public void enableMetrics(){
        int pluginId = 20694;
        Metrics metrics = new Metrics(this, pluginId);
    }

    public void registerEventHandlers(){
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @SuppressWarnings("UnstableApiUsage")
    public String getVersion(){
        return instance.getPluginMeta().getVersion();
    }
}
