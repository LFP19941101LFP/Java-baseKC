package com.alibaba.service;

/**
 * 自定义异常类
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.service;
 * @Title ReamException
 * @date 2020/6/25、10:44
 * @company 阿里巴巴
 */
public class TeamException extends Exception{

    static final long serialVersionUID = -3387516993524229948L;
    public TeamException(){
        super();
    }
    public TeamException(String msg){
        super(msg);
    }

}
