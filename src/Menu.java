import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INVASORES DO ESPA\u00C7O");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 60));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(69, 11, 736, 134);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("JOGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				//fechar menu e abrir a gameplay
				
				setVisible(false);

				Menu menuJogo = new Menu();
				menuJogo.setVisible(false);
				
				InvasoresDoEspaco jogo = new InvasoresDoEspaco();
				jogo.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(332, 267, 165, 70);
		contentPane.add(btnNewButton);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fechar jogo
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSair.setBackground(Color.BLACK);
		btnSair.setForeground(Color.GREEN);
		btnSair.setBounds(332, 385, 165, 70);
		contentPane.add(btnSair);
		
		JLabel lblJavaEdition = new JLabel("JAVA EDITION");
		lblJavaEdition.setForeground(Color.GREEN);
		lblJavaEdition.setFont(new Font("DialogInput", Font.ITALIC, 50));
		lblJavaEdition.setBounds(24, 84, 364, 114);
		contentPane.add(lblJavaEdition);
		
		JLabel lblCriadoPorAndr = new JLabel("Criado por:");
		lblCriadoPorAndr.setForeground(Color.GREEN);
		lblCriadoPorAndr.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCriadoPorAndr.setBounds(10, 482, 110, 44);
		contentPane.add(lblCriadoPorAndr);
		
		JLabel lblAndrSantosN = new JLabel("André Santos ");
		lblAndrSantosN.setForeground(Color.GREEN);
		lblAndrSantosN.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblAndrSantosN.setBounds(10, 512, 351, 44);
		contentPane.add(lblAndrSantosN);
		
		JLabel lblFbioBatistaNesquecime = new JLabel("Fábio Batista");
		lblFbioBatistaNesquecime.setForeground(Color.GREEN);
		lblFbioBatistaNesquecime.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblFbioBatistaNesquecime.setBounds(10, 538, 351, 44);
		contentPane.add(lblFbioBatistaNesquecime);
		
		JLabel lblGonaloAlbuquerqueN = new JLabel("Gonçalo Albuquerque ");
		lblGonaloAlbuquerqueN.setForeground(Color.GREEN);
		lblGonaloAlbuquerqueN.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblGonaloAlbuquerqueN.setBounds(10, 567, 397, 44);
		contentPane.add(lblGonaloAlbuquerqueN);
	}
}
