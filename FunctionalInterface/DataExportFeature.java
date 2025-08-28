package FunctionalInterface;

interface ReportExporter {
    void exportCSV(String data);
    void exportPDF(String data);

    // New feature (default implementation)
    default void exportJSON(String data) {
        System.out.println("JSON export not yet supported.");
    }
}

class SalesReportExporter implements ReportExporter {
    @Override
    public void exportCSV(String data) {
        System.out.println("Exported Sales Report as CSV: " + data);
    }

    @Override
    public void exportPDF(String data) {
        System.out.println(" Exported Sales Report as PDF: " + data);
    }

    // Override to support JSON
    @Override
    public void exportJSON(String data) {
        System.out.println("Exported Sales Report as JSON: { \"report\": \"" + data + "\" }");
    }
}

public class DataExportFeature {
    public static void main(String[] args) {
        ReportExporter exporter = new SalesReportExporter();

        exporter.exportCSV("Q1 Revenue = $5000");
        exporter.exportPDF("Q1 Revenue = $5000");
        exporter.exportJSON("Q1 Revenue = $5000");
    }
}

