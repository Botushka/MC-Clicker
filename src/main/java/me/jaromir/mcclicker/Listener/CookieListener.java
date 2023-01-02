package me.jaromir.mcclicker.Listener;

import me.jaromir.mcclicker.Cookie.Sakila;
import me.jaromir.mcclicker.GUI.GUICommand;
import me.jaromir.mcclicker.MCCLICKER;
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


public class CookieListener extends GUICommand implements Listener {

    public CookieListener(MCCLICKER plugin) {
        this.plugin = plugin;
    }

    private final MCCLICKER plugin;


    public  static int cookies = 0;
    public static int costShears = 25;
    public static int costTotem = 100;
    public static int costFactory = 650;

    public static  int count = 1;
    private void addCookies(int amount) {
        count += amount;
    }

    private void UpgradeShears(int amount) {
        cookies -= costShears;
        costShears += amount * 3.5;
    }
    private void UpgradeTotem(int amount) {
        cookies -= costTotem;
        costTotem += amount * 3.5;
    }
    private void UpgradeFactory(int amount) {
        cookies -= costFactory;
        costFactory += amount * 3.5;
    }
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

    @EventHandler
    public void clickEvent(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equals(ChatColor.GOLD + "Cookie Clicker - Upgardes")){
            switch(e.getCurrentItem().getType()){
                case SHEARS:
                    if(cookies >= costShears) {
                        player.sendMessage("Clicking power increased by 2");
                        addCookies(2);
                        UpgradeShears(24);
                        player.sendMessage(ChatColor.GOLD + "sheers upgrade costs now " + ChatColor.YELLOW + costShears + ChatColor.GOLD + " cookies");
                        openNewGUI(player);
                        break;
                    }else{
                        player.sendMessage("You don't have enough cookies!");
                        break;
                    }
                case TOTEM_OF_UNDYING:
                    if(cookies >= costTotem) {
                        player.sendMessage("Clicking power increased by 15");
                        addCookies(15);
                        UpgradeTotem(100);
                        player.sendMessage(ChatColor.GOLD + "Factory upgrade costs now " + ChatColor.YELLOW + costTotem + ChatColor.GOLD + " cookies");
                        openNewGUI(player);
                        break;
                    }else{
                        player.sendMessage("You dont have enough cookies!");
                        break;
                    }
                case PISTON:
                    if(cookies >= costFactory) {
                        player.sendMessage("Clicking power increased by 50");
                        addCookies(100);
                        UpgradeFactory(649);
                        player.sendMessage(ChatColor.GOLD + "Factory upgrade costs now " + ChatColor.YELLOW + costFactory + ChatColor.GOLD + " cookies");
                        openNewGUI(player);
                        break;
                    }else{
                        player.sendMessage("You don't have enough cookies!");
                        break;
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
        Sakila stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());
        if(stats == null){
            stats = new MCCLICKER(p.getUniqueId().toString(), 0, 0);
        }
        Material material = block.getType();
        if (material.equals(Material.HONEY_BLOCK)) {
            e.setCancelled(true);
            cookies += count;
            p.sendMessage(ChatColor.GOLD + "You now have " + ChatColor.YELLOW + cookies + ChatColor.GOLD + " cookies!");
        }
    }

}

