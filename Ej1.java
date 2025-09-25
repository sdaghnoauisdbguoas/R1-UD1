
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Ej1{

public static void main(String[] args) {

    Properties property1 = new  Properties();

    property1.setProperty("nombre","wasiq");
    property1.setProperty("mesNacimiento","Diciembre");
    property1.setProperty("edad","17");

    try {
        FileOutputStream f1 = new FileOutputStream("probo.properties");
        property1.store(f1,"esto es un fichero");
    } catch (Exception e) {
        e.printStackTrace();
    }

    try {
        FileOutputStream f2 = new FileOutputStream("biggie.xml");
        property1.storeToXML(f2, "la de xml");

    } catch (Exception e) {
        e.printStackTrace();
    }

    Properties c1 = new Properties();
    try {
        FileInputStream r1 = new FileInputStream("probo.properties");
        c1.load(r1);
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("Estos es la edad: " + c1.getProperty("edad"));

    Properties c2 = new Properties();
    try {
        FileInputStream r2 = new FileInputStream("biggie.xml");
        c2.loadFromXML(r2);
    } catch (Exception e) {
    e.printStackTrace();
    }
    System.out.println("Esto la hemos cogido de xml.el nombre es:" + c2.getProperty("nombre"));


}


}