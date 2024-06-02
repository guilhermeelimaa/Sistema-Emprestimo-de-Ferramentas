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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Total Empréstimos"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
