/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteendb.gui;

import canteendb.db.DatabaseConnection;
import canteendb.db.beans.AvailableItemsBeans;
import canteendb.db.beans.fooditemlist;
import canteendb.db.mngmt.UserManagement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author amald
 */
public class billingui extends javax.swing.JDialog {

    /**
     * Creates new form billingui
     */
    public billingui(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {

            // try {
            initComponents();
            setLocationRelativeTo(null);
            DatabaseConnection connection = null;
            connection = new DatabaseConnection();
            DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBoxitem.getModel();
            model.removeAllElements();
            try {

                String qry = "SELECT * FROM Available_Items";
                ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);

                while (rs.next()) {
                    //System.out.println(var1);
                    //model.addElement(var1);
                    model.addElement(new fooditemlist(rs.getString("id"), rs.getString("NAME"), rs.getString("RATE")));
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            //get current date time with Date()
            Date date = new Date();
            jTextFielddate.setText(dateFormat.format(date));
            String qry = "select max(Billno)+1 as bno from Bill";

            ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
            if (rs.next() == true) {
                jTextFieldbillno.setText(rs.getString("bno"));
            }

            /* DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBoxitem.getModel();
             //String qry = "SELECT * FROM Available_Items";
             //ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
             UserManagement management = new UserManagement();
             ArrayList<AvailableItemsBeans> AvailableItemsBeans = management.getAvailableItems();
            
             for (int i = 0; i < AvailableItemsBeans.size(); i++) {
             AvailableItemsBeans detailsBean = AvailableItemsBeans.get(i);
             Object[] row = { detailsBean.getName(), detailsBean.getRate()};
             model.addElement(row);
             }
             } catch (ClassNotFoundException ex) {
             Logger.getLogger(billingui.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
             Logger.getLogger(billingui.class.getName()).log(Level.SEVERE, null, ex);
             }
             */
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(billingui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(billingui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxitem = new javax.swing.JComboBox();
        jTextFieldrate = new javax.swing.JTextField();
        jTextFieldqty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextFieldtotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldgrandtotal = new javax.swing.JTextField();
        jTextFieldbillno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFielddate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Biling"));

        jComboBoxitem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxitemItemStateChanged(evt);
            }
        });
        jComboBoxitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxitemActionPerformed(evt);
            }
        });

        jTextFieldrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldrateActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldtotalActionPerformed(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Grand Total :");

        jTextFieldgrandtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldgrandtotalActionPerformed(evt);
            }
        });

        jTextFieldbillno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldbillnoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("BillNo :");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Date :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldgrandtotal)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1)
                        .addComponent(jComboBoxitem, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldrate, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldqty, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldtotal)
                        .addComponent(jTextFieldbillno))
                    .addComponent(jTextFielddate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldbillno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextFieldgrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFielddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jTextFieldrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jButton1)))))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxitemActionPerformed

    private void jTextFieldrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldrateActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldrateActionPerformed

    private void jComboBoxitemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxitemItemStateChanged
        // TODO add your handling code here:

        fooditemlist food = (fooditemlist) jComboBoxitem.getSelectedItem();
        jTextFieldrate.setText(food.getRATE());


    }//GEN-LAST:event_jComboBoxitemItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            try {
                float rate, qty, total;
                qty = Integer.parseInt(jTextFieldqty.getText());
                rate = Integer.parseInt(jTextFieldrate.getText());
                total = (qty * rate);
                jTextFieldtotal.setText(String.valueOf(total));
                System.out.println(total);
                Vector colum = new Vector(4);
                colum.add("Slno");
                colum.add("Name");
                colum.add("Rate");
                colum.add("Qty");
                colum.add("Total");
                Vector row = new Vector(4);
                row.add("1");
                row.add(jComboBoxitem.getSelectedItem());
                row.add(jTextFieldrate.getText());
                row.add(jTextFieldqty.getText());
                row.add(jTextFieldtotal.getText());
                Vector data = new Vector(4);
                data.add(row);
                JTable table = new JTable(data, colum);
                DefaultTableModel tablemodel = new DefaultTableModel(data, colum);
                jTable1.setModel(tablemodel);

               // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                //get current date time with Date()
                //Date date = new Date();
                //jTextFielddate.setText(dateFormat.format(date));
                DatabaseConnection connection = null;
                connection = new DatabaseConnection();
                String qry = "INSERT INTO Bill VALUES('" + jComboBoxitem.getSelectedItem() + "','"
                        + jTextFieldrate.getText() + "','" + jTextFieldqty.getText() + "','"
                        + jTextFieldtotal.getText() + "','" + jTextFieldbillno.getText()
                        + "','" + jTextFielddate.getText() + "')";
                connection.getConnection().createStatement().executeUpdate(qry);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(billingui.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(billingui.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                DatabaseConnection connection = null;
                connection = new DatabaseConnection();
                String qry = "SELECT Name,Rate,Qty,Total FROM Bill where billno=".concat(jTextFieldbillno.getText());
                ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);

                ResultSetMetaData md = rs.getMetaData();
                int columnCount = md.getColumnCount();

                columnCount = md.getColumnCount();

                Vector columns = new Vector(columnCount);

                //store column names  
                for (int i = 1; i <= columnCount; i++) {
                    columns.add(md.getColumnName(i));
                    // columns.add(md.getColumnType(i)); 
                }
                Vector data = new Vector();
                Vector row;

                //store row data  
                while (rs.next()) {
                    row = new Vector(columnCount);
                    for (int i = 1; i <= columnCount; i++) {
                        row.add(rs.getString(i));
                        //System.out.println(i);

                    }
                    data.add(row);
                }

                JTable table = new JTable(data, columns);

                //working -- DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
                System.out.println("creating table .....");
                DefaultTableModel tableModel = new DefaultTableModel(data, columns);
                jTable1.setModel(tableModel);

            } catch (Exception e) {
                System.out.println("error catched .............");
                e.printStackTrace();
            }

            DatabaseConnection connection = null;
            connection = new DatabaseConnection();
            String qry = "select sum(Total)as grandtotal from Bill where Billno=".concat(jTextFieldbillno.getText());
            ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
            if (rs.next()) {
                jTextFieldgrandtotal.setText(rs.getString("grandtotal"));
            } else {
                jTextFieldgrandtotal.setText("0");

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(billingui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(billingui.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldgrandtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldgrandtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldgrandtotalActionPerformed

    private void jTextFieldbillnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldbillnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldbillnoActionPerformed

    private void jTextFieldtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldtotalActionPerformed

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
            java.util.logging.Logger.getLogger(billingui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billingui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billingui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billingui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                billingui dialog = new billingui(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxitem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldbillno;
    private javax.swing.JTextField jTextFielddate;
    private javax.swing.JTextField jTextFieldgrandtotal;
    private javax.swing.JTextField jTextFieldqty;
    private javax.swing.JTextField jTextFieldrate;
    private javax.swing.JTextField jTextFieldtotal;
    // End of variables declaration//GEN-END:variables

    public void loadFoodDetails() throws SQLException {
        try {
            UserManagement management = new UserManagement();
            ArrayList<AvailableItemsBeans> AvailableItemsBeans = management.getAvailableItems();
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.getDataVector().clear();
            for (int i = 0; i < AvailableItemsBeans.size(); i++) {
                AvailableItemsBeans detailsBean = AvailableItemsBeans.get(i);
                Object[] row = {i + 1, detailsBean.getName(), detailsBean.getRate()};
                tableModel.addRow(row);
            }
            jTable1.updateUI();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
