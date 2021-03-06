/*Dipto, a reasonably secure end-to-end desktop chat app built by the paranoid, for the paranoid
Copyright (C) 2018 Hiddenmaster

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dipto.Utility;
import dipto.business.network.Server;
import dipto.business.network.beans.FileMessage;
import dipto.business.network.beans.SecretMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import dipto.business.network.IGUIListener;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;

/**
 *
 * @author anon
 */
public class ChatFrame extends javax.swing.JFrame implements IGUIListener {
    private final List<JTextArea> chat_views;
    private Server diptoCore;
    
    /**
     * Creates new form chatFrame
     */
    public ChatFrame() {
        initComponents();
        
        diptoCore = new Server(this);
        
        diptoCore.generateKeys();
        diptoCore.waitForIncomingRequests();
        
        chat_views = new ArrayList<>();
        jButtonClean.setEnabled(false);
        jButtonSend.setEnabled(false);
        
        jTextAreaMessage.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jButtonClean.setEnabled(true);
                
                if(jListRecipients.getSelectedIndex() != -1)
                    jButtonSend.setEnabled(true);
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                if(jTextAreaMessage.getText().length() == 0){
                    jButtonSend.setEnabled(false);
                    jButtonClean.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneMessage = new javax.swing.JScrollPane();
        jTextAreaMessage = new javax.swing.JTextArea();
        jScrollPaneRecipients = new javax.swing.JScrollPane();
        jListRecipients = new javax.swing.JList<>();
        jTextFieldRecipient = new javax.swing.JTextField();
        jButtonSendDemand = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jButtonSend = new javax.swing.JButton();
        jButtonClipboardLocal = new javax.swing.JButton();
        jButtonClipboardGlobal = new javax.swing.JButton();
        jScrollPaneChats = new javax.swing.JScrollPane();
        jButtonSendFile = new javax.swing.JButton();
        jComboBoxTimerOptions = new javax.swing.JComboBox<>();
        jButtonClearChat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dipto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextAreaMessage.setColumns(20);
        jTextAreaMessage.setRows(5);
        jScrollPaneMessage.setViewportView(jTextAreaMessage);

        jListRecipients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListRecipientsMouseClicked(evt);
            }
        });
        jScrollPaneRecipients.setViewportView(jListRecipients);

        jButtonSendDemand.setText("Ajouter");
        jButtonSendDemand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendDemandActionPerformed(evt);
            }
        });

        jButtonClean.setText("Nettoyer");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        jButtonSend.setText("Envoyer");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jButtonClipboardLocal.setText("Copier l'adresse locale dans le presse-papier");
        jButtonClipboardLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClipboardLocalActionPerformed(evt);
            }
        });

        jButtonClipboardGlobal.setText("Copier l'adresse globale dans le presse-papier");
        jButtonClipboardGlobal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClipboardGlobalActionPerformed(evt);
            }
        });

        jButtonSendFile.setText("Send file");
        jButtonSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendFileActionPerformed(evt);
            }
        });

        jComboBoxTimerOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "5 seconds", "10 seconds", "15 seconds", "30 seconds", "1 minute", "5 minutes", "10 minutes", "30 minutes" }));
        jComboBoxTimerOptions.setSelectedIndex(1);

        jButtonClearChat.setText("Clear");
        jButtonClearChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneRecipients, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneChats, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPaneMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxTimerOptions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldRecipient, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSendDemand))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonClipboardGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonClipboardLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonSendFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonClearChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneRecipients))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRecipient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSendDemand))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonClipboardLocal)
                            .addComponent(jButtonSendFile))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonClipboardGlobal)
                            .addComponent(jButtonClearChat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneChats, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPaneMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxTimerOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonClean)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSend)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        diptoCore.stop();
        
        WipeTextAreas();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonClipboardLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClipboardLocalActionPerformed
        Utility.paste(diptoCore.getLocalIpAndPort());
    }//GEN-LAST:event_jButtonClipboardLocalActionPerformed

    private void jButtonClipboardGlobalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClipboardGlobalActionPerformed
        Utility.paste(diptoCore.getGlobalIpAndPort());
    }//GEN-LAST:event_jButtonClipboardGlobalActionPerformed

    private void jListRecipientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListRecipientsMouseClicked
        JList list = (JList)evt.getSource();
        
        if(list.getModel().getSize() <= 0)
            return;
        
        int index = list.locationToIndex(evt.getPoint());
        String recipient = (String)list.getModel().getElementAt(index);

        jScrollPaneChats.setViewportView(getTextArea(recipient));
        jTextAreaMessage.setEnabled(true);
    }//GEN-LAST:event_jListRecipientsMouseClicked

    private void jButtonSendDemandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendDemandActionPerformed
        if(!Utility.checkRecipientIntegrity(jTextFieldRecipient.getText())){
            JOptionPane.showMessageDialog(null, "The given recipient ID isn't valid", "Input error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String desired_recipient = jTextFieldRecipient.getText();

        if(!getDisplayedRecipients().contains(desired_recipient))
            diptoCore.initiateConnexionToRecipient(desired_recipient);

    }//GEN-LAST:event_jButtonSendDemandActionPerformed

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        String recipient = jListRecipients.getSelectedValue();
        
        if(recipient == null){
            JOptionPane.showMessageDialog(null, "select a recipient", "Selection error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String message = jTextAreaMessage.getText().trim();
        JTextArea area = getTextArea(recipient);
        
        diptoCore.sendMessage(recipient, message, GetTimingBeforeDeletion());
        area.append("You: " + message + "\n");
        jTextAreaMessage.setText("");
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        jTextAreaMessage.setText("");
    }//GEN-LAST:event_jButtonCleanActionPerformed

    private void jButtonSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendFileActionPerformed
        String recipient = jListRecipients.getSelectedValue();
        
        if(recipient == null){
            JOptionPane.showMessageDialog(null, "select a recipient", "Selection error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JFileChooser filchooser = new JFileChooser();

        if(filchooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
            diptoCore.sendMessage(recipient, filchooser.getSelectedFile(), 0);
    }//GEN-LAST:event_jButtonSendFileActionPerformed

    private void jButtonClearChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearChatActionPerformed
        jTextAreaMessage.setText("");
    }//GEN-LAST:event_jButtonClearChatActionPerformed
    
    private int GetTimingBeforeDeletion(){
        String timer = (String)(jComboBoxTimerOptions.getSelectedItem());
        
        if(timer.contains("None"))
            return 0;
        if(timer.contains("seconds"))
            return Integer.parseInt(timer.replace(" seconds",""));
        else if(timer.contains("minutes"))
            return Integer.parseInt(timer.replace(" minutes","")) * 60;
        else
            return Integer.parseInt(timer.replace(" minute","")) * 60;
    }
    
    private void WipeTextAreas(){
        getDisplayedRecipients().forEach(recipient -> {
            getTextArea(recipient).setText(Utility.WipeText());
        });
    }    
            
    
    private JTextArea getTextArea(String recipient){
        Optional<JTextArea> target_chat = chat_views.stream().filter(area -> area.getName().equals(recipient)).findFirst();
        return target_chat.get();
    }
    
    private ArrayList<String> getDisplayedRecipients(){
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0 ; i<jListRecipients.getModel().getSize() ; i++ )
            list.add(jListRecipients.getModel().getElementAt(i));
        
        return list;
    }
    
    @Override
    public void handleNewRecipient(String message) {
        /* J'ajoute la fenetre de chat dans la liste */
        String recipient_id = diptoCore.GetLastRecipient();

        JTextArea text_area = new JTextArea();
        text_area.setEditable(false);
        text_area.setName(recipient_id);
        text_area.setSize(jScrollPaneChats.getSize());
        chat_views.add(text_area);

        /* J'ajoute le nom du chat dans la liste */
        ArrayList<String> list_recipients = getDisplayedRecipients();
        DefaultListModel<String> dlm = new DefaultListModel<>();

        list_recipients.forEach((item) -> { 
            dlm.addElement(item);
        });

        dlm.addElement(recipient_id);
        jListRecipients.setModel(dlm);
    }
    
    @Override
    public void handleNewMessage(SecretMessage message) {
        JTextArea text_area = getTextArea(message.getSender());
        text_area.append("Him/Her: " + message.getPlainMessage() + "\n");
        
        if(jListRecipients.getSelectedValue() != null && jListRecipients.getSelectedValue().equals(message.getSender()))
            jScrollPaneChats.setViewportView(text_area);
    }
    
    @Override
    public void handleConnectionStateChanged(boolean is_connected) {
        jButtonClipboardGlobal.setEnabled(is_connected);
    }
    
    @Override
    public void handlePeerLeftConversation(String recipient_id) {
        System.out.println("peer left");
        JTextArea text_area = getTextArea(recipient_id);
        text_area.append("Recipient left the conversation\n");
    }

    @Override
    public void handleFileReceived(FileMessage file) {
        JFileChooser filchooser = new JFileChooser();
        filchooser.setSelectedFile(new File(file.getFile_name()));
        
        if(filchooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
            return;
                
        try (FileOutputStream fos = new FileOutputStream(filchooser.getSelectedFile().getAbsolutePath())) {
            fos.write(file.getPayload());
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void handleDeleteMessageTimerElapsed(int lineNumber, String userID) {
        JTextArea text_area = getTextArea(userID);

        try {
            text_area.replaceRange("", text_area.getLineStartOffset(lineNumber), text_area.getLineEndOffset(lineNumber));
        } catch (BadLocationException ex) {
            Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            ChatFrame frame = new ChatFrame();
            frame.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonClearChat;
    private javax.swing.JButton jButtonClipboardGlobal;
    private javax.swing.JButton jButtonClipboardLocal;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JButton jButtonSendDemand;
    private javax.swing.JButton jButtonSendFile;
    private javax.swing.JComboBox<String> jComboBoxTimerOptions;
    private javax.swing.JList<String> jListRecipients;
    private javax.swing.JScrollPane jScrollPaneChats;
    private javax.swing.JScrollPane jScrollPaneMessage;
    private javax.swing.JScrollPane jScrollPaneRecipients;
    private javax.swing.JTextArea jTextAreaMessage;
    private javax.swing.JTextField jTextFieldRecipient;
    // End of variables declaration//GEN-END:variables





}
