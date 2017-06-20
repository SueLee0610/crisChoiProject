package viewnew;

import java.awt.*;

import javax.swing.ImageIcon;
 
public class Bullet {
 
        int x,y;
        Image imgBullet;
        boolean visible;
       
        public Bullet(int startX, int startY)
        {
                x = startX;
                y = startY;
                ImageIcon newBullet = new ImageIcon("./images/boom.png"); //bullet
                imgBullet = newBullet.getImage();
                visible = true;
        }
       
        public Rectangle getBounds()
        {
                return new Rectangle(x,y, 72, 74); //31과 8은 이미지 사각형 크기
        }
        public int getX()
        {
                return x;
        }
        public int getY()
        {
                return y;
        }
        public boolean getVisible()
        {
                return visible;
        }
        public Image getImage()
        {
                return imgBullet;
        }
       
        public void move()
        {
                x = x + 2; //총알 스피드
                if ( x > 1136) //배경화면의 x 너비
                        visible = false;
        }
       
        public void setVisible(boolean isVisible)//down
        {
                visible = isVisible;
        }
       
 
}