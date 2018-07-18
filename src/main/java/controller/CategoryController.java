package controller;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.Category;
//import redis.RedisCache;
//import redis.RedisClient;
import service.CategoryService;
import util.Page;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

//告诉SpringMVC这是一个控制器类
@Controller
//@RequestMapping(value = "categoryController")
public class CategoryController {
//    RedisCache redisCache = new RedisCache();
//    RedisClient redisClient = new RedisClient();

    @Autowired
    CategoryService categoryService;

    //RequestMapping的value值前面有没有斜杠都没有关系
    @RequestMapping(value = "listCategory" , method = RequestMethod.GET)//默认就是GET
    public ModelAndView listCategory(Page page) {

        ModelAndView mav = new ModelAndView("listCategory");
        //每一次获取列表之前都要计算totalCount,以及更新last的值
        int totalCount = categoryService.count();
        page.calculateLast(totalCount);
//        System.out.println(redisClient.getByKey("foo"));
        List<Category> categoryList = categoryService.list(page.getStart(), page.getCount());
//        if (categoryList == null) {
//            mav.setViewName("listEmpty");
//        }
        mav.addObject("cs", categoryList);

        return mav;
    }

    @RequestMapping("editCategory")
    public ModelAndView editCategory(HttpServletRequest request) {
//        int id = category.getId();
        int id = Integer.parseInt(request.getParameter("id"));
        int startIndex = Integer.parseInt(request.getParameter("startIndex"));
        Category category = categoryService.getById(id);
        ModelAndView mav = new ModelAndView("editCategory");
        mav.addObject("startIndex", startIndex);
        mav.addObject("category", category);

        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "updateCategory" , method = RequestMethod.POST)
    public String updateCategory(@RequestBody Category category, int startIndex) {
        System.out.println("SSM接受到浏览器提交的json，并转换为Category对象: "+ category);
        categoryService.update(category);
        System.out.println(startIndex);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("OK", "OK");
        //接受ajax请求之后无法通过Controller来进行页面跳转.
//        ModelAndView mav = new ModelAndView("redirect:/listCategory?start=" + startIndex);
//        System.out.println("创建了一个mav. ViewName为: " + mav.getViewName());
        return jsonObject.toString();
    }

    @RequestMapping("deleteCategory")
    public ModelAndView deleteCategory(HttpServletRequest request, int startIndex) {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryService.delete(id);
        return new ModelAndView("redirect:/listCategory?start=" + startIndex);
    }

}
