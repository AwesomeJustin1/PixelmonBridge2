package moe.clienthax.pixelmonbridge.impl.data.processor.value.item;

import moe.clienthax.pixelmonbridge.impl.items.PixelmonItemList;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.common.data.processor.common.AbstractSpongeValueProcessor;
import org.spongepowered.common.data.util.NbtDataUtil;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeValue;
import org.spongepowered.common.data.value.mutable.SpongeValue;

import java.util.Optional;

import static moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys.SPRITE_NAME;

/**
 * Created by clienthax on 09/03/2018.
 */
public class SpritePathValueProcessor extends AbstractSpongeValueProcessor<ItemStack, String, Value<String>> {

    public SpritePathValueProcessor() {
        super(ItemStack.class, SPRITE_NAME);
    }

    @Override
    protected Value<String> constructValue(String actualValue) {
        return new SpongeValue<>(this.key, actualValue);
    }

    @Override
    protected boolean set(ItemStack itemStack, String value) {
        if (itemStack.getItem() == PixelmonItemList.SPRITE_ITEM) {
            NbtDataUtil.getOrCreateCompound(itemStack).setString("SpriteName", value);
        }
        return true;
    }

    @Override
    protected Optional<String> getVal(ItemStack itemStack) {
        if (itemStack.getItem() == PixelmonItemList.SPRITE_ITEM) {
            final NBTTagCompound mainCompound = itemStack.getTagCompound();
            if (mainCompound == null) {
                return Optional.empty(); // Basically, this wasn't initialized properly.
            }
            final String spritePath = mainCompound.getString("SpriteName");
            return Optional.of(spritePath);
        }
        return Optional.empty();
    }

    @Override
    protected ImmutableValue<String> constructImmutableValue(String value) {
        return new ImmutableSpongeValue<String>(this.key, value);
    }

    @Override
    public DataTransactionResult removeFrom(ValueContainer<?> container) {
        return DataTransactionResult.failNoData();
    }
}
