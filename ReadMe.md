# session 实现登录
1. version-1
使用 session 来记录用户的登录情况，这种流程很简单：登录时将用户记录在 session 中，使用服务时首先验证是否存在用户信息。

其中使用 RequestBody 注解测试时需要将 postman 的 body-raw 中将数据格式设置为 json。

2. version-2
使用过滤器，通过自定义一个继承 OncePerRequestFilter 的 filter 类，就可以不用在 ApiController 中单独验证。
   
# jwt 实现登录
jwt的登录流程和 session 基本是相同的，不同之处在于
1. jwt 将数据加密传输，在服务器解密
2. 服务器不保存用户数据，通过 jwt 校验方法来判断登录信息

进度
1. version-1
使用 jwt，流程如下：
   1. 调用 login 进行登录，jwt 生成 token（token 具有时效），并返回
   2. 调用 api 的请求中必须带有 “Authorization” 字段，字段解析成功则登录成功