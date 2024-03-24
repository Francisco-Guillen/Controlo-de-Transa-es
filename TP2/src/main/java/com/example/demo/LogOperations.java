package com.example.demo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LogOperations")
public class LogOperations {

	private int NumReg;
	private char EventType;
	
	//Log
	private String Objeto;
	private String Valor;
	private String Referencia;
	
	// -- Dados sobre o utilizador e posto de trabalho
	private String UserID;
	private String TerminalD;
	private String TerminalName;
	
	// -- Quando ocorreu a operação
	private Date DCriacao;

	 @Id
	public int getNumReg() {
		return NumReg;
	}

	public void setNumReg(int numReg) {
		NumReg = numReg;
	}

	public char getEventType() {
		return EventType;
	}

	public void setEventType(char eventType) {
		EventType = eventType;
	}

	public String getObjeto() {
		return Objeto;
	}

	public void setObjeto(String objeto) {
		Objeto = objeto;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getReferencia() {
		return Referencia;
	}

	public void setReferencia(String referencia) {
		Referencia = referencia;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getTerminalD() {
		return TerminalD;
	}

	public void setTerminalD(String terminalD) {
		TerminalD = terminalD;
	}

	public String getTerminalName() {
		return TerminalName;
	}

	public void setTerminalName(String terminalName) {
		TerminalName = terminalName;
	}

	public Date getDCriacao() {
		return DCriacao;
	}

	public void setDCriacao(Date dCriacao) {
		DCriacao = dCriacao;
	}

	@Override
	public String toString() {
		return "LogOperations [NumReg=" + NumReg + ", EventType=" + EventType + ", Objeto=" + Objeto + ", Valor="
				+ Valor + ", Referencia=" + Referencia + ", UserID=" + UserID + ", TerminalD=" + TerminalD
				+ ", TerminalName=" + TerminalName + ", DCriacao=" + DCriacao + "]";
	}
}
