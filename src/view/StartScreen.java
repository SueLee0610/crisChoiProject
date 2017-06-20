package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import controller.GameStateListener;
import model.SelectionCharacter;

public class StartScreen extends JFrame{
		
	private Image screenImage;
	private Graphics screenGraphic;
	
	private final int SCREEN_WIDTH = 1000;
	private final int SCREEN_HEIGHT = 800;
		
	private ImageIcon startButtonEnteredImage = new ImageIcon("./images/startButtonEntered.png");
	private ImageIcon startButtonBasicImage = new ImageIcon("./images/startButtonBasic.png");
	private ImageIcon quitButtonEnteredImage = new ImageIcon("./images/quitButtonEntered.png");
	private ImageIcon quitButtonBasicImage = new ImageIcon("./images/quitButtonBasic.png");
	private ImageIcon leftButtonEnteredImage = new ImageIcon("./images/leftButtonEnteredImage.png");
	private ImageIcon leftButtonBasicImage = new ImageIcon("./images/leftButtonBasicImage.png");
	private ImageIcon rightButtonEnteredImage = new ImageIcon("./images/rightButtonEnteredImage.png");
	private ImageIcon rightButtonBasicImage = new ImageIcon("./images/rightButtonBasicImage.png");

	private ImageIcon goButtonEnteredImage = new ImageIcon("./images/goButtonEnteredImage.png");
	private ImageIcon goButtonBasicImage = new ImageIcon("./images/goButtonBasicImage.png");
		
	private ImageIcon nextButtonEnteredImage = new ImageIcon("./images/nextButtonEnteredImage.jpg");
	private ImageIcon nextButtonBasicImage = new ImageIcon("./images/nextButtonBasicImage.jpeg");
		
	private Image background = new ImageIcon("./images/title.jpg").getImage();
		

	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton goButton = new JButton(goButtonBasicImage);
	private JButton nextButton = new JButton(nextButtonBasicImage);
		
		
	private boolean isMainScreen = false;

	ArrayList<SelectionCharacter> characterList = new ArrayList<SelectionCharacter>();
	
	private Image titleImage;
	private Image selectedImage;
	private int nowSelected = 0;
	
	private GameStateListener controller;
	
	public StartScreen(GameStateListener controller) {
		this.controller = controller;
		
		setUndecorated(true);
		setTitle("공주 구하기");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
			
		characterList.add(new SelectionCharacter("warriorTitleImage.png", "warrior.png", "story.png", "warrior"));
		characterList.add(new SelectionCharacter("magicianTitleImage.png", "magician.png", "story.png", "magician"));
		characterList.add(new SelectionCharacter("gunnerTitleImage.png", "gunner.png", "story.png", "gunner"));
			
		startButton.setBounds(300, 300, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			startButton.setIcon(startButtonEnteredImage);
			startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectCharacter(0);
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				goButton.setVisible(true);
				background = new ImageIcon("./images/tent.jpg").getImage();
				isMainScreen = true;
			  }
			});
			add(startButton);
			
			quitButton.setBounds(300, 430, 400, 100);
			quitButton.setBorderPainted(false);
			quitButton.setContentAreaFilled(false);
			quitButton.setFocusPainted(false);
			
			quitButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					quitButton.setIcon(quitButtonEnteredImage);
					quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				}
			
				@Override
				public void mouseExited(MouseEvent e) {
					quitButton.setIcon(quitButtonBasicImage);
					quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
				
					System.exit(0);
				}
			});
			add(quitButton);
			
			leftButton.setVisible(false);
			leftButton.setBounds(250, 300, 50, 50);
			leftButton.setBorderPainted(false);
			leftButton.setContentAreaFilled(false);
			leftButton.setFocusPainted(false);
			leftButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					leftButton.setIcon(leftButtonEnteredImage);
					leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				}
				@Override
				public void mouseExited(MouseEvent e) {
					leftButton.setIcon(leftButtonBasicImage);
					leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					selectLeft();
				}
			});
			add(leftButton);
			
			rightButton.setVisible(false);
			rightButton.setBounds(700, 300, 50, 50);
			rightButton.setBorderPainted(false);
			rightButton.setContentAreaFilled(false);
			rightButton.setFocusPainted(false);
			rightButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					rightButton.setIcon(rightButtonEnteredImage);
					rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				}
				@Override
				public void mouseExited(MouseEvent e) {
					rightButton.setIcon(rightButtonBasicImage);
					rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					selectRight();
				}
			});
			add(rightButton);
			
			goButton.setVisible(false);
			goButton.setBounds(800, 500, 70, 70);
			goButton.setBorderPainted(false);
			goButton.setContentAreaFilled(false);
			goButton.setFocusPainted(false);
			goButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					goButton.setIcon(goButtonEnteredImage);
					goButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				}
				@Override
				public void mouseExited(MouseEvent e) {
					goButton.setIcon(goButtonBasicImage);
					goButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					gameStart(nowSelected);
					//selectNext(nowSelected);
					nextButton.setVisible(true);
				
				}
			});
			add(goButton);
		
		    nextButton.setVisible(false);
		    nextButton.setBounds(700, 470, 65, 30);
		    nextButton.setBorderPainted(false);
		    nextButton.setContentAreaFilled(false);
		    nextButton.setFocusPainted(false);
		    nextButton.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			    	nextButton.setIcon(nextButtonEnteredImage);
			    	nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			    }
			    @Override
			    public void mouseExited(MouseEvent e) {
			    	nextButton.setIcon(nextButtonBasicImage);
			    	nextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			    }
			    @Override
			    public void mousePressed(MouseEvent e) {
			    	selectNext(nowSelected);
			    }
		    });
		    add(nextButton);
		}
		
		public void paint(Graphics g) {
			screenImage = createImage(SCREEN_WIDTH,SCREEN_HEIGHT);
			screenGraphic = screenImage.getGraphics();
			screenDraw(screenGraphic);
			g.drawImage(screenImage, 0, 0, null);
			
		}
		
		public void screenDraw(Graphics g) {
			g.drawImage(background, 0, 0, null);
			if(isMainScreen)
			{
				g.drawImage(selectedImage, 300, 100, null);
				g.drawImage(titleImage, 400, 530, null);
			}
			paintComponents(g);
			this.repaint();
		}

		public void selectCharacter(int nowSelected) {
			titleImage = new ImageIcon("./images/" + characterList.get(nowSelected).getTitleImage()).getImage();
			selectedImage = new ImageIcon("./images/" + characterList.get(nowSelected).getStartImage()).getImage();
		}
		
		public void selectLeft() {
			if(nowSelected == 0)
				nowSelected = characterList.size() -1;
			else
				nowSelected--;
			selectCharacter(nowSelected);
		}
		
		public void selectRight() {
			if(nowSelected == characterList.size() -1)
				nowSelected = 0;
			else
				nowSelected++;
			selectCharacter(nowSelected);
	    }
		
		public void gameStart(int nowSelected) {
			isMainScreen = false;
			leftButton.setVisible(false);
			rightButton.setVisible(false);
			goButton.setVisible(false);
			nextButton.setVisible(false);
			background = new ImageIcon("./images/" + characterList.get(nowSelected).getGameImage()).getImage();
		}
		
		public void selectNext(int nowSelected) {
			System.out.println("selectNext");
			isMainScreen = false;
			leftButton.setVisible(false);
			rightButton.setVisible(false);
			goButton.setVisible(false);
			nextButton.setVisible(true);
			String characterClass = characterList.get(nowSelected).getCharacterClass();
			controller.onCharacterSelectionPerformed(characterClass);
		}
			
	}

