package moe.clienthax.pixelmonbridge.impl.utils;

import com.pixelmonmod.pixelmon.blocks.MultiBlock;
import moe.clienthax.pixelmonbridge.api.utils.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.common.util.VecHelper;

import java.util.Optional;

public class PixelmonBlockHelper implements BlockHelper {

    public Optional<Location<World>> getBaseBlock(Location<World> worldLocation) {
        BlockState state = worldLocation.getBlock();
        Block block = ((IBlockState) state).getBlock();
        if (block instanceof MultiBlock) {
            BlockPos baseBlock = ((MultiBlock) block).findBaseBlock((net.minecraft.world.World) worldLocation.getExtent(), new BlockPos.MutableBlockPos(VecHelper.toBlockPos(worldLocation)), ((IBlockState) state));
            return Optional.of(new Location<>(worldLocation.getExtent(), VecHelper.toVector3d(baseBlock)));
        }
        return Optional.of(worldLocation);
    }

}
