package ir.kamalkarimi.warehousing.dto;

public class ArticleItemDto {
    private Long articleId;
    private String amount;

    public ArticleItemDto() {
    }

    public ArticleItemDto(Long articleId, String amount) {
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
