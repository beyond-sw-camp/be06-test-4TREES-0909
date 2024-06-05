package buisiness.servlet;

import buisiness.dao.BuisinessDao;
import buisiness.dto.ComInfoRegiDto;
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

@WebServlet("/buisiness/company/regist")
public class BuisinessComRegistServlet extends HttpServlet {
    BuisinessDao buisinessDao;
    ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        buisinessDao = new BuisinessDao();
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String str = "";
        String res = "";
        String jsonResponse = "";
        while((str = br.readLine()) != null){
            res += str;
        }
        Map<String,Object> jsonStr = mapper.readValue(res,new TypeReference<Map<String,Object>>(){});
        ComInfoRegiDto comInfoRegiDto = new ComInfoRegiDto();
        comInfoRegiDto.setComInfoName(String.valueOf(jsonStr.get("company_info_name")));
        comInfoRegiDto.setComInfoAddress(String.valueOf(jsonStr.get("company_info_address")));
        comInfoRegiDto.setComInfoType(String.valueOf(jsonStr.get("company_info_type")));
        comInfoRegiDto.setComInfoIntro(String.valueOf(jsonStr.get("company_info_intro")));
        comInfoRegiDto.setCompanyIdx(Integer.parseInt(String.valueOf(jsonStr.get("company_idx"))));

        System.out.println(comInfoRegiDto);
        if (buisinessDao.createAccount(comInfoRegiDto)){
            jsonResponse = mapper.writeValueAsString(BaseResponseMessage.COMPANY_REGIST_SUCCESS);

        }else {
            jsonResponse = mapper.writeValueAsString(BaseResponseMessage.COMPANY_REGIST_FAIL);

        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(jsonResponse);
    }
}
