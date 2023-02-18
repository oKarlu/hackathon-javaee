package com.stefanini.usuario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.usuario.model.UsuarioModel;
import net.bytebuddy.utility.nullability.AlwaysNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AtualizarUsuarioDTO {
    private Long idUsuario;

    @NotBlank(message = "Preencha o nome")
    @Size(max = 50)
    private String nomeUsuario;

    @NotBlank(message = "Preencha o login")
    @Size(min = 5, max = 20)
    private String loginUsuario;

    @NotBlank(message = "Preencha o email")
    @Size(max = 50)
    @Email
    private String emailUsuario;

    @NotBlank(message = "Preencha a senha")
    @Size(min = 4, max = 10, message = "Senha não pode ser menor que 4 ou maior que 10")
    private String senhaUsuario;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimentoUsuario;

    @AlwaysNull
    private LocalDateTime dataCriacaoUsuario;

    public AtualizarUsuarioDTO() {
    }

    public AtualizarUsuarioDTO(UsuarioModel usuarioModel) {
        this.idUsuario = usuarioModel.getIdUsuario();
        this.nomeUsuario = usuarioModel.getNomeUsuario();
        this.loginUsuario = usuarioModel.getLoginUsuario();
        this.emailUsuario = usuarioModel.getEmailUsuario();
        this.senhaUsuario = usuarioModel.getSenhaUsuario();
        this.dataNascimentoUsuario = usuarioModel.getDataNascimentoUsuario();
        this.dataCriacaoUsuario = usuarioModel.getDataCriancaoUsuario();
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

}
