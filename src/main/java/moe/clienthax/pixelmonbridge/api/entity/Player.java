package moe.clienthax.pixelmonbridge.api.entity;


import moe.clienthax.pixelmonbridge.api.entity.pixelmon.Pokemon;
import moe.clienthax.pixelmonbridge.api.storage.PlayerStorage;

import java.util.Optional;

/**
 * Created by Justin
 */
public interface Player extends org.spongepowered.api.entity.living.player.Player {
    /**
     * Caches the result of the internal getPlayerStorage() call so it is only called once per player
     *
     * @return The player's PlayerStorage
     */
    PlayerStorage getStorage();

    /**
     * READ-ONLY
     *
     * @param pos The position of the pokemon you want to access
     * @return A copy of the pokemon stored there in a kinda NBTTagCompound form
     */
    Optional<Pokemon> getPokemon(int pos);
}
