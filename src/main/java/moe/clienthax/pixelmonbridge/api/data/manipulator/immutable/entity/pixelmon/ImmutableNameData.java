package moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableNameData;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.text.Text;

/**
 * Created by clienthax on 13/03/2018.
 */
public interface ImmutableNameData extends ImmutableDataManipulator<ImmutableNameData, MutableNameData> {

    ImmutableValue<String> name();

}
