package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 一个方块被玩家破坏的时候，调用本事件.
 * <p>
 * 如果你想要在方块被破坏之后掉落经验, 你必须设置经验值
 * 为0以上。 默认情况下, 如果事件是这样的，经验会被设置：
 * <ol>
 * <li>玩家不能是创造/冒险模式
 * <li>玩家不能“掠夺”此方块 (注: 就是没有用当前的工具把方块完全破坏)
 * <li>玩家没有精准采集
 * <li>方块在普通的Minecraft中掉落经验
 * </ol>
 * <p>
 * 注意:
 * Plugins wanting to simulate a traditional block drop should set the block
 * to air and utilize their own methods for determining what the default drop
 * for the block being broken is and what to do about it, if anything.
 * <p>
 * 如果方块破坏事件（即本事件）被取消，这个方块将不会被破坏，并且经验不会掉落。
 */
public class BlockBreakEvent extends BlockExpEvent implements Cancellable {
    private final Player player;
    private boolean cancel;

    public BlockBreakEvent(final Block theBlock, final Player player) {
        super(theBlock, 0);

        this.player = player;
    }

    /**
     * 获取破坏这个方块的玩家
     *
     * @return 破坏这个方块的玩家
     */
    public Player getPlayer() {
        return player;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
