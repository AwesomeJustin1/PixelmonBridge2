package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableNameData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableNameData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.common.AbstractImmutableStringData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableNameData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * Created by clienthax on 13/03/2018.
 */
public class PixelmonImmutableNameData extends AbstractImmutableStringData<ImmutableNameData, MutableNameData> implements ImmutableNameData {


    public PixelmonImmutableNameData(String value) {
        super(ImmutableNameData.class, value, PixelmonDataKeys.POKEMON_NAME, PixelmonMutableNameData.class, "");
    }

    @Override
    public ImmutableValue<String> name() {
        return getValueGetter();
    }

}
