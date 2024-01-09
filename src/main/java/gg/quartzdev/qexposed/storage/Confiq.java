package gg.quartzdev.qexposed.storage;

import gg.quartzdev.qexposed.qExposed;
import gg.quartzdev.qexposed.util.Loqqer;
import org.bukkit.configuration.file.FileConfiguration;

public class Confiq {

    qExposed plugin;
    Loqqer logger;
    FileConfiguration file;

    public Confiq(){
        this.plugin = qExposed.getInstance();
        this.logger = plugin.logger;

        this.file = plugin.getConfig();
        this.plugin.saveDefaultConfig();

        this.loadAll();
    }

    private void save() {
        this.plugin.saveConfig();
    }

    public void reload() {
        this.plugin.reloadConfig();
        this.file = this.plugin.getConfig();
        this.save();
        this.loadAll();
    }
    private void loadAll() {
//        Config logic here
    }

}
