/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clothocad.tool.sequencechecker;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import sequencing.ABITrace;
import sequencing.Analyzer;
import sequencing.TraceExtract.ResultType;

import javax.swing.JFileChooser;
import org.clothocore.api.core.Collator;
import org.clothocore.api.core.wrapper.ConnectionWrapper;
import org.clothocore.api.data.Format;
import org.clothocore.api.data.Plasmid;

import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.openide.util.ImageUtilities;
import org.netbeans.api.settings.ConvertAsProperties;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.clothocad.tool.sequencechecker//SeqChecker//EN", autostore = false)
public final class SeqCheckerTopComponent extends TopComponent {

    /** path to the icon used by the component and its open action */
    protected static final String ICON_PATH = "org/clothocad/tool/sequencechecker/SeqChecker.png";
    protected static final String PREFERRED_ID = "SeqCheckerTopComponent";
    protected static SeqCheckerTopComponent instance;
    protected SeqCheckInput inputTableContents;
    protected LocalCheckController _localChecker;

    public SeqCheckerTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(SeqCheckerTopComponent.class, "CTL_SeqCheckerTopComponent"));
        setToolTipText(NbBundle.getMessage(SeqCheckerTopComponent.class, "HINT_SeqCheckerTopComponent"));
        setIcon(ImageUtilities.loadImage(ICON_PATH, true));

        _localChecker = new LocalCheckController();


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPanel = new javax.swing.JTabbedPane();
        outputPanel = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSplitPane3 = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        inputPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        selectButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        mainSplitPane = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTable = new javax.swing.JTable();

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setDividerSize(4);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(210);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Construct", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jSplitPane2.setLeftComponent(jScrollPane2);

        jSplitPane3.setDividerLocation(180);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clone", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jSplitPane3.setLeftComponent(jScrollPane3);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Error", "Description"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jSplitPane3.setRightComponent(jScrollPane4);

        jSplitPane2.setRightComponent(jSplitPane3);

        jSplitPane1.setTopComponent(jSplitPane2);

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
        );

        mainTabbedPanel.addTab(org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent.outputPanel.TabConstraints.tabTitle"), outputPanel); // NOI18N

        jToolBar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        mainTabbedPanel.addTab("tab3", jToolBar2);

        jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        org.openide.awt.Mnemonics.setLocalizedText(selectButton, org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent.selectButton.text")); // NOI18N
        selectButton.setToolTipText(org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent.selectButton.toolTipText_1")); // NOI18N
        selectButton.setFocusable(false);
        selectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        selectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(selectButton);

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent.checkButton.text")); // NOI18N
        jButton2.setToolTipText(org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent.checkButton.toolTipText")); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        mainSplitPane.setDividerLocation(250);
        mainSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        inputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Status", "Construct", "Clone", "Primer", "Trace File"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inputTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(inputTable);
        inputTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent.inputTable.columnModel.title0")); // NOI18N
        inputTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent.inputTable.columnModel.title1")); // NOI18N
        inputTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent.inputTable.columnModel.title2")); // NOI18N
        inputTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent.inputTable.columnModel.title3")); // NOI18N

        mainSplitPane.setLeftComponent(jScrollPane1);

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(mainSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 587, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        /*
         *  Run this code to switch to local connection, select button must be used
        String selectstring = "org.clothocad.connection.localconnection";
        ConnectionWrapper cw = (ConnectionWrapper) Collator.getPluginByUUID(selectstring);
        Collator.setDefaultConnection(cw);
         */
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(null);
        File selectedDirectory = chooser.getSelectedFile();
        if (selectedDirectory == null) { //cancel button selected
            return;
        }
        File[] folderContents = selectedDirectory.listFiles();
        ArrayList<File> filteredFolderContents = new ArrayList<File>();

        for (File file : folderContents) {
            //System.out.println(file.getName());
            try {
                if (file.getName().substring(file.getName().lastIndexOf(".")).equals(".ab1")) {
                    filteredFolderContents.add(file);
                }
            } catch (StringIndexOutOfBoundsException e) {
                //folder names that don't have a '.' character well cause an exception to be thrown
            }
        }

        inputTableContents = new SeqCheckInput(filteredFolderContents); //holds the contents of the input table
        inputTable.setModel(new javax.swing.table.DefaultTableModel(inputTableContents.getTable(), new String[]{"Trace", "Construct", "Clone", "Well"}));

    }//GEN-LAST:event_selectButtonActionPerformed

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
    }//GEN-LAST:event_checkButtonActionPerformed

    private void inputTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputTableMouseClicked
        if (inputTableContents == null) { //inputTableContents is null when a folder has not been selected
            return;
        }

        File trace = inputTableContents.getFiles().get(inputTable.getSelectedRow()); //gets the trace file at the selected row
        String partName = inputTableContents.getConstructNames()[inputTable.getSelectedRow()]; //retrieves the construct name field from the selected row
        //Get the region of the plasmid to validate as a String (seq)
        Plasmid aplas = Plasmid.retrieveByName(partName); //querying for a part is done through a Format, not the Collector
        if (aplas == null) {
        System.out.println("Plasmid with given name: "+partName+" could not be found");
        return; //Plasmid with given name, partName, could not be found
        }
        Format aform = aplas.getFormat(); //get the Format of aplas
        String target = aform.generateSequencingRegion(aplas).getSeq(); //based on the Format, a sequencing region is generated
         
        //_localChecker.performCheck(trace, target);  //original code that displays a new window each time Sequence Analyzer is called
        //String target = "CTAGAACATGCATCGACGTCTAGGGATACAGGGTAATTACGGCCCCAGAATTCAAAAGATCTTAAGTAAGTAAGAGTATACGTATATCGGCTAAAACGTATTAAGGCGCTTCGGCGCCTTTTTTTATGGGGGTATTTTCATCCCAATCCACACGTCCAACGCACAGCAAACACCACGTCGACCCTATCAGCTGCGTGCTTTCTATGAGTCGTTGCTGCATAACTTGACAATTAATCATCCGGCTCGTATAATGTGTGGAATTTGTAAGGAGGTGACAATATGAGCAAAGGAGAAGAACTTTTCACTGGAGTTGTCCCAATTCTTGTTGAATTAGATGGTGATGTTAATGGGCACAAATTTTCTGTCCGTGGAGAGGGTGAAGGTGATGCTACAAACGGAAAACTCACCCTTAAATTTATTTGCACTACTGGAAAACTACCTGTTCCGTGGCCAACACTTGTCACTACTCTGACCTATGGTGTTCAATGCTTTTCCCGTTATCCGGATCACATGAAACGGCATGACTTTTTCAAGAGTGCCATGCCCGAAGGTTATGTACAGGAACGCACTATATCTTTCAAAGATGACGGGACCTACAAGACGCGTGCTGAAGTCAAGTTTGAAGGTGATACCCTTGTTAATCGTATCGAGTTAAAGGGTATTGATTTTAAAGAAGATGGAAACATTCTTGGACACAAACTCGAGTACAACTTTAACTCACACAATGTATACATCACGGCAGACAAACAAAAGAATGGAATCAAAGCTAACTTCAAAATTCGCCACAACGTTGAAGATGGTTCCGTTCAACTAGCAGACCATTATCAACAAAATACTCCAATTGGCGATGGCCCTGTCCTTTTACCAGACAACCATTACCTGTCGACACAATCTGTCCTTTCGAAAGATCCCAACGAAAAGCGTGACCACATGGTCCTTCTTGAGTTTGTAACTGCTGCTGGGATTACACATGGCATGGATGAGCTCTACAATAAGATCG";
        mainSplitPane.setRightComponent(_localChecker.getCheckPanel(trace, target));  //hopefully, this sets the bottom panel to the graphical display that the Analyzer generates
        mainSplitPane.setDividerLocation(250); //not sure how to best set this right now
    }//GEN-LAST:event_inputTableMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel inputPanel;
    private javax.swing.JTable inputTable;
    protected javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JTabbedPane mainTabbedPanel;
    private javax.swing.JPanel outputPanel;
    protected javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized SeqCheckerTopComponent getDefault() {
        if (instance == null) {
            instance = new SeqCheckerTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the SeqCheckerTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized SeqCheckerTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(SeqCheckerTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof SeqCheckerTopComponent) {
            return (SeqCheckerTopComponent) win;
        }
        Logger.getLogger(SeqCheckerTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }
}
