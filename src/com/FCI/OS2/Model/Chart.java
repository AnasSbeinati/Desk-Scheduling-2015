package com.FCI.OS2.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import javax.swing.JComponent;

public class Chart extends JComponent {
	ArrayList<Line2D.Double> lines;
	ArrayList<Integer> sequence;
	String method;

	public Chart(ArrayList<Integer> sequence1, String method) {
		super();
		this.method = method;
		this.sequence = new ArrayList<>(sequence1);
		lines = new ArrayList<Line2D.Double>();
		setPreferredSize(new Dimension(1000, 544));
		lines.add(new Line2D.Double(0, 100, 1000, 100));
		for (int i = 0; i < sequence.size() - 1; i++) {
			Line2D.Double line = new Line2D.Double(sequence.get(i) / 5,
					i * 30 + 110, sequence.get(i + 1) / 5, (i + 1) * 30 + 110);
			lines.add(line);
			lines.add(new Line2D.Double(sequence.get(i) / 5, 100, sequence
					.get(i) / 5, 90));
			repaint();
		}
		lines.add(new Line2D.Double(0, 100, 0, 90));
		lines.add(new Line2D.Double(999, 100, 999, 90));
		lines.add(new Line2D.Double(sequence.get(sequence.size() - 1) / 5, 100,
				sequence.get(sequence.size() - 1) / 5, 90));
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.red);
		g.drawString(method, 500, 50);
		g.setColor(Color.black);
		Collections.sort(sequence);
		for (int i = 0; i < sequence.size(); i++) {
			g.drawString(sequence.get(i).toString(), sequence.get(i) / 5,
					(i % 2 == 0 ? 75 : 90));
		}
		g.drawString("0", 0, 75);
		g.drawString("4999", 970, 90);
		g.setColor(Color.blue);
		for (Line2D.Double line : lines) {
			if ((int) line.getY1() == 100)
				g.setColor(Color.green);
			else
				g.setColor(Color.blue);
			g.drawLine((int) line.getX1(), (int) line.getY1(),
					(int) line.getX2(), (int) line.getY2());

			if ((int) line.getY2() > 100)
				g.fillOval((int) Math.ceil(line.getX1()-5 + .5),
						(int) Math.ceil(line.getY1()+.5)-5, 10, 10);
		}
		g.setColor(Color.blue);
		g.fillOval((int) Math.ceil(lines.get(2*sequence.size()-3).getX2()-5 + .5),
				(int) Math.ceil(lines.get(2*sequence.size()-3).getY2()+.5)-5, 10, 10);
	}
}
