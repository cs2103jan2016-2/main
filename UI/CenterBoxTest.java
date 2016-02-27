import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.BoxBlur;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/*
 *@author Chiang Jia Feng
 *@Description: CenterBox (Tabpane and Textfield)
 */

public class CenterBoxTest {

	
	private final String firstTab = "All Tasks";
	private final String secondTab = "Completed Tasks";

	private final double textfieldWidth = 100; //centerBox txtfield size
	private final double textfieldHeight = 1500;
	private final double tabPaneWidth = 1000; //centerBox tabPane size
	private final double tabPaneHeight = 1000;
	private final double titledPaneWidth = 1000; //centerBox titledPane size
	private final double titledPaneHeight = 1000;
	private final double TabWidth = 300; //centerBox txtfield size
	private final double TabHeight = 300; //centerBox txtfield size

	private VBox centerBox = new VBox();;
	private TitledPane titledPane = new TitledPane();
	private TabPane tabPane = new TabPane();
	private ListView<String> list = new ListView<>();

	private Stage dialog = new Stage();
	private TextField mainTextField = new TextField();

	private Logic logic = new Logic();
	
	private LeftBox lb;
	private Stage primaryStage;

	
	public VBox centerBox(Stage primaryStage, LeftBox lb)
	{
		this.lb = lb;
		this.primaryStage = primaryStage;
		addTabpane(centerBox);
		addMainTextfield(centerBox);
		return centerBox;	
	}
	private void addTabpane(VBox centerBox) 
	{
		tabPane.setPrefSize(tabPaneHeight,tabPaneWidth);
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		addTab(tabPane);
		centerBox.getChildren().add(tabPane);	
	}
	private void addMainTextfield(VBox centerBox) 
	{
		textFieldListener();
		mainTextField.setPrefSize(textfieldHeight, textfieldWidth);
		centerBox.getChildren().add(mainTextField);
	}
	private void textFieldListener() {
		mainTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
	    {
	        public void handle(KeyEvent ke)
	        {
	            if (ke.getCode().equals(KeyCode.ENTER))
	            {
	            	logic.run(mainTextField.getText());
	            	mainTextField.setText("");
	            }
	        }
	    });	
	}
	private void addTab(TabPane tabPane)
	{
		Tab tab = new Tab(firstTab);
		addTitledpane(tab);
		tabPane.getTabs().add(tab);
		Tab tab1 = new Tab(secondTab);
		addTitledpane(tab);
		tabPane.getTabs().add(tab1);
	}
	private void addTitledpane(Tab tab) 
	{
		tab.setContent(titledPane);
		addMainList(titledPane);
	}
	private void addMainList(TitledPane titledPane) 
	{
		titledPane.setPrefSize(titledPaneHeight, titledPaneWidth);
		ListView<HBox> list = new ListView<>(); 
		addContent(list);
		list.setOnKeyPressed(new EventHandler<KeyEvent>() 
		{
	        public void handle(KeyEvent ke) {
	        	if (ke.getCode().equals(KeyCode.ENTER))
	            {
		            createDisappearPane(list.getSelectionModel().getSelectedItem());
		           
		            centerBox.setEffect(new BoxBlur());
		            lb.leftBox.setEffect(new BoxBlur());
	            }
	        }
	    });
		titledPane.setContent(list);
	}
	private void createDisappearPane(HBox hbox) 
	{
	    Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
	    dialog.initOwner(primaryStage);
	    VBox dialogVbox = new VBox();
	    dialogVbox.getChildren().add(new Text("This is a Dialog"));
	    Scene dialogScene = new Scene(dialogVbox, 300, 200);
	    dialog.setScene(dialogScene);
	    dialog.show();
	    dialog.setOnCloseRequest(new EventHandler<WindowEvent>() {
	        public void handle(WindowEvent we) {
	        	centerBox.setEffect(null);
	            lb.leftBox.setEffect(null);
	        }
	    });  
	}
	@SuppressWarnings("null")
	private void addContent(ListView<HBox> list) 
	{
		ObservableList<HBox> arrayImgView = FXCollections.observableArrayList();
		//for(int x=0;x<logic.getOngoingTasks().size();x++)
		/*for(int x=0;x<10000;x++)
		{
			HBox vb = new HBox();
			vb.setPrefSize(50,100);
			Label lbl = new Label("task a");
			Label lbl1 = new Label("date");
			Label lbl2 = new Label("time");
			lbl.setPrefWidth(100);
			lbl1.setPrefWidth(250);
			lbl2.setPrefWidth(500);

			//lbl.setText(logic.getOngoingTasks().get(0).getTaskDescription());
			vb.getChildren().addAll(lbl,lbl1,lbl2);
			arrayImgView.add(vb);
		}*/
		
		
		new Thread(new Runnable() {
		    @Override public void run() {
		        Platform.runLater(new Runnable() {
		            @Override public void run() {
		            	for(int x=0;x<10000;x++)
		        		{
		        			HBox vb = new HBox();
		        			vb.setPrefSize(50,100);
		        			Label lbl = new Label("task a");
		        			Label lbl1 = new Label("date");
		        			Label lbl2 = new Label("time");
		        			lbl.setPrefWidth(100);
		        			lbl1.setPrefWidth(250);
		        			lbl2.setPrefWidth(500);

		        			//lbl.setText(logic.getOngoingTasks().get(0).getTaskDescription());
		        			vb.getChildren().addAll(lbl,lbl1,lbl2);
		        			arrayImgView.add(vb);
		        			
		        		}
		            }
		        });
		    }
		}).start();
		//arrayImgView = FXCollections.observableArrayList(new VBox(),new VBox(),new VBox());
		//ObservableList<String> arrayImgView = FXCollections.observableArrayList(new String("test"),new String("test1"),new String("test2"));		
		list.setItems(arrayImgView);
	}
	public TextField getTextField()
	{
		return mainTextField;
	}
}