package calculadora.te1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 */

public class controller
implements Initializable {
    @FXML //Declaración de las variables globales necesarias en los metodos
    public Label l_fail;
    public Label l_result;
    public ComboBox cmbx_prov;
    public ComboBox cmbx_per1;
    public ComboBox cmbx_per2;
    public TextField tf_name;
    public TextField tf_old;
    public List operators = new ArrayList<Persona>();
    public List operatorsName = new ArrayList<Persona>();
    public ObservableList<Persona> addPer;
    public int counter = 0;
    public int op1 = 4;
    public int op2 = 4;
    public double result;

    @Override //Declaración del método para generar la lista de provincias para el DDL
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> provinces = FXCollections.observableArrayList("San José", "Alajuela", "Cartago", "Heredia", "Guanacaste", "Puntarenas", "Limón");
        cmbx_prov.setItems(provinces);
    }


    public void addPerson(ActionEvent actionEvent) { //Declaración de la función para añadir objetos Persona

        String name = tf_name.getText();
        Object province = cmbx_prov.getSelectionModel().getSelectedItem();
        String old = tf_old.getText();


        if (name != null && province != null && old != null){ //Valida que los espacios de los atributos para la persona estén llenos

            if (counter <4){
                if(Integer.parseInt(old) != 0){
                    Persona persona = new Persona(name, province.toString(), Integer.parseInt(old));
                    operators.add(persona); //Añade a una lista los objetos creados
                    operatorsName.add(persona.getName()); //Añade a una lista los nombres de los objetos creados
                    counter ++;
                    l_fail.setVisible(false);
                    addPer = FXCollections.observableArrayList(operatorsName);
                    cmbx_per1.setItems(addPer);
                    cmbx_per2.setItems(addPer);
                    //Se añaden al DDL de los operandos para poder seleccionarlos
                }
                else {
                    l_fail.setVisible(true);
                    l_fail.setText("La edad debe ser distinta de cero");
                    //Valida que la edad sea distinta de cero
                }

            }else {
                l_fail.setVisible(true);
                l_fail.setText("Máximo número de personas creadas alcanzado");
                //Valida que solo puedan ser creadas 4 personas
            }

        }else{
            l_fail.setVisible(true);
            l_fail.setText("Debe indicar todos los atributos de la persona a crear \n el nombre debe ser" +
                    " una cadena, la provincia debe seleccionarla \ny la edad debe ser un entero distinto de cero");
            //Valida que las entradas sean como corresponde
        }

    }


    public void div(ActionEvent actionEvent) { //Declaración de la función para dividir
        if(cmbx_per1.getSelectionModel().getSelectedItem() != null && cmbx_per2.getSelectionModel().getSelectedItem() != null){
            op1 = cmbx_per1.getSelectionModel().getSelectedIndex();
            op2 = cmbx_per2.getSelectionModel().getSelectedIndex();
            Persona ope1 = (Persona) operators.get(op1);
            Persona ope2 = (Persona) operators.get(op2);
            //Se obtienen los valores de los DDL de los operadores
            result = ope1.getOld() / ope2.getOld();
            l_result.setText("Resultado: " + Math.round(ope1.getOld()) + " / " + Math.round(ope2.getOld()) + " = " + result);
            l_fail.setVisible(false);
        }
        else{
            l_fail.setVisible(true);
            l_fail.setText("Debe seleccionar las personas para realizar las operaciones");
            //Valida que los operandos estén seleccionados
        }
    }

    public void mult(ActionEvent actionEvent) { //Declaración de la función para multiplicar
        if(cmbx_per1.getSelectionModel().getSelectedItem() != null && cmbx_per2.getSelectionModel().getSelectedItem() != null){
            op1 = cmbx_per1.getSelectionModel().getSelectedIndex();
            op2 = cmbx_per2.getSelectionModel().getSelectedIndex();
            Persona ope1 = (Persona) operators.get(op1);
            Persona ope2 = (Persona) operators.get(op2);
            //Se obtienen los valores de los DDL de los operadores
            result = ope1.getOld() * ope2.getOld();
            l_result.setText("Resultado: " + Math.round(ope1.getOld()) + " X " + Math.round(ope2.getOld()) + " = " + Math.round(result));
            l_fail.setVisible(false);
        }
        else{
            l_fail.setVisible(true);
            l_fail.setText("Debe seleccionar las personas para realizar las operaciones");
            //Valida que los operandos estén seleccionados
        }
    }

    public void sub(ActionEvent actionEvent) { //Declaración de la función para restar
        if(cmbx_per1.getSelectionModel().getSelectedItem() != null && cmbx_per2.getSelectionModel().getSelectedItem() != null){
            op1 = cmbx_per1.getSelectionModel().getSelectedIndex();
            op2 = cmbx_per2.getSelectionModel().getSelectedIndex();
            Persona ope1 = (Persona) operators.get(op1);
            Persona ope2 = (Persona) operators.get(op2);
            //Se obtienen los valores de los DDL de los operadores
            result = ope1.getOld() - ope2.getOld();
            l_result.setText("Resultado: " + Math.round(ope1.getOld()) + " - " + Math.round(ope2.getOld()) + " = " + Math.round(result));
            l_fail.setVisible(false);
        }
        else{
            l_fail.setVisible(true);
            l_fail.setText("Debe seleccionar las personas para realizar las operaciones");
            //Valida que los operandos estén seleccionados
        }
    }

    public void add(ActionEvent actionEvent) { //Declaración de la función para sumar
        if(cmbx_per1.getSelectionModel().getSelectedItem() != null && cmbx_per2.getSelectionModel().getSelectedItem() != null){
            op1 = cmbx_per1.getSelectionModel().getSelectedIndex();
            op2 = cmbx_per2.getSelectionModel().getSelectedIndex();
            Persona ope1 = (Persona) operators.get(op1);
            Persona ope2 = (Persona) operators.get(op2);
            //Se obtienen los valores de los DDL de los operadores
            result = ope1.getOld() + ope2.getOld();
            l_result.setText("Resultado: " + Math.round(ope1.getOld()) + " + " + Math.round(ope2.getOld()) + " = " + Math.round(result));
            l_fail.setVisible(false);
        }
        else{
            l_fail.setVisible(true);
            l_fail.setText("Debe seleccionar las personas para realizar las operaciones");
            //Valida que los operandos estén seleccionados
        }
    }
}