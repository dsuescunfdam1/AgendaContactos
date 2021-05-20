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
		itemImportar.setOnAction(event -> importarAgenda());
		itemExportarPersonales = new MenuItem("Exportar_Personales");
		itemExportarPersonales.setOnAction(event -> exportarPersonales());
		
		itemSalir = new MenuItem("Salir");
		itemSalir.setOnAction(event -> salir());
		
		menu.getItems().addAll(itemImportar, itemExportarPersonales);
		
		Menu menu2 = new Menu("Operaciones");
		barra.getMenus().add(menu2);

		itemBuscar = new MenuItem("Importar");
		itemBuscar.setOnAction(event -> buscar());
		itemFelicitar = new MenuItem("Exportar_Personales");
		itemFelicitar.setOnAction(event -> felicitar());
		
		
		
		menu2.getItems().addAll(itemBuscar, itemFelicitar);
		
		Menu menu3 = new Menu("Operaciones");
		barra.getMenus().add(menu3);

		itemAbout = new MenuItem("Importar");
		itemAbout.setOnAction(event -> about());
		
		
		
		
		menu2.getItems().addAll(itemBuscar, itemFelicitar);

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