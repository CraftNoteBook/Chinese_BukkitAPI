package org.bukkit.event.inventory;

import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.Recipe;

/**
 * 当一个物品被合成的时候触发这个事件。
 * 译注:触发这个事件的时候，物品已经被合成出来。
 */
public class CraftItemEvent extends InventoryClickEvent {
    private Recipe recipe;

    @Deprecated
    public CraftItemEvent(Recipe recipe, InventoryView what, SlotType type, int slot, boolean right, boolean shift) {
        this(recipe, what, type, slot, right ? (shift ? ClickType.SHIFT_RIGHT : ClickType.RIGHT) : (shift ? ClickType.SHIFT_LEFT : ClickType.LEFT), InventoryAction.PICKUP_ALL);
    }

    public CraftItemEvent(Recipe recipe, InventoryView what, SlotType type, int slot, ClickType click, InventoryAction action) {
        super(what, type, slot, click, action);
        this.recipe = recipe;
    }

    public CraftItemEvent(Recipe recipe, InventoryView what, SlotType type, int slot, ClickType click, InventoryAction action, int key) {
        super(what, type, slot, click, action, key);
        this.recipe = recipe;
    }

    /**
     * 获取合成出该物品所用的合成公式.
     * @return 被合成出来的物品所用的合成公式
     */
    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public CraftingInventory getInventory() {
        return (CraftingInventory) super.getInventory();
    }
}

