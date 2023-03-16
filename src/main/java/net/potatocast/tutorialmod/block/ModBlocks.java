package net.potatocast.tutorialmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.potatocast.tutorialmod.Tutorialmod;
import net.potatocast.tutorialmod.item.ModCreativeModeTab;
import net.potatocast.tutorialmod.item.Moditems;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tutorialmod.MOD_ID);

    //cobalt
    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f).requiresCorrectToolForDrops(),
            UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f).requiresCorrectToolForDrops(),
            UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> NETHER_COBALT_ORE = registerBlock("nether_cobalt_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f).requiresCorrectToolForDrops(),
            UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> END_COBALT_ORE = registerBlock("end_cobalt_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f).requiresCorrectToolForDrops(),
            UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
