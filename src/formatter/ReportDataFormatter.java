package formatter;

public class ReportDataFormatter {


    public String formatSeverityData(final String data) {

        if (data == null || data.isEmpty()) {
            return data;
        }

        return data.substring(0, 1).toUpperCase() + data.substring(1).toLowerCase();
    }


}
