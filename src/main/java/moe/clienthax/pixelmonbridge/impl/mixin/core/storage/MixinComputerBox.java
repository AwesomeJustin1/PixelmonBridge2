package moe.clienthax.pixelmonbridge.impl.mixin.core.storage;

import com.pixelmonmod.pixelmon.storage.ComputerBox;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Created by Justin
 */
@Mixin(ComputerBox.class)
public abstract class MixinComputerBox implements moe.clienthax.pixelmonbridge.api.storage.ComputerBox {

    @Shadow
    protected abstract void updatePCData(int pos);

}