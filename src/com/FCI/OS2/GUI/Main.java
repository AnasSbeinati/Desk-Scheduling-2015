package com.FCI.OS2.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import com.FCI.OS2.Model.Chart;

import java.awt.Color;

import com.FCI.OS2.Model.Simulater;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField i;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField req;
	private JTextField FCFS;
	private JTextField SCAN;
	private JTextField CLOOK;
	private JTextField SSTF;
	private JTextField CSCAN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 619);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRequests = new JLabel("Requests");
		lblRequests.setBounds(12, 13, 56, 16);
		contentPane.add(lblRequests);

		JLabel lblInitialHeadPosition = new JLabel("Initial Head Position");
		lblInitialHeadPosition.setBounds(12, 85, 112, 16);
		contentPane.add(lblInitialHeadPosition);

		i = new JTextField();
		i.setBounds(12, 114, 112, 22);
		contentPane.add(i);
		i.setColumns(10);

		ArrayList<Integer> result1, result2, result3, result4, result5;
		JButton btnSimulate = new JButton("Simulate");
		btnSimulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int ini = Integer.parseInt(i.getText().trim());
					if (ini < 0 || ini > 4999) {
						JOptionPane.showMessageDialog(null,
								"initial value out of boundaries!");
					} else {
						Simulater simulator = new Simulater(req.getText()
								.trim(), ini);
						ArrayList<Integer> result;
						// FCFS
						result = simulator.FCFS();
						FCFS.setText(result.toString());
						String res = simulator.getTotalHeadMovement(result)
								.toString();
						textField_1.setText(res);
						// SSTF
						result = simulator.SSTF();
						SSTF.setText(result.toString());
						res = simulator.getTotalHeadMovement(result).toString();
						textField_2.setText(res);
						// C-SCAN
						result = simulator.CSCAN();
						CSCAN.setText(result.toString());
						res = simulator.getTotalHeadMovement(result).toString();
						textField_4.setText(res);
						// SCAN
						result = simulator.SCAN();
						SCAN.setText(result.toString());
						res = simulator.getTotalHeadMovement(result).toString();
						textField_3.setText(res);
						// C-look
						result = simulator.CLOOK();
						CLOOK.setText(result.toString());
						res = simulator.getTotalHeadMovement(result).toString();
						textField_5.setText(res);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Input Error!");
				}
			}
		});
		btnSimulate.setBounds(12, 149, 408, 25);
		contentPane.add(btnSimulate);

		JLabel lblNewLabel = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel.setBounds(12, 187, 831, 16);
		contentPane.add(lblNewLabel);

		JLabel lblTheResults = new JLabel("The Results");
		lblTheResults.setBounds(186, 210, 76, 16);
		contentPane.add(lblTheResults);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(12, 243, 408, 98);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("FCFS: sequence");
		lblNewLabel_1.setBounds(12, 13, 99, 16);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("total head movement");
		lblNewLabel_2.setBounds(12, 66, 121, 16);
		panel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(160, 63, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);

		FCFS = new JTextField();
		FCFS.setColumns(10);
		FCFS.setBounds(12, 31, 384, 22);
		panel.add(FCFS);

		JButton btnNewButton = new JButton("Chart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {
					public void run() {
						int ini = Integer.parseInt(i.getText().trim());
						Simulater simulator = new Simulater(req.getText()
								.trim(), ini);
						ArrayList<Integer> result;
						// FCFS
						result = simulator.FCFS();
						Chart lineComponent = new Chart(result, "FCFS");
						JOptionPane.showMessageDialog(null, lineComponent);
					}
				};
				SwingUtilities.invokeLater(r);
			}
		});
		btnNewButton.setBounds(299, 62, 97, 25);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 218, 185));
		panel_1.setBounds(435, 243, 408, 98);
		contentPane.add(panel_1);

		JLabel lblSstfSequence = new JLabel("SSTF: sequence");
		lblSstfSequence.setBounds(12, 13, 99, 16);
		panel_1.add(lblSstfSequence);

		JLabel label_1 = new JLabel("total head movement");
		label_1.setBounds(12, 66, 121, 16);
		panel_1.add(label_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 63, 116, 22);
		panel_1.add(textField_2);

		SSTF = new JTextField();
		SSTF.setColumns(10);
		SSTF.setBounds(12, 31, 384, 22);
		panel_1.add(SSTF);

		JButton button_3 = new JButton("Chart");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {
					public void run() {
						int ini = Integer.parseInt(i.getText().trim());
						Simulater simulator = new Simulater(req.getText()
								.trim(), ini);
						ArrayList<Integer> result;
						// SSTF
						result = simulator.SSTF();
						Chart lineComponent = new Chart(result, "SSTF");
						JOptionPane.showMessageDialog(null, lineComponent);
					}
				};
				SwingUtilities.invokeLater(r);
			}
		});
		button_3.setBounds(299, 62, 97, 25);
		panel_1.add(button_3);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 218, 185));
		panel_2.setBounds(12, 354, 408, 98);
		contentPane.add(panel_2);

		JLabel lblScanSequence = new JLabel("SCAN: sequence");
		lblScanSequence.setBounds(12, 13, 99, 16);
		panel_2.add(lblScanSequence);

		JLabel label_2 = new JLabel("total head movement");
		label_2.setBounds(12, 66, 121, 16);
		panel_2.add(label_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 63, 116, 22);
		panel_2.add(textField_3);

		SCAN = new JTextField();
		SCAN.setColumns(10);
		SCAN.setBounds(12, 31, 384, 22);
		panel_2.add(SCAN);

		JButton button = new JButton("Chart");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable r = new Runnable() {
					public void run() {
						int ini = Integer.parseInt(i.getText().trim());
						Simulater simulator = new Simulater(req.getText()
								.trim(), ini);
						ArrayList<Integer> result;
						// SCAN
						result = simulator.SCAN();
						Chart lineComponent = new Chart(result, "SCAN");
						JOptionPane.showMessageDialog(null, lineComponent);
					}
				};
				SwingUtilities.invokeLater(r);
			}
		});
		button.setBounds(299, 62, 97, 25);
		panel_2.add(button);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 218, 185));
		panel_3.setBounds(435, 354, 408, 98);
		contentPane.add(panel_3);

		JLabel lblCscanSequence = new JLabel("C-SCAN: sequence");
		lblCscanSequence.setBounds(12, 13, 99, 16);
		panel_3.add(lblCscanSequence);

		JLabel label_3 = new JLabel("total head movement");
		label_3.setBounds(12, 66, 121, 16);
		panel_3.add(label_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 63, 116, 22);
		panel_3.add(textField_4);

		CSCAN = new JTextField();
		CSCAN.setColumns(10);
		CSCAN.setBounds(12, 31, 384, 22);
		panel_3.add(CSCAN);

		JButton button_2 = new JButton("Chart");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable r = new Runnable() {
					public void run() {
						int ini = Integer.parseInt(i.getText().trim());
						Simulater simulator = new Simulater(req.getText()
								.trim(), ini);
						ArrayList<Integer> result;
						// C-SCAN
						result = simulator.CSCAN();
						Chart lineComponent = new Chart(result, "C-SCAN");
						JOptionPane.showMessageDialog(null, lineComponent);
					}
				};
				SwingUtilities.invokeLater(r);
			}
		});
		button_2.setBounds(299, 62, 97, 25);
		panel_3.add(button_2);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(255, 218, 185));
		panel_4.setBounds(229, 465, 408, 98);
		contentPane.add(panel_4);

		JLabel lblClookSequence = new JLabel("C-LOOK: sequence");
		lblClookSequence.setBounds(12, 13, 99, 16);
		panel_4.add(lblClookSequence);

		JLabel label_4 = new JLabel("total head movement");
		label_4.setBounds(12, 66, 121, 16);
		panel_4.add(label_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 63, 116, 22);
		panel_4.add(textField_5);

		CLOOK = new JTextField();
		CLOOK.setColumns(10);
		CLOOK.setBounds(12, 31, 384, 22);
		panel_4.add(CLOOK);

		JButton button_1 = new JButton("Chart");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable r = new Runnable() {
					public void run() {
						int ini = Integer.parseInt(i.getText().trim());
						Simulater simulator = new Simulater(req.getText()
								.trim(), ini);
						ArrayList<Integer> result;
						// C-LOKK
						result = simulator.CLOOK();
						Chart lineComponent = new Chart(result, "C-LOOK");
						JOptionPane.showMessageDialog(null, lineComponent);
					}
				};
				SwingUtilities.invokeLater(r);
			}
		});
		button_1.setBounds(299, 62, 97, 25);
		panel_4.add(button_1);

		req = new JTextField();
		req.setBounds(12, 42, 408, 22);
		contentPane.add(req);
		req.setColumns(10);
	}
}
