package dev.cBc.VillagerInvEditor.utils.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnClick implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        // invoked whenever a click occurs in the inventory

        // if the click is in our window
        if (event.getView().getTitle().equals("Villager's Inventory")) {
            // prevent players from removing the barrier block
            if (event.getSlot() == 8){
               event.setCancelled(true);
            }
        }
    }
}