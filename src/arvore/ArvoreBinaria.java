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
	
	public void insereValor (No raiz, String valor, boolean lado, int codigo)
	{	
		//Verifica se a árvore está vazia
		if (this.raiz == null)
		{
			this.raiz = new No(valor,lado, codigo);
			return;
		}
		
		//Verifica para que lado da raiz vai andar
		if (lado == true)
		{
			//Se nao tiver lado direito, insere
			if (raiz.getDireito() == null)
			{
				raiz.setDireito(new No(valor, lado, codigo));
				return;
			}
			if (valor.compareTo(raiz.getValor()) < 0) {
				insereValor(raiz.getEsquerdo(), valor, lado, codigo);
				return;
			}
			//Insere recursivamente
			insereValor(raiz.getDireito(), valor, lado, codigo);
		}
		else
		{	
			if (raiz.getEsquerdo() == null)
			{
				raiz.setEsquerdo(new No(valor, lado, codigo));
				return;
			}
			if (valor.compareTo(raiz.getValor()) < 0) {
				insereValor(raiz.getEsquerdo(), valor, lado, codigo);
				return;
			}
			insereValor(raiz.getDireito(), valor,lado,codigo);
		}
	}
	
	public No removeNo(String valor, No raiz) {
        //verifica se é nulo
        if(raiz==null)
            return null;
        else {
            if(raiz.getValor()==valor) {
                //remove no FOLHA
                if(raiz.getEsquerdo()==null && raiz.getDireito()==null) {
                    raiz=null;
                    return null;
                }
                else {
                    // remove no com apenas 1 filho
                    if(raiz.getEsquerdo() ==null || raiz.getDireito() == null) {
                        No temp;
                        if(raiz.getEsquerdo()!=null)
                            temp= raiz.getEsquerdo();
                        else
                            temp= raiz.getDireito();
                        raiz=null;
                        return temp;
                    }
                    //troca o no com o de valor mais proximo e exclui o ultimo 
                    else {
                        No temp = raiz.getEsquerdo();
                        while(temp.getDireito() != null)
                            temp= temp.getDireito();
                        raiz.setValor(temp.getValor());
                        temp.setValor(valor);
                        raiz.setEsquerdo(removeNo(valor,raiz.getEsquerdo()));
                        return raiz;
                    }
                }
            }
            //chama o metodo de forma recursiva
            else{
                if(valor.compareTo(raiz.getValor()) < 0)
                    raiz.setEsquerdo(removeNo(valor,raiz.getEsquerdo()));
                else
                    raiz.setDireito(removeNo(valor,raiz.getDireito()));
                return raiz;
            }
        }
    }
	
	public boolean buscaValor(String valor, No raiz) {
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
	
	public No buscaNo(String valor, No raiz) {
		if(raiz == null) {
			return null;
		}
		if(valor == raiz.getValor()) {
			System.out.println("piroca");
			return raiz;
		}
		No n;
		n = buscaNo(valor, raiz.getDireito());
		if(n == null) buscaNo(valor, raiz.getEsquerdo());
		return n;
	}
	
	public void buscaCodigo(No raiz,int codigo,boolean lado) {
		if(raiz == null) {
			return;
		}
		if(raiz.getCod() == codigo && raiz.isLado() == lado) {
			System.out.println(raiz.getValor());
		}else {
			buscaCodigo(raiz.getDireito(), codigo, lado);
			buscaCodigo(raiz.getEsquerdo(), codigo, lado);
		}
	}
	
	public void imprimeArvore(No raiz)
	{
		if (raiz == null)
			return;
		if(raiz.noFolha()) {
			System.out.println(raiz.getValor());
			return;
		}
		imprimeArvore(raiz.getEsquerdo());
		System.out.println(raiz.getValor());
		imprimeArvore(raiz.getDireito());
	}
}
