public class Met extends Museum{

    public static void main(String args[]){
        Met obj = new Met();
        System.out.println(obj);
    }

    @Override
    public double getPriceAdult() {
        return 10;
    }

    @Override
    public double getSalesTax() {
        return 0;
    }

    @Override
    public double getPriceSenior() {
        return 20;
    }

    @Override
    public double getPriceStudent() {
        return 30;
    }
}
