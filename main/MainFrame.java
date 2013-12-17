/*
 * http://lite3.framapad.org/p/LiJcjJg102
 */

package main;

import java.awt.BorderLayout;

import javax.swing.*;

import toolbox.DefaultToolboxModel;
import toolbox.ToolboxPanel;

import dessin.DefaultDessinModel;
import dessin.Dessin;
import dessin.DessinModel;

import menu.MenuVue;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	/**
	 * @param args
	 */
	public MainFrame() {
		super("Dessin");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		DessinModel m = new DefaultDessinModel();
		Dessin dessinFrame = new Dessin(m);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(dessinFrame, BorderLayout.CENTER);
		getContentPane().add(new ToolboxPanel(new DefaultToolboxModel(m)), BorderLayout.SOUTH);
		
        setJMenuBar(new MenuVue());
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
