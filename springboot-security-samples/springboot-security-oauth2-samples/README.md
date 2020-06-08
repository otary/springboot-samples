# springboot-security-oauth2-samples

## 访问流程

1. 访问 http://localhost:8080/oauth/authorize?client_id=abc&response_type=code&redirect_uri=http://www.baidu.com ,跳转到 http://localhost:8080/login 进行登录
2. 登录成功后跳转到 http://www.baidu.com?code=tvUwyI, 此时获取到 code 值
3. 访问 http://localhost:8080/oauth/token?grant_type=authorization_code&code=voI95w&redirect_uri=http://www.baidu.com







