package Principal;

import visao.MenuPrincipal;

/**
 * Classe principal que inicia a aplicação.
 */
public class Principal {

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args Os argumentos da linha de comando (não utilizados neste
     * caso).
     */
    public static void main(String[] args) {
        /**
         * Cria uma instância do menu principal
         */
        MenuPrincipal objetotela = new MenuPrincipal();
        /**
         * Torna a janela visível
         */
        objetotela.setVisible(true);
    }

}
