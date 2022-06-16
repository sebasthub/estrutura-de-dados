package main;

public class Main {

	public static void main(String[] args) {
		int timelineAtual = 0;
		
		Entity player = new Entity(10, 5);
		Entity enemy = new Entity(10, 5);
		
		
		
		//deve ser chamado no fim do turno
		TimeLine atual = new TimeLine(player, enemy, timelineAtual);
	}

}
