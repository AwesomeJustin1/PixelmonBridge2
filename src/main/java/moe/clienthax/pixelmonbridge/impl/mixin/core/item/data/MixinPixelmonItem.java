package moe.clienthax.pixelmonbridge.impl.mixin.core.item.data;

import com.pixelmonmod.pixelmon.items.PixelmonItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.common.mixin.core.item.MixinItem;

/**
 * Created by clienthax on 09/03/2018.
 */
@Mixin(value = PixelmonItem.class)
public abstract class MixinPixelmonItem extends MixinItem {
}
