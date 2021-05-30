package ir.kamalkarimi.warehousing.dto;

public class InventoryDto {

    private ArticleDto []inventory;

    public InventoryDto() {
    }

    public ArticleDto[] getInventory() {
        return inventory;
    }

    public void setInventory(ArticleDto[] inventory) {
        this.inventory = inventory;
    }
}
