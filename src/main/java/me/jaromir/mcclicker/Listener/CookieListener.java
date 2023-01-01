package me.jaromir.mcclicker.Listener;

import me.jaromir.mcclicker.Cookie.Upgrades;
import me.jaromir.mcclicker.GUI.GUICommand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

public class CookieListener extends GUICommand implements Listener {


    @EventHandler
    public void onRightclick(PlayerInteractEvent e){
        Action action =  e.getAction();
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if(action.equals(Action.RIGHT_CLICK_BLOCK)){
            if(block.getType().equals(Material.HONEY_BLOCK)){
                openNewGUI(player);
            }
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
            cookies += count;
            p.sendMessage("You now have " + cookies + " cookies!");
        }
    }

}

