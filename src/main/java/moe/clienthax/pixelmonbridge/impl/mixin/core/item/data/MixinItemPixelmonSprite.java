package moe.clienthax.pixelmonbridge.impl.mixin.core.item.data;

import com.pixelmonmod.pixelmon.items.ItemPixelmonSprite;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.item.MutablePixelmonSpriteItemData;
import net.minecraft.item.ItemStack;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

/**
 * Created by clienthax on 09/03/2018.
 */
@Mixin(ItemPixelmonSprite.class)
public abstract class MixinItemPixelmonSprite extends MixinPixelmonItem {

    @Override
    public void getManipulatorsFor(ItemStack itemStack, List<DataManipulator<?, ?>> list) {
        super.getManipulatorsFor(itemStack, list);
        org.spongepowered.api.item.inventory.ItemStack spongeStack = (org.spongepowered.api.item.inventory.ItemStack) (Object) itemStack;

        spongeStack.get(MutablePixelmonSpriteItemData.class).ifPresent(list::add);
    }

}
