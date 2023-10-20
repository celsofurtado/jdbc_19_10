package br.com.fiap.live19.model;

import java.time.LocalDate;

public class Game {

	private int codigo;
	private String titulo;
	private LocalDate dataLancamento;
	private boolean finalizado;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	@Override
	public String toString() {
		return "Game [codigo=" + codigo + ", titulo=" + titulo + ", dataLancamento=" + dataLancamento + ", finalizado="
				+ finalizado + "]";
	}
	
	

}
