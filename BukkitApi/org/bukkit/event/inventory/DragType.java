package org.bukkit.event.inventory;

/**
 * 在物品栏中拖动物品的拖动类型
 */
public enum DragType {
    /**
     * 每个物品槽会放置一个光标上的物品
     */
    SINGLE,
    /**
     * 光标上的物品会平均分到每一个物品槽上，但物品槽里的物品不会超过该物品的最大堆叠数量，剩余的物品仍会在光标上
     */
    EVEN,
}
