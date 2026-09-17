package com.example.rubymod.item;

import com.example.rubymod.RubyMod;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.Holder;
import net.neoforged.neoforge.common.SimpleTier;
import java.util.List;
import java.util.Map;
import java.util.EnumMap;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RubyMod.MOD_ID);

    // Ruby Gem
    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    // Ruby Tool Tier
    public static final Tier RUBY_TIER = new SimpleTier(
            Tiers.DIAMOND.getIncorrectBlocksForDrops(),
            2000,
            9.0f,
            4.0f,
            15,
            () -> Ingredient.of(ModItems.RUBY.get())
    );

    // Ruby Armor Material
    public static final Holder<ArmorMaterial> RUBY_ARMOR_MATERIAL = ArmorMaterial.createRegistry().register(
            RubyMod.MOD_ID,
            new ArmorMaterial(
                    new EnumMap<>(Map.of(
                        Type.BOOTS, 3,
                        Type.LEGGINGS, 6,
                        Type.CHESTPLATE, 8,
                        Type.HELMET, 3,
                        Type.BODY, 11
                    )),
                    15,
                    SoundEvents.ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.of(ModItems.RUBY.get()),
                    List.of(new ArmorMaterial.Layer(RubyMod.MOD_ID)),
                    3.0f,
                    0.1f
            )
    );

    // Ruby Tools
    public static final DeferredItem<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(RUBY_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(RUBY_TIER, 3, -2.4f))));

    public static final DeferredItem<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(RUBY_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(RUBY_TIER, 1.0f, -2.8f))));

    public static final DeferredItem<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(RUBY_TIER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(RUBY_TIER, 6.0f, -3.1f))));

    public static final DeferredItem<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(RUBY_TIER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(RUBY_TIER, 1.5f, -3.0f))));

    public static final DeferredItem<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(RUBY_TIER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(RUBY_TIER, -2.0f, -1.0f))));

    // Ruby Armor
    public static final DeferredItem<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(RUBY_ARMOR_MATERIAL, Type.HELMET, new Item.Properties()
                    .durability(Type.HELMET.getDurability(37))));

    public static final DeferredItem<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(RUBY_ARMOR_MATERIAL, Type.CHESTPLATE, new Item.Properties()
                    .durability(Type.CHESTPLATE.getDurability(37))));

    public static final DeferredItem<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(RUBY_ARMOR_MATERIAL, Type.LEGGINGS, new Item.Properties()
                    .durability(Type.LEGGINGS.getDurability(37))));

    public static final DeferredItem<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(RUBY_ARMOR_MATERIAL, Type.BOOTS, new Item.Properties()
                    .durability(Type.BOOTS.getDurability(37))));
}