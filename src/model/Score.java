package model;

import java.io.Serializable;

public class Score implements Serializable{
	/**
	 * 	
	 */
	private int scoreNumber;
	// Relacion con el jugador.
	private Player player;

	public Score(int scoreNumber) {
		this.scoreNumber = scoreNumber;
	}

	/**
	 * @param score
	 * @return void
	 */
	public void Puntaje(int score) {
	}

	/**
	 * @return int
	 */
	public int getScore() {
		return scoreNumber;
	}

	/**
	 * @param score
	 * @return void
	 */
	public void setScore(int score) {
		this.scoreNumber = score;
	}

}

