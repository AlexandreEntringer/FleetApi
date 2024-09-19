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
import java.util.Objects;

/**
 *
 * @author alexandre.entringer
 */
@Entity
@Table(name = "agendamentos", schema = "fleet")
public class Agendamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios usuario;
    @JoinColumn(name = "id_motivo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Motivos motivo;
    @JoinColumn(name = "id_rotas", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rotas rota;
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Veiculos veiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Motivos getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivos motivo) {
        this.motivo = motivo;
    }

    public Rotas getRota() {
        return rota;
    }

    public void setRota(Rotas rota) {
        this.rota = rota;
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }

    public Agendamentos() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Agendamentos other = (Agendamentos) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Agendamentos{" + "id=" + id + ", usuario=" + usuario + ", motivo=" + motivo + ", rota=" + rota + ", veiculo=" + veiculo + '}';
    }
}
