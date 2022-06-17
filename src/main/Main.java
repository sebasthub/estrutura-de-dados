package main;

import arvore.ArvoreBinaria;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		arvore.insereValor(arvore.getRaiz(), "logado com sucesso",true,1);
		arvore.insereValor(arvore.getRaiz(), "não é possivel fazer o login",false,1);
		arvore.insereValor(arvore.getRaiz(), "conectado ao bd",true,2);
		arvore.insereValor(arvore.getRaiz(), "erro de conexão com o bd",false,2);
		arvore.insereValor(arvore.getRaiz(), "finalizado com sucesso",true,3);
		arvore.insereValor(arvore.getRaiz(), "não é possivel finalizar agora",false,3);
		arvore.insereValor(arvore.getRaiz(), "acesso autorizado",true,4);
		arvore.insereValor(arvore.getRaiz(), "acesso não autorizado",false,4);
		inicializacao(arvore, true, false, true, false);
		//arvore.buscaCodigo(arvore.getRaiz(), 1, true);
		//arvore.imprimeArvore(arvore.getRaiz());
		//System.out.println(arvore.removeNo("não é possivel fazer o login", arvore.getRaiz()).getValor() + " removido");
		//arvore.imprimeArvore(arvore.getRaiz());
	}
	
	public static void inicializacao(ArvoreBinaria a,boolean cod1,boolean cod2,boolean cod3,boolean cod4) {
		a.buscaCodigo(a.getRaiz(), 1, cod1);
		a.buscaCodigo(a.getRaiz(), 2, cod2);
		a.buscaCodigo(a.getRaiz(), 3, cod3);
		a.buscaCodigo(a.getRaiz(), 4, cod4);
	}

}
