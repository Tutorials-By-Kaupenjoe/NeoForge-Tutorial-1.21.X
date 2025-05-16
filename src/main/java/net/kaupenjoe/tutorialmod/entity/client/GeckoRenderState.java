package net.kaupenjoe.tutorialmod.entity.client;

import net.kaupenjoe.tutorialmod.entity.GeckoVariant;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class GeckoRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public GeckoVariant variant;
}
