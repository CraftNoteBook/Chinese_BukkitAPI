package org.bukkit.event.hanging;

import org.bukkit.entity.Hanging;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个物品展示框被破坏时调用.
 */
public class HangingBreakEvent extends HangingEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final HangingBreakEvent.RemoveCause cause;

    public HangingBreakEvent(final Hanging hanging, final HangingBreakEvent.RemoveCause cause) {
        super(hanging);
        this.cause = cause;
    }

    /**
     * 获取这个物品展示框被破坏的原因.
     * <p>
     * 原文：Gets the cause for the hanging entity's removal
     *
     * @return 这个物品展示框被破坏的原因
     */
    public HangingBreakEvent.RemoveCause getCause() {
        return cause;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * 指定破坏原因的一个枚举
     */
    public enum RemoveCause {
        /**
         * 被一个实体破坏
         */
        ENTITY,
        /**
         * 因为爆炸而破坏
         */
        EXPLOSION,
        /**
         * 放置方块时自动脱落
         */
        OBSTRUCTION,
        /**
         * 破坏它背后的方块而自动脱落
         */
        PHYSICS,
        /**
         * 未分类（未知）的破坏原因（默认）
         */
        DEFAULT,
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
