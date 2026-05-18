package it.unicam.mdp_mgc_2026.interfaccegrafiche.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AllControlsDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("All JavaFX Controls Demo");

        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(
                createInputTab(),
                createSelectionTab(),
                createButtonsTab(),
                createMenusTab(),
                createContainersTab(),
                createMiscTab()
        );

        Scene scene = new Scene(tabPane, 800, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tab createInputTab() {
        GridPane grid = baseGrid();

        TextField textField = new TextField("Sample text");
        PasswordField passwordField = new PasswordField();
        TextArea textArea = new TextArea("Multiline text");
        Spinner<Integer> spinner = new Spinner<>(0, 10, 5);
        Slider slider = new Slider(0, 100, 50);
        ColorPicker colorPicker = new ColorPicker();
        DatePicker datePicker = new DatePicker();

        grid.add(new Label("TextField:"), 0, 0);      grid.add(textField, 1, 0);
        grid.add(new Label("PasswordField:"), 0, 1);  grid.add(passwordField, 1, 1);
        grid.add(new Label("TextArea:"), 0, 2);       grid.add(textArea, 1, 2);
        grid.add(new Label("Spinner:"), 0, 3);        grid.add(spinner, 1, 3);
        grid.add(new Label("Slider:"), 0, 4);         grid.add(slider, 1, 4);
        grid.add(new Label("ColorPicker:"), 0, 5);    grid.add(colorPicker, 1, 5);
        grid.add(new Label("DatePicker:"), 0, 6);     grid.add(datePicker, 1, 6);

        Tab tab = new Tab("Input", grid);
        tab.setClosable(false);
        return tab;
    }

    private Tab createSelectionTab() {
        VBox vbox = baseVBox();

        // ComboBox
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("One", "Two", "Three");
        comboBox.setValue("Two");

        // ChoiceBox
        ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList("Red", "Green", "Blue"));
        choiceBox.setValue("Green");

        // CheckBox
        CheckBox checkBox = new CheckBox("Enable option");
        checkBox.setSelected(true);

        // RadioButtons
        ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("A");
        RadioButton rb2 = new RadioButton("B");
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb1.setSelected(true);

        // ListView
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Alpha", "Beta", "Gamma");

        // TableView
        TableView<Person> tableView = new TableView<>();
        tableView.setItems(FXCollections.observableArrayList(
                new Person("Alice", 30), new Person("Bob", 25)
        ));
        TableColumn<Person, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Person, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableView.getColumns().addAll(nameCol, ageCol);

        vbox.getChildren().addAll(new Label("ComboBox:"), comboBox,
                new Label("ChoiceBox:"), choiceBox,
                checkBox,
                new Label("RadioButtons:"), rb1, rb2,
                new Label("ListView:"), listView,
                new Label("TableView:"), tableView);

        Tab tab = new Tab("Selection", new ScrollPane(vbox));
        tab.setClosable(false);
        return tab;
    }

    private Tab createButtonsTab() {
        VBox vbox = baseVBox();

        Button button = new Button("Click me");
        button.setOnAction(e -> button.setText("Clicked!"));

        ToggleButton toggleButton = new ToggleButton("Toggle");
        toggleButton.setOnAction(e -> {
            toggleButton.setText(toggleButton.isSelected() ? "On" : "Off");
        });

        Hyperlink link = new Hyperlink("Go somewhere");
        link.setOnAction(e -> link.setText("Clicked"));

        ButtonBar buttonBar = new ButtonBar();
        buttonBar.getButtons().addAll(new Button("OK"), new Button("Cancel"));

        vbox.getChildren().addAll(new Label("Button:"), button,
                new Label("ToggleButton:"), toggleButton,
                new Label("Hyperlink:"), link,
                new Label("ButtonBar:"), buttonBar);

        Tab tab = new Tab("Buttons", vbox);
        tab.setClosable(false);
        return tab;
    }

    private Tab createMenusTab() {
        VBox vbox = baseVBox();

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        fileMenu.getItems().addAll(new MenuItem("New"), new MenuItem("Open"), new SeparatorMenuItem(), new MenuItem("Exit"));
        Menu editMenu = new Menu("Edit");
        editMenu.getItems().addAll(new CheckMenuItem("Auto Save"), new RadioMenuItem("Mode A"));
        menuBar.getMenus().addAll(fileMenu, editMenu);

        ContextMenu contextMenu = new ContextMenu(new MenuItem("Copy"), new MenuItem("Paste"));
        TextField contextField = new TextField("Right-click me");
        contextField.setContextMenu(contextMenu);

        MenuButton menuButton = new MenuButton("Options", null,
                new MenuItem("Option 1"), new MenuItem("Option 2"));

        SplitMenuButton splitMenuButton = new SplitMenuButton();
        splitMenuButton.setText("Split Menu");
        splitMenuButton.getItems().addAll(new MenuItem("Item A"), new MenuItem("Item B"));

        vbox.getChildren().addAll(menuBar, contextField, menuButton, splitMenuButton);

        Tab tab = new Tab("Menus", vbox);
        tab.setClosable(false);
        return tab;
    }

    private Tab createContainersTab() {
        VBox vbox = baseVBox();

        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(
                new TitledPane("Section 1", new Label("Content A")),
                new TitledPane("Section 2", new Label("Content B"))
        );

        TabPane nestedTabs = new TabPane(
                new Tab("Tab A", new Label("Inside Tab A")),
                new Tab("Tab B", new Label("Inside Tab B"))
        );

        ScrollPane scrollPane = new ScrollPane(new TextArea("Scrollable content here..."));

        vbox.getChildren().addAll(new Label("Accordion:"), accordion,
                new Label("Nested TabPane:"), nestedTabs,
                new Label("ScrollPane:"), scrollPane);

        Tab tab = new Tab("Containers", vbox);
        tab.setClosable(false);
        return tab;
    }

    private Tab createMiscTab() {
        VBox vbox = baseVBox();

        ProgressBar progressBar = new ProgressBar(0.7);
        ProgressIndicator progressIndicator = new ProgressIndicator(0.4);
        Tooltip tooltip = new Tooltip("This is a tooltip");
        Button tooltipButton = new Button("Hover me");
        Tooltip.install(tooltipButton, tooltip);

        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMin(0);
        scrollBar.setMax(100);
        scrollBar.setValue(25);

        Pagination pagination = new Pagination(5);

        vbox.getChildren().addAll(new Label("ProgressBar:"), progressBar,
                new Label("ProgressIndicator:"), progressIndicator,
                new Label("Tooltip:"), tooltipButton,
                new Label("ScrollBar:"), scrollBar,
                new Label("Pagination:"), pagination);

        Tab tab = new Tab("Misc", vbox);
        tab.setClosable(false);
        return tab;
    }

    private GridPane baseGrid() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(15));
        return grid;
    }

    private VBox baseVBox() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(15));
        return vbox;
    }

    public static class Person {
        private final String name;
        private final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public Integer getAge() { return age; }
    }

    public static void main(String[] args) {
        launch(args);
    }
}