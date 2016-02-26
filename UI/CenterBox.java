import java.time.LocalDate;

import com.sun.javafx.scene.control.skin.DatePickerSkin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CenterBox {

	VBox centerBox = new VBox();
	TextField mainTextField = new TextField();
	double textfieldWidth=0;
	double textfieldHeight=0;
	Stage primaryStage;

	public CenterBox() {
		// TODO Auto-generated constructor stub
	}


	public VBox centerBox(Stage primaryStage, double textfieldWidth, double textfieldHeight)
	{
		this.primaryStage = primaryStage;
		this.textfieldWidth = textfieldWidth;
		this.textfieldHeight = textfieldHeight;
		addTabpane(centerBox);
		addMainTextfield(centerBox);
		return centerBox;	
	}


private void addTabpane(VBox centerBox) {
		
		TabPane tabPane = new TabPane();
		tabPane.setPrefHeight(1000);
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		addTab(tabPane);
		centerBox.getChildren().add(tabPane);
	}
private void addMainTextfield(VBox centerBox) {
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
            	mainTextField.setText("");
            }
        }
    });	
}
private void addTab(TabPane tabPane)
{
	Tab tab = new Tab();
	addTitledpane(tab);
	setTabname(tab);
	tabPane.getTabs().add(tab);
}
private void setTabname(Tab tab) {
	tab.setText("name 1");
}
private void addTitledpane(Tab tab) {
	 TitledPane titledPane = new TitledPane();
	 addMainList(titledPane);
	 tab.setContent(titledPane);
}
private void addMainList(TitledPane titledPane) {
	ListView<String> list = new ListView<>(); 
	addContent(list);
	list.setOnKeyPressed(new EventHandler<KeyEvent>() {
        public void handle(KeyEvent ke) {
        	if (ke.getCode().equals(KeyCode.ENTER))
            {
	            createDisappearPane(list.getSelectionModel().getSelectedItem());
            }
        }
    });
	
	titledPane.setContent(list);
	
}
private void createDisappearPane(String str_Name) {

	
    Stage dialog = new Stage();
	dialog.initModality(Modality.APPLICATION_MODAL);
    dialog.initOwner(primaryStage);
    VBox dialogVbox = new VBox(20);
    dialogVbox.getChildren().add(new Text("This is a Dialog"));
    Scene dialogScene = new Scene(dialogVbox, 300, 200);

    dialog.setScene(dialogScene);
    dialog.show();
	
	
	
}
private void addContent(ListView<String> list) {
	ObservableList<String> arrayImgView = FXCollections.observableArrayList(new String("test"),new String("test1"),new String("test2"));
	list.setItems(arrayImgView);

}
}