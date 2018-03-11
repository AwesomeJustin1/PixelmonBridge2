package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.item;

import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.item.ImmutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.item.MutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.item.PixelmonMutablePixelmonSpriteItemData;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

import static moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys.SPRITE_NAME;

/**
 * Created by clienthax on 09/03/2018.
 */
public class PixelmonImmutablePixelmonSpriteItemData extends AbstractImmutableData<ImmutablePixelmonSpriteItemData, MutablePixelmonSpriteItemData> implements ImmutablePixelmonSpriteItemData
{

    final String spriteName;

    final ImmutableValue<String> spriteNameImmutableValue;

    public PixelmonImmutablePixelmonSpriteItemData(String spriteName) {
        this.spriteName = spriteName;

        this.spriteNameImmutableValue = Sponge.getRegistry().getValueFactory()
                .createValue(SPRITE_NAME, this.spriteName)
                .asImmutable();

        registerGetters();
    }

    @Override
    protected void registerGetters() {
        registerFieldGetter(SPRITE_NAME, () -> this.spriteName);
        registerKeyValue(SPRITE_NAME, this::spritePath);
    }

    @Override
    public ImmutableValue<String> spritePath() {
        return spriteNameImmutableValue;
    }


    @Override
    public MutablePixelmonSpriteItemData asMutable() {
        return new PixelmonMutablePixelmonSpriteItemData(this.spriteName);
    }

    @Override
    public int getContentVersion() {
        return 0;
    }
}
