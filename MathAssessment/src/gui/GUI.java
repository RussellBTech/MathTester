package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import mathTest.MathTest;
import mathTest.MathTest2;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class GUI {

	public JFrame frmMathDiagnosticsJutech;
	private JTextField AnswerField;
	private JPanel startPanel;
	private JPanel testPanel;
	private JTextField problemBox;
	private JPanel panel;
	private MathTest2 portentousTest;
	private int testLocation;
	private int totalScore;
	private int[] predecessors;
	private double[] distances;
	
	private final int DEPTH = 2;
	private final int WIDTH = 4;
	private final ButtonGroup lengthGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField resultsBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmMathDiagnosticsJutech.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		testLocation = 0;
		frmMathDiagnosticsJutech = new JFrame();
		frmMathDiagnosticsJutech.setTitle("Math Diagnostics JuT Alpha");
		frmMathDiagnosticsJutech.setBounds(100, 100, 510, 385);
		frmMathDiagnosticsJutech.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMathDiagnosticsJutech.getContentPane().setLayout(null);
		
		
		
		startPanel = new JPanel();
		startPanel.setBounds(0, 0, 494, 326);
		frmMathDiagnosticsJutech.getContentPane().add(startPanel);
		startPanel.setLayout(null);
		
		JButton btnStartTest = new JButton("Start Test");
		btnStartTest.setBounds(160, 217, 171, 23);
		startPanel.add(btnStartTest);
		btnStartTest.setToolTipText("Click this to begin a diagnostic");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 30, 140, 106);
		panel_1.setBorder(new TitledBorder(null, "Length", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		startPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(6, 46, 128, 23);
		lengthGroup.add(rdbtnNewRadioButton);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(6, 72, 128, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		lengthGroup.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(6, 20, 128, 23);
		panel_1.add(rdbtnNewRadioButton_2);
		lengthGroup.add(rdbtnNewRadioButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(341, 30, 140, 106);
		panel_2.setBorder(new TitledBorder(null, "Difficulty", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		startPanel.add(panel_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		buttonGroup.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("New radio button");
		buttonGroup.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("New radio button");
		buttonGroup.add(rdbtnNewRadioButton_5);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton_5)
						.addComponent(rdbtnNewRadioButton_4)
						.addComponent(rdbtnNewRadioButton_3))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnNewRadioButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_5)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		resultsBox = new JTextField();
		resultsBox.setHorizontalAlignment(SwingConstants.CENTER);
		resultsBox.setText("Empty and Invisible");
		resultsBox.setEditable(false);
		resultsBox.setBounds(160, 89, 171, 20);
		startPanel.add(resultsBox);
		resultsBox.setColumns(10);
		resultsBox.setVisible(false);
		btnStartTest.addActionListener(new startListener());
		startPanel.setVisible(true);
		
		testPanel = new JPanel();
		testPanel.setLocation(0, 0);
		testPanel.setSize(494, 326);
		frmMathDiagnosticsJutech.getContentPane().add(testPanel);
		testPanel.setVisible(false);
		testPanel.setLayout(null);
		
		AnswerField = new JTextField();
		AnswerField.setBounds(116, 158, 114, 20);
		AnswerField.setHorizontalAlignment(SwingConstants.CENTER);
		AnswerField.setBackground(Color.WHITE);
		testPanel.add(AnswerField);
		AnswerField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(260, 157, 88, 23);
		testPanel.add(btnSubmit);
		btnSubmit.addActionListener(new submitListener());
		
		panel = new JPanel();
		panel.setBounds(110, 107, 244, 43);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Problem", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		testPanel.add(panel);
		panel.setLayout(null);
		
		problemBox = new JTextField();
		problemBox.setBounds(6, 16, 232, 20);
		panel.add(problemBox);
		problemBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		problemBox.setEditable(false);
		problemBox.setHorizontalAlignment(SwingConstants.CENTER);
		problemBox.setBackground(Color.WHITE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMathDiagnosticsJutech.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
	}
	
	public class startListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			startPanel.setVisible(false);
			portentousTest = new MathTest2(DEPTH, WIDTH);
			problemBox.setText(portentousTest.getEquation(0));
			testPanel.setVisible(true);
			totalScore = 0;
		}
	}
	
	public class submitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String answer = AnswerField.getText();
			String[] cleaned = answer.split(" ");
			answer = "";
			for(String string: cleaned) {
				answer += string;
			}
			int temp = testLocation;
			if(answer.equals(portentousTest.getAnswer(testLocation))) {
				
				if(testLocation == portentousTest.getDesiredDestination()) {
					testPanel.setVisible(false);
					startPanel.setVisible(true);
					resultsBox.setVisible(true);
					resultsBox.setText("Score: " + totalScore);
				} else {
					testLocation = portentousTest.moveTowardsGoal(testLocation);
					totalScore += portentousTest.getStructure().getEdge(temp, testLocation).getWeight();
					problemBox.setText(portentousTest.getEquation(testLocation));
				}
				
			} else {
				if(testLocation == DEPTH * WIDTH - 1) {
					testPanel.setVisible(false);
					startPanel.setVisible(true);
					resultsBox.setVisible(true);
					resultsBox.setText("Score: " + totalScore);
				} else {
					testLocation = portentousTest.failForward(testLocation);
					totalScore += portentousTest.getStructure().getEdge(temp, testLocation).getWeight();
				
					problemBox.setText(portentousTest.getEquation(testLocation));
				}
			}
			
			
			//System.out.println(answer);
		}
	}

	public JPanel getStartPanel() {
		return startPanel;
	}
}
