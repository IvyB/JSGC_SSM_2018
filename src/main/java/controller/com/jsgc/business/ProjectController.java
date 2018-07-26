package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Project;
import service.com.jsgc.business.ProjectService;
import util.com.jsgc.RequestPage;
import util.com.jsgc.searchCondition.ProjectSearchConditions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/business/project/")

//@RequestMapping("/business/project/")

@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class ProjectController {
    @Resource
    private ProjectService projectService;
    @RequestMapping("/getProjectList")
    @ResponseBody
    public String searchByConditons(@RequestBody String params) throws UnsupportedEncodingException {
        System.out.println(params);
        ProjectSearchConditions ps = JSON.parseObject(params , new TypeReference<ProjectSearchConditions>() {});
        System.out.println(ps);
        ps.parseOrder();
        System.out.println(ps);
        return projectService.searchByConditions(ps);
//        String gbk = new String(projectService.searchByConditions(ps).getBytes(), "utf-8");
//        //分页条件
//        int limit=Integer.parseInt(request.getParameter("limit"));
//        int start=Integer.parseInt(request.getParameter("start"));
//        System.out.println(limit+" "+start);
//        RequestPage requestPage=new RequestPage(limit,start);
//        //搜索条件
//        String projectSerial=request.getParameter("projectSerial");
//        String projectName=request.getParameter("projectName");
//        String projectDepartment=request.getParameter("projectDepartment");//承包部门编号
//        String projectOwner=request.getParameter("projectOwner");//项目负责人姓名
//        int projectBudgetDown=Integer.parseInt(request.getParameter("projectBudgetDown"));
//        int projectBudgetUp=Integer.parseInt(request.getParameter("projectBudgetUp"));
//        String order=request.getParameter("order");
//        System.out.println(projectSerial+" "+projectName+" "+projectDepartment+" "+projectOwner+" "+projectBudgetDown+" "+order);
//        HashMap searchConditionMaps=new HashMap();
//        //searchConditionMaps.put("projectSerial")
//

//        return projectService.searchByConditions(ps);
    }


    @RequestMapping("getProjectDetail")
    @ResponseBody
    public String getProjectDetail(@RequestBody String params){
        Project project = JSON.parseObject(params , new TypeReference<Project>() {});
        return   projectService.getProjectDetail(project.getProjectId());
    }

    @RequestMapping("updateProjectDetail")
    @ResponseBody
    public int updateProjectDetail(@RequestBody String params){
        Project project = JSON.parseObject(params , new TypeReference<Project>() {});
        return   projectService.updateProjectDetail(project);
    }

    @RequestMapping("addProject")
    @ResponseBody
    public int addProject(@RequestBody String params){
        Project project = JSON.parseObject(params , new TypeReference<Project>() {});
        return   projectService.insertProject(project);
    }

    @RequestMapping("deleteProject")
    @ResponseBody
    public int deleteProject(int projectID){

        return  projectService.deleteProject(projectID);
    }


}
