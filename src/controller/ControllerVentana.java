package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.FileChooser;
import model.Game;
import model.Level;
import model.Pac_Man;
import thread.ThreadPacMan;

public class ControllerVentana {

	@FXML
	private Pane pane;
	@FXML
	private MenuBar menuBar;
	private Game game;
	private ArrayList<Arc> arcs;
	private ArrayList<ThreadPacMan> thread;
    private File theFile;
	
	
	
	
	public void iniciar(ActionEvent event) {

	
	
		for (int i = 0; i <game.getLevels()[0].getPacmans().size(); i++) {
			arcs.add(new Arc());
			
		}
		for (int j = 0; j < game.getLevels()[0].getPacmans().size(); j++) {
			
			moverPacman(j);
			pane.getChildren().addAll(arcs.get(j));
			thread.add(new ThreadPacMan(game, this));
			thread.get(j).start();
		}
		

	}

	
	public void moverPacman(int i) {
		
		
		
		arcs.get(i).setRadiusX(game.getLevels()[0].getPacmans().get(i).getRadio());
		arcs.get(i).setRadiusY(game.getLevels()[0].getPacmans().get(i).getRadio());
		arcs.get(i).setStartAngle(25);
		arcs.get(i).setLength(300);
		arcs.get(i).setStroke(Color.YELLOW);
		arcs.get(i).setStrokeType(StrokeType.INSIDE);
		arcs.get(i).setType(ArcType.ROUND);
		arcs.get(i).setFill(Color.DARKRED);
		arcs.get(i).setLayoutX((game.getLevels()[0].getPacmans().get(i).getPosX()));
		arcs.get(i).setLayoutY((game.getLevels()[0].getPacmans().get(i).getPosY()));
	
	}
	
	@FXML
	public void initialize() {
		game = new Game();
		arcs = new ArrayList<Arc>();
		thread = new ArrayList<ThreadPacMan>();
		
		
		Menu file =menuBar.getMenus().get(0);
		
		MenuItem menuItem1 = new MenuItem("Cargar Nivel");
		MenuItem menuItem2 = new MenuItem("Guardar Nivel ");
		file.getItems().add(menuItem1);
		file.getItems().add(menuItem2);
		
		menuItem1.setOnAction(event -> {
			System.out.println("hola");
			JFileChooser chooser = new JFileChooser("data");
			//fileChooser.setTitle("Open Resource File");
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int result = chooser.showOpenDialog(chooser);
			if(result==JFileChooser.APPROVE_OPTION) {
				theFile = chooser.getSelectedFile();
			}
			
			
			try {
				game.loadLevel(theFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		});
		
		
		
		
	}
	
	 @FXML
	 public void stopPacMan(MouseEvent event) {
		 double x = event.getX();
		 double y =event.getY();
		 Long tiempo = 1000000L;
		 for (int i = 0; i < arcs.size(); i++) {
				 if (game.getLevels()[0].stopped(x, y,i)) {
					 System.out.println(game.getLevels()[0].stopped(x, y,i));
					 System.out.println("Detener");
					
					 
				} 
				 
				 
			 }
		 

	  }

	public Pane getPane() {
		return pane;
	}


	public void setPane(Pane pane) {
		this.pane = pane;
	}
}
