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
import java.io.IOException;
import java.util.List;

@WebServlet("/groupbuy/listall")
public class GroupbuyListAllServlet extends HttpServlet {
    GroupbuyDao groupbuyDao;
    ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        groupbuyDao = new GroupbuyDao();
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GroupbuyDto> groupbuyDtos = groupbuyDao.listAll();
        String jsonResponse;
        BaseResponse response;
        if (groupbuyDtos != null) {
            response = new BaseResponse(BaseResponseMessage.GROUPBUY_LIST_SUCCESS, groupbuyDtos);
        } else {
            response = new BaseResponse(BaseResponseMessage.GROUPBUY_LIST_FAIL);
        }
        jsonResponse = mapper.writeValueAsString(response);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);

    }
}
