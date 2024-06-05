package user.servlet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.BaseResponse;
import user.dao.UserDao;
import user.dto.UserLoginDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

import static config.BaseResponseMessage.USER_LOGIN_FAIL;
import static config.BaseResponseMessage.USER_LOGIN_SUCCESS;


@WebServlet("/user/basic/login")
public class UserBasicLoginServlet extends HttpServlet {
    UserDao dao;
    ObjectMapper mapper;

    @Override
    public void init() {
        dao = new UserDao();
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ------------------- 클라이언트로부터 요청을 받아서 Dto에 저장하는 부분 -------------------
        BufferedReader reader = req.getReader();
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            json.append(line);

        }

        UserLoginDto dto = mapper.readValue(json.toString(), UserLoginDto.class);
        // 서버 http의 json형태의 데이터를 --> dto에 담을 수 있게 객체 형식으로 바꾼다.
        // ------------------- ------------------- -------------------


        // ------------------- 로그인 확인하는 Dao의 메소드 실행 -------------------
        //PostMemberLoginRes result = dao.find(dto);
        Boolean result = dao.find(dto) ;
        // 디비를 조회하고 로그인이 되어있는지 확인
        // ------------------- ------------------- -------------------


        // ------------------- Dao의 처리 결과에 따른 응답 설정 부분 -------------------
        String jsonResponse;
        if (result == true) {

            BaseResponse response = new BaseResponse(USER_LOGIN_SUCCESS);
            jsonResponse = mapper.writeValueAsString(response);
        } else {
            BaseResponse response = new BaseResponse(USER_LOGIN_FAIL);
            jsonResponse = mapper.writeValueAsString(response);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
        // ------------------- ------------------- -------------------

    }

}
