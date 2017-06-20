package model;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import view.Board;
 
public class Character {
        
	int xPos, xMove, yPos, nx, backgroundXPos, left, yMove;//dx = Ű �� �� ���� ������ �����̴� ���� 
    Image imgLeft, imgJump,reverse;
       
        protected int ammo;
        protected int hp;
		protected int mp;
		protected int attackPower;
        private int hp_potion = 4;
        private int mp_potion = 4;
        private int score = 0;
        ImageIcon characterRight; // = new ImageIcon("./images/warrior_right.png"); //ĳ���� �̹���
        ImageIcon characterJump; //= new ImageIcon("./images/warrior_right.png");
        ImageIcon characterLeft; //= new ImageIcon("./images/warrior_left.png");
        
        protected String characterClass;
        
        private static Character instance;
       
        static ArrayList bullets;
        
        private int invincibilityTimeInMilliseconds = 2000;
        
        private Enemy lastAttackingEnemy;
       
        protected Character() { //��
        	//characterClass = "warrior";
            xPos = 40;
            left = 150; //��ũ������ �������� �� �� ��ġ ����
            nx = 0;
            backgroundXPos= 685; //����̹��� �ʺ񺸴� ���� �۰� ����
            yPos = 172;
            bullets = new ArrayList(); //bullet �ʱ�ȭ
        }
       
        public Rectangle getBounds() //
        {
                return new Rectangle(left, yPos, 63, 154); //ĳ������ �簢�� �̹��� ũ��
        }  
       
        public static ArrayList getBullets()
        {
                return bullets;
        }
       
        public void choose_hpPotion(){
        	if(hp_potion > 0){
        		hp += 5;
        		hp_potion --;
        	}
        }
        
        public void choose_mpPotion(){
        	if(mp_potion > 0){
        		mp += 10;
        		mp_potion --;
        		ammo ++;
        	}
        }
        
        public int getAttackPower() {
			return attackPower;
		}

		public void setAttackPower(int attackPower) {
			this.attackPower = attackPower;
		}

		public void fire()
        {
                if (ammo > 0)
                {
                	mp -= 10;
             
                ammo--; //�Ѿ� ����
                //The v is from the board class, which corresponds to the character's
                //position when it is jumping, resulting in the bullet being formed
                //at a higher position when the character is at the peak of its jump
                Bullet z = new Bullet((left + 60), (Board.v + 154/2));
                bullets.add(z);
        }}
        
        public void move() {
                if (xMove != -1){
                	if (left + xMove <= 150){
                		left+=xMove; //ĳ���͸� ������ ���������� ������
                	}else{
                		xPos = xPos + xMove; //
                		backgroundXPos= backgroundXPos+xMove;
                        nx = nx + xMove; //�� �� ���� ���ȭ���� ������ ����
                	}
                }else{
                	if (left+xMove >0){
                		left = left + xMove; //��ũ�� ������ ����
                	}
                } 
        }
        
        public int getHp_potion() {
			return hp_potion;
		}

		public void setHp_potion(int hp_potion) {
			this.hp_potion = hp_potion;
		}

		public int getMp_potion() {
			return mp_potion;
		}

		public void setMp_potion(int mp_potion) {
			this.mp_potion = mp_potion;
		}

		public int getXPos() {
                return xPos;
        }
       
        public int getLeft(){
                return left;
        }
 
        public int getnX() {
                return nx;
        }
       
        public int getnX2() {
                return backgroundXPos;
        }
 
        public int getXMove() {
                return xMove;
        }
        
        public int getYMove() {
        	return yMove;
        }
        
        public int getHp() {
			return hp;
		}

		public void setHp(int hp) {
			this.hp = hp;
		}
		
		public void reduceHealth(int damage) {
			this.hp -= damage;
		}
		
		public boolean isDead() {
			return hp <= 0;
		}
		
		public int getAmmo() {
			return ammo;
		}
		
		public void attackedByEnemy(Enemy enemy) {
			TimerTask resetAttackBlockTask = new TimerTask() {

				@Override
				public void run() {
					//character can be attacked again by the same enemy
					lastAttackingEnemy = null;
				}
				
			};
			Timer timer = new Timer();
			//Nobody has attacked before
			if (lastAttackingEnemy == null) {
				reduceHealth(enemy.getAttackPower()); //Later change to enemy.getAttackPower()
				lastAttackingEnemy = enemy;
				timer.schedule(resetAttackBlockTask, invincibilityTimeInMilliseconds);
			}
			else if (enemy != lastAttackingEnemy) {
				reduceHealth(enemy.getAttackPower());
				lastAttackingEnemy = enemy;
				timer.schedule(resetAttackBlockTask, invincibilityTimeInMilliseconds);
			}
		}

		public int getMp() {
			return mp;
		}

		public void setMp(int mp) {
			this.mp = mp;
		}

		public Image getImage() {
                return imgLeft;
        }
		
		public int getScore() {
			return this.score;
		}
		
		public void increaseScore(int score) {
			this.score += score;
		}
		
		public void resetScore() {
			score = 0;
		}
		
		public void resetStats() {
			ammo = 10;
			mp = 100;
		}
 
        public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode(); //��ȣ�� ������
                if (key == KeyEvent.VK_LEFT)
                {               xMove = -1; //�������� �̵�
                imgLeft = characterLeft.getImage();           }
               
                if (key == KeyEvent.VK_RIGHT)
                        {xMove = 1; //���������� �̵�
                        imgLeft = characterRight.getImage(); //�������� ���� �̹����� ����ȯ
                        }
               
                if (key == KeyEvent.VK_SPACE)
                {
                        fire();
                }
               
                if (key == KeyEvent.VK_UP)
                        {yMove = 1;
                        imgLeft = characterJump.getImage();
                        }
                if (key == KeyEvent.VK_H)
                {
                	choose_hpPotion();
                }  
                if (key == KeyEvent.VK_M)
                {
                	choose_mpPotion();
                } 
        }
                
        
 
        public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
 
                if (key == KeyEvent.VK_LEFT)
                        xMove = 0; //�� ������
 
                if (key == KeyEvent.VK_RIGHT)
                        xMove = 0; //�� ������
               
                if (key == KeyEvent.VK_UP)
                {
                	yMove = 0;
                    imgLeft = characterRight.getImage();}
                }
        }