package bid.servlet;

import bid.dao.BidDao;
import bid.dto.BidDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.BaseResponse;
import config.BaseResponseMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/bid/regist")
public class BidRegistServlet extends HttpServlet {
    BidDao dao;
    ObjectMapper mapper;

    @Override
    public void init() {
        dao = new BidDao();
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
        // Map
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = objectMapper.readValue(json.toString(), new TypeReference<Map<String, Object>>() {
        });
        System.out.println(jsonMap);

        String jsonResponse;

        BidDto dto = mapper.readValue(json.toString(), BidDto.class);
        // 가격 미입력
        if(jsonMap.get("bidPrice") == null) {
            BaseResponse response = new BaseResponse(BaseResponseMessage.BID_REGIST_PRICE_EMPTY);
            jsonResponse = mapper.writeValueAsString(response);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(jsonResponse);
            return ;
        }
        // 상품 미입력
        if(jsonMap.get("productIdx") == null) {
            BaseResponse response = new BaseResponse(BaseResponseMessage.BID_REGIST_PRODUCT_EMPTY);
            jsonResponse = mapper.writeValueAsString(response);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(jsonResponse);
            return ;
        }

        // ------------------- 입찰 등록하는 Dao의 메소드 실행 -------------------
        Boolean result = dao.create(dto);


        // ------------------- Dao의 처리 결과에 따른 응답 설정 부분 -------------------
        if (result) {
            BaseResponse response = new BaseResponse(BaseResponseMessage.BID_REGIST_SUCCESS);
            jsonResponse = mapper.writeValueAsString(response);
        } else {
            BaseResponse response = new BaseResponse(BaseResponseMessage.BID_REGIST_FAIL);
            jsonResponse = mapper.writeValueAsString(response);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
    }
}
