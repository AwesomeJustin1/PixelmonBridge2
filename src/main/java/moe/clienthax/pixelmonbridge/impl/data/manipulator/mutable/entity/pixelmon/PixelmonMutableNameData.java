package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableNameData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableNameData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon.PixelmonImmutableNameData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.common.AbstractStringData;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Created by clienthax on 13/03/2018.
 */
public class PixelmonMutableNameData extends AbstractStringData<MutableNameData, ImmutableNameData> implements MutableNameData {

    public PixelmonMutableNameData(String value) {
        super(MutableNameData.class, value, PixelmonDataKeys.POKEMON_NAME, PixelmonImmutableNameData.class, "");
    }

    public PixelmonMutableNameData() {
        this("");
    }

    @Override
    public Value<String> name() {
        return getValueGetter();
    }

}
