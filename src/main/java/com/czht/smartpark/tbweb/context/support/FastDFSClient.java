package com.czht.smartpark.tbweb.context.support;

import com.czht.smartpark.tbweb.modular.dmo.SysConfig;
import com.czht.smartpark.tbweb.modular.dto.CodeDTO;
import com.czht.smartpark.tbweb.modular.mapper.SysConfigMapper;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FastDFSClient {


    private StorageClient1 storageClient1 = null;

    @Autowired
    private SysConfigMapper configMapper = SpringContextHolder.getBean(SysConfigMapper.class);


    /**
     * 注释掉的部分为 直接读取配置文件，现在直接从数据库读取
     */
    public FastDFSClient(){

        try {
//            ClientGlobal.init(FastDFSClient.class.getResource("/conf/fdfs.conf").getPath());
            initConfig();
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
            TrackerServer trackerServer = trackerClient.getConnection();
            if (trackerServer == null) {
                throw new IllegalStateException("getConnection return null");
            }

            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            if (storageServer == null) {
                throw new IllegalStateException("getStoreStorage return null");
            }

            storageClient1 = new StorageClient1(trackerServer,storageServer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initConfig(){
        if(configMapper == null) return;
        List<SysConfig> configs = configMapper.getConfigs("fdfs_client");
        if(configs != null && configs.size()>0){
            for(SysConfig config : configs){
                String name = config.getConfigName();
                String value = config.getValue();
                if("connect_timeout".equals(name)){
                    ClientGlobal.setG_connect_timeout(Integer.parseInt(value));
                }
                if("network_timeout".equals(name)){
                    ClientGlobal.setG_network_timeout(Integer.parseInt(value));
                }
                if("charset".equals(name)){
                    ClientGlobal.setG_charset(value);
                }
                if("http.tracker_http_port".equals(name)){
                    ClientGlobal.setG_tracker_http_port(Integer.parseInt(value));
                }
                if("http.anti_steal_token".equals(name)){
                    ClientGlobal.setG_anti_steal_token(value=="no"?false:true);
                }
                if("http.secret_key".equals(name)){
                    ClientGlobal.setG_secret_key(value);
                }
                if("tracker_server".equals(name)){
                    String[] szTrackerServers = value.split(",");
                    InetSocketAddress[] tracker_servers = new InetSocketAddress[szTrackerServers.length];

                    for(int i = 0; i < szTrackerServers.length; ++i) {
                        String[] parts = szTrackerServers[i].split("\\:", 2);
                        if (parts.length != 2) {
                            throw new RuntimeException("the value of item \"tracker_server\" is invalid, the correct format is host:port");
                        }

                        tracker_servers[i] = new InetSocketAddress(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                    }

                    ClientGlobal.setG_tracker_group(new TrackerGroup(tracker_servers));
                }

            }
        }
    }


    /**
     * 上传文件
     * @param buff 文件对象
     * @param ext 后缀
     * @return
     */
    public String uploadFile(byte[] buff, String ext) {
        return uploadFile(buff,ext,null);
    }

    /**
     * 上传文件
     * @param buff 文件对象
     * @param ext 后缀
     * @param metaList 文件元数据
     * @return
     */
    public String uploadFile(byte[] buff, String ext, Map<String, String> metaList) {
        try {
            NameValuePair[] nameValuePairs = null;
            if (metaList != null) {
                nameValuePairs = new NameValuePair[metaList.size()];
                int index = 0;
                for (Iterator<Map.Entry<String, String>> iterator = metaList.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<String, String> entry = iterator.next();
                    String name = entry.getKey();
                    String value = entry.getValue();
                    nameValuePairs[index++] = new NameValuePair(name,value);
                }
            }
            return storageClient1.upload_file1(buff, ext,nameValuePairs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取文件元数据
     * @param fileId 文件ID
     * @return
     */
    public Map<String, String> getFileMetadata(String fileId) {
        try {
            NameValuePair[] metaList = storageClient1.get_metadata1(fileId);
            if (metaList != null) {
                HashMap<String, String> map = new HashMap<String, String>();
                for (NameValuePair metaItem : metaList) {
                    map.put(metaItem.getName(),metaItem.getValue());
                }
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除文件
     * @param fileId 文件ID
     * @return 删除失败返回-1，否则返回0
     */
    public int deleteFile(String fileId) {
        try {
            return storageClient1.delete_file1(fileId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 下载文件
     * @param fileId 文件ID（上传文件成功后返回的ID）
     * @return
     */
    public byte[] downloadFile(String fileId) {
        if(fileId == null){
            return null;
        }
        byte[] content = null;
        try {
            content = storageClient1.download_file1(fileId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return content;
    }

    public void main(String[] args){

    }
}
