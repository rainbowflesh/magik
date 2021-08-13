package is.nijikawa.fozubaoyo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("is.nijikawa.fozubaoyo.mapper")
public class NowWeLogin {

    public static void main(String[] args) {
        SpringApplication.run(NowWeLogin.class, args);
    }

}
    