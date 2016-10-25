## Struts2 简单应用--实现登录功能

> 功能描述: 在登录功能的action之前添加检查session的拦截器，达到权限控制的功能；

### 1 在login.jsp中添加form 表单

	${loginError }
	  <form action="login" method="post">
	  	用户名：<input type="text" name="username"><br>
	  	密码：<input type="password" name="password"><br>
	  	<input type="submit" value="提交">  
	  </form>


### 2 在com.itzzy.action 包下新建LoginAction.java 文件 代码如下：

	public class LoginAction extends ActionSupport implements SessionAware{
		private String username;
		private String password;
		private Map<String, Object> session;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String login(){
			if("admin".equals(username)&&"123".equals(password)){
				session.put("login", username);
				return SUCCESS;
			}else {
				session.put("loginError", "用户名或密码不正确！");
				return ERROR;
			}
		}
		public void setSession(Map<String, Object> session) {
			// TODO Auto-generated method stub
			this.session = session;
		}
	}

###3 在struts.xml 文件中添加配置
	
	<!-- 通过此action 访问后台管理页面 -->
		<action name="auth">
			<result>/WEB-INF/page/manager.jsp</result>
			<result name="login">/login.jsp</result>//如果是直接访问后台，没有session将跳转拿到login.jsp
			<!-- 应用拦截器 -->
			<interceptor-ref name="MyStack"></interceptor-ref>
		</action>
		
		<action name="login" class="com.itzzy.action.LoginAction" method="login">
			<result>/WEB-INF/page/manager.jsp</result>
			<result name="error">/login.jsp</result>
		</action>

###4 添加拦截器，在com.itzzy.interceptor 包下新建文件

	public class Authinterceptor extends AbstractInterceptor {
		@Override
		public String intercept(ActionInvocation invocation) throws Exception {
			ActionContext context = ActionContext.getContext();
			Map<String, Object> session = context.getSession();
			if(session.get("login") !=null){
				String result = invocation.invoke();//拦截器放行，执行下一个拦截器或action
				return result;
			}else {
				return "login";
			}
		}
	}

###5 在Struts.xml 中注册拦截器

	<!-- 注册拦截器 -->
		<interceptors>
			<interceptor name="auth" class="com.itzzy.interceptor.Authinterceptor"></interceptor>
			<!-- 自定义拦截器栈 -->
			<interceptor-stack name="MyStack">
				<interceptor-ref name="defaultStack"></interceptor-ref>
				<interceptor-ref name="auth"></interceptor-ref>
			</interceptor-stack>
		</interceptors>	