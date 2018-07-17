package moe.clienthax.pixelmonbridge.api.pixelmon;

import com.pixelmonmod.pixelmon.enums.EnumType;
import com.pixelmonmod.pixelmon.enums.battle.AttackCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/**
 * Created by Justin
 */
public interface Moveset extends List<com.pixelmonmod.pixelmon.battles.attacks.Attack>, Cloneable, RandomAccess {

    boolean add(Attack a);


    default Attack set(int index, Attack a) {
        return (Attack) set(index, (com.pixelmonmod.pixelmon.battles.attacks.Attack) a);
    }


    void swap(int index, int index2);


    boolean replaceMove(String oldMove, com.pixelmonmod.pixelmon.battles.attacks.Attack newMove);

    default boolean replaceMove(String oldMove, Attack newMove) {
        return replaceMove(oldMove, (com.pixelmonmod.pixelmon.battles.attacks.Attack) newMove);
    }


    void replaceWith(ArrayList<Integer> attackIds);


    boolean isAt(int index, com.pixelmonmod.pixelmon.battles.attacks.Attack a);

    default boolean isAt(int index, Attack a) {
        return isAt(index, (com.pixelmonmod.pixelmon.battles.attacks.Attack) a);
    }


    boolean hasAttack(com.pixelmonmod.pixelmon.battles.attacks.Attack a);

    default boolean hasAttack(Attack a) {
        return hasAttack((com.pixelmonmod.pixelmon.battles.attacks.Attack) a);
    }


    boolean hasAttack(String... attackNames);


    boolean hasAttackCategory(AttackCategory attackCategory);


    boolean hasOffensiveAttackType(EnumType... types);


    boolean hasFullPP();


    void healAllPP();
}
