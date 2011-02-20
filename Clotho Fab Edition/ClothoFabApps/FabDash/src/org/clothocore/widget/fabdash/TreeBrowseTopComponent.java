/*
 * 
Copyright (c) 2010 The Regents of the University of California.
All rights reserved.
Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
SUCH DAMAGE.

THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS..
 */
package org.clothocore.widget.fabdash;

import java.util.logging.Logger;
import javax.swing.SwingWorker;
import org.clothocore.api.core.Collector;
import org.clothocore.api.data.Collection;
import org.clothocore.api.data.ObjBase;
import org.clothocore.api.data.ObjType;
import org.clothocore.util.basic.ObjBasePopup;
import org.clothocore.widget.fabdash.browser.ObjTypeChooser;
import org.clothocore.widget.fabdash.browser.SearchBar;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import org.openide.util.ImageUtilities;
import org.netbeans.api.settings.ConvertAsProperties;


/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.clothocore.widget.fabdash//TreeBrowse//EN",
autostore = false)
public final class TreeBrowseTopComponent extends TopComponent {

    private static TreeBrowseTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "TreeBrowseTopComponent";

    public TreeBrowseTopComponent() {
        initComponents();
        add(new ObjTypeChooser(this), java.awt.BorderLayout.NORTH);
        add(new SearchBar(), java.awt.BorderLayout.SOUTH);

        
        setName(NbBundle.getMessage(TreeBrowseTopComponent.class, "CTL_TreeBrowseTopComponent"));
        setToolTipText(NbBundle.getMessage(TreeBrowseTopComponent.class, "HINT_TreeBrowseTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);

    }

    public void changeObjType(ObjType type) {
        _chosenType = type;
        System.out.println(_chosenType);
    }

    private void grabTreeDataForCurrentUser() {

        new SwingWorker() {
            Collection personalCollection  = null;

            @Override
            protected Object doInBackground() throws Exception {
                System.out.println("################################ FabDash connecting");
                if(!Collector.isConnected()) {
                    return null;
                }

                try {
                    personalCollection = Collector.getCurrentUser().getHerCollection();
                }  catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public void done() {
                browseTree.setModel( CollectionBrowser.generate(personalCollection));
                browseTree.validate();
                repaint();
            }
        }.execute();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        browseTree = new javax.swing.JTree();

        setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Connecting...");
        browseTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        browseTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseTreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(browseTree);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void browseTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseTreeMouseClicked
        if(evt.getClickCount()==2) {
            try {
                if(browseTree.getSelectionPath()==null) {
                    return;
                }
                Object[] selectedList = browseTree.getSelectionPath().getPath();
                ObjBase obj = (ObjBase) selectedList[selectedList.length-1];
                obj.launchDefaultViewer();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(evt.getModifiers() == 4) {
            try {
                Object[] selectedList = browseTree.getSelectionPath().getPath();
                ObjBase obj = (ObjBase) selectedList[selectedList.length-1];
                new ObjBasePopup(browseTree, obj, evt.getPoint());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_browseTreeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree browseTree;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized TreeBrowseTopComponent getDefault() {
        if (instance == null) {
            instance = new TreeBrowseTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the TreeBrowseTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized TreeBrowseTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(TreeBrowseTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof TreeBrowseTopComponent) {
            return (TreeBrowseTopComponent) win;
        }
        Logger.getLogger(TreeBrowseTopComponent.class.getName()).warning(
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
        grabTreeDataForCurrentUser();
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


    ///////////////////////////////////////////////////////////////////
    ////                      private variables                    ////
    private ObjType _chosenType = ObjType.PART;
}
