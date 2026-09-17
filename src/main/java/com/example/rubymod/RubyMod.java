package com.example.rubymod;

import com.example.rubymod.block.ModBlocks;
import com.example.rubymod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(RubyMod.MOD_ID)
public class RubyMod {
    public static final String MOD_ID = "rubymod";
    public static final Logger LOGGER = LoggerFactory.getLogger(RubyMod.class);

    public RubyMod(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        
        modEventBus.addListener(this::addCreative);
        
        LOGGER.info("Ruby Mod initialized!");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RUBY);
        }
        
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
        }
        
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.RUBY_SWORD);
            event.accept(ModItems.RUBY_PICKAXE);
            event.accept(ModItems.RUBY_AXE);
            event.accept(ModItems.RUBY_SHOVEL);
            event.accept(ModItems.RUBY_HOE);
        }
        
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.RUBY_SWORD);
            event.accept(ModItems.RUBY_HELMET);
            event.accept(ModItems.RUBY_CHESTPLATE);
            event.accept(ModItems.RUBY_LEGGINGS);
            event.accept(ModItems.RUBY_BOOTS);
        }
    }
}