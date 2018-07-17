package moe.clienthax.pixelmonbridge.api;

import com.google.common.base.Preconditions;
import moe.clienthax.pixelmonbridge.api.utils.BlockHelper;
import moe.clienthax.pixelmonbridge.api.utils.ComputerHelper;
import moe.clienthax.pixelmonbridge.api.utils.PlayerHelper;
import moe.clienthax.pixelmonbridge.api.utils.PokemonHelper;

/**
 * Created by clienthax on 09/03/2018.
 */
public final class PixelmonBridgeAPI {

    private static final PokemonHelper pokemonHelper = null;
    private static final ComputerHelper computerHelper = null;
    private static final BlockHelper blockHelper = null;
    private static final PlayerHelper playerHelper = null;

    public static PokemonHelper getPokemonHelper() {
        Preconditions.checkState(pokemonHelper != null, "PixelmonHelper was not initialized");
        return pokemonHelper;
    }

    public static ComputerHelper getComputerHelper() {
        Preconditions.checkState(computerHelper != null, "ComputerHelper was not initialized");
        return computerHelper;
    }

    public static BlockHelper getBlockHelper() {
        Preconditions.checkState(blockHelper != null, "BlockHelper was not initialized");
        return blockHelper;
    }

    public static PlayerHelper getPlayerHelper() {
        Preconditions.checkState(playerHelper != null, "PlayerHelper was not initialized");
        return playerHelper;
    }

}
