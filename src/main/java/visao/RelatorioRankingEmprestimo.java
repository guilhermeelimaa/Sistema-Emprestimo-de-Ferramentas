package visao;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import modelo.Emprestimo;

public class RelatorioRankingEmprestimo extends JFrame { 
   
    private ArrayList<Emprestimo> emprestimos;

    public RelatorioRankingEmprestimo() {
        initComponents();
        carregarEmprestimos();
        setTitle("Relatório Ranking de Empréstimos");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose(); // Fecha a janela
                // Abre o menu principal
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new MenuPrincipal().setVisible(true);
                    }
                });
            }
        });
    }

    private void carregarEmprestimos() {
        Emprestimo emprestimo = new Emprestimo();
        emprestimos = emprestimo.getMinhaLista();

        // Contagem de empréstimos por pessoa
        Map<String, Integer> countMap = new HashMap<>();
        for (Emprestimo emp : emprestimos) {
            String amigo = emp.getAmigo();
            countMap.put(amigo, countMap.getOrDefault(amigo, 0) + 1);
        }

        // Ordenação decrescente da contagem de empréstimos
        ArrayList<Map.Entry<String, Integer>> sortedAmigos = new ArrayList<>(countMap.entrySet());
        sortedAmigos.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Criando o modelo da tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Total Empréstimos");

        // Preenchendo a tabela com os dados dos empréstimos
        for (Map.Entry<String, Integer> entry : sortedAmigos) {
            Object[] rowData = {
                entry.getKey(),
                entry.getValue()
            };
            model.addRow(rowData);
        }

        // Definindo o modelo da tabela
        jTable1.setModel(model); // Use jTable1 em vez de tabelaEmprestimos
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioRankingEmprestimo().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Total Empréstimos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        MenuPrincipal objetotela = new MenuPrincipal();
        // Torna a janela visível
        objetotela.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
