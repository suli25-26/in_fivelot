package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DialogController {

    @FXML
    void onClickBackButton(ActionEvent event) {
        App.setRoot("mainScene");
    }

}
