package moe.clienthax.pixelmonbridge.api.utils;

import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;

import java.util.Optional;

public interface PokemonHelper {

    /**
     * Sets up a pokemon to be owned by a player
     *
     * @param player      the player to generate the pokemon ids from
     * @param pokemonName the name of the pokemon to create
     * @return pokemon with ids + movesets setup
     */
    Optional<Living> makeAndSetupPokemon(Player player, String pokemonName);

    /**
     * Adds a random moveset to the pokemon
     *
     * @param pixelmon to apply moves to
     * @return pixelmon with random moves applied
     */
    Optional<Living> giveRandomMoveset(Living pixelmon);

    /**
     * Returns a egg made from the two pokemon supplied if they can both breed
     *
     * @param pixelmon1
     * @param pixelmon2
     * @return
     */
    Optional<Living> makeEgg(Living pixelmon1, Living pixelmon2);

    /**
     * Returns a egg made from the two party slots of the player specified
     *
     * @param player
     * @param slot1
     * @param slot2
     * @return
     */
    Optional<Living> makeEgg(Player player, int slot1, int slot2);

    /**
     * Returns the name of the hidden power type for a pokemon
     */
    Optional<String> getHiddenPowerType(Living pixelmon);

}
