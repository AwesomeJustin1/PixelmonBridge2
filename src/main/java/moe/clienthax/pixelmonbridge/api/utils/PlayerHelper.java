package moe.clienthax.pixelmonbridge.api.utils;

import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.living.player.Player;

public interface PlayerHelper {

    /**
     * Adds the specified pokemon to a free slot of the players party,
     * this will be forwarded to their computer if there is no space
     *
     * @param player
     * @param snapshot the pixelmon to add
     */
    void addToParty(Player player, EntitySnapshot snapshot);

}
