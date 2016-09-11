package vehicle;

import com.common.Result;
import com.dao.commentDao;
import com.entity.commentDO;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liyang on 15/4/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations={
                "classpath:com/spring/dao.xml",
                "classpath:com/spring/datasource.xml"
        })
public class commentTest {
    @Autowired
    private commentDao commentDao;
   // @Test
    public void insertComment(){
        commentDO  comment = new commentDO();
        long comment_id =100;
        int vote_num =1;
        String content = "hello world";
        comment.setGmt_create(new Date());
        comment.setComment_id(comment_id);
        comment.setContent(content);
        comment.setDevice_tag("abaa");
        comment.setVote_num(vote_num);
        try{
            commentDao.insertComment(comment);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    //@Test
    public void selectCommentDO(){
        commentDO comment = new commentDO();
        long comment_id = 100;
        try{
            comment = commentDao.selectComment(comment_id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String s = gson.toJson(comment);
        System.out.print(s);
    }
    @Test
    public void selectAllComment(){
        List<commentDO> list = new ArrayList<commentDO>();
        try{
            list = commentDao.selectAllComment();
        }catch (SQLException e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String s = gson.toJson(list);
        System.out.print(s);
    }
    //@Test
    public void voteComment(){
        commentDO comment = new commentDO();
        long comment_id = 100;
        int vote_num = 2;
        comment.setComment_id(comment_id);
        comment.setVote_num(vote_num);
        try{
            commentDao.voteComment(comment);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
