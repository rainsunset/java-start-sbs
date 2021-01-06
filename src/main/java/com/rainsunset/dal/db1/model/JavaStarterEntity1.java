package com.rainsunset.dal.db1.model;

import lombok.Data;

import javax.persistence.*;

/**
 * 此处示例为多数据源
 * 如果多数据源，表结构相同，可只保留一个Entity，放在一个公共目录，并修改jpaEntityManagerFactory的packagesToScan都扫描同一个目录即可
 *
 * @author ChenYanRui
 * @since 2020/5/28
 */
@Data
@Entity
@Table(name = "java_starter")
public class JavaStarterEntity1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
}
