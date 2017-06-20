package controller;

import java.util.ArrayList;

import javax.swing.*;

import model.Bird;
import model.Boss;
import model.Character;
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
        public static void main(String[] args){
        	
                new GUImain();
        	
        }
		@Override
		public void onLevelFinished() {   
			currentLevel ++;
			switch(currentLevel){
				case 2:
					ArrayList<Enemy> enemies = new ArrayList<>();
		            enemies.add(new Bird(300, 250, "./images/bird.png"));
		            enemies.add(new Bird(1200, 300, "./images/bird.png"));
		            enemies.add(new Boss(700, 150, "./images/turtle.png"));
		            character.resetStats();
		            Board level2 = new Board("./images/sky.png", enemies, this, character);
		            gameFrame.dispose();
		            gameFrame.add(level2); //frame에 board형성
		            gameFrame.setVisible(true);
		            break;
		            
				case 3:
					ArrayList<Enemy> enemies3 = new ArrayList<>();
		            enemies3.add(new Dwarf(1600, 200, "./images/dwarf.png"));
		            enemies3.add(new Bird(300, 250, "./images/bird.png"));
		            enemies3.add(new Boss(2000, 150, "./images/boss.png"));
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
            gameFrame.setTitle("2-D Test Game");
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.setSize(1136,640); //배경화면 크기 (700,385)
            //frame.setVisible(true); //frame 형성
            gameFrame.setLocationRelativeTo(null);
                
            ArrayList<Enemy> enemies = new ArrayList<>();
            enemies.add(new Dwarf(2000, 200, "./images/dwarf.png"));
            enemies.add(new Dwarf(1300, 150, "./images/dwarf.png"));
            enemies.add(new Dog(700, 250, "./images/dog.png"));
            enemies.add(new Mammoth(1500, 250, "./images/mammoth.png"));
            enemies.add(new Boss(2500, 150, "./images/boss.png"));
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