package br.com.hippo.entities;

public class Usuario {

        private int idUsuario;
        private String loginUsuario;
        private String senhaUsuario;
        private String nomeUsuario;
        private String tipoPerfil;
        private int usuarioAtivo;

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = "C";
    }

    public int getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void setUsuarioAtivo(int usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }
}