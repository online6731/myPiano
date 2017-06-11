package mypiano;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Listeners {
    
}


class MainViewKeyListener implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("char: " + e.getKeyChar());
        System.out.println("note : " + Keyboard.charToNote.get(e.getKeyChar()));
        System.out.println("key : " + Keyboard.noteToKey.get(Keyboard.charToNote.get(e.getKeyChar())));
        Keyboard.find(Keyboard.noteToKey.get(Keyboard.charToNote.get(e.getKeyChar()))).press();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Keyboard.find(Keyboard.noteToKey.get(Keyboard.charToNote.get(e.getKeyChar()))).release();
    }
    
}

class PlaySavedSoundButtonActionListener implements ActionListener {

    public PlaySavedSoundButtonActionListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player.playFile("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\mySong.wav");
    }
}

class SaveButtonActionListener implements ActionListener {
    JPanel optionPanel;
    JTextField songLabel;
    public SaveButtonActionListener(JPanel optionPanel, JTextField songLabel) {
        this.optionPanel = optionPanel;
        this.songLabel = songLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(optionPanel);
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath() + ".myPiano"), "utf-8"));
            writer.write(songLabel.getText());
        } catch (IOException ex) {
        } finally { try {writer.close();} catch (Exception ex) {}}
    }
}


class StopButtonActionListener implements ActionListener {

    private final Recorder jsr;

    public StopButtonActionListener(Recorder jsr) {
        this.jsr = jsr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jsr.finish();
    }
}


class OpenButtonActionListener implements ActionListener {
    JPanel optionPanel;
    public OpenButtonActionListener(JPanel optionPanel) {
        this.optionPanel = optionPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(optionPanel);
        try {
            FileInputStream in = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        String text = "", line;
        FileReader fr = null;
        try {
            fr = new FileReader(fileChooser.getSelectedFile().getAbsolutePath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(fr);


        try {
            br = new BufferedReader(new FileReader(fileChooser.getSelectedFile().getAbsolutePath()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while ((line = br.readLine()) != null) text += line;
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


class PlayButtonActionListener implements ActionListener {
    JTextField songLabel;
    public PlayButtonActionListener(JTextField songLabel) {
        this.songLabel = songLabel;
    }

    @Override
    public synchronized void actionPerformed(ActionEvent e) {
        String songText = songLabel.getText();
        Matcher m = Pattern.compile("([^ ])+? ").matcher(songText);
        while(m.find()){
            //System.out.println("            " + songText.substring(m.start(), m.end() - 1));
            Player.playNote(songText.substring(m.start(), m.end() - 1), false);
        }
        /*
        for (int i = 0, j = 0; i + 1 < ss.length(); ) {
            while (j < ss.length() && !(ss.charAt(j) == ' ' || ss.charAt(j) == ',')) j++;
            Player.playNote(ss.substring(i, j), false);
            j++;
            i = j;

            try {
                Thread.sleep(800);
            } catch (InterruptedException ex) {
                Logger.getLogger(Keyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
*/
    }
}
