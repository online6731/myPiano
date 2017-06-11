package mypiano;

import java.io.File; 
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class Recorder {
 
    File wavFile = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\mySong.wav");
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    TargetDataLine line;

    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }

    void start() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();
  
            AudioInputStream ais = new AudioInputStream(line);
  
            AudioSystem.write(ais, fileType, wavFile);
 
        } catch (LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
    }
 

    void finish() {
        line.stop();
        line.close();
    }

}