package viewnew;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import javax.swing.*;
 
public class Board extends JPanel implements ActionListener, Runnable { //Panel ������ ���ư��Ƿ� Panel�� ����ؾ� 
        
    public Image imgBackground; //���ȭ�� �̹��� ����Ʈ
    
    Timer time;
    Thread animator; //�ִϸ��̼� ������ ����
    
    Character character; //ĳ���� ����
    /*Enemy1 enemy1;
    Enemy1 enemy2;
    Boss boss1;
    */
    private List<Enemy> enemies; // = new ArrayList<>();
 
    static int v = 172; //������ �� �ٲ�� y�� ����
    int minimum = -5;
    int maximum = 5;
    Random rand;
    //int randomSpeed = rand.nextInt(maximum - minimum + 1) + minimum;
    
    boolean lost = false;
    boolean a = false;
    boolean done2 = false;
    boolean lost2 = false;
       
    static Font font = new Font("SanSerif", Font.BOLD, 24);
    
    ArrayList<Rectangle> hitBoxes = new ArrayList<Rectangle>();
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private GameStateListener listener;
    
    /***
     * 
     * @param backgroundImageLocation: the location where the background image for this board is stored.
     * @param enemies is a list of enemies that will be in the board.
     */
    public Board(String backgroundImageLocation, List<Enemy> enemies, GameStateListener listener, Character character) {
        this.character = character; //ĳ���� Ŭ���� �ҷ���
        this.enemies = enemies;
        this.listener = listener;
        
        addKeyListener(new AL()); //���忡 keyListener �߰�
        setFocusable(true); //���ʿ����� Ű ������ �۵��ϰ� ��
        
        //Setting background image
        ImageIcon backgroundForest = new ImageIcon(backgroundImageLocation); //����̹��� ��� ����
        imgBackground = backgroundForest.getImage(); //img�� ���ȭ���� �ҷ���
        
        time = new Timer(1, this); //5�и������� ���� �̹��� ������Ʈ, ��ũ�Ѹ��ϴ� ��ó�� ����
        time.start(); //Action perform �޼ҵ�(�׼Ǹ����� implement)
    }
 
        public void actionPerformed(ActionEvent e) {
        	
        	checkCollisions();
                
            ArrayList bullets = Character.getBullets();
            for (int i = 0; i < bullets.size(); i++)
            {
            	Bullet bullet = (Bullet) bullets.get(i);
                if (bullet.getVisible() == true)
                	bullet.move();
                else
                	bullets.remove(i);
                }
               
    
                
                character.move(); //������ ������ move �޼ҵ� ����
                
                for (Enemy enemy : enemies) { 
                	if (enemy.isAlive()) {
                		enemy.move(character.getXMove(), character.getLeft());
                	}
                }
       	         
                repaint(); //time���� ������Ʈ
                
        }
       
 
        public void checkCollisions(){
        	try{
        		//Check bullet collision
        		ArrayList<Bullet> bullets = character.getBullets();
        		int numberOfRemainingEnemies = enemies.size();
        		if (numberOfRemainingEnemies <= 0) {
        			time.stop();
        			listener.onLevelFinished();
        		}
		        for (int i = 0; i < bullets.size(); i++)
		        {
		                Bullet bullet = bullets.get(i);
		                Rectangle bulletHitbox = bullet.getBounds();
		                
		                numberOfRemainingEnemies = enemies.size();
		                for (int j = 0; j < numberOfRemainingEnemies; j++) {
		                	Enemy enemy = enemies.get(j);
		                	Rectangle enemyHitBox = enemy.getBounds();
		                	//If bullet hit enemy
		                	if (enemyHitBox.intersects(bulletHitbox)) {
		                		enemy.takeDamage(character.getAttackPower());
		                		bullet.setVisible(false);
		                		if(enemy.isAlive() == false){
		                			enemies.remove(enemy);
		                			numberOfRemainingEnemies = enemies.size();
		                			character.increaseScore(10);
		                		}
		                	}
		                }
		        }
		        
		        
		        
		        //Checks character collision
		        for (int i = 0; i < enemies.size(); i++) {
			        //If character hits enemy
			        if (enemies.get(i).getBounds().intersects(character.getBounds())){
	            		character.attackedByEnemy(enemies.get(i));
	            		if (character.isDead()) {
	            			time.stop();
	            			listener.onGameOver();
	            		}
	            	}
		        }
		              
		  
        }
	    catch(NullPointerException e)
        {
	    	System.out.print("NullPointerException caught");
	   	}
    }
 
        public void paint(Graphics g) {
        	if (lost){
        		//character.setHp(character.getHp() - 10); �������� �پ�� ����
        		System.out.println("YOU ARE LOST");
        	}
        	if(lost2)
        		System.out.println("boss");
        	if (character.yMove == 1 && done2 == false) { //run�޼ҵ带 �� ���� �� �� �ְԲ� ��(������), �׷��� ���������� ��� done2 �Ҹ��� ��� ����
        		//(character.yMove == 1 && done2 == false)
        		done2 = true;
                animator = new Thread(this);
                animator.start();
            }
        	
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g; //Graphics2D �̿�
                
                for(Rectangle r: hitBoxes){
                	g2d.fill(r);
                }
                
                int backgroundRepetitions = 10;
                int backgroundResolutionWidth = 1136;
                for (int i = 0; i < backgroundRepetitions; i++) {
               		g2d.drawImage(imgBackground, backgroundResolutionWidth * i - character.getnX(), 0, null);
                }
                
                g2d.drawImage(character.getImage(), character.left, v, null); //(ĳ����, x������, y������, observer)
 
                
                if (character.getXMove() == -1) {
                        g2d.drawImage(imgBackground, 685 - character.getnX2(), 0, null);
                        g2d.drawImage(character.getImage(), character.left, v, null); //ĳ���Ͱ� �������� �� ��
                }
               
                ArrayList bullets = Character.getBullets(); //ArrayList�� ������ ArrayList ����
                
                for (int i = 0; i < bullets.size(); i++)
                {
                        Bullet bullet = (Bullet) bullets.get(i); //ArrayList ���빰���� ������
                        if (bullet.getVisible())
                        g2d.drawImage(bullet.getImage(),bullet.getX(), bullet.getY(), null);
                }
                g2d.setFont(font);
                g2d.setColor(Color.WHITE);
                g2d.drawString("���� �Ѿ� ��: " + character.ammo, 500, 40);
                g2d.drawString("HP: " + character.getHp(), 100, 40);
                g2d.drawString("MP: " + character.getMp(), 100, 70);
                g2d.drawString("HP ����: " + character.getHp_potion(), 900, 40);
                g2d.drawString("MP ����: " + character.getMp_potion(), 900, 70);
                g2d.drawString("Score: " + character.getScore(), 500, 70);
                //g2d.drawString("�� HP: " + enemy1.getHp(), 500, 100); Rewrite
               
                
                //Draw enemies
                for (Enemy enemy : enemies) {
                	if (enemy.isAlive()) {
                		g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
                	}
                }
        }
 
        private class AL extends KeyAdapter {
                public void keyReleased(KeyEvent e) {
                        character.keyReleased(e);
                }
 
                public void keyPressed(KeyEvent e) {
                        character.keyPressed(e);
                }
        }
 
        boolean jumpClimax = false; //������ ��ũ�� ���� ��
        boolean jumpDone = false; //������ ������ ����
 
        public void cycle() { //y�� ��ȭ��Ŵ
 
                if (jumpClimax == false)
                        v--;
                if (v == 125) //������ ��ũ�� ���� ��
                        jumpClimax = true;
                if (jumpClimax == true && v <= 172) {
                        v++;
                if (v == 172) 
                        jumpDone = true;
                       
                }
        }
 
        public void run() {
 
                long beforeTime, timeDiff, sleep;
 
                beforeTime = System.currentTimeMillis();
 
                while (jumpDone == false) {
 
                        cycle();
 
                        timeDiff = System.currentTimeMillis() - beforeTime;
                        sleep = 10 - timeDiff;
 
                        if (sleep < 0)
                                sleep = 2;
                        try {
                                Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                        }
 
                        beforeTime = System.currentTimeMillis();
                }
                jumpDone = false;
                jumpClimax = false;
                done2 = false;
        }
 
}