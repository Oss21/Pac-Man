package thread;

import controller.ControllerVentana;
import model.Game;
import model.Level;
import model.Pac_Man;

public class ThreadPacMan extends Thread{

	private boolean iniciar;
	private ControllerVentana controller;
	private Game game;
	
	public ThreadPacMan(Game game, ControllerVentana controller) {
		this.controller = controller;
		this.game = game;
		iniciar = true;
	}
	
	
	public void run() {
		while (iniciar) {
			for (int i = 0; i < game.getLevels()[0].getPacmans().size(); i++) {
				for (int j = i+1; j < game.getLevels()[0].getPacmans().size(); j++) {
					if (game.getLevels()[0].collision(i, j)) {
						game.getLevels()[0].getPacmans().get(i).setToReturnUno(!game.getLevels()[0].getPacmans().get(i).isToReturnUno());
						game.getLevels()[0].getPacmans().get(i).setToReturnDos(!game.getLevels()[0].getPacmans().get(i).isToReturnDos());
						
						game.getLevels()[0].getPacmans().get(j).setToReturnDos(!game.getLevels()[0].getPacmans().get(j).isToReturnDos());
						game.getLevels()[0].getPacmans().get(j).setToReturnUno(!game.getLevels()[0].getPacmans().get(j).isToReturnUno());
					}
					
				}
				
				game.getLevels()[0].getPacmans().get(i).movePacman(controller.getPane(), game.getLevels()[0].getPacmans().get(i).getwaitTime());
				controller.moverPacman(i);
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void detener() {
		iniciar = false;
	}
	
	
}
	
	
