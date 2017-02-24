package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class UserTag extends JLabel{
	public UserTag(String name, String target){
		if (name.equals(target))
			this.setBackground(Color.white);
		else
			this.setBackground(Color.DARK_GRAY);
		
		this.setText(name);
		this.setIcon(getIcon());
		this.setPreferredSize(new Dimension(85,20));
		this.setForeground(Color.white);
		this.setOpaque(true);
		this.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setTarget();
				setBackground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}
	
	public void setTarget(){
		ChatPanel.target = this.getText();
	}
}