package moe.clienthax.pixelmonbridge.api.events;

import com.pixelmonmod.pixelmon.enums.EnumType;
import moe.clienthax.pixelmonbridge.api.catalog.type.Type;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;

/**
 * Created by Justin
 */
public class CalculateTypeEffectivenessEvent implements Event {
    private Type attack;
    private Type defender;
    private float effectiveness;
    private Cause cause;

    public CalculateTypeEffectivenessEvent(EnumType attack, EnumType defender, float effectiveness) {
        this.attack = (Type) (Object) attack;
        this.defender = (Type) (Object) defender;
        this.effectiveness = effectiveness;
        cause = Cause.of(EventContext.empty(), this);
    }

    public Type getAttack() {
        return attack;
    }

    public void setAttack(Type attack) {
        this.attack = attack;
    }

    public Type getDefender() {
        return defender;
    }

    public void setDefender(Type defender) {
        this.defender = defender;
    }

    public float getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(float effectiveness) {
        this.effectiveness = effectiveness;
    }

    @Override
    public Cause getCause() {
        return cause;
    }
}
