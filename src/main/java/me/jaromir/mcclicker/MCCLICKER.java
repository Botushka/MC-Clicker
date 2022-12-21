package me.jaromir.mcclicker;

import me.jaromir.mcclicker.GUI.GUICommand;
import me.jaromir.mcclicker.Listener.CookieListener;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCCLICKER extends JavaPlugin implements Listener {

    /***
     * UNFININSHED
     * TODO:
     * -Make GUI commands work how they are supposed to
     * -Make the GUI more neat and add bit features
     * -Make right clicking honey block open the gui
     */

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("gui").setExecutor(new GUICommand());
        getServer().getPluginManager().registerEvents(new CookieListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     * -Default numbers for newcomers
     */

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!getConfig().contains("Players." + p.getUniqueId().toString())) {
            getConfig().set("Players." + p.getUniqueId().toString() + ".cookies", 0);
            saveConfig();
        }
    }

    /**
     * -Cookie counter when hit
     */

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Block block = e.getBlock();
        Player p = e.getPlayer();
        String uuid = p.getUniqueId().toString();
        Material material = block.getType();
        if (material.equals(Material.HONEY_BLOCK)) {
            e.setCancelled(true);
            int cookies = getConfig().getInt("Players." + uuid + ".cookies");
            getConfig().set("Players." + uuid + ".cookies", cookies +1);
            saveConfig();
            p.sendMessage("You now have " + cookies + " cookies!");
        }
    }
}

