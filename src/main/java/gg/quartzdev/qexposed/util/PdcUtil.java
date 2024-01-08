package gg.quartzdev.qexposed.util;

import gg.quartzdev.qexposed.qExposed;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Date;
import java.time.Instant;

public class PdcUtil {

    public static NamespacedKey murdererKey = qExposed.getInstance().murdererKey;
    public static long RESET_TIME = 60*60*24; // in seconds ( = 1 day

    public static void makeMurderer(Player player){
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        long now = Instant.now().getEpochSecond();
        pdc.set(murdererKey, PersistentDataType.LONG, now);
    }

    public static boolean isMurderer(Player player){
        long durationAsMurderer = getDuration(player);
        if( durationAsMurderer == -1) return false;
        return durationAsMurderer < RESET_TIME;
    }

    public static long getDuration(Player player){
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        if(!pdc.has(murdererKey, PersistentDataType.LONG)) return -1;
        Long timeOfMurder = pdc.get(murdererKey, PersistentDataType.LONG);
        if(timeOfMurder == null) return -1;
        return Instant.now().getEpochSecond() - timeOfMurder;
    }



}
