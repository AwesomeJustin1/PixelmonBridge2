package moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.item;

import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.item.ImmutablePixelmonSpriteItemData;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Created by clienthax on 09/03/2018.
 */
public interface MutablePixelmonSpriteItemData extends DataManipulator<MutablePixelmonSpriteItemData, ImmutablePixelmonSpriteItemData> {

    Value<String> spritePath();

}
