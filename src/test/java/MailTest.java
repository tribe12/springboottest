import com.wgh.springboot.config.JavaMailComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wgh on 2021/3/15.
 */


@SpringBootTest
@RunWith(SpringRunner.class)
public class MailTest {

    @Autowired
    private JavaMailComponent javaMailComponent;

    @Test
    public void test() {
        this.javaMailComponent.sendMail("451641760@qq.com");
    }
}