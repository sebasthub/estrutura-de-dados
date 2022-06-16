package arvore;

public class ArvoreBinaria 
{
	No raiz = null;
	
	public No getRaiz()
	{
		return raiz;
	}
	
	public void liberaMemoria(No raiz)
	{
		if (raiz == null || raiz.noFolha())
		{
			return;
		}
		
		if (raiz.getDireito() != null)
		{
			liberaMemoria(raiz.getDireito());
			raiz.setDireito(null);
		}
		
		if (raiz.getEsquerdo() != null)
		{
			liberaMemoria(raiz.getEsquerdo());
			raiz.setEsquerdo(null);
		}
		
		this.raiz = null;
	}
	
	void calculaNivelNos(No raiz, int nivel)
	{
		//Verifica se existe a arvore
		if (raiz == null)
			return;
		
		raiz.setNivel(nivel);
		calculaNivelNos(raiz.getEsquerdo(), nivel+1);
		calculaNivelNos(raiz.getDireito(), nivel+1);
	}
	
	public void insereValor (No raiz, int valor)
	{	
		//Verifica se a árvore está vazia
		if (this.raiz == null)
		{
			this.raiz = new No(valor);
			return;
		}
		
		//Verifica para que lado da raiz vai andar
		if (valor > raiz.getValor())
		{
			//Se nao tiver lado direito, insere
			if (raiz.getDireito() == null)
			{
				raiz.setDireito(new No(valor));
				return;
			}
			
			//Insere recursivamente
			insereValor(raiz.getDireito(), valor);
		}
		else
		{	
			if (raiz.getEsquerdo() == null)
			{
				raiz.setEsquerdo(new No(valor));
				return;
			}
			
			insereValor(raiz.getEsquerdo(), valor);
		}
	}
	
	public No removeNo(int valor, No raiz) {
		if(raiz.noFolha()) {
			return null;
		}else if(valor == raiz.getValor()){
			
		}
	}
	
	public boolean buscaValor(int valor, No raiz) {
		if(raiz == null) {
			return false;
		}
		if(valor == raiz.getValor()) {
			return true;
		}
		if(buscaValor(valor, raiz.getDireito())) {
			return true;
		}else if(buscaValor(valor, raiz.getEsquerdo())){
			return true;
		}
		return false;
	}
	
	public No buscaNo(int valor, No raiz) {
		if(raiz == null) {
			return null;
		}
		if(valor == raiz.getValor()) {
			return raiz;
		}
		if(raiz.getDireito() != null && raiz.noFolha() != true) {
			return buscaNo(valor, raiz.getDireito());
		}else if(raiz.getEsquerdo() != null) {
			return buscaNo(valor, raiz.getEsquerdo());
		}
		return null;
	}
	
	public No buscaNoAnterior(int valor, No raiz) {
		if(raiz == null) {
			return null;
		}
		if(valor == raiz.getValor()) {
			return raiz;
		}
		if(raiz.getDireito() != null) {
			No result = buscaNo(valor, raiz.getDireito());
			if(result != null && result.getValor() == valor)return raiz;
		}else if(raiz.getEsquerdo() != null) {
			No result = buscaNo(valor, raiz.getEsquerdo());
			if(result != null && result.getValor() == valor)return raiz;
		}
		return null;
	}
	
	
	public void imprimeArvore(No raiz)
	{
		if (raiz == null)
			return;
		
		imprimeArvore(raiz.getEsquerdo());
		System.out.println(raiz.getValor());
		imprimeArvore(raiz.getDireito());
	}
}
