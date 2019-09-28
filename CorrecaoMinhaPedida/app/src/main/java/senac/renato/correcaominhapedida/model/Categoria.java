package senac.renato.correcaominhapedida.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;

@DatabaseTable
public class Categoria implements Serializable {
    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField(canBeNull = false)
    private String nome;

    @ForeignCollectionField(eager = true)
    private Collection<Produto> colecaoProdutos;


    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setColecaoProdutos(Collection<Produto> colecaoProdutos) {
        this.colecaoProdutos = colecaoProdutos;
    }

    public Collection<Produto> getColecaoProdutos() {
        return colecaoProdutos;
    }

    @Override
    public String toString() {
        return nome + "(" + colecaoProdutos.size() + ")";
    }
}
