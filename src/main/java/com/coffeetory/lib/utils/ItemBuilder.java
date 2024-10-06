package com.coffeetory.lib.utils;

import com.google.common.collect.Multimap;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ItemBuilder {

    private final Material material;
    private final ItemMeta itemMeta;
    private final List<Component> lore;

    private int amount;

    public ItemBuilder(Material material) {
        this(material, 1);
    }

    public ItemBuilder(ItemStack item) {
        this(item, item.getAmount());
    }

    public ItemBuilder(@NotNull ItemStack item, int amount) {
        this(item.getType(), item.getItemMeta(), amount);
    }

    public ItemBuilder(Material material, int amount) {
        this(material, null, amount);
    }

    public ItemBuilder(Material material, ItemMeta meta, int amount) {
        this.material = material;
        this.itemMeta = meta == null ? Bukkit.getItemFactory().getItemMeta(material) : meta;
        this.lore = itemMeta.hasLore() ? itemMeta.lore() : new ArrayList<>();
        this.amount = amount;
    }

    public ItemBuilder withDisplayName(@NotNull String name) {
        itemMeta.displayName(Component.text(name));
        return this;
    }

    public ItemBuilder withDisplayName(@NotNull Component name) {
        itemMeta.displayName(name);
        return this;
    }

    public ItemBuilder withPersistentData(NamespacedKey key, String data) {
        itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, data);
        return this;
    }

    public ItemBuilder withPersistentData(NamespacedKey key, int data) {
        itemMeta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, data);
        return this;
    }

    public ItemBuilder withPersistentData(NamespacedKey key, boolean data) {
        itemMeta.getPersistentDataContainer().set(key, PersistentDataType.BOOLEAN, data);
        return this;
    }

    public ItemBuilder withAttributeModifiers(Multimap<Attribute, AttributeModifier> attributeModifiers) {
        itemMeta.setAttributeModifiers(attributeModifiers);
        return this;
    }

    public ItemBuilder withItemFlag(ItemFlag flag, boolean bol) {
        if (bol) itemMeta.addItemFlags(flag);
        else itemMeta.removeItemFlags(flag);
        return this;
    }

    public ItemBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder withEnchant(Enchantment enchant, int level) {
        this.itemMeta.addEnchant(enchant, level, true);
        return this;
    }

    public ItemBuilder withLore(@NotNull String lore) {
        this.lore.add(lore.isEmpty() ? Component.empty() : Component.text(lore));
        return this;
    }

    public ItemBuilder withLore(String @NotNull ... lores) {
        for (String s : lores)
            lore.add(s == null ? Component.empty() : Component.text(s));
        return this;
    }

    public ItemBuilder withLore(Component lore) {
        if (lore != null) this.lore.add(lore);
        return this;
    }

    public ItemBuilder withLore(Component @NotNull ... lores) {
        for (Component c : lores)
            if (c != null) lore.add(c);
        return this;
    }

    public ItemStack build() {
        ItemStack item = ItemStack.of(material, amount);
        itemMeta.lore(lore);
        item.setItemMeta(itemMeta);
        return new ItemStack(item);
    }

}
