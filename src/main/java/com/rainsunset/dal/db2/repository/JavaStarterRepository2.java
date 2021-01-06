package com.rainsunset.dal.db2.repository;

import com.rainsunset.dal.db2.model.JavaStarterEntity2;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 不同数据源的Repository都需要分目录存放，具体对应xml配置<jpa:repositories base-package=""/>
 *
 * @author ChenYanRui
 * @since 2020/5/28
 */
public interface JavaStarterRepository2 extends JpaRepository<JavaStarterEntity2, Integer> {
}
