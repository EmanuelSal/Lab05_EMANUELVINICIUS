package com.matheusgr.similaridade;

import com.matheusgr.lunr.documento.Documento;

public class AnaliseDeSimilaridade {
	
	private int intersecao;
	private int uniao;
	private int similaridade;
	
	public AnaliseDeSimilaridade() {
		this.intersecao = 0;
		this.uniao = 0;
		this.similaridade = (intersecao / uniao) * 100;
	}
	
	public int similaridade(Documento[] d, Documento[] dc) {
		if (d.length > dc.length) {this.intersecao = d.length - dc.length;} 
		else {this.intersecao = d.length + dc.length;}
		this.uniao = d.length + dc.length;
		return similaridade;
		
		
	}

}
