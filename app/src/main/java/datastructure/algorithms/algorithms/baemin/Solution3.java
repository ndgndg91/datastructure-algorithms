package datastructure.algorithms.algorithms.baemin;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution3 {

    public String[] solution(String[] productInfo, String[] dailyProductSales) {
        Map<String, Product> productMap = Arrays.stream(productInfo).map(Product::new)
                .collect(Collectors.toMap(Product::getId, p -> p));
        return Arrays.stream(dailyProductSales)
                .map(DailyProductSale::new)
                .map(d -> {
                    Product product = productMap.get(d.getId());
                    StringBuilder builder = new StringBuilder();
                    return builder.append(d.getDate())
                            .append(",")
                            .append(d.getId())
                            .append(",")
                            .append(product.getName())
                            .append(",")
                            .append(product.getPrice() * d.getQuantity())
                            .toString();
                }).toArray(String[]::new);
    }

    static class Product {
        private final String id;
        private final String name;
        private final int price;

        Product(String info) {
            String[] split = info.split(",");
            this.id = split[0];
            this.name = split[1];
            this.price = Integer.parseInt(split[2]);
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Product product = (Product) o;

            if (price != product.price) return false;
            if (!Objects.equals(id, product.id)) return false;
            return Objects.equals(name, product.name);
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + price;
            return result;
        }
    }

    static class DailyProductSale {
        private final String date;
        private final String id;
        private final int quantity;

        public DailyProductSale(String info) {
            String[] split = info.split(",");
            this.date = split[0];
            this.id = split[1];
            this.quantity = Integer.parseInt(split[2]);
        }

        public String getDate() {
            return date;
        }

        public String getId() {
            return id;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DailyProductSale that = (DailyProductSale) o;

            if (quantity != that.quantity) return false;
            if (!Objects.equals(date, that.date)) return false;
            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
            int result = date != null ? date.hashCode() : 0;
            result = 31 * result + (id != null ? id.hashCode() : 0);
            result = 31 * result + quantity;
            return result;
        }
    }
}