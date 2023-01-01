package me.jaromir.mcclicker.Listener;

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

public class CookieListener extends GUICommand implements Listener {

    private  int cookies = 0;

    private int upgrade = 0;

    private  int count = 1;
    public void addCookies(int amount) {
        count += amount;
    }
    public void removeCookies(int amount) {
        count -= amount;
    }
    public void upgradeCost(int cost) {
        count -= cost;
    }
    public void increaseCost(int amount) {
        upgrade += amount * 2;
    }

    @EventHandler
    public void onRightclick(PlayerInteractEvent e){
        Action action =  e.getAction();
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if(action.equals(Action.RIGHT_CLICK_BLOCK)){
            if(block.getType().equals(Material.HONEY_BLOCK)){
                player.sendMessage("right click");
                openNewGUI(player);
            }
        }
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equals(ChatColor.GOLD + "Cookie Clicker - Upgardes")){

            switch(e.getCurrentItem().getType()){
                if{cookies < }
                {
                    case SHEARS:
                        player.sendMessage("Clicking power increased by 2");
                        addCookies(2);
                        upgradeCost(25);

                        break;
                    case TOTEM_OF_UNDYING:
                        player.sendMessage("Clicking power increased by 15");
                        addCookies(15);
                        upgradeCost(100);
                        break;
                    case PISTON:
                        player.sendMessage("Clicking power increased by 50");
                        addCookies(400);
                        break;
                }
                else{
                    player.sendMessage("You can't afford this");
                }
            }
            e.setCancelled(true);
        }else;

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
            cookies -= upgrade;
            p.sendMessage("You now have " + cookies + " cookies!");
        }
    }

}

