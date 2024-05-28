package visao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Ferramenta;
import DAO.FerramentaDAO;
import java.sql.Date;

public class CadastroFerramenta extends javax.swing.JFrame {

    private Ferramenta objetoferramenta;
    private FerramentaDAO ferramentaDAO;

    public CadastroFerramenta() {
        initComponents();
        this.ferramentaDAO = new FerramentaDAO();
        setTitle("Cadastrar Ferramentas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JBCadastrar = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTFNomeF = new javax.swing.JTextField();
        JTFMarca = new javax.swing.JTextField();
        JTFCusto = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Marca:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Custo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(JBCadastrar)
                        .addGap(59, 59, 59)
                        .addComponent(JBVoltar))
                    .addComponent(JTFCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFNomeF, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNomeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCadastrar)
                    .addComponent(JBVoltar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>                        

private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        String nome = JTFNomeF.getText();
        String marca = JTFMarca.getText();
        double custo = Double.parseDouble(JTFCusto.getText());

        Ferramenta ferramenta = ferramentaDAO.buscarFerramentaPorNome(nome);

        if (ferramenta == null) {
            // Se a ferramenta não existe, cria uma nova com quantidade 1
            Ferramenta novaFerramenta = new Ferramenta(0, nome, marca, custo, 1, new Date(System.currentTimeMillis()));
            if (ferramentaDAO.InsertFerramentaBD(novaFerramenta)) {
                JOptionPane.showMessageDialog(this, "Ferramenta cadastrada com sucesso!");
                JTFNomeF.setText("");
                JTFMarca.setText("");
                JTFCusto.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar ferramenta.");
            }
        } else {
            // Se a ferramenta existe, atualiza a quantidade
            int novaQuantidade = ferramenta.getQuantidade() + 1;
            ferramenta.setQuantidade(novaQuantidade);
            if (ferramentaDAO.atualizarQuantidadeFerramenta(ferramenta)) {
                JOptionPane.showMessageDialog(this, "Quantidade de ferramenta atualizada com sucesso!");
                JTFNomeF.setText("");
                JTFMarca.setText("");
                JTFCusto.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar quantidade de ferramenta.");
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido para o custo.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados.");
        ex.printStackTrace();
    }
}


    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }                                         

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTextField JTFCusto;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JTextField JTFNomeF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
