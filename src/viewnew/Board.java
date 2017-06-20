package viewnew;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import javax.swing.*;
 
public class Board extends JPanel implements ActionListener, Runnable { //Panel 위에서 돌아가므로 Panel을 상속해야 
        
    public Image imgBackground; //배경화면 이미지 임포트
    
    Timer time;
    Thread animator; //애니메이션 스레드 형성
    
    Character character; //캐릭터 형성
    /*Enemy1 enemy1;
    Enemy1 enemy2;
    Boss boss1;
    */
    private List<Enemy> enemies; // = new ArrayList<>();
 
    static int v = 172; //점프할 때 바뀌는 y값 변수
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
        this.character = character; //캐릭터 클래스 불러움
        this.enemies = enemies;
        this.listener = listener;
        
        addKeyListener(new AL()); //보드에 keyListener 추가
        setFocusable(true); //왼쪽오른쪽 키 누르면 작동하게 함
        
        //Setting background image
        ImageIcon backgroundForest = new ImageIcon(backgroundImageLocation); //배경이미지 경로 지정
        imgBackground = backgroundForest.getImage(); //img가 배경화면을 불러옴
        
        time = new Timer(1, this); //5밀리세컨드 마다 이미지 업데이트, 스크롤링하는 것처럼 보임
        time.start(); //Action perform 메소드(액션리스너 implement)
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
               
    
                
                character.move(); //수행할 때마다 move 메소드 실행
                
                for (Enemy enemy : enemies) { 
                	if (enemy.isAlive()) {
                		enemy.move(character.getXMove(), character.getLeft());
                	}
                }
       	         
                repaint(); //time마다 업데이트
                
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
        		//character.setHp(character.getHp() - 10); 무한으로 줄어듦 ㄴㄴ
        		System.out.println("YOU ARE LOST");
        	}
        	if(lost2)
        		System.out.println("boss");
        	if (character.yMove == 1 && done2 == false) { //run메소드를 한 번만 할 수 있게끔 함(스레드), 그러나 더블점프할 경우 done2 불리언 사용 ㄴㄴ
        		//(character.yMove == 1 && done2 == false)
        		done2 = true;
                animator = new Thread(this);
                animator.start();
            }
        	
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g; //Graphics2D 이용
                
                for(Rectangle r: hitBoxes){
                	g2d.fill(r);
                }
                
                int backgroundRepetitions = 10;
                int backgroundResolutionWidth = 1136;
                for (int i = 0; i < backgroundRepetitions; i++) {
               		g2d.drawImage(imgBackground, backgroundResolutionWidth * i - character.getnX(), 0, null);
                }
                
                g2d.drawImage(character.getImage(), character.left, v, null); //(캐릭터, x시작점, y시작점, observer)
 
                
                if (character.getXMove() == -1) {
                        g2d.drawImage(imgBackground, 685 - character.getnX2(), 0, null);
                        g2d.drawImage(character.getImage(), character.left, v, null); //캐릭터가 왼쪽으로 갈 때
                }
               
                ArrayList bullets = Character.getBullets(); //ArrayList를 저장할 ArrayList 생성
                
                for (int i = 0; i < bullets.size(); i++)
                {
                        Bullet bullet = (Bullet) bullets.get(i); //ArrayList 내용물들을 가져옴
                        if (bullet.getVisible())
                        g2d.drawImage(bullet.getImage(),bullet.getX(), bullet.getY(), null);
                }
                g2d.setFont(font);
                g2d.setColor(Color.WHITE);
                g2d.drawString("남은 총알 수: " + character.ammo, 500, 40);
                g2d.drawString("HP: " + character.getHp(), 100, 40);
                g2d.drawString("MP: " + character.getMp(), 100, 70);
                g2d.drawString("HP 포션: " + character.getHp_potion(), 900, 40);
                g2d.drawString("MP 포션: " + character.getMp_potion(), 900, 70);
                g2d.drawString("Score: " + character.getScore(), 500, 70);
                //g2d.drawString("적 HP: " + enemy1.getHp(), 500, 100); Rewrite
               
                
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
 
        boolean jumpClimax = false; //점프의 피크에 있을 때
        boolean jumpDone = false; //점프가 완전히 끝남
 
        public void cycle() { //y값 변화시킴
 
                if (jumpClimax == false)
                        v--;
                if (v == 125) //점프의 피크에 있을 때
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