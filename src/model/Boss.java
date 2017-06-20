package model;

import java.awt.*;

import javax.swing.ImageIcon;
 
public class Boss extends Enemy {
		
		private int xMove, nx, backgroundXPos, left, yMove;
       
        //hp 추가
        public Boss(int startX, int startY, String location) //적마다 위치가 각각 다르므로 생성자에 아예 넣어줌
        {
        		super(startX, startY, location);
               	
        		hp = 60;
        
                left = 150; //스크린에서 왼쪽으로 갈 때 위치 고정
        }
        
        @Override
        public Rectangle getBounds()
        {
                return new Rectangle(xPos,yPos, 223, 243);
        }    
       
}