/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueclient;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static queueclient.publishantrian.startMillis;
import redis.clients.jedis.Jedis;

/**
 *
 * @author agung
 */
public class pubClient extends javax.swing.JFrame {

    // private static final String JEDIS_SERVER = "192.168.13.2";
    public Jedis jedis = null;
    private int vInt = 100;
    private int vInt2 = 200;
    private int total_antrian = 0;
    private int sisa_antrian = 0;
    private int nomor_antrian = 0;
    private int status_antrian = 0;
    private int nomor_layanan = 0;
    private PropertyValues pv;
    private static String socketServer;
    private static int socketport;
    private static String looketname;
    private static Properties prop;

    

    /**
     * Creates new form pubRedis
     */
    public pubClient() throws IOException {
        initComponents();
        pv = new PropertyValues();
        prop = new Properties(pv.getProperties());
        try{
        socketServer = prop.getProperty("SOCKET_SERVER");
        socketport = Integer.valueOf(prop.getProperty("SOCKET_SERVER_PORT"));
        looketname  = prop.getProperty("LOKETNAME");
        jedis = new Jedis(prop.getProperty("JEDIS_SERVER"));
 
        }
        finally{
            pv.closeProperties();
        }
        //jedis.set("totalantrian", "100");
        //jedis.set("nomorantrian_loket01", "100");
        //jedis.set("loket01status", "0");
        //jedis.set("nomorantrian", "100");
        total_antrian = Integer.valueOf(jedis.get("counter_sppt"))-100;
        sisa_antrian = Integer.valueOf(jedis.get("sisa_layanan"));
        nomor_antrian = Integer.valueOf(jedis.get("nomorantrian"));
        nomor_layanan = Integer.valueOf(jedis.get("nomor_layanan_"+looketname));
        status_antrian = Integer.valueOf(jedis.get(looketname+"status"));
        lblnomor_antrian.setText(String.valueOf(nomor_antrian));
        //jtxtLoket.setText("sdfs");
        ttlAntri.setText(String.valueOf(total_antrian));
        // ttlSisa.setText(String.valueOf(sisa_antrian));
        ttlLayan.setText(jedis.get("nomor_layanan_"+looketname));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jtxtLoket = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnLayan = new javax.swing.JButton();
        btnPanggil = new javax.swing.JButton();
        btnIstirahat = new javax.swing.JButton();
        btnLewat = new javax.swing.JButton();
        lblnomor_antrian = new javax.swing.JLabel();
        ttlLayan = new javax.swing.JLabel();
        ttlAntri = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtxtLoket.setEditable(false);
        jtxtLoket.setBackground(new java.awt.Color(0, 0, 51));
        jtxtLoket.setForeground(new java.awt.Color(255, 255, 204));
        jtxtLoket.setText("loket01");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLayan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tick_32.png"))); // NOI18N
        btnLayan.setText("Layan");
        btnLayan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLayan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayanActionPerformed(evt);
            }
        });
        jPanel1.add(btnLayan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 200, 80));

        btnPanggil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sound.png"))); // NOI18N
        btnPanggil.setText("Panggil");
        btnPanggil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPanggil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanggilActionPerformed(evt);
            }
        });
        jPanel1.add(btnPanggil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 80));

        btnIstirahat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clock_32.png"))); // NOI18N
        btnIstirahat.setText("Istirahat");
        btnIstirahat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIstirahat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIstirahatActionPerformed(evt);
            }
        });
        jPanel1.add(btnIstirahat, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 10, 120, 80));

        btnLewat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/block_32.png"))); // NOI18N
        btnLewat.setText("Lewat");
        btnLewat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLewat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLewatActionPerformed(evt);
            }
        });
        jPanel1.add(btnLewat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 80));

        lblnomor_antrian.setBackground(new java.awt.Color(0, 0, 0));
        lblnomor_antrian.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
        lblnomor_antrian.setForeground(new java.awt.Color(204, 0, 51));
        lblnomor_antrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnomor_antrian.setText("100");
        lblnomor_antrian.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMOR ANTRIAN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        lblnomor_antrian.setOpaque(true);
        jPanel1.add(lblnomor_antrian, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 160, 80));

        ttlLayan.setBackground(new java.awt.Color(0, 0, 0));
        ttlLayan.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
        ttlLayan.setForeground(new java.awt.Color(102, 102, 255));
        ttlLayan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ttlLayan.setText("100");
        ttlLayan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMOR LAYANAN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12), new java.awt.Color(102, 153, 255))); // NOI18N
        ttlLayan.setOpaque(true);

        ttlAntri.setBackground(new java.awt.Color(0, 0, 0));
        ttlAntri.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
        ttlAntri.setForeground(new java.awt.Color(51, 255, 51));
        ttlAntri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ttlAntri.setText("100");
        ttlAntri.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL ANTRIAN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12), new java.awt.Color(0, 255, 0))); // NOI18N
        ttlAntri.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtLoket)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ttlAntri, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ttlLayan, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxtLoket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ttlLayan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttlAntri, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPanggilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanggilActionPerformed

        switch (jedis.get(looketname+"status")) {
            case "3": //istirahat
                // nomor_antrian = Integer.valueOf(jedis.get("nomorantrian"));
                //  jedis.incr("nomorantrian");
                // jedis.set("nomorantrian",String.valueOf(nomor_antrian+1));
                nomor_antrian = Integer.valueOf(jedis.get("nomorantrian"));
                lblnomor_antrian.setText(String.valueOf(nomor_antrian));
                break;
            case "2": //layan
                jedis.incr("nomorantrian");
                nomor_antrian = Integer.valueOf(jedis.get("nomorantrian"));
                //  jedis.incr("nomorantrian");
                // jedis.set("nomorantrian",String.valueOf(nomor_antrian+1));
                // nomor_antrian = Integer.valueOf(jedis.get("nomorantrian"));
                lblnomor_antrian.setText(String.valueOf(nomor_antrian));
                break;
        }
        jedis.set(looketname+"status", "1");
        Thread thread3 = new publishantrian(jtxtLoket.getText() + "-call-" + String.valueOf(nomor_antrian), jedis);
        thread3.start();
        try {
            thread3.join();
            tcpclient(jtxtLoket.getText(), String.valueOf(nomor_antrian));
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        } catch (Exception ex) {
            Logger.getLogger(pubClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPanggilActionPerformed

    private void btnIstirahatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIstirahatActionPerformed

        if (btnIstirahat.getText().equals("Tersedia")) {
            btnIstirahat.setText("Istirahat");
            jedis.set(looketname+"status", "3");
            btnLayan.setEnabled(true);
            btnPanggil.setEnabled(true);
            Thread thread = new publishantrian(jtxtLoket.getText() + "-on-" + String.valueOf(vInt), jedis);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        } else {
            btnIstirahat.setText("Tersedia");
            jedis.set(looketname+"status", "0");

            btnLayan.setEnabled(false);
            btnPanggil.setEnabled(false);
            Thread thread = new publishantrian(jtxtLoket.getText() + "-rest-" + String.valueOf(vInt), jedis);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }

        }


    }//GEN-LAST:event_btnIstirahatActionPerformed

    private void btnLayanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayanActionPerformed
        jedis.set(looketname+"status", "2");
       
        // nomor_antrian = Integer.valueOf(jedis.get("nomorantrian"));
        //jedis.set("nomorantrian",String.valueOf(nomor_antrian+1));                        
        //  lblnomor_antrian.setText(String.valueOf(nomor_antrian));
        jedis.set("nomor_layanan_"+looketname, String.valueOf(nomor_antrian));
        ttlLayan.setText(String.valueOf(nomor_antrian));
      //  jedis.incr("nomorantrian");
        
       // lblnomor_antrian.setForeground(Color.blue);
        Thread thread = new publishantrian(jtxtLoket.getText() + "-service-" + String.valueOf(nomor_antrian), jedis);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }//GEN-LAST:event_btnLayanActionPerformed

    private void btnLewatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLewatActionPerformed
        // if (!jedis.get("loket01status").equals("1")){        
        //nomor_antrian = Integer.valueOf(jedis.get("nomorantrian")) + 1;
        //jedis.set("nomorantrian", String.valueOf(nomor_antrian));
        jedis.incr("nomorantrian");
        nomor_antrian = Integer.valueOf(jedis.get("nomorantrian"));
        lblnomor_antrian.setText(String.valueOf(nomor_antrian));
        jedis.set("nomor_layanan_"+looketname, String.valueOf(nomor_antrian));
        jedis.set(looketname+"status", "1");
        //  }
    }//GEN-LAST:event_btnLewatActionPerformed

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
            java.util.logging.Logger.getLogger(pubClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pubClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pubClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pubClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new pubClient().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(pubClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private static void log(String string, Object... args) {
        long millisSinceStart = System.currentTimeMillis() - startMillis;
        System.out.printf("%20s %6d %s\n", Thread.currentThread().getName(), millisSinceStart,
                String.format(string, args));
    }

    private static void tcpclient(String loket, String nourut) throws Exception {
        //String sentence;
        String modifiedSentence;
        // BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
        try (Socket clientSocket = new Socket(socketServer, socketport)) {
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //  sentence = inFromUser.readLine();
            outToServer.writeBytes(loket + "-" + nourut + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIstirahat;
    private javax.swing.JButton btnLayan;
    private javax.swing.JButton btnLewat;
    private javax.swing.JButton btnPanggil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtxtLoket;
    private javax.swing.JLabel lblnomor_antrian;
    private javax.swing.JLabel ttlAntri;
    private javax.swing.JLabel ttlLayan;
    // End of variables declaration//GEN-END:variables
}