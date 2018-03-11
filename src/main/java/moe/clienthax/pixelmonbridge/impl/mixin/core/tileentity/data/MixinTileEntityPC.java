package moe.clienthax.pixelmonbridge.impl.mixin.core.tileentity.data;

import com.pixelmonmod.pixelmon.blocks.tileEntities.TileEntityPC;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.tileentity.MutableComputerTileEntityData;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.common.mixin.core.tileentity.MixinTileEntity;

import java.util.List;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(TileEntityPC.class)
public abstract class MixinTileEntityPC extends MixinTileEntity {

    @Override
    public void supplyVanillaManipulators(List<DataManipulator<?, ?>> manipulators) {
        super.supplyVanillaManipulators(manipulators);
        get(MutableComputerTileEntityData.class).ifPresent(manipulators::add);
    }

}
