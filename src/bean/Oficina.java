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
@Table(name = "oficina", catalog = "Klassic", schema = "")
@NamedQueries({
    @NamedQuery(name = "Oficina.findAll", query = "SELECT o FROM Oficina o")
    , @NamedQuery(name = "Oficina.findById", query = "SELECT o FROM Oficina o WHERE o.id = :id")
    , @NamedQuery(name = "Oficina.findByNome", query = "SELECT o FROM Oficina o WHERE o.nome = :nome")
    , @NamedQuery(name = "Oficina.findByTelefone", query = "SELECT o FROM Oficina o WHERE o.telefone = :telefone")
    , @NamedQuery(name = "Oficina.findByCidadecodigo", query = "SELECT o FROM Oficina o WHERE o.cidadecodigo = :cidadecodigo")})
public class Oficina implements Serializable {

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

    public Oficina() {
    }

    public Oficina(Integer id) {
        this.id = id;
    }

    public Oficina(Integer id, String nome, String telefone, int cidadecodigo) {
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
        if (!(object instanceof Oficina)) {
            return false;
        }
        Oficina other = (Oficina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Oficina[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
