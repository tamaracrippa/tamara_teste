import { Component, OnInit } from '@angular/core';
import {HttpClientModule } from '@angular/common/http';
import {MatMenuModule} from '@angular/material/menu';


@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.scss']
  
})
export class ClientesComponent implements OnInit {

  constructor() { }

  public clientes = [
    {nome: "", nascimento: "", cpf: "", carro: "", sexo:"", status:""},
    {nome: "", nascimento: "", cpf: "", carro: "", sexo:"", status:""},
    {nome: "", nascimento: "", cpf: "", carro: "", sexo:"", status:""},
]

  ngOnInit(): void {
    
  }

}
