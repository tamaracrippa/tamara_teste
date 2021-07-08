package br.com.desafio.corridasCompartilhadas.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.desafio.corridasCompartilhadas.model.Passageiro;

@RepositoryRestResource(collectionResourceRel = "passageiro", path = "passageiros")
public interface PassageiroRepository extends PagingAndSortingRepository<Passageiro, String> {
    
    List<Passageiro> findAll();
    
    long deleteByCpf(String cpf);
}
