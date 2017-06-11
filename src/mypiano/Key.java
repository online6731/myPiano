package mypiano;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Key {
    JPanel keyboardPanel;
    JLabel label;
    String note;
    int number;
    int order;
    int type;
    
    public Key(int number) {
        this.keyboardPanel = Keyboard.panel;
        this.number = number;
        this.note = Keyboard.keyToNote.get(number);
        type = (Keyboard.whiteKeyNumber.contains(number) ? 1 : 2);
        order = Keyboard.keyNumberHashMap.get(number);
        label = new JLabel();
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    press();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    release();
                }

            });
    }
    
    public void draw() {
        if (type == 1) label.setIcon(new ImageIcon(Resources.ipWhiteButton.getImage()));
        else label.setIcon(new ImageIcon(Resources.ipBlackButton.getImage()));
        label.setFocusable(false);
        keyboardPanel.add(label);
        if (type == 1) label.setBounds(Resources.keysDistanceFromLeft + order * Resources.whiteKeyWidth, Resources.keysDistanceFromTop, Resources.whiteKeyWidth, Resources.whiteKeyHeight);
        else label.setBounds(Resources.keysDistanceFromLeft + Keyboard.keyNumberHashMap.get(number - 1) * Resources.whiteKeyWidth + Resources.whiteKeyWidth - Resources.blackKeyWidth / 2, Resources.keysDistanceFromTop, Resources.blackKeyWidth, Resources.blackKeyHeight);
        label.setVisible(true);
        
    }
    
    public void press(){
        System.out.println(number);
        Player.playNote(Keyboard.keyToNote.get(number), true);
        if (type == 1){
            label.setIcon(new ImageIcon(Resources.ipWhiteButtonClicked.getImage()));
        } else{
            
            label.setIcon(new ImageIcon(Resources.ipBlackButtonClicked.getImage()));
        }
        
    }
    
    public void release(){
        if (type == 1){
            
            label.setIcon(new ImageIcon(Resources.ipWhiteButton.getImage()));
        } else{
            
            label.setIcon(new ImageIcon(Resources.ipBlackButton.getImage()));
        }
        
    }
    
}
