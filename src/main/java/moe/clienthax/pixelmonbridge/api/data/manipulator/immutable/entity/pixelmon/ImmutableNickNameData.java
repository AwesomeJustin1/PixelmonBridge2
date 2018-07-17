package moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableNickNameData;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * Created by clienthax on 13/03/2018.
 */
public interface ImmutableNickNameData extends ImmutableDataManipulator<ImmutableNickNameData, MutableNickNameData> {

    ImmutableValue<String> nickName();

}
