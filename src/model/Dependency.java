package model;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "dependency")
public class Dependency {

    private String fileName;
    private String filePath;
    private List<Vulnerability> vulnerabilities;

    public String getFileName() {

        return fileName;
    }

    @XmlElement(name = "fileName", namespace = "https://jeremylong.github.io/DependencyCheck/dependency-check.2.5.xsd")
    public void setFileName(final String fileName) {

        this.fileName = fileName;
    }

    public String getFilePath() {

        return filePath;
    }

    @XmlElement(name = "filePath", namespace = "https://jeremylong.github.io/DependencyCheck/dependency-check.2.5.xsd")
    public void setFilePath(final String filePath) {

        this.filePath = filePath;
    }

    public List<Vulnerability> getVulnerabilities() {

        return vulnerabilities;
    }

    @XmlElementWrapper(name = "vulnerabilities", namespace = "https://jeremylong.github.io/DependencyCheck/dependency-check.2.5.xsd")
    @XmlElement(name = "vulnerability", namespace = "https://jeremylong.github.io/DependencyCheck/dependency-check.2.5.xsd")
    public void setVulnerabilities(final List<Vulnerability> vulnerabilities) {

        this.vulnerabilities = vulnerabilities;
    }

    @Override
    public String toString() {

        return "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", vulnerabilities=" + vulnerabilities;
    }
}
