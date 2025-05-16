package net.kaupenjoe.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoodProperties {
    public static final FoodProperties RADISH = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build();

    public static final Consumable RADISH_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 400), 0.35f)).build();

    public static final FoodProperties GOJI_BERRY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.15f).build();

}
