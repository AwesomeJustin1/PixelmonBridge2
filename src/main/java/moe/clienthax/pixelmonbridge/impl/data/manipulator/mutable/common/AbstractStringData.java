package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.common;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.common.data.ImmutableDataCachingUtil;
import org.spongepowered.common.data.manipulator.mutable.common.AbstractSingleData;
import org.spongepowered.common.data.value.mutable.SpongeValue;
import org.spongepowered.common.util.ReflectionUtil;

import java.lang.reflect.Modifier;

public abstract class AbstractStringData<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>> extends
        AbstractSingleData<String, M, I> {

    private final Class<? extends I> immutableClass;
    private final String defaultValue;

    protected AbstractStringData(Class<M> manipulatorClass, String value, Key<? extends BaseValue<String>> usedKey, Class<? extends I> immutableClass, String defaultValue) {
        super(manipulatorClass, value, usedKey);
        checkArgument(!Modifier.isAbstract(immutableClass.getModifiers()), "The immutable class cannot be abstract!");
        checkArgument(!Modifier.isInterface(immutableClass.getModifiers()), "The immutable class cannot be an interface!");
        this.immutableClass = checkNotNull(immutableClass);
        this.defaultValue = checkNotNull(defaultValue);
    }

    @Override
    protected Value<String> getValueGetter() {
        return new SpongeValue<>(this.usedKey, this.defaultValue, this.getValue());
    }

    @Override
    public I asImmutable() {
        return ImmutableDataCachingUtil.getManipulator(this.immutableClass, getValue());
    }

    @SuppressWarnings("unchecked")
    @Override
    public M copy() {
        return (M) ReflectionUtil.createInstance(this.getClass(), this.getValue());
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer()
                .set(this.usedKey.getQuery(), getValue());
    }
}
