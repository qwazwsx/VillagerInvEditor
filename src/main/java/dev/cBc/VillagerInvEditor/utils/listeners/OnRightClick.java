package dev.cBc.VillagerInvEditor.utils.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Random;

public class OnRightClick implements Listener {
    public Villager target;
    public HashMap<String, Villager> interactions = new HashMap<>();


    @EventHandler
    public void onRightClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (player.isSneaking()) {
            if (event.getRightClicked() instanceof Villager villager) {
                // cancel default villager interact
                event.setCancelled(true);

                // store this villager *with a reference to our player ID* to prevent race condition w/ two players editing inventories at the same time
                interactions.put(event.getPlayer().getName(), villager);

                // create and fill inventory
                Inventory inventory = Bukkit.createInventory(null, 9, "Villager's Inventory");
                for (int i = 0; i < 8; i++) {
                    inventory.setItem(i, villager.getInventory().getItem(i));
                }

                // villagers only have 8 inventory slots, block the last one
                inventory.setItem(8, new ItemStack(Material.BARRIER));
                
                player.openInventory(inventory);
            }
        }
    }
}
