package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Encomenda")
public class Encomenda {
	
	private int EncId;
	private int ClienteId;
	private String Nome;
	private String Morada;
	
    public Encomenda() {

   }
    	
    @Id
	public int getEncId() {
		return EncId;
	}
	
	public void setEncId(int EncId) {
		this.EncId = EncId;
	}
	
	@OneToMany
	private List<EncLinha> encomenda;
	
	public int getClienteId() {
		return ClienteId;
	}
	
	public void setClienteId(int clienteId) {
		this.ClienteId = clienteId;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		this.Nome = nome;
	}
	
	public String getMorada() {
		return Morada;
	}
	
	public void setMorada(String morada) {
		this.Morada = morada;
	}

	
	public List<EncLinha> getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(List<EncLinha> encomenda) {
		this.encomenda = encomenda;
	}

	@Override
	public String toString() {
		return "Encomenda [EncId=" + EncId + ", ClienteId=" + ClienteId + ", Nome=" + Nome + ", Morada=" + Morada + "]";
	}
	
}
