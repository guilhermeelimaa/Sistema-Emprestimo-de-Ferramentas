package visao;

import modelo.Ferramenta;
import modelo.Amigo;
import modelo.Emprestimo;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioEmprestimo extends javax.swing.JFrame {

    private ArrayList<Emprestimo> emprestimos;
    private JScrollPane jScrollPane1;

    public RelatorioEmprestimo() {
        initComponents();
        // Carrega os empréstimos após a inicialização da tabela
        carregarEmprestimos();
        // Configura o JFrame
        pack();
        setVisible(true);
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
                emp.getAmigo(), // obtendo o nome do amigo
                emp.getFerramenta(), // obtendo o nome da ferramenta
                emp.getDataaquisicao(), // data de aquisição
                emp.getDataentrega() // data de entrega
            };
            model.addRow(rowData);
        }

        // Definindo o modelo da tabela
        tbrelatorioemprestimo.setModel(model);

        // Criando a tabela usando o modelo
        JTable tbrelatorioemprestimo = new JTable(model);

        // Criando um JScrollPane para a tabela
        jScrollPane1 = new JScrollPane(tbrelatorioemprestimo);

        // Adicionando o JScrollPane ao JFrame
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioEmprestimo();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbrelatorioemprestimo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbrelatorioemprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Amigo", "Ferramenta", "Data Aquisição", "Data Entrega"
            }
        ));
        jScrollPane2.setViewportView(tbrelatorioemprestimo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbrelatorioemprestimo;
    // End of variables declaration//GEN-END:variables
}
