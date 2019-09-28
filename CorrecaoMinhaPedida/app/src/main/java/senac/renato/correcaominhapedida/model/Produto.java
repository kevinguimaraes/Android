package senac.renato.correcaominhapedida.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class Produto implements Serializable {
    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField(canBeNull = false)
    private String nome;

    @DatabaseField(canBeNull = false)
    private Double valor;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Categoria categoria;

    public Produto() {
    }

    public Produto(Integer id, String nome, Double valor, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Produto(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setValor(String valor) {
        try {
            this.valor = Double.parseDouble(valor);
        } catch (Exception e){
            this.valor = null;
        }
    }


    @Override
    public String toString() {
        return nome;
    }
}
