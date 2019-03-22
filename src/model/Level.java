package model;

import java.util.ArrayList;

import com.sun.javafx.geom.Area;
import com.sun.javafx.geom.Shape;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

/**
 * @author
 *
 */
public class Level {

	/**
	 * Arraylist de Pac_Man.
	 */
	private ArrayList<Pac_Man> pacmans;
	/**
	 *
	 * @param levelNumber
	 */
	public Level() {
		
		pacmans = new ArrayList<Pac_Man>();
	
		
	}


	
	
	
	
	/**
	 * @param posX_Uno
	 * @param posY_Uno
	 * @param posX_Dos
	 * @param posY_Dos
	 * @return double
	 */
	public double calculateDistancePac_Man(double posX_Uno, double posY_Uno, double posX_Dos, double posY_Dos) {		
		return Math.sqrt(Math.pow(posX_Dos - posX_Uno, 2) + Math.pow(posY_Dos - posY_Uno, 2));
	}

	/**
	 * @return boolean
	 */
	public boolean collision(int i, int j) {
		return (calculateDistancePac_Man(pacmans.get(i).getPosX(),pacmans.get(i).getPosY(),pacmans.get(j).getPosX(), pacmans.get(j).getPosY()) < ( pacmans.get(i).getRadio()+ pacmans.get(j).getRadio()))? true : false;
	}
		
			
	public boolean stopped(double x, double y, int i) {
		return (calculateDistancePac_Man(pacmans.get(i).getPosX(),pacmans.get(i).getPosY(),x, y) < ( pacmans.get(i).getRadio()))? true : false;

	}

				
					
					
	
										
					
			

					
		
		

	public ArrayList<Pac_Man> getPacmans() {
		return pacmans;
	}

	public void setPacmans(ArrayList<Pac_Man> pacmans) {
		this.pacmans = pacmans;
	}

}

