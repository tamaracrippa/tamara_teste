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

import br.com.desafio.corridasCompartilhadas.model.Motorista;
import br.com.desafio.corridasCompartilhadas.repository.MotoristaRepository;

@RestController
public class MotoristaController {
    
    private static Logger LOGGER = Logger.getLogger(MotoristaController.class);
    
    @Autowired
    private MotoristaRepository motoristaRepository;
    
    
    @RequestMapping(value = "/motorista/search", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Motorista>> getMotoristas() {
        try {
            List<Motorista> listMotorista = motoristaRepository.findAll();
            if (listMotorista.size() > 0) {
                return new ResponseEntity<List<Motorista>>(listMotorista,HttpStatus.OK);
            }
            return new ResponseEntity<List<Motorista>>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            LOGGER.error("Erro ao tentar consultar base", e);
            return new ResponseEntity<List<Motorista>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
          
    }    
    
    @RequestMapping(value = "/motorista/save", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String[]> saveMotorista(@RequestBody Motorista motorista) {   
       try {
           System.out.println("motorista: " + motorista.getNome());
           motoristaRepository.save(motorista);
           return new ResponseEntity<String[]>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Erro ao tentar inserir Motorista", e);
            return new ResponseEntity<String[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @Transactional
    @RequestMapping(value = "/motorista/delete", method = RequestMethod.DELETE, produces = "application/text")
    public ResponseEntity<List<Motorista>> deleteMotorista(@RequestBody String cpf) {   
       try {
           System.out.println("CPF: " + cpf);
           motoristaRepository.deleteByCpf(cpf);
           return new ResponseEntity<List<Motorista>>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Erro ao tentar deletar Motorista", e);
            System.out.println("ERRO: " + e);
            return new ResponseEntity<List<Motorista>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
