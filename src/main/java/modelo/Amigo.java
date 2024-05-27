package modelo;

import java.util.*;
import DAO.AmigoDAO;
import java.sql.SQLException;

public class Amigo extends Ferramenta {

    private int id;
    private String nome;
    private String telefone;
    private final AmigoDAO dao; 

    public Amigo() {
        this.dao = new AmigoDAO(); 
    }

    public Amigo(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.dao = new AmigoDAO();
    }

    public Amigo(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dao = new AmigoDAO(); 
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Telefone: " + this.getTelefone()              
                + "\n -----------";
    }

    public ArrayList<Amigo> getMinhaLista() {
        return dao.getMinhaLista();
    }
    

    public boolean InsertAmigoBD(int id, String nome, String telefone) throws SQLException {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.InsertAmigoBD(objeto);
        return true;
    }
    

    public boolean InsertAmigoBD(String nome, String telefone) throws SQLException {
        int id = this.maiorID() + 1;
        return InsertAmigoBD(id, nome, telefone);
    }

    public boolean DeleteAmigoBD(int id) {
        dao.DeleteAmigoBD(id);
        return true;
    }

    public boolean UpdateAmigoBD(int id, String nome, String telefone) {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.UpdateAmigoBD(objeto);
        return true;
    }

    public Amigo carregaAmigo(int id) {
        return dao.carregaAmigo(id);
    }

    public int maiorID() throws SQLException {
        return dao.maiorID();
    }   
}


