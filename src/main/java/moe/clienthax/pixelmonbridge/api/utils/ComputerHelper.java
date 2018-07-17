package moe.clienthax.pixelmonbridge.api.utils;

import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.living.player.Player;

public interface ComputerHelper {

    /**
     * Adds the specified pokemon to a free slot of the players computer
     *
     * @param player
     * @param snapshot the pixelmon to add
     */
    void addToComputer(Player player, EntitySnapshot snapshot);

}
