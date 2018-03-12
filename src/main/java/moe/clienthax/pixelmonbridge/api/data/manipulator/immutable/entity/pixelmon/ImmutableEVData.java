package moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEVData;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * Created by clienthax on 12/03/2018.
 */
public interface ImmutableEVData extends ImmutableDataManipulator<ImmutableEVData, MutableEVData> {

    ImmutableValue<Integer> hpEVS();
    ImmutableValue<Integer> attackEVS();
    ImmutableValue<Integer> defenseEVS();
    ImmutableValue<Integer> spAttackEVS();
    ImmutableValue<Integer> spDefenseEVS();
    ImmutableValue<Integer> speedEVS();

}

