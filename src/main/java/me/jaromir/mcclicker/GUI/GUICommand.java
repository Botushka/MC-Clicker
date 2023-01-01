package me.jaromir.mcclicker.GUI;

import me.jaromir.mcclicker.Cookie.Upgrades;
import me.jaromir.mcclicker.Listener.CookieListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class GUICommand extends Upgrades {

    private Inventory inv;


    public void openNewGUI(Player p) {
        inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Cookie Clicker - Upgardes");
        for (int slot = 0; slot < inv.getSize(); slot++) {
            inv.setItem(slot, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
        }
        ItemStack extraHand = new ItemStack(Material.SHEARS);
        ItemStack orphan = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemStack Factory = new ItemStack(Material.PISTON);
        ItemStack cookie = new ItemStack(Material.COOKIE);

        ItemMeta cookie_meta = cookie.getItemMeta();
        cookie_meta.setDisplayName(ChatColor.RED + "Extra Hand");
        ArrayList<String> cookie_lore = new ArrayList<>();
        cookie_lore.add(ChatColor.DARK_GREEN + "Your cookies: " + cookies);
        cookie_meta.setLore(cookie_lore);
        cookie.setItemMeta(cookie_meta);
        inv.setItem(4, cookie);

        ItemMeta extraHand_meta = extraHand.getItemMeta();
        extraHand_meta.setDisplayName(ChatColor.RED + "Extra Hand");
        ArrayList<String> extraHand_lore = new ArrayList<>();
        extraHand_lore.add(ChatColor.DARK_GREEN + "Increase cookie clicking power by 2");
        extraHand_lore.add(ChatColor.DARK_GREEN + "Upgrade costs: " + costShears);
        extraHand_meta.setLore(extraHand_lore);
        extraHand.setItemMeta(extraHand_meta);
        inv.setItem(10, extraHand);

        ItemMeta orphan_meta = orphan.getItemMeta();
        orphan_meta.setDisplayName(ChatColor.RED + "Orhpan");
        ArrayList<String> orphan_lore = new ArrayList<>();
        orphan_lore.add(ChatColor.DARK_GREEN + "Increase clicking power by 15");
        orphan_lore.add(ChatColor.DARK_GREEN + "Upgrade costs: " + costTotem);
        orphan_meta.setLore(orphan_lore);
        orphan.setItemMeta(orphan_meta);
        inv.setItem(13, orphan);

        ItemMeta Factory_meta = Factory.getItemMeta();
        Factory_meta.setDisplayName(ChatColor.RED + "Factory");
        ArrayList<String> Factory_lore = new ArrayList<>();
        Factory_lore.add(ChatColor.DARK_GREEN + "This increases cooking clicking power by 50");
        Factory_lore.add(ChatColor.DARK_GREEN + "Upgrade costs: " + costFactory);
        Factory_meta.setLore(Factory_lore);
        Factory.setItemMeta(Factory_meta);
        inv.setItem(16, Factory);

        p.openInventory(inv);
    }
}