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
@Table(name = "reparo", catalog = "Klassic", schema = "")
@NamedQueries({
    @NamedQuery(name = "Reparo.findAll", query = "SELECT r FROM Reparo r")
    , @NamedQuery(name = "Reparo.findById", query = "SELECT r FROM Reparo r WHERE r.id = :id")
    , @NamedQuery(name = "Reparo.findByNomePeca", query = "SELECT r FROM Reparo r WHERE r.nomePeca = :nomePeca")
    , @NamedQuery(name = "Reparo.findByDescricao", query = "SELECT r FROM Reparo r WHERE r.descricao = :descricao")
    , @NamedQuery(name = "Reparo.findByPreco", query = "SELECT r FROM Reparo r WHERE r.preco = :preco")
    , @NamedQuery(name = "Reparo.findByOficinaid", query = "SELECT r FROM Reparo r WHERE r.oficinaid = :oficinaid")})
public class Reparo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome_peca")
    private String nomePeca;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "preco")
    private String preco;
    @Basic(optional = false)
    @Column(name = "Oficina_id")
    private int oficinaid;

    public Reparo() {
    }

    public Reparo(Integer id) {
        this.id = id;
    }

    public Reparo(Integer id, String nomePeca, String descricao, String preco, int oficinaid) {
        this.id = id;
        this.nomePeca = nomePeca;
        this.descricao = descricao;
        this.preco = preco;
        this.oficinaid = oficinaid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        String oldNomePeca = this.nomePeca;
        this.nomePeca = nomePeca;
        changeSupport.firePropertyChange("nomePeca", oldNomePeca, nomePeca);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        String oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    public int getOficinaid() {
        return oficinaid;
    }

    public void setOficinaid(int oficinaid) {
        int oldOficinaid = this.oficinaid;
        this.oficinaid = oficinaid;
        changeSupport.firePropertyChange("oficinaid", oldOficinaid, oficinaid);
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
        if (!(object instanceof Reparo)) {
            return false;
        }
        Reparo other = (Reparo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Reparo[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
