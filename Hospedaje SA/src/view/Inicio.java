package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sqlDB.DatabaseConnection;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class Inicio extends JFrame {


	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reserva de habitacion");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(206, 11, 228, 30);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 52, 673, 209);
		contentPane.add(separator);
		
		JButton prueba = new JButton("Prueba");
		prueba.addActionListener(  new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
				
				JOptionPane.showMessageDialog(null, "pruebaa");
			}   
		}	);
		prueba.setBounds(122, 150, 89, 23);
		contentPane.add(prueba);
	}
}
