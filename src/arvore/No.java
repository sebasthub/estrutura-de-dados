package arvore;

import main.TimeLine;

public class No 
{
	private TimeLine valor;
	private No esquerdo;
	private No direito;
	private int nivel;
	
	public int getNivel() {
		return nivel;
	}
	
	public boolean noFolha()
	{
		return (direito == null && esquerdo == null);
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	No(int valor)
	{
		this.valor = valor;
	}
	

	public int getValor() {
		return valor;
	}



	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}
	
	public void finalize()
	{
		System.out.println("LIBERADO");
	}
}
