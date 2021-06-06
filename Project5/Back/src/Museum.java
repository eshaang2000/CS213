public abstract class Museum {
    final int MAX_TICKETS = 5;
    double priceAdult;
    double priceChild;
    double priceStudent;
    public abstract double getPriceAdult();
    public abstract double getSalesTax();
    public abstract double getPriceSenior();
    public abstract double getPriceStudent();

}
