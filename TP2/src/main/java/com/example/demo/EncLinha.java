package com.example.demo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="EncLinha")
public class EncLinha implements Serializable {

    @EmbeddedId
    private EncLinhaId encLinhaid;
    
    //@Column(name = "EncId", nullable = false)
    //@Column(name="EncId", insertable=false, updatable=false)
    //@JoinColumn(name = "EncId")
   
  @Column(name="EncId", insertable=false, updatable=false)
	private int EncId;
    
    //@Column(name = "ProdutoId", nullable = false)
    //@Column(insertable=false, updatable=false)
    
    //@Column(name = "ProdutoId", insertable=false, updatable=false)
    //@JoinColumn(name = "ProdutoId")
  
  @Column(name = "ProdutoId", insertable=false, updatable=false)
	private int ProdutoId;
	private String Designacao;
	private double Preco;  
	private double Qtd;  
		
	@ManyToOne
	private Encomenda encomenda;
	
	public EncLinha() {
		
	}
	/*
	public EncLinha(int EncId) {
		this.EncId = EncId;
	}
	*/
	public EncLinha(int EncId, int ProdutoId) {
		this.encLinhaid = new EncLinhaId(EncId, ProdutoId);
		this.EncId = EncId;
		this.ProdutoId = ProdutoId;
	}
	
	
	public int getEncId() {
		return EncId;
	}

	public void setEncId(int EncId) {
		this.EncId = EncId;
	}

	public int getProdutoId() {
		return ProdutoId;
	}

	public void setProdutoId(int ProdutoId) {
		this.ProdutoId = ProdutoId;
	}
	

	public Encomenda getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}

	public void setList(Encomenda encomenda) {
		this.encomenda = encomenda;
	}
	
	public String getDesignacao() {
		return Designacao;
	}

	public void setDesignacao(String Designacao) {
		this.Designacao = Designacao;
	}

	public double getPreco() {
		return Preco;
	}

	public void setPreco(double Preco) {
		this.Preco = Preco;
	}

	public double getQtd() {
		return Qtd;
	}

	public void setQtd(double qtd) {
		this.Qtd = qtd;
	}

	
	public EncLinhaId getEncLinhaId() {
		return encLinhaid;
	}

	public void setEncLinhaId(EncLinhaId encLinhaid) {
		this.encLinhaid = encLinhaid;
	}
	
	@Override
	public String toString() {
		return "EncLinha [EncId=" + EncId + ", ProdutoId=" + ProdutoId + ", Designacao=" + Designacao + ", Preco="
				+ Preco + ", Qtd=" + Qtd + "]";
	}
	
}
