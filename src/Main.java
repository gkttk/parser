import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import model.Dependencies;
import reader.ReportReader;

public class Main {


    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        final Dependencies result = new ReportReader().readReport();
        System.out.println(result);


    }

}
