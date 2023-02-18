package com.stefanini.usuario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.usuario.model.UsuarioModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioTodosDadosDTO {
    private Long idUsuario;

    @NotEmpty(message = "Nome não pode ser nulo")
    @Size(max = 50)
    private String nomeUsuario;

    @NotEmpty(message = "Login não pode ser nulo")
    @Size(min = 5, max = 20)
    private String loginUsuario;

    @NotEmpty(message = "Email não pode ser nulo")
    @Size(max = 50)
    @Email
    private String emailUsuario;

    @NotEmpty(message = "Senha não pode ser nula")
    @Size(min = 4, max = 10, message = "Senha não pode ser menor que 4 ou maior que 10")
    private String senhaUsuario;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimentoUsuario;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCriacaoUsuario;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataAtualizacaoUsuario;

    public UsuarioTodosDadosDTO() {
    }

    public UsuarioTodosDadosDTO(UsuarioModel usuarioModel) {
        this.idUsuario = usuarioModel.getIdUsuario();
        this.nomeUsuario = usuarioModel.getNomeUsuario();
        this.loginUsuario = usuarioModel.getLoginUsuario();
        this.emailUsuario = usuarioModel.getEmailUsuario();
        this.senhaUsuario = usuarioModel.getSenhaUsuario();
        this.dataNascimentoUsuario = usuarioModel.getDataNascimentoUsuario();
        this.dataCriacaoUsuario = usuarioModel.getDataCriancaoUsuario();
        this.dataAtualizacaoUsuario = usuarioModel.getDataAtualizacaoUsuario();
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public LocalDate getDataNascimentoUsuario() {
        return dataNascimentoUsuario;
    }

    public void setDataNascimentoUsuario(LocalDate dataNascimentoUsuario) {
        this.dataNascimentoUsuario = dataNascimentoUsuario;
    }

    public LocalDateTime getDataCriacaoUsuario() {
        return dataCriacaoUsuario;
    }

    public void setDataCriacaoUsuario(LocalDateTime dataCriacaoUsuario) {
        this.dataCriacaoUsuario = dataCriacaoUsuario;
    }

    public LocalDateTime getDataAtualizacaoUsuario() {
        return dataAtualizacaoUsuario;
    }

    public void setDataAtualizacaoUsuario(LocalDateTime dataAtualizacaoUsuario) {
        this.dataAtualizacaoUsuario = dataAtualizacaoUsuario;
    }
}
