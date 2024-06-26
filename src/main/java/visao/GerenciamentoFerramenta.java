/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Ferramenta;

/**
 *
 * @author User
 */
public class GerenciamentoFerramenta extends javax.swing.JFrame {

    /**
     * Creates new form GerenciamentoFerramenta
     */
    private Ferramenta objetoferramenta;

    public GerenciamentoFerramenta() {
        initComponents();
        this.objetoferramenta = new Ferramenta();
        this.carregaTabela();
        setTitle("Gerenciamento de Ferramentas");
    }

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableFerramenta.getModel();
        modelo.setNumRows(0);
        /**
         * Posiciona na primeira linha da tabela
         */
        
        /**
         * Carrega a lista de objetos aluno
         */
        ArrayList<Ferramenta> minhalista = objetoferramenta.getMinhaLista();
        for (Ferramenta a : minhalista) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getMarca(),
                a.getCusto(),});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFerramenta = new javax.swing.JTable();
        JBCancelar = new javax.swing.JButton();
        JBAlterar = new javax.swing.JButton();
        JBApagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        JTFMarca = new javax.swing.JTextField();
        JTFCusto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento Ferramenta");

        jTableFerramenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Marca", "Custo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFerramenta.getTableHeader().setReorderingAllowed(false);
        jTableFerramenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFerramentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFerramenta);

        JBCancelar.setText("Voltar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBAlterar.setText("Alterar");
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });

        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Marca:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Custo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTFNome, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(JTFMarca)
                            .addComponent(JTFCusto)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBCancelar)
                        .addGap(73, 73, 73)
                        .addComponent(JBAlterar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(JBApagar)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar)
                    .addComponent(JBAlterar)
                    .addComponent(JBApagar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        /**
         * Libera todos os recurso da interface gráfica
         */
        dispose();
        MenuPrincipal objetotela = new MenuPrincipal();
        /**
         * Torna a janela visível
         */
        objetotela.setVisible(true);
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void jTableFerramentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFerramentaMouseClicked
        // TODO add your handling code here:
        if (this.jTableFerramenta.getSelectedRow() != -1) {
            int id = (int) this.jTableFerramenta.getValueAt(this.jTableFerramenta.getSelectedRow(), 0);
            String nome = this.jTableFerramenta.getValueAt(this.jTableFerramenta.getSelectedRow(), 1).toString();
            String marca = this.jTableFerramenta.getValueAt(this.jTableFerramenta.getSelectedRow(), 2).toString();
            String custoStr = this.jTableFerramenta.getValueAt(this.jTableFerramenta.getSelectedRow(), 3).toString();

            double custo = Double.parseDouble(custoStr);

            this.JTFNome.setText(nome);
            this.JTFMarca.setText(marca);
            this.JTFCusto.setText(Double.toString(custo));
        }
    }//GEN-LAST:event_jTableFerramentaMouseClicked

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
        // TODO add your handling code here:
        try {
            int id = 0;
            String nome = "";
            String marca = "";
            double custo = 0;

            /**
             * Verifica se os campos foram preenchidos corretamente
             */
            if (this.JTFNome.getText().length() < 2) {
                throw new Mensagens("Nome da ferramenta deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFNome.getText();
            }
            if (this.JTFMarca.getText().length() < 2) {
                throw new Mensagens("Marca da ferramenta deve conter ao menos 2 caracteres.");
            } else {
                marca = this.JTFMarca.getText();
            }
            if (this.JTFCusto.getText().isEmpty()) {
                throw new Mensagens("Custo da ferramenta não pode estar vazio.");
            } else {
                custo = Double.parseDouble(this.JTFCusto.getText());
            }

            /**
             * Verifica se uma ferramenta foi selecionada na tabela
             */
            if (this.jTableFerramenta.getSelectedRow() == -1) {
                throw new Mensagens("Por favor, selecione uma ferramenta para alterar.");
            } else {
                id = Integer.parseInt(this.jTableFerramenta.getValueAt(this.jTableFerramenta.getSelectedRow(), 0).toString());
            }

            if (this.objetoferramenta.UpdateFerramentaBD(id, nome, marca, custo)) {
                this.JTFNome.setText("");
                this.JTFMarca.setText("");
                this.JTFCusto.setText("");
                JOptionPane.showMessageDialog(rootPane, "Ferramenta alterada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao alterar a ferramenta.");
            }

            /**
             * Recarrega a tabela após a alteração
             */
            carregaTabela();
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um valor numérico válido para o custo.");
        }

    }//GEN-LAST:event_JBAlterarActionPerformed

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
        // TODO add your handling code here:
        try {
            int id = 0;
            if (this.jTableFerramenta.getSelectedRow() == -1) {
                throw new Mensagens(
                        "Primeiro Selecione uma Ferramenta para APAGAR");
            } else {
                id = Integer.parseInt(this.jTableFerramenta.
                        getValueAt(this.jTableFerramenta.getSelectedRow(), 0).
                        toString());
            }
            int respostaUsuario = JOptionPane.
                    showConfirmDialog(null,
                            "Tem certeza que deseja apagar esta Ferramenta ?");
            if (respostaUsuario == 0) {
                if (this.objetoferramenta.DeleteFerramentaBD(id)) {

                    this.JTFNome.setText("");
                    this.JTFMarca.setText("");
                    this.JTFCusto.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Emprestimo Apagado com Sucesso!");
                }
            }
            System.out.println(this.objetoferramenta.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {

            carregaTabela();
        }
    }//GEN-LAST:event_JBApagarActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciamentoFerramenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoFerramenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoFerramenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoFerramenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciamentoFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFCusto;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFerramenta;
    // End of variables declaration//GEN-END:variables
}
