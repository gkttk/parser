package report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.Dependencies;
import model.Dependency;
import model.Vulnerability;

public class ReportCreator {


    public void createReport(final Dependencies dependencies) throws IOException {

        FileWriter fWriter = new FileWriter("fileName.html");
        BufferedWriter writer = new BufferedWriter(fWriter);
        writer.write("<table>");
        writer.write("<tr><th>File Name</th><th>Vulnerability</th><th>Severity</th><th>Weakness</th></tr>");

        for (final Dependency dependency : dependencies.getDependencies()) {

            List<Vulnerability> vulnerabilities = dependency.getVulnerabilities();

            //todo
            if (vulnerabilities != null && !vulnerabilities.isEmpty()) {
                writer.write("<tr>");
                for (Vulnerability vulnerability : vulnerabilities) {
                    final String fileNameCell = generateFileNameCell(dependency);
                    writer.write(fileNameCell);
                    String source = vulnerability.getSource();
                    String name = vulnerability.getName();

                    final String vulnerabilityCell = String.format("<td>%s | %s<td>", source, name);
                    writer.write(vulnerabilityCell);
                    writer.write("</tr>");
                }
            }

            //  writer.newLine(); //this is not actually needed for html files - can make your code more readable though

            writer.write("</tr>");
        }

        writer.write("</table>");

        writer.close(); //make sure you close the writer object

    }


    private String generateFileNameCell(final Dependency dependency) {

        return String.format("<td>%s</td>", dependency.getFileName());
    }

    private String generateLine(final Dependency dependency) {

        String fileName = dependency.getFileName();
        String filePath = dependency.getFilePath();

        return String.format("<li>FileName: %s | FilePath: %s</li>", fileName, filePath);
    }

}
