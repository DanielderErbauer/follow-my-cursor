package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class that controls movement and render of the bot.
 * @author DanielderErbauer
 *
 */
public class Bot extends GameObject {
	
	float speed;

	public Bot(int pX, int pY, Game game, float speed) {
		super(pX, pY, game);
		this.speed = speed;
	}
	
	/**
	 * Draws a white rectangle at the {@link Vector2D} position
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) position.x, (int) position.y, 10, 10);
	}
	
	/**
	 * Updates the {@link Vector2D} position
	 */
	@Override
	public void update() {
		Vector2D distance = game.getMouseCursor().position.subtract(position);
		if (!position.equals(game.getMouseCursor().position)) {		
				position = position.add(distance.normalize().multiply(speed));
		}
	}
}
