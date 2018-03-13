package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.common;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.common.data.manipulator.immutable.common.AbstractImmutableSingleData;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeValue;
import org.spongepowered.common.util.ReflectionUtil;

import java.lang.reflect.Modifier;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public abstract class AbstractImmutableStringData<I extends ImmutableDataManipulator<I, M>, M extends DataManipulator<M, I>> extends
        AbstractImmutableSingleData<String, I, M> {

    private final Class<? extends M> mutableClass;
    private final String defaultValue;
    private final ImmutableValue<String> immutableValue;

    public AbstractImmutableStringData(Class<I> immutableClass, String value, Key<? extends BaseValue<String>> usedKey,
                                        Class<? extends M> mutableClass, String defaultValue) {
        super(immutableClass, value, usedKey);
        checkArgument(!Modifier.isAbstract(mutableClass.getModifiers()), "The immutable class cannot be abstract!");
        checkArgument(!Modifier.isInterface(mutableClass.getModifiers()), "The immutable class cannot be an interface!");
        this.mutableClass = checkNotNull(mutableClass);
        this.defaultValue = defaultValue;
        this.immutableValue = ImmutableSpongeValue.cachedOf(usedKey, defaultValue, value);
    }

    @Override
    protected final ImmutableValue<String> getValueGetter() {
        return this.immutableValue;
    }

    @Override
    public M asMutable() {
        return ReflectionUtil.createInstance(this.mutableClass, this.getValue());
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer()
                .set(this.usedKey, this.value);
    }

}

