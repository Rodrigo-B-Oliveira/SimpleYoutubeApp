/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.bandeiraoliveira.youtubeapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Rodrigo
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private WebView webView;
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void search(ActionEvent event) {
        try {
            errorLabel.setText("");
            String videoId = Search.query(searchField.getText());
            switch (videoId) {
                case "" ->
                    webView.getEngine().load("https://www.youtube.com/results?search_query");
                default ->
                    webView.getEngine().load("https://www.youtube.com/watch?v=" + videoId);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            errorLabel.setText(e.getMessage());
        }

    }
}
