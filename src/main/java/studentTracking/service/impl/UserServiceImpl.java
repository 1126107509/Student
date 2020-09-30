package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IUserDao;
import studentTracking.model.User;
import studentTracking.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;


    /**
     * z
     * 根据用户名和密码获得登录用户id
     * @param userName 用户名
     * @param password 密码
     * @return 用户id
     */
    @Override
    public long getUserByLogin(String userName, String password) {
        return userDao.getUserByLogin(userName, password);
    }

    /**
     * z
     * 根据用户id获取用户信息
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    public User getUserByUserId(long userId) {
        return userDao.getUserByUserId(userId);
    }

    /**
     * z
     * 根据用户id修改密码
     * @param userId 用户id
     * @param newPwd 新密码
     * @return 是否修改成功
     */
    @Override
    public boolean modifyPwdByUserId(long userId, String newPwd) {
        return userDao.modifyPwdByUserId(userId, newPwd);
    }

}
