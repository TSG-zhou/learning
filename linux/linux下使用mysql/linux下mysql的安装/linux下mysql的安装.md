##linux下mysql的安装

 **参考：[http://dev.mysql.com/doc/refman/5.7/en/linux-installation-yum-repo.html](http://dev.mysql.com/doc/refman/5.7/en/linux-installation-yum-repo.html)**

----------

	
- 添加MySQL Yum资源库
	1. 首先,将MySQL Yum资源库添加到系统。 
	2. 去下载MySQL Yum ：[http://dev.mysql.com/downloads/repo/yum/](http://dev.mysql.com/downloads/repo/yum/) 
	3. 选择和下载平台的发布包。


----------

- 找到下载好的Yum资源包
	1. 将资源包本地安装到linux系统中
	
		`shell> yum localinstall <资源包的名字>.rpm`	
	2. 检查Yum资源库中匹配mysql.  的文件
	
		`shell> yum repolist enabled | grep "mysql.*-community.*"`
	3. 
	
		
		
	

