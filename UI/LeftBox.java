import java.time.LocalDate;

import com.sun.javafx.scene.control.skin.DatePickerSkin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class LeftBox {

	VBox leftBox = new VBox();

	private void addGraph() {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList( new PieChart.Data("Completed", 13), new PieChart.Data("Incomplete", 25));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Completed Task Statistic");
        leftBox.getChildren().add(chart);
	}
	private void addTagCategories() {
		TitledPane titledPane = new TitledPane();
		addTagList(titledPane);
	}
	@SuppressWarnings("restriction")
	private void addCalendar() {
		DatePicker  checkInDatePicker = new DatePicker();
        Label checkInlabel = new Label("Check-In Date:");
        DatePickerSkin datePickerSkin = new DatePickerSkin(new DatePicker(LocalDate.now()));
        @SuppressWarnings("restriction")
		Node popupContent = datePickerSkin.getPopupContent();
        leftBox.getChildren().add(popupContent);
	}
	private void addTagList(TitledPane titledPane){
		ListView<String> list = new ListView<>(); 
		ObservableList<String> arrayImgView = FXCollections.observableArrayList(new String("test"),new String("test1"),new String("test2"));
		list.setItems(arrayImgView);
		titledPane.setContent(list);
		leftBox.getChildren().add(list);
	}
	public VBox leftBox() {
		addGraph();
		addTagCategories();
		addCalendar();
		return leftBox;	
	}
}
