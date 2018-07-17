package moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableBaseStatsData;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * Created by clienthax on 12/03/2018.
 */
public interface ImmutableBaseStatsData extends ImmutableDataManipulator<ImmutableBaseStatsData, MutableBaseStatsData> {

    ImmutableValue<Integer> hp();

    ImmutableValue<Integer> attack();

    ImmutableValue<Integer> defense();

    ImmutableValue<Integer> spAttack();

    ImmutableValue<Integer> spDefense();

    ImmutableValue<Integer> speed();

}
