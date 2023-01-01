package me.jaromir.mcclicker.Cookie;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Upgrades implements Listener {

    public  int cookies = 0;
    public int costShears = 24;
    public int costTotem = 99;
    public int costFactory = 649;

    public  int count = 1;
    public void addCookies(int amount) {
        count += amount;
    }

    public void UpgradeShears(int amount) {
        cookies -= costShears;
        costShears += amount * 3.5;
    }
    public void UpgradeTotem(int amount) {
        cookies -= costTotem;
        costTotem += amount * 3.5;
    }
    public void UpgradeFactory(int amount) {
        cookies -= costFactory;
        costFactory += amount * 3.5;
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equals(ChatColor.GOLD + "Cookie Clicker - Upgardes")){
            switch(e.getCurrentItem().getType()){
                case SHEARS:
                    if(cookies > costShears) {
                        player.sendMessage("Clicking power increased by 2");
                        addCookies(2);
                        UpgradeShears(25);
                        player.sendMessage("sheers upgrade costs now " + costShears);

                        break;
                    }else{
                        player.sendMessage("You don't have enough cookies!");
                        break;
                    }
                case TOTEM_OF_UNDYING:
                    if(cookies > costTotem) {
                        player.sendMessage("Clicking power increased by 15");
                        addCookies(15);
                        UpgradeTotem(100);
                        break;
                    }else{
                        player.sendMessage("You dont have enough cookies!");
                        break;
                    }
                case PISTON:
                    if(cookies > costFactory) {
                    player.sendMessage("Clicking power increased by 50");
                    addCookies(100);
                    UpgradeFactory(650);
                    break;
                }else{
                        player.sendMessage("You don't have enough cookies!");
                        break;
                }
            }
            e.setCancelled(true);
        }else;

    }
}
