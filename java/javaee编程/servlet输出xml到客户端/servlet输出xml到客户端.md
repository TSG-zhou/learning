##servlet输出xml到客户端

>使用dom4j 框架构建发送xml文件到客户端

    public void buildXML(Tuser tu, HttpServletResponse response){
		Document document = DocumentHelper.createDocument();
		
		Element user = document.addElement("Users");
		Element nike = user.addElement("nikename");
		nike.setText(tu.getNikename());
		Element username = user.addElement("username");
		username.setText(tu.getUsername()+"");
		Element lasttime = user.addElement("lasttime");
		lasttime.setText(tu.getLastTime()+"");
		Element lastadd = user.addElement("lastadd");
		lastadd.setText(tu.getLastAddress()+"");
		
		try {
			XMLWriter out = new XMLWriter(response.getWriter());
			out.write(document);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}