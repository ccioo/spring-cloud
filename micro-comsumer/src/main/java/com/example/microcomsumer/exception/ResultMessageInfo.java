package com.example.microcomsumer.exception;

import java.io.Serializable;

/**
 * 用于调用方法需要返回成功与否和其它值的情况
 */
public class ResultMessageInfo implements Serializable {
    private Integer code;
    private String msg="";
    private String url="";
    private Object data;
    public ResultMessageInfo(){}
    public ResultMessageInfo(Integer code, String message, String url, Object data){
        this.code=code;
        this.msg=message;
        this.url=url;
        this.data=data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg ;//通过CODE 得到信息
    }

    public void setMsg(String message) {
        this.msg = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static  ResultMessageInfo ofMessage(String message){
        return new ResultMessageInfo(State.FAILED.getCode(),message,null,null);
    }
    public static  ResultMessageInfo ofMessage(Integer code){
        String msg=getValueByCode(code);
        return new ResultMessageInfo(code,msg,null,null);
    }

    /**
     * 执行失败，状态码和提示信息
     * @param code
     * @param message
     * @return
     */
    public static ResultMessageInfo ofMessage(Integer code,String message){
        return new ResultMessageInfo(code,message,null,null);
    }

    /**
     * 成功，只返回成功状态码
     * @return
     */

    public  static ResultMessageInfo ofSuccess(){
        return ofSuccess(State.SUCCESS.getMessage(),null);
    }

    /**
     * 执行成功，返回提示信息
     * @param message
     * @return
     */
    public  static ResultMessageInfo ofSuccess(String message){
        return ofSuccess(message,null);
    }

    /**
     *执行成功，只返回结果集
     * @param data
     * @return
     */
    public static ResultMessageInfo ofSuccess(Object data){
        return ofSuccess( State.SUCCESS.getMessage(),data);
    }

    /**
     *执行成功，只返回结果集
     * @param data
     * @return
     */
    public static ResultMessageInfo ofFail(Object data){
        return ofSuccess( State.FAILED.getMessage(),data);
    }

    /**
     * 执行成功，返回提示信息和结果集
     * @param message
     * @param data
     * @return
     */
    public static ResultMessageInfo ofSuccess(String message,Object data){
        return new ResultMessageInfo(State.SUCCESS.getCode(),message,null,data);
    }

    /**
     * 通过code取value
     * @param code
     * @return
     */
    public static String getValueByCode(Integer code){
        for(State state: State.values()){
            if(code.equals(state.code)){
                return state.message;
            }
        }
        return  null;
    }


    /**
     * 常用返回状态
     */
    public enum State {
        SUCCESS(0, "成功"),
        FAILED(1, "失败"),
        ERROR(1001, "未知异常"),
        UNAUTHORIZED(401, "无权限"),
        NULL_POINT(4007,"空指针"),
        TOKEN_EXPIRE(50014,"登录过期"),
        NOT_LOGIN(5001,"未登录"),

        TOKEN_KICKED(50015,"账号已被踢掉"),
        TOKEN_FORBID(50016,"账号已被禁用"),
        SMS_TOO_OFTEN(51000,"登录操作过于频繁"),
        SMS_CODE_ERROR(51001,"验证码错误");


        private Integer code;
        private String message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        State(Integer code, String message) {
            this.code = code;
            this.message = message;
        }


    }

}
