package cool.wangshuo.template;

import com.fasterxml.jackson.databind.ObjectMapper;
import cool.wangshuo.st.TemplateAppApplication;
import cool.wangshuo.st.mapper.CRUDMapper;
import cool.wangshuo.st.model.entity.Goods;
import cool.wangshuo.st.model.vo.common.CommonVo1;
import cool.wangshuo.st.model.vo.curd.GoodsAddVo;
import cool.wangshuo.st.model.vo.curd.GoodsUpdateVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author wangshuo
 * @date 2023/4/22 17:42
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TemplateAppApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
public class CRUDControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    private String baseURL = "/crud";

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void insertTest() throws Exception {

        GoodsAddVo vo = new GoodsAddVo();
        vo.setName("商品2");
        vo.setGoodType("水果");
        vo.setPrice(100);
        vo.setManufacturing(new Date());


        mockMvc.perform(MockMvcRequestBuilders.post(baseURL + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(vo))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Resource
    private CRUDMapper crudMapper;

    @Test
    public void updateTest() throws Exception {
        List<Goods> entities = crudMapper.selectList(null);
        Goods entity = entities.get(entities.size()-1);
        GoodsUpdateVo vo = new GoodsUpdateVo();
        BeanUtils.copyProperties(entity, vo);
        vo.setName("新的名称111");
        mockMvc.perform(MockMvcRequestBuilders.post(baseURL + "/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(vo))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void delTest() throws Exception {
        List<Goods> entities = crudMapper.selectList(null);
        Goods entity = entities.get(entities.size()-1);
        CommonVo1 vo = new CommonVo1();
        vo.setId(entity.getId());

        mockMvc.perform(MockMvcRequestBuilders.post(baseURL + "/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(vo))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }


    @Test
    public void pageTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(baseURL + "/page")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

}