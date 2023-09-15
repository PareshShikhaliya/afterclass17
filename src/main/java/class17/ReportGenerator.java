package class17;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

interface Report {
    void generate();
}

class SalesReport implements Report {
    @Override
    public void generate() {
        System.out.println("Generating Sales Report...");
        // Implement sales report generation logic here
    }
}

class InventoryReport implements Report {
    @Override
    public void generate() {
        System.out.println("Generating Inventory Report...");
        // Implement inventory report generation logic here
    }
}

class ExpenseReport implements Report {
    @Override
    public void generate() {
        System.out.println("Generating Expense Report...");
        // Implement expense report generation logic here
    }
}

class EmployeeReport implements Report {
    @Override
    public void generate() {
        System.out.println("Generating Employee Report...");
        // Implement employee report generation logic here
    }
}

class ReportFactory {
    private static final Properties reportConfig = new Properties();

    static {
        try {
            reportConfig.load(new FileInputStream("C:\\Users\\pares\\IdeaProjects\\Serialization\\src\\main\\java\\class17\\report-config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Report createReport(String reportCode) {
        String className = reportConfig.getProperty(reportCode);
        if (className != null) {
            try {
                Class<?> reportClass = Class.forName(className);
                return (Report) reportClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

public class ReportGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the report code (or 'exit' to quit): ");
            String reportCode = scanner.nextLine();

            if (reportCode.equalsIgnoreCase("exit")) {
                break;
            }

            Report report = ReportFactory.createReport(reportCode);
            if (report != null) {
                report.generate();
            } else {
                System.out.println("Invalid report code: " + reportCode);
            }
        }
    }
}

