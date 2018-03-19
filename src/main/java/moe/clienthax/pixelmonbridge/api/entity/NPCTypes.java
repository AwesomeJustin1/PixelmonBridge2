package moe.clienthax.pixelmonbridge.api.entity;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.EntityType;

/**
 * Created by clienthax on 13/03/2018.
 */
public class NPCTypes {

    public static final EntityType TUTOR = Sponge.getRegistry().getType(EntityType.class, "pixelmon:tutor").get();
    public static final EntityType NURSEJOY = Sponge.getRegistry().getType(EntityType.class, "pixelmon:nursejoy").get();
    public static final EntityType SHOPKEEPER = Sponge.getRegistry().getType(EntityType.class, "pixelmon:shopkeeper").get();
    public static final EntityType TRAINER = Sponge.getRegistry().getType(EntityType.class, "pixelmon:trainer").get();
    public static final EntityType CHATTINGNPC = Sponge.getRegistry().getType(EntityType.class, "pixelmon:chattingnpc").get();
    public static final EntityType RELEARNER = Sponge.getRegistry().getType(EntityType.class, "pixelmon:relearner").get();
    public static final EntityType TRADER = Sponge.getRegistry().getType(EntityType.class, "pixelmon:trader").get();

}
