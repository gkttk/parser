package report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import formatter.ReportDataFormatter;
import model.Dependencies;
import model.Dependency;
import model.Vulnerability;

public class ReportCreator {

    private final ReportDataFormatter reportDataFormatter;

    public ReportCreator() {

        this.reportDataFormatter = new ReportDataFormatter();
    }

    public void createReport(final Dependencies dependencies) throws IOException {

        FileWriter fWriter = new FileWriter("fileName.html");
        BufferedWriter writer = new BufferedWriter(fWriter);
        writer.write("<head>");
        writer.write("</link>");
        writer.write("<link rel=\"stylesheet\" href=\"src\\styles.css\">");
        writer.write("<script src=\"https://code.jquery.com/jquery-3.6.0.js\">");
        writer.write("</script>");
        writer.write("<script src=\"https://code.jquery.com/ui/1.13.1/jquery-ui.js\">");
        writer.write("</script>");
        writer.write("<script>$( function() {\n"
                + "    $( \"#accordion\" ).accordion({\n"
                + "      collapsible: true,"
                + "      active: false\n"
                + "    });\n"
                + "  } );</script>");
        writer.write("</head>");

        writer.write("<div id=\"accordion\">");
        writer.write("<h3>SECTION</h3>");
        writer.write("<div>");
        writer.write("<p>Text text text text</p>");
        writer.write("</div>");
        writer.write("</div>");

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
                    final String vulnerabilityCell = generateVulnerabilityCell(vulnerability);
                    writer.write(vulnerabilityCell);
                    final String severityCell = generateSeverityCell(vulnerability);
                    writer.write(severityCell);
                    final String weaknessCell = generateWeaknessCell(vulnerability);
                    writer.write(weaknessCell);

                    writer.write("</tr>");
                }
            }

            writer.write("</tr>");
        }

        writer.write("</table>");

        writer.close();

    }


    private String generateFileNameCell(final Dependency dependency) {

        return String.format("<td>%s</td>", dependency.getFileName());
    }


    private String generateVulnerabilityCell(final Vulnerability vulnerability) {

        final String source = vulnerability.getSource();
        final String name = vulnerability.getName();

        return String.format("<td>%s | %s</td>", source, name);
    }

    private String generateSeverityCell(final Vulnerability vulnerability) {

        final String severity = reportDataFormatter.formatSeverityData(vulnerability.getSeverity());
        return String.format("<td>%s</td>", severity);
    }

    private String generateWeaknessCell(final Vulnerability vulnerability) {

        final List<String> cwes = vulnerability.getCwes();
        String weakness = "";
        if (cwes != null && !cwes.isEmpty()) {
            weakness = vulnerability.getCwes().get(0);
        }

        return String.format("<td>%s</td>", weakness);
    }


}
