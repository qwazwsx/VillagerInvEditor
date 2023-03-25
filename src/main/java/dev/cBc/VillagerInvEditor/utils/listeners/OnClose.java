package dev.cBc.VillagerInvEditor.utils.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.entity.Villager;
import java.util.HashMap;

public class OnClose implements Listener {
    public HashMap<String, Villager> interactions;

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        // look up our target villager by player name
        Villager target = interactions.get(event.getPlayer().getName());

        // if we're just closed our inventory
        if (event.getView().getTitle().equal("Villager's Inventory") && target != null) {
            // copy the edited inventory back into the villagers inventory
            for (int i = 0; i < 8; i++) { // careful to only select the first 8 slots
                target.getInventory().setItem(i, event.getInventory().getItem(i));
            }
        }
    }
}