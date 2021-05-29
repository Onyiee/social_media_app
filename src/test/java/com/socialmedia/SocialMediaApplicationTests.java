package com.socialmedia;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
class SocialMediaApplicationTests {
	@Autowired
	DataSource dataSource;

	@Test
	void applicationCanConnectToDatabase() {
		assertThat(dataSource).isNotNull();
		log.info("Object is created");

		try(Connection connection= dataSource.getConnection()){
			assertThat(connection).isNotNull();
			assertThat(connection.getCatalog()).isEqualTo("socialmediadb");
			log.info("connection--> {}", connection.getCatalog());
		}catch (SQLException throwables){
			log.info("An error occurred while connecting to the database-->{}",
					throwables.getMessage());
		}
	}

}
