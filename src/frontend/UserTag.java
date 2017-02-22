package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class UserTag extends JLabel{
	public UserTag(String name){
		this.setText(name);
		this.setIcon(getIcon());
		this.setPreferredSize(new Dimension(85,20));
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.white);
		this.setOpaque(true);
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setTarget();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void setTarget(){
		ChatPanel.target = this.getText();
	}
}