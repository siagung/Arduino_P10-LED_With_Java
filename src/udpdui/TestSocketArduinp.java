/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpdui;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agung
 */
public class TestSocketArduinp extends javax.swing.JFrame {

    	//Ip Adress and Port, where the Arduino Server is running on
    private static final String serverIP="192.168.99.106";
    private static final int serverPort=23;
    private static final long serialVersionUID = 615908526682541228L;
    
    Socket clientSocket;

    BufferedReader inFromServer;   
    
    String msgToServer;//Message that will be sent to Arduino
    String msgFromServer;//recieved message will be stored here
    
    
    Font font;
    
    byte[] sendData = new byte[1024];
    byte[] receiveData = new byte[1024];
    
    InetAddress IPAddress;    
    
    String sentence;
    
    public TestSocketArduinp() {
        
     
        
          //OutputStream to Arduino-Server
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKirim = new javax.swing.JButton();
        btnConnect = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtNo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnKirim.setText("jButton1");
        btnKirim.setEnabled(false);
        btnKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimActionPerformed(evt);
            }
        });

        btnConnect.setText("connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnClose.setText("close");
        btnClose.setEnabled(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtNo.setText("1-  3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKirim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 243, Short.MAX_VALUE))
                    .addComponent(txtNo))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btnKirim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect)
                    .addComponent(btnClose))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
     
        try {
            clientSocket = new Socket(serverIP, serverPort);//making the socket connection
            System.out.println("Connected to:"+serverIP+" on port:"+serverPort);//debug
           
            btnConnect.setEnabled(false);
            btnClose.setEnabled(true);
            btnKirim.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(TestSocketArduinp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimActionPerformed

        try {
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes(txtNo.getText()+"\n");
            outToServer.flush();
        } catch (IOException ex) {
            Logger.getLogger(TestSocketArduinp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//            try {               
//                 //outToServer.flush();
//            } catch (IOException ex) {
//                Logger.getLogger(TestSocketArduinp.class.getName()).log(Level.SEVERE, null, ex);
//            }
      }
    }//GEN-LAST:event_btnKirimActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        try {
            //outToServer.flush();
//            outToServer.close();
            clientSocket.close();
            btnClose.setEnabled(false);
            btnKirim.setEnabled(false);
            btnConnect.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(TestSocketArduinp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestSocketArduinp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestSocketArduinp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestSocketArduinp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestSocketArduinp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestSocketArduinp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnKirim;
    private javax.swing.JTextField txtNo;
    // End of variables declaration//GEN-END:variables
}