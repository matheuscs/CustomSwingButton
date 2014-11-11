package com.tests.swing;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.FlowLayout;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	 * @throws IOException 
	 */
	public Main() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		final ImageIcon regular = new ImageIcon(ClassLoader.getSystemResource("pawn(regular).png"));
		final ImageIcon hovering = new ImageIcon(ClassLoader.getSystemResource("pawn(hovering).png"));
		final ImageIcon clicking = new ImageIcon(ClassLoader.getSystemResource("pawn(clicking).png"));
		final BufferedImage img = ImageIO.read(ClassLoader.getSystemResource("pawn(regular).png"));

		final JLabel lblNewLabel = new JLabel(regular);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
				if( (pixel>>24) == 0x00 ) {
					return;
				}
				else { 
					System.out.println("I was clicked! I really look like a button.");
					lblNewLabel.setIcon(clicking);
				}
				super.mousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
				if( (pixel>>24) == 0x00 ) {
					lblNewLabel.setIcon(regular);
				}
				else {
					lblNewLabel.setIcon(hovering);					
				}
				super.mouseReleased(e);
			}
		});
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
				if( (pixel>>24) == 0x00 ) {
					lblNewLabel.setIcon(regular);
					lblNewLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				else {
					lblNewLabel.setIcon(hovering);
					lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				super.mouseMoved(e);
			}
		});
		contentPane.add(lblNewLabel);
	}
}
