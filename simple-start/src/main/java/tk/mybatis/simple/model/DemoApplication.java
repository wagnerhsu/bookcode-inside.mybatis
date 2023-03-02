package tk.mybatis.simple.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Cleanup;
import lombok.var;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;


public class DemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String... args) throws IOException {
        logger.info("main");
        var mapper = new ObjectMapper();
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        var sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        @Cleanup SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Country> countryList = sqlSession.selectList("selectAll");
        countryList.stream().forEach(x -> {
            try {
                logger.info("value:{}", mapper.writeValueAsString(x));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
