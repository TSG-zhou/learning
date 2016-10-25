## Android xutils3.0网络请求使用

> 在安卓中使用xutils 框架进行post 和get 请求

- 将xutils3.0 拷贝到libs目录下

- 配置到整个安卓工程中

- 在application 中对xutils进行初始化

	1. 新建一个类，继承Application类。
	2. 在oncreate 方法中初始化
	

			@Override
		    public void onCreate() {
		        x.Ext.init(this);//初始化方法
		        super.onCreate();
		    }

	3. 初始化完毕后方能使用

###发送post请求

	String path = "http://119.29.59.185/servlet/LoginServlet";

	final RequestParams params = new RequestParams(path);
    params.addBodyParameter("username",username);
    params.addBodyParameter("password",password);

	x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println(s);
                 if ("UNE".equals(s)){
                    Toast.makeText(LoginActivity.this,"用户名密码不正确",Toast.LENGTH_SHORT).show();
                     return;
                }else if ("PSE".equals(s)){
                    Toast.makeText(LoginActivity.this,"密码不正确",Toast.LENGTH_SHORT).show();
                     return;
                }

                LxrOnline lxr = (LxrOnline) IOutils.pullParser(s);

                dao.addlxrinfo(lxr);
                startActivity(new Intent(LoginActivity.this,FragmentBaseActivity.class));
                finish();
            }

            @Override
            public void onError(Throwable ex, boolean b) {
                if (ex instanceof HttpException) { // 网络错误
                    HttpException httpEx = (HttpException) ex;
                    int responseCode = httpEx.getCode();
                    String responseMsg = httpEx.getMessage();
                    String errorResult = httpEx.getResult();
                    System.out.println(responseCode+"=="+responseMsg+"=="+errorResult);
                    // ...
                } else { // 其他错误
                    // ...
                    System.out.println("others-------");
                }
                System.out.println(ex.getMessage()+"=="+ex.getLocalizedMessage());
            }

            @Override
            public void onCancelled(CancelledException e) {
                System.out.println("cancelled"+e.toString());
            }

            @Override
            public void onFinished() {
                dia.dismiss();
            }
        });