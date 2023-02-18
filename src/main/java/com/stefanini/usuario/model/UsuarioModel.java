package com.stefanini.usuario.model;

import com.stefanini.usuario.dto.AtualizarUsuarioDTO;
import com.stefanini.usuario.dto.PersistirUsuarioDTO;
import com.stefanini.usuario.dto.UsuarioTodosDadosDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Column(name = "login_usuario", unique = true)
    private String loginUsuario;

    @Column(name = "email_usuario", unique = true)
    private String emailUsuario;

    @Column(name = "senha_usuario")
    private String senhaUsuario;

    @Column(name = "data_nascimento_usuario")
    private LocalDate dataNascimentoUsuario;

    @Column(name = "data_criacao_usuario", updatable = false)
    private LocalDateTime dataCriancaoUsuario;

    @Column(name = "data_atualizacao_usuario")
    private LocalDateTime dataAtualizacaoUsuario;

    public UsuarioModel() {
    }

    public UsuarioModel(UsuarioTodosDadosDTO usuarioTodosDadosDTO) {
        this.idUsuario = usuarioTodosDadosDTO.getIdUsuario();
        this.nomeUsuario = usuarioTodosDadosDTO.getNomeUsuario();
        this.loginUsuario = usuarioTodosDadosDTO.getLoginUsuario();
        this.emailUsuario = usuarioTodosDadosDTO.getEmailUsuario();
        this.senhaUsuario = usuarioTodosDadosDTO.getSenhaUsuario();
        this.dataNascimentoUsuario = usuarioTodosDadosDTO.getDataNascimentoUsuario();
        this.dataCriancaoUsuario = usuarioTodosDadosDTO.getDataCriacaoUsuario();
        this.dataAtualizacaoUsuario = usuarioTodosDadosDTO.getDataAtualizacaoUsuario();
    }

    public UsuarioModel(PersistirUsuarioDTO persistirUsuarioDTO) {
        this.nomeUsuario = persistirUsuarioDTO.getNomeUsuario();
        this.loginUsuario = persistirUsuarioDTO.getLoginUsuario();
        this.emailUsuario = persistirUsuarioDTO.getEmailUsuario();
        this.senhaUsuario = persistirUsuarioDTO.getSenhaUsuario();
        this.dataNascimentoUsuario = persistirUsuarioDTO.getDataNascimentoUsuario();
    }

    public UsuarioModel(AtualizarUsuarioDTO atualizarUsuarioDTO) {
        this.idUsuario = atualizarUsuarioDTO.getIdUsuario();
        this.nomeUsuario = atualizarUsuarioDTO.getNomeUsuario();
        this.loginUsuario = atualizarUsuarioDTO.getLoginUsuario();
        this.emailUsuario = atualizarUsuarioDTO.getEmailUsuario();
        this.senhaUsuario = atualizarUsuarioDTO.getSenhaUsuario();
        this.dataNascimentoUsuario = atualizarUsuarioDTO.getDataNascimentoUsuario();
        this.dataCriancaoUsuario = atualizarUsuarioDTO.getDataCriacaoUsuario();
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

    public LocalDateTime getDataCriancaoUsuario() {
        return dataCriancaoUsuario;
    }

    public void setDataCriancaoUsuario(LocalDateTime dataCriancaoUsuario) {
        this.dataCriancaoUsuario = dataCriancaoUsuario;
    }

    public LocalDateTime getDataAtualizacaoUsuario() {
        return dataAtualizacaoUsuario;
    }

    public void setDataAtualizacaoUsuario(LocalDateTime dataAtualizacaoUsuario) {
        this.dataAtualizacaoUsuario = dataAtualizacaoUsuario;
    }
}
