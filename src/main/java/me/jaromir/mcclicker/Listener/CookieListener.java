package me.jaromir.mcclicker.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class CookieListener implements Listener {

    @EventHandler
    public void onRightclick(PlayerInteractEvent e){
        Action action =  e.getAction();
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if(action.equals(Action.RIGHT_CLICK_BLOCK)){
            if(block.getType().equals(Material.HONEY_BLOCK)){

            }
        }
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equals(ChatColor.GOLD + "Cookie Clicker GUI")){

            switch(e.getCurrentItem().getType()){
                case SHEARS:
                    player.closeInventory();
                    player.sendMessage("Clicking power increased by 2");
                    break;
                case TOTEM_OF_UNDYING:
                    player.closeInventory();
                    player.sendMessage("Clicking power increased by 15");
                    break;
                case PISTON:
                    player.closeInventory();
                    player.sendMessage("Clicking power increased by 50");
                    break;
            }
            e.setCancelled(true);
        }else;

    }
}