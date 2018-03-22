### Android Studio Code Formatter 说明文档

formatter.xml修改
> 打开eclipse中的windows>Preferences搜索“Formatter”，选中Java>Code Style>Formatter,在右侧选择Import按钮导入本地的formatter.xml文件，再点击Edit按钮进行编辑，修改完毕后点击OK按钮，然后在原来的界面点击Export All按钮导出修改后的formatter.xml文件
#### Android Studio安装Eclipse Code Formatter插件
> 打开Android Studio中的Settings>Plugins，选择Browse Repositories按钮，然后搜索“Eclipse Code Formatter”，点击Install安装成功后，需要重启Android Studio

#### 使用Eclipse Code Formatter插件
> 打开Android Studio中的Settings>Other Settings>Eclipse Code Formatter，在右侧选择 Use the Eclipse code formatter单选框，添加下方的Eclipse Java Formatter config file文件路径即我们的formatter.xml文件路径。然后在Android Studio主界面工具栏中将Format切换成Eclipse(图标)，就可以使用快捷键Formatter代码了