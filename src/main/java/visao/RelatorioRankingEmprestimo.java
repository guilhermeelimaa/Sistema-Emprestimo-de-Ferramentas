package visao;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import modelo.Emprestimo;

public class RelatorioRankingEmprestimo extends JFrame {

    private ArrayList<Emprestimo> emprestimos;
    private JTable tabelaEmprestimos;

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

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Empréstimos");

        // Inicializa a tabela
        tabelaEmprestimos = new JTable();

        // Tabela para exibir os empréstimos
        JScrollPane scrollPane = new JScrollPane(tabelaEmprestimos);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
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
        tabelaEmprestimos.setModel(model);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioRankingEmprestimo().setVisible(true);
            }
        });
    }
}
