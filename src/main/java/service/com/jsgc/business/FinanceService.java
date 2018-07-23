package service.com.jsgc.business;

import mapper.com.jsgc.business.ContractMapper;
import mapper.com.jsgc.business.FinanceMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Finance;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
@Service
public class FinanceService {
    @Resource
    private FinanceMapper financeMapper;
    @Resource
    private ContractMapper contractMapper;
    @Resource
    private ProjectMapper projectMapper;

    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");

    public JedisPool jedisPool = (JedisPool) ac.getBean("jedisPool");//注入JedisPool



    public String getFinanceDetail(int financeID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Finance:"+financeID;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        return result;
    }

    public int updateFinanceDetail(Finance finance) {
        int projectID = projectMapper.getProjectIDBySerial(finance.getProjectSerial());
        finance.setProjectId(projectID);
        int contractID = contractMapper.getContractIDBySerial(finance.getContractSerial());
        finance.setContractId(contractID);
        return financeMapper.updateByPrimaryKeySelective(finance);
    }

    public int insertFinance(Finance finance){
        int projectID = projectMapper.getProjectIDBySerial(finance.getProjectSerial());
        finance.setProjectId(projectID);
        int contractID = contractMapper.getContractIDBySerial(finance.getContractSerial());
        finance.setContractId(contractID);
        return financeMapper.insertSelective(finance);
    }

    public int deleteFinance(int financeID){
        return financeMapper.deleteByPrimaryKey(financeID);
    }
}