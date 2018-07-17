package moe.clienthax.pixelmonbridge.api.catalog.gender;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Created by Justin
 */
public class Genders {
    public static final Gender MALE = DummyObjectProvider.createFor(Gender.class, "MALE");
    public static final Gender FEMALE = DummyObjectProvider.createFor(Gender.class, "FEMALE");
    public static final Gender NONE = DummyObjectProvider.createFor(Gender.class, "NONE");
}
