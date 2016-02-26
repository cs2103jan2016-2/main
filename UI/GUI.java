import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class GUI extends Application {
	
	final double sceneWidth = 1640; 
	final double sceneHeight = 750; 
	
	final double textfieldWidth = 50;
	final double textfieldHeight = 1500;
	Stage primaryStage;
	
	public String strDBdir = "";
	public String strDBname = "";
	
	HBox root = new HBox();
	VBox leftBox = new VBox();
	LeftBox lb = new LeftBox();;
	CenterBox cb = new CenterBox();
	
	Scene scene = new Scene(root,sceneWidth,sceneHeight,Color.WHITE);
	private Service<Void> backgroundThread;
	
	@Override
	public void start(Stage primaryStage) 
	{
		root.getChildren().add(lb.leftBox());
		root.getChildren().add(cb.centerBox(primaryStage, textfieldWidth,textfieldHeight));
		EscCloseForm(primaryStage);
		initializeRoot(primaryStage);
	}

	private void initializeRoot(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void EscCloseForm(Stage primaryStage) 
	{
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
		        @Override
		        public void handle(KeyEvent t) {
		          if(t.getCode()==KeyCode.ESCAPE)
		          {
		        	  primaryStage.close();
		          }
		        }
		    });		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void setDBname(String strDBname) {
		this.strDBname = strDBname;
	}

	public void setDBdir(String strDBdir) {
		this.strDBdir = strDBdir;
		
	}
}
