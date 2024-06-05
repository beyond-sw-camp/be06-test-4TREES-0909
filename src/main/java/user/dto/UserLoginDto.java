//  서블릿에서 요청을 받아 user 데이터를 DAO로 전송하기 위해 사용하는 객체

package user.dto;

public class UserLoginDto {
    //클라이언트가 요청(HTTP)
    //요청 받기(뭔가 받아줄 애가 필요)
    //요청 처리(DB필요??)
    //- 디비 필요? => 나는 못해, DAO 니가 가서 가져우ㅏ
    // - DAO -> 디비갔다옴 이거 가져왔어~~
    //서블릿은 받아서 이쁘게 포장해서 고객이 원하는대로 돌려준다

    String userEmail;
    String userPassword;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
