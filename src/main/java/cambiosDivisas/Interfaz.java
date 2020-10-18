package cambiosDivisas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interfaz extends Application{
	
	private Divisa euro = new Divisa("euro",0.921198);
	private Divisa dolar = new Divisa("dolar",1);
	private Divisa yen = new Divisa("yen",105.40); 
	private Divisa libra = new Divisa("libra",0.77);
	private ComboBox<Divisa> comboBoxOrigenx;
	private ComboBox<Divisa> comboBox2;
	Scene initialScene;
	private HBox firstValues;
	private HBox secondValues;
	private VBox combinedHbox;
	private TextField textFirstComboBox ;
	private TextField textSecondComboBox;
	private Button cambiar;
	
	 
	public void start(Stage primaryStage) throws Exception {
		startInitialTextBox();
		startSecondTextBox();
		
		startComboBox();
		startSecondComboBox();
		startInitialButton();

		initialFirstHBox();
		secondHBox();
		startVbox();
		
		initialScene=new Scene(combinedHbox,300,300);
		primaryStage.setScene(initialScene);
		primaryStage.setTitle("cambio de divisas");
		primaryStage.show();
	}
	
	private void startInitialButton() {
		cambiar= new Button();
		cambiar.setText("Cambiar");
		cambiar.setDefaultButton(true);
		cambiar.setOnAction(p -> onInitialButtonAction(p) );
		
	}
	
	private void onInitialButtonAction(ActionEvent p) {
		cambiar= new Button();
		double cantidadTransformada=Double.parseDouble(textFirstComboBox.getText());
		switch (comboBoxOrigenx.getSelectionModel().getSelectedItem().getMoneda()) {
		case "euro":
			cantidadTransformada=cantidadTransformada*1.085542;
			break;
		case "yen":
			cantidadTransformada=cantidadTransformada*0.0095;
			break;
		case "libra":
			cantidadTransformada=cantidadTransformada*1.29;
			break;
		}
		
		double valorMUltiplicado=comboBox2.getSelectionModel().getSelectedItem().getValor();
		textSecondComboBox.setText(""+Math.round((cantidadTransformada*valorMUltiplicado)));
		
	}

	private void startInitialTextBox() {
		textFirstComboBox = new TextField();
		textFirstComboBox.prefColumnCountProperty();
		textFirstComboBox.setAlignment(Pos.BOTTOM_CENTER);
		textFirstComboBox.setMaxWidth(100);	
	}
	private void startSecondTextBox() {
		textSecondComboBox = new TextField();
		textSecondComboBox.prefColumnCountProperty();
		textSecondComboBox.setAlignment(Pos.BOTTOM_CENTER);
		textSecondComboBox.setMaxWidth(100);	
		textSecondComboBox.setEditable(false);
		textSecondComboBox.setDisable(true);
	}
	
	private void startComboBox() {
		comboBoxOrigenx=new ComboBox<>();
		comboBoxOrigenx.getItems().addAll(euro,dolar,yen,libra);
		comboBoxOrigenx.getSelectionModel().select(euro);
			
	}
	private void startSecondComboBox() {
		comboBox2=new ComboBox<>();
		comboBox2.getItems().addAll(euro,dolar,yen,libra);
		comboBox2.getSelectionModel().select(yen);
			
	}
	private void initialFirstHBox(){
		firstValues=new HBox();
		firstValues.setAlignment(Pos.CENTER);
		firstValues.getChildren().addAll(textFirstComboBox,comboBoxOrigenx);
	}
	private void secondHBox(){
		secondValues=new HBox();
		secondValues.setAlignment(Pos.CENTER);
		secondValues.getChildren().addAll(textSecondComboBox,comboBox2);
	}
	private void startVbox() {
		combinedHbox=new VBox();
		combinedHbox.setSpacing(5);
		combinedHbox.setAlignment(Pos.CENTER);
		combinedHbox.getChildren().addAll(firstValues,secondValues,cambiar);
		
	}

	
	public static void main(String[] args) {
		launch(args);}
	
	
	
	
	

}
