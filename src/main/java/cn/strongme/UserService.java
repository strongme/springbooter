package cn.strongme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 阿水 on 2017/5/27 09:59.
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> listAll() {
        return this.userMapper.listAll();
    }

}
