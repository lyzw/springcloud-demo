package com.zhouw.common.helper.sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.zhouw.common.util.common.StringUtil;
import com.zhouw.common.util.file.FileUtil;

import java.io.File;
import java.util.Properties;
import java.util.Vector;

/**
 * Sftp工具类
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/6.
 * @since v1.0
 */
public class SftpHelper {

    /**
     * 创建sftp连接
     *
     * @param host     服务器地址
     * @param port     服务器端口
     * @param username 用户名
     * @param password 密码
     * @return sftp连接
     * @throws JSchException 连接异常
     */
    public static ChannelSftp getSftpConnect(final String host, final int port, final String username,
                                             final String password) throws JSchException {
        JSch jsch = new JSch();
        Session sshSession = jsch.getSession(username, host, port);
        sshSession.setPassword(password);
        Properties sshConfig = new Properties();
        //自动接受新的公钥
        sshConfig.put("StrictHostKeyChecking", "no");
        sshSession.setConfig(sshConfig);
        sshSession.connect();
        Channel channel = sshSession.openChannel("sftp");
        channel.connect();
        return (ChannelSftp) channel;
    }


    /**
     * 上传文件
     *
     * @param channelSftp sftp链接
     * @param file        文件
     * @param dstFileName 文件路径
     * @throws SftpException 异常
     */
    public static void uploadFile(ChannelSftp channelSftp, File file, String dstFileName) throws SftpException {
        String fullFileName = "";
        if (!StringUtil.isEmpty(dstFileName)) {
            //如果文件已/结尾，则给定的是文件夹名，此时已此文件夹作为上传的文件夹
            String filePath = "";
            if (!dstFileName.startsWith("/")) {
                fullFileName = channelSftp.pwd() + "/" + dstFileName;
            }
            if (fullFileName.endsWith("/")) {
                filePath = fullFileName;
            } else {
                filePath = FileUtil.getParentDir(fullFileName, FileUtil.FILE_SEPERATOR_UNIX);
            }
            if (!isDirExists(channelSftp, filePath)) {
                mkdirs(channelSftp, filePath);
            }
        }
    }

    /**
     * 创建文件夹
     *
     * @param channelSftp sftp链接
     * @param pathName    文件名
     * @return 是否创建成功
     * @throws SftpException 异常
     */
    public static boolean mkdirs(ChannelSftp channelSftp, String pathName) throws SftpException {
        //如果给的路径是空的，则返回false
        if (StringUtil.isEmpty(pathName)) {
            return false;
        }
        //如果给的路径不是以“/”开头的，则返回false
        if (!pathName.startsWith("/")) {
            return false;
        }
        String[] paths = pathName.split("/");
        int index = 0;
        channelSftp.cd("/");
        for (String path : paths) {
            if (index == 0) {
                index++;
                continue;
            }
            channelSftp.ls(path);
        }
        return true;
    }

    /**
     * 判断文件夹是否存在，使用ls命令
     *
     * @param channelSftp sftp链接
     * @param dir         路径
     * @return 是否存在
     */
    public static boolean isDirExists(ChannelSftp channelSftp, String dir) {
        try {
            Vector vector = channelSftp.ls(dir);
            if (vector == null) {
                return false;
            } else {
                return true;
            }
        } catch (SftpException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 在sftp用户主目录下创建文件夹
     *
     * @param channelSftp sftp链接
     * @param pathName    路径名
     * @return 是否创建成功
     */
    public static boolean mkdirsAtHome(ChannelSftp channelSftp, String pathName) {
        return true;
    }

    /**
     * 测试方法
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String pathName = "/opt/run/";
        String[] paths = pathName.split("/");
        int i = 0;
        for (String path : paths) {
            System.out.println(i++ + ": " + path);
        }
    }

}
