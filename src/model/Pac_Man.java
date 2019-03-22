package model;

import javafx.scene.layout.Pane;

public class Pac_Man {
	/**
	 * Dirección de desplazamiento del Pac-Man					
	 */
	public final static String UP = "Up";
	/**
	 * Dirección de desplazamiento del Pac-Man
	 */
	public final static String RIGHT = "Right";
	/**
	 * Dirección de desplazamiento del Pac-Man
	 */
	public final static String LEFT = "Left";
	/**
	 * Dirección de desplazamiento del Pac-Man
	 */
	public final static String DOWN = "Down";
	/**
	 * Establece el radio del Pac-Man
	 */
	private double radio;
	/**
	 * Establece la posX del Pac-Man
	 */
	private double posX;
	/**
	 * Establece la posY del Pac-Man
	 */
	private double posY;
	/**
	 * Establece el tiempo de espera del Pac-Man
	 */
	private double waitTime;
	/**
	 * Cantidad de rebotes del Pac-Man
	 */
	private int numberOfBounces;
	/**
	 * Estado del Pac_Man, en movimiento o detenido.
	 */
	private boolean stopped;
	// Regresa el pacman cuando va de arriba hacia abajo.
	private boolean toReturnUno;
	// Regresa el pacman cuando va de derecha a izquierda.
	private boolean toReturnDos;
	
	private boolean firstIterationUpAndDown;
	private boolean firstIterationLeftAndRight;


	private String direction;
	/**
	 * @param radio
	 * @param posX
	 * @param posY
	 * @param waitTime
	 * @param direction
	 * @param numberOfBounces
	 * @param stopped
	 * @return void
	 */
	public Pac_Man(double radio, double posX, double posY, double waitTime, String direction, int numberOfBounces, boolean stopped) {
		this.radio = radio;
		this.posX = posX;
		this.posY = posY;
		this.waitTime = waitTime;
		this.numberOfBounces = numberOfBounces;
		this.stopped = stopped;
		this.direction = direction;
		firstIterationUpAndDown = true;
		firstIterationLeftAndRight = true;
	
	}

	/**
	 * Devuelve el radio del Pac-Man.
	 * @return double
	 */
	public double getRadio() {
		return radio;
	}

	/**
	 * Establece el radio del Pac-Man
	 * @param radio
	 * @return void
	 */
	public void setRadio(double radio) {
		this.radio = radio;
	}

	/**
	 * Devuelve la posición en el eje X que se encuentra el  Pac_Man.
	 * @return double
	 */
	public double getPosX() {
		return posX;
	}

	/**
	 * Permite cambiar el valor de la posición del Pac-Man en el eje X
	 * @param posX
	 * @return void
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}

	/**
	 * Devuelve la posición en el eje Y en el que se encuentra el  Pac_Man.
	 * @return double
	 */
	public double getPosY() {
		return posY;
	}

	/**
	 * Permite cambiar el valor de la posición del Pac-Man en el eje Y
	 * @param posY
	 * @return void
	 */
	public void setPosY(double posY) {
		this.posY = posY;
	}

	/**
	 * Retorna el tiempo de espera.
	 * @return double
	 */
	public double getwaitTime() {
		return waitTime;
	}

	/**
	 * Cambia el tiempo de espera del Pac-Man
	 * @param waitTime
	 * @return void
	 */
	public void setWaitTime(double waitTime) {
		this.waitTime = waitTime;
	}

	/**
	 * Establece la dirección de desplazamiento del Pac-Man
	 * @return String
	 */
	public String getDirection() {
		return direction;
		
	}

	/**
	 * Cambia el la dirección de desplazamiento del Pac-Man.
	 * @param direction
	 * @return void
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return void
	 **/
	public void movePacman(Pane pane, double d) {
		
		if (direction.equals(UP)) {
			moveUpAndDown(pane, d);
		}else if (direction.equals(RIGHT)) {
			moveLeftAndRight(pane,d);			
		}else if (direction.equals(DOWN)) {
			moveUpAndDown(pane, d);
		}else if (direction.equals(LEFT)) {
			moveLeftAndRight(pane,d);			
		}
	}
			
			
	


	
	private void moveUpAndDown(Pane pane, double d) {
	
		if(firstIterationUpAndDown) {
			if (direction.equals(UP)) {
				toReturnUno = true;
				firstIterationUpAndDown = false;
			}else if (direction.equals(DOWN)  ) {
				toReturnUno = false;
				firstIterationUpAndDown = false;
			}
		}
		if (toReturnUno) {
			posY -= d;
		}else {
			posY += d;
		}
		
		if (posY > pane.getHeight()-radio) {
			toReturnUno = true;
		}else if(posY < (0 +radio)){
			toReturnUno = false;
			
		}
	
		
	}
	
	public void devolverse(int avance) {
		if (toReturnUno) {
			posX -= avance;
		}else {
			posX += avance;
		}
	}
	
	private void moveLeftAndRight(Pane pane, double d) {
		if (firstIterationLeftAndRight) {
			if (direction.equals(LEFT)) {
					toReturnDos = true;
					firstIterationLeftAndRight = false;
			}else if (direction.equals(RIGHT)  ) {
				toReturnDos = false;
				firstIterationLeftAndRight = false;
			}
		}
		if (toReturnDos) {
			posX -= d;
		}else {
			posX += d;
		}
		if (posX > (pane.getWidth()-radio)) {
			toReturnDos = true;
		}else if (posX < (0+radio)) {
			toReturnDos = false;
		}
		
	}
	
	
	
	/**
	 * Devulve el número de rebotes que tiene el Pac-Man
	 * @return int
	 */
	public int getNumberOfBounces() {
		return numberOfBounces;
	}

	/**
	 * Permite cambiar el número de rebotes que tiene el Pac-Man	
	 * @param NumberOfBounces
	 * @return void
	 */
	public void setNumberOfBounces(int NumberOfBounces) {
		this.numberOfBounces = NumberOfBounces;
	}

	/**
	 * Regresa verdadero si se detuvo el pokemon y falso si es lo contrario.
	 * @return boolean
	 */
	public boolean getstopped() {
		return stopped;
	}

	/**
	 * Permite modificar el estado del Pac-Man 
	 * @param stopped
	 * @return void
	 */
	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	public boolean isToReturnUno() {
		return toReturnUno;
	}

	public void setToReturnUno(boolean toReturnUno) {
		this.toReturnUno = toReturnUno;
	}

	public boolean isToReturnDos() {
		return toReturnDos;
	}

	public void setToReturnDos(boolean toReturnDos) {
		this.toReturnDos = toReturnDos;
	}

	public double area() {
		return (Math.PI * Math.pow(radio, 2));
	}
	
	
}

