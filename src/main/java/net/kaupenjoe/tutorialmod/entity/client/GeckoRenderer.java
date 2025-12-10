package net.kaupenjoe.tutorialmod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.GeckoVariant;
import net.kaupenjoe.tutorialmod.entity.custom.GeckoEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class GeckoRenderer extends MobRenderer<GeckoEntity, GeckoRenderState, GeckoModel> {
    private static final Map<GeckoVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(GeckoVariant.class), map -> {
                map.put(GeckoVariant.BLUE,
                        Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/gecko/gecko_blue.png"));
                map.put(GeckoVariant.GREEN,
                        Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/gecko/gecko_green.png"));
                map.put(GeckoVariant.PINK,
                        Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/gecko/gecko_pink.png"));
                map.put(GeckoVariant.BROWN,
                        Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/gecko/gecko_brown.png"));
            });

    public GeckoRenderer(EntityRendererProvider.Context context) {
        super(context, new GeckoModel(context.bakeLayer(GeckoModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public Identifier getTextureLocation(GeckoRenderState entity) {
        return LOCATION_BY_VARIANT.get(entity.variant);
    }

    @Override
    public void submit(GeckoRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        if(renderState.isBaby) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.submit(renderState, poseStack, nodeCollector, cameraRenderState);
    }

    @Override
    public GeckoRenderState createRenderState() {
        return new GeckoRenderState();
    }

    @Override
    public void extractRenderState(GeckoEntity entity, GeckoRenderState reusedState, float partialTick) {
        super.extractRenderState(entity, reusedState, partialTick);
        reusedState.idleAnimationState.copyFrom(entity.idleAnimationState);
        reusedState.variant = entity.getVariant();
    }
}
