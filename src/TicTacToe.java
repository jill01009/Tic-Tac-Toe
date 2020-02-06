import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class TicTacToe {

	private JFrame frame;
	JButton btn1=new JButton(""),
			btn2=new JButton(""),
			btn3=new JButton(""),
			btn4=new JButton(""),
			btn5=new JButton(""),
			btn6=new JButton(""),
			btn7=new JButton(""),
			btn8=new JButton(""),
			btn9=new JButton("");
	JLabel lblNewLabel_1,xScore,oScore;
	static int count =0;
	boolean win =false;
	int countX=0,countO=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToe() {
		initialize();
		addAction();
	}
	
	// Display X or O
	int x_or_o=0;
	
	//function to add action to the buttons
	public void addAction()
	{
		JButton [] buttons = {btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};
		for (JButton each:buttons)
		{
			each.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					        if(each.getText().equals("")){
							if (x_or_o % 2==0)
										{
										   each.setText("X");
										   each.setForeground(new Color(108, 122, 137));
										   lblNewLabel_1.setText("O's turn now");
										   getTheWinner();
										}
								else{
									each.setText("O");
									each.setForeground(new Color(242, 120, 75));
									lblNewLabel_1.setText("X's turn now");
									getTheWinner();
									}
							x_or_o++; count++; 
							}
			}
			});
		}
	}
	
// Find the winner
	public void getTheWinner()
	{
		if (!btn1.getText().equals("")&&btn1.getText().equals(btn2.getText())&&btn1.getText().equals(btn3.getText())) 
			winEffect(btn1,btn2,btn3);
		if (!btn4.getText().equals("")&&btn4.getText().equals(btn5.getText())&&btn4.getText().equals(btn6.getText())) 
			winEffect(btn4,btn5,btn6);
		if (!btn7.getText().equals("")&&btn7.getText().equals(btn8.getText())&&btn7.getText().equals(btn9.getText()))
			winEffect(btn7,btn8,btn9);
		if (!btn1.getText().equals("")&&btn1.getText().equals(btn4.getText())&&btn1.getText().equals(btn7.getText())) 
			winEffect(btn7,btn4,btn1);
		if (!btn2.getText().equals("")&&btn2.getText().equals(btn5.getText())&&btn2.getText().equals(btn8.getText()))
			winEffect(btn8,btn5,btn2);
		if (!btn3.getText().equals("")&&btn3.getText().equals(btn6.getText())&&btn3.getText().equals(btn9.getText())) 
			winEffect(btn3,btn6,btn9);
		if (!btn3.getText().equals("")&&btn3.getText().equals(btn5.getText())&&btn3.getText().equals(btn7.getText()))
			winEffect(btn7,btn5,btn3);
		if (!btn1.getText().equals("")&&btn1.getText().equals(btn5.getText())&&btn1.getText().equals(btn9.getText())) 
			winEffect(btn1,btn5,btn9);
		if ((count==8)&&(win==false)) lblNewLabel_1.setText("No one wins");
	}
	
// Win Effects 
	public void winEffect(JButton b1, JButton b2, JButton b3)
	{	
		win =true;
		if (b1.getText().equals("X"))
		{
			b1.setForeground(new Color (46, 49, 49));
			b1.setFont(new Font(".SF NS Text", Font.BOLD, 30));
			b2.setForeground(new Color (46, 49, 49));
			b2.setFont(new Font(".SF NS Text", Font.BOLD, 30));
			b3.setForeground(new Color (46, 49, 49));
			b3.setFont(new Font(".SF NS Text", Font.BOLD, 30));
			countX++; xScore.setText(countX+"");
		}
		else 
		{
			b1.setForeground(new Color (241, 90, 34));
			b1.setFont(new Font(".SF NS Text", Font.BOLD, 30));
			b2.setForeground(new Color (241, 90, 34));
			b2.setFont(new Font(".SF NS Text", Font.BOLD, 30));
			b3.setForeground(new Color (241, 90, 34));
			b3.setFont(new Font(".SF NS Text", Font.BOLD, 30));
			countO++;oScore.setText(countO+"");
		}
		String msg = b1.getText() + " IS THE WINNER";
		lblNewLabel_1.setText(msg);
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(77, 78, 249, 241);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
// Buttons format
		btn1.setBounds(6, 6, 80, 80);
		btn1.setFont(new Font("AppleGothic", Font.BOLD, 30));
		panel.add(btn1);
		
		btn2.setFont(new Font("AppleGothic", Font.BOLD, 30));
		btn2.setBounds(84, 6, 80, 80);
		panel.add(btn2);
		
		btn3.setFont(new Font("AppleGothic", Font.BOLD, 30));
		btn3.setBounds(162, 6, 80, 80);
		panel.add(btn3);
		
		btn4.setFont(new Font("AppleGothic", Font.BOLD, 30));
		btn4.setBounds(6, 83, 80, 80);
		panel.add(btn4);
		
		btn5.setFont(new Font("AppleGothic", Font.BOLD, 30));
		btn5.setBounds(84, 83, 80, 80);
		panel.add(btn5);
		
		btn6.setFont(new Font("AppleGothic", Font.BOLD, 30));
		btn6.setBounds(162, 83, 80, 80);
		panel.add(btn6);
		
		btn7.setFont(new Font("AppleGothic", Font.BOLD, 30));
		btn7.setBounds(6, 160, 80, 80);
		panel.add(btn7);
		
		btn8.setFont(new Font("AppleGothic", Font.BOLD, 30));
		btn8.setBounds(84, 160, 80, 80);
		panel.add(btn8);
		
		btn9.setFont(new Font("AppleGothic", Font.BOLD, 30));
		btn9.setBounds(162, 160, 80, 80);
		panel.add(btn9);
		
// Title format
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(83, 17, 232, 49);
		panel_2.setBackground(new Color (242, 121, 53));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Let's play");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT", Font.BOLD, 24));
		lblNewLabel_1.setBounds(6, 6, 220, 37);
		panel_2.add(lblNewLabel_1);
		
// Button Replay set up
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(159, 326, 85, 39);
		frame.getContentPane().add(panel_1);
		JButton btnReplay = new JButton("Replay");
		btnReplay.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) 
			{
				JButton [] buttons ={btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};
				for (JButton btn : buttons) 
				{
					btn.setText("");
					btn.setFont(new Font("AppleGothic", Font.BOLD, 30));
				}
				lblNewLabel_1.setText("Let's play");
				count =0;
				win = false;
				x_or_o=0;
			}
		});
		panel_1.add(btnReplay);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(6, 78, 65, 241);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		// Score bulletin
		
		JLabel lblX = new JLabel("X");
		lblX.setOpaque(true);
		lblX.setBackground(new Color(250, 190, 88));
		lblX.setFont(new Font("Dialog", Font.BOLD, 22));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(0, 0, 65, 35);
		panel_3.add(lblX);
		
		JLabel lblO = new JLabel("O");
		lblO.setOpaque(true);
		lblO.setHorizontalAlignment(SwingConstants.CENTER);
		lblO.setBackground(new Color(250, 190, 88));
		lblO.setFont(new Font("Dialog", Font.BOLD, 22));
		lblO.setBounds(0, 141, 65, 35);
		panel_3.add(lblO);
		
		xScore = new JLabel("");
		xScore.setOpaque(true);
		xScore.setBackground(Color.BLACK);
		xScore.setForeground(Color.WHITE);
		xScore.setFont(new Font("Dialog", Font.BOLD, 30));
		xScore.setHorizontalAlignment(SwingConstants.CENTER);
		xScore.setBounds(0, 34, 65, 68);
		panel_3.add(xScore);
		
		oScore = new JLabel("");
		oScore.setOpaque(true);
		oScore.setBackground(Color.BLACK);
		oScore.setForeground(Color.WHITE);
		oScore.setFont(new Font("Dialog", Font.BOLD, 30));
		oScore.setBounds(0, 173, 65, 68);
		panel_3.add(oScore);
	}
}

