package visao;

import modelo.Emprestimo;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioEmprestimo extends javax.swing.JFrame {

    private ArrayList<Emprestimo> emprestimos;
    private JTable tabelaEmprestimos;

    public RelatorioEmprestimo() {
        initComponents();
        carregarEmprestimos();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        // Criando o modelo da tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Ferramenta");
        model.addColumn("Data Aquisição");
        model.addColumn("Data Devolução");

        // Preenchendo a tabela com os dados dos empréstimos
        for (Emprestimo emp : emprestimos) {
            Object[] rowData = {
                emp.getAmigo(),
                emp.getFerramenta(),
                emp.getDataaquisicao(),
                emp.getDataentrega()
            };
            model.addRow(rowData);
        }

        // Definindo o modelo da tabela
        tabelaEmprestimos.setModel(model);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioEmprestimo().setVisible(true);
            }
        });
    }
}
