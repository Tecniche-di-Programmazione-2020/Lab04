package it.polito.tdp.lab04.model;

public class Corso {
	String codins;
	String nome;
	Integer pd;
	Integer crediti;
	
	public Corso(String codins, String nome, int crediti, int pd) {
		this.codins = codins;
		this.nome = nome;
		this.crediti = crediti;
		this.pd = pd;
	}
	public String getCodins() {
		return codins;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPd() {
		return pd;
	}
	public void setPd(Integer pd) {
		this.pd = pd;
	}
	public Integer getCrediti() {
		return crediti;
	}
	public void setCrediti(Integer crediti) {
		this.crediti = crediti;
	}
	@Override
	public String toString() {
		
		return nome;
	}
	

}
