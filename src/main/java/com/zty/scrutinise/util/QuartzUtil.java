package com.zty.scrutinise.util;

import com.zty.scrutinise.dao.StaffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class QuartzUtil {
    @Autowired
    private StaffDao staffDao;

    //每分钟启动
    //@Scheduled(cron = "*/5 * * * * ?")
    public void timerToNow() {
        staffDao.upd_clockstatus();
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
