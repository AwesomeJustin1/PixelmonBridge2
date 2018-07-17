package moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableBaseStatsData;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Created by clienthax on 12/03/2018.
 */
public interface MutableBaseStatsData extends DataManipulator<MutableBaseStatsData, ImmutableBaseStatsData> {

    Value<Integer> hp();

    Value<Integer> attack();

    Value<Integer> defense();

    Value<Integer> spAttack();

    Value<Integer> spDefense();

    Value<Integer> speed();

}
