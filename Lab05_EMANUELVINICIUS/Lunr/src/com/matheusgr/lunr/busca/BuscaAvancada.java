package com.matheusgr.lunr.busca;



import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

public class BuscaAvancada {
	
	private HashMap <String, String> termos;
	
	public BuscaAvancada(HashMap<String, String> termos) {
		(new ValidadorBusca()).valida(termos);
		this.termos.put(null, null);
	}
	
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		for (String termo : this.termos.keySet()) {
			if (termo.isBlank()) {
				continue;
			}
			for (Documento d : ds.busca(termo)) {
				respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
			}
		}
		return respostaDocumento;
	}
}