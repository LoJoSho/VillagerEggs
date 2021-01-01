package me.lojosho.villageregg;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class VillagerEgg extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void EntityEgg(ProjectileHitEvent event){
        if (event.getEntity().getType() == EntityType.EGG) {
            if (Objects.requireNonNull(event.getHitEntity()).getType() == EntityType.VILLAGER) {
                Location b = event.getHitEntity().getLocation();
                event.getEntity().getWorld().dropItemNaturally(b.getBlock().getLocation(), new ItemStack(Material.VILLAGER_SPAWN_EGG, 1));
                event.getHitEntity().remove();
            }
            if (event.getHitEntity().getType() == EntityType.COW) {
                Location b = event.getHitEntity().getLocation();
                event.getEntity().getWorld().dropItemNaturally(b.getBlock().getLocation(), new ItemStack(Material.COW_SPAWN_EGG, 1));
                event.getHitEntity().remove();
            }
            if (event.getHitEntity().getType() == EntityType.PIG) {
                Location b = event.getHitEntity().getLocation();
                event.getEntity().getWorld().dropItemNaturally(b.getBlock().getLocation(), new ItemStack(Material.PIG_SPAWN_EGG, 1));
                event.getHitEntity().remove();
            }
        }
    }
}
