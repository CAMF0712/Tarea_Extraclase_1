module calculadora.te1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens calculadora.te1 to javafx.fxml;
    exports calculadora.te1;
}