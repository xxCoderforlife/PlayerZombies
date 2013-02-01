package me.rainbow.playerzombies;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * User: rainbow
 * Date: 02/01/13
 * Time: 14:56
 */
public class NamedSkull extends ItemStack {
    private String skullOwner;

    public NamedSkull(String owner) {
        super(Material.SKULL_ITEM, 1, (byte) 3);
        setSkullOwner(owner);
    }

    public NamedSkull(Player player){
        this(player.getName());
    }

    public String getSkullOwner() {
        return skullOwner;
    }

    public void setSkullOwner(String skullOwner) {
        this.skullOwner = skullOwner;
        SkullMeta metadata = (SkullMeta) getItemMeta();
        metadata.setOwner(skullOwner);
        setItemMeta(metadata);
    }
}