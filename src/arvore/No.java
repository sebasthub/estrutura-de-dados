package arvore;

public class No 
{
	private String valor;
	private int cod;
	private boolean lado;
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


	No(String valor, boolean lado, int cod)
	{
		this.lado = lado;
		this.cod = cod;
		this.valor = valor;
	}
	

	public String getValor() {
		return valor;
	}

	

	public void setValor(String valor) {
		this.valor = valor;
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
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public boolean isLado() {
		return lado;
	}

	public void setLado(boolean lado) {
		this.lado = lado;
	}

	public void finalize()
	{
		System.out.println("LIBERADO");
	}
}
