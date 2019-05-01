package xjtu.soto.access.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xjtu.soto.access.pojo.ThirdLocateEntity;
import xjtu.soto.access.service.ThirdLocateService;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ThirdLocateServiceImplTest {

    @Autowired
    private ThirdLocateService thirdLocateService;
    @Test
    public void findAll() {
        List<ThirdLocateEntity> lists = thirdLocateService.findAll();
        for (ThirdLocateEntity entity:
             lists) {
            System.out.println(entity.getAddress());
        }
    }

    @Test
    public void save() {
        ThirdLocateEntity thirdLocateEntity = new ThirdLocateEntity(3l, "西12");
        thirdLocateService.save(thirdLocateEntity);
    }

    @Test
    public void findByTop() {
        thirdLocateService.findByTop(2l);
    }
}