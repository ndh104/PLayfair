/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;

import Data.DBAccess;
import Entity.Student;
import Entity.Transcript;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author bigbo
 */
public final class frmTranscript extends javax.swing.JFrame {

    /**
     * Creates new form frmTranscript
     */
    public frmTranscript(){
        initComponents();
        if ("2".equals(frmLogin.role)) {
            btnDel.setVisible(false);
        }
        btnSaveAdd.setVisible(false);
        btnCancelAdd.setVisible(false);
        btnSaveEdit.setVisible(false);
        btnCancelEdit.setVisible(false);
        tb_Transcript.getTableHeader().setFont(new Font("Segoe Ul", Font.PLAIN, 14));
        TableColumnModel column = tb_Transcript.getColumnModel();
        column.getColumn(0).setPreferredWidth(50);
        column.getColumn(1).setPreferredWidth(50);
        column.getColumn(2).setPreferredWidth(50);
        column.getColumn(3).setPreferredWidth(50);
        show_Transcript();
        sort();
    }

    private void sort() {
        DefaultTableModel dm = (DefaultTableModel) tb_Transcript.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(dm);
        tb_Transcript.setRowSorter(sorter);
    }

    public void show_Transcript() {
        List<Transcript> transcriptlist = DBAccess.getAllTranscript();
        DefaultTableModel model = (DefaultTableModel) tb_Transcript.getModel();
        Object[] row = new Object[10];
        for (int i = 0; i < transcriptlist.size(); i++) {
            row[0] = transcriptlist.get(i).getTeacherID();
            row[1] = transcriptlist.get(i).getStudentID();
            row[2] = transcriptlist.get(i).getSubID();
            row[3] = transcriptlist.get(i).getPoint();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Transcript = new javax.swing.JTable();
        btnBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTeacherID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        txtSubID = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnSaveAdd = new javax.swing.JButton();
        btnSaveEdit = new javax.swing.JButton();
        btnCancelEdit = new javax.swing.JButton();
        btnCancelAdd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        txtPoint = new javax.swing.JFormattedTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_Transcript.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_Transcript.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher ID", "StudentID", "Subject ID", "Point"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Transcript.setRowHeight(30);
        tb_Transcript.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_TranscriptMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Transcript);

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnBack.setText("Back");
        btnBack.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBackMouseMoved(evt);
            }
        });
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBackMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("TRANSCRIPT");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Teacher ID:");

        txtTeacherID.setEditable(false);
        txtTeacherID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Student ID:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Subject ID:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Point:");

        txtStudentID.setEditable(false);
        txtStudentID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSubID.setEditable(false);
        txtSubID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnSaveAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSaveAdd.setText("Save");
        btnSaveAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAddActionPerformed(evt);
            }
        });

        btnSaveEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSaveEdit.setText("Save");
        btnSaveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEditActionPerformed(evt);
            }
        });

        btnCancelEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelEdit.setText("Cancel");
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });

        btnCancelAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelAdd.setText("Cancel");
        btnCancelAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelAddActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Search:");

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        txtPoint.setEditable(false);
        txtPoint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPoint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPointKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSaveAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(btnCancelAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnCancelEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(btnSaveEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(98, 98, 98))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(50, 50, 50)))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSubID, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(txtPoint)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTeacherID, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTeacherID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSubID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnSaveAdd)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEdit)
                                    .addComponent(btnDel))
                                .addGap(18, 18, 18)
                                .addComponent(btnSaveEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCancelEdit)
                                    .addComponent(btnCancelAdd))
                                .addGap(24, 24, 24)))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        this.dispose();
        frmMain frm = new frmMain();
        frm.setVisible(true);
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
        btnBack.setForeground(Color.black);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseMoved
        // TODO add your handling code here:
        btnBack.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnBackMouseMoved

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        // TODO add your handling code here:
        btnBack.setForeground(Color.orange);
    }//GEN-LAST:event_btnBackMousePressed

    private void tb_TranscriptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_TranscriptMouseClicked
        // TODO add your handling code here:
        int row = tb_Transcript.getSelectedRow();
        if (row >= 0) {
            txtTeacherID.setText(tb_Transcript.getValueAt(row, 0).toString());
            txtStudentID.setText(tb_Transcript.getValueAt(row, 1).toString());
            txtSubID.setText(tb_Transcript.getValueAt(row, 2).toString());
            txtPoint.setText(tb_Transcript.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_tb_TranscriptMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        btnSaveAdd.setVisible(true);
        btnCancelAdd.setVisible(true);
        btnAdd.setVisible(false);
        btnEdit.setVisible(false);
        txtTeacherID.setEditable(true);
        txtTeacherID.setText("");
        txtStudentID.setEditable(true);
        txtStudentID.setText("");
        txtSubID.setEditable(true);
        txtSubID.setText("");
        txtPoint.setEditable(true);
        txtPoint.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAddActionPerformed
        // TODO add your handling code here:
        int out = JOptionPane.showConfirmDialog(null, "Do you want to save this Subject?", "SAVE?", JOptionPane.OK_CANCEL_OPTION);
        if (out == 0) {
            try {
                String teacherID = txtTeacherID.getText();
                String studentID = txtStudentID.getText();
                String subID = txtSubID.getText();
                float subCredits = Float.valueOf(txtPoint.getText());
                boolean check = DBAccess.addTranscript(teacherID, studentID, subID, subCredits);
                DefaultTableModel tbModel = (DefaultTableModel) tb_Transcript.getModel();
                tbModel.setRowCount(0);
                show_Transcript();
                btnSaveAdd.setVisible(false);
                btnCancelAdd.setVisible(false);
                btnAdd.setVisible(true);
                btnEdit.setVisible(true);
                if (check) {
                    JOptionPane.showMessageDialog(null, "Saved!");
                } else {
                    JOptionPane.showMessageDialog(null, "This Transcript is already in database!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnSaveAddActionPerformed

    private void btnCancelAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelAddActionPerformed
        // TODO add your handling code here:
        btnSaveAdd.setVisible(false);
        btnCancelAdd.setVisible(false);
        btnAdd.setVisible(true);
        btnEdit.setVisible(true);
        txtTeacherID.setEditable(false);
        txtStudentID.setEditable(false);
        txtSubID.setEditable(false);
        txtPoint.setEditable(false);
    }//GEN-LAST:event_btnCancelAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        btnSaveEdit.setVisible(true);
        btnCancelEdit.setVisible(true);
        btnAdd.setVisible(false);
        btnEdit.setVisible(false);
        txtPoint.setEditable(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEditActionPerformed
        // TODO add your handling code here:
        int out = JOptionPane.showConfirmDialog(null, "Do you want to save changes?", "SAVE?", JOptionPane.OK_CANCEL_OPTION);
        if (out == 0) {
            try {
                String teacherID = txtTeacherID.getText();
                String studentID = txtStudentID.getText();
                String subID = txtSubID.getText();
                float point = Float.valueOf(txtPoint.getText());
                if (point < 0 || point > 10) {
                    JOptionPane.showMessageDialog(null, "Point must be between 0 and 10!");
                } else {
                    boolean check = DBAccess.editTranscript(teacherID, studentID, subID, point);
                    DefaultTableModel tbModel = (DefaultTableModel) tb_Transcript.getModel();
                    tbModel.setRowCount(0);
                    show_Transcript();
                    btnSaveEdit.setVisible(false);
                    btnCancelEdit.setVisible(false);
                    btnAdd.setVisible(true);
                    btnEdit.setVisible(true);
                    if (check) {
                        JOptionPane.showMessageDialog(null, "Saved!");
                    } else {
                        JOptionPane.showMessageDialog(null, "This Transcript is already in database!");
                    }
                }

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnSaveEditActionPerformed

    private void btnCancelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditActionPerformed
        // TODO add your handling code here:
        btnSaveEdit.setVisible(false);
        btnCancelEdit.setVisible(false);
        btnAdd.setVisible(true);
        btnEdit.setVisible(true);
        txtPoint.setEditable(false);
    }//GEN-LAST:event_btnCancelEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        int out = JOptionPane.showConfirmDialog(null, "Do you want to delete this Transcript?", "DELETE?", JOptionPane.OK_CANCEL_OPTION);
        if (out == 0) {
            try {
                String teacherID = txtTeacherID.getText();
                DBAccess.deleteTranscript(teacherID);
                DefaultTableModel tbModel = (DefaultTableModel) tb_Transcript.getModel();
                tbModel.setRowCount(0);
                show_Transcript();
                txtTeacherID.setText("");
                txtStudentID.setText("");
                txtSubID.setText("");
                txtPoint.setText("");
                JOptionPane.showMessageDialog(null, "Deleted!");
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtPointKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPointKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((Character.isDigit(c)) || (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.VK_BACK_SPACE)) {
            if (c == KeyEvent.VK_PERIOD) {
                String s = txtPoint.getText();
                int dot = s.indexOf('.');
                if (dot != -1) {
                    getToolkit().beep();
                    evt.consume();
                }
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPointKeyTyped

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tb_Transcript.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tb_Transcript.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyReleased

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
            java.util.logging.Logger.getLogger(frmTranscript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTranscript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTranscript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTranscript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTranscript().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel btnBack;
    private javax.swing.JButton btnCancelAdd;
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSaveAdd;
    private javax.swing.JButton btnSaveEdit;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_Transcript;
    private javax.swing.JFormattedTextField txtPoint;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtSubID;
    private javax.swing.JTextField txtTeacherID;
    // End of variables declaration//GEN-END:variables
}
