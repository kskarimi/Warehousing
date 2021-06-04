package ir.kamalkarimi.warehousing.dto;

public class InventoryTO {

    private String name;

    private Integer amount;

    private boolean isAvailable;

    public InventoryTO() {
        this(null,null,false);
    }

    public InventoryTO(String name, Integer amount, boolean isAvailable) {
        this.name = name;
        this.amount = amount;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
