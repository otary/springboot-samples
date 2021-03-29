package cn.chenzw.springboot.web.util;

import cn.chenzw.springboot.web.domain.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanUtilsTests {

    /**
     * 使用无参数构造函数
     */
    @Test
    public void testInstantiateClass() {
        UserDto userDto = BeanUtils.instantiateClass(UserDto.class);

        log.info("userDto => {}", userDto);
    }

    @Test
    public void testInstantiateClass2() throws NoSuchMethodException {
        UserDto userDto = BeanUtils.instantiateClass(UserDto.class.getConstructor(Long.class, String.class, String.class), 1L, "张三", "12");

        log.info("userDto => {}", userDto);
    }


}
