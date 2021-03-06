package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.Accountant;

import java.util.List;

public interface AccountantMapper {
    int deleteByPrimaryKey(String accountantId);

    int insert(Accountant record);

    int insertSelective(Accountant record);

    Accountant selectByPrimaryKey(String accountantId);

    int updateByPrimaryKeySelective(Accountant record);

    int updateByPrimaryKey(Accountant record);

    public List<String> getAccountantSerials();

    List<Accountant> selectByVersionID(String versionId);

    List<Accountant> selectBorrowTypeByVersionID(String versionId);

    List<Accountant> selectLendTypeByVersionID(String versionId);
}