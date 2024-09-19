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
@Table(name = "historico", schema = "fleet")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_agendamento", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Agendamentos agendamentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Agendamentos getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Agendamentos agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Historico() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Historico other = (Historico) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Historico{" + "id=" + id + ", agendamentos=" + agendamentos + '}';
    }
}
