/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Adolpho Cavalcanti
 */
@Entity
@Table(name = "lanchonete", catalog = "Klassic", schema = "")
@NamedQueries({
    @NamedQuery(name = "Lanchonete.findAll", query = "SELECT l FROM Lanchonete l")
    , @NamedQuery(name = "Lanchonete.findById", query = "SELECT l FROM Lanchonete l WHERE l.id = :id")
    , @NamedQuery(name = "Lanchonete.findByNome", query = "SELECT l FROM Lanchonete l WHERE l.nome = :nome")
    , @NamedQuery(name = "Lanchonete.findByTelefone", query = "SELECT l FROM Lanchonete l WHERE l.telefone = :telefone")
    , @NamedQuery(name = "Lanchonete.findByCidadecodigo", query = "SELECT l FROM Lanchonete l WHERE l.cidadecodigo = :cidadecodigo")})
public class Lanchonete implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "Cidade_codigo")
    private int cidadecodigo;

    public Lanchonete() {
    }

    public Lanchonete(Integer id) {
        this.id = id;
    }

    public Lanchonete(Integer id, String nome, String telefone, int cidadecodigo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cidadecodigo = cidadecodigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public int getCidadecodigo() {
        return cidadecodigo;
    }

    public void setCidadecodigo(int cidadecodigo) {
        int oldCidadecodigo = this.cidadecodigo;
        this.cidadecodigo = cidadecodigo;
        changeSupport.firePropertyChange("cidadecodigo", oldCidadecodigo, cidadecodigo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lanchonete)) {
            return false;
        }
        Lanchonete other = (Lanchonete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Lanchonete[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
