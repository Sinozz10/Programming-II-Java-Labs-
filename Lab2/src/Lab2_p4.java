import java.io.*;
import java.util.*;

public class Lab2_p4 {

    //Update the invoice count in the file
    private static void updateInvoiceCount(String fileName, int newCount) {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                Scanner fileScanner = new Scanner(file);

                //Read all lines
                StringBuilder content = new StringBuilder();
                fileScanner.nextLine();
                while (fileScanner.hasNextLine()) {
                    content.append(fileScanner.nextLine()).append("\n");
                }
                fileScanner.close();

                //Updated count
                FileWriter fw = new FileWriter(fileName);
                PrintWriter pw = new PrintWriter(fw);
                pw.print(newCount + "\n" + content.toString().trim());
                pw.close();
                fw.close();

            } catch (IOException e) {
                System.out.println("Error updating invoice count: " + e.getMessage());
            }
        } else {
            System.out.println("Error: File does not exist, cannot update count.");
        }
    }


    public static Invoice[] readInvoiceDetailsFromFile(String fileName) {
        Invoice[] invoices = null;

        File file = new File(fileName);

        // Show the absolute path where program is looking for the file
        //System.out.println("Looking for file at: " + file.getAbsolutePath());

        if (file.exists()) {
            try {
                Scanner fileScanner = new Scanner(file);
                int numInvoices = fileScanner.nextInt();
                fileScanner.nextLine();
                invoices = new Invoice[numInvoices];

                //To Read each invoice
                for (int i = 0; i < numInvoices; i++) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");

                    //Converts first num
                    int invoiceNumber = Integer.parseInt(parts[0]);

                    String customerName = parts[1];

                    //Convert Prices
                    int num=Integer.parseInt(parts[2]);
                    double[] prices = new double[num];
                    for (int j = 0; j < num; j++) {
                        prices[j] = Double.parseDouble(parts[j+3]);
                    }

                    invoices[i] = new Invoice(invoiceNumber, customerName, prices);
                }
                fileScanner.close();
                System.out.println("File read successfully!!");
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("Error: File not found - " + fileName);
            //System.out.println("Create the file at: " + file.getAbsolutePath());
        }

        return invoices;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "invoice.txt"; //To Prevent Spelling Mistakes with file writing
        System.out.println("Reading from file: " + fileName);

        // Load invoices.
        Invoice[] invoices = readInvoiceDetailsFromFile(fileName);

        if (invoices != null) {
            // Sort the array by total cost (after discount) in descending order.
            Arrays.sort(invoices, new Comparator<Invoice>() {
                @Override
                public int compare(Invoice i1, Invoice i2) {
                    double cost1 = i1.calculateInvoice();
                    double cost2 = i2.calculateInvoice();
                    return Double.compare(cost2, cost1); //Using Descending.
                }
            });

            System.out.println("\n===== Sorted Invoices (by total cost after discount) =====");
            for (int i = 0; i < invoices.length; i++) {
                invoices[i].report();
                System.out.println("--------------------");
            }

            // Ask user if they want to add a new invoice
            System.out.print("\nDo you want to add a new invoice? (yes/no)(y/n): ");
            String choice = scanner.nextLine().toLowerCase().trim();

            if (choice.equals("yes") || choice.equals("y")) {
                System.out.println("============= Add New Invoice =============");
                System.out.print("Enter invoice number: ");
                int newInvoiceNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter customer name: ");
                String newCustomerName = scanner.nextLine();
                System.out.print("Enter prices separated by ',' : ");
                String pricesInput = scanner.nextLine();
                String[] priceStrings = pricesInput.split(",");
                double[] newPrices = new double[priceStrings.length];

                for (int i = 0; i < priceStrings.length; i++) {
                    newPrices[i] = Double.parseDouble(priceStrings[i].trim());
                }

                // Append the new invoice to the file.
                File Appender = new File( fileName);
                if (Appender.exists()) {
                    try {
                        //Append
                        FileWriter fw = new FileWriter(fileName, true);
                        PrintWriter pw = new PrintWriter(fw);

                        // Write the new invoice data in file.
                        pw.print("\n" + newInvoiceNumber + "," + newCustomerName + "," + newPrices.length);
                        for (int i = 0; i < newPrices.length; i++) {
                            pw.print("," + newPrices[i]);
                        }
                        pw.close();
                        fw.close();

                        System.out.println("\nNew invoice added successfully to " + fileName);

                        // Update the first line with new count
                        updateInvoiceCount(fileName, invoices.length + 1);

                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }
                } else {
                    System.out.println("Error: File does not exist, cannot append.");
                }
            } else {
                System.out.println("\nNo new invoice added.\n GoodBYE! ");
            }
        }

    }
}