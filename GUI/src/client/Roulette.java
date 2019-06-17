package client;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Roulette extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6177823262130803723L;
	
	
	private Image _myimage;
	private Image _ball;
	private float delta;

    public Roulette(String text){
        setIcon(new ImageIcon("img/Basic_roulette_wheel_1024x1024.png"));
    }

    public void setIcon(Icon icon) {
        super.setIcon(icon);
        if (icon instanceof ImageIcon)
        {
            _myimage = ((ImageIcon) icon).getImage();
        }
        _ball = new ImageIcon("img/ball.png").getImage();
        delta = 0;
    }

    @Override
    public void paint(Graphics g){
    	int x = Math.min(this.getWidth(), this.getHeight());
        g.drawImage(_myimage, 0, 0, x, x, null);
        g.drawImage(_ball, (int)(x / 2 + x * 0.45 * Math.sin(delta)), (int)(x / 2 - x * 0.45 * Math.cos(delta)), 10, 10, null);
    }

	public void nextSlot(int pos) {
		// TODO Auto-generated method stub
		delta = pos * 6.28f / 38;
		invalidate();
		this.updateUI();
	}

}
