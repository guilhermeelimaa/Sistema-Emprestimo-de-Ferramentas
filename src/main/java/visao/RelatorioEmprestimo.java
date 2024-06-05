package visao;

import modelo.Emprestimo;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioEmprestimo extends javax.swing.JFrame {

    private ArrayList<Emprestimo> emprestimos;
    private JScrollPane jScrollPane1;

    public RelatorioEmprestimo() {
        initComponents();
        /**
         * Carrega os empréstimos após a inicialização da tabela
         */
        carregarEmprestimos();
        /**
         * Configura o JFrame
         */
        pack();
        setVisible(true);
        setTitle("Relatório de Empréstimos");
    }
    

    // Criando o modelo da tabela

    DefaultTableModel model = new DefaultTableModel(new Object[]{"Amigo", "Ferramenta", "Data aquisição", "Data Entrega", "Status"}, 0) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
};

    private void carregarEmprestimos() {
        Emprestimo emprestimo = new Emprestimo();
        emprestimos = emprestimo.getMinhaLista();

        /**
         * Preenchendo a tabela com os dados dos empréstimos
         */
        for (Emprestimo emp : emprestimos) {
            Object[] rowData = {
                emp.getAmigo(), /**
                 * Obtendo o nome do amigo
                 */
                emp.getFerramenta(), /**
                 * Obtendo o nome da ferramenta
                 */
                emp.getDataaquisicao(), /**
                 * Data de aquisição
                 */
                emp.getDataentrega(), /**
                * Data de entrega
                */
                emp.getStatus()
            };
            model.addRow(rowData);
        }

        /**
         * Definindo o modelo da tabela
         */
        tbrelatorioemprestimo.setModel(model);

        /**
         * Criando a tabela usando o modelo
         */
        JTable tbrelatorioemprestimo = new JTable(model);

        /**
         * Criando um JScrollPane para a tabela
         */
        jScrollPane1 = new JScrollPane(tbrelatorioemprestimo);

        /**
         * Adicionando o JScrollPane ao JFrame
         */
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbrelatorioemprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Amigo", "Ferramenta", "Data Aquisição", "Data Entrega", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbrelatorioemprestimo.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbrelatorioemprestimo);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbrelatorioemprestimo;
    // End of variables declaration//GEN-END:variables
}
