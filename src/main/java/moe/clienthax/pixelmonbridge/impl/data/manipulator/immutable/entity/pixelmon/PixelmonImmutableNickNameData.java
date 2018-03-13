package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableNickNameData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableNickNameData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.common.AbstractImmutableStringData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableNickNameData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * Created by clienthax on 13/03/2018.
 */
public class PixelmonImmutableNickNameData extends AbstractImmutableStringData<ImmutableNickNameData, MutableNickNameData> implements ImmutableNickNameData {


    public PixelmonImmutableNickNameData(String value) {
        super(ImmutableNickNameData.class, value, PixelmonDataKeys.POKEMON_NICK_NAME, PixelmonMutableNickNameData.class, "");
    }

    @Override
    public ImmutableValue<String> nickName() {
        return getValueGetter();
    }

}
