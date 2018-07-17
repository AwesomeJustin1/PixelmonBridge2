package moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableIVData;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * Created by clienthax on 13/03/2018.
 */
public interface ImmutableIVData extends ImmutableDataManipulator<ImmutableIVData, MutableIVData> {

    ImmutableValue<Integer> hpIVS();

    ImmutableValue<Integer> attackIVS();

    ImmutableValue<Integer> defenseIVS();

    ImmutableValue<Integer> spAttackIVS();

    ImmutableValue<Integer> spDefenseIVS();

    ImmutableValue<Integer> speedIVS();

}
