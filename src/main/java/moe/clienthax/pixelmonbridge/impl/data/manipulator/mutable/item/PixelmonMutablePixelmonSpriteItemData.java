package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.item;

import static com.google.common.base.Preconditions.checkNotNull;

import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.item.ImmutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.item.MutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.item.PixelmonImmutablePixelmonSpriteItemData;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Optional;

import static moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys.SPRITE_NAME;

/**
 * Created by clienthax on 09/03/2018.
 */
public class PixelmonMutablePixelmonSpriteItemData extends AbstractData<MutablePixelmonSpriteItemData, ImmutablePixelmonSpriteItemData> implements MutablePixelmonSpriteItemData
{

    String spriteName;

    public PixelmonMutablePixelmonSpriteItemData(String spriteName) {
        this.spriteName = spriteName;
        registerGettersAndSetters();
    }

    public PixelmonMutablePixelmonSpriteItemData() {
        this("");
    }

    @Override
    protected void registerGettersAndSetters() {
        registerFieldGetter(SPRITE_NAME, () -> this.spriteName);
        registerFieldSetter(SPRITE_NAME, (value) -> this.spriteName = value);
        registerKeyValue(SPRITE_NAME, this::spritePath);
    }

    @Override
    public Value<String> spritePath() {
        return Sponge.getRegistry().getValueFactory()
                .createValue(SPRITE_NAME, this.spriteName, "");
    }



    @Override
    public Optional<MutablePixelmonSpriteItemData> fill(DataHolder dataHolder, MergeFunction overlap) {
        MutablePixelmonSpriteItemData mutablePixelmonSpriteItemData = checkNotNull(checkNotNull(overlap).merge(copy(), from(dataHolder.toContainer()).orElse(null)));
        mutablePixelmonSpriteItemData = mutablePixelmonSpriteItemData
                .set(SPRITE_NAME, this.spriteName);
        return Optional.of(mutablePixelmonSpriteItemData);
    }

    @Override
    public Optional<MutablePixelmonSpriteItemData> from(DataContainer container) {
        return Optional.empty();
    }

    @Override
    public MutablePixelmonSpriteItemData copy() {
        return new PixelmonMutablePixelmonSpriteItemData(this.spriteName);
    }

    @Override
    public ImmutablePixelmonSpriteItemData asImmutable() {
        return new PixelmonImmutablePixelmonSpriteItemData(this.spriteName);
    }

    @Override
    public int getContentVersion() {
        return 0;
    }
}
