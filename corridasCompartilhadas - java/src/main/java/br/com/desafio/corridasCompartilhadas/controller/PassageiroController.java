package br.com.desafio.corridasCompartilhadas.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.corridasCompartilhadas.model.Passageiro;
import br.com.desafio.corridasCompartilhadas.repository.PassageiroRepository;

@RestController
public class PassageiroController {
    
    @Autowired
    private PassageiroRepository passageiroRepository;
    
    private static Logger LOGGER = Logger.getLogger(PassageiroController.class);

    @RequestMapping(value = "/passageiro/search", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Passageiro>> getPassageiros() {
        try {
            List<Passageiro> listPassageiro = passageiroRepository.findAll();
            if (listPassageiro.size() > 0) {
                return new ResponseEntity<List<Passageiro>>(listPassageiro,HttpStatus.OK);
            }
            return new ResponseEntity<List<Passageiro>>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            LOGGER.error("Erro ao tentar consultar Passageiros base", e);
            return new ResponseEntity<List<Passageiro>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/passageiro/save", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String[]> savePassageiro(@RequestBody Passageiro passageiro) {   
       try {
           passageiroRepository.save(passageiro);
           return new ResponseEntity<String[]>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Erro ao tentar inserir Passageiro", e);
            return new ResponseEntity<String[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @Transactional
    @RequestMapping(value = "/passageiro/delete", method = RequestMethod.DELETE, produces = "application/text")
    public ResponseEntity<List<Passageiro>> deletePassageiro(@RequestBody String cpf) {   
       try {
           passageiroRepository.deleteByCpf(cpf);
           return new ResponseEntity<List<Passageiro>>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Erro ao tentar deletar Passageiro", e);
            return new ResponseEntity<List<Passageiro>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
}
