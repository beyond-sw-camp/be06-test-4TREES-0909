package groupbuy.dto;

public class GroupbuyDto {
    private Integer userIdx;
    private Integer categoryIdx;
    private String gpbyTitle;
    private String gpbyContent;
    private Integer gpbyQuantity;
    private Integer gpbyEnddate;

    public Integer getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Integer userIdx) {
        this.userIdx = userIdx;
    }

    public void setCategoryIdx(Integer categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    public void setGpbyTitle(String gpbyTitle) {
        this.gpbyTitle = gpbyTitle;
    }

    public void setGpbyContent(String gpbyContent) {
        this.gpbyContent = gpbyContent;
    }

    public void setGpbyQuantity(Integer gpbyQuantity) {
        this.gpbyQuantity = gpbyQuantity;
    }

    public void setGpbyEnddate(Integer gpbyEnddate) {
        this.gpbyEnddate = gpbyEnddate;
    }

    public Integer getCategoryIdx() {
        return categoryIdx;
    }

    public String getGpbyTitle() {
        return gpbyTitle;
    }

    public String getGpbyContent() {
        return gpbyContent;
    }

    public Integer getGpbyQuantity() {
        return gpbyQuantity;
    }

    public Integer getGpbyEnddate() {
        return gpbyEnddate;
    }
}
