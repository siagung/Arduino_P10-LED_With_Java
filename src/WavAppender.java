;
import java.io.File;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;






/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agung
 */
public class WavAppender {
        public static void main(String[] args) {
            try {
                String wavFile1 = "no_urut.wav";
                String wavFile2 = "lima.wav";
                String wavFile3 = "puluh.wav";
                String wavFile4 = "enam.wav";
                String wavFile5 = "diloket.wav";
                String wavFile6 = "tiga.wav";
                
                //create String array
                String[] numbers = new String[]{"no_urut.wav", "lima.wav", "puluh.wav","enam.wav","diloket.wav","tiga.wav"};
               
                /*
                * To covert String array to java.util.List object, use
                * List asList(String[] strArray) method of Arrays class.
                */
                
                List list = (List) Arrays.asList(numbers);
               
                //display elements of List
                System.out.println("String array converted to List");
                for(int i=0; i < list.size(); i++){
                    System.out.println(list.get(i));
                }
                
                concatenateFiles(list,"dua.wav");
                
                
                /* try {
                AudioInputStream clip1 = AudioSystem.getAudioInputStream(new File(wavFile1));
                AudioInputStream clip2 = AudioSystem.getAudioInputStream(new File(wavFile2));
                AudioInputStream clip3 = AudioSystem.getAudioInputStream(new File(wavFile3));
                AudioInputStream clip4 = AudioSystem.getAudioInputStream(new File(wavFile4));
                AudioInputStream clip5 = AudioSystem.getAudioInputStream(new File(wavFile5));
                AudioInputStream clip6 = AudioSystem.getAudioInputStream(new File(wavFile6));
                AudioInputStream appendedFiles =  new AudioInputStream(
                new SequenceInputStream(clip1, clip2,clip3,clip4,clip5,clip6),
                clip1.getFormat(),
                clip1.getFrameLength() + clip2.getFrameLength()+ clip3.getFrameLength()+ clip4.getFrameLength()+ clip5.getFrameLength()+ clip6.getFrameLength());
                
                AudioSystem.write(appendedFiles, AudioFileFormat.Type.WAVE,
                new File("sounds/56.wav"));
                } catch (Exception e) {
                e.printStackTrace();
                }*/
            } catch (Exception ex) {
                Logger.getLogger(WavAppender.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    public static Boolean concatenateFiles(List<String> sourceFilesList, String destinationFileName) throws Exception {
		Boolean result = false;

		AudioInputStream audioInputStream = null;
		List<AudioInputStream> audioInputStreamList = null;
		AudioFormat audioFormat = null;
		Long frameLength = null;

		try {
			// loop through our files first and load them up
			for (String sourceFile : sourceFilesList) {
				audioInputStream = AudioSystem.getAudioInputStream(new File(sourceFile));

				// get the format of first file
				if (audioFormat == null) {
					audioFormat = audioInputStream.getFormat();
				}

				// add it to our stream list
				if (audioInputStreamList == null) {
					audioInputStreamList = new ArrayList<AudioInputStream>();
				}
				audioInputStreamList.add(audioInputStream);

				// keep calculating frame length
				if(frameLength == null) {
					frameLength = audioInputStream.getFrameLength();
				}
				else {
					frameLength += audioInputStream.getFrameLength();
				}
			}

			// now write our concatenated file
			AudioSystem.write(new AudioInputStream(new SequenceInputStream(Collections.enumeration(audioInputStreamList)), audioFormat, frameLength), Type.WAVE, new File(destinationFileName));

			// if all is good, return true
			result = true;
		}
		catch (Exception e) {
			throw e;
		}
		finally {
			if (audioInputStream != null) {
				audioInputStream.close();
			}
			if (audioInputStreamList != null) {
				audioInputStreamList = null;
			}
		}

		return result;
	}
}
