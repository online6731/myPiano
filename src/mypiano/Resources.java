package mypiano;

import ij.ImagePlus;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Resources {
    static int whiteKeyWidth = 24, whiteKeyHeight = 240, blackKeyWidth = 16, blackKeyHeight = 160;
    static ImagePlus ipWhiteButtonClicked, ipBlackButtonClicked, ipWhiteButton, ipBlackButton, pianoIcon, exitIcon;
    static int keyboardPanelWidth, keyboardPanelHeigth;
    static int keysDistanceFromLeft = 0, keysDistanceFromRight = 0, keysDistanceFromTop = 0, keysDistanceFromBottom = 0;
    public static void load() {
        keyboardPanelWidth = MainView.keyboardPanel.getWidth();
        keyboardPanelHeigth = MainView.keyboardPanel.getHeight();
        whiteKeyWidth = Math.round( (float)((float) (keyboardPanelWidth - keysDistanceFromLeft -keysDistanceFromRight) / 52.0));
        whiteKeyHeight = (keyboardPanelHeigth - keysDistanceFromTop - keysDistanceFromBottom);
        blackKeyWidth = whiteKeyWidth / 4 * 3;
        blackKeyHeight = whiteKeyHeight / 8 * 5;
        ipWhiteButtonClicked = new ImagePlus();
        ipWhiteButtonClicked.setProcessor(new ImagePlus("name", new ImageIcon("./Image/whiteButtonClicked.png").getImage()).getProcessor().resize(whiteKeyWidth, whiteKeyHeight));
        ipBlackButtonClicked = new ImagePlus();
        ipBlackButtonClicked.setProcessor(new ImagePlus("name", new ImageIcon("./Image/blackButtonClicked.png").getImage()).getProcessor().resize(blackKeyWidth, blackKeyHeight));
        ipWhiteButton = new ImagePlus();
        ipWhiteButton.setProcessor(new ImagePlus("name", new ImageIcon("./Image/whiteButton.png").getImage()).getProcessor().resize(whiteKeyWidth, whiteKeyHeight));
        ipBlackButton = new ImagePlus();
        ipBlackButton.setProcessor(new ImagePlus("name", new ImageIcon("./Image/blackButton.png").getImage()).getProcessor().resize(blackKeyWidth, blackKeyHeight));
        pianoIcon = new ImagePlus();
        pianoIcon.setProcessor(new ImagePlus("name", new ImageIcon("./Image/piano icon.png").getImage()).getProcessor().resize(30, 30));
        MainView.icon.setIcon(new ImageIcon(pianoIcon.getImage()));
        exitIcon = new ImagePlus();
        exitIcon.setProcessor(new ImagePlus("name", new ImageIcon("./Image/exit icon.png").getImage()).getProcessor().resize(30, 30));
        MainView.exit.setIcon(new ImageIcon(exitIcon.getImage()));
    }
    
}
