import java.time.LocalDate;

public class Products {
    public Products(String name, double price, double buyPrice, LocalDate ExpDate, int quantity) {
      this.name = name;
      this.price = price;
      this.ExpDate = ExpDate;
      this.quantity = quantity;
      this.buyPrice = buyPrice;
    }


    private String name;
    private double price;
    private LocalDate ExpDate;
    private int quantity;
    private double buyPrice;

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpDate() {
        return ExpDate;
    }

    public void setExpDate(LocalDate expDate) {
        ExpDate = expDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


