package ArrayCode1;

import java.util.Random;
import java.util.Scanner;

public class FrozenTreasureGame {
    Player player;
    IceBlock[] iceBlocks;
    int treasureX;
    int treasureY;
    private int gridSize;

    public FrozenTreasureGame(int gridSize) {
        this.gridSize = gridSize;
        player = new Player(gridSize / 2, gridSize / 2);
        iceBlocks = new IceBlock[gridSize * gridSize / 4];
        for (int i = 0; i < iceBlocks.length; i++) {
            iceBlocks[i] = new IceBlock(new Random().nextInt(gridSize), new Random().nextInt(gridSize));
        }
        treasureX = new Random().nextInt(gridSize);
        treasureY = new Random().nextInt(gridSize);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Current position: (" + player.getX() + ", " + player.getY() + ")");
            System.out.println("Enter direction (W/A/S/D):");
            char direction = scanner.next().charAt(0);
            switch (direction) {
                case 'W':
                    player.move(0, -1);
                    break;
                case 'A':
                    player.move(-1, 0);
                    break;
                case 'S':
                    player.move(0, 1);
                    break;
                case 'D':
                    player.move(1, 0);
                    break;
            }
            if (isFrozen()) {
                System.out.println("You froze!");
                break;
            }
            if (isTreasureFound()) {
                System.out.println("You found the treasure!");
                break;
            }
        }
    }

    protected boolean isFrozen() {
        for (IceBlock iceBlock : iceBlocks) {
            if (player.getX() == iceBlock.getX() && player.getY() == iceBlock.getY()) {
                return true;
            }
        }
        return false;
    }

    boolean isTreasureFound() {
        return player.getX() == treasureX && player.getY() == treasureY;
    }

    public static void main(String[] args) {
        FrozenTreasureGame game = new FrozenTreasureGame(10);
        game.play();
    }
}
