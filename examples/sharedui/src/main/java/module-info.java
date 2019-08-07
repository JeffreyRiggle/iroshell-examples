module ilusr.examples {
    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires ilusr.core;
    requires ilusr.iroshell;

    exports examples.sharedui;
}