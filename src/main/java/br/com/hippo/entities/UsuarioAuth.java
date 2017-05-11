package br.com.hippo.entities;

public class UsuarioAuth {

    private String loginUsuario;
    private String senhaUsuario;

    public UsuarioAuth(String loginUsuario, String senhaUsuario) {
        this.loginUsuario = loginUsuario ;
        this.senhaUsuario = senhaUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }
}
