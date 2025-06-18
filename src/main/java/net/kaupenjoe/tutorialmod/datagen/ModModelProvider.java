package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.block.custom.BismuthLampBlock;
import net.kaupenjoe.tutorialmod.block.custom.GojiBerryBushBlock;
import net.kaupenjoe.tutorialmod.block.custom.RadishCropBlock;
import net.kaupenjoe.tutorialmod.component.ModDataComponents;
import net.kaupenjoe.tutorialmod.item.ModArmorMaterials;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.BISMUTH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_BISMUTH.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.RADISH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.FROSTFIRE_ICE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.STARLIGHT_ASHES.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.BISMUTH_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModels.generateTrimmableItem(ModItems.BISMUTH_HELMET.get(), ModArmorMaterials.BISMUTH, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth"), false);
        itemModels.generateTrimmableItem(ModItems.BISMUTH_CHESTPLATE.get(), ModArmorMaterials.BISMUTH, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth"), false);
        itemModels.generateTrimmableItem(ModItems.BISMUTH_LEGGINGS.get(), ModArmorMaterials.BISMUTH, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth"), false);
        itemModels.generateTrimmableItem(ModItems.BISMUTH_BOOTS.get(), ModArmorMaterials.BISMUTH, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth"),  false);

        itemModels.generateFlatItem(ModItems.KAUPEN_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.BAR_BRAWL_MUSIC_DISC.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.GECKO_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);

        itemModels.createFlatItemModel(ModItems.KAUPEN_BOW.get(), ModelTemplates.BOW);
        itemModels.generateBow(ModItems.KAUPEN_BOW.get());

        ItemModel.Unbaked unbakedChisel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(ModItems.CHISEL.get(), ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked unbakedUsedChisel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(ModItems.CHISEL.get(), "_used", ModelTemplates.FLAT_ITEM));
        itemModels.itemModelOutput.register(ModItems.CHISEL.get(),
                new ClientItem(new ConditionalItemModel.Unbaked(new HasComponent(ModDataComponents.COORDINATES.get(), false),
                        unbakedUsedChisel, unbakedChisel),
                        new ClientItem.Properties(false, false)));

        itemModels.generateFlatItem(ModItems.RADIATION_STAFF.get(), ModelTemplates.FLAT_ITEM);

        /* BLOCKS */
        blockModels.createTrivialCube(ModBlocks.BISMUTH_ORE.get());
        blockModels.createTrivialCube(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.BISMUTH_END_ORE.get());
        blockModels.createTrivialCube(ModBlocks.BISMUTH_NETHER_ORE.get());

        blockModels.createTrivialCube(ModBlocks.MAGIC_BLOCK.get());

        blockModels.family(ModBlocks.BISMUTH_BLOCK.get())
                .fence(ModBlocks.BISMUTH_FENCE.get())
                .fenceGate(ModBlocks.BISMUTH_FENCE_GATE.get())
                .wall(ModBlocks.BISMUTH_WALL.get())
                .stairs(ModBlocks.BISMUTH_STAIRS.get())
                .slab(ModBlocks.BISMUTH_SLAB.get())
                .button(ModBlocks.BISMUTH_BUTTON.get())
                .pressurePlate(ModBlocks.BISMUTH_PRESSURE_PLATE.get())
                .door(ModBlocks.BISMUTH_DOOR.get())
                .trapdoor(ModBlocks.BISMUTH_TRAPDOOR.get());

        blockModels.woodProvider(ModBlocks.BLOODWOOD_LOG.get()).logWithHorizontal(ModBlocks.BLOODWOOD_LOG.get()).wood(ModBlocks.BLOODWOOD_WOOD.get());
        blockModels.woodProvider(ModBlocks.STRIPPED_BLOODWOOD_LOG.get()).logWithHorizontal(ModBlocks.STRIPPED_BLOODWOOD_LOG.get()).wood(ModBlocks.STRIPPED_BLOODWOOD_WOOD.get());

        blockModels.createTrivialCube(ModBlocks.BLOODWOOD_PLANKS.get());

        blockModels.createTintedLeaves(ModBlocks.BLOODWOOD_LEAVES.get(), TexturedModel.LEAVES, -12012264);

        blockModels.createCropBlock(ModBlocks.RADISH_CROP.get(), RadishCropBlock.AGE,  0, 1, 2, 3);
        blockModels.createCropBlock(ModBlocks.GOJI_BERRY_BUSH.get(), GojiBerryBushBlock.AGE,  0, 1, 2, 3);

        blockModels.createCrossBlock(ModBlocks.BLOODWOOD_SAPLING.get(), BlockModelGenerators.PlantType.TINTED);

        blockModels.createTrivialCube(ModBlocks.GROWTH_CHAMBER.get());

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.BISMUTH_LAMP.get())
                        .with(BlockModelGenerators.createBooleanModelDispatch(BismuthLampBlock.CLICKED,
                                BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(ModBlocks.BISMUTH_LAMP.get(), "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube)),
                                BlockModelGenerators.plainVariant(TexturedModel.CUBE.create(ModBlocks.BISMUTH_LAMP.get(), blockModels.modelOutput)))));
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().filter(x -> !x.is(ModBlocks.PEDESTAL) && !x.is(ModBlocks.CHAIR));
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream().filter(x -> x.get() != ModBlocks.PEDESTAL.asItem() && x.get() != ModBlocks.CHAIR.asItem()
                && !x.is(ModItems.TOMAHAWK));
    }
}
