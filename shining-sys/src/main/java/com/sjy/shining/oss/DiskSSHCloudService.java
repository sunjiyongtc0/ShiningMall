package com.sjy.shining.oss;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SCPOutputStream;
import ch.ethz.ssh2.Session;
import com.sjy.shining.utils.RRException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *  远程服务器推送
 *
 */
public class DiskSSHCloudService extends CloudStorageService {

    @Value("${file.eye}")
    private  String eyePath;

    private Connection conn;


    public DiskSSHCloudService(CloudStorageConfig config)  {
        this.config = config;
        try {
            ConneCtionLinux();
        }catch (Exception e){
            System.err.println("authentication failed:"+e.getMessage());
        }

    }


    /**
     * 获取远程连接
     * */
    private  void ConneCtionLinux() throws IOException {
        conn= new Connection(config.getProxyServer(),22);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(config.getProxyUser(),config.getProxyPass());
        if(!isAuthenticated){
            System.err.println("authentication failed");
        }
    }



    @Override
    public String upload(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return upload(file.getBytes(), getPath("") + "." + prefix);
    }

    @Override
    public String upload(byte[] data, String path) {
        if (data.length < 3 || path.equals(""))
            throw new RRException("上传文件为空");
        //本地存储必需要以"/"开头
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        SCPOutputStream os = null;
        try {
            String fileName = config.getDiskPath() + path;
            String dateDir = path.split("/")[1];
            //文件夹
            Session session0= conn.openSession();//打开一个会话
            String cmd0 = "mkdir "+config.getDiskPath() + "/" + dateDir;
            session0.execCommand(cmd0);//执行命令
//            File dirFile = new File(config.getDiskPath() + "/" + dateDir);
//            if (!dirFile.exists()) {
//                dirFile.mkdirs();
//            }
            //上传文件
            SCPClient scp = new SCPClient(conn);
            //文件名，文件大小，发送地址
            os = scp.put(path.split("/")[2],data.length,config.getDiskPath()+ "/" + dateDir,null);
            os.write(data,0,data.length);
            Session session= conn.openSession();//打开一个会话
            //远程执行linux命令 因为上传的文件没有读的文件 需要加上才能下载 （如果你上传的文件有）
            String cmd = "chmod  755 "+config.getDiskPath()+ "/" + dateDir+ "/" +path.split("/")[2] ;
            System.out.println(cmd);
            session.execCommand(cmd);//执行命令
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException("上传文件失败", e);
        }
        // ************/home/work/wxapp/shining/ad/20210106   =>config.getProxyServer() + path
        return config.getProxyHttp()+ path;
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, path);
        } catch (IOException e) {
            throw new RRException("上传文件失败", e);
        }
    }


    /**
     * 批量删除服务器上的文件，支持根据关键字删除
     */
    public boolean deleteFile(String file) {
        try {
                String remoteTargetDirectory= config.getDiskPath();
                String [] fi =  file.split(",");
                for (int i = 0;i < fi.length;i ++) {
                    Session session= conn.openSession();//打开一个会话
                    String cmd = "rm -rf  "+remoteTargetDirectory+"*"+fi[i]+"*";
                    session.execCommand(cmd);//执行命令
                    session.close();
                }
                conn.close();

        }catch (Exception ex){
            return false;
        }
        return true;
    }


}
