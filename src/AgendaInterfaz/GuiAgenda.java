package AgendaInterfaz;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ut7.Agenda.modelo.AgendaContactos;

public class GuiAgenda extends Application {
	private AgendaContactos agenda;
	private MenuItem itemImportar;
	private MenuItem itemExportarPersonales;
	private MenuItem itemSalir;

	private MenuItem itemBuscar;
	private MenuItem itemFelicitar;

	private MenuItem itemAbout;

	private TextArea areaTexto;

	private RadioButton rbtListarTodo;
	private RadioButton rbtListarSoloNumero;
	private Button btnListar;

	private Button btnPersonalesEnLetra;
	private Button btnPersonalesOrdenadosPorFecha;

	private TextField txtBuscar;

	private Button btnClear;
	private Button btnSalir;

	@Override
	public void start(Stage stage) {
		agenda = new AgendaContactos(); // el modelo

		BorderPane root = crearGui();

		Scene scene = new Scene(root, 1100, 700);
		stage.setScene(scene);
		stage.setTitle("Agenda de contactos");
		scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
		stage.show();

	}

	private BorderPane crearGui() {
		BorderPane panel = new BorderPane();
		panel.setTop(crearBarraMenu());
		panel.setCenter(crearPanelPrincipal());
		return panel;
	}

	private BorderPane crearPanelPrincipal() {
		BorderPane panel = new BorderPane();
		panel.setPadding(new Insets(10));
		panel.setTop(crearPanelLetras());

		areaTexto = new TextArea();
		areaTexto.getStyleClass().add("textarea");
		panel.setCenter(areaTexto);

		panel.setLeft(crearPanelBotones());
		return panel;
	}

	private VBox crearPanelBotones() {
		// a completar
		VBox panel = new VBox();
		panel.setPadding(new Insets(10));
		areaTexto.setPromptText("Buscar");
		areaTexto.setMinHeight(40);
		areaTexto.setPadding(new Insets(40));
		
		rbtListarSoloNumero = new RadioButton("Listar Solo Numero");
		
		rbtListarTodo = new RadioButton("Listar Todo");
		rbtListarTodo.setSelected(true);
		
		ToggleGroup grupo = new ToggleGroup();
		rbtListarSoloNumero.setToggleGroup(grupo);
		rbtListarTodo.setToggleGroup(grupo);
		
		btnListar = new Button("Listar");
		btnListar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnListar.setPrefWidth(250);
		btnListar.setPadding(new Insets(40));
		btnListar.setOnAction(event -> listar());
		
		
		btnPersonalesEnLetra = new Button("Personales en Letra");
		btnPersonalesEnLetra.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnPersonalesEnLetra.setPrefWidth(250);
		btnPersonalesEnLetra.setOnAction(event -> contactosEnLetra('a'));
		
		btnPersonalesOrdenadosPorFecha = new Button("Contactos personales ordenados por fecha");
		btnPersonalesOrdenadosPorFecha.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnPersonalesOrdenadosPorFecha.setPrefWidth(250);
		btnPersonalesOrdenadosPorFecha.setOnAction(event -> personalesOrdenadosPorFecha());
		
		btnClear = new Button("Clear");
		btnClear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnClear.setPrefWidth(250);
		btnClear.setOnAction(event -> clear());
		btnClear.setPadding(new Insets(40));
		
		btnSalir = new Button("Clear");
		btnSalir.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnSalir.setPrefWidth(250);
		btnSalir.setOnAction(event -> salir());
		
		panel.getChildren().addAll(areaTexto, rbtListarTodo, rbtListarSoloNumero, btnListar, btnPersonalesEnLetra, btnPersonalesOrdenadosPorFecha, btnClear, btnSalir);
		
		
		
		

		return panel;
	}

	private GridPane crearPanelLetras() {
		// a completar
		GridPane panel = new GridPane();
		panel.setPadding(new Insets(10));
		

		String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		int len = alfabeto.length();
		int fil = 0;
		for (int i = 0; i < len; i++) {
			char letra = alfabeto.charAt(i);
			Button btn = obtenerBoton(String.valueOf(letra));
			btn.setOnAction(event -> contactosEnLetra(letra));
			panel.add(btn, i, fil);
			if ((i + 1) == 14 ) {
				fil++;
				i = 0;
			}
		}

		return panel;
	}
	
	private Button obtenerBoton(String texto) {

		Button btn = new Button(texto);
		btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		btn.setPrefHeight(15);
		btn.setPrefWidth(15);

		GridPane.setHgrow(btn, Priority.ALWAYS);
		GridPane.setVgrow(btn, Priority.ALWAYS);
		GridPane.setMargin(btn, new Insets(5));

		return btn;
	}
	
	

	private MenuBar crearBarraMenu() {
		// a completar
		MenuBar barra = new MenuBar();
		barra.setId("barramenu");
		Menu menu = new Menu("Archivo");
		barra.getMenus().add(menu);

		itemImportar = new MenuItem("Importar");
		itemImportar.setAccelerator(
				KeyCombination.keyCombination("Ctrl+I"));
		itemImportar.setOnAction(event -> importarAgenda());
		
		itemExportarPersonales = new MenuItem("Exportar_Personales");
		itemExportarPersonales.setAccelerator(
				KeyCombination.keyCombination("Ctrl+E"));
		itemExportarPersonales.setOnAction(event -> exportarPersonales());
		
		itemSalir = new MenuItem("Salir");
		itemSalir.setAccelerator(
				KeyCombination.keyCombination("Ctrl + S"));
		itemSalir.setOnAction(event -> salir());
		
		menu.getItems().addAll(itemImportar, itemExportarPersonales, itemSalir);
		
		Menu menu2 = new Menu("Operaciones");
		barra.getMenus().add(menu2);

		itemBuscar = new MenuItem("Importar");
		itemBuscar.setAccelerator(
				KeyCombination.keyCombination("Ctrl+B"));
		itemBuscar.setOnAction(event -> buscar());
		
		itemFelicitar = new MenuItem("Exportar_Personales");
		itemFelicitar.setAccelerator(
				KeyCombination.keyCombination("Ctrl+F"));
		itemFelicitar.setOnAction(event -> felicitar());
		
		
		
		menu2.getItems().addAll(itemBuscar, itemFelicitar);
		
		Menu menu3 = new Menu("Help");
		barra.getMenus().add(menu3);

		itemAbout = new MenuItem("Importar");
		itemAbout.setAccelerator(
				KeyCombination.keyCombination("Ctrl+A"));
		itemAbout.setOnAction(event -> about());
		
		
		
		
		menu3.getItems().addAll(itemAbout);

		return barra;
	}

	private void importarAgenda() {
		// a completar

	}

	private void exportarPersonales() {
		// a completar

	}

	/**
	 *  
	 */
	private void listar() {
		clear();
		// a completar

	}

	private void personalesOrdenadosPorFecha() {
		clear();
		// a completar

	}

	private void contactosPersonalesEnLetra() {
		clear();
		// a completar

	}

	private void contactosEnLetra(char letra) {
		clear();
		// a completar
	}

	private void felicitar() {
		clear();
		// a completar

	}

	private void buscar() {
		clear();
		// a completar

		cogerFoco();

	}

	private void about() {
		// a completar

	}

	private void clear() {
		areaTexto.setText("");
	}

	private void salir() {
		Platform.exit();
	}

	private void cogerFoco() {
		txtBuscar.requestFocus();
		txtBuscar.selectAll();

	}

	public static void main(String[] args) {
		launch(args);
	}
}