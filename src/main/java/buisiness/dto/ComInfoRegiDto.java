package buisiness.dto;

public class ComInfoRegiDto {
    String comInfoName;
    String comInfoAddress;
    String comInfoType;
    String comInfoIntro;
    Integer companyIdx;


    public ComInfoRegiDto() {

    }

    @Override
    public String toString() {
        return "ComInfoRegiDto{" +
                "comInfoName='" + comInfoName + '\'' +
                ", comInfoAddress='" + comInfoAddress + '\'' +
                ", comInfoType='" + comInfoType + '\'' +
                ", comInfoIntro='" + comInfoIntro + '\'' +
                ", companyIdx=" + companyIdx +
                '}';
    }

    public ComInfoRegiDto(String comInfoName, String comInfoAddress, String comInfoType, String comInfoIntro, Integer companyIdx) {
        this.comInfoName = comInfoName;
        this.comInfoAddress = comInfoAddress;
        this.comInfoType = comInfoType;
        this.comInfoIntro = comInfoIntro;
        this.companyIdx = companyIdx;
    }

    public String getComInfoName() {
        return comInfoName;
    }

    public void setComInfoName(String comInfoName) {
        this.comInfoName = comInfoName;
    }

    public String getComInfoAddress() {
        return comInfoAddress;
    }

    public void setComInfoAddress(String comInfoAddress) {
        this.comInfoAddress = comInfoAddress;
    }

    public String getComInfoType() {
        return comInfoType;
    }

    public void setComInfoType(String comInfoType) {
        this.comInfoType = comInfoType;
    }

    public String getComInfoIntro() {
        return comInfoIntro;
    }

    public void setComInfoIntro(String comInfoIntro) {
        this.comInfoIntro = comInfoIntro;
    }

    public Integer getCompanyIdx() {
        return companyIdx;
    }

    public void setCompanyIdx(Integer companyIdx) {
        this.companyIdx = companyIdx;
    }
}
