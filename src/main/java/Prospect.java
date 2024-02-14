public class Prospect {
    private String name;
    private double loanAmount;
    private float interestRate;
    private int years;

    public Prospect(String name, double loanAmount, float interestRate, int years) {
        this.name = name;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.years = years;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
