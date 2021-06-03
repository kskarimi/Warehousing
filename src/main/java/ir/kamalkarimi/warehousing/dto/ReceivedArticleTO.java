package ir.kamalkarimi.warehousing.dto;

import java.util.List;

public class ReceivedArticleTO {

    private List<ArticleTO> inventory;

    public ReceivedArticleTO() {
    }

    public List<ArticleTO> getInventory() {
        return inventory;
    }

    public void setInventory(List<ArticleTO> inventory) {
        this.inventory = inventory;
    }
}
