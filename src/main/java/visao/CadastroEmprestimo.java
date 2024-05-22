/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Emprestimo;

/**
 *
 * @author kaios
 */
public class CadastroEmprestimo extends javax.swing.JFrame {

    /**
     * Creates new form CadastroEmprestimos
     */
    private Emprestimo objetoemprestimo;

    public CadastroEmprestimo() {
        initComponents();
        this.objetoemprestimo = new Emprestimo();
        setTitle("Cadastrar Empréstimos");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBCadastrar = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTFAmigo = new javax.swing.JTextField();
        JTFFerramenta = new javax.swing.JTextField();
        JTFDataAquisicao = new javax.swing.JTextField();
        JTFDataEntrega = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        JBVoltar.setText("Cancelar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Amigo:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Ferramenta:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Data Aquisição:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Data Entrega:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(JBCadastrar)
                .addGap(52, 52, 52)
                .addComponent(JBVoltar)
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTFAmigo, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(JTFFerramenta)
                    .addComponent(JTFDataAquisicao)
                    .addComponent(JTFDataEntrega))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTFDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCadastrar)
                    .addComponent(JBVoltar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        // TODO add your handling code here:
        dispose();
        MenuPrincipal objetotela = new MenuPrincipal();
        // Torna a janela visível
        objetotela.setVisible(true);
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        // TODO add your handling code here:
        try {
            int id = 0;
            String amigo = "";
            String ferramenta = "";
            String dataaquisicao = "";
            String dataentrega = "";
            if (this.JTFAmigo.getText().length() < 2) {
                throw new Mensagens("Nome do amigo deve conter ao menos 2 caracteres.");
            } else {
                amigo = this.JTFAmigo.getText();
            }
            if (this.JTFFerramenta.getText().length() < 3) {
                throw new Mensagens("Ferramenta deve conter ao menos 3 caracteres");
            } else {
                ferramenta = this.JTFFerramenta.getText();
            }
            if (this.JTFDataAquisicao.getText().length() < 8) {
                throw new Mensagens("Data de aquisição deve conter ao menos 8 caracteres.");
            } else {
                String dataAquisicaoString = this.JTFDataAquisicao.getText();

                dataaquisicao = this.JTFDataAquisicao.getText();
            }
            if (this.JTFDataEntrega.getText().length() < 8) {
                throw new Mensagens("Data de entrega deve conter ao menos 8 caracteres.");
            } else {
                String dataEntregaString = this.JTFDataEntrega.getText();

                dataentrega = this.JTFDataEntrega.getText();
            }

            if (this.objetoemprestimo.InsertEmprestimoBD(id, amigo, ferramenta, dataaquisicao, dataentrega)) {
                JOptionPane.showMessageDialog(rootPane, "Emprestimo Cadastrado com Sucesso!");

                this.JTFAmigo.setText("");
                this.JTFFerramenta.setText("");
                this.JTFDataAquisicao.setText("");
                this.JTFDataEntrega.setText("");
            }

            System.out.println(this.objetoemprestimo.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTextField JTFAmigo;
    private javax.swing.JTextField JTFDataAquisicao;
    private javax.swing.JTextField JTFDataEntrega;
    private javax.swing.JTextField JTFFerramenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
