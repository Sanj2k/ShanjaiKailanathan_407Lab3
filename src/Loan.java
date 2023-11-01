public class Loan {
    private String type;
    private double amount;

    public Loan (String type, double amount){
        this.type = type;
        this.amount = amount;
    }
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double calculateTotalAmount(double baseRate) {
        double interestRate;
        if(type.equals("House Mortgage")){
            interestRate = baseRate + 0.01;
        }
        else if (type.equals("Car Loan")){
            interestRate = baseRate + 0.03;
        }
        else{
            interestRate = baseRate + 0.4;
        }
        return amount * (1 + interestRate);

    }
}
