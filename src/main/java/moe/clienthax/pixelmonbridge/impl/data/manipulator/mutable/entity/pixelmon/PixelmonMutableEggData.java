package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableEggData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEggData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon.PixelmonImmutableEggData;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.common.data.manipulator.mutable.common.AbstractBooleanData;

/**
 * Created by clienthax on 12/03/2018.
 */
public class PixelmonMutableEggData extends AbstractBooleanData<MutableEggData, ImmutableEggData> implements MutableEggData {

    public PixelmonMutableEggData(Boolean value) {
        super(MutableEggData.class, value, PixelmonDataKeys.POKEMON_IS_EGG, PixelmonImmutableEggData.class, false);
    }

    public PixelmonMutableEggData() {
        this(false);
    }

    @Override
    public Value<Boolean> isEgg() {
        return getValueGetter();
    }

}
