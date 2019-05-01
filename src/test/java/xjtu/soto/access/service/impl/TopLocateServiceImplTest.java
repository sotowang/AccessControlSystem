package xjtu.soto.access.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xjtu.soto.access.pojo.TopLocateEntity;
import xjtu.soto.access.service.TopLocateService;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TopLocateServiceImplTest {

    @Autowired
    private TopLocateService topLocateService;
    @Test
    public void save() {
        TopLocateEntity topLocateEntity = new TopLocateEntity("西安交通大学1");
        topLocateService.save(topLocateEntity);
    }

    @Test
    public void findById() {
        topLocateService.findById(1l);
    }

    @Test
    public void deleteById() {
        topLocateService.deleteById(1l);

    }
}