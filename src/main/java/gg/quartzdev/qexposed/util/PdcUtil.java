package gg.quartzdev.qexposed.util;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PdcUtil {

    public static void makeMurderer(NamespacedKey murdererKey, Player player){
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(murdererKey, PersistentDataType.BOOLEAN, true);
    }

    public static boolean isMurderer(NamespacedKey murdererKey, Player player){
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        Boolean isMurderer = pdc.get(murdererKey, PersistentDataType.BOOLEAN);
        return (isMurderer != null && isMurderer) ? true : false;
    }




}
