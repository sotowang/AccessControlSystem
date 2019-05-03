package xjtu.soto.access.service.impl;

import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xjtu.soto.access.pojo.RecordEntity;
import xjtu.soto.access.service.RecordService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RecordServiceImplTest {

    @Autowired
    private RecordService recordService;
    @Test
    public void add() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByCardId() {
    }

    @Test
    public void findByFId() {
    }

    @Test
    public void findByTime() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByNameLike() {
    }

    @Test
    public void findByTypeAndRoleAndDepartmentAndFidAndTimeBetween() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date time1 = simpleDateFormat.parse("2019-04-27");
        Date time2 = simpleDateFormat.parse("2019-04-29");
        List<RecordEntity> res = recordService.findByTypeAndRoleAndDepartmentAndFidAndLocateAndTimeBetween(
                1, 1l, 1l, 1l,9l, time1, time2);

        Assert.assertEquals(1,res.size());
    }

    @Test
    public void findByTypeAndRoleAndDepartmentAndCardidAndFidAndTimeBetween() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date time1 = simpleDateFormat.parse("2019-04-27");
        Date time2 = simpleDateFormat.parse("2019-04-29");
        List<RecordEntity> res = recordService.findByTypeAndRoleAndDepartmentAndCardidAndFidAndLocateAndTimeBetween(
                1, 1l, 1l, "3118311061",1l,9l, time1, time2);

        Assert.assertEquals(1,res.size());
    }
}