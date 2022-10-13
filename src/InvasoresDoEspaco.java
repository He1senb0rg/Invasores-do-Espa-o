import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;

public class InvasoresDoEspaco extends JFrame {

	private JPanel contentPane;
	boolean up= false;
	boolean isShooting = false;
	private JLabel BulletImg;
	int bullets = 4;
	int invasores = 4;
	int score = 0;
	int highScore = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvasoresDoEspaco frame = new InvasoresDoEspaco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean Colision(JLabel a, JLabel b) {
		//colisao
		boolean x = false;
		
		Rectangle r1 = a.getBounds();
		Rectangle r2 = b.getBounds();
		
		if(r2.intersects(r1)) {
			x = true;
		}else {
			x = false;
		}
		
		return x;
	}

	/**
	 * Create the frame.
	 */
	public InvasoresDoEspaco() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JogadorImage = new JLabel("New label");
		JogadorImage.setIcon(new ImageIcon("Images\\nave.png"));
		JogadorImage.setBounds(277, 531, 51, 48);
		contentPane.add(JogadorImage);
		
		JLabel Invasor1 = new JLabel("");
		Invasor1.setIcon(new ImageIcon("Images\\invasor.png"));
		Invasor1.setBounds(23, 40, 107, 113);
		contentPane.add(Invasor1);
		
		JLabel Invasor2 = new JLabel("");
		Invasor2.setIcon(new ImageIcon("Images\\invasor.png"));
		Invasor2.setBounds(156, 40, 107, 113);
		contentPane.add(Invasor2);
		
		JLabel Invasor3 = new JLabel("");
		Invasor3.setIcon(new ImageIcon("Images\\invasor.png"));
		Invasor3.setBounds(295, 40, 107, 113);
		contentPane.add(Invasor3);
		
		JLabel Invasor4 = new JLabel("");
		Invasor4.setIcon(new ImageIcon("Images\\invasor.png"));
		Invasor4.setBounds(439, 40, 107, 113);
		contentPane.add(Invasor4);
		
		JLabel LabelBalas = new JLabel("BULLETS: 0");
		LabelBalas.setFont(new Font("DialogInput", Font.PLAIN, 20));
		LabelBalas.setForeground(Color.GREEN);
		LabelBalas.setBounds(10, 11, 138, 31);
		contentPane.add(LabelBalas);
		
		JLabel lblScore = new JLabel("SCORE: 00000");
		lblScore.setForeground(Color.GREEN);
		lblScore.setFont(new Font("DialogInput", Font.PLAIN, 20));
		lblScore.setBounds(412, 11, 164, 31);
		contentPane.add(lblScore);
		
		JLabel lblHighscore = new JLabel("HIGH-SCORE: 00000");
		lblHighscore.setForeground(Color.GREEN);
		lblHighscore.setFont(new Font("DialogInput", Font.PLAIN, 20));
		lblHighscore.setBounds(595, 11, 224, 31);
		contentPane.add(lblHighscore);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//quando abrir a form mostrar o num de balas
				LabelBalas.setText("BULLETS: " + bullets);
				}
		});
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//andar pra esquerda
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					if(JogadorImage.getLocation().x > 0) {
						JogadorImage.setLocation((JogadorImage.getLocation().x)-10, JogadorImage.getLocation().y);
					}	
				}
				
				//andar pra direita
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(JogadorImage.getLocation().x < 770) {
						JogadorImage.setLocation((JogadorImage.getLocation().x)+10, JogadorImage.getLocation().y);
						}			
				}
				
				//bala
				if(isShooting == false) {
					if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						if(bullets > 0) {
							BulletImg = new JLabel();
							BulletImg.setBounds(JogadorImage.getLocation().x + 20, JogadorImage.getLocation().y, 10, 15);
							getContentPane().add(BulletImg);
							BulletImg.setIcon(new ImageIcon("Images\\bala.png"));
							isShooting = true;
						}	
					}	
				}
			}
		});
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				//verificar se ganhaste ou perdeste
				if(bullets <= 0) {
					if(invasores <= 0) {
						JOptionPane.showInternalMessageDialog(null, "YOU WIN :)",
					        "information", JOptionPane.INFORMATION_MESSAGE);
						invasores = 4;
						bullets = 4;
						LabelBalas.setText("BULLETS: " + bullets);
						Invasor1.setVisible(true);
						Invasor2.setVisible(true);
						Invasor3.setVisible(true);
						Invasor4.setVisible(true);
						Invasor1.setLocation(23, 40);
						Invasor2.setLocation(156, 40);
						Invasor3.setLocation(295, 40);
						Invasor4.setLocation(439, 40);
						}
					else if(invasores > 0) {
						invasores = 4;
						bullets = 4;
						LabelBalas.setText("BULLETS: " + bullets);
						if(score > highScore) {
							highScore = score;
						}		
						lblHighscore.setText("HIGH-SCORE: " + highScore);
						JOptionPane.showInternalMessageDialog(null, "YOU LOST :( \n SCORE: " + score,
						        "information", JOptionPane.INFORMATION_MESSAGE);
						score = 0;
						lblScore.setText("SCORE: " + score);
						LabelBalas.setText("BULLETS: " + bullets);
						Invasor1.setVisible(true);
						Invasor2.setVisible(true);
						Invasor3.setVisible(true);
						Invasor4.setVisible(true);
						Invasor1.setLocation(23, 40);
						Invasor2.setLocation(156, 40);
						Invasor3.setLocation(295, 40);
						Invasor4.setLocation(439, 40);
					}
				}
				
				//se a bala n acertar em nada
				if(isShooting == true) {
					BulletImg.setLocation((BulletImg.getLocation().x), BulletImg.getLocation().y - 10);
					if(BulletImg.getLocation().y <= 0) {
						isShooting = false;
						BulletImg.setVisible(false);
						bullets --;
						LabelBalas.setText("BULLETS: " + bullets);
						
					}
					//se a bala acertar num invasor
					else if(Colision(BulletImg, Invasor1) == true) {
						Invasor1.setVisible(false);
						Invasor1.setLocation((Invasor1.getLocation().x), 1000);
						isShooting = false;
						BulletImg.setVisible(false);
						invasores--;
						bullets --;
						score += 100;
						lblScore.setText("SCORE: " + score);
						LabelBalas.setText("BULLETS: " + bullets);
					}
					//se a bala acertar num invasor
					else if(Colision(BulletImg, Invasor2) == true) {
						Invasor2.setVisible(false);
						Invasor2.setLocation((Invasor2.getLocation().x), 1000);
						isShooting = false;
						BulletImg.setVisible(false);
						invasores--;
						bullets --;
						score += 100;
						lblScore.setText("SCORE: " + score);
						LabelBalas.setText("BULLETS: " + bullets);
					}
					//se a bala acertar num invasor
					else if(Colision(BulletImg, Invasor3) == true) {
						Invasor3.setVisible(false);
						Invasor3.setLocation((Invasor3.getLocation().x), 1000);
						isShooting = false;
						BulletImg.setVisible(false);
						invasores--;
						bullets --;
						score += 100;
						lblScore.setText("SCORE: " + score);
						LabelBalas.setText("BULLETS: " + bullets);
					}
					//se a bala acertar num invasor
					else if(Colision(BulletImg, Invasor4) == true) {
						Invasor4.setVisible(false);
						Invasor4.setLocation((Invasor4.getLocation().x), 1000);
						isShooting = false;
						BulletImg.setVisible(false);
						invasores--;
						bullets --;
						score += 100;
						lblScore.setText("SCORE: " + score);
						LabelBalas.setText("BULLETS: " + bullets);
					}	
				}		
				
				//andamento dos invasores pra esquerda e pra direita
				if(up == true) {
					Invasor1.setLocation((Invasor1.getLocation().x+2), Invasor1.getLocation().y);
					Invasor2.setLocation((Invasor2.getLocation().x+2), Invasor2.getLocation().y);
					Invasor3.setLocation((Invasor3.getLocation().x+2), Invasor3.getLocation().y);
					Invasor4.setLocation((Invasor4.getLocation().x+2), Invasor4.getLocation().y);
				if(Invasor4.getLocation().x >= 715)	{
					up= false;
				}
				}else {
					Invasor1.setLocation((Invasor1.getLocation().x-2), Invasor1.getLocation().y);
					Invasor2.setLocation((Invasor2.getLocation().x-2), Invasor2.getLocation().y);
					Invasor3.setLocation((Invasor3.getLocation().x-2), Invasor3.getLocation().y);
					Invasor4.setLocation((Invasor4.getLocation().x-2), Invasor4.getLocation().y);
					if(Invasor1.getLocation().x <= 0)	{
						up= true;
				}		
			}	
			}}, 20, 20);
			
		}
	}

