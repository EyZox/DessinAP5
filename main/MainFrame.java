/*
 * http://lite3.framapad.org/p/LiJcjJg102
 */

package main;

import java.awt.BorderLayout;

import javax.swing.*;

import toolbox.DefaultToolboxModel;
import toolbox.ToolboxModel;
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
	
	private static DessinModel currentDessin;
	
	public MainFrame() {
		super("Dessin");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		currentDessin = new DefaultDessinModel(null);
		Dessin dessinFrame = new Dessin(currentDessin);
		ToolboxModel tm = new DefaultToolboxModel(currentDessin);
		ToolboxPanel tp = new ToolboxPanel(tm);
		currentDessin.setToolboxModel(tm);
		
		
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(dessinFrame, BorderLayout.CENTER);
		getContentPane().add(tp, BorderLayout.SOUTH);
		
        setJMenuBar(new MenuVue());
		          
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MainFrame();
	}


	public static DessinModel getCurrentDessin() {
		return currentDessin;
	}


	public static void setCurrentDessin(DessinModel currentDessin) {
		MainFrame.currentDessin = currentDessin;
	}

}
