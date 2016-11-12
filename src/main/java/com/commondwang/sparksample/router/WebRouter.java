package com.commondwang.sparksample.router;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commondwang.sparksample.data.User;
import com.commondwang.sparksample.store.UserStore;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

@Service
public class WebRouter implements Router{
	@Autowired
	private UserStore userStore;
	
	@Autowired
	private FreeMarkerEngine freeMarkerEngine;

	public void initRouter() {
		spark.Spark.staticFileLocation("/view");
		
		//The sample user security filter
		spark.Spark.before((request, response) -> {
			if(request.pathInfo().equals("/index")){
				Object user = request.session().attribute("user"); 
			    if(null == user){
			    	response.redirect("/login");
			    	return;
			    }else{
			    	UserContext.setCurrentUser((User)user);
			    }
			}
		});
		
		//the login page
		spark.Spark.get("/login", (req, res) -> {
			if(UserContext.getCurrentUser() != null){
				res.redirect("/index");
				return "";
			}else{
				Map<String, Object> attributes = new HashMap<>();
				return freeMarkerEngine.render(new ModelAndView(attributes, "login.ftl"));
			}
		});
		
		spark.Spark.get("/index", (req, res) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("user", UserContext.getCurrentUser());
	        return freeMarkerEngine.render(new ModelAndView(attributes, "index.ftl"));	
		});
		
		//the post login
		spark.Spark.post("/login", (req, res) -> {
			String userName = req.queryParams("username");
			String password = req.queryParams("password");
			User user = userStore.getByName(userName);
			if(null != user && user.getPassword().equals(password)){
				signinHandler(user.getUserId(), req, res);
				res.redirect("/index");
				return "";
			}else{
				res.redirect("/login");
				return "";
			}
		});
		
		spark.Spark.after((request, response) -> {
			UserContext.removeCurrentUser();
		});
	}
	
	private void signinHandler(String userId, Request request, Response response){
		request.session().attribute("user", userStore.get(userId)) ;
	}
}
