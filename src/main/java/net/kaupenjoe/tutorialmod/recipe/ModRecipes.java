package net.kaupenjoe.tutorialmod.recipe;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, TutorialMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, TutorialMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<GrowthChamberRecipe>> GROWTH_CHAMBER_SERIALIZER =
            SERIALIZERS.register("growth_chamber", GrowthChamberRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<GrowthChamberRecipe>> GROWTH_CHAMBER_TYPE =
            TYPES.register("growth_chamber", () -> new RecipeType<GrowthChamberRecipe>() {
                @Override
                public String toString() {
                    return "growth_chamber";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
