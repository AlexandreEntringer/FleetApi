package com.api.fleet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Basic;
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
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alexandre.entringer
 */
@Entity
@Table(name = "agendamentos", schema = "fleet")
@Data
@NoArgsConstructor
public class Agendamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuarios usuario;
    @JoinColumn(name = "id_motivo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Motivos motivo;
    @JoinColumn(name = "id_rotas", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Rotas rota;
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Veiculos veiculo;
    @Column(name = "status")
    @Basic(optional = false)
    private Integer status;
    @Column(name = "data_registro")
    @Basic(optional = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date dataRegistro;
    @Column(name = "data_inativacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date dataInativacao;
    @Column(name = "data_inicio")
    @Basic(optional = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date dataInicio;
    @Column(name = "data_fim")
    @Basic(optional = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date dataFim;
}
