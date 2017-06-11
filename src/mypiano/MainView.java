package mypiano;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainView extends javax.swing.JFrame {
    public Keyboard keyboard;
    public Recorder recorder;
    
    public MainView() {
        this.setUndecorated(true);
        initComponents();
        initializition();
    }
    
    public final void initializition(){
        //this.setAlwaysOnTop(true);
        
        this.setTitle("Piano STEP #12");
        //cm.registerComponent(this, menu);
        this.setLocation(100, 200);
        keyboardPanel.grabFocus();
        Resources.load();
        NoteWriter.set(songLabel);
        keyboardPanel.addKeyListener(new MainViewKeyListener());
        recorder = new Recorder();
        keyboard = new Keyboard(keyboardPanel);
        keyboard.drawKeyboard();
        openButton.addActionListener(new OpenButtonActionListener(optionPanel));
        saveButton.addActionListener(new SaveButtonActionListener(optionPanel, songLabel));
        playButton.addActionListener(new PlayButtonActionListener(songLabel));
        recordButton.addActionListener(new RecordButtonActionListener(recorder));
        stopButton.addActionListener(new StopButtonActionListener(recorder));
        exit.addMouseListener(new ExitButtonActionListener());
        playSavedSongButton.addActionListener(new PlaySavedSoundButtonActionListener());
        editableButton.addActionListener((ActionEvent e) -> {
            if (editableButton.isSelected()){
                songLabel.setEditable(true);
                songLabel.setFocusable(true);
                songLabel.grabFocus();
            } else {
                songLabel.setEditable(false);
                songLabel.setFocusable(false);
                keyboardPanel.grabFocus();
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        menu = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        musicSheetLabel = new javax.swing.JLabel();
        songLabel = new javax.swing.JTextField();
        editableButton = new javax.swing.JToggleButton();
        bassDrum = new javax.swing.JCheckBox();
        playButton = new javax.swing.JButton();
        keyboardPanel = new javax.swing.JPanel();
        optionPanel = new javax.swing.JPanel();
        recordButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        playSavedSongButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        openButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu.setBackground(new java.awt.Color(51, 51, 51));
        menu.setForeground(new java.awt.Color(153, 153, 153));

        title.setBackground(new java.awt.Color(0, 0, 204));
        title.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Piano STEP #12");

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 5));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));

        musicSheetLabel.setText("musicSheet: ");

        songLabel.setEditable(false);
        songLabel.setBackground(new java.awt.Color(153, 153, 153));
        songLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        songLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                songLabelActionPerformed(evt);
            }
        });

        editableButton.setText("Edit");

        bassDrum.setBackground(new java.awt.Color(153, 153, 153));
        bassDrum.setForeground(new java.awt.Color(255, 255, 255));
        bassDrum.setText("Background");
        bassDrum.setFocusable(false);
        bassDrum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bassDrumActionPerformed(evt);
            }
        });

        playButton.setText("play");
        playButton.setFocusable(false);

        keyboardPanel.setBackground(new java.awt.Color(153, 153, 153));
        keyboardPanel.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout keyboardPanelLayout = new javax.swing.GroupLayout(keyboardPanel);
        keyboardPanel.setLayout(keyboardPanelLayout);
        keyboardPanelLayout.setHorizontalGroup(
            keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        keyboardPanelLayout.setVerticalGroup(
            keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );

        optionPanel.setBackground(new java.awt.Color(153, 153, 153));
        optionPanel.setForeground(new java.awt.Color(153, 153, 153));

        recordButton.setText("record");
        recordButton.setFocusable(false);

        stopButton.setText("stop");
        stopButton.setFocusable(false);

        playSavedSongButton.setText("play");
        playSavedSongButton.setFocusable(false);

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playSavedSongButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recordButton)
                .addGap(8, 8, 8))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recordButton)
                    .addComponent(stopButton)
                    .addComponent(playSavedSongButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveButton.setText("save");
        saveButton.setFocusable(false);

        openButton.setText("open");
        openButton.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(keyboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(musicSheetLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(songLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editableButton)
                        .addGap(4, 4, 4)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bassDrum)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(songLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bassDrum)
                    .addComponent(playButton)
                    .addComponent(musicSheetLabel)
                    .addComponent(editableButton)
                    .addComponent(saveButton)
                    .addComponent(openButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keyboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bassDrumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bassDrumActionPerformed

    }//GEN-LAST:event_bassDrumActionPerformed

    private void songLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_songLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_songLabelActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JCheckBox bassDrum;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton editableButton;
    public static javax.swing.JLabel exit;
    public static javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel keyboardPanel;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel musicSheetLabel;
    private javax.swing.JButton openButton;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton playButton;
    private javax.swing.JButton playSavedSongButton;
    private javax.swing.JButton recordButton;
    private javax.swing.JButton saveButton;
    public static javax.swing.JTextField songLabel;
    private javax.swing.JButton stopButton;
    public static javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    private static class RecordButtonActionListener implements ActionListener {

        private final Recorder jsr;

        public RecordButtonActionListener(Recorder jsr) {
            this.jsr = jsr;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    jsr.start();
                }
            }).start();
            
        }
    }


    // </editor-fold> 



    

}
