package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableNickNameData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableNickNameData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon.PixelmonImmutableNickNameData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.common.AbstractStringData;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Created by clienthax on 13/03/2018.
 */
public class PixelmonMutableNickNameData extends AbstractStringData<MutableNickNameData, ImmutableNickNameData> implements MutableNickNameData {

    public PixelmonMutableNickNameData(String value) {
        super(MutableNickNameData.class, value, PixelmonDataKeys.POKEMON_NICK_NAME, PixelmonImmutableNickNameData.class, "");
    }

    public PixelmonMutableNickNameData() {
        this("");
    }

    @Override
    public Value<String> nickName() {
        return getValueGetter();
    }

}
