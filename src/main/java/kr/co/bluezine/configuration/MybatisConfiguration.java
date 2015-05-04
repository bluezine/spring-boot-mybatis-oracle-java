package kr.co.bluezine.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration("MybatisConfiguration")
@MapperScan(basePackages={"kr.co.bluezine.mapper"})
public class MybatisConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);
	
	@Value("${bonecp.driverClass}")
	private String driverClass;
	
	@Value("${bonecp.url}")
	private String jdbcUrl;
	
	@Value("${bonecp.username}")
	private String jdbcUsername;
	
	@Value("${bonecp.password}")
	private String jdbcPassword;
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		logger.debug("---------> Set BoneCP Data Pool");
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setPassword(jdbcPassword);
		dataSource.setUsername(jdbcUsername);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		logger.debug("---------> Set SqlSessionFactory");
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
	
	@Bean(destroyMethod="clearCache")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		logger.debug("---------> Set SqlSessionTemplate");
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
