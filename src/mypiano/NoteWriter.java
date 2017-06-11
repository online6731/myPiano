package mypiano;

import java.text.DecimalFormat;
import javax.swing.JTextField;


public class NoteWriter{
    static Boolean isRunning = false;
    static double lastNote, interval;
    static JTextField songLabel;
    
    static void set(JTextField songLabel) {
        NoteWriter.songLabel = songLabel;
        isRunning = true;
        lastNote = System.currentTimeMillis();
    }
    
    public static void writeNote(String note){
        interval = System.currentTimeMillis() - lastNote;
        interval %= 100000;
        interval /= 1000;
        lastNote = System.currentTimeMillis();
        songLabel.setText(songLabel.getText() + "(" + new DecimalFormat("#.#").format(interval) + ")" + " ");
        songLabel.setText(songLabel.getText() + note + " ");
    }
}
