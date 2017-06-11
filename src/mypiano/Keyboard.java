package mypiano;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Keyboard {
    static ArrayList<Key> keys;
    static ArrayList<Integer> whiteKeyNumber, blackKeyNumber;
    static HashMap<Integer, Integer> keyNumberHashMap;
    static HashMap<Integer, String> keyToNote;
    static HashMap<String, Integer> noteToKey;
    static HashMap<Character, String> charToNote;
    static JPanel panel;
    static JLayeredPane panel2;
    
    @SuppressWarnings("empty-statement")
    public Keyboard(JPanel panel) {
        this.panel = panel;
        panel.setVisible(true);
        fillConstants();
        drawKeyboard();
    }
    
    public void drawKeyboard(){
        for (Key pk : keys) pk.draw();
    }

    private void fillConstants() {
        keys = new ArrayList<>();
        whiteKeyNumber = new ArrayList<>();
        blackKeyNumber = new ArrayList<>();
        keyNumberHashMap = new HashMap<>();
        keyToNote = new HashMap<>();
        noteToKey = new HashMap<>();
        charToNote = new HashMap<>();
        
        int[] whiteKeyNumbers = {1, 3, 4, 6, 8, 9, 11, 13, 15, 16, 18, 20, 21, 23, 25, 27, 28, 30, 32,
                                33, 35, 37, 39, 40, 42, 44, 45, 47, 49, 51, 52, 54, 56, 57, 59, 61, 63,
                                64, 66, 68, 69, 71, 73, 75, 76, 78, 80, 81, 83, 85, 87, 88};
        int[] blackKeyNumbers = {2, 5, 7, 10, 12, 14, 17, 19, 22, 24, 26, 29, 31, 34, 36, 38, 41, 43,
                                46, 48, 50, 53, 55, 58, 60, 62, 65, 67, 70, 72, 74, 77, 79, 82, 84, 86};
        String[] notes =        {"A0", "A#0", "B0", 
                                "C1", "C#1", "D1", "D#1", "E1", "F1", "F#1", "G1", "G#1", "A1", "A#1", "B1", 
                                "C2", "C#2", "D2", "D#2", "E2", "F2", "F#2", "G2", "G#2", "A2", "A#2", "B2", 
                                "C3", "C#3", "D3", "D#3", "E3", "F3", "F#3", "G3", "G#3", "A3", "A#3", "B3", 
                                "C4", "C#4", "D4", "D#4", "E4", "F4", "F#4", "G4", "G#4", "A4", "A#4", "B4", 
                                "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", 
                                "C6", "C#6", "D6", "D#6", "E6", "F6", "F#6", "G6", "G#6", "A6", "A#6", "B6", 
                                "C7", "C#7", "D7", "D#7", "E7", "F7", "F#7", "G7", "G#7", "A7", "A#7", "B7", 
                                };
        charToNote.put('1', "C1"); charToNote.put('2', "D1"); charToNote.put('3', "E1"); charToNote.put('4', "F1"); charToNote.put('5', "G1"); charToNote.put('6', "A1"); charToNote.put('7', "B1");
        charToNote.put('8', "C2"); charToNote.put('9', "D2"); charToNote.put('0', "E2"); charToNote.put('q', "F2"); charToNote.put('w', "G2"); charToNote.put('e', "A2"); charToNote.put('r', "B2");
        charToNote.put('t', "C3"); charToNote.put('y', "D3"); charToNote.put('u', "E3"); charToNote.put('i', "F3"); charToNote.put('o', "G3"); charToNote.put('p', "A3"); charToNote.put('a', "B3");
        charToNote.put('s', "C4"); charToNote.put('d', "D4"); charToNote.put('f', "E4"); charToNote.put('g', "F4"); charToNote.put('h', "G4"); charToNote.put('j', "A4"); charToNote.put('k', "B4");
        charToNote.put('l', "C5"); charToNote.put('z', "D5"); charToNote.put('x', "E5"); charToNote.put('c', "F5"); charToNote.put('v', "G5"); charToNote.put('b', "A5"); charToNote.put('n', "B5");
        charToNote.put('m', "C6"); //charToNote.put('d', "D4"); charToNote.put('f', "E4"); charToNote.put('g', "F4"); charToNote.put('h', "G4"); charToNote.put('j', "A5"); charToNote.put('k', "B5");
        
        for (int i = 0; i < notes.length; i++) {
            keyToNote.put(i + 1, notes[i]);
        }
        for (int i = 0; i < notes.length; i++) {
            noteToKey.put(notes[i], i + 1);
        }
        for (int i = 0; i < whiteKeyNumbers.length; i++) {
            whiteKeyNumber.add(whiteKeyNumbers[i]);
            keyNumberHashMap.put(whiteKeyNumbers[i], i);
        }
        for (int i = 0; i < blackKeyNumbers.length; i++) {
            blackKeyNumber.add(blackKeyNumbers[i]);
            keyNumberHashMap.put(blackKeyNumbers[i], i);
        }
        ArrayList<Key> blackPianoKey = new ArrayList<>();
        ArrayList<Key> whitePianoKey = new ArrayList<>();
        blackKeyNumber.forEach((i) -> { keys.add(new Key(i)); });
        whiteKeyNumber.forEach((i) -> { keys.add(new Key(i)); });
        /*
        int i = 0, j = 0;
        while (i < whitePianoKey.size() || j < blackPianoKey.size())
            if (j == blackPianoKey.size() || whitePianoKey.get(i).number < whitePianoKey.get(j).number) keys.add(whitePianoKey.get(i++));
            else keys.add(whitePianoKey.get(j++));
        */
        
    }
    public static Key find (int index){
        for (Key pk : keys) if (pk.number == index) return pk;
        return null;
    }
    
}
