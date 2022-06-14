# session 实现登录
1. version-1
使用 session 来记录用户的登录情况，这种流程很简单：登录时将用户记录在 session 中，使用服务时首先验证是否存在用户信息。

其中使用 RequestBody 注解测试时需要将 postman 的 body-raw 中将数据格式设置为 json。

2. version-2
使用过滤器，通过自定义一个继承 OncePerRequestFilter 的 filter 类，就可以不用在 ApiController 中单独验证。