package ua.vld.config.service;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import ua.vld.config.AbstractUserServiceTest;

@ActiveProfiles("datajpa")
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class DataJpaUserServiceTest extends AbstractUserServiceTest{

}
