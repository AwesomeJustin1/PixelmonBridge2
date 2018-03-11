package moe.clienthax.pixelmonbridge.api.data.key;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.key.KeyFactory;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.TypeTokens;

import java.util.Map;
import java.util.UUID;

import static org.spongepowered.api.data.DataQuery.of;

/**
 * Created by clienthax on 09/03/2018.
 */
public class PixelmonDataKeys {

    //For whatever reason the one in spongeapi is bounded O_o
    public static final TypeToken<Value<Float>> FLOAT_VALUE_TOKEN = new TypeToken<Value<Float>>() {private static final long serialVersionUID = -1;};
    public static final TypeToken<OptionalValue<String>> OPTIONAL_STRING_VALUE_TOKEN = new TypeToken<OptionalValue<String>>() {private static final long serialVersionUID = -1;};
    public static final TypeToken<ListValue<Integer>> LIST_INTEGER_VALUE_TOKEN = new TypeToken<ListValue<Integer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<Integer, EntitySnapshot>> MAP_VALUE_INTEGER_ENTITYSNAPSHOT_VALUE_TOKEN = new TypeToken<MapValue<Integer, EntitySnapshot>>() {};
    public static final TypeToken<MapValue<Integer, Map<Integer, EntitySnapshot>>> MAP_VALUE_INTEGER_MAP_INTEGER_ENTITYSNAPSHOT_VALUE_TOKEN = new TypeToken<MapValue<Integer, Map<Integer, EntitySnapshot>>>() {private static final long serialVersionUID = -1;};

    /**
     * Item specific keys
     */
    public static final Key<Value<String>> SPRITE_NAME = Key.builder().type(TypeTokens.STRING_VALUE_TOKEN).id("sprite_name").name("Sprite Name").query(of("SpriteName")).build();


    /**
     * Player specific keys
     */
    public static final Key<MapValue<Integer, EntitySnapshot>> PARTY_POKEMON = Key.builder().type(MAP_VALUE_INTEGER_ENTITYSNAPSHOT_VALUE_TOKEN).id("party_pokemon").name("Party Pokemon").query(of("partyPokemon")).build();
    public static final Key<MapValue<Integer, Map<Integer, EntitySnapshot>>> COMPUTER_POKEMON = Key.builder().type(MAP_VALUE_INTEGER_MAP_INTEGER_ENTITYSNAPSHOT_VALUE_TOKEN).id("computer_pokemon").name("Computer Pokemon").query(of("computerPokemon")).build();

    /**
     * PC Tile Entity Specific keys
     */
    public static final Key<OptionalValue<UUID>> COMPUTER_OWNER = Key.builder().type(TypeTokens.OPTIONAL_UUID_VALUE_TOKEN).id("computer_owner").name("Computer Owner").query(of("ComputerOwner")).build();
    public static final Key<Value<DyeColor>> COMPUTER_COLOR = Key.builder().type(TypeTokens.DYE_COLOR_VALUE_TOKEN).id("computer_color").name("Computer Color").query(of("ComputerColor")).build();
    public static final Key<Value<Boolean>> COMPUTER_RAVE_MODE = Key.builder().type(TypeTokens.BOOLEAN_VALUE_TOKEN).id("computer_rave_enabled").name("Computer Rave Mode Enabled").query(of("ComputerRaveEnabled")).build();

    /**
     * Pokemon specific keys
     */
    public static final Key<Value<Integer>> POKEMON_HP_EVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_hp_evs").name("Pokemon HP EVS").query(of("pokemonEvsHP")).build();
    public static final Key<Value<Integer>> POKEMON_ATTACK_EVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_attack_evs").name("Pokemon Attack EVS").query(of("pokemonEvsAttack")).build();
    public static final Key<Value<Integer>> POKEMON_DEFENSE_EVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_defense_evs").name("Pokemon Defense EVS").query(of("pokemonEvsDefense")).build();
    public static final Key<Value<Integer>> POKEMON_SP_ATTACK_EVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_sp_attack_evs").name("Pokemon SP Attack EVS").query(of("pokemonEvsSpAttack")).build();
    public static final Key<Value<Integer>> POKEMON_SP_DEFENSE_EVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_sp_defense_evs").name("Pokemon SP Defense EVS").query(of("pokemonEvsSpDefense")).build();
    public static final Key<Value<Integer>> POKEMON_SPEED_EVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_speed_evs").name("Pokemon Speed EVS").query(of("pokemonEvsSpeed")).build();

    public static final Key<Value<Integer>> POKEMON_HP_IVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_hp_ivs").name("Pokemon HP IVS").query(of("pokemonIvsHP")).build();
    public static final Key<Value<Integer>> POKEMON_ATTACK_IVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_attack_ivs").name("Pokemon Attack IVS").query(of("pokemonIvsAttack")).build();
    public static final Key<Value<Integer>> POKEMON_DEFENSE_IVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_defense_ivs").name("Pokemon Defense IVS").query(of("pokemonIvsDefense")).build();
    public static final Key<Value<Integer>> POKEMON_SP_ATTACK_IVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_sp_attack_ivs").name("Pokemon SP Attack IVS").query(of("pokemonIvsSpAttack")).build();
    public static final Key<Value<Integer>> POKEMON_SP_DEFENSE_IVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_sp_defense_ivs").name("Pokemon SP Defense IVS").query(of("pokemonIvsSpDefense")).build();
    public static final Key<Value<Integer>> POKEMON_SPEED_IVS = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_speed_ivs").name("Pokemon Speed IVS").query(of("pokemonIvsSpeed")).build();

    public static final Key<Value<Integer>> POKEMON_HP = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_hp").name("Pokemon HP").query(of("pokemonHP")).build();
    public static final Key<Value<Integer>> POKEMON_ATTACK = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_attack").name("Pokemon Attack").query(of("pokemonAttack")).build();
    public static final Key<Value<Integer>> POKEMON_DEFENSE = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_defense").name("Pokemon Defense").query(of("pokemonDefense")).build();
    public static final Key<Value<Integer>> POKEMON_SP_ATTACK = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_sp_attack").name("Pokemon SP Attack").query(of("pokemonSpAttack")).build();
    public static final Key<Value<Integer>> POKEMON_SP_DEFENSE = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_sp_defense").name("Pokemon SP Defense").query(of("pokemonSpDefense")).build();
    public static final Key<Value<Integer>> POKEMON_SPEED = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_speed").name("Pokemon Speed").query(of("pokemonSpeed")).build();

    public static final Key<Value<Integer>> POKEMON_LEVEL = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_level").name("Pokemon Level").query(of("pokemonLevel")).build();
    public static final Key<Value<Float>> POKEMON_SCALE = Key.builder().type(FLOAT_VALUE_TOKEN).id("pokemon_scale").name("Pokemon Scale").query(of("pokemonScale")).build();
    public static final Key<Value<String>> POKEMON_GROWTH = Key.builder().type(TypeTokens.STRING_VALUE_TOKEN).id("pokemon_growth").name("Pokemon Growth").query(of("pokemonGrowth")).build();
    public static final Key<Value<Integer>> POKEMON_VARIANT = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_variant").name("Pokemon Variant").query(of("pokemonVariant")).build();
    public static final Key<Value<String>> POKEMON_GENDER = Key.builder().type(TypeTokens.STRING_VALUE_TOKEN).id("pokemon_gender").name("Pokemon Gender").query(of("pokemonGender")).build();
    public static final Key<Value<Boolean>> POKEMON_PLAYER_OWNED = Key.builder().type(TypeTokens.BOOLEAN_VALUE_TOKEN).id("pokemon_player_owned").name("Pokemon Player Owned").query(of("pokemonPlayerOwned")).build();
    public static final Key<Value<Boolean>> POKEMON_FAINTED = Key.builder().type(TypeTokens.BOOLEAN_VALUE_TOKEN).id("pokemon_fainted").name("Pokemon Fainted").query(of("pokemonFainted")).build();
    public static final Key<Value<String>> POKEMON_CAUGHT_BALL = Key.builder().type(TypeTokens.STRING_VALUE_TOKEN).id("pokemon_caught_ball").name("Pokemon Caught Ball").query(of("pokemonCaughtBall")).build();
    public static final Key<Value<String>> POKEMON_NATURE = Key.builder().type(TypeTokens.STRING_VALUE_TOKEN).id("pokemon_nature").name("Pokemon Nature").query(of("pokemonNature")).build();
    public static final Key<Value<Integer>> POKEMON_EXP = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_exp").name("Pokemon EXP").query(of("pokemonEXP")).build();

    public static final Key<Value<String>> POKEMON_NAME = Key.builder().type(TypeTokens.STRING_VALUE_TOKEN).id("pokemon_name").name("Pokemon Name").query(of("pokemonName")).build();
    public static final Key<Value<String>> POKEMON_NICK_NAME = Key.builder().type(TypeTokens.STRING_VALUE_TOKEN).id("pokemon_nickname").name("Pokemon Nickname").query(of("pokemonNickname")).build();
    public static final Key<Value<String>> POKEMON_BOSS_MODE = Key.builder().type(TypeTokens.STRING_VALUE_TOKEN).id("pokemon_boss_mode").name("Pokemon Boss Mode").query(of("pokemonBossmode")).build();
    public static final Key<ListValue<Integer>> POKEMON_ID = Key.builder().type(LIST_INTEGER_VALUE_TOKEN).id("pokemon_ids").name("Pokemon ID").query(of("pokemonID")).build();

    public static final Key<Value<Boolean>> POKEMON_IS_EGG = Key.builder().type(TypeTokens.BOOLEAN_VALUE_TOKEN).id("pokemon_is_egg").name("Pokemon Is Egg").query(of("pokemonIsEgg")).build();
    public static final Key<Value<Boolean>> POKEMON_IS_SHINY = Key.builder().type(TypeTokens.BOOLEAN_VALUE_TOKEN).id("pokemon_is_shiny").name("Pokemon Is Shiny").query(of("pokemonIsShiny")).build();
    //TODO change this for new system
    public static final Key<Value<Integer>> POKEMON_SPECIAL_TEXTURE = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_special_texture").name("Pokemon Special Texture").query(of("pokemonSpecialTexture")).build();
    public static final Key<Value<ItemStackSnapshot>> POKEMON_HELD_ITEM = Key.builder().type(TypeTokens.ITEM_SNAPSHOT_VALUE_TOKEN).id("pokemon_held_item").name("Pokemon Held Item").query(of("pokemonHeldItem")).build();

    public static final Key<OptionalValue<String>> POKEMON_ORIGINAL_TRAINER = Key.builder().type(OPTIONAL_STRING_VALUE_TOKEN).id("pokemon_original_trainer").name("Original Pokemon Trainer").query(of("pokemonOriginalTrainer")).build();
    public static final Key<Value<Integer>> POKEMON_ABILITY_SLOT = Key.builder().type(TypeTokens.INTEGER_VALUE_TOKEN).id("pokemon_ability_slot").name("Pokemon Ability Slot").query(of("pokemonAbilitySlot")).build();
    public static final Key<Value<String>> POKEMON_ABILITY_NAME = Key.builder().type(TypeTokens.STRING_VALUE_TOKEN).id("pokemon_ability_name").name("Pokemon Ability Name").query(of("pokemonAbilityName")).build();


}
