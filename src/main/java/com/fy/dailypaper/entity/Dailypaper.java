package com.fy.dailypaper.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 日报表
 * @TableName dailypaper
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dailypaper implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 日报标题
     */
    private String headline;

    /**
     * 任务
     */
    private String task;

    /**
     * 问题
     */
    private String problem;

    /**
     * 收获
     */
    private String harvest;

    public Dailypaper(Integer uid, String headline, String task, String problem, String harvest) {
        this.uid = uid;
        this.headline = headline;
        this.task = task;
        this.problem = problem;
        this.harvest = harvest;
    }
}