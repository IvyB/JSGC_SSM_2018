package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BudgetReply;
import pojo.com.jsgc.admin.BuyOrgForm;

import java.util.List;

public interface BuyOrgFormMapper {
    int deleteByPrimaryKey(String buyOrgFormId);

    int insert(BuyOrgForm record);

    int insertSelective(BuyOrgForm record);

    BuyOrgForm selectByPrimaryKey(String buyOrgFormId);

    int updateByPrimaryKeySelective(BuyOrgForm record);

    int updateByPrimaryKey(BuyOrgForm record);
    public List<String> getBuyOrgFormSerials();

    List<BuyOrgForm> selectByVersionID(String versionId);
}