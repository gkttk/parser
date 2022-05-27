package reader;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import model.Dependencies;

public class ReportReader {


    public Dependencies readReport() throws JAXBException, FileNotFoundException {

//        JAXBContext jaxbContext = JAXBContext.newInstance(Dependencies.class);
//        JAXBContextImpl context = new JAXBContextBuilder().
//                setDefaultNsUri("https://jeremylong.github.io/DependencyCheck/dependency-check.2.5.xsd")
//                .build();

        JAXBContext context = JAXBContext.newInstance(Dependencies.class);

        return (Dependencies) context.createUnmarshaller()
                .unmarshal(new FileReader("src/dependency-check-report_full.xml"));

//        JAXBContext context = JAXBContext.newInstance(Dependency.class);
//        return (Dependency) context.createUnmarshaller()
//                .unmarshal(new FileReader("C:\\custom\\parser\\src\\dependency.xml"));

    }

}
