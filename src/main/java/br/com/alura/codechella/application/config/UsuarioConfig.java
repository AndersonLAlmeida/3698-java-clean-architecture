package br.com.alura.codechella.application.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.AlteraUsuario;
import br.com.alura.codechella.application.usecases.CriaUsuario;
import br.com.alura.codechella.application.usecases.ListaUsuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public CriaUsuario criaUsuario(RepositorioDeUsuario  repositorioDeUsuario) {
        return new CriaUsuario(repositorioDeUsuario);
    }

    @Bean
    public AlteraUsuario alteraUsuario(RepositorioDeUsuario  repositorioDeUsuario) {
        return new AlteraUsuario(repositorioDeUsuario);
    }

    @Bean
    public ListaUsuario listaUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new ListaUsuario(repositorioDeUsuario);
    }

    @Bean
    public RepositorioDeUsuarioJpa criarRepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityMapper entityMapper) {
        return new RepositorioDeUsuarioJpa(repositorio, entityMapper);
    }

    @Bean
    public UsuarioEntityMapper criarUsuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }


}
