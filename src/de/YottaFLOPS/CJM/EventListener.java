package de.YottaFLOPS.CJM;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

class EventListener implements Listener {
    private final Main plugin;

    EventListener(Main instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String opjoin = plugin.opjoin;
        String nmjoin = plugin.nmjoin;
        if (opjoin.contains("PLAYERCOUNT")) {
            opjoin = opjoin.replace("PLAYERCOUNT", String.valueOf(plugin.getServer().getOnlinePlayers().size()));
        }
        if (nmjoin.contains("PLAYERCOUNT")) {
            nmjoin = nmjoin.replace("PLAYERCOUNT", String.valueOf(plugin.getServer().getOnlinePlayers().size()));
        }
        if(opjoin.contains("PLAYER")) {
            opjoin = opjoin.replace("PLAYER", p.getDisplayName());
        }
        if(nmjoin.contains("PLAYER")) {
            nmjoin = nmjoin.replace("PLAYER", p.getDisplayName());
        }
        if (p.isOp()) {
            e.setJoinMessage(opjoin);
        } else {
            e.setJoinMessage(nmjoin);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        String opleave = plugin.opleave;
        String nmleave = plugin.nmleave;
        if (opleave.contains("PLAYERCOUNT")) {
            opleave = opleave.replace("PLAYERCOUNT", String.valueOf(plugin.getServer().getOnlinePlayers().size()));
        }
        if (nmleave.contains("PLAYERCOUNT")) {
            nmleave = nmleave.replace("PLAYERCOUNT", String.valueOf(plugin.getServer().getOnlinePlayers().size()));
        }
        if(opleave.contains("PLAYER")) {
            opleave = opleave.replace("PLAYER", p.getDisplayName());
        }
        if(nmleave.contains("PLAYER")) {
            nmleave = nmleave.replace("PLAYER", p.getDisplayName());
        }
        if (p.isOp()) {
            e.setQuitMessage(opleave);
        } else {
            e.setQuitMessage(nmleave);
        }
    }
}