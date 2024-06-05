package groupbuy.dto;

public class GroupbuyDto {
    private Integer gpbyIdx;
    private String gpbyTitle;
    private Integer gpbyQuantity;

    public GroupbuyDto(Integer gpbyIdx, String gpbyTitle, Integer gpbyQuantity) {
        this.gpbyIdx = gpbyIdx;
        this.gpbyTitle = gpbyTitle;
        this.gpbyQuantity = gpbyQuantity;
    }

    public Integer getGpbyIdx() {
        return gpbyIdx;
    }

    public void setGpbyIdx(Integer gpbyIdx) {
        this.gpbyIdx = gpbyIdx;
    }

    public String getGpbyTitle() {
        return gpbyTitle;
    }

    public void setGpbyTitle(String gpbyTitle) {
        this.gpbyTitle = gpbyTitle;
    }

    public Integer getGpbyQuantity() {
        return gpbyQuantity;
    }

    public void setGpbyQuantity(Integer gpbyQuantity) {
        this.gpbyQuantity = gpbyQuantity;
    }
}
