# 更改checkbox默认样式 #
---
> 更改checkbox默认样式就是更改checkbox 的主题，即在/res/values/styles.xml 中添加样式即可

### 1 在/res/drawable 中创建 .xml 文件，加入如下代码

    <?xml version="1.0" encoding="utf-8"?>
	<selector xmlns:android="http://schemas.android.com/apk/res/android">
	    <item android:drawable="@drawable/press_check_background" android:state_checked="true" />
	    <item android:drawable="@drawable/normal_checked_cycle" android:state_checked="false"/>
	    <item android:drawable="@drawable/normal_checked_cycle" />
	</selector>
	
> android:drawable 属性可以为图片，也可以为资源文件所画的图

### 2 在/res/drawable 中创建 normal_checked_cycle.xml 文件，加入如下代码
	<?xml version="1.0" encoding="utf-8"?>
	<shape
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    android:shape="oval"
	    android:useLevel="false">
	    <solid android:color="@color/circlebackground"/>
	    <padding
	        android:left="1dp"
	        android:top="1dp"
	        android:right="1dp"
	        android:bottom="1dp" />
	    <solid
	        android:color="@color/circlebackground" />
	    <stroke
	        android:width="0.1dp"
	        android:color="@color/circlecolor" />
	    <size android:width="10dp"
	        android:height="10dp" />
	</shape>
**shape语法**

    <?xml version="1.0" encoding="utf-8"?>
	<shape
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    android:shape=["rectangle" | "oval" | "line" | "ring"] >
		//rectangle : 长方形 (默认的形状)
		//oval : 椭圆形(或圆形)
		//line : 
		//ring : 
	    <corners	// 圆角
	        android:radius="integer"
	        android:topLeftRadius="integer" 左上角
	        android:topRightRadius="integer" 右上角
	        android:bottomLeftRadius="integer" 左下角
	        android:bottomRightRadius="integer" /> 左下角
	    <gradient	// 渐变
	        android:angle="integer"
	        android:centerX="integer"
	        android:centerY="integer"
	        android:centerColor="integer"
	        android:endColor="color"
	        android:gradientRadius="integer"
	        android:startColor="color"
	        android:type=["linear" | "radial" | "sweep"]
	        android:useLevel=["true" | "false"] />
	    <padding	/ /间隔
	        android:left="integer"
	        android:top="integer"
	        android:right="integer"
	        android:bottom="integer" />
	    <size
	        android:width="integer"
	        android:height="integer" />
	    <solid	// 实心，就是填充的意思
	        android:color="color" />
	    <stroke	// 描边
	        android:width="integer"
	        android:color="color"
	        android:dashWidth="integer"
	        android:dashGap="integer" />
	</shape>

### 3 使用做好的shape图
		
> 在布局文件中添加如下代码，checbox中引用该style，即可实现自定义checkbox样式

    <CheckBox
            android:clickable="false"
            android:id="@+id/cb_login_check"
            android:checked="true"
            android:layout_gravity="center"
            style="@style/LoginCheckBoxTheme"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
