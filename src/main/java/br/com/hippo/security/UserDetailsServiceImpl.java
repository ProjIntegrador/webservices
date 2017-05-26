package br.com.hippo.security;

import br.com.hippo.entities.AutenticacaoCliente;
import br.com.hippo.entities.Cliente;
import br.com.hippo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailCliente) throws UsernameNotFoundException {
        Cliente cliente = userRepository.findByEmailCliente(emailCliente);
        return new AutenticacaoCliente(cliente);
    }
}
