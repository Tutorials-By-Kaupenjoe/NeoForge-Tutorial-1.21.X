package net.kaupenjoe.tutorialmod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record LightningStrikerEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<LightningStrikerEnchantmentEffect> CODEC = MapCodec.unit(LightningStrikerEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel serverLevel, int enchantmentLevel, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        if(enchantmentLevel == 1) {
            EntityType.LIGHTNING_BOLT.spawn(serverLevel, entity.getOnPos(), EntitySpawnReason.TRIGGERED);
        }

        if(enchantmentLevel == 2) {
            EntityType.LIGHTNING_BOLT.spawn(serverLevel, entity.getOnPos(), EntitySpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(serverLevel, entity.getOnPos(), EntitySpawnReason.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
