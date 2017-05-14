package br.com.hippo.entities;

public class UsuarioAuth {

    private int idUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private String nomeUsuario;
    private String tipoPerfil;
    private int usuarioAtivo;

    public UsuarioAuth(String loginUsuario, String senhaUsuario) {
        this.loginUsuario = loginUsuario ;
        this.senhaUsuario = senhaUsuario;
    }

    public int getIdUsuario() { return idUsuario; }

    public String getNomeUsuario() { return nomeUsuario; }

    public String getTipoPerfil() { return tipoPerfil; }

    public int getUsuarioAtivo() { return usuarioAtivo; }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }
}
