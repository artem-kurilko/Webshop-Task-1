import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // считывание аргументов
        int amount = Integer.parseInt(args[0]);
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(args[1]));
        Type type = Type.valueOf(args[2]);

        BigDecimal totalPrice = calculateTotalPrice(amount, price, type);

        System.out.println(totalPrice + " DKK");
    }

    // метод для расчета полной цены
    private static BigDecimal calculateTotalPrice(int amount, BigDecimal price, Type type) {

        BigDecimal totalPrice = BigDecimal.valueOf(0);
        totalPrice = totalPrice.add(price.multiply(BigDecimal.valueOf(amount)));

        switch (type) {
            case online: {
                return totalPrice;
            }

            case book: {
                int freight;

                if (amount <= 10) {
                    freight = 50;
                } else {
                    freight = 50 + (int) Math.ceil((amount-10)/10.0) * 25;
                }

                return totalPrice.add(BigDecimal.valueOf(freight));
            }

            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}