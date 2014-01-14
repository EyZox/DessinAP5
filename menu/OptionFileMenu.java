package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import main.MainFrame;

@SuppressWarnings("serial")
public class OptionFileMenu extends JFrame {

	public static final boolean OPEN = true;
	public static final boolean SAVE = false;
	
	public OptionFileMenu(final boolean ouvrir) {

		setPreferredSize(new java.awt.Dimension(600,400));
		final JFileChooser arbre = new JFileChooser();
		if(ouvrir) {
			setTitle("Ouvrir...");
		} else {
			setTitle("Enregistrer...");
			arbre.setApproveButtonText("Sauvegarder");
		}

		getContentPane().add(arbre);

		arbre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
					dispose();
				}else if(arg0.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
					if(ouvrir) {
						MainFrame.getCurrentDessin().open(arbre.getSelectedFile());
					} else {

						if(arbre.getSelectedFile() != null) {
							MainFrame.getCurrentDessin().saveAs(arbre.getSelectedFile());
						} else {
							MainFrame.getCurrentDessin().saveAs(new File(arbre.getName()));
						}
					}
					dispose();
				}
			}
		});

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
