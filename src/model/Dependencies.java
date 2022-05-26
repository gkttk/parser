package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "analysis", namespace = "https://jeremylong.github.io/DependencyCheck/dependency-check.2.5.xsd")
public class Dependencies {

    private List<Dependency> dependencies;

    public List<Dependency> getDependencies() {

        return dependencies;
    }

    @XmlElementWrapper(name = "dependencies", namespace = "https://jeremylong.github.io/DependencyCheck/dependency-check.2.5.xsd")
    @XmlElement(name = "dependency", namespace = "https://jeremylong.github.io/DependencyCheck/dependency-check.2.5.xsd")
    public void setDependencies(final List<Dependency> dependencies) {

        this.dependencies = dependencies;
    }

}
