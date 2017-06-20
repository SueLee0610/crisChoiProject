package viewnew;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

//hp �߰�
public abstract class Enemy {
	
		protected int xPos,
				yPos,
				hp,
				attackPower;

		protected Image imgEnemy;
		
		protected boolean isAlive,
				isVisible;
		
        public Enemy(int startX, int startY, String location) //������ ��ġ�� ���� �ٸ��Ƿ� �����ڿ� �ƿ� �־���
        {
                xPos = startX;
                yPos = startY;
                ImageIcon l = new ImageIcon(location);
                imgEnemy = l.getImage();
                isAlive = true;
                
                //default attack power
                attackPower = 5;
        }
       
        public int getX()
        {
                return xPos;
        }
        public int getY()
        {
                return yPos;
        }
        
        public boolean isAlive()
        {
                return isAlive;
        }
        public Image getImage()
        {
                return imgEnemy;
        }
        
        public boolean isVisible() {
			return isVisible;
		}

		public void setVisible(boolean visible) {
			this.isVisible = visible;
		}

		public int getHp() {
			return hp;
		}

		public void setHp(int hp) {
			this.hp = hp;
		}
		
		private boolean isDead() {
			return hp <= 0;
		}
		
		public void takeDamage(int damage) {
			hp -= damage;
			if (isDead()) {
				isAlive = false;
			}
		}
		
		public int getAttackPower() {
			return attackPower;
		}

		public void move(int xMove, int left) //dx
        {
                if (xMove == 1 && !((left + xMove )< 150))//Added this to only move enemy when character moves forward (not back)
                xPos = xPos - xMove; //���� �������� ������
        }
 
        public abstract Rectangle getBounds();
}