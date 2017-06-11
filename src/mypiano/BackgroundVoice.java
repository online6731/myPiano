package mypiano;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BackgroundVoice extends Thread {
    int keyNumber;
    public BackgroundVoice(int keyNumber) {
        this.keyNumber = keyNumber;
    }
    
    public void run(){
        while(true){
            Player.playNote(Keyboard.keyToNote.get(keyNumber), true);
            try {   Thread.sleep(500);  } catch (InterruptedException ex) { Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex); }
        }
    }
}
