/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agung
 */



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


public class wav2 {
       public static void main(String[] args) throws Exception {
           
                String[] numbers = new String[15];
                numbers[0] = "no_urut.wav";
                numbers[1] = "1.wav";
                numbers[2] = "2.wav";
                numbers[3] = "3.wav";
                numbers[4] = "4.wav";
                numbers[5] = "5.wav";
                numbers[6] = "6.wav";
                numbers[7] = "7.wav";
                numbers[8] = "8.wav";
                numbers[9] = "9.wav";
                numbers[10] = "sepuluh.wav";
                numbers[11] = "sebelas.wav";
                numbers[12] = "seratus.wav";
                numbers[13] = "puluh.wav";
                numbers[12] = "ratus.wav";
                numbers[13] = "diloket.wav";
                numbers[14] = "tintong.wav";
                String[] numbers2 = new String[7];
                numbers2[0]= "no_urut.wav";
                numbers2[1]= "lima.wav";
                numbers2[2]= "ratus.wav";
                numbers2[3]= "diloket.wav";
                numbers2[5]= "satu.wav";
                numbers2[6]= "satu.wav";
		for ( int i = 1; i <=9; i++){
                                 numbers2[4]= numbers[i] ;
                                 List list = (List) Arrays.asList(numbers2);
                System.out.println("50"+String.valueOf(i)+".wav");
                
                //concatenateFiles(list,"loket01/50"+i+".wav");
                }
                                
                
                //String[] numbers2 = new String[]{"no_urut.wav", "lima.wav", "ratus.wav", numbers[i],"diloket.wav","tiga.wav"};               
               
                
                //List list = (List) Arrays.asList(numbers);
               
                
               // concatenateFiles(list,"loket01/50"+i+".wav");
                
          
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
