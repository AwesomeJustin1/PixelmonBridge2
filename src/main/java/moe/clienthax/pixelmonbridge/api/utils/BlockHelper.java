package moe.clienthax.pixelmonbridge.api.utils;

import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Optional;

public interface BlockHelper {

    /**
     * Gets the base block which contains the tile entity for pixelmon multiblocks
     * @param worldLocation
     * @return either the base tile entity of the multiblock, or the original worldLocation
     */
    Optional<Location<World>> getBaseBlock(Location<World> worldLocation);

}
