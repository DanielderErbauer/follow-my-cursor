package game;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

/**
 * Class to store the absolute position of the cursor on the JFrame.
 * @author DanielderErbauer
 *
 */
public class MouseCursor extends GameObject{

	public MouseCursor(int pX, int pY, Game game) {
		super(pX, pY, game);
	}

	@Override
	public void render(Graphics g) {}
	
	/**
	 * Updates the game to the current absolute position of the cursor on the JFrame.
	 */
	@Override
	public void update() {
		Point cursor = MouseInfo.getPointerInfo().getLocation();
		position.x = cursor.x - game.getFrame().getX();
		position.y = cursor.y - game.getFrame().getY();
	}
	
}
