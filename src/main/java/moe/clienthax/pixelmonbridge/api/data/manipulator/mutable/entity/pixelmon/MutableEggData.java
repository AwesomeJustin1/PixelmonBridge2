package moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableEggData;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Created by clienthax on 12/03/2018.
 */
public interface MutableEggData extends DataManipulator<MutableEggData, ImmutableEggData> {

    Value<Boolean> isEgg();

}
