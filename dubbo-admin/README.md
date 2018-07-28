参考https://github.com/apache/incubator-dubbo-ops整理出来的dubbo admin程序。


**有两种方式可以启动，注意先启动ZooKeeper**

1. 直接执行main方法，在类`DubboAdminApplication`中

2. 使用maven打包，然后执行jar包

   ```
   mvn clean package
   java -jar dubbo-admin-0.0.1-SNAPSHOT.jar
   ```

**开发环境**
- jdk 1.8
- eclipse-oxygen (4.7.3)
- maven 3.5.2
- dubbo 2.6.2 / 2.6.3

