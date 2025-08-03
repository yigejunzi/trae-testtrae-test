# Spring Boot Demo Project (JDK 8)

## 项目介绍
这是一个简单的Spring Boot项目，使用JDK 8，包含一个REST控制器和一个静态主页。

## 启动项目
### 正常启动
```
mvn spring-boot:run
```

项目将在9090端口启动，访问地址：
- 主页：http://localhost:9090
- Hello端点：http://localhost:9090/hello

### 调试模式启动
1. 运行调试脚本：
```
debug.bat
```

2. 在IDEA中配置远程调试：
   - 打开IDEA
   - 点击"Run" -> "Edit Configurations..."
   - 点击"+"号，选择"Remote JVM Debug"
   - 配置如下：
     - Name: Spring Boot Debug
     - Host: localhost
     - Port: 5005
   - 点击"OK"保存配置

3. 启动调试：
   - 在IDEA中设置断点
   - 点击"Debug"按钮启动远程调试
   - 脚本将等待调试器连接后才继续启动应用

## 项目结构
- `src/main/java`: Java源代码
- `src/main/resources`: 资源文件
  - `application.properties`: 配置文件
  - `static/`: 静态资源文件

## 端口配置
应用默认在9090端口运行，可在`src/main/resources/application.properties`中修改。

## Elasticsearch和Kafka集成
项目已集成Elasticsearch和Kafka，提供了以下API端点：

### Elasticsearch端点
- 保存产品：POST http://localhost:9090/es-kafka/product
- 获取产品：GET http://localhost:9090/es-kafka/product/{id}

### Kafka端点
- 发送消息：POST http://localhost:9090/es-kafka/message?message=your_message_here

使用这些端点前，请确保已安装并运行Elasticsearch和Kafka服务。