package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.javafx.geom.Area;
import com.sun.javafx.geom.Shape;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Game {
	/**
	 * Ruta del archivo serializable
	 */
	public String PATH_DATA = "data/data.inf";

	/**
	 * Relacion con level
	 */
	private Level[] levels;
	private int nivel;
	private Score[] scores;
	private ArrayList<Player> players;
	
	public Game() {
		levels = new Level[3];
		scores = new Score[10];
		players = new ArrayList<Player>();
		
	}

	public boolean  elPuntoEsta(Shape areaUno, Shape areaDos) {
		Area pacmanUno = new Area(areaUno);
		Area pacmanDos = new Area(areaDos);
		pacmanUno.intersect(pacmanDos);
		

		
		return true;
		}
	/**
	 * @param levelNumber
	 * @return void
	 */
	public void Level(int levelNumber) {
	}

	/**
	 * Permite cargar el nivel
	 * @param file
	 * @return void
	 * @throws IOException 
	 */
	public void loadLevel(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader lector = new BufferedReader(fr);
		String line = lector.readLine();
		while (line != null) {
			String data[] = line.split("	");
			
			if (line.charAt(0) != '#') {
				if (data.length == 1) {
				 nivel = Integer.parseInt(data[0]);
					levels[nivel] = new Level();
				}else {
					double radio = Double.parseDouble(data[0]);
					double posX = Double.parseDouble(data[1]);
					double posY = Double.parseDouble(data[2]);
					int waitTime = Integer.parseInt(data[3]);
					String direction = data[4];
					int numberOfBounces = Integer.parseInt(data[5]);
					boolean stopped = Boolean.valueOf(data[6]);
					
					levels[nivel].getPacmans().add(new Pac_Man(radio, posX, posY, waitTime, direction, numberOfBounces, stopped));
				
				}
				
				
			}
			
			
			
			line = lector.readLine();
			
			
			
		}
		
	}

	/**
	 * Permite guardar el estado actual en el que se encuentra el nivel
	 * @return void
	 */
	public void saveLevel() {
		// TODO Auto-generated method stub
	}
	
	
	public Level[] getLevels() {
		return levels;
	}

	
				


}


