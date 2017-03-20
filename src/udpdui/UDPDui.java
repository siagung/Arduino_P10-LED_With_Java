/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpdui;

import com.alee.laf.WebLookAndFeel;
import com.opass.app.helper.JustOneLock;
import java.awt.FontFormatException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author agung
 */
public class UDPDui implements Runnable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JustOneLock ua = new JustOneLock("ScaleID");
         
         if (ua.isAppActive()) {
             System.out.println("Already active.");
             System.exit(1);
         }else{
        SwingUtilities.invokeLater(new UDPDui());
         }
    }

    @Override
    public void run() {
   try {
            try {
                try {
                    MainExec();
                } catch (IOException ex) {
                    Logger.getLogger(UDPDui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FontFormatException ex) {
                    Logger.getLogger(UDPDui.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(UDPDui.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(UDPDui.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    void MainExec() throws UnsupportedLookAndFeelException, InterruptedException, IOException, FontFormatException {
        try {
            UIManager.setLookAndFeel (WebLookAndFeel.class.getCanonicalName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UDPDui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
 
    ///FullScreenFrame f = new FullScreenFrame(device);
    //f.startFullScreen();
    
        mainForm ks = new mainForm();
        ks.setLocationRelativeTo(null);
        ks.setResizable(false);
        //setUndecorated(true);
       // ks.startFullScreen();
        ks.setVisible(true);
        
    }
    
}
