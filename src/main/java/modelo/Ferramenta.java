package modelo;

import java.util.*;
import DAO.FerramentaDAO;
import java.sql.SQLException;

public class Ferramenta {

    private int id;
    private String nome;
    private String marca;
    private Double custo;
    private final FerramentaDAO dao;

    public Ferramenta() {
        this.dao = new FerramentaDAO();
    }

    public Ferramenta(int id, String nome, String marca, Double custo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.dao = new FerramentaDAO();
    }

    public Ferramenta(int id, String nome, String marca, double custo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.dao = new FerramentaDAO();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Marca: " + this.getMarca()
                + "\n Custo: " + this.getCusto()
                + "\n -----------";
    }

    public ArrayList getMinhaLista() {

        return dao.getMinhaLista();
    }

    public boolean InsertFerramentaBD(String nome, String marca, double custo) throws SQLException {
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo);

        dao.InsertFerramentaBD(objeto);
        return true;
    }

    public boolean DeleteFerramentaBD(int id) {

        dao.DeleteFerramentaBD(id);
        return true;
    }

    public boolean UpdateFerramentaBD(int id, String nome, String marca, double custo) {
        return dao.UpdateFerramentaBD(id, nome, marca, custo);
    }

    public Amigo carregaFerramenta(int id) {
        dao.carregaFerramenta(id);
        return null;
    }

    public int maiorID() throws SQLException {

        return dao.maiorID();
    }
}
