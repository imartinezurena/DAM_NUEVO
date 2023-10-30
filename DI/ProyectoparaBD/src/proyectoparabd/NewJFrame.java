/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectoparabd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author at5DAM2
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
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

        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        readButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cleanButton = new javax.swing.JButton();
        modelo = new javax.swing.JTextField();
        potencia = new javax.swing.JTextField();
        autonomia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCoches = new javax.swing.JTable();
        precio = new javax.swing.JTextField();
        labelModelo = new javax.swing.JLabel();
        labelPotencia = new javax.swing.JLabel();
        labelAutonomia = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        importCSVbutton = new javax.swing.JButton();
        exportCsvButton = new javax.swing.JButton();
        importJSON = new javax.swing.JButton();
        exportJSON = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createButton.setText("create");
        createButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createButtonMouseClicked(evt);
            }
        });

        readButton.setText("read");
        readButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readButtonMouseClicked(evt);
            }
        });

        updateButton.setText("update");
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
        });

        deleteButton.setText("delete");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        cleanButton.setText("clean");
        cleanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleanButtonMouseClicked(evt);
            }
        });

        tablaCoches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "MODELO", "POTENCIA", "AUTONOMIA", "PRECIO"
            }
        ));
        jScrollPane1.setViewportView(tablaCoches);

        labelModelo.setText("MODELO");

        labelPotencia.setText("POTENCIA");

        labelAutonomia.setText("AUTONOMIA");

        labelPrecio.setText("PRECIO");

        importCSVbutton.setText("import CSV");
        importCSVbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importCSVbuttonMouseClicked(evt);
            }
        });

        exportCsvButton.setText("export CSV");
        exportCsvButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportCsvButtonMouseClicked(evt);
            }
        });

        importJSON.setText("import JSON");

        exportJSON.setText("export JSON");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelModelo)
                    .addComponent(labelAutonomia)
                    .addComponent(labelPrecio)
                    .addComponent(labelPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importCSVbutton)
                    .addComponent(importJSON))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(createButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(potencia, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(readButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(autonomia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(precio)
                                    .addGap(6, 6, 6)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(deleteButton)
                                .addComponent(cleanButton)
                                .addComponent(updateButton))))
                    .addComponent(exportCsvButton)
                    .addComponent(exportJSON))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(createButton)
                                    .addComponent(modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelModelo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(readButton)
                                .addComponent(potencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(updateButton)
                                .addComponent(autonomia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelAutonomia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(deleteButton)
                                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelPrecio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cleanButton)
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exportCsvButton)
                            .addComponent(importCSVbutton))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(importJSON)
                            .addComponent(exportJSON))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readButtonMouseClicked
        read();        // TODO add your handling code here:
    }//GEN-LAST:event_readButtonMouseClicked

    private void createButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonMouseClicked

        try {
            String url = "jdbc:mysql://localhost:3306/tesla";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            PreparedStatement pst;
            pst = con.prepareStatement("insert into coches (modelo,potencia,autonomia,precio) values(?,?,?,?)");
            pst.setString(1, modelo.getText());
            pst.setInt(2, Integer.parseInt(potencia.getText()));
            pst.setInt(3, Integer.parseInt(autonomia.getText()));
            pst.setInt(4, Integer.parseInt(precio.getText()));
            int filas = pst.executeUpdate();
            if (filas > 0) {
                read();
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {
        }

    }//GEN-LAST:event_createButtonMouseClicked

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        // TODO add your handling code here:
        String seleccion = JOptionPane.showInputDialog(this, "introduce el id a actualizar");
        try {
            String url = "jdbc:mysql://localhost:3306/tesla";
            Connection con;
            con = (Connection) DriverManager.getConnection(url, "root", "");
            PreparedStatement pst;
            pst = con.prepareCall("update coches set modelo=?, potencia=?, autonomia=?, precio=? where id=?");

            pst.setString(1, modelo.getText());
            pst.setInt(2, Integer.parseInt(potencia.getText()));
            pst.setInt(3, Integer.parseInt(autonomia.getText()));
            pst.setInt(4, Integer.parseInt(precio.getText()));
            pst.setInt(5, Integer.parseInt(seleccion));
            int filas = pst.executeUpdate();
            if (filas > 0) {
                read();
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_updateButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        // TODO add your handling code here:
        String seleccion = JOptionPane.showInputDialog(this, "introduce el id a borrar");
        try {
            String url = "jdbc:mysql://localhost:3306/tesla";
            Connection con;
            con = (Connection) DriverManager.getConnection(url, "root", "");
            PreparedStatement pst;
            pst = con.prepareCall("delete from coches where id=?");
            pst.setInt(1, Integer.parseInt(seleccion));
            int filas = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void cleanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanButtonMouseClicked
        // TODO add your handling code here:
        modelo.setText(" ");
        potencia.setText(" ");
        autonomia.setText(" ");
        precio.setText(" ");
    }//GEN-LAST:event_cleanButtonMouseClicked

    private void importCSVbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importCSVbuttonMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);

        if (JFileChooser.APPROVE_OPTION == seleccion) {
             String linea;
            File fichero = fileChooser.getSelectedFile();
            try (BufferedReader lectorConBuffer = new BufferedReader(new FileReader(fichero))) {
                lectorConBuffer.readLine();
            while ((linea = lectorConBuffer.readLine()) != null) {
                cargarBase(linea);
                
            }
        } catch (IOException e) {
            System.out.println("Excepción IOException capturada: " + e.getMessage());
        }
        }
    }//GEN-LAST:event_importCSVbuttonMouseClicked

    private void exportCsvButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportCsvButtonMouseClicked
        // TODO add your handling code here:
          static final String CSV_CABECERA = "ID,MODELO,POTENCIA,AUTONOMIA,PRECIO";
           static final String CSV_SEPARADOR = ",";
        try {
            
    
            String url = "jdbc:mysql://localhost:3306/tesla";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            PreparedStatement pst;
            ResultSet rs;
            pst = con.prepareStatement("select * from Coches");
            rs = pst.executeQuery("select * from Coches");
             FileWriter escritor;
            escritor = new FileWriter(fichero);
            escritor.write(CSV_CABECERA + "\n");
            escritor.flush();
             while (rs.next()) {
                escritor.write(rs.getString("modelo") + "," + rs.getString("potencia") + "," + rs.getString("autonomia") + "," + rs.getString("precio")+"\n");
                escritor.flush();
            }
             
            
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Exportacion no completada correctamente");
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Exportacion no completada correctamente");
        }
        
        
    }//GEN-LAST:event_exportCsvButtonMouseClicked
private void cargarBase(String linea){
        try {
            int num =4;
            String[] campos=linea.split(",");
            String url = "jdbc:mysql://localhost:3306/tesla";
            Connection con;
            con = (Connection) DriverManager.getConnection(url, "root", "");
            PreparedStatement pst;
            pst = con.prepareCall("insert into coches (modelo,potencia,autonomia,precio) values(?,?,?,?)");
            pst.setString(1, campos[0]);
            pst.setInt(2, Integer.parseInt(campos[1]));
            pst.setInt(3, Integer.parseInt(campos[2]));
            pst.setInt(4, Integer.parseInt(campos[3]));
            int filas= pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    

}
    /**
     * @param args the command line arguments
     */
    private void read() {
        try {
            String url = "jdbc:mysql://localhost:3306/tesla";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            PreparedStatement pst;
            ResultSet rs;
            pst = con.prepareStatement("select * from coches");
            rs = pst.executeQuery("select * from coches");
            int id;
            String modelo;
            int potencia;
            int autonomia;
            int precio;
            DefaultTableModel modeloDatos = (DefaultTableModel) tablaCoches.getModel();
            int rowCount = 0;
            int tam = modeloDatos.getRowCount();
            while (rowCount < tam) {
                modeloDatos.removeRow(0);
                rowCount++;
            }
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("id"));
                modelo = rs.getString("modelo");
                potencia = Integer.parseInt(rs.getString("potencia"));
                autonomia = Integer.parseInt(rs.getString("autonomia"));
                precio = Integer.parseInt(rs.getString("precio"));
                modeloDatos.addRow(new Object[]{id, modelo, potencia, autonomia, precio});
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autonomia;
    private javax.swing.JButton cleanButton;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exportCsvButton;
    private javax.swing.JButton exportJSON;
    private javax.swing.JButton importCSVbutton;
    private javax.swing.JButton importJSON;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelAutonomia;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel labelPotencia;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JTextField modelo;
    private javax.swing.JTextField potencia;
    private javax.swing.JTextField precio;
    private javax.swing.JButton readButton;
    private javax.swing.JTable tablaCoches;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
