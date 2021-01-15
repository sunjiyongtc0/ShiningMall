package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.BaseDao;
import com.sjy.shining.dao.UserDao;
import com.sjy.shining.entity.UserEntity;
import com.sjy.shining.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service("userService")
public class UserServiceImpl  extends ServiceImpl<UserDao, UserEntity> implements UserService {
//    @Autowired
//    private UserDao userDao;

    @Override
    public UserEntity queryObject(Integer id) {
        return baseMapper.queryObject(id);
    }

    @Override
    public List<UserEntity> queryList(Map<String, Object> map) {
        return baseMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return baseMapper.queryTotal(map);
    }

//    @Override
//    public int save(UserEntity user) {
//        user.setRegisterTime(new Date());
//        System.out.println(user.toString());
//        return baseMapper.save(user);
//    }

    @Override
    public int update(UserEntity user) {
        return baseMapper.updateById(user);
    }

    @Override
    public int delete(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userEntity.setRegisterTime(new Date());
        baseMapper.saveUser(userEntity);
    }

}
