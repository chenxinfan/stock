package cn.chenxinfan.stock.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/16 14:57
 */
@Slf4j
@Configuration
@MapperScan(basePackages = {"cn.chenxinfan.stock.mapper", "cn.chenxinfan.stock.split.mapper"}, sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(resolveMapperLocations());
//        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybaties-config.xml"));
        return bean.getObject();
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    private Resource[] resolveMapperLocations() {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<String> mapperLocaltions = new ArrayList<>();
        mapperLocaltions.add("classpath*:mapper/*.xml");
        mapperLocaltions.add("classpath*:mapper/split/*.xml");
        List<Resource> resources = new ArrayList<>();
        mapperLocaltions.stream().forEach(mapperLocaltion -> {
            try {
                Resource[] mappers = resourceResolver.getResources(mapperLocaltion);
                resources.addAll(Arrays.asList(mappers));
            } catch (IOException e) {
                log.error("error", e);
            }
        });
        return resources.toArray(new Resource[resources.size()]);
    }
}
