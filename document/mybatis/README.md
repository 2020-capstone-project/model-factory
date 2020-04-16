# Spring & Mybatis & PostgreSQL

스프링 & 마이바티스 & 포스트그래스 연동하기

<br>

## 1. 프로젝트 준비

* Intelij
* Gradle

1. New Project

   ![image](https://user-images.githubusercontent.com/43431081/79115843-e86f7480-7dc1-11ea-8688-de7f0dfe1835.png)

2. gradle에 dependency 추가

   **build.gradle**

   ```java
   plugins {
       id 'java'
   }
   
   group 'org.example'
   version '1.0-SNAPSHOT'
   
   sourceCompatibility = 1.8
   compileJava.options.encoding("UTF-8")
   
   apply plugin: 'java'
   apply plugin: 'war'
   
   repositories {
       mavenCentral()
   }
   
   dependencies {
       testCompile group: 'junit', name: 'junit', version: '4.12'
       implementation 'javax.servlet:javax.servlet-api:4.0.1'
       implementation 'org.springframework:spring-webmvc:5.2.4.RELEASE'
       implementation 'org.springframework:spring-jdbc:5.2.4.RELEASE'
       implementation 'org.mybatis:mybatis:3.5.4'
       implementation 'org.mybatis:mybatis-spring:2.0.4'
       implementation 'org.postgresql:postgresql:42.2.11.jre7'
       compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.0.1'
       compile group: 'com.fasterxml.jackson.datatype', name: 'jackson-datatype-jsr310', version: '2.10.3'
       implementation 'org.apache.tomcat:tomcat-jdbc:10.0.0-M1'
   }
   ```

<br>

## 2. 설정 클래스 작성

* **java/config/PerrsistenceConfig.java**

  ```java
  package config;
  
  import org.apache.ibatis.session.SqlSessionFactory;
  import org.apache.tomcat.jdbc.pool.DataSource;
  import org.mybatis.spring.SqlSessionFactoryBean;
  import org.mybatis.spring.annotation.MapperScan;
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  
  @Configuration
  @MapperScan("mapper")
  public class PersistenceConfig {
  
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
      DataSource ds = new DataSource();
      ds.setDriverClassName("org.postgresql.Driver");
      ds.setUrl("jdbc:postgresql://arjuna.db.elephantsql.com:5432/");
      ds.setUsername("******");
      ds.setPassword("******");
      ds.setInitialSize(2);
      ds.setMaxActive(10);
      return ds;
    }
  
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
      SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
      factoryBean.setDataSource(dataSource());
      return factoryBean.getObject();
    }
  
  }
  ```

  * DataSource, SqlSessionFactory 빈 추가
  * @MapperScan("스캔할패키지")

<br>

## 3. 매퍼 인터페이스 작성

* **java/mapper/MemberMapper.java**

  ```java
  package mapper;
  
  import dto.Member;
  import org.apache.ibatis.annotations.Select;
  import org.springframework.stereotype.Repository;
  
  import java.util.List;
  
  public interface MemberMapper {
    @Select("select * from member")
    List<Member> selectList();
  }
  ```

<br>

## 4. 컨트롤러 작성

* **java/controller/TestController.java**

  ```java
  package controller;
  
  import dto.Member;
  import mapper.MemberMapper;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RestController;
  
  import java.util.List;
  
  @RestController
  public class TestController {
  
    @Autowired
    private MemberMapper memberMapper;
  
    @GetMapping("/members")
    public List<Member> members() {
      return memberMapper.selectList();
    }
  
  }
  ```

<br>

## 5. 컨트롤러 빈 등록

* **java/config/RestConfig.java**

  ```java
  package config;
  
  import controller.TestController;
  import mapper.MemberMapper;
  import org.mybatis.spring.SqlSessionTemplate;
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.web.servlet.config.annotation.EnableWebMvc;
  import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
  
  @Configuration
  @EnableWebMvc
  public class RestConfig implements WebMvcConfigurer {
  
    @Bean
    public TestController testController() {
      return new TestController();
    }
  
  
  ```