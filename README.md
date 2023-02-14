# chatgpt_springboot
使用springboot将chatgpt对接到微信公众号

第一步：
打开openAI官网https://chat.openai.com/auth/login
注册一个账号并登陆
![image](https://user-images.githubusercontent.com/87122321/218243014-d5d1b163-c426-4cf0-a869-dd92cb2e3524.png)


第二步：
打开 https://openai.com/api/ 登陆
![image](https://user-images.githubusercontent.com/87122321/218243262-cc5a25a2-ace2-4460-9870-c14a62d3a8a5.png)
![image](https://user-images.githubusercontent.com/87122321/218243346-65266adc-2a10-4a69-afb0-a6d732ffbbc6.png)
创建一个key并复制
![image](https://user-images.githubusercontent.com/87122321/218243427-3aade624-7bfa-4045-8cc8-ead5cea59bf5.png)
![image](https://user-images.githubusercontent.com/87122321/218243508-8f7aa0a0-6012-4990-996c-660f03e4ce67.png)

打开项目中的application,将key替换进去
![image](https://user-images.githubusercontent.com/87122321/218243751-9b26ef2f-7c74-4db4-bc91-bcb754925999.png)

第三步：
打开https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index注册微信测试公众号并登陆
设置一个自己需要的key
![image](https://user-images.githubusercontent.com/87122321/218641625-5b5ccd1f-cbe7-4563-a1e4-b95fa28fb91a.png)
填入application.yml
![image](https://user-images.githubusercontent.com/87122321/218641937-c1f2b2c2-984e-467f-bad2-7607ebde9b9b.png)

第四步：
启动项目
![image](https://user-images.githubusercontent.com/87122321/218642416-1f4f17d5-44a9-4758-8e04-9bebfea7933a.png)

在微信公众平台url中填入接口信息，马赛克的地方为你的ip地址和端口
![image](https://user-images.githubusercontent.com/87122321/218642252-f3ff5315-1c7d-439f-a8e2-6b0ab8048a3d.png)
点击提交
![image](https://user-images.githubusercontent.com/87122321/218642493-9a1845d9-3413-4b14-abf0-45736a07ae78.png)
出现配置成功便成功了
