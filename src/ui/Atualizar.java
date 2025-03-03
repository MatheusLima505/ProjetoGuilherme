package ui;

import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import projetofinal.CustomerDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 20221074010010
 */
public class Atualizar extends javax.swing.JFrame {
    private JFrame crudUI;
    
    private int row;
    private int column;
    private String value;
    private String type;
    
    private int id;
    private int sid;
    private String fname;
    private String sname;
    private String email;
    private int add;
    private int act;
    
    private String newv;
    
    public Atualizar(JFrame crudUI, int row, int column, String value,String type, int id, int sid, String fname, String sname, String email, int add, int act) {
        initComponents();
        jLabel8.setText(type);
        nome.setText(fname);
        nome1.setText(sname);
        this.crudUI=crudUI;
        this.row = row;
        this.column=column;
        this.value=value;
        this.type=type;
        this.id=id;
        this.sid=sid;
        this.fname=fname;
        this.sname=sname;
        this.email=email;
        this.add=add;
        this.act=act;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        input = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nome = new javax.swing.JLabel();
        nome1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setText("tipo do input");
        jLabel8.setToolTipText("");

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nome.setText("primeironome");

        nome1.setText("sobrenome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(76, 76, 76)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(8, 8, 8)))
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            this.newv=input.getText();
            int b = 0;
            CustomerDAO dao = new CustomerDAO();
            if (this.type == "store_id") {
                b = parseInt(this.newv);
                dao.updateCustomer(this.id, b, this.fname, this.sname, this.email, this.add, this.act);
            } else if (this.type == "first_name"){
                dao.updateCustomer(this.id, this.sid, this.newv, this.sname, this.email, this.add, this.act);
            } else if (this.type =="last_name") {
                dao.updateCustomer(this.id, this.sid, this.fname, this.newv, this.email, this.add, this.act);
            } else if (this.type == "email") {
                dao.updateCustomer(this.id, this.sid, this.fname, this.sname, this.newv, this.add, this.act);
            } else if (this.type=="address_id"){
                b = parseInt(this.newv);
                dao.updateCustomer(this.id, this.sid, this.fname, this.sname, this.email, b, this.act);
            } else if (this.type=="active") {
                b = parseInt(this.newv);
                dao.updateCustomer(this.id, this.sid, this.fname, this.sname, this.email, this.add, b);
            } else if (this.type =="customer_id"){
                b = parseInt(this.newv);
                dao.updateCustomer(b, this.sid, this.fname, this.sname, this.email, this.add, this.act);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Atualizar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ne){
            JOptionPane.showMessageDialog(rootPane, "Tipo de input invalido.");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        crudUI.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField input;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel nome1;
    // End of variables declaration//GEN-END:variables
}
