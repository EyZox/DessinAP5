package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import main.MainFrame;

@SuppressWarnings("serial")
public class OpenFileMenu extends JFrame {

	public OpenFileMenu() {
		super("Ouvrir...");
		setPreferredSize(new java.awt.Dimension(400,400));
		final JFileChooser arbre = new JFileChooser();
		getContentPane().add(arbre);
		
		arbre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
					dispose();
				}else if(arg0.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
					MainFrame.getCurrentDessin().open(arbre.getSelectedFile());
					dispose();
				}
			}
		});

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
