package com.samphanie.springcloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname CommonResult
 * @Date 2020/4/19 15:32
 * @Author ZSY
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static CommonResult success(){
        return new CommonResult(200, "请求成功！");
    }

    public static CommonResult success(Integer code, String message){
        return new CommonResult(code, message);
    }

    public static <T> CommonResult<T> success(Integer code, String message, T data){
        return new CommonResult<T>(code, message, data);
    }

    public static CommonResult fail(){
        return new CommonResult(200, "请求失败！");
    }

    public static CommonResult error(Integer code, String message){
        return new CommonResult(code, message);
    }

    public static <T> CommonResult<T> error(Integer code, String message, T data){
        return new CommonResult<T>(code, message, data);
    }


}
