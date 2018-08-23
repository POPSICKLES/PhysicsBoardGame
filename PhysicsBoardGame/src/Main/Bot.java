package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bot extends GameObject {

	Handler handler;

	public Bot(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;
		
		Random r = new Random();
		velY = r.nextInt(11) - 5;
		velX = r.nextInt(11) - 5;
	}

	/*public void collision() {
		for(int i = 0; i < this.handler.objects.size(); i++) {
			GameObject tempObject = this.handler.objects.get(i);

			if(tempObject.getId() == ID.Bot2 && this.getBoundaries().intersects(tempObject.getBoundaries())) {
				this.velY *= -1;
				this.velX *= -1;
				tempObject.velY *= -1;
				tempObject.velX *= -1;
			}
		}
	}*/

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(x <= 0 || x >= Game.WIDTH-32) this.velX *= -1;
		if(y <= 0 || y >= Game.HEIGHT-32) this.velY*= -1;
		
		x = walls(x, 0, Game.WIDTH - 32);
		y = walls(y, 0, Game.HEIGHT - 32);
		
		if(this.getId() == ID.Bot) {
			this.handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.02f, this.handler));
		}
		if(this.getId() == ID.Bot2) {
			this.handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, this.handler));
		}
		if(this.getId() == ID.Bot3) {
			this.handler.addObject(new Trail(x, y, ID.Trail, Color.white, 16, 16, 0.02f, this.handler));
		}
		
		
		//collision();
	}

	@Override
	public void render(Graphics g) {
		if(this.getId() == ID.Bot) {
			g.setColor(Color.cyan);
			g.fillOval(x, y, 16, 16);
		}
		if(this.getId() == ID.Bot2) {
			g.setColor(Color.red);
			g.fillOval(x, y, 16, 16);
		}
		if(this.getId() == ID.Bot3) {
			g.setColor(Color.white);
			g.fillOval(x, y, 16, 16);
		}
	}

	@Override
	public Rectangle getBoundaries() {
		return new Rectangle(x, y, 32, 32);
	}


}
