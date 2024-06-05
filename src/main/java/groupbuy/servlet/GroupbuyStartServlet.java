package groupbuy.servlet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.BaseResponse;
import config.BaseResponseMessage;
import groupbuy.dao.GroupbuyDao;
import groupbuy.dto.GroupbuyIdxDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/groupbuy/start")
public class GroupbuyStartServlet extends HttpServlet {
    GroupbuyDao groupbuyDao;
    ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        groupbuyDao = new GroupbuyDao();
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        GroupbuyIdxDto dto = mapper.readValue(json.toString(), GroupbuyIdxDto.class);

        Boolean result = groupbuyDao.start(dto);

        String jsonResponse;
        if (result) {
            BaseResponse response = new BaseResponse(BaseResponseMessage.GROUPBUY_START_SUCCESS);
            jsonResponse = mapper.writeValueAsString(response);
        } else {
            BaseResponse response = new BaseResponse(BaseResponseMessage.GROUPBUY_START_FAIL);
            jsonResponse = mapper.writeValueAsString(response);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);

    }
}
