/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import jftha.main.Dice;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import jftha.main.Player;

/**
 *
 * @author tue75856 Josh
 */
public class BoardGUI extends javax.swing.JFrame {

    Player players[];
    int howmany;
    //Turn phases
    public static final int ITEM_1 = 0,
            DICE_ROLL = 1,
            ATTACK = 2,
            ITEM_2 = 3;

    public BoardGUI() {
        howmany = 4;
        players = new Player[howmany];
        initComponents();
    }

    /**
     * Creates new form BoardGUI
     */
    public BoardGUI(Player playas[]) {
        howmany = playas.length;
        players = playas;
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

        rollDieButton = new javax.swing.JButton();
        dieLabel = new javax.swing.JLabel();
        PlayerOneInfoLabel = new javax.swing.JLabel();
        PlayerTwoInfoLabel = new javax.swing.JLabel();
        PlayerThreeInfoLabel = new javax.swing.JLabel();
        PlayerFourInfoLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        OutputScrollPane = new javax.swing.JScrollPane();
        OutputTextArea = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        CurPlayerLabel = new javax.swing.JLabel();
        CurPhaseLabel = new javax.swing.JLabel();
        ItemOneLabel = new javax.swing.JLabel();
        ItemTwoLabel = new javax.swing.JLabel();
        ItemThreeLabel = new javax.swing.JLabel();
        ItemFiveLabel = new javax.swing.JLabel();
        ItemFourLabel = new javax.swing.JLabel();
        ItemSevenLabel = new javax.swing.JLabel();
        ItemEightLabel = new javax.swing.JLabel();
        ItemSixLabel = new javax.swing.JLabel();
        boardLayeredPane = new javax.swing.JLayeredPane();
        spaceLabel1 = new javax.swing.JLabel();
        spaceLabel18 = new javax.swing.JLabel();
        spaceLabel22 = new javax.swing.JLabel();
        spaceLabel21 = new javax.swing.JLabel();
        spaceLabel20 = new javax.swing.JLabel();
        spaceLabel19 = new javax.swing.JLabel();
        spaceLabel2 = new javax.swing.JLabel();
        spaceLabel3 = new javax.swing.JLabel();
        spaceLabel4 = new javax.swing.JLabel();
        spaceLabel5 = new javax.swing.JLabel();
        spaceLabel6 = new javax.swing.JLabel();
        spaceLabel7 = new javax.swing.JLabel();
        spaceLabel8 = new javax.swing.JLabel();
        spaceLabel9 = new javax.swing.JLabel();
        spaceLabel10 = new javax.swing.JLabel();
        spaceLabel11 = new javax.swing.JLabel();
        spaceLabel12 = new javax.swing.JLabel();
        spaceLabel13 = new javax.swing.JLabel();
        spaceLabel14 = new javax.swing.JLabel();
        spaceLabel15 = new javax.swing.JLabel();
        spaceLabel16 = new javax.swing.JLabel();
        spaceLabel17 = new javax.swing.JLabel();
        boardLabel = new javax.swing.JLabel();
        characterLabel1 = new javax.swing.JLabel();
        characterLabel2 = new javax.swing.JLabel();
        characterLabel3 = new javax.swing.JLabel();
        characterLabel4 = new javax.swing.JLabel();
        characterLabel5 = new javax.swing.JLabel();
        characterLabel6 = new javax.swing.JLabel();
        characterLabel7 = new javax.swing.JLabel();
        characterLabel8 = new javax.swing.JLabel();
        characterLabel9 = new javax.swing.JLabel();
        characterLabel10 = new javax.swing.JLabel();
        characterLabel11 = new javax.swing.JLabel();
        characterLabel12 = new javax.swing.JLabel();
        characterLabel13 = new javax.swing.JLabel();
        characterLabel14 = new javax.swing.JLabel();
        characterLabel15 = new javax.swing.JLabel();
        characterLabel16 = new javax.swing.JLabel();
        characterLabel17 = new javax.swing.JLabel();
        characterLabel18 = new javax.swing.JLabel();
        characterLabel19 = new javax.swing.JLabel();
        characterLabel20 = new javax.swing.JLabel();
        characterLabel21 = new javax.swing.JLabel();
        characterLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        rollDieButton.setText("Roll Die");
        rollDieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollDieButtonActionPerformed(evt);
            }
        });

        dieLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/die1.png"))); // NOI18N
        dieLabel.setName("dieLabel"); // NOI18N

        PlayerOneInfoLabel.setText("Player 1 Info");
        PlayerOneInfoLabel.setPreferredSize(new java.awt.Dimension(35, 35));

        PlayerTwoInfoLabel.setText("Player 2 Info");
        PlayerTwoInfoLabel.setPreferredSize(new java.awt.Dimension(35, 35));

        PlayerThreeInfoLabel.setText("Player 3 Info");
        PlayerThreeInfoLabel.setPreferredSize(new java.awt.Dimension(35, 35));

        PlayerFourInfoLabel.setText("Player 4 Info");
        PlayerFourInfoLabel.setPreferredSize(new java.awt.Dimension(35, 35));

        OutputTextArea.setEditable(false);
        OutputTextArea.setColumns(20);
        OutputTextArea.setRows(5);
        OutputScrollPane.setViewportView(OutputTextArea);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        CurPlayerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CurPlayerLabel.setText("Player ?");

        CurPhaseLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CurPhaseLabel.setText("????? Phase [1,2]");

        ItemOneLabel.setText("Item 1");
        ItemOneLabel.setToolTipText("Item 1");

        ItemTwoLabel.setText("Item 2");
        ItemTwoLabel.setToolTipText("Item 2");

        ItemThreeLabel.setText("Item 3");
        ItemThreeLabel.setToolTipText("Item 3");

        ItemFiveLabel.setText("Item 5");
        ItemFiveLabel.setToolTipText("Item 5");

        ItemFourLabel.setText("Item 4");
        ItemFourLabel.setToolTipText("Item 4");

        ItemSevenLabel.setText("Item 7");
        ItemSevenLabel.setToolTipText("Item 7");

        ItemEightLabel.setText("Item 8");
        ItemEightLabel.setToolTipText("Item 8");

        ItemSixLabel.setText("Item 6");
        ItemSixLabel.setToolTipText("Item 6");

        spaceLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel1.setBounds(850, 610, 70, 70);
        boardLayeredPane.add(spaceLabel1, javax.swing.JLayeredPane.PALETTE_LAYER);
        spaceLabel1.getAccessibleContext().setAccessibleName("spaceLabel1");

        spaceLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel18.setBounds(650, 110, 70, 70);
        boardLayeredPane.add(spaceLabel18, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel22.setBounds(830, 480, 70, 70);
        boardLayeredPane.add(spaceLabel22, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel21.setBounds(710, 400, 70, 70);
        boardLayeredPane.add(spaceLabel21, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel20.setBounds(700, 290, 70, 70);
        boardLayeredPane.add(spaceLabel20, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel19.setBounds(720, 190, 70, 70);
        boardLayeredPane.add(spaceLabel19, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel2.setBounds(750, 550, 70, 70);
        boardLayeredPane.add(spaceLabel2, javax.swing.JLayeredPane.PALETTE_LAYER);
        spaceLabel2.getAccessibleContext().setAccessibleName("spaceLabel2");

        spaceLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel3.setBounds(640, 490, 70, 70);
        boardLayeredPane.add(spaceLabel3, javax.swing.JLayeredPane.PALETTE_LAYER);
        spaceLabel3.getAccessibleContext().setAccessibleName("spaceLabel1");

        spaceLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel4.setBounds(490, 460, 70, 70);
        boardLayeredPane.add(spaceLabel4, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel5.setBounds(300, 500, 70, 70);
        boardLayeredPane.add(spaceLabel5, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel6.setBounds(330, 390, 70, 70);
        boardLayeredPane.add(spaceLabel6, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel7.setBounds(210, 380, 70, 70);
        boardLayeredPane.add(spaceLabel7, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel8.setBounds(100, 350, 70, 70);
        boardLayeredPane.add(spaceLabel8, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel9.setBounds(80, 260, 70, 70);
        boardLayeredPane.add(spaceLabel9, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel10.setBounds(80, 180, 70, 70);
        boardLayeredPane.add(spaceLabel10, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel11.setBounds(20, 100, 70, 70);
        boardLayeredPane.add(spaceLabel11, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel12.setBounds(100, 30, 70, 70);
        boardLayeredPane.add(spaceLabel12, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel13.setBounds(220, 40, 70, 70);
        boardLayeredPane.add(spaceLabel13, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel14.setBounds(300, 110, 70, 70);
        boardLayeredPane.add(spaceLabel14, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel15.setBounds(370, 190, 70, 70);
        boardLayeredPane.add(spaceLabel15, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel16.setBounds(450, 120, 70, 70);
        boardLayeredPane.add(spaceLabel16, javax.swing.JLayeredPane.PALETTE_LAYER);

        spaceLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        spaceLabel17.setBounds(560, 150, 70, 70);
        boardLayeredPane.add(spaceLabel17, javax.swing.JLayeredPane.PALETTE_LAYER);

        boardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fantasy Map (22 Spaces).png"))); // NOI18N
        boardLabel.setBounds(0, 0, 942, 697);
        boardLayeredPane.add(boardLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        characterLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel1.setBounds(860, 620, 50, 50);
        boardLayeredPane.add(characterLabel1, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel2.setBounds(760, 560, 50, 50);
        boardLayeredPane.add(characterLabel2, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel3.setBounds(650, 500, 50, 50);
        boardLayeredPane.add(characterLabel3, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel4.setBounds(500, 470, 50, 50);
        boardLayeredPane.add(characterLabel4, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel5.setBounds(310, 510, 50, 50);
        boardLayeredPane.add(characterLabel5, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel6.setBounds(340, 400, 50, 50);
        boardLayeredPane.add(characterLabel6, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel7.setBounds(220, 390, 50, 50);
        boardLayeredPane.add(characterLabel7, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel8.setBounds(110, 360, 50, 50);
        boardLayeredPane.add(characterLabel8, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel9.setBounds(90, 270, 50, 50);
        boardLayeredPane.add(characterLabel9, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel10.setBounds(90, 190, 50, 50);
        boardLayeredPane.add(characterLabel10, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel11.setBounds(30, 110, 50, 50);
        boardLayeredPane.add(characterLabel11, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel12.setBounds(110, 40, 50, 50);
        boardLayeredPane.add(characterLabel12, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel13.setBounds(230, 50, 50, 50);
        boardLayeredPane.add(characterLabel13, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel14.setBounds(310, 120, 50, 50);
        boardLayeredPane.add(characterLabel14, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel15.setBounds(380, 200, 50, 50);
        boardLayeredPane.add(characterLabel15, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel16.setBounds(460, 130, 50, 50);
        boardLayeredPane.add(characterLabel16, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel17.setBounds(570, 160, 50, 50);
        boardLayeredPane.add(characterLabel17, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel18.setBounds(660, 120, 50, 50);
        boardLayeredPane.add(characterLabel18, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel19.setBounds(730, 200, 50, 50);
        boardLayeredPane.add(characterLabel19, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel20.setBounds(710, 300, 50, 50);
        boardLayeredPane.add(characterLabel20, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel21.setBounds(720, 410, 50, 50);
        boardLayeredPane.add(characterLabel21, javax.swing.JLayeredPane.MODAL_LAYER);

        characterLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        characterLabel22.setBounds(840, 490, 50, 50);
        boardLayeredPane.add(characterLabel22, javax.swing.JLayeredPane.MODAL_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boardLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OutputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurPlayerLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ItemOneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ItemTwoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ItemFiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ItemSixLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ItemSevenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ItemEightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ItemThreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ItemFourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(CurPhaseLabel)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PlayerOneInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlayerThreeInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(PlayerTwoInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PlayerFourInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rollDieButton))
                        .addGap(93, 93, 93))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PlayerOneInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlayerTwoInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlayerThreeInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlayerFourInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dieLabel)
                        .addGap(5, 5, 5)
                        .addComponent(rollDieButton)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boardLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ItemOneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemThreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemTwoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemFourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ItemFiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemSevenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemEightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemSixLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CurPlayerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CurPhaseLabel))
                            .addComponent(OutputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rollDieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollDieButtonActionPerformed
        Dice die = new Dice(6);
        die.rollGUI(dieLabel);
    }//GEN-LAST:event_rollDieButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (players != null) {
            StringBuilder sb;
            for (int i = 0; i < players.length; i++) {
                sb = new StringBuilder();
                if (players[i] != null) {
                    sb.append("Player " + (i + 1) + " Name: " + players[i].getCustomName());
                    sb.append("\n");
                    sb.append("Class: " + players[i].getCharacter().getClassName());
                    sb.append("\n");
                }
                if (i == 0) {
                    PlayerOneInfoLabel.setText(sb.toString());
                } else if (i == 1){
                    PlayerTwoInfoLabel.setText(sb.toString());
                } else if (i == 2){
                    PlayerThreeInfoLabel.setText(sb.toString());
                } else if (i == 3){
                    PlayerFourInfoLabel.setText(sb.toString());
                }
            }
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(BoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoardGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CurPhaseLabel;
    private javax.swing.JLabel CurPlayerLabel;
    private javax.swing.JLabel ItemEightLabel;
    private javax.swing.JLabel ItemFiveLabel;
    private javax.swing.JLabel ItemFourLabel;
    private javax.swing.JLabel ItemOneLabel;
    private javax.swing.JLabel ItemSevenLabel;
    private javax.swing.JLabel ItemSixLabel;
    private javax.swing.JLabel ItemThreeLabel;
    private javax.swing.JLabel ItemTwoLabel;
    private javax.swing.JScrollPane OutputScrollPane;
    private javax.swing.JTextArea OutputTextArea;
    private javax.swing.JLabel PlayerFourInfoLabel;
    private javax.swing.JLabel PlayerOneInfoLabel;
    private javax.swing.JLabel PlayerThreeInfoLabel;
    private javax.swing.JLabel PlayerTwoInfoLabel;
    private javax.swing.JLabel boardLabel;
    private javax.swing.JLayeredPane boardLayeredPane;
    private javax.swing.JLabel characterLabel1;
    private javax.swing.JLabel characterLabel10;
    private javax.swing.JLabel characterLabel11;
    private javax.swing.JLabel characterLabel12;
    private javax.swing.JLabel characterLabel13;
    private javax.swing.JLabel characterLabel14;
    private javax.swing.JLabel characterLabel15;
    private javax.swing.JLabel characterLabel16;
    private javax.swing.JLabel characterLabel17;
    private javax.swing.JLabel characterLabel18;
    private javax.swing.JLabel characterLabel19;
    private javax.swing.JLabel characterLabel2;
    private javax.swing.JLabel characterLabel20;
    private javax.swing.JLabel characterLabel21;
    private javax.swing.JLabel characterLabel22;
    private javax.swing.JLabel characterLabel3;
    private javax.swing.JLabel characterLabel4;
    private javax.swing.JLabel characterLabel5;
    private javax.swing.JLabel characterLabel6;
    private javax.swing.JLabel characterLabel7;
    private javax.swing.JLabel characterLabel8;
    private javax.swing.JLabel characterLabel9;
    private javax.swing.JLabel dieLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton rollDieButton;
    private javax.swing.JLabel spaceLabel1;
    private javax.swing.JLabel spaceLabel10;
    private javax.swing.JLabel spaceLabel11;
    private javax.swing.JLabel spaceLabel12;
    private javax.swing.JLabel spaceLabel13;
    private javax.swing.JLabel spaceLabel14;
    private javax.swing.JLabel spaceLabel15;
    private javax.swing.JLabel spaceLabel16;
    private javax.swing.JLabel spaceLabel17;
    private javax.swing.JLabel spaceLabel18;
    private javax.swing.JLabel spaceLabel19;
    private javax.swing.JLabel spaceLabel2;
    private javax.swing.JLabel spaceLabel20;
    private javax.swing.JLabel spaceLabel21;
    private javax.swing.JLabel spaceLabel22;
    private javax.swing.JLabel spaceLabel3;
    private javax.swing.JLabel spaceLabel4;
    private javax.swing.JLabel spaceLabel5;
    private javax.swing.JLabel spaceLabel6;
    private javax.swing.JLabel spaceLabel7;
    private javax.swing.JLabel spaceLabel8;
    private javax.swing.JLabel spaceLabel9;
    // End of variables declaration//GEN-END:variables
}
