package model;

import java.awt.*;

import javax.swing.ImageIcon;
 
public class MiddleBossSoldier extends Enemy {
		
		private int xMove, nx, backgroundXPos, left, yMove;
       
        //hp �߰�
        public MiddleBossSoldier(int startX, int startY) //������ ��ġ�� ���� �ٸ��Ƿ� �����ڿ� �ƿ� �־���
        {
        		super(startX, startY, "./images/boss.png");
               	
        		hp = 60;
        
                left = 150; //��ũ������ �������� �� �� ��ġ ����
        }
        
        @Override
        public Rectangle getBounds()
        {
                return new Rectangle(xPos,yPos, 223, 243);
        }    
       
}