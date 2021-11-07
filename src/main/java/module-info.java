module xyz.akopartem.encrypts {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;
    requires java.logging;


    opens xyz.akopartem.encrypts to javafx.fxml;
    exports xyz.akopartem.encrypts;
}