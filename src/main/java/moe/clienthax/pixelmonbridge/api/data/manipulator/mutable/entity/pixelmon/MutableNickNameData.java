package moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableNameData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableNickNameData;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Created by clienthax on 13/03/2018.
 */
public interface MutableNickNameData extends DataManipulator<MutableNickNameData, ImmutableNickNameData> {

    Value<String> nickName();

}
