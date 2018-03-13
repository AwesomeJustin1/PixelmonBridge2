package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableEggData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEggData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableEggData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.common.data.manipulator.immutable.common.AbstractImmutableBooleanData;

/**
 * Created by clienthax on 12/03/2018.
 */
public class PixelmonImmutableEggData extends AbstractImmutableBooleanData<ImmutableEggData, MutableEggData> implements ImmutableEggData {


    public PixelmonImmutableEggData(boolean value) {
        super(ImmutableEggData.class, value, PixelmonDataKeys.POKEMON_IS_EGG, PixelmonMutableEggData.class, false);
    }

    @Override
    public ImmutableValue<Boolean> isEgg() {
        return getValueGetter();
    }

}
