package model;

import java.awt.*;

import javax.swing.ImageIcon;

import java.util.ArrayList;

public class Dwarf extends Enemy{
	
		int dwarfWidth = 198;
		int dwarfHeight = 181;
		
	
		public Dwarf(int startX, int startY, String location) {
			super(startX, startY, location);
			hp = 10;
		}
 
		@Override
        public Rectangle getBounds()
        {
                return new Rectangle(xPos,yPos, dwarfWidth, dwarfHeight);
        }
       
}