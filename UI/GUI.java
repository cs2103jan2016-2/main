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
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class GUI extends Application {
	
	private final double sceneWidth = 1640; 
	private final double sceneHeight = 750; 
	private final double textfieldWidth = 200;
	private final double textfieldHeight = 1500;
	private Stage primaryStage;
	public String strDBdir = "";
	public String strDBname = "";
	HBox root = new HBox();
	VBox leftBox = new VBox();
	LeftBox lb = new LeftBox();;
	CenterBox cb = new CenterBox();
	TextField mainTextFeild=null;
	Scene scene = new Scene(root,sceneWidth,sceneHeight,Color.WHITE);	
	Logic logic = new Logic();
	@Override
	public void start(Stage primaryStage) 
	{
		root.getChildren().add(lb.leftBox(cb));
		root.getChildren().add(cb.centerBox(primaryStage, textfieldWidth,textfieldHeight,lb));
		mainTextFeild = cb.getTextField();
		EscCloseForm(primaryStage);
		initializeRoot(primaryStage);
	}

	public void initializeRoot(Stage primaryStage) 
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
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) 
	          {
	        	  Task<Void> task = new Task<Void>() {
	     	         @Override protected Void call() throws Exception {
	     	        	 logic.save();
						return null;
	     	         }
	     	     };
	     	    Thread th = new Thread(task);
	     	    th.setDaemon(true);
	     	    th.start();
	            System.out.println("Stage is closing");
	          }
	      });        
		primaryStage.close();
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
	
	/*	
 	Logic logic = new Logic(commands);
	logic.run();
	*/
}
