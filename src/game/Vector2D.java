package game;

/**
 * The Vector2D class. The base logic behind the Bot.
 * @author DanielderErbauer
 *
 */
public class Vector2D implements Cloneable{
	
	public float x;
	public float y;
	
	/**
	 * Constructor which takes a x float and a y float to initialize the Vector 
	 * @param x The x value
	 * @param y The y value
	 */
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor which takes another Vector2D instance to initialize the Vector 
	 * @param v The Vector2D instance
	 */
	public Vector2D(Vector2D v) {
		this.x = v.x;
		this.y = v.y;
	}
	
	/**
	 * Adds the given Vector to the instance of this class
	 * @param v The Vector to add
	 * @return A new Vector2D instance, containing the result
	 */
	public Vector2D add(Vector2D v) {
		return new Vector2D(this.x + v.x, this.y + v.y);
	}
	
	/**
	 * Subtracts the given Vector from the instance of this class
	 * @param v The Vector to subtract
	 * @return A new Vector2D instance, containing the result
	 */
	public Vector2D subtract(Vector2D v) {
		return new Vector2D(this.x - v.x, this.y - v.y);
	}
	
	/**
	 * Calculates the length of the Vector
	 * @return A double representing the length
	 */
	public double length() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	/**
	 * Multiplies the Vector by the value of the skalar
	 * @param skalar A float value representing the skalar
	 * @return A new Vector instance, containing the result
	 */
	public Vector2D multiply(float skalar) {
		return new Vector2D(this.x * skalar, this.y * skalar);
	}
	
	/**
	 * Divides the Vector by the value of the skalar 
	 * @param skalar A float value representing the skalar
	 * @return A new Vector instance, containing the result OR null, if the given skalar is 0
	 */
	public Vector2D divide(float skalar) {
		if(skalar == 0) return null;
		
		return new Vector2D(this.x / skalar, this.y / skalar);
	}
	
	/**
	 * Normalizes the Vector, so the length is 1
	 * @return A new Vector instance, containing the result
	 */
	public Vector2D normalize() {
		return this.divide((float) this.length());
	}
	
	/**
	 * Calculates the midpoint between two Vectors
	 * @param Another Vector instance
	 * @return A new Vector instance, containing the result
	 */
	public Vector2D midpoint(Vector2D v) {
		return new Vector2D((this.x + v.x)/2,(this.y + v.y)/2);
	}
	
	public Vector2D clone() {
		return new Vector2D(this);
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null) {
			return false;
		} else if (this == other) {
			return true;
		} else if (this.x == ((Vector2D) other).x && this.y == ((Vector2D) other).y) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return new StringBuffer().append("Vector2D[X=" + this.x + ",Y=" + this.y + "]").toString();
	}
	
}
