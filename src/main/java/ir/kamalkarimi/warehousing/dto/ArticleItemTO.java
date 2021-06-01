package ir.kamalkarimi.warehousing.dto;

public class ArticleItemTO {
    private Long articleId;
    private String amount;

    public ArticleItemTO() {
    }

    public ArticleItemTO(Long articleId, String amount) {
        this.articleId = articleId;
        this.amount = amount;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
