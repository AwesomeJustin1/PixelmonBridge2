package moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableIVData;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Created by clienthax on 13/03/2018.
 */
public interface MutableIVData extends DataManipulator<MutableIVData, ImmutableIVData> {

    Value<Integer> hpIVS();

    Value<Integer> attackIVS();

    Value<Integer> defenseIVS();

    Value<Integer> spAttackIVS();

    Value<Integer> spDefenseIVS();

    Value<Integer> speedIVS();

}
