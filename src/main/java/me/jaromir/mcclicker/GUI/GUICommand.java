package me.jaromir.mcclicker.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static me.jaromir.mcclicker.Listener.CookieListener.*;

public class GUICommand {

    private Inventory inv;

    /**
     * /////////////////// COOKIE CLICKER GUI /////////////
     */
    public void openNewGUI(Player p) {
        inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Cookie Clicker - Upgardes");
        for (int slot = 0; slot < inv.getSize(); slot++) {
            inv.setItem(slot, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
        }
        ItemStack extraHand = new ItemStack(Material.SHEARS);
        ItemStack orphan = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemStack Factory = new ItemStack(Material.PISTON);
        ItemStack cookie = new ItemStack(Material.COOKIE);
        ItemStack lever = new ItemStack(Material.LEVER);
        ItemStack leaf = new ItemStack(Material.JUNGLE_LEAVES);

        ItemMeta leaf_meta = leaf.getItemMeta();
        leaf_meta.setDisplayName(ChatColor.RED + "Styling");
        ArrayList<String> leaf_lore = new ArrayList<>();
        leaf_lore.add(ChatColor.DARK_GREEN + "Click to change the way how your GUI looks");
        leaf_meta.setLore(leaf_lore);
        leaf.setItemMeta(leaf_meta);
        inv.setItem(26, leaf);

        ItemMeta lever_meta = lever.getItemMeta();
        lever_meta.setDisplayName(ChatColor.RED + "Click power");
        ArrayList<String> lever_lore = new ArrayList<>();
        lever_lore.add(ChatColor.DARK_GREEN + "Your click power: " + count);
        lever_meta.setLore(lever_lore);
        lever.setItemMeta(lever_meta);
        inv.setItem(22, lever);

        ItemMeta cookie_meta = cookie.getItemMeta();
        cookie_meta.setDisplayName(ChatColor.RED + "Cookie counter");
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