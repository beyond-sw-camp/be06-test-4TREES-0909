package bid.dto;

public class BidDto {
    private int productIdx;
    private int gpbyIdx;
    private int bidPrice;

    public BidDto() {
    }

    public BidDto(int productIdx, int gpbyIdx, int bidPrice) {
        this.productIdx = productIdx;
        this.gpbyIdx = gpbyIdx;
        this.bidPrice = bidPrice;
    }

    public int getProductIdx() {
        return productIdx;
    }

    public void setProductIdx(int productIdx) {
        this.productIdx = productIdx;
    }

    public int getGpbyIdx() {
        return gpbyIdx;
    }

    public void setGpbyIdx(int gpbyIdx) {
        this.gpbyIdx = gpbyIdx;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }
}
