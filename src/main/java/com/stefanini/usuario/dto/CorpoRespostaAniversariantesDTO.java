package com.stefanini.usuario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.usuario.model.UsuarioModel;

import java.time.LocalDate;

public class CorpoRespostaAniversariantesDTO {

    private String nomeUsuario;

    private String loginUsuario;

    private String emailUsuario;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimentoUsuario;

    public CorpoRespostaAniversariantesDTO() {
    }

    public CorpoRespostaAniversariantesDTO(UsuarioModel usuarioModel) {
        this.nomeUsuario = usuarioModel.getNomeUsuario();
        this.loginUsuario = usuarioModel.getLoginUsuario();
        this.emailUsuario = usuarioModel.getEmailUsuario();
        this.dataNascimentoUsuario = usuarioModel.getDataNascimentoUsuario();
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

    public LocalDate getDataNascimentoUsuario() {
        return dataNascimentoUsuario;
    }

    public void setDataNascimentoUsuario(LocalDate dataNascimentoUsuario) {
        this.dataNascimentoUsuario = dataNascimentoUsuario;
    }
}
