package model;

import java.awt.*;

import javax.swing.ImageIcon;
 
public class Boss extends Enemy {
		
		private int xMove, nx, backgroundXPos, left, yMove;
       
        //hp �߰�
        public Boss(int startX, int startY, String location) //������ ��ġ�� ���� �ٸ��Ƿ� �����ڿ� �ƿ� �־���
        {
        		super(startX, startY, location);
               	
        		hp = 60;
        
                left = 150; //��ũ������ �������� �� �� ��ġ ����
        }
        
        @Override
        public Rectangle getBounds()
        {
                return new Rectangle(xPos,yPos, 223, 243);
        }    
       
}