package org.bukkit.event.hanging;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Hanging;

/**
 * 当一个物品展示框被一个实体破坏时调用本事件
 */
public class HangingBreakByEntityEvent extends HangingBreakEvent {
    private final Entity remover;

    public HangingBreakByEntityEvent(final Hanging hanging, final Entity remover) {
        super(hanging, HangingBreakEvent.RemoveCause.ENTITY);
        this.remover = remover;
    }

    /**
     * 获取破坏这个物品展示框的实体.
     * <p>
     * 原文：Gets the entity that removed the hanging entity
     *
     * @return 移除这个悬挂实体的实体
     */
    public Entity getRemover() {
        return remover;
    }
}
