package mapper.com.jsgc.admin;


import pojo.com.jsgc.admin.Version;

public interface VersionMapper {
    int deleteByPrimaryKey(Integer verisionId);

    int insert(Version record);

    int insertSelective(Version record);

    Version selectByPrimaryKey(Integer verisionId);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKey(Version record);
}