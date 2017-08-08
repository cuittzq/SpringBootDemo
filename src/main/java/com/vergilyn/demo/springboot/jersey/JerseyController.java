package com.vergilyn.demo.springboot.jersey;

import com.alibaba.fastjson.JSON;
import com.vergilyn.demo.constant.Constant;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/*
 * 所有注册的端点都应该被@Components和HTTP资源annotations（比如@GET）注解。
 * 1、因为是@Component，所以其生命周期受Spring管理。
 * 		并且你可以使用@Autowired添加依赖及使用@Value注入外部配置。
 */
//@Component
@RestController
@Path("/jersey")
public class JerseyController {
	
	@GET
	@Path("/get")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  
    @Produces(MediaType.APPLICATION_JSON) 
	public Map<String, Object> getMessage() {
		return Constant.map;
	}
	
	@POST	//POST形式在浏览器地址栏输入请求路径不一定能访问到。推荐用fiddler工具或者firefox浏览器插件（poster或HttpRequester）
	@Path("/post")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  
    @Produces(MediaType.APPLICATION_JSON) 
	public Map<String, Object> postMessage(Map<String,Object> param) {
	    System.out.println(JSON.toJSONString(param));
		return Constant.map;
	}
}