package ir.kamalkarimi.warehousing.dto;

public class InventoryTO {

    private ArticleTO[]inventory;

    public InventoryTO() {
    }

    public ArticleTO[] getInventory() {
        return inventory;
    }

    public void setInventory(ArticleTO[] inventory) {
        this.inventory = inventory;
    }
}
