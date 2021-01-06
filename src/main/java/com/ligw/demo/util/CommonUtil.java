package com.ligw.demo.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 * Description: Common Utility
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class CommonUtil {
    /**
     * 获取系统时间戳
     * @return String
     */
    public static String getTimeStamp() {
        String timeStamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
        return timeStamp.substring(0, timeStamp.length() - 3);
    }

    /**
     * 获取系统时间戳(毫秒)
     * @return String
     */
    public static String getTimeSampInMillis(){
        return String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    /**
     * 获取32位UUID字符串
     * @return String
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }

    /**
     * 获取随机数字符串
     * @param bitCount 随机数位数
     * @return String
     */
    public static String getRandomNumber(int bitCount){
        return String.valueOf((int) ((Math.random() * 9 + 1) * (int) Math.pow(10, bitCount)));
    }


    /**
     * 获取上传文件父级目录绝对路径(若路径不存在重新创建)
     * @param rootPath 文件资源根目录
     * @param relativePath 相对路径
     * @return 绝对路径
     */
    public static String getUploadFilePath(String rootPath, String relativePath){
        File root = new File(rootPath);
        if (!root.exists()) {
            return null;
        }
        String uploadParentDirPath =
                new StringBuilder().append(rootPath).append(relativePath).toString();
        File uploadParentDir = new File(uploadParentDirPath);
        try {
            if (!uploadParentDir.exists()) {
                uploadParentDir.mkdirs();
            }
            return uploadParentDirPath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据上传文件的父级绝对路径获取相对路径
     * @return 相对路径
     */
    public static String getRelativePath(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateString = simpleDateFormat.format(Calendar.getInstance().getTime());
        return new StringBuilder(File.separator).append(dateString).toString();
    }


    /**
     * 获取文件扩展名
     * @param filename
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * 查找从小到大排序的数字数组缺少的最小数字
     * @param array
     * @return
     */
    public static int minLoseInArray(int[] array){
        int minque = 1;
        //array 不为空
        if (null != array && array.length>0){
            if (array.length == 1){
                minque = array[0]+1;
            } else if(array.length == 2){
                if (1 == (array[1] - array[0])){
                    minque = array[1]+1;
                } else {
                    minque = array[0]+1;
                }
            } else {
                int headlength = (array.length+1)/2;
                int[] headArray = new int[headlength];
                System.arraycopy(array,0,headArray,0,headlength);
                //检查前半部分是否密集
                int headmin = headArray[0];
                int headmax = headArray[headlength-1];
                if (headlength  > (headmax - headmin)){
                    //前部分密集分布
                    int footlength = array.length - headlength;
                    int[] footArray = new int[footlength];
                    System.arraycopy(array,headlength,footArray,0,footlength);
                    int footmin = footArray[0];
                    int footmax = footArray[footlength-1];
                    // 检查后部分是否与前部分衔接
                    if (1 == (footmin - headmax)){
                        //检查后部分是否密集
                        if (footlength  > (footmax - footmin)){
                            //后半部分密集分布
                            minque = footmax +1;
                        } else {
                            minque = minLoseInArray(footArray);
                        }
                    } else {
                        minque = headmax +1;
                    }
                } else {
                    minque = minLoseInArray(headArray);
                }
            }
        }
        return minque;
    }

    /**
     * 快速排序
     * @param a
     * @param low 起始下标
     * @param high 结束下标
     */
    public static void quickSort(int[] a, int low, int high){
        int start = low;
        int end = high;
        int key = a[low];
        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) quickSort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) quickSort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }
}
