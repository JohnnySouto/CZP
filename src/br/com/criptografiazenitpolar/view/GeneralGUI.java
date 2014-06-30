package br.com.criptografiazenitpolar.view;

/**
 *
 * @author Johnny Souto e-mail: falecomigo@johnnysouto.com.br
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;
import static java.awt.EventQueue.invokeLater;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public final class GeneralGUI extends JFrame {
    
    private String txtOriginal;
    private String txtCriptografada;
    private String txtTemp;
    private char[] arrayTxtOriginal;
    private char[] arrayTxtCriptografada;
    private JLabel lbMensagemOriginal;
    private JLabel lbMensagemCriptografada;
    private JTextField tfOriginal;
    private JTextField tfCriptografada;
    private JButton criptografarButton;
    private JButton desCriptografarButton;
    private JButton clipboardButton;
    
    public GeneralGUI() {
        initGUI();
    }
    
    public void criptografarMensagemActionPerformed(ActionEvent evt){
        
        txtCriptografada = tfOriginal.getText().toLowerCase();
        
        arrayTxtOriginal = txtCriptografada.toCharArray();
        
        for (int i = 0; i < arrayTxtOriginal.length; i++) {
            if (arrayTxtOriginal[i] == 'a') {
                arrayTxtOriginal[i] = 'i';
            } else if (arrayTxtOriginal[i] == 'e') {
                    arrayTxtOriginal[i] = 'o';
                    } else if (arrayTxtOriginal[i] == 'i') {
                            arrayTxtOriginal[i] = 'a';
                            } else if (arrayTxtOriginal[i] == 'l') {
                                    arrayTxtOriginal[i] = 'n';
                                    } else if (arrayTxtOriginal[i] == 'n') {
                                            arrayTxtOriginal[i] = 'l';
                                            } else if (arrayTxtOriginal[i] == 'o') {
                                                    arrayTxtOriginal[i] = 'e';
                                                    } else if (arrayTxtOriginal[i] == 'p') {
                                                            arrayTxtOriginal[i] = 'z';
                                                            } else if (arrayTxtOriginal[i] == 'r') {
                                                                    arrayTxtOriginal[i] = 't';
                                                                    } else if (arrayTxtOriginal[i] == 't') {
                                                                            arrayTxtOriginal[i] = 'r';
                                                                            } else if (arrayTxtOriginal[i] == 'z') {
                                                                                    arrayTxtOriginal[i] = 'p';
                                                                                    }
        }
        
        txtCriptografada = String.valueOf(arrayTxtOriginal);
        
        tfCriptografada.setText(txtCriptografada);
    }
    
    public void desCriptografarMensagemActionPerformed(ActionEvent evt){
        
        
        txtOriginal = tfCriptografada.getText().toLowerCase();
        
        arrayTxtCriptografada = txtOriginal.toCharArray();
        
        for (int i = 0; i < arrayTxtCriptografada.length; i++) {
            if (arrayTxtCriptografada[i] == 'i') {
                arrayTxtCriptografada[i] = 'a';
            } else if (arrayTxtCriptografada[i] == 'o') {
                    arrayTxtCriptografada[i] = 'e';
                    } else if (arrayTxtCriptografada[i] == 'a') {
                            arrayTxtCriptografada[i] = 'i';
                            } else if (arrayTxtCriptografada[i] == 'n') {
                                    arrayTxtCriptografada[i] = 'l';
                                    } else if (arrayTxtCriptografada[i] == 'l') {
                                            arrayTxtCriptografada[i] = 'n';
                                            } else if (arrayTxtCriptografada[i] == 'e') {
                                                    arrayTxtCriptografada[i] = 'o';
                                                    } else if (arrayTxtCriptografada[i] == 'z') {
                                                            arrayTxtCriptografada[i] = 'p';
                                                            } else if (arrayTxtCriptografada[i] == 't') {
                                                                    arrayTxtCriptografada[i] = 'r';
                                                                    } else if (arrayTxtCriptografada[i] == 'r') {
                                                                            arrayTxtCriptografada[i] = 't';
                                                                            } else if (arrayTxtCriptografada[i] == 'p') {
                                                                                    arrayTxtCriptografada[i] = 'z';
                                                                                    }
        }
        
        txtOriginal = String.valueOf(arrayTxtCriptografada);
        
        tfOriginal.setText(txtOriginal);
    }
    
    public void clipboardButtonActionPerformed(ActionEvent evt) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  
        txtTemp = tfCriptografada.getText().toLowerCase();  
        StringSelection strSelection = new StringSelection(txtTemp);  
        clipboard.setContents(strSelection, null);
    }
    
    public void initGUI() {
        lbMensagemOriginal = new JLabel("Mensagem Original:");
        lbMensagemCriptografada = new JLabel("Mensagem Criptografada:");
        tfOriginal = new JTextField(12);
        tfCriptografada = new JTextField(12);
        criptografarButton = new JButton("Criptografar");
        desCriptografarButton = new JButton("(Des)Criptografar");
        clipboardButton = new JButton("Copiar Mensagem Criptografada");
        
        tfOriginal.setSize(80, 24);
        tfCriptografada.setSize(80, 24);

        GroupLayout grpLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(grpLayout);
        grpLayout.setAutoCreateGaps(true);
        grpLayout.setAutoCreateContainerGaps(true);

        grpLayout.setHorizontalGroup(grpLayout.createSequentialGroup()
            .addGroup(grpLayout.createParallelGroup(LEADING)
                .addComponent(lbMensagemOriginal)
                .addComponent(lbMensagemCriptografada)
                //.addGroup(grpLayout.createParallelGroup(LEADING)
                .addComponent(clipboardButton))
            .addGroup(grpLayout.createParallelGroup(LEADING)
                .addComponent(tfOriginal)
                .addComponent(tfCriptografada))
            .addGroup(grpLayout.createParallelGroup(LEADING)
                .addComponent(criptografarButton)
                .addComponent(desCriptografarButton))
        );
       
        grpLayout.linkSize(SwingConstants.HORIZONTAL, clipboardButton, criptografarButton, desCriptografarButton);
        
        grpLayout.linkSize(SwingConstants.VERTICAL, tfOriginal, tfCriptografada);

        grpLayout.setVerticalGroup(grpLayout.createSequentialGroup()
            .addGroup(grpLayout.createParallelGroup(BASELINE)
                .addComponent(lbMensagemOriginal)
                .addComponent(tfOriginal)
                .addComponent(criptografarButton))
            .addGroup(grpLayout.createParallelGroup(LEADING)
                .addComponent(lbMensagemCriptografada)
                .addComponent(tfCriptografada)
                .addComponent(desCriptografarButton))
            .addGroup(grpLayout.createParallelGroup(LEADING)
                .addComponent(clipboardButton))
        );
        
        criptografarButton.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criptografarMensagemActionPerformed(evt);
            }
        });
        
        desCriptografarButton.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desCriptografarMensagemActionPerformed(evt);
            }
        });
        
        clipboardButton.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clipboardButtonActionPerformed(evt);
            }
        });

        setTitle("Criptografia Zenit Polar");
        setSize(720, 144);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static void main(String args[]) {
        invokeLater(new Runnable() {
            public void run() {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    } 
                                //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                                // "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                                // UIManager.getCrossPlatformLookAndFeelClassName());
                                // "javax.swing.plaf.metal.MetalLookAndFeel");
                }catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(GeneralGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(GeneralGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(GeneralGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(GeneralGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                new GeneralGUI().setVisible(true);
            }
        });
    }
}