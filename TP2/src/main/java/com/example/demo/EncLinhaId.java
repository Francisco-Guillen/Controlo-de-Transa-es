package com.example.demo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;


@Embeddable
public class EncLinhaId implements Serializable {

	private int EncId;
	private int ProdutoId;

	public EncLinhaId() {
		
	}
	
	public EncLinhaId(int EncId) {
		this.EncId = EncId;
	}
	

    public EncLinhaId(int EncId, int ProdutoId) {
        this.EncId = EncId;
        this.ProdutoId = ProdutoId;
        
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(EncId, ProdutoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EncLinhaId other = (EncLinhaId) obj;
		return EncId == other.EncId && ProdutoId == other.ProdutoId;
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


}
