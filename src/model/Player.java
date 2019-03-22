package model;

public class Player {
	/**
	 * Nombre del jugador.
	 */
	private String name;


	/**
	 * @param name 
	 */
	public Player(String name ) {
		this.name = name;
	}

	/**
	 * Devuelve el nombre que tiene el jugador.
	 * @return String
	 */
	public String getName() {
		return name;

	}

	/**
	 * @param name
	 * @return void
	 */
	public void setName (String name) {
		this.name = name;
	}

}

