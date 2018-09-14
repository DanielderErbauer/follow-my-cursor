package game;

import java.awt.Graphics;

/**
 * Class for everything that needs to be updated frequently and/or needs to render something.
 * @author DanielderErbauer
 *
 */
public abstract class GameObject {
	
	public Vector2D position;
	public Game game;
	
	public GameObject(Vector2D pos, Game game) {
		this.position = pos;
		this.game = game;
	}
	
	public GameObject(int pX, int pY, Game game) {
		this.position = new Vector2D(pX, pY);
		this.game = game;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);

	/**
	 * @return the position
	 */
	public Vector2D getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Vector2D position) {
		this.position = position;
	}
}
