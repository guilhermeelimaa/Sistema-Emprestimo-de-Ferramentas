package visao;

import DAO.AmigoDAO;
import DAO.FerramentaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Emprestimo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.Ferramenta;

public class CadastroEmprestimo extends javax.swing.JFrame {

    private Emprestimo objetoemprestimo;
    private AmigoDAO amigoDAO;
    private FerramentaDAO ferramentaDAO;

    public CadastroEmprestimo() {
        initComponents();
        this.objetoemprestimo = new Emprestimo();
        setTitle("Cadastrar Empréstimos");
        this.amigoDAO = new AmigoDAO();
        this.ferramentaDAO = new FerramentaDAO();
        carregarFerramentas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        JBCadastrar = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTFAmigo = new javax.swing.JTextField();
        JCBFerramenta = new javax.swing.JComboBox<>();
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

        // Set current date in JTFDataAquisicao field
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        JTFDataAquisicao.setText(currentDate.format(formatter));

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
                                        .addComponent(JCBFerramenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                        .addComponent(JCBFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }// </editor-fold>                        

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        MenuPrincipal objetotela = new MenuPrincipal();
        objetotela.setVisible(true);
    }

private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        int id = 0;
        String amigo = "";
        String ferramentaNome = "";
        String dataaquisicao = "";
        String dataentrega = "";

        if (this.JTFAmigo.getText().length() < 2) {
            throw new Mensagens("Nome do amigo deve conter ao menos 2 caracteres.");
        } else {
            amigo = this.JTFAmigo.getText();
        }

        ferramentaNome = (String) JCBFerramenta.getSelectedItem();

        if (!amigoDAO.amigoExiste(amigo)) {
            throw new Mensagens("O amigo informado não está cadastrado no banco de dados.");
        }

        dataaquisicao = this.JTFDataAquisicao.getText();

        if (this.JTFDataEntrega.getText().length() < 8) {
            throw new Mensagens("Data de entrega deve conter ao menos 8 caracteres.");
        } else {
            dataentrega = this.JTFDataEntrega.getText();
        }

        // Busca a ferramenta pelo nome
        Ferramenta ferramenta = ferramentaDAO.buscarFerramentaPorNome(ferramentaNome);

        // Verifica se a ferramenta foi encontrada
        if (ferramenta == null) {
            throw new Mensagens("A ferramenta selecionada não foi encontrada no banco de dados.");
        }

        // Verifica se há pelo menos uma unidade da ferramenta disponível
        if (ferramenta.getQuantidade() <= 0) {
            throw new Mensagens("Não há unidades disponíveis da ferramenta selecionada.");
        }

        // Atualiza a quantidade da ferramenta, subtraindo uma unidade
        ferramenta.setQuantidade(ferramenta.getQuantidade() - 1);
        ferramentaDAO.atualizarQuantidadeFerramenta(ferramenta);

        // Insere o empréstimo no banco de dados
        if (this.objetoemprestimo.InsertEmprestimoBD(id, amigo, ferramentaNome, dataaquisicao, dataentrega)) {
            JOptionPane.showMessageDialog(rootPane, "Empréstimo cadastrado com sucesso!");

            this.JTFAmigo.setText("");
            this.JTFDataAquisicao.setText("");
            this.JTFDataEntrega.setText("");

            // Atualiza o ComboBox de ferramentas
            carregarFerramentas();
        }

        System.out.println(this.objetoemprestimo.getMinhaLista().toString());
    } catch (Mensagens erro) {
        JOptionPane.showMessageDialog(null, erro.getMessage());
    } catch (NumberFormatException erro2) {
        JOptionPane.showMessageDialog(null, "Informe um número válido.");
    } catch (SQLException ex) {
        Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    private void carregarFerramentas() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(ferramentaDAO.listarNomesFerramentas().toArray(new String[0]));
        JCBFerramenta.setModel(model);
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new CadastroEmprestimo().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JComboBox<String> JCBFerramenta;
    private javax.swing.JTextField JTFDataAquisicao;
    private javax.swing.JTextField JTFDataEntrega;
    private javax.swing.JTextField JTFAmigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration                   
}
