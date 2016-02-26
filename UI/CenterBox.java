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

public class CenterBox {

	double textfieldWidth=0;
	double textfieldHeight=0;
	TextField mainTextField = new TextField();

	LeftBox lb;
	VBox centerBox = new VBox();
    Stage dialog = new Stage();
	Stage primaryStage;
	Stage dialogStage;
	TabPane tabPane = new TabPane();
	TitledPane titledPane = new TitledPane();
	ListView<String> list = new ListView<>(); 

	Logic logic = new Logic();
	public CenterBox() {
		// TODO Auto-generated constructor stub
	}
	public VBox centerBox(Stage primaryStage, double textfieldWidth, double textfieldHeight,LeftBox lb)
	{
		dialogStage = new Stage();
		this.lb = lb;
		this.primaryStage = primaryStage;
		this.textfieldWidth = textfieldWidth;
		this.textfieldHeight = textfieldHeight;
		addTabpane(centerBox);
		addMainTextfield(centerBox);
		return centerBox;	
	}
	private void addTabpane(VBox centerBox) 
	{
		tabPane.setPrefHeight(1000);
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
		
		Tab tab = new Tab();
		addTitledpane(tab);
		tabPane.getTabs().add(tab);
		setTabname(tab,"All Tasks");
		Tab tab1 = new Tab();
		addTitledpane(tab);
		tabPane.getTabs().add(tab1);
		setTabname(tab1,"Completed Tasks");

	}
	private void setTabname(Tab tab,String name) {
		tab.setText(name);
	}
	private void addTitledpane(Tab tab) {
		 
		tab.setContent(titledPane);
		addMainList(titledPane);

	}
	private void addMainList(TitledPane titledPane) {
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
	    VBox dialogVbox = new VBox(20);
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
		for(int x=0;x<5;x++)
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
		//arrayImgView = FXCollections.observableArrayList(new VBox(),new VBox(),new VBox());
		//ObservableList<String> arrayImgView = FXCollections.observableArrayList(new String("test"),new String("test1"),new String("test2"));		
		list.setItems(arrayImgView);
	}
	public TextField getTextField()
	{
		return mainTextField;
	}
}