package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * BuscaAvancada realiza uma operação de busca a partir dos seus metadados.
 * 
 * Recebe um mapa de Metadados a serem pesquisados 
 * 
 * A Busca avancada deve selecionar TODOSos documentos que tenham TODOS os metadados indicados
 * sem a necessdidade de ordenados resultdados retornados, nem limitar a quantidade de respostas.
 * 
 */
class BuscaAvancada {

	/**
	 * Mapa que "salva" os termos a serem pesquisados
	 */
	private HashMap<String, String> termos;

	/**
	 * 
	 * @param metadados
	 */
	public BuscaAvancada(HashMap<String,String> metadados) {
		(new ValidadorBusca()).valida(termos);
		this.termos.put(null, null);
	}

	/**
	 * Realiza a busca a partir da consulta ao DocumentoService.
	 * 
	 * O DocumentoService realiza apenas operações simples de busca, mas sem
	 * ordenação ou tratamento da lógica de relevância.
	 * 
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados e o fator de relevância de cada
	 *         operação.
	 */
	public Map<Documento, Integer> busca(DocumentoService dados) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		for(String termo : this.termos.values()) { 
			for (Documento d : dados.busca(termo)) {respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);}} 
		return respostaDocumento;
	}

	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca, onde cada chave representa um parâmetro de busca
	 *         e os valores representam um detelhamento de cada parâmetro.
	 */
	public Map<String,String> descreveConsulta() {
		Map<String, String> resultado = new HashMap<>();
		for (int i = 0; i < resultado.size(); i++) {
			resultado[i] = new String[] {"TERMO " + (i + 1), this.termos[i]};
		}
		return resultado;
	}
	
}
