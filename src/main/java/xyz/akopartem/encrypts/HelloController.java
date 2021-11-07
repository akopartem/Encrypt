package xyz.akopartem.encrypts;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.logging.Logger;

public class HelloController {
    private static final Logger log = Logger.getLogger(HelloController.class.getName());

    @FXML
    private Label t;

    @FXML
    private TextArea ta;

    @FXML
    private VBox vbox;

    @FXML
    protected void onEnButtonClick() {
        String res = Encrypt.encryptString(ta.getText());
        StringSelection stringSelection = new StringSelection(res);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        t.setText("Зашифрованный текст скопирован.");
        log.info("Converted " + ta.getText() + " to " + res);
    }
    ContextMenu contextMenu = new ContextMenu();

    @FXML
    protected void onVBoxClick() {
        vbox.requestFocus();
        contextMenu.hide();
        stage.hide();
    }
    Stage stage = new Stage();

    protected void help() throws IOException {
        Parent root;
        try {
            root = FXMLLoader.load(HelloApplication.class.getResource("help-view.fxml"));
            stage.setTitle("Помощь");
            stage.setScene(new Scene(root, 200, 200));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void initialize() {
        javafx.scene.control.MenuItem item1 = new MenuItem("Помощь");
        item1.setOnAction(event -> System.out.println("s"));
        item1.setOnAction(actionEvent -> {
            try {
                help();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        contextMenu.getItems().addAll(item1);
        vbox.setOnContextMenuRequested(new EventHandler<>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(vbox, event.getScreenX(), event.getScreenY());
            }
        });

    }

    @FXML
    protected void clearT() {
        if (t.getText().equals("")) t.setText("");
    }

    @FXML
    protected void onDeButtonClick() {
        try {
            String res = Decrypt.decryptString(ta.getText().replaceAll("\n", ""));
            log.info("Converted " + ta.getText().replaceAll("\n", "") + " to " + res);
            ta.setText(res);
            t.setText("");
        } catch (Exception e) {
            log.info("Incorrect join (" + ta.getText() + ")");
            t.setText("Введите корректное значение.");
        }
    }
}