package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MainController {
    int n = 90;
    CheckBox[] boxes = new CheckBox[n];

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField selectedSlots;    

    @FXML
    void initialize() {
        this.initCheckBoxes();
    }

    void initCheckBoxes() {
        for(int i=0; i<n; i++) {
            boxes[i] = new CheckBox();
            boxes[i].setText(String.valueOf(i + 1));
            boxes[i].selectedProperty()
            .addListener((observable, oldValue, newValue) -> {
                int count = this.countSelected();
                this.selectedSlots.setText(String.valueOf(count));
            });

            gridPane.add(boxes[i], i % 6, i / 6);
            
        }
    }

    @FXML
    void onClickSaveButton(ActionEvent event) {
        this.startSave();
    }

    void startSave() {
        System.out.println(countSelected());
        if(countSelected() == 5) {
            System.out.println("Mentés...");
            Storage.write(generateLine());
        }else {
            System.err.println("Hiba! 5 számot kell megjelölni!");
        }
    }

    int countSelected() {
        int count = 0;
        for(CheckBox box: boxes) {
            if(box.isSelected()) {
                count++;
            }
        }
        return count;
    }

    String generateLine() {
        StringBuilder sb = new StringBuilder();
        for(CheckBox box :boxes) {
            if(box.isSelected()) {
                sb.append(box.getText());
                sb.append(",");
            }
        }
        return sb.toString();
    }

}
