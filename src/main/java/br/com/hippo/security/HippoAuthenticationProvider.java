package br.com.hippo.security;

import br.com.hippo.entities.AutenticacaoCliente;
import br.com.hippo.entities.Cliente;
import br.com.hippo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HippoAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private ClienteRepository repository;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Cliente cliente = repository.findByEmailCliente(authentication.getName());
        AutenticacaoCliente autenticacao = new AutenticacaoCliente(cliente);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(autenticacao, authentication.getCredentials(), new ArrayList<>());
        return token;
    }

    public boolean supports(Class<?> arg0) {
        return true;
    }

}