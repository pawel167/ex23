package com.example.demo8;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HelloController {

    private static DBService service = new DBService();
    private static List<empl> masterlist = FXCollections.observableArrayList();

    @FXML
    private TableColumn<empl, String > codet,fiot,razrt,salaryt;

    @FXML
    private TableView<empl> tablet;

    @FXML
    private TextField searchField;

    @FXML
    private ComboBox<String> sortCB,razrCB;

    @FXML
    void initialize(){
        codet.setCellValueFactory(new PropertyValueFactory<>("code"));
        fiot.setCellValueFactory(new PropertyValueFactory<>("fio"));
        razrt.setCellValueFactory(new PropertyValueFactory<>("razr"));
        salaryt.setCellValueFactory(new PropertyValueFactory<>("salary"));
        masterlist.addAll(service.findAll());

        razrCB.getItems().addFirst("Показать всё");
        Set<String> unique = new HashSet<>();
        for (var f : masterlist)
            unique.add(String.valueOf(f.getRazr()));
        razrCB.getItems().addAll(unique);

        sortCB.getItems().add(0,"По возрастанию");
        sortCB.getItems().add(1,"По убыванию");

        for (var f : new ComboBox[] {sortCB, razrCB})
            f.valueProperty().addListener((o,ov,on) -> filtered());

        searchField.textProperty().addListener((o,ov,on) -> filtered());
        filtered();
    }

    void filtered(){
        var search = searchField.getText();

        Comparator<empl> sorted = "По возрастанию".equals(sortCB.getValue())?
                Comparator.comparing(empl::getSalary) :
                Comparator.comparing(empl::getSalary).reversed();

        var result = masterlist.stream()
                .filter(x -> search.isEmpty() || x.getFio().toLowerCase().contains(search.toLowerCase()))
                .filter(x -> {
                    if (razrCB.getValue() == null || razrCB.getValue().isBlank())
                        return true;
                    if (razrCB.getValue().equals("Показать всё"))
                        return true;

                    return razrCB.getValue().isBlank() || x.getRazr() == Integer.parseInt(razrCB.getValue());
                })
                .sorted(sorted)
                .toList();

        tablet.getItems().setAll(result);
    }
}
