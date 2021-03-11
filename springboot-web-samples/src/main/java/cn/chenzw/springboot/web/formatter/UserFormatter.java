package cn.chenzw.springboot.web.formatter;

import cn.chenzw.springboot.web.domain.dto.UserDto;
import cn.chenzw.springboot.web.repository.UserMapper;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * String => UserDto 转换器
 *
 * @author chenzw
 */
public class UserFormatter implements Formatter<UserDto> {

    private UserMapper userMapper;

    public UserFormatter(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDto parse(String id, Locale locale) throws ParseException {

        System.out.println("---------------------------");
        return userMapper.queryById(Long.valueOf(id));
    }

    @Override
    public String print(UserDto userDto, Locale locale) {
        return String.valueOf(userDto.getId());
    }
}
