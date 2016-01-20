package com.nicekong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by nicekkong on 2016. 1. 20..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class DataSourceTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private DataSource ds;

    @Test
    public void Connection_테스트() throws Exception {

        Connection con = null;
        try {
            con = ds.getConnection();
            System.out.println(con);
            logger.debug("\n=========>con : " + con + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(con != null) {
                con.close();
            }
        }
    }


}
