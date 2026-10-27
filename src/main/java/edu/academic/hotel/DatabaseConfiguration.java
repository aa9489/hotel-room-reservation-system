package edu.academic.hotel;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
@Configuration public class DatabaseConfiguration {
 @Bean @Primary HikariDataSource dataSource(Environment env){
  String raw=env.getProperty("DATABASE_URL","jdbc:h2:mem:hotel;DB_CLOSE_DELAY=-1");
  String url=raw, username=env.getProperty("DB_USERNAME"), password=env.getProperty("DB_PASSWORD");
  if(raw.startsWith("postgres://")||raw.startsWith("postgresql://")){
   URI uri=URI.create(raw);String userInfo=uri.getUserInfo();
   if(userInfo!=null){String[] credentials=userInfo.split(":",2);if(username==null||username.isBlank())username=decode(credentials[0]);if((password==null||password.isBlank())&&credentials.length>1)password=decode(credentials[1]);}
   url="jdbc:postgresql://"+uri.getHost()+(uri.getPort()<0?"":":"+uri.getPort())+(uri.getRawPath()==null?"":uri.getRawPath())+(uri.getRawQuery()==null?"":"?"+uri.getRawQuery());
  }
  HikariConfig config=new HikariConfig();config.setJdbcUrl(url);config.setUsername(username==null||username.isBlank()?"sa":username);config.setPassword(password==null?"":password);config.setMaximumPoolSize(10);config.setPoolName("hotel-pool");return new HikariDataSource(config);
 }
 private static String decode(String value){return URLDecoder.decode(value,StandardCharsets.UTF_8);}
}
