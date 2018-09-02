package org.moita.sb2.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

@Component
public class ConnectionSessionConfig {

    private static final String CONFIG_XML = "mybatis-config.xml";

    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void execute() {
        try (InputStream inputStream = getResourceAsStream(CONFIG_XML)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }
} 