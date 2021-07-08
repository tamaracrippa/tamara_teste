package br.com.desafio.corridasCompartilhadas.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.desafio.corridasCompartilhadas.model.Motorista;

@RepositoryRestResource(collectionResourceRel = "motorista", path = "motoristas")
public interface MotoristaRepository extends PagingAndSortingRepository<Motorista, String> {
    
    List<Motorista> findAll();
    
    long deleteByCpf(String cpf);
    
}
