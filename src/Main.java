import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import model.Dependencies;
import reader.ReportReader;
import report.ReportCreator;

public class Main {


    public static void main(String[] args) throws JAXBException, IOException {

        final Dependencies result = new ReportReader().readReport();
        System.out.println(result);

        new ReportCreator().createReport(result);


    }

}
