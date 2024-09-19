package com.api.fleet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author alexandre.entringer
 */
@Entity
@Table(name = "perfil_acesso", schema = "fleet")
public class PerfilAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_modulo",referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modulos modulo;
    @JoinColumn(name = "id_usuario",referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios usuario;
    @Column(name = "data_registro")
    private Date dataRegistro;
    @Column(name = "data_inativacao")
    private Date dataInativacao;
    @Column(name = "status")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modulos getModulo() {
        return modulo;
    }

    public void setModulo(Modulos modulo) {
        this.modulo = modulo;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Date getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public PerfilAcesso() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PerfilAcesso other = (PerfilAcesso) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "PerfilAcesso{" + "id=" + id + ", modulo=" + modulo + ", usuario=" + usuario + ", dataRegistro=" + dataRegistro + ", dataInativacao=" + dataInativacao + ", status=" + status + '}';
    }
}
