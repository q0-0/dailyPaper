package com.fy.dailypaper.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *作用：统一封装后端返回的结果
 * 成功 R.ok
 * 失败：R.fail
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    //表示响应状态是否成功 code:0成功  code:-1失败
    private Integer code;
    //提示信息
    private String msg;
    //返回的数据对象
    private T data;


    // 响应成功的完整方法，需要调用者提供响应的code,msg,data
    public static <T> R<T> ok(Integer code, String msg, T data) {
        return new R<>(code, msg, data);
    }

    // 简化版本的成功方法,需要设置响应的数据
    public static <T> R<T> ok(T data) {
        return ok(0, "成功", data);
    }

    // 简化版本的成功方法，需要设置参数
    public static <T> R<T> ok() {
        return ok(null);
    }


    // 响应失败的完整方法，需要调用者提供响应的code,msg,data
    public static <T> R<T> fail(Integer code, String msg, T data) {
        return new R<>(code, msg, data);
    }

    // 简化版本的失败方法,需要设置响应的数据
    public static <T> R<T> fail(T data) {
        return fail(-1, "失败", data);
    }

    // 简化版本的失败方法，需要设置参数
    public static <T> R<T> fail() {
        return fail(null);
    }




}
