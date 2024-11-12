package net.kaupenjoe.tutorialmod.enchantment;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> LIGHTNING_STRIKER = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "lightning_striker"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, LIGHTNING_STRIKER, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                5,
                2,
                Enchantment.dynamicCost(5, 7),
                Enchantment.dynamicCost(25, 7),
                2,
                EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM, new LightningStrikerEnchantmentEffect()));
    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key,
                                 Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }
}
