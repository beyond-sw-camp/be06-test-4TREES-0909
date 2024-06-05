package groupbuy.servlet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.BaseResponse;
import config.BaseResponseMessage;
import groupbuy.dao.GroupbuyDao;
import groupbuy.dto.GroupbuyDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/groupbuy/regist")
public class GroupbuyRegistServlet extends HttpServlet {
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
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        StringBuilder json = new StringBuilder();
        String requestBody;
        while ((requestBody = reader.readLine()) != null) {
            json.append(requestBody);
        }
        GroupbuyDto groupbuyDto = mapper.readValue(json.toString(), GroupbuyDto.class);
        Boolean validReq = checkValidReq(groupbuyDto);
        Integer resultPk = -1;
        if (validReq) {
            resultPk = groupbuyDao.regist(groupbuyDto);
        }
        String jsonResponse;

        if (validReq && resultPk > 0){
            BaseResponse response = new BaseResponse(BaseResponseMessage.GROUPBUY_REGIST_SUCCESS);
            jsonResponse = mapper.writeValueAsString(response);
        } else if (!validReq) {
            BaseResponse response = new BaseResponse(BaseResponseMessage.GROUPBUY_REGIST_FAIL_TITLE_EMPTY);
            jsonResponse = mapper.writeValueAsString(response);
        } else {
            BaseResponse response = new BaseResponse(BaseResponseMessage.GROUPBUY_REGIST_FAIL);
            jsonResponse = mapper.writeValueAsString(response);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
    }

    private static Boolean checkValidReq(GroupbuyDto groupbuyDto) {
        if ((groupbuyDto.getCategoryIdx() == null) ||
                (groupbuyDto.getGpbyContent() == null) || (groupbuyDto.getGpbyTitle() == null) || (groupbuyDto.getGpbyQuantity() == null) ||
                (groupbuyDto.getGpbyEnddate() == null)) {
            return false;
        }
        return true;
    }
}
