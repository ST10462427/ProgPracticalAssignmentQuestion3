package ArrayCode1;


import org.junit.Test;
import static org.junit.Assert.*;

public class FrozenTreasureGameTest {
    @Test
    public void Player() {
        FrozenTreasureGame game = new FrozenTreasureGame(10);
        game.player = new Player(1, 1);
        game.iceBlocks[0] = new IceBlock(1, 1);
        assertTrue(game.isFrozen());
    }

    @Test
    public void FrozenTreasureGame() {
        FrozenTreasureGame game = new FrozenTreasureGame(10);
        game.player = new Player(1, 1);
        game.treasureX = 1;
        game.treasureY = 1;
        assertTrue(game.isTreasureFound());
    }
}