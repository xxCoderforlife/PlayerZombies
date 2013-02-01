package me.rainbow.playerzombies;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
    public void onDisable() {
        // TODO: Place any custom disable code here.
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDie(PlayerDeathEvent event) {
        if (event.getDeathMessage().contains("Zombie")) {

            Player player = event.getEntity();
            Location location = player.getLocation();

            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            EntityEquipment eq = zombie.getEquipment();
            eq.setHelmet(new NamedSkull(player.getName()));
            eq.setHelmetDropChance(0);
            zombie.setCanPickupItems(true);
        }
    }
}

