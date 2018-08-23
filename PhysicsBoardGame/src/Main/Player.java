package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = walls(x, 200, Game.WIDTH - 224);
		y = walls(y, 200, Game.HEIGHT - 224);
		
		
	}
	
	public void render(Graphics g) {
		if(this.id == ID.Player1) {
			g.setColor(Color.red);
			g.fillOval(x, y, 24, 24);
		}
		if(this.id == ID.Player2) {
			g.setColor(Color.blue);
			g.fillOval(x, y, 24, 24);
		}
	}

	@Override
	public Rectangle getBoundaries() {
		// TODO Auto-generated method stub
		return null;
	}

}
