package moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.item;

import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.item.MutablePixelmonSpriteItemData;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * Created by clienthax on 09/03/2018.
 */
public interface ImmutablePixelmonSpriteItemData extends ImmutableDataManipulator<ImmutablePixelmonSpriteItemData, MutablePixelmonSpriteItemData> {

    ImmutableValue<String> spritePath();

}
