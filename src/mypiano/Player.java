package mypiano;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.*;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


class Player {
    
    
    public static void playFile(String soundFile) {
        new Thread(() -> {
            AudioInputStream audioIn = null;
            try {
                File f = new File(soundFile);
                audioIn = AudioSystem.getAudioInputStream(f);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    audioIn.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        
    }
    
    
    public static void playKey(Integer number) {
        newplayNote(number, 2); 
    }

    public static synchronized void playNote(String note, Boolean writeIt) {

        if (note.startsWith("(") && note.endsWith(")")) try {
            //System.out.println((long)(Float.parseFloat(note.substring(1, note.length() - 1)) * 1000));
            Thread.sleep((long)(Float.parseFloat(note.substring(1, note.length() - 1)) * 1000));
        } catch (InterruptedException ex) { Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex); }
        else {
            for (Key pk : Keyboard.keys) pk.release();
            playKey(Keyboard.noteToKey.get(note));
        }
         if (writeIt) NoteWriter.writeNote(note);

        
    }


    public static void newplayNote(int finalNote, int finalInstrument) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence sequence = new Sequence(Sequence.PPQ,4);
            javax.sound.midi.Track track = sequence.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(ShortMessage.PROGRAM_CHANGE,1,finalInstrument,0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(ShortMessage.NOTE_ON,1,finalNote,100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(ShortMessage.NOTE_OFF,1,finalNote,100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            sequencer.setSequence(sequence);
            sequencer.start();
        } catch (Exception ex) { ex.printStackTrace(); }

    }
    
}