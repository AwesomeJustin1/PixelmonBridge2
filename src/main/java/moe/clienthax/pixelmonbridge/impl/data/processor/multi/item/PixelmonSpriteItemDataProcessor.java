package moe.clienthax.pixelmonbridge.impl.data.processor.multi.item;

import com.google.common.collect.ImmutableMap;
import com.pixelmonmod.pixelmon.storage.NbtKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.item.ImmutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.item.MutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.api.item.PixelmonItemTypes;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.item.PixelmonMutablePixelmonSpriteItemData;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.common.data.processor.common.AbstractItemDataProcessor;
import org.spongepowered.common.item.inventory.util.ItemStackUtil;

import java.util.Map;
import java.util.Optional;

import static moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys.SPRITE_NAME;

/**
 * Created by clienthax on 09/03/2018.
 */
public class PixelmonSpriteItemDataProcessor extends AbstractItemDataProcessor<MutablePixelmonSpriteItemData, ImmutablePixelmonSpriteItemData> {

    public PixelmonSpriteItemDataProcessor() {
        super(input -> input.getItem() == PixelmonItemTypes.PIXELMON_SPRITE);
    }

    @Override
    protected boolean doesDataExist(ItemStack itemStack) {
        return true;
    }

    @Override
    protected boolean set(ItemStack itemStack, Map<Key<?>, Object> keyValues) {
        if (itemStack.getTagCompound() == null) {
            itemStack.setTagCompound(new NBTTagCompound());
            itemStack.getTagCompound().setString("SpriteName", "");
        }
        final NBTTagCompound tagCompound = ItemStackUtil.getTagCompound(itemStack);
        tagCompound.setString("SpriteName", (String) keyValues.get(SPRITE_NAME));

        return true;
    }

    @Override
    protected Map<Key<?>, ?> getValues(ItemStack itemStack) {
        ImmutableMap.Builder<Key<?>, Object> builder = ImmutableMap.builder();
        builder.put(SPRITE_NAME, itemStack.getTagCompound().getString("SpriteName"));
        return builder.build();
    }

    @Override
    protected MutablePixelmonSpriteItemData createManipulator() {
        return new PixelmonMutablePixelmonSpriteItemData("");
    }

    @Override
    public Optional<MutablePixelmonSpriteItemData> fill(DataContainer container, MutablePixelmonSpriteItemData mutablePixelmonSpriteItemData) {
        String spritePath = container.getString(DataQuery.of("UnsafeData", NbtKeys.SPRITE_NAME)).orElse("");
        return Optional.of(new PixelmonMutablePixelmonSpriteItemData(spritePath));
    }

    @Override
    public DataTransactionResult remove(DataHolder dataHolder) {
        return DataTransactionResult.failNoData();
    }
}
