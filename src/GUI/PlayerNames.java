/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import jftha.heroes.*;
import jftha.main.Player;

/**
 *
 * @author shane
 */
public class PlayerNames extends javax.swing.JFrame {

    private int howmany, count;
    Player[] players;

    /**
     * Creates new form PlayerNames
     */
    public PlayerNames() {
        initComponents();
    }

    public PlayerNames(int numPlayers) {
        this.howmany = numPlayers;
        players = new Player[howmany];
        count = 1;
        initComponents();
    }

    public PlayerNames(int numPlayers, int c, Player[] playas) {
        this.howmany = numPlayers;
        players = playas;
        count = c;
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

        playerType = new javax.swing.ButtonGroup();
        name = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        playerNameField = new javax.swing.JTextField();
        BarbarianButton = new javax.swing.JRadioButton();
        NinjaButton = new javax.swing.JRadioButton();
        MageButton = new javax.swing.JRadioButton();
        KnightButton = new javax.swing.JRadioButton();
        MartialArtistButton = new javax.swing.JRadioButton();
        ThiefButton = new javax.swing.JRadioButton();
        PriestButton = new javax.swing.JRadioButton();
        MerchantButton = new javax.swing.JRadioButton();
        PaladinButton = new javax.swing.JRadioButton();
        input = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        name.setText("Player Name:");

        playerType.add(BarbarianButton);
        BarbarianButton.setText("Barbarian");
        BarbarianButton.setName("Barbarian"); // NOI18N
        BarbarianButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarbarianButtonActionPerformed(evt);
            }
        });

        playerType.add(NinjaButton);
        NinjaButton.setText("Ninja");
        NinjaButton.setName("Ninja"); // NOI18N

        playerType.add(MageButton);
        MageButton.setText("Mage");
        MageButton.setName("Mage"); // NOI18N

        playerType.add(KnightButton);
        KnightButton.setText("Knight");
        KnightButton.setName("Knight"); // NOI18N
        KnightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KnightButtonActionPerformed(evt);
            }
        });

        playerType.add(MartialArtistButton);
        MartialArtistButton.setText("Martial Artist");

        playerType.add(ThiefButton);
        ThiefButton.setText("Thief");
        ThiefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThiefButtonActionPerformed(evt);
            }
        });

        playerType.add(PriestButton);
        PriestButton.setText("Priest");

        playerType.add(MerchantButton);
        MerchantButton.setText("Merchant");

        playerType.add(PaladinButton);
        PaladinButton.setText("Paladin");

        input.setText("Go");
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BarbarianButton)
                                    .addComponent(NinjaButton)
                                    .addComponent(MageButton)
                                    .addComponent(KnightButton))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MerchantButton)
                                    .addComponent(PriestButton)
                                    .addComponent(ThiefButton)
                                    .addComponent(MartialArtistButton)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(name)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(playerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PaladinButton)
                            .addComponent(input))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(playerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BarbarianButton)
                    .addComponent(MartialArtistButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NinjaButton)
                    .addComponent(ThiefButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MageButton)
                    .addComponent(PriestButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KnightButton)
                    .addComponent(MerchantButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PaladinButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(input)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BarbarianButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarbarianButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarbarianButtonActionPerformed

    private void KnightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KnightButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KnightButtonActionPerformed

    private void ThiefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThiefButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThiefButtonActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        Hero playerHero = null;
        if (anyValidButtonSelected()) {
            playerHero = assignPlayer(getSelectedButton(playerType), playerHero);
            if ((playerNameField.getText().equals("")) || (playerNameField.getText() != null)) {
                players[count - 1] = new Player(playerNameField.getText(), playerHero);
            } else {
                System.out.println("No name filled in.");
            }

            JRadioButton button = getSelectedButton(playerType);
            if (button != null) {
                playerType.clearSelection();
            }
            playerNameField.setText("");
        }

        if (count == howmany) {
            BoardGUI board = new BoardGUI();
            this.setVisible(false);
            board.setVisible(true);
        } else {
            PlayerNames playName = new PlayerNames(howmany, count + 1, players);
            this.setVisible(false);
            playName.setVisible(true);
        }
    }//GEN-LAST:event_inputActionPerformed

    private boolean anyValidButtonSelected() {
        boolean result = false;
        if (BarbarianButton.isSelected()) {
            result = true;
        } else if (NinjaButton.isSelected()) {
            result = true;
        } else if (MageButton.isSelected()) {
            result = true;
        } else if (KnightButton.isSelected()) {
            result = true;
        } else {
            System.out.println("Invalid Selection."); //more handling
        }
        return result;
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.title.setText("Player " + count);
    }//GEN-LAST:event_formWindowOpened

    private Hero assignPlayer(JRadioButton b, Hero playerHero) {
        String s = b.getText();
        if (s.equalsIgnoreCase("Barbarian")) {
            playerHero = new Barbarian();
        } else if (s.equalsIgnoreCase("Ninja")) {
            playerHero = new Ninja();
        } else if (s.equalsIgnoreCase("Mage")) {
            playerHero = new Mage();
        } else if (s.equalsIgnoreCase("Knight")) {
            playerHero = new Knight();
        } else if (s.equalsIgnoreCase("Martial Artist")) {
            //playerHero = new MartialArtist();
            System.out.println("Not Available.");
        } else if (s.equalsIgnoreCase("Ninja")) {
            //playerHero = new Thief();
            System.out.println("Not Available.");
        } else if (s.equalsIgnoreCase("Priest")) {
            //playerHero = new Priest();
            System.out.println("Not Available.");
        } else if (s.equalsIgnoreCase("Merchant")) {
            //playerHero = new Merchant();
            System.out.println("Not Available.");
        } else if (s.equalsIgnoreCase("Paladin")) {
            //playerHero = new Paladin();
            System.out.println("Not Available.");
        } else {
            // No button pressed
            System.out.println("Error: No character picked.");
        }
        return playerHero;
    }

    public JRadioButton getSelectedButton(ButtonGroup group) {
        Enumeration<AbstractButton> e = group.getElements();
        while (e.hasMoreElements()) {
            AbstractButton b = e.nextElement();
            if (b.isSelected()) {
                return (JRadioButton) b;
            }
        }
        return null;
    }

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
            java.util.logging.Logger.getLogger(PlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BarbarianButton;
    private javax.swing.JRadioButton KnightButton;
    private javax.swing.JRadioButton MageButton;
    private javax.swing.JRadioButton MartialArtistButton;
    private javax.swing.JRadioButton MerchantButton;
    private javax.swing.JRadioButton NinjaButton;
    private javax.swing.JRadioButton PaladinButton;
    private javax.swing.JRadioButton PriestButton;
    private javax.swing.JRadioButton ThiefButton;
    private javax.swing.JButton input;
    private javax.swing.JLabel name;
    private javax.swing.JTextField playerNameField;
    private javax.swing.ButtonGroup playerType;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
