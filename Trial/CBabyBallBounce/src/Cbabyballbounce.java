//import javax.swing.JPanel
import javax.swing.JPanel;
// import java.awt.*;
import java.awt.*;
// import javax.swing.border.EmptyBorder;
import javax.swing.border.EmptyBorder;
// import javax.swing.border.LineBorder;
import javax.swing.border.LineBorder;
// import javax.swing.event.*;
import javax.swing.event.*;
// import javax.swing
import javax.swing.*;
//import java.awt.event.*;
import java.awt.event.*;
// import java.util.*;
import java.util.*;
// import java.util.timer
import java.util.Timer;
// import java.util.timertask
import java.util.TimerTask;
// import java.util.timeUnit
import java.util.concurrent.TimeUnit;
// import java.lang.*
import java.lang.*;
// import java.awt.evene.*
import java.awt.event.*;


// initialize the class CBabyBallBounce and extends JFame while implementing ActionListener and MouseInputListener
public class Cbabyballbounce extends JFrame implements ActionListener, MouseInputListener {
	
	// initialize the serial version
	private static final long serialVersionUID = 1L;
	// initialize JPanel contentPane
	private final JPanel contentPane;
	// initialize JPanel mapPanel
	final JPanel mapPanel = new JPanel();
	// initialize JPanel gamePanel
	final JPanel gamePanel = new JPanel();
	// initialize JPanel mainPanel
	final JPanel mainPanel = new JPanel();
	// initialize JPanel panelMouse
	JPanel panelMouse = new JPanel();


	// initialize JTextField squareBox
	public final JTextField squareBox = new JTextField();
	// initialize JTextField directionBox
	public final JTextField directionBox = new JTextField();
	// initialize JTextField optionBox
	public final JTextField optionBox = new JTextField();
	// initialize JTextField timerHour
	public final JTextField timerHour = new JTextField();
	// initialize JTextField minTimer
	public final JTextField minTimer = new JTextField();
	// initialize JTextField secTimer
	public final JTextField secTimer = new JTextField();
	// initialize JTextField scoreLeft
	public final JTextField leftScore = new JTextField();
	// initialize JTextField scoreRight
	public final JTextField rightScore = new JTextField();

	
	// initialize JButton buttonUp
	final JButton buttonUp = new JButton("^");
	// initialize JButton buttonBall
	final JButton buttonBall = new JButton("");
	// initialize JButton buttonDown
	final JButton buttonDown = new JButton("v");
	// initialize JButton buttonRight
	final JButton buttonRight = new JButton(">");
	// initialize JButton buttonLeft
	final JButton buttonLeft = new JButton("<");
	// initialize JButton buttonMap
	final JButton buttonMap = new JButton("");
	// initialize JButton buttonTwoPlayers
	final JButton buttonTwoPlayers = new JButton("2 Player");
	// initialize JButton buttonFourPlayers
	final JButton buttonFourPlayers = new JButton("4 Player");
	// initialize JButton buttonMulti
	final JButton buttonMulti = new JButton("Multi");
	// initialize JButton buttonExit
	final JButton buttonExit = new JButton("Exit");
	// initialize JButton buttonAct
	final JButton buttonAct = new JButton("Act");
	// initialize JButton buttonRun
	final JButton buttonRun = new JButton("Run");
	// initialize JButton buttonReset
	final JButton buttonReset = new JButton("Reset");
	// Created an array buttonGrid[][] of size [13][16]
	JButton buttonGrid[][] = new JButton[13][16];
	// initialize integer
	// generates integer leftR, leftC, rightR, rightC, bR, bC, lTR = 3, lTC = 3
	int leftR, leftC, rightR, rightC, bR, bC, lTR = 3, lTC = 3;
	// generates integer rTC = 13, rTR = 6
	int rTC = 13, rTR = 6;
	// generates integer rBR = 6, rBC = 11, speed = 1, scoreL, scoreR
	int rBR = 6, rBC = 11, speed = 1, scoreL, scoreR;
	// generates integer lY = 1, lYS = 1, rY, timeM, timeH
	int lY = 1, lYS = 1, rY, timeM, timeH;
	// generates integer vSpeedlT = -1, vSpeedrT = 1, vSpeedrB = -1
	int vSpeedlT = -1, vSpeedrT = 1, vSpeedrB = -1;
	// generates integer vDirection = 1
	int vDirection = 1;
	// initialize float timeS
	float timeS;
	// initialize timer tt
	javax.swing.Timer tt = new javax.swing.Timer(100, this);
	// initialize boolean four as false
	boolean four = false;
	// initialize Timer timer
	Timer timer = new Timer();


	public static void main(final String[] args) {
		// inherits CBabyBallBounce to variable frame
		final Cbabyballbounce frame = new Cbabyballbounce();
		// places setResizable of frame to false
		frame.setResizable(false);
		// places setLocationRelative of frame to null
		frame.setLocationRelativeTo(null);
		// places setDefaultCloseOperation of frame to WindowConstants.EXIT_ON_CLOSE
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// places setVisible of frame to true
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		// examines if "left:" eqals "right"
		// examines if e.getSource() equals buttonBall
		// examines if e.getSource() equals buttonBall
		if (e.getSource().equals(buttonBall)) {
			// places setIcon of buttonGrid[bR][bC] to null
			buttonGrid[bR][bC].setIcon(null);
			// calls function ball()
			ballPos();
			// places speed to 1
			speed = 1;
		}


		// examines if e.getSource() is equal to buttonAct
		if (e.getSource().equals(buttonAct)) {
			// examines if ((bR == rightR) && ((rightC - 1) == bC))
			if (((bR == rightR) && ((rightC - 1) == bC))) {
				// reverses the direction of speed
				speed = -speed;
				// places setText of directionBox to WEST
				directionBox.setText("WEST");
				// places setIcon of buttonMap to west.jpg
				buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\west.jpg"));
			}
			// examines if (((bR == leftR) && ((leftC + 1) == bC)))
			if ((((bR == leftR) && ((leftC + 1) == bC)))) {
				// reverses the direction of speed
				speed = -speed;
				// places setText of directionBox to EAST
				directionBox.setText("EAST");
				// places setIcon of buttonMap to east.jpg
				buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\east.jpg"));
			}
			// ckecks if bC equals 0
			if ((bC == 0)) {
				// reverses the direction of speed
				speed = -speed;
				// increases scoreR by 1
				scoreR += 1;
				// places setText of scoreRight to scoreR
				rightScore.setText("" + scoreR);
				// places setIcon of buttonMap to east.jpg
				buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\east.jpg"));
				// places setText of directionBox to EAST
				directionBox.setText("EAST");
			} 
			
			else if (bC == 15) {
				// reverses the direction of speed
				speed = -speed;
				// increases scoreL by 1
				scoreL += 1;
				// places setText of scoreLeft to scoreL
				leftScore.setText("" + scoreL);
				// places setIcon of buttonMap to west.jpg
				buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\west.jpg"));
				// places setText of directionBox to WEST
				directionBox.setText("WEST");
			}
			
			// places buttonGrid[bR][bC] to null
			buttonGrid[bR][bC].setIcon(null);
			// bC increases by speed
			bC += speed;
			// places setIcon of buttonGrid[bR][bC] to ball.png
			buttonGrid[bR][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\ball.png"));
			// places setText of squareBox to ((bC + 1) * (bR + 1))
			squareBox.setText("" + ((bC + 1) * (bR + 1)));

			if (speed == 1 && (bC == 8 || bC == 9)) {
				// places setIcon of buttonGrid[bR][bC - 1] to wall.png
				buttonGrid[bR][bC - 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));

			} else if (speed == -1 && (bC == 7 || bC == 6)) {
				// places setIcon of buttonGrid[bR][bC + 1] to wall.png
				buttonGrid[bR][bC + 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
			}
		}
		// examines if e.getSource() is equal to buttonRun
		if (e.getSource().equals(buttonRun)) {
			// places schedule to timer
			timer.schedule(new TimerTask() {

				@Override
				// runs the function
				public void run() {
					// places the loop to continuous
					while (true) {
						// starts the timer
						tt.start();
						// call function clock
						clock();
						// places setText of secTimer to timeS
						secTimer.setText("" + timeS);
						// places the textbox of optionBox to "4 PLYR"
						optionBox.setText("4 PLAYER");
						// examines if timeS equals 60
						if (timeS == 60) {
							// places timeM to timeS / 60
							timeM = (int) timeS / 60;
							// places timeS to 0
							timeS = 0;
						}
						// examines if timeM equals to 60
						if (timeM == 60) {
							// places timeH to timeM / 60
							timeH = timeM / 60;
							// places timeM to 0
							timeM = 0;
						}
						// places rightR to 0
						rightR = 0;
						// places rightC to 0
						rightC = 0;
						// places setText of timerHour to timeH
						timerHour.setText("" + timeH);
						// places setText of minTimer to timtM
						minTimer.setText("" + timeM);
						// examines if rTR equals to 0
						if (rTR == 0) {
							// reverses the direction of vSpeedrT
							vSpeedrT = -vSpeedrT;

						}
						// examines if rTR equals to 12
						if (rTR == 12) {
							// reverses the direction of vSpeedrT
							vSpeedrT = -vSpeedrT;

						}
						// places setIcon of buttonGrid[rTR][rTC] to null
						buttonGrid[rTR][rTC].setIcon(null);
						// increases rTR by vSpeedrT
						rTR += vSpeedrT;
						// places setIcon of buttonGrid[rTR][rTC] to baby2.png
						buttonGrid[rTR][rTC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\baby2.png"));
						// examines if LTR equals to 0
						if (lTR == 0) {
							// reverses the direction of vSpeedlT
							vSpeedlT = -vSpeedlT;

						}
						// examines if LTR equals to 12
						if (lTR == 12) {
							// reverses the direction of vSpeedLT
							vSpeedlT = -vSpeedlT;

						}
						// places setIcon of buttonGrid[lTR][lTC] to null
						buttonGrid[lTR][lTC].setIcon(null);
						// increases LTR by vSpeedlT
						lTR += vSpeedlT;
						// places setIcon of buttonGrid[lTR][lTC] to baby1.png
						buttonGrid[lTR][lTC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\baby1.png"));
						// examines if rBR equals to 0
						if (rBR == 0) {
							// reverses the direction of vSpeedrB
							vSpeedrB = -vSpeedrB;

						}
						// examines if rBR equals to 12
						if (rBR == 12) {
							// reverses the direction of vSpeedrB
							vSpeedrB = -vSpeedrB;

						}
						// places buttonGrid[rBR][rBC] to null
						buttonGrid[rBR][rBC].setIcon(null);
						// increases the value of rBR by vSpeedrB
						rBR += vSpeedrB;
						// places buttonGrid[rBR][rBC] to baby2.jpg
						buttonGrid[rBR][rBC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\baby2.png"));
						// places mouseMotionListener in the panel panelMouse
						panelMouse.addMouseMotionListener(new MouseMotionListener() {

							@Override
							public void mouseDragged(final MouseEvent e) {

							}

							@Override
							public void mouseMoved(final MouseEvent e) {
								// initialize integer l
								int l;
								// places lY to the vertical location of ball divided by 30
								lY = (e.getY()) / 30;
								// places value of l to lY
								l = lY;
								// places value of leftR to l
								leftR = l;

								// places buttonGrid[l][c] to baby1.png
								buttonGrid[l][leftC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\baby1.png"));
								// loops i to 13th step
								for (int i = 0; i < 13; i++) {
									// examines if i is not equal to l
									if (i != l) {
										// places buttonGrid[l][c] to null
										buttonGrid[i][leftC].setIcon(null);
									}
								}

							}

						});
						// examines if ((((bR == (rBR + 1)) || ((bR == (rBR - 1)))) && ((rBC - 1) == bC)))
						if ((((bR == (rBR + 1)) || ((bR == (rBR - 1)))) && ((rBC - 1) == bC))) {
							// places the direction of speed to opposite
							speed = -speed;
							// places setText of directionBox to "WEST"
							directionBox.setText("WEST");
							// places icon of buttonMap to west.jpg
							buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\west.jpg"));
						}
						// examines if (((bR == (rTR + 1)) || ((bR == (rTR + 1)))) && ((rTC - 1) == bC))
						if (((bR == (rTR + 1)) || ((bR == (rTR + 1)))) && ((rTC - 1) == bC)) {
							// places the direction of speed to opposite
							speed = -speed;
							// places setText of directionBox to "WEST"
							directionBox.setText("WEST");
							// places icon of buttonMap to west.jpg
							buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\west.jpg"));
						}
						// examines if ((((bR == (leftR + 1)) || ((bR == (leftR - 1)))) && ((leftC + 1) == bC)))
						if ((((bR == (leftR + 1)) || ((bR == (leftR - 1)))) && ((leftC + 1) == bC))) {
							// places the direction of speed to opposite
							speed = -speed;
							// places setText of directionBox to "EAST"
							directionBox.setText("EAST");
							// places icon of buttonMap to east.jpg
							buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\east.jpg"));
						}
						// examines if ((((bR == (lTR + 1)) || (bR == (lTR - 1)) && ((lTC + 1) == bC))))
						if ((((bR == (lTR + 1)) || (bR == (lTR - 1)) && ((lTC + 1) == bC)))) {
							// places the direction of speed to opposite
							speed = -speed;
							// places setText of directionBox to "EAST"
							directionBox.setText("EAST");
							// places icon of buttonMap to west.jpg
							buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\east.jpg"));
						}
						// examines if bC equals to 0
						if ((bC == 0)) {
							// places the speed to 0
							speed = 0;
							// increases scoreR by 1
							scoreR += 1;
							// places the text in scoreRight to scoreR
							rightScore.setText("" + scoreR);
							// places setText of directionBox to "EAST"
							buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\east.jpg"));
							// places the text in directionBox to EAST
							directionBox.setText("EAST");
							// examines if speed is equal to 0
							
							if(scoreR ==1 ) {
								JOptionPane.showMessageDialog(rightScore, "Player 2 wins");
								System.exit(0);
							}
						}
						// examines if bC equals 15
						else if (bC == 15) {
							// places speed to 0
							speed = 0;
							// increases scoreL by 1
							scoreL += 1;
							// places the text of scoreLeft to scoreL
							leftScore.setText("" + scoreL);
							// places the icon of buttonMap to west.jpg
							buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\west.jpg"));
							// places the text of directionBox to WEST
							directionBox.setText("WEST");
							if(scoreL ==1  ) {
								JOptionPane.showMessageDialog(leftScore, "Player 1 wins");
								System.exit(0);
							}
							// examines if speed equals 0
						}
						// examines if bR equals 12 or 0
						if (bR == 12 || bR == 0) {
							// reverses the direction of vDirection
							vDirection = -vDirection;
						}
						// places the icon of array buttonGrid to null
						buttonGrid[bR][bC].setIcon(null);
						// increases the value of bC by speed
						bC += speed;
						// increases the value of bR by direction
						bR += vDirection;
						// places the icon of buttonGrid[ball] to ball.jpg
						buttonGrid[bR][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\ball.png"));
						// places text to multiplication of rows and columns
						squareBox.setText("" + ((bC + 1) * (bR + 1)));
						{
							// examines if speed equals to 1 and bC equals 8 or 9
							if (speed == 1 && (bC == 8 || bC == 9)) {
								// examines if bR equals12
								if (bR == 12) {
									// places the buttonGrid to wall.png
									buttonGrid[bR - 1][bC - 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
								}
								// examines if bR euqls 0
								else if (bR == 0) {
									// places the buttonGrid to wall.png
									buttonGrid[bR + 1][bC - 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
								} else {
									// places the buttonGrid to wall.png
									buttonGrid[bR + 1][bC - 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
									// places the buttonGrid to wall.png
									buttonGrid[bR - 1][bC - 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
								}
							}
							// examines if(speed == -1 && (bC == 7 || bC == 6))
							else if (speed == -1 && (bC == 7 || bC == 6)) {
								// examines if bR equals 12
								if (bR == 12) {
									// places the buttonGrid to wall.png
									buttonGrid[bR - 1][bC + 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
								}
								// examines if bR equals 0
								else if (bR == 0) {
									// places the buttonGrid to wall.png
									buttonGrid[bR + 1][bC + 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
								} else {
									// places the buttonGrid to wall.png
									buttonGrid[bR + 1][bC + 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
									// places the buttonGrid to wall.png
									buttonGrid[bR - 1][bC + 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
								}

							}
						}

					}
				}
			}, 1);
		}
		// examines if e.getSource() equals buttonReset
		if (e.getSource().equals(buttonReset)) {
			// places scoreL to 0
			scoreL = 0;
			// places scoreR to 0
			scoreR = 0;
			// places the text of scoreLeft to scoreL
			leftScore.setText("" + scoreL);
			// places the text of scoreRight to scoreR
			rightScore.setText("" + scoreR);
			// places the buttonGrid of ball to null
			buttonGrid[bR][bC].setIcon(null);

			// places the buttonGrid of right player to null
			buttonGrid[rightR][rightC].setIcon(null);
			// places the buttonGrid of left player to null
			buttonGrid[leftR][leftC].setIcon(null);

			// places the buttonGrid of left player to null
			buttonGrid[lTR][lTC].setIcon(null);
			// places the buttonGrid of right player to null
			buttonGrid[rTR][rTC].setIcon(null);
			// places the buttonGrid of right player to null
			buttonGrid[rBR][rBC].setIcon(null);
			// places timeS to 0
			timeS = 0;
			// places timeM to 0
			timeM = 0;
			// places timeH to 0
			timeH = 0;
			// places text of timeHour to timeH
			timerHour.setText("" + timeH);
			// places text of timeSex to timeS
			secTimer.setText("" + timeS);
			// places text of timeMnin to timeM
			minTimer.setText("" + timeM);
			// calls the method players()
			players();
			// places the text of optionBox to "2 PLYR"
			optionBox.setText("2 PLYR");
			// calls the method ball()
			ballPos();
			// places the speed to 1
			speed = 1;
			// places the text of directionBox to "EAST"
			directionBox.setText("EAST");
			// places text to multiplication of rows and columns
			squareBox.setText("" + ((bC + 1) * (bR + 1)));
			// places the icon of buttonMap to east.jpg
			buttonMap.setIcon(new ImageIcon("images\\east.jpg"));

			// loops value of i 13 times
			for (int i = 0; i <= 12; i++) {
				// loops value of j 16 times
				for (int j = 0; j <= 15; j++) {
					// examines if i is greater than 6 and smaller than 9
					if (j >= 7 && j < 9) {
						// places the icon to wall.png
						buttonGrid[i][j].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
					}
					// adds the buttonGrid to game panel
					gamePanel.add(buttonGrid[i][j]);

				}
			}

		}
		// examines if e.getSource() equals (buttonLeft) or e.getSource() equals(buttonRight)
		if (e.getSource().equals(buttonLeft) || e.getSource().equals(buttonRight)) {
			// examines if e.getSource() equals (buttonLeft) and bC != 0
			if (e.getSource().equals(buttonLeft) && bC != 0) {
				// places the buttonGrid of ball to null
				buttonGrid[bR][bC].setIcon(null);
				// decreases bC by 1
				bC = bC - 1;
				// examines if (((bR == leftR) and ((leftC) == bC)))
				if ((((bR == leftR) && ((leftC) == bC)))) {
					// increases bC by 1
					bC = bC + 1;
				}
				// places the buttonGrid of ball to ball.png
				buttonGrid[bR][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\ball.png"));
				// places the icon of buttonMap to west.jpg
				buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\west.jpg"));
				// places the text of directionBox to "EAST"
				directionBox.setText("EAST");
				// examines if bC equals 7 or 6
				if (bC == 6 || bC == 7) {
					// places the buttonGrid of ballto wall.png
					buttonGrid[bR][bC + 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));

				}
				// places text to multiplication of rows and columns
				squareBox.setText("" + ((bC + 1) * (bR + 1)));
				// places the text to "WEST"
				directionBox.setText("WEST");

			}
			// examines if e.getSource() equals (buttonRight) and bC != 15
			if (e.getSource().equals(buttonRight) && bC != 15) {
				// places the buttonGrid of ball to null
				buttonGrid[bR][bC].setIcon(null);
				// increases bC by 1
				bC += 1;
				// examines if ((bR == rightR) and ((rightC) == bC))
				if (((bR == rightR) && ((rightC) == bC))) {
					// places bC to -1
					bC -= 1;
				}
				// places buttonGrid of ball to ball.png
				buttonGrid[bR][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\ball.png"));
				// places text to multiplication of rows and columns
				squareBox.setText("" + ((bC + 1) * (bR + 1)));
				// examines if bC equals 8 or 9
				if (bC == 8 || bC == 9) {
					// places the buttonGrid to wall.png
					buttonGrid[bR][bC - 1].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));

				}
				// places the icon in buttonMap to east.jpg
				buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\east.jpg"));
				// places the text to "EAST"
				directionBox.setText("EAST");
			}

		}
		// NOTE BUTTON UP
		// examines if e.getSource() equals (buttonUP) or e.getSource() equals(buttonDown)
		if (e.getSource().equals(buttonUp) || e.getSource().equals(buttonDown)) {
			// examines if e.getSource() equals (buttonUP)
			if (e.getSource().equals(buttonUp)) {
				if (bR >= 1) {
					// places the buttonGrid of ball to null
					buttonGrid[bR][bC].setIcon(null);
					// decreases bR by 1
					bR -= 1;
					// places the icon of buttonMap to north.jpg
					buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\north.jpg"));
					// places the buttonGrid of ball to ball.png
					buttonGrid[bR][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\ball.png"));
				}
				// places the text of directionBox to "EAST"
				directionBox.setText("NORTH");
				// places text to multiplication of rows and columns
				squareBox.setText("" + ((bC + 1) * (bR + 1)));
			}
			// examines if e.getSource() equals (buttonDown)
			if (e.getSource().equals(buttonDown)) {
				// examines if bR is smaller or equals to 11
				if (bR <= 11) {
					// places the buttonGrid of ball to null
					buttonGrid[bR][bC].setIcon(null);
					// increases bR by 1
					bR += 1;
					// places the icon of buttonMap to south.jpg
					buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\south.jpg"));
					// places the buttonGrid of ball to ball.png
					buttonGrid[bR][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\ball.png"));
				}
				// places the text of directionBox to "SOUTH"
				directionBox.setText("SOUTH");
				// places text to multiplication of rows and columns
				squareBox.setText("" + ((bC + 1) * (bR + 1)));

			}
			// examines if bC equals 7 or 8
			if ((bC == 8 || bC == 7)) {
				// examines if bR equals 1
				if (bR == 1) {
					// places the location of ball to wall.png
					buttonGrid[bR + 1][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
				}
				// examines if bR equals 12
				else if (bR == 12) {
					// places the location of ball to wall.png
					buttonGrid[bR - 1][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
				} else {
					// places the location of ball to wall.png
					buttonGrid[bR - 1][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\greenfoot.jpg"));
					// places the location of ball to wall.png
					buttonGrid[bR + 1][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
				}

			}
		}
		// examines if e.getSource() equals(buttonFourPlayers)
		if (e.getSource().equals(buttonFourPlayers)) {
			// places the location of left player to null
			buttonGrid[leftR][leftC].setIcon(null);
			// places the location of right player to null
			buttonGrid[rightR][rightC].setIcon(null);
			// places the textbox of optionBox to "4 PLYR"
			optionBox.setText("4 PLYR");
			// calls playersFour() method
			playersFour();
			// places four to true
			four = true;
		}
		if (e.getSource().equals(buttonTwoPlayers)) {
			// places the location of left player to null
			buttonGrid[lTR][lTC].setIcon(null);
			// places the location of right player to null
			buttonGrid[rTR][rTC].setIcon(null);
			// places the location of left player to null
			buttonGrid[leftR][leftC].setIcon(null);
			// places the location of left player to null
			buttonGrid[rightR][rightC].setIcon(null);
			// places the location of right player to null
			buttonGrid[rBR][rBC].setIcon(null);
			// places the textbox of optionBox to "2 PLYR"
			optionBox.setText("2 PLYR");
			// calls the method players()
			players();
		}
		// examines if e.getSource() equals(buttonExit)
		if (e.getSource().equals(buttonExit)) {
			// exits the program
			System.exit(0);
		}
	}

	protected void clock() {
		// tries the following syntax
		try {
			// program sleeps for 500 milliseconds
			Thread.sleep(500);
			// increases timeS by 0.5
			timeS += 0.5;
		}
		// catches exceptions
		catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	// constructor
	public Cbabyballbounce() {
		// places the icon for this application
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\greenfoot.jpg"));
		// places the title of frame to "CBabyBallBounce- Baby Ball Bounce Application"
		setTitle("CBabyBallBounce \u2013 Baby Ball Bounce Application");
		// places default close opetaion to JFrame.EXIT_ON_CLOSE
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// places the bounds of frame to (100, 100, 825, 585)
		setBounds(100, 100, 825, 585);
		// generates JMenuBar menuBar
		final JMenuBar menuBar = new JMenuBar();
		// places background colour to white
		menuBar.setBackground(Color.WHITE);
		// adds menuBar to menu
		setJMenuBar(menuBar);
		// generates a JMenu
		// generates a JMenumnNewMenuScenerio
		final JMenu mnNewMenuScenerio = new JMenu("Scenario");
		// places the font to ("Segoe UI", Font.BOLD, 12)
		mnNewMenuScenerio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		// adds the menu to menuBar
		menuBar.add(mnNewMenuScenerio);
		// generatesa JMenuItem mntmNewMenuSceneioExit
		final JMenuItem mntmNewMenuSceneioExit = new JMenuItem("Exit");
		// adds mntmNewMenuSceneioExit to JMenu
		mnNewMenuScenerio.add(mntmNewMenuSceneioExit);
		// generates a JMenu mnNewMenuEdit
		final JMenu mnMenuEdit = new JMenu("Edit");
		// places the font to ("Segoe UI", Font.BOLD, 12)
		mnMenuEdit.setFont(new Font("Segoe UI", Font.BOLD, 12));
		// adds the menu to menuBar
		menuBar.add(mnMenuEdit);
		// generates a JMenu mnNewMenuControls
		final JMenu mnMenuControls = new JMenu("Contact");
		// places the font to ("Segoe UI", Font.BOLD, 12)
		mnMenuControls.setFont(new Font("Segoe UI", Font.BOLD, 12));
		// adds the menu to menuBar
		menuBar.add(mnMenuControls);
		// generates a JMenu mnNewMenuHelp
		final JMenu mnNewMenuHelp = new JMenu("Help");
		// places the font to ("Segoe UI", Font.BOLD, 12)
		mnNewMenuHelp.setFont(new Font("Segoe UI", Font.BOLD, 12));
		// adds the menu to menuBar
		menuBar.add(mnNewMenuHelp);
		// generatesa JMenuItem mntmNewMenuItemHelpHelpTopic
		final JMenuItem mntmNewMenuItemHelpHelpTopic = new JMenuItem("Help Topic");
		// adds mntmNewMenuItemHelpHelpTopic to JMenu
		mnNewMenuHelp.add(mntmNewMenuItemHelpHelpTopic);
		// generatesa JMenuItem mntmNewMenuItemHelpAbout
		final JMenuItem mntmNewMenuItemHelpAbout = new JMenuItem("About");
		// adds mntmNewMenuItemHelpAbout to JMenu
		mnNewMenuHelp.add(mntmNewMenuItemHelpAbout);
		// generates a JPanel contentPane
		contentPane = new JPanel();
		// places background colour to black
		contentPane.setBackground(Color.BLACK);
		// places the border to (5, 5, 5, 5)
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// places the contentPane
		setContentPane(contentPane);
		// places the layout to null
		contentPane.setLayout(null);
		// generates a JPanel panelRight
		final JPanel panelRight = new JPanel();
		// places background colour to CYAN
		panelRight.setBackground(Color.BLACK);
		// places the font to Color.BLUE, 1, true
		panelRight.setBorder(new LineBorder(Color.BLUE, 1, true));
		// places the bounds to (651, 5, 160, 465)
		panelRight.setBounds(651, 5, 160, 465);
		// adds the panel to contentPane
		contentPane.add(panelRight);
		// places layout to null
		panelRight.setLayout(null);
		// generates a JPanel panelTimer
		final JPanel panelTimer = new JPanel();
		// places the bounds to (3, 5, 153, 90)
		panelTimer.setBounds(3, 5, 153, 90);
		// adds the panel to panelRight
		panelRight.add(panelTimer);
		// places layout to null
		panelTimer.setLayout(null);
		// generates a JLabel
		final JLabel lblTimer = new JLabel("DIGITAL TIMER");
		// places the font to ("Tahoma", Font.BOLD, 10)
		lblTimer.setFont(new Font("Tahoma", Font.BOLD, 10));
		// places the bounds to (28, 0, 94, 13)
		lblTimer.setBounds(28, 0, 94, 13);
		// adds the label to panelTimer
		panelTimer.add(lblTimer);
		// places the foreground colour to white
		timerHour.setForeground(Color.WHITE);
		// places the background colour to black
		timerHour.setBackground(Color.BLACK);
		// places the text to'00'
		timerHour.setText("00");
		// places columns to 10
		timerHour.setColumns(10);
		// places the bounds to (4, 15, 27, 19)
		timerHour.setBounds(4, 15, 27, 19);
		// adds it to panelTimer
		panelTimer.add(timerHour);
		// places the foreground colour to white
		minTimer.setForeground(Color.WHITE);
		// places the background colour to black
		minTimer.setBackground(Color.BLACK);
		// places the text to'00'
		minTimer.setText("00");
		// places columns to 10
		minTimer.setColumns(10);
		// places the bounds to (59, 15, 27, 19)
		minTimer.setBounds(59, 15, 27, 19);
		// adds it to panelTimer
		panelTimer.add(minTimer);
		// places the foreground colour to white
		secTimer.setForeground(Color.WHITE);
		// places the background colour to black
		secTimer.setBackground(Color.BLACK);
		// places the text to'00'
		secTimer.setText("00");
		// places columns to 10
		secTimer.setColumns(10);
		// places the bounds to (59, 15, 27, 19)
		secTimer.setBounds(108, 15, 27, 19);
		// adds it to panelTimer
		panelTimer.add(secTimer);
		// generates a JLabel label_2
		final JLabel label_two = new JLabel(":");
		// places the font to ("Tahoma", Font.BOLD, 14)
		label_two.setFont(new Font("Tahoma", Font.BOLD, 14));
		// places the bounds to (41, 15, 6, 17)
		label_two.setBounds(41, 15, 6, 17);
		// adds the label to panelTimer
		panelTimer.add(label_two);
		// generates a JLabel label_4
		final JLabel label_4 = new JLabel(":");
		// places the font to ("Tahoma", Font.BOLD, 14)
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		// places the bounds to (41, 15, 6, 17)
		label_4.setBounds(96, 15, 6, 17);
		// adds the label to panelTimer
		panelTimer.add(label_4);
		// generates a JLabel lblScore
		final JLabel lblScore = new JLabel("SCORE");
		// places the font to ("Tahoma", Font.BOLD, 10)
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 10));
		// places the bounds to (41, 15, 6, 17)
		lblScore.setBounds(50, 44, 45, 13);
		// adds the label to panelTimer
		panelTimer.add(lblScore);
		// places the foreground colour to white
		leftScore.setForeground(Color.WHITE);
		// places the background colour to black
		leftScore.setBackground(Color.BLACK);
		// places the text to'00'
		leftScore.setText("00");
		// places column to 10
		leftScore.setColumns(10);
		// places the bounds to (10, 60, 27, 19)
		leftScore.setBounds(10, 60, 27, 19);
		// adds the textfield to panelTimer
		panelTimer.add(leftScore);
		// places the foreground colour to white
		rightScore.setForeground(Color.WHITE);
		// places the background colour to black
		rightScore.setBackground(Color.BLACK);
		// places the text to'00'
		rightScore.setText("00");
		// places column to 10
		rightScore.setColumns(10);
		// places the bounds to (10, 60, 27, 19)
		rightScore.setBounds(108, 60, 27, 19);
		// adds the textfield to panelTimer
		panelTimer.add(rightScore);
		// generates JLabel label_5
		final JLabel label_5 = new JLabel("<L : R>");
		// places the font to ("Tahoma", Font.BOLD, 10)
		label_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		// places the bounds to (50, 65, 45, 13)
		label_5.setBounds(50, 65, 45, 13);
		// adds the label to panelTimer
		panelTimer.add(label_5);
		// generates a JPanel panelTextBox
		final JPanel panelTextbox = new JPanel();
		// places the bounds to (3, 97, 153, 67)
		panelTextbox.setBounds(3, 97, 153, 67);
		// adds the panel to panelRight
		panelRight.add(panelTextbox);
		// places layout to GridBagLayout
		final GridBagLayout gbl_panelTextbox = new GridBagLayout();
		// places columnheight and widths
		gbl_panelTextbox.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelTextbox.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelTextbox.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelTextbox.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelTextbox.setLayout(gbl_panelTextbox);
		// generates a JLabel lblOption
		final JLabel lblOption = new JLabel("OPTION:");
		// adds gridbagLayout
		final GridBagConstraints gbc_lblOption = new GridBagConstraints();
		gbc_lblOption.fill = GridBagConstraints.BOTH;
		gbc_lblOption.insets = new Insets(0, 0, 5, 5);
		// places gridX
		gbc_lblOption.gridx = 0;
		// places gridY
		gbc_lblOption.gridy = 0;
		// adds the panelTextBox
		panelTextbox.add(lblOption, gbc_lblOption);
		// places column to 10
		optionBox.setColumns(10);
		// adds grdibagconstrainrts
		final GridBagConstraints gbc_optionBox = new GridBagConstraints();
		// places width to 2
		gbc_optionBox.gridwidth = 2;
		// inserts the box
		gbc_optionBox.insets = new Insets(0, 0, 5, 0);
		gbc_optionBox.fill = GridBagConstraints.HORIZONTAL;
		// places gridX to 2
		gbc_optionBox.gridx = 2;
		// places gridY
		gbc_optionBox.gridy = 0;
		// adds the layout to panelTextBox
		panelTextbox.add(optionBox, gbc_optionBox);
		// generates a JLabel lblSquare
		final JLabel lblSquare = new JLabel("SQUARE:");
		// adds gridbagLayout
		final GridBagConstraints gbc_lblSquare = new GridBagConstraints();
		gbc_lblSquare.anchor = GridBagConstraints.WEST;
		gbc_lblSquare.insets = new Insets(0, 0, 5, 5);
		// places gridXY to 0
		gbc_lblSquare.gridx = 0;
		// places gridY to 1
		gbc_lblSquare.gridy = 1;
		// adds the layout to panelTextBox
		panelTextbox.add(lblSquare, gbc_lblSquare);
		// squareBox = new JTextField();
		squareBox.setColumns(10);
		final GridBagConstraints gbc_squareBox = new GridBagConstraints();
		gbc_squareBox.gridwidth = 2;
		gbc_squareBox.insets = new Insets(0, 0, 5, 0);
		gbc_squareBox.fill = GridBagConstraints.HORIZONTAL;
		// places gridX to 2
		gbc_squareBox.gridx = 2;
		// places gridY to 1
		gbc_squareBox.gridy = 1;
		// adds the layout to panelTextBox
		panelTextbox.add(squareBox, gbc_squareBox);
		final JLabel lblDirection = new JLabel("DIRECTION:");
		final GridBagConstraints gbc_lblDirection = new GridBagConstraints();
		gbc_lblDirection.anchor = GridBagConstraints.WEST;
		gbc_lblDirection.insets = new Insets(0, 0, 0, 5);
		// places gridX to 0
		gbc_lblDirection.gridx = 0;
		// places gridY to 2
		gbc_lblDirection.gridy = 2;
		// adds the layout to panelTextBox
		panelTextbox.add(lblDirection, gbc_lblDirection);
		directionBox.setColumns(10);
		final GridBagConstraints gbc_directionBox = new GridBagConstraints();
		gbc_directionBox.gridwidth = 2;
		gbc_directionBox.fill = GridBagConstraints.HORIZONTAL;
		// places gridX to 2
		gbc_directionBox.gridx = 2;
		// places gridY to 2
		gbc_directionBox.gridy = 2;
		// adds the layout to panelTextBox
		panelTextbox.add(directionBox, gbc_directionBox);
		// generates a JPanel panelDirection
		final JPanel panelDirections = new JPanel();
		// places the bounds to (3, 166, 153, 104)
		panelDirections.setBounds(3, 166, 153, 104);
		// adds the panel to panelRight
		panelRight.add(panelDirections);
		// places layout to null
		panelDirections.setLayout(null);
		// places background colour to white
		buttonUp.setBackground(Color.WHITE);
		// places the bounds to (53, 11, 49, 21)
		buttonUp.setBounds(53, 11, 49, 21);
		// adds the panel to panelDirections
		panelDirections.add(buttonUp);
		// adds actionListener to buttonUP
		buttonUp.addActionListener(this);
		// places icon of buttonBall to ball.png
		buttonBall.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\ball.png"));
		// places the bounds to (48, 36, 61, 37)
		buttonBall.setBounds(48, 36, 61, 37);
		// adds the button to panelDirections
		panelDirections.add(buttonBall);
		// adds actionListener to buttonBall
		buttonBall.addActionListener(this);
		buttonDown.setToolTipText("");
		// places background colour to white
		buttonDown.setBackground(Color.WHITE);
		// places the bounds to (53, 78, 46, 21)
		buttonDown.setBounds(53, 78, 46, 21);
		// adds the button to panelDirections
		panelDirections.add(buttonDown);
		// adds actionListener to buttonDown
		buttonDown.addActionListener(this);
		// enables the button buttonLeft
		buttonLeft.setEnabled(true);
		// places background colour to white
		buttonLeft.setBackground(Color.WHITE);
		// places the bounds to (0, 42, 47, 21)
		buttonLeft.setBounds(0, 42, 47, 21);
		// adds the button to panelDirections
		panelDirections.add(buttonLeft);
		// adds actionListener to buttonLeft
		buttonLeft.addActionListener(this);
		// places background colour to white
		buttonRight.setBackground(Color.WHITE);
		// places the bounds to (42, 45, 47, 21)
		buttonRight.setBounds(109, 42, 45, 21);
		// adds the panel to panelRight
		panelDirections.add(buttonRight);
		// adds actionListener to buttonRight
		buttonRight.addActionListener(this);
		// places the bounds to (3, 272, 153, 117)
		mapPanel.setBounds(3, 272, 153, 117);
		// adds the panel to panelRight
		panelRight.add(mapPanel);
		// places layout to null
		mapPanel.setLayout(null);
		buttonMap.setDoubleBuffered(true);
		// places background colour to white
		buttonMap.setBackground(Color.WHITE);
		buttonMap.setAutoscrolls(true);
		// places the icon image to east.jpg
		buttonMap.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\east.jpg"));
		// places the bounds to (12, 7, 125, 96)
		buttonMap.setBounds(12, 7, 125, 96);
		// adds the button to mapPanel
		mapPanel.add(buttonMap);
		// adds actionListener to buttonMap
		buttonMap.addActionListener(this);
		// generates a JPanel panelRightButtons
		final JPanel panelRightButtons = new JPanel();
		// places the bounds to (3, 390, 153, 69)
		panelRightButtons.setBounds(3, 390, 153, 69);
		// adds the panel to panelRight
		panelRight.add(panelRightButtons);
		// places layout to null
		panelRightButtons.setLayout(null);
		// places the font to ("Tahoma", Font.BOLD, 8)
		buttonTwoPlayers.setFont(new Font("Tahoma", Font.BOLD, 8));
		// places the bounds to (4, 12, 74, 21)
		buttonTwoPlayers.setBounds(4, 12, 74, 21);
		// adds button to panelRightButtons
		panelRightButtons.add(buttonTwoPlayers);
		// adds actionListener to buttonTwoPlayers
		buttonTwoPlayers.addActionListener(this);
		// places the font to ("Tahoma", Font.BOLD, 8)
		buttonFourPlayers.setFont(new Font("Tahoma", Font.BOLD, 8));
		// places the bounds to (78, 12, 77, 21)
		buttonFourPlayers.setBounds(78, 12, 77, 21);
		// adds button to panelRightButtons
		panelRightButtons.add(buttonFourPlayers);
		// adds actionListener to buttonFourPlayers
		buttonFourPlayers.addActionListener(this);
		// places the font to ("Tahoma", Font.BOLD, 10)
		buttonMulti.setFont(new Font("Tahoma", Font.BOLD, 10));
		// places the bounds to (5, 42, 73, 21)
		buttonMulti.setBounds(5, 42, 73, 21);
		// adds button to panelRightButtons
		panelRightButtons.add(buttonMulti);
		// adds actionListener to buttonMulti
		buttonMulti.addActionListener(this);
		buttonExit.setDisabledIcon(null);
		// places the font to ("Tahoma", Font.BOLD, 10)
		buttonExit.setFont(new Font("Tahoma", Font.BOLD, 10));
		// places the bounds to (78, 42, 71, 21)
		buttonExit.setBounds(78, 42, 71, 21);
		// adds button to panelRightButtons
		panelRightButtons.add(buttonExit);
		// adds actionListener to buttonExit
		buttonExit.addActionListener(this);
		// generates a JPanel
		final JPanel panelBottom = new JPanel();
		// places background colour to orange
		panelBottom.setBackground(Color.GRAY);
		// places the border to new Color(0, 0, 255), 2, true
		panelBottom.setBorder(new LineBorder(new Color(0, 0, 255), 2, true));
		// places the bounds to (0, 475, 810, 50)
		panelBottom.setBounds(0, 475, 810, 50);
		// adds the panel to contentPane
		contentPane.add(panelBottom);
		// places layout to null
		panelBottom.setLayout(null);
		// places the font to ("Tahoma", Font.BOLD, 10)
		buttonAct.setFont(new Font("Tahoma", Font.BOLD, 10));
		// places background colour to white
		buttonAct.setBackground(Color.WHITE);
		// places icon to step.png
		buttonAct.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\step.png"));
		// places the bounds to (140, 10, 85, 21)
		buttonAct.setBounds(140, 10, 85, 21);
		panelBottom.add(buttonAct);
		// adds actionListener to buttonAct
		buttonAct.addActionListener(this);
		// places the font to ("Tahoma", Font.BOLD, 10)
		buttonRun.setFont(new Font("Tahoma", Font.BOLD, 10));
		// places background colour to white
		buttonRun.setBackground(Color.WHITE);
		// places icon to run.png
		buttonRun.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\run.png"));
		// places the bounds to (140, 10, 85, 21)
		buttonRun.setBounds(235, 10, 85, 21);
		// adds the button to panelBottom
		panelBottom.add(buttonRun);
		// adds actionListener to buttonRun
		buttonRun.addActionListener(this);
		// places the font to ("Tahoma", Font.BOLD, 10)
		buttonReset.setFont(new Font("Tahoma", Font.BOLD, 10));
		// places background colour to white
		buttonReset.setBackground(Color.WHITE);
		// places icon to resey.png
		buttonReset.setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\reset.png"));
		// places the bounds to (140, 10, 85, 21)
		buttonReset.setBounds(330, 10, 99, 21);
		// adds the button to panelBottom
		panelBottom.add(buttonReset);
		// adds actionListener to buttonReset
		buttonReset.addActionListener(this);
		// places the font to ("Tahoma", Font.BOLD, 10)
		final JSlider sliderSpeed = new JSlider(1, 10);
		// places background colour to white
		sliderSpeed.setBackground(Color.WHITE);
		// places the bounds to (140, 10, 85, 21)
		sliderSpeed.setBounds(579, 10, 200, 22);
		// adds the button to panelBottom
		panelBottom.add(sliderSpeed);
		final JLabel lblNewLabel_2 = new JLabel("Speed:");
		// places the font to ("Tahoma", Font.BOLD, 10)
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		// places the bounds to (529, 14, 45, 13)
		lblNewLabel_2.setBounds(529, 14, 45, 13);
		// adds the label to panelBottom
		panelBottom.add(lblNewLabel_2);
		// places background colour to green
		mainPanel.setBackground(Color.GRAY);
		// places the border to new LineBorder(Color.BLUE, 1, true)
		mainPanel.setBorder(new LineBorder(Color.BLACK, 1, true));
		// places the bounds to (0, 5, 649, 465)
		mainPanel.setBounds(0, 5, 649, 465);
		// adds the panel to contentPane
		contentPane.add(mainPanel);
		// places layout to null
		mainPanel.setLayout(null);
		// places background colour to white
		gamePanel.setBackground(Color.WHITE);
		// places the border to new LineBorder(Color.BLUE, 2, true)
		gamePanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		// places the bounds to (50, 30, 600, 400)
		gamePanel.setBounds(50, 30, 600, 400);
		// adds the panel to mainPanel
		mainPanel.add(gamePanel);
		// places the layuot to GridLayout(13,16)
		gamePanel.setLayout(new GridLayout(13, 16));
		// places background colour to black
		panelMouse.setBackground(Color.ORANGE);
		// places the bounds to (0, 30, 50, 400)
		panelMouse.setBounds(0, 30, 50, 400);
		// adds the panel to mainPanel
		mainPanel.add(panelMouse);
		// calls the method gameBoard()
		gameBoard();
		// calls the method players()
		players();
		// calling  method ballPos()
		ballPos();

	}

	private void gameBoard() {
		// loops value of i 13 times
		for (int i = 0; i <= 12; i++) {
			// loops value of j 16 times
			for (int j = 0; j <= 15; j++) {
				// generates a dummy button
				final JButton dummy = new JButton();
				// swaps the value of dummy to buttonGrid
				buttonGrid[i][j] = dummy;
				// places borderPainted to false
				dummy.setBorderPainted(false);
				// places background colour to white
				buttonGrid[i][j].setBackground(Color.white);
				// examines if i is greater than 6 and smaller than 9
				if (j >= 7 && j < 9) {
					// places the icon to wall.png
					buttonGrid[i][j].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\wall.png"));
				}
				// adds the buttonGrid to game panel
				gamePanel.add(buttonGrid[i][j]);

			}
		}
		// places the text to "east"
		directionBox.setText("EAST");
		// places tje text of optionBox to "2 PLRY"
		optionBox.setText("2 PLYR");

	}

	private void ballPos() {
		// places the value of bR to 6
		bR = 6;
		// places the value of bC to 4
		bC = 4;
		// places the image icon to ball.png
		buttonGrid[bR][bC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\ball.png"));
	}

	private void players() {
		// places the value of LR to 6
		leftR = 6;
		// places the value of leftC to 1
		leftC = 2;
		// places the value of rightR to 6
		rightR = 6;
		// places the value of rightC to 13
		rightC = 13;
		// places the image icon to baby1.png
		buttonGrid[leftR][leftC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\baby1.png"));
		// places the image icon to baby2.png
		buttonGrid[rightR][rightC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\baby2.png"));
	}

	private void playersFour() {
		// places the value of leftR to 6
		leftR = 6;
		// places the value of lc to 1
		leftC = 1;
		// places the image icon to baby1.png
		buttonGrid[leftR][leftC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\baby1.png"));
		// places the image icon to baby1.png
		buttonGrid[lTR][lTC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\baby1.png"));
		// places the image icon to baby2.png
		buttonGrid[rTR][rTC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\baby2.png"));
		// places the image icon to baby2.png
		buttonGrid[rBR][rBC].setIcon(new ImageIcon("D:\\NAMI\\Assignments of year 2\\Trial\\CBabyBallBounce\\src\\images\\baby2.png"));
	}

	@Override
	public void mouseClicked(final MouseEvent e) {

	}

	@Override
	public void mousePressed(final MouseEvent e) {

	}

	@Override
	public void mouseReleased(final MouseEvent e) {

	}

	@Override
	public void mouseEntered(final MouseEvent e) {

	}

	@Override
	public void mouseExited(final MouseEvent e) {

	}

	@Override
	public void mouseDragged(final MouseEvent e) {

	}

	@Override
	public void mouseMoved(final MouseEvent e) {

	}
}

