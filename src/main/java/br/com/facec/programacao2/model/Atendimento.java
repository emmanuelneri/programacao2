package br.com.facec.programacao2.model;

import br.com.facec.programacao2.others.Validavel;

import java.time.LocalDateTime;

import static br.com.facec.programacao2.exceptions.ValidacaoUtil.validarCampoObrigatorio;
import static br.com.facec.programacao2.exceptions.ValidacaoUtil.validarEntidadeExistente;

public class Atendimento extends Entidade implements Validavel {

    private Cliente cliente;
    private Funcionario funcionario;
    private String descricaoProblema;
    private LocalDateTime dataHora = LocalDateTime.now();
    private StatusAtendimento status = StatusAtendimento.ABERTO;

    @Override
    public void validar() {
        validarCampoObrigatorio(descricaoProblema, "Descrição do problema é obrigatória.");
        validarCampoObrigatorio(funcionario, "Funcionário é obrigatório.");
        validarCampoObrigatorio(cliente, "Cliente é obrigatório.");
        validarEntidadeExistente(funcionario, "Funcionário não existe no sistema!");
        validarEntidadeExistente(cliente, "Cliente não existe no sistema!");
    }

    public void encerrar() {
        this.status = StatusAtendimento.ENCERRADO;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusAtendimento getStatus() {
        return status;
    }

    public void setStatus(StatusAtendimento status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "id=" + getId() +
                ", cliente=" + cliente +
                ", funcionario=" + funcionario +
                ", descricaoProblema='" + descricaoProblema + '\'' +
                ", dataHora=" + dataHora +
                ", status=" + status +
                '}';
    }
}
