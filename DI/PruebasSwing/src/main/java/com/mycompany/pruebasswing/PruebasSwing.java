/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebasswing;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author at5DAM2
 */
public class PruebasSwing {

    public static void main(String[] args) {
        
        JButton btnSaludar = new JButton("saludar");
        JButton btnSaludar2 = new JButton("saludar2");
        JButton btnSaludar3 = new JButton("saludar3");
        
        JCheckBox fresa=new JCheckBox("fresa");
        JCheckBox vainilla=new JCheckBox("vainilla");
        JCheckBox choco=new JCheckBox("choco");
        
        JTable tablaPrueba=new JTable();
        
        JTable x= new JTable(new DefaultTableModel(new Object[][]{},new String[]{
        "facu","fausto","laura","alvaro","carlos"
        }));
        JTextField areaTexto= new JTextField(30);
        
        JLabel lblInfo = new JLabel("mi primera app");
        ButtonGroup generos=new ButtonGroup();
        JRadioButton rdHombre = new JRadioButton("hombre");
        JRadioButton rdmujer = new JRadioButton("mujer");
        JComboBox comboColores=new JComboBox();
        comboColores.addItem(" ");
        comboColores.addItem("green");
        comboColores.addItem("red");
        comboColores.addItem("blue");
        JRadioButton rdPrefieronodecirlo = new JRadioButton("helicoptero apache de combate");
        generos.add(rdHombre);
        generos.add(rdmujer);
        generos.add(rdPrefieronodecirlo);
        JPanel mipanel= new JPanel();
        JFrame miventana=new JFrame("mi app");
        mipanel.add(btnSaludar);
        mipanel.add(btnSaludar2);
        mipanel.add(btnSaludar3);
        mipanel.add(areaTexto);
        mipanel.add(lblInfo);
        mipanel.add(fresa);
        mipanel.add(choco);
        mipanel.add(vainilla);
        mipanel.add(x);
        mipanel.add(comboColores);
        mipanel.add(rdHombre);
        mipanel.add(rdmujer);
        
        
        miventana.setVisible(true);
        miventana.add(mipanel);
        miventana.setSize(500,500);
        miventana.setResizable(true);
        miventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        areaTexto.setSize(0, 0);
        
        comboColores.addActionListener((l)-> {
        String elegido= comboColores.getSelectedItem().toString();
        Color c=null;
            switch (elegido) {
                case "green":
                    c=Color.GREEN;
                    break;
                    
                case "red":
                    c=Color.red;
                    break;
                    
                case "blue":
                    c=Color.blue;
                    break;
                    
                default:
                    throw new AssertionError();
            }
        mipanel.setBackground(c);
        });
        btnSaludar2.addActionListener((f)->{
            //if (areaTexto.getText().isEmpty()){JOptionPane.showMessageDialog(miventana,"kkculopedopis");}
        JOptionPane.showConfirmDialog(miventana, "facu la mama", "sdgswr", 1);
    });
        
    }
}
