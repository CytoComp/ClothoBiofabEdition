/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserFrame.java
 *
 * Created on Jul 15, 2011, 2:39:52 PM
 */
package org.clothocore.widget.fabdash;

import java.util.ArrayList;
import javax.swing.JLabel;
import org.clothocore.api.core.Collector;
import org.clothocore.api.data.ObjLink;
import org.clothocore.api.data.ObjType;
import org.clothocore.api.data.Person;

/**
 *
 * @author jenhan
 */
public class UserFrame extends javax.swing.JFrame {

    /**
     *
     * @param current- current user name
     */
    public UserFrame(JLabel current) {
        _current = current;
        initComponents();
        currentUserLabel.setText("Current User: " + current.getText());
        userComboBox.removeAllItems();
        ArrayList<ObjLink> personLinks = Collector.getAllLinksOf(ObjType.PERSON);
        for (ObjLink ol : personLinks) {
            userComboBox.addItem(ol.name);
        }
        userComboBox.setSelectedIndex(0);
    }

    public UserFrame() {
        initComponents();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentUserLabel = new javax.swing.JLabel();
        userComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        logInButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(UserFrame.class, "UserFrame.title")); // NOI18N
        setResizable(false);

        currentUserLabel.setText(org.openide.util.NbBundle.getMessage(UserFrame.class, "UserFrame.currentUserLabel.text")); // NOI18N
        currentUserLabel.setToolTipText(org.openide.util.NbBundle.getMessage(UserFrame.class, "UserFrame.currentUserLabel.toolTipText")); // NOI18N

        userComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        userComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(UserFrame.class, "UserFrame.userComboBox.toolTipText")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(UserFrame.class, "UserFrame.jLabel2.text")); // NOI18N

        logInButton.setText(org.openide.util.NbBundle.getMessage(UserFrame.class, "UserFrame.logInButton.text")); // NOI18N
        logInButton.setToolTipText(org.openide.util.NbBundle.getMessage(UserFrame.class, "UserFrame.logInButton.toolTipText")); // NOI18N
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(org.openide.util.NbBundle.getMessage(UserFrame.class, "UserFrame.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(userComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(logInButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancelButton))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentUserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logInButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        Person newUser = Person.retrieveByName((String) userComboBox.getSelectedItem());
        if (newUser != null) {
            Collector.setCurrentUser(newUser);
            _current.setText(newUser.getDisplayName());
        }
        this.dispose();
    }//GEN-LAST:event_logInButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UserFrame().setVisible(true);
            }
        });
    }
    private JLabel _current;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel currentUserLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logInButton;
    private javax.swing.JComboBox userComboBox;
    // End of variables declaration//GEN-END:variables
}
