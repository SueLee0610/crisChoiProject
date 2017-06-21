package controller;

import java.util.ArrayList;

import javax.swing.*;

import model.Bird;
import model.MiddleBossSoldier;
import model.Turtle;
import model.Character;
import model.DBHandler;
import model.Dog;
import model.Dwarf;
import model.Enemy;
import model.Gunner;
import model.Magician;
import model.Mammoth;
import model.Warrior;
import view.Board;
import view.GameFinishedScreen;
import view.GameOverScreen;
import view.StartScreen;

public class GUImain implements GameStateListener {
 
		
		private JFrame jframe;
		private JFrame gameFrame;
		private Character character;
		private int currentLevel;
		
        public GUImain(){
        	jframe = new StartScreen(this);
        }
    
        
		@Override
		public void onLevelFinished() {   
			currentLevel ++;
			switch(currentLevel){
				case 2:
					ArrayList<Enemy> enemies = new ArrayList<>();
		            enemies.add(new Bird(300, 250));
		            enemies.add(new Bird(1200, 220));
		            enemies.add(new Turtle(700, 200));
		            character.resetStats();
		            Board level2 = new Board("./images/sky.png", enemies, this, character);
		            gameFrame.dispose();
		            gameFrame.add(level2); //frame에 board형성
		            gameFrame.setVisible(true);
		            break;
		            
				case 3:
					ArrayList<Enemy> enemies3 = new ArrayList<>();
		            enemies3.add(new Dwarf(1600, 200));
		            enemies3.add(new Bird(300, 250));
		            enemies3.add(new MiddleBossSoldier(2000, 150));
		            character.resetStats();
		            Board level3 = new Board("./images/sky.png", enemies3, this, character);
		            gameFrame.dispose();
		            gameFrame.add(level3); //frame에 board형성
		            gameFrame.setVisible(true);
		            break;
				case 4:
					gameFrame.dispose();
					new GameFinishedScreen();
		        default:
		            break;
			}
           
		}
		
		@Override
		public void onCharacterSelectionPerformed(String characterClass) {
			switch(characterClass) {
				case "warrior":
					character = Warrior.getInstance();
					break;
				case "magician":
					character = Magician.getInstance();
					break;
				case "gunner":
					character = Gunner.getInstance();
					break;
				default:
					character = Warrior.getInstance();
						
			}
			jframe.dispose();
			// TODO Auto-generated method stub
			gameFrame = new JFrame();
            gameFrame.setTitle("DisneyGame");
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.setSize(1136,640); //배경화면 크기 (700,385)
            //frame.setVisible(true); //frame 형성
            gameFrame.setLocationRelativeTo(null);
                
            ArrayList<Enemy> enemies = new ArrayList<>();
            enemies.add(new Dwarf(2000, 200));
            enemies.add(new Dwarf(1300, 150));
            enemies.add(new Dog(700, 250));
            enemies.add(new Mammoth(1500, 250));
            enemies.add(new MiddleBossSoldier(2500, 150));
            Board level1 = new Board("./images/Forest.png", enemies, this, character);

            gameFrame.add(level1); //frame에 board형성
            gameFrame.setVisible(true);
			
            currentLevel = 1;
		}
		
		@Override
		public void onGameOver(){
			gameFrame.dispose();
			new GameOverScreen();
		}
}