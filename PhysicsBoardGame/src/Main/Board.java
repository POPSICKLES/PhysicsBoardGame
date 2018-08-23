package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Board extends GameObject{

	private ArrayList<String> vector;
	private ArrayList<Integer> place, mf;
	private Game game;

	public Board(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		if(this.vector == null && this.place == null && this.mf == null) {
			this.overLay();
		}
	}
	public void render(Graphics g) {
		Font fnt = new Font("ariel", 1, 10);
		g.setFont(fnt);
		boolean switcheroo = false;
		g.setColor(Color.black);
		g.fillRect(0, 0,  1000, 1000);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x-10, y-10, 620, 620);
		g.setColor(Color.green);
		g.fillRect(x, y, 600, 600);
		g.setColor(Color.black);
		for(int i = 0; i < 10 ; i++) {
			for(int j = 0; j < 10; j++) {
				if((10*i + j - 2) % 3 == 0) {
					if(!switcheroo) {
						g.setColor(Color.CYAN);
						g.fillRect(x + j*60, y + (9 - i)*60 , 60, 60);
						g.setColor(Color.black);
						g.drawRect(x + j*60, y + (9 - i)*60 , 60, 60);
						g.drawString(10*i + j +"", x + j*60, y + (10 - i)*60);
					}else {
						g.setColor(Color.CYAN);
						g.fillRect(x + (9 - j)*60, y + (9 - i)*60 , 60, 60);
						g.setColor(Color.black);
						g.drawRect(x + (9 - j)*60, y + (9 - i)*60 , 60, 60);
						g.drawString(10*i + j +"", x + (9 - j)*60, y + (10 - i)*60);
					}
					

				}
				else if((10*i + j - 1) % 3 == 0) {
					if(!switcheroo) {
						g.setColor(Color.white);
						g.fillRect(x + j*60, y + (9 - i)*60 , 60, 60);
						g.setColor(Color.black);
						g.drawRect(x + j*60, y + (9 - i)*60 , 60, 60);
						g.drawString(10*i + j +"", x + j*60, y + (10 - i)*60);
					}else {
						g.setColor(Color.white);
						g.fillRect(x + (9 - j)*60, y + (9 - i)*60 , 60, 60);
						g.setColor(Color.black);
						g.drawRect(x + (9 - j)*60, y + (9 - i)*60 , 60, 60);
						g.drawString(10*i + j +"", x + (9 - j)*60, y + (10 - i)*60);
					}
				}
				else if((10*i + j - 3) % 3 == 0) {
					if(!switcheroo) {
						g.setColor(Color.pink);
						g.fillRect(x + j*60, y + (9 - i)*60 , 60, 60);
						g.setColor(Color.black);
						g.drawRect(x + j*60, y + (9 - i)*60 , 60, 60);
						g.drawString(10*i + j +"", x + j*60, y + (10 - i)*60);
					}else {
						g.setColor(Color.pink);
						g.fillRect(x + (9 - j)*60, y + (9 - i)*60 , 60, 60);
						g.setColor(Color.black);
						g.drawRect(x + (9 - j)*60, y + (9 - i)*60 , 60, 60);
						g.drawString(10*i + j +"", x + (9 - j)*60, y + (10 - i)*60);
					}
				}
				
				if(!switcheroo) {
					if(j == 0 && (i != 0 && i != 9)) {
						g.setColor(Color.red);
						g.drawString("+1", x + 45, y + (9 - i)*60 + 10);
					}
					if(j == 9 && (i != 0 && i != 9)) {
						g.setColor(Color.blue);
						g.drawString("-1", x + j*60 + 50, y + (9 - i)*60 + 10);
					}
				}
				else{
					if(j == 0 && (i != 0 && i != 9)) {
						g.setColor(Color.red);
						g.drawString("+1", x + 9*60 + 45, y + (9 - i)*60 + 10);
					}
					if(j == 9 && (i != 0 && i != 9)) {
						g.setColor(Color.blue);
						g.drawString("-1", x + 0*60 + 45, y + (9 - i)*60 + 10);
					}
				}

				for(int k = 0; k < place.size(); k++) {
					if(10*i + j == this.place.get(k)) {
						g.drawString(vector.get(k),x + j*60, y + (9 - i)*60 + 10);
						if(this.mf.get(k) == 1) {
							g.fillOval(x + j*60 + 50, y + (9 - i)*60, 10, 10);
						}else g.drawOval(x + j*60 + 50, y + (9 - i)*60, 10, 10);
					}
				}
			}
			switcheroo = !switcheroo;
		}
		
		//roll button
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(190, 120, 100, 50);
		g.setColor(Color.white);
		g.fillRect(195, 125, 90, 40);
		
		Font fnt2 = new Font("ariel", 1, 30);
		g.setFont(fnt2);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("ROLL", 195, 156);
		g.drawString("A " + Menu.roll + " was rolled,", 400, 156);
	}

	public void overLay() {
		this.vector = new ArrayList<String>();
		this.place = new ArrayList<Integer>();
		this.mf = new ArrayList<Integer>();
		Random r = new Random();
		for(int i = 0; i < 10 ; i++) {
			for(int j = 1; j < 9; j++) {
				if(r.nextInt(6) > 1) {
					this.place.add(10*i + j);
					int vector = r.nextInt(4);
					int mf = r.nextInt(2);
					if(vector == 0) {
						this.vector.add("UP");
					}
					else if(vector == 1) {
						this.vector.add("RIGHT");
					}
					else if(vector == 2) {
						this.vector.add("DOWN");
					}
					else if(vector == 3) {
						this.vector.add("LEFT");
					}

					if(mf == 1) {
						this.mf.add(1);
					}else this.mf.add(0);
				}
			}
		}
	}

	@Override
	public Rectangle getBoundaries() {
		// TODO Auto-generated method stub
		return null;
	}
}
