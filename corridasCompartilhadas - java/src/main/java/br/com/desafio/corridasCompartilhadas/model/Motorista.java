package br.com.desafio.corridasCompartilhadas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Motorista")
public class Motorista {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
      private Long id;

      private String nome;

      private int dataNascimento;
      
      @Column(unique=true)
      private String cpf;
      
      private String modeloCarro;
      
      private String status;
      
      private String sexo;

      

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getNome() {
            return nome;
      }

      public void setNome(String nome) {
            this.nome = nome;
      }


      public String getCpf() {
            return cpf;
      }

      public void setCpf(String cpf) {
            this.cpf = cpf;
      }


    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
