import java.text.DecimalFormat;

class Candle {

    String name;
    int quantity;
    double burnTime;
    double dollarPerBurnTime;
    double price;

    public Candle(String name, int quantity, double burnTime, double price) {
        this.name = name;
        this.quantity = quantity;
        this.burnTime = burnTime;
        this.price = price;
        this.dollarPerBurnTime = price / burnTime;
    }

    public double getSubtotal() {
        return price * quantity;
    }

}

public class Main {

    public static void main(String[] args) {

        Candle candle1 = new Candle("Luscious Lavender", 3, 5, 7.50);
        Candle candle2 = new Candle("Fragrant Floral's", 5, 7, 18.75);
        Candle candle3 = new Candle("Spicy N' Dicey", 2, 12, 11.98);

        Candle candle4 = new Candle("Ocean Breeze", 4, 8, 14.99);
        Candle candle5 = new Candle("Sweet Serenity", 1, 10, 9.99);

        int totalBurnTime = calculateTotalBurnTime(candle1, candle2, candle3, candle4, candle5);
        double totalDollarPerBurnTime = calculateTotalDollarPerBurnTime(candle1, candle2, candle3, candle4, candle5);
        double totalPrice = calculateTotalPrice(candle1, candle2, candle3, candle4, candle5);

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedTotalDollarPerBurnTime = df.format(totalDollarPerBurnTime);

        printReceipt(candle1, candle2, candle3, candle4, candle5,
                totalBurnTime, formattedTotalDollarPerBurnTime, totalPrice);

    }

    public static int calculateTotalBurnTime(Candle... candles) {
        int total = 0;
        for (Candle c : candles) {
            total += c.burnTime * c.quantity;
        }
        return total;
    }

    public static double calculateTotalDollarPerBurnTime(Candle... candles) {
        double total = 0;
        for (Candle c : candles) {
            total += c.price;
        }
        return total / calculateTotalBurnTime(candles);
    }

    public static double calculateTotalPrice(Candle... candles) {
        double total = 0;
        for (Candle c : candles) {
            total += c.getSubtotal();
        }
        return total;
    }

    public static void printReceipt(Candle... candles,
                                    int totalBurnTime,
                                    String formattedTotalDollarPerBurnTime,
                                    double totalPrice) {

        System.out.println("Receipt\n");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (Candle c : candles) {
            System.out.println(c.name);
            // Print other properties
        }

        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        System.out.println("Total Burn Time: " + totalBurnTime);
        System.out.println("Total Dollar per Burn Time: $" + formattedTotalDollarPerBurnTime);
        System.out.println("Total Price: $" + totalPrice);

    }

}
