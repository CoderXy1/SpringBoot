package com.xy.aurora.Common.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Result<T>{

    private int code;
    private String msg;
    private T data;

    public Result(){
    }

    public Result(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(){
        return new Result<>(200,"成功",null);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(200,"成功",data);
    }

    public static <T> Result<T> fail(Integer code,String msg){
        return new Result<>(code,msg,null);
    }

    public static <T> Result<T> fail(Integer code,String msg,T data){
        return new Result<>(code,msg,data);
    }

}
