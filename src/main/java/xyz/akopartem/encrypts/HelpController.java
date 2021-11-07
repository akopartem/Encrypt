package xyz.akopartem.encrypts;

import javafx.fxml.FXML;

import java.awt.Desktop;
import java.net.URI;
import java.awt.*;

public class HelpController {
    @FXML
    private Label tg;

    @FXML
    protected void onTgClick() {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://t.me/akopartem"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}