#### ZooKeeper 常用Java API

主要参考了[W3C School ZooKeeper教程](https://www.w3cschool.cn/zookeeper/)

不过将原来代码中的一些匿名内部类换成了Lambda表达式的实现方式。 本例用的都是ZooKeeper自己的API，其实还有一些第三的API用起来可能更方便，如ZKClient (本例pom中已经引入了)， 还有[Apache Curator](http://curator.apache.org/)。

** 开发环境：**
- jdk 1.8
- eclipse-oxygen (4.7.3)
- maven 3.3.9
- zookeeper-3.4.13

