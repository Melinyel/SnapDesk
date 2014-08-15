package fr.knux14.snapdesk;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.habosa.javasnap.Snapchat;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public Snapchat scAccount;
	private JPanel insidePanel, btmPanel;
	private JLabel topLabel, snapLabel, storyLabel;
	private JButton takePicture, seeSnaps, seeStory, configuration;
	public MainFrame(Snapchat sc) {
		setSize(300, 420); // Weed :D
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle (Resources.programFName);
		setDefaultCloseOperation(3);
		
		this.scAccount = sc;
		
		setLayout(new BorderLayout());
		
		topLabel = new JLabel("Connect� en tant que " + sc.username);
		topLabel.setHorizontalAlignment(JLabel.CENTER);
		
		insidePanel = new JPanel();
		insidePanel.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		
		takePicture = new JButton("Envoyer un snap");
		g.fill = GridBagConstraints.HORIZONTAL;
		g.gridx = 0;
		g.gridy = 0;
		g.weightx = 0.0;
		g.gridwidth = 3;
		g.ipady = 40;
		insidePanel.add(takePicture, g);
		
		seeSnaps = new JButton("Mes snaps re�us");
		g.fill = GridBagConstraints.HORIZONTAL;
		g.gridx = 0;
		g.gridy = 3;
		g.ipady = 0;
		g.weighty = 1.0;
		insidePanel.add(seeSnaps, g);
		
		seeStory = new JButton("Amis et histoires");
		g.fill = GridBagConstraints.HORIZONTAL;
		g.gridx = 0;
		g.gridy = 4;
		insidePanel.add(seeStory, g);
		
		configuration = new JButton("Configuration");
		g.fill = GridBagConstraints.HORIZONTAL;
		g.gridx = 0;
		g.gridy = 6;
		g.weighty = 1.0;
		g.anchor = GridBagConstraints.PAGE_END;
		insidePanel.add(configuration, g);
		
		insidePanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));
		
		btmPanel = new JPanel();
		btmPanel.setLayout(new BoxLayout(btmPanel, BoxLayout.LINE_AXIS));
		snapLabel = new JLabel("0 nouveaux snaps", JLabel.LEFT);
		storyLabel = new JLabel("0 nouvelles histoires", JLabel.RIGHT);
		btmPanel.add(snapLabel, BorderLayout.WEST);
		btmPanel.add(new RefreshButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 * @TODO T�l�charger Snaps, histoire & tout
				 */
			}
		}), BorderLayout.CENTER);
		btmPanel.add(storyLabel, BorderLayout.EAST);
		
		add(topLabel, BorderLayout.NORTH);
		add(insidePanel, BorderLayout.CENTER);
		add(btmPanel, BorderLayout.SOUTH);
		
	}
	
}