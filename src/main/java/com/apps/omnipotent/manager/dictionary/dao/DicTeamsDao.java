package com.apps.omnipotent.manager.dictionary.dao;

import com.apps.omnipotent.manager.dictionary.bean.DictionaryTeams;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典对象 Dao
 * @author lb
 *
 */
@Repository
public interface DicTeamsDao {

    @Select("select * from be_dictionary where dic_id=? order by sort asc")
    List<DictionaryTeams> listTeamsByDicId(String id);

    /**
     * 获取全部的字典对象
     * @return
     */
//    public List<DictObj> listDictObj();
}
