package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected int velX, velY;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public static int walls(int var, int min, int max) {
		if(var >= max) {
			return max;
		}
		if(var <= min) {
			return min;
		}
		else {
			return var;
		}
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBoundaries(); 
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return this.id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return this.velX;
	}
	public int getVelY() {
		return this.velY;
	}
}
