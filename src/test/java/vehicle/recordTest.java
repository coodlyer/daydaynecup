package vehicle;

import com.dao.recordDao;
import com.entity.recordDO;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* Created by liyang on 15/5/21.
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations={
                "classpath:com/spring/dao.xml",
                "classpath:com/spring/datasource.xml"
        })
public class recordTest {
    @Autowired
    recordDao recordDao;
    @Test
    public void insertRecord(){
        recordDO record = new recordDO();
        long rid =100;
        String device_tag = "hello";
        int am_done=1;
        int pm_done=1;
        record.setDevice_tag(device_tag);
        record.setRid(rid);
        record.setAm_done(am_done);
        record.setPm_done(pm_done);
        try{
           long r= recordDao.insertRecord(record);
            System.out.print(r);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    @Test
    public void selectRecord(){
        String device_tag="hello";
        List<recordDO> record = new ArrayList<recordDO>();
        try{
            record = recordDao.selectRecord(device_tag);
        }catch (SQLException e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String s = gson.toJson(record);
        System.out.print(s);
    }
    @Test
    public void updateRecord(){
        int am_done=0;
        int pm_done=0;
        long rid=100;
        recordDO record = new recordDO();
        record.setRid(rid);
        record.setPm_done(pm_done);
        record.setAm_done(am_done);
        try{
            recordDao.updateRecord(record);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
