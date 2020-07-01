package com.apps.omnipotent.manager.dao;

import com.apps.omnipotent.manager.bean.Dictionary;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典 Dao
 * @author lb
 *
 */
@Repository
public interface UserDao {

    /**
     * 获取全部
     * @return
     */
    @Select( "select * from be_user m where m.delete_flag='1'")
    List<Dictionary> listUser();

}
