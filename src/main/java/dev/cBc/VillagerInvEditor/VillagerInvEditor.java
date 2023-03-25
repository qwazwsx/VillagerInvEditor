package dev.cBc.VillagerInvEditor;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.cBc.VillagerInvEditor.utils.Color;
import dev.cBc.VillagerInvEditor.utils.listeners.OnClick;
import dev.cBc.VillagerInvEditor.utils.listeners.OnClose;
import dev.cBc.VillagerInvEditor.utils.listeners.OnRightClick;

public final class VillagerInvEditor extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Enabling VillagerInvEditor...");
        // allow onClose handler to access interaction log
        OnRightClick onRightClick = new OnRightClick();
        OnClose onClose = new OnClose();        
        onClose.interactions = onRightClick.interactions;
        Bukkit.getServer().getPluginManager().registerEvents(onRightClick, this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnClick(), this);
        Bukkit.getServer().getPluginManager().registerEvents(onClose, this);    }

    @Override
    public void onDisable() {
        System.out.println("Disabling VillagerInvEditor...");
    }
}
