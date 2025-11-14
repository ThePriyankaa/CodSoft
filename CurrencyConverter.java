package codsoft;

import java.util.*;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🌍 Currency Converter");

        System.out.print("Enter base currency (e.g., USD, INR): ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter target currency: ");
        String target = sc.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        // Static exchange rates (for offline use)
        Map<String, Double> rates = new HashMap<>();
        rates.put("USDINR", 83.2);
        rates.put("INRUSD", 0.012);
        rates.put("USDEUR", 0.93);
        rates.put("EURUSD", 1.08);
        rates.put("INREUR", 0.011);
        rates.put("EURINR", 90.0);

        String key = base + target;
        if (rates.containsKey(key)) {
            double converted = amount * rates.get(key);
            System.out.println("\n💵 " + amount + " " + base + " = " + converted + " " + target);
        } else {
            System.out.println("⚠️ Conversion rate not available for " + base + " to " + target);
        }

        sc.close();
    }
}
