package calculadora.te1;

public class Persona { //Declaración de la clase Persona

    //Declaración de los atributos de los objetos Persona
    private String name;
    private String province;
    private double old;

    public Persona(String name, String province, int old){ //Declaración del constructor
        this.name = name;
        this.province = province;
        this.old = old;
    }

    //Declaración de los métodos .get necesarios
    public double getOld(){
        return this.old;
    }
    public String getName(){
        return this.name;
    }

}
