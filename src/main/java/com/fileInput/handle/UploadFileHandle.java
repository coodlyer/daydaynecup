package com.fileInput.handle;

/**
 * Created by liyang on 15/4/15.
 */
import com.fileInput.config.AbstractHandle;
import com.common.Result;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;
import com.fileInput.config.QiNiuConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/upload")
public class UploadFileHandle extends AbstractHandle{
    private Logger logger = LoggerFactory.getLogger(UploadFileHandle.class);

    //最大文件大小
    private long maxSize = 2000000;

    //定义允许上传的文件扩展名
    private HashMap<String, String> extMap = new HashMap<String, String>();
    {
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        extMap.put("flash", "swf,flv");
        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
    }

    @RequestMapping(value ="/test", method = RequestMethod.POST)
    public @ResponseBody
    String process (HttpServletRequest request) throws Exception {

        Result result = new Result();

        //文件保存目录路径
        String savePath ="attached/";

        if(!ServletFileUpload.isMultipartContent(request)){
            result.setError("1000");
        }
        String dirName = request.getParameter("dir");
        if (dirName == null) {
            dirName = "image";
        }
        if(!extMap.containsKey(dirName)) {
            result.setError("1001");
            return gson.toJson(result);
        }
        savePath += dirName+"/";

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List items;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            logger.error("UploadFile.process.error.parseRequest", e);
            result.setError("1002");
            return gson.toJson(result);
        }
        Iterator itr = items.iterator();
        while (itr.hasNext()) {
            FileItem item = (FileItem) itr.next();
            //获得上传文件名称
            String fileName = item.getName();
            //判断是否为文件
            if (!item.isFormField()) {
                //检查文件大小
                if(item.getSize() > maxSize){
                    result.setError("1003");
                    return gson.toJson(result);
                }
                //检查扩展名
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

                if(!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
                    result.setError("1004");
                    return gson.toJson(result);
                }


                //TODO 文件名唯一表示生成
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;

                try{
                    /****
                     * 保存到服务器中
                     //设置文件保存目录
                     File savePathFile = new File(saveFileName);
                     savePathFile.mkdirs();//创建没有的目录
                     if(!savePathFile.canWrite()){
                     out.println(getError("目录没有写权限。"+saveFileName));
                     return;
                     }
                     saveFileName+=newFileName;//含文件名;
                     //保存文件
                     File uploadedFile = new File(saveFileName);
                     item.write(uploadedFile);
                     ***/

                    //保存到七牛

                    Mac mac = new Mac(QiNiuConfig.QINIU_ACCESS_KEY, QiNiuConfig.QINIU_SECRET_KEY);
                    PutPolicy putPolicy=new PutPolicy(QiNiuConfig.QINIU_bucketName);
                    String uptoken = putPolicy.token(mac);
                    PutExtra extra = new PutExtra();
                    String key = savePath+newFileName;
                    PutRet ret = IoApi.Put(uptoken, key, item.getInputStream(), extra);

                    if(!ret.ok()){
                        result.setError("1005");
                        return gson.toJson(result);
                    }
                }catch(Exception e){
                    result.setError("1006");
                    logger.error("UploadFile.process.error.UploadToQiniu", e);
                    return gson.toJson(result);
                }
                result.addParam("fid", QiNiuConfig.RESOURCE_URL + "/attached/image/" + newFileName);
                return gson.toJson(result);
            }
        }
        return gson.toJson(result);
    }
}
