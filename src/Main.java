import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Loan> loans = new ArrayList<>();
        double baseRate = 0.02;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Select an option:\n");
            System.out.print("1. Disburse a Loan\n");
            System.out.print("2. Show the list of all loans\n");
            System.out.print("3. Show sum of all loans\n");
            System.out.print("4. Exit\n");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Select Loan\n");
                    System.out.println("House Mortgage\n");
                    System.out.println("Car Loan\n");
                    System.out.println("Personal Loan\n");

                    int loanTypeChoice = scanner.nextInt();
                    String loanType;
                    double loanAmount;

                    switch (loanTypeChoice) {
                        case 1:
                            loanType = "House Mortgage";
                            break;
                        case 2:
                            loanType = "Car Loan";
                            break;
                        case 3:
                            loanType = "Personal Loan";
                            break;
                        default:
                            System.out.println("Invalid");
                            continue;
                    }

                    System.out.print("Enter your loan amount: ");
                    loanAmount = scanner.nextDouble();
                    loans.add(new Loan(loanType, loanAmount));
                    System.out.println("Loan disbursed");
                    break;

                case 2:
                    System.out.println("list of loans");
                    System.out.println("Type");
                    System.out.println("Amount");
                    System.out.println("Amount owed");

                    for(Loan loan : loans) {
                        double totalAmount = loan.calculateTotalAmount(baseRate);
                        System.out.printf("%s\t$%.2f\t$%.2f\n", loan.getType(),loan.getAmount(),totalAmount);
                    }
                    break;
                case 3:
                    double totalLoanAmount = 0;
                    for (Loan loan : loans) {
                        totalLoanAmount += loan.calculateTotalAmount(baseRate);
                    }
                    System.out.printf("Sum of all Loans\nAmount\t\tAmount owed\n$%.2f\t$%.2f\n", totalLoanAmount, totalLoanAmount);
                    break;
                case 4:
                    System.out.println("Thank you for Banking with with CityToronto Bank ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");

            }



        }
    }
}