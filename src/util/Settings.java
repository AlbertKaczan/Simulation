package util;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Settings extends JFrame {
	public class SliderBlueprint {
		public int min, max, currVal;
		public String name;
		

		public SliderBlueprint(int min, int max, int currVal, String name) {
			super();
			this.min = min;
			this.max = max;
			this.currVal = currVal;
			this.name = name;
		}
	}
	
	private static final int SLIDER_HEIGTH = 37,
							 SLIDER_WIDTH = 210,
							 LABEL_WIDTH = 67,
							 LABEL_HEIGHT = 25;
	
	private ArrayList<SliderBlueprint> slidersBP = new ArrayList<SliderBlueprint>();
	
	private HashMap<String, JSlider> sliders = new HashMap<String, JSlider>();
	
	private JPanel contentPane;
	private JButton btnAddSlider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
					frame.addSlider(1, 50, 5, "Time");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa2");
//					frame.addSlider(0, 100, 50, "kurwa");
//					frame.addSlider(0, 100, 50, "kurwa");
					frame.createWindow();
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
	public Settings() {
		setResizable(false);
		setTitle("Settings");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // se mozesz zmienic to tutaj jak bys moze kiedys tam to zrobic chcial co nie
		
		getContentPane().setLayout(null);
		
//		JLabel label = new JLabel("123451234");
//		label.setBounds(10, 11, 67, 14);
//		getContentPane().add(label);
//		
//		JLabel label_1 = new JLabel("123451234");
//		label_1.setBounds(10, 50, 67, 14);
//		getContentPane().add(label_1);
//		
//		JSlider slider = new JSlider();
//		slider.setBounds(10, 61, 200, 26);
//		getContentPane().add(slider);
//		
		

	
	}

	public void addSlider(int min, int max, int currVal, String name) {
		addSlider(new SliderBlueprint(min, max, currVal, name));
	}
	
	public void addSlider(SliderBlueprint bp) {
		slidersBP.add(bp);
	}
	
	public JSlider getSlider(String name) {
		return sliders.get(name);
	}
	
	public void createWindow() {
		//getContentPane().removeAll();
		
		if (slidersBP == null)
			throw new RuntimeException("slidersBP == null");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width 	   = gd.getDisplayMode().getWidth();
		int maxHeight  = gd.getDisplayMode().getHeight();
		int counter    = 0,
			currHeight = 11,
			currWidth  = 10,
			maxSliders = 10;
		
		
//		btnAddSlider = new JButton("Add slider");
//		btnAddSlider.setBounds(10, currHeight, 89, 23);
//		btnAddSlider.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				addSlider(0, 100, 50, "kurwa");
//				createWindow();
//				repaint();
//			}
//		});;
//		getContentPane().add(btnAddSlider);
//		
//		currHeight += 30;
		
		for (SliderBlueprint bp : slidersBP) {
			JLabel label = new JLabel();
			JSlider slider = new JSlider();
			slider.setMinimum(bp.min);
			slider.setValue(bp.currVal);
			slider.setMaximum(bp.max);
			slider.setToolTipText(bp.name);
			slider.setBounds(currWidth, currHeight, 200, 26);
			slider.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					label.setText("" + slider.getValue());
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					label.setText("" + slider.getValue());
				}
			});
			slider.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
					label.setText("" + slider.getValue());
				}
			});
			slider.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
	
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
	
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					label.setText("" + slider.getValue());
				}
			});
			
			currHeight += 27;
			
			label.setText(slider.getValue() + "");
			label.setBounds(currWidth + 7, currHeight, 67, 14);
			
			currHeight += LABEL_HEIGHT;
			
			if (++counter % maxSliders == 0 || currHeight > maxHeight - 200) {
				currHeight = 11;
				currWidth += SLIDER_WIDTH;
			}
			
			sliders.put(bp.name, slider);
			contentPane.add(slider);
			getContentPane().add(label);
		}
		
		setBounds(100, 100, currWidth + SLIDER_WIDTH + 10,
				maxHeight - 150 > maxSliders * SLIDER_HEIGTH ?
					(maxSliders * SLIDER_HEIGTH) + ((maxSliders-1) * 27) + 11 
					:
					(maxHeight - 150) + 11);
		//slidersBP = null;
	}

	public JButton getBtnAddSlider() {
		return btnAddSlider;
	}
}




















