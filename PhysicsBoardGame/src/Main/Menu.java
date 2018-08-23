package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import Main.Game.STATE;

public class Menu extends MouseAdapter {

	private Game game;
	private Handler handler;
	public static int roll;


	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		//Play button
		if(mouseOver(mx, my, 350, 390, 300, 60) && this.game.gameState == STATE.Menu) {
			this.game.gameState = STATE.Game;
			this.handler.clear();
			handler.addObject(new Board(Game.WIDTH/2 - 300, Game.HEIGHT/2 - 300, ID.Board));
			handler.addObject(new Player(Game.WIDTH/2 - 282, Game.HEIGHT/2 + 258, ID.Player1));
			handler.addObject(new Player(Game.WIDTH/2 + 258, Game.HEIGHT/2 - 282, ID.Player2));
		}

		//Help button
		if(mouseOver(mx, my, 350, 475, 300, 60) && this.game.gameState == STATE.Menu) {
			this.game.gameState = STATE.Help;
			this.handler.clear();
			Random r = new Random();
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot2, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot3, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot2, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot3, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot2, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot3, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot2, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot3, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot2, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot3, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot2, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot3, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot2, this.handler));
			this.handler.addObject(new Bot(r.nextInt(Game.WIDTH - 64) + 32, r.nextInt(Game.HEIGHT - 64) + 32, ID.Bot3, this.handler));
		}
		//Quit Button
		if(mouseOver(mx, my, 350, 560, 300, 60) && this.game.gameState == STATE.Menu) {
			System.exit(1);
		}
		
		if(mouseOver(mx, my, 50, 860, 100, 50) && this.game.gameState == STATE.Help) {
			this.game.gameState = STATE.Menu;
		}
		
		if(mouseOver(mx, my, 190, 120, 100, 50) && this.game.gameState == STATE.Game) {
			Random r = new Random();
			int rolls = r.nextInt(6) + 1;
			roll = rolls;
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}
			else return false;
		}
		else return false;	
	}

	public void tick() {
		if(this.game.gameState == STATE.Help) {
			this.handler.tick();
		}

	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 1000);
		if(this.game.gameState == STATE.Menu) {
			//back design
			g.setColor(Color.CYAN);
			for(int k = 951; k > - 1000; k-= 100) {
				for(int i = 0; i < 20; i++) {
					for(int j = 0; j < 50; j++) {
						g.fillRect(0 + j*20, k + j*20, 20, 20);
						g.fillRect(0 + j*20, k + (j-1)*20, 20, 20);
					}
				}
			}
			//Boarders of menu
			g.setColor(Color.pink);
			g.fillRect(150, 300, 700, 400);
			g.setColor(Color.black);
			g.fillRect(160, 310, 680, 380);
			g.setColor(Color.pink);
			g.drawRect(350, 390, 300, 60);
			g.drawRect(350, 475, 300, 60);
			g.drawRect(350, 560, 300, 60);
			//Menu buttons
			Font fnt = new Font("ariel", 1, 100);
			Font fnt2 = new Font("ariel", 1, 60);
			g.setFont(fnt);
			g.setColor(Color.pink);
			g.drawString("MENU", 352, 250);
			g.setFont(fnt2);
			g.drawString("PLAY", 425, 442);
			g.drawString("HELP", 425, 527);
			g.drawString("QUIT", 425, 612);
		}
		else if(this.game.gameState == STATE.Help) {
			//back design
			this.handler.render(g);
			g.setColor(Color.white);
			for(int k = 951; k > - 1000; k-= 100) {
				for(int i = 0; i < 20; i++) {
					for(int j = 0; j < 50; j++) {
						g.fillRect(0 + j*20, k + j*20, 20, 20);
						g.fillRect(0 + j*20, k + (j-1)*20, 20, 20);
					}
				}
			}
			//back button
			g.setColor(Color.white);
			g.fillRect(50, 860, 100, 50);
			g.setColor(Color.red);
			g.drawRect(50, 860, 100, 50);
			Font fnt = new Font("ariel", 1, 30);
			g.setFont(fnt);
			g.drawString("BACK", 56, 895);
			//boarder of rules
			g.setColor(Color.red);
			g.fillRect(200, 90, 600, 820);
			g.setColor(Color.white);
			g.fillRect(205, 95, 590, 810);
			//instructions/rules for game
			int a = 305;
			int b = 185;
			Font fnt2 = new Font("ariel", 1, 20);
			g.setFont(fnt2);
			g.setColor(Color.black);
			g.drawString("You are a proton and your opponent is", a, b);
			g.drawString("an electron. Your goal is to reach the", a, b+20);
			g.drawString("100th box, before the electron gets to", a, b+40);
			g.drawString("block 1. You will each take turn to roll", a, b+60);
			g.drawString("the dice, proton follows the blocks in", a, b+80);
			g.drawString("increasing order, electron in decreasing.", a, b+100);
			g.drawString("As you progress you will land on two", a, b+120);
			g.drawString("special blocks, acceleration blocks,", a, b+140);
			g.drawString("and magnetic field blocks. Acceleration", a, b+160);
			g.drawString("blocks will either increase or decrease", a, b+180);
			g.drawString("your velocity by 1, meaning from now on", a, b+200);
			g.drawString("every time you roll the dice, you multiply", a, b+220);
			g.drawString("the result by your velocity. What you roll", a, b+240);
			g.drawString("corresponds to how many blocks you", a, b+260);
			g.drawString("move. All players start with a velocity of", a, b+280);
			g.drawString("1. Magnetic field blocks has 2 values", a, b+300);
			g.drawString("located on two of its corners. It'll have", a, b+320);
			g.drawString("a direction, and a colored/uncolored", a, b+340);
			g.drawString("circle, indicating the direction of the", a, b+360);
			g.drawString("magnetic field.If you or an opponent land", a, b+380);
			g.drawString("on that block, roll the dice once more,", a, b+400);
			g.drawString("the number you rolled multiplied by your", a, b+420);
			g.drawString("velocity will be the velocity used to", a, b+440);
			g.drawString("determine the number of blocks you move.", a, b+460);
			g.drawString("The direction is determined by the direction", a, b+480);
			g.drawString("of the magnetic force. If you happen to land", a, b+500);
			g.drawString("on another special block, ignore its affects.", a, b+520);
			g.drawString("If you land on a magnetic block and the final", a, b+540);
			g.drawString("velocity exceed the number of blocks on the path,", a, b+560);
			g.drawString("go as far as you can, but you will be stunned", a, b+580);
			g.drawString("meaning your next turn will be skipped. This can", a, b+600);
			g.drawString("also happen if you stepp on a negative acceleration", a, b+620);
			g.drawString("block, where your velocity reaches 0.", a, b+640);
		}
	}
}
