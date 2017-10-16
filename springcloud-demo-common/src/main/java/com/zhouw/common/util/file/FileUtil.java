package com.zhouw.common.util.file;

import com.zhouw.common.util.common.StringUtil;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/6.
 * @since v1.0
 */
public class FileUtil {

    /** unix格式文件分隔符 **/
    public static final String FILE_SEPERATOR_UNIX = "/";
    /** dos格式文件分隔符 **/
    public static final String FILE_SEPERATOR_DOS = "\\\\";

    public static String formatFileFath(String src, boolean isUnix) {
        return "";
    }

    /**
     * 根据给定的文件名或者路径获取其父目录
     * @param src
     * @param fileSeperator
     * @return
     */
    public static String getParentDir(String src, String fileSeperator) {
        if (StringUtil.isEmpty(src)) return "";
        int index = 0;
        if (src.endsWith(fileSeperator)) {
            index = src.substring(0, src.length() - 1).lastIndexOf(fileSeperator);
        } else {
            index = src.lastIndexOf(fileSeperator);
        }
        return src.substring(0, index + 1);
    }

    public static String getFileNameFromPath(String src, String fileSeperator) {
        if (src.endsWith(fileSeperator)) {
            return "";
        } else {
            return src.substring(src.lastIndexOf(fileSeperator) + 1);
        }

    }

    public static void main(String[] args) {
        String filaName = "/opt/run/111.txt";
        System.out.println(getFileNameFromPath(filaName, FILE_SEPERATOR_UNIX));
    }
}
