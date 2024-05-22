package modelo;

import DAO.EmprestimoDAO;
import java.util.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Emprestimo {

    private int id;
    private String amigo;
    private String ferramenta;
    private Date dataaquisicao;
    private Date dataentrega;
    private final EmprestimoDAO dao;

    // Construtor padrão
    public Emprestimo() {
        this.dao = new EmprestimoDAO();
    }

    // Construtor com parâmetros
    public Emprestimo(int id, String amigo, String ferramenta, Date dataaquisicao, Date dataentrega) {
        this.id = id;
        this.amigo = amigo;
        this.ferramenta = ferramenta;
        this.dataaquisicao = dataaquisicao;
        this.dataentrega = dataentrega;
        this.dao = new EmprestimoDAO();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmigo() {
        return amigo;
    }

    public void setAmigo(String amigo) {
        this.amigo = amigo;
    }

    public String getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(String ferramenta) {
        this.ferramenta = ferramenta;
    }

    public Date getDataaquisicao() {
        return dataaquisicao;
    }

    public void setDataaquisicao(Date dataaquisicao) {
        this.dataaquisicao = dataaquisicao;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

    @Override
    public String toString() {
        return "\n Amigo: " + this.getAmigo()
                + "\n Ferramenta: " + this.getFerramenta()
                + "\n Data Aquisição: " + this.getDataaquisicao()
                + "\n Data Entrega: " + this.getDataentrega()
                + "\n -----------";
    }
    
    public ArrayList<Emprestimo> getMinhaLista() {
        return dao.getMinhaLista();
    }

    public boolean InsertEmprestimoBD(int id, String amigo, String ferramenta, Date dataaquisicao, Date dataentrega) throws SQLException {
        Emprestimo objeto = new Emprestimo(id, amigo, ferramenta, dataaquisicao, dataentrega);
        dao.InsertEmprestimoBD(objeto);
        return true;
    }

    public boolean DeleteEmprestimoBD(int id) {
        dao.DeleteEmprestimoBD(id);
        return true;
    }

    public boolean UpdateEmprestimoBD(int id, String amigo, String ferramenta, Date dataaquisicao, Date dataentrega) {
        Emprestimo objeto = new Emprestimo(id, amigo, ferramenta, dataaquisicao, dataentrega);
        dao.UpdateEmprestimoBD(objeto);
        return true;
    }

    public Emprestimo carregaEmprestimo(int id) {
        return dao.carregaEmprestimo(id);
    }

    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
