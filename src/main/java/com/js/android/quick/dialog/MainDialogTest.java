package com.js.android.quick.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainDialogTest extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea area1;
	private JTextArea area2;

	public MainDialogTest() {
		super();
		initUI();

		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initUI() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		area1 = new JTextArea(5, 20);
		area2 = new JTextArea(5, 20);
		area1.addMouseListener(new DMouseAdapter());
		area2.addMouseListener(new DMouseAdapter());
		c.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, area1, area2));
	}

	public static void main(String args[]) {
		new MainDialogTest();
	}

	private class DMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Object source = e.getSource();
			if (e.getClickCount() >= 2 && source instanceof JTextArea) {
				JTextArea sArea = (JTextArea) source;
				// show dialog window
				String rs = DDialog.showDialog(MainDialogTest.this, sArea.getText());
				sArea.setText(rs);
			}
		}
	}
}
