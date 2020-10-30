# Netty 网关
***
*学习性质的网关，此学习项目将逐步详细记录演进过程*

## 学习参考
&ensp;&ensp;&ensp;&ensp;自己也是第一次接触Netty，学习完以后感觉Netty是真的好用，这里将自己学习过程中的一些资料和学习路径记录下来，希望对大家有所启发

&ensp;&ensp;&ensp;&ensp;训练营中的讲述的方式是从底向上，如果之前没接触过，感觉还是写不出来，所以还是需要学习下其他资料

#### 极客时间 视频专栏 《Netty源码剖析与实战》
&ensp;&ensp;&ensp;&ensp;这个视频可以算是五星，作者讲解的很好，在这个专栏可以收获的是netty的相关知识、netty基本功能、netty
的扩展功能、阅读源码教学。这种是自顶向下，个人更喜欢这种方式吧，看完以后，有个大概的了解，例子写写，跑跑，大概也就半只脚进去了。

&ensp;&ensp;&ensp;&ensp;建议2-3倍速（Video Speed Control，可以用这个谷歌浏览器插件到3倍速）食用，1-3天可以刷完。第一遍主要是对它有个了解。这课质量还是有的，深挖还是需要下来下功夫。

&ensp;&ensp;&ensp;&ensp;学完以后心中差不多对netty能做什么有了了解了，想写，但还是写不出来，哈哈，我是这样的，需要看下面的。

#### 官方文档
- [User guide for 4.x](https://netty.io/wiki/user-guide-for-4.x.html
):这篇强烈推荐，仔细看完，将其中的代码自己敲一遍（不要复制，代码是手艺活，得亲自上手），搞完你对netty写一些简单的东西差不多就掌握了

- [Documentation](https://netty.io/wiki/index.html):总文档，API、变化等有空也可以点点，重要的是例子（建议直接拉取git仓库的源码，网页上看着有点不方便）
    - [Snoop](https://netty.io/4.1/xref/io/netty/example/http/snoop/package-summary.html) ‐ 构建自己的轻量级HTTP客户端和服务器,Http
    服务端和客户端示例，写网关的基础参考
    - Proxy：这个也在示例里面，代理的实现例子，对网关实现也有参考价值

## V1.0
### 版本功能
- 将 localhost:80/ 转到 localhost:8080/，并返回结果

### 工程结构
- client：此模块负责将请求目标服务
- server：负责接收用户请求

### 代码说明
&ensp;&ensp;&ensp;&ensp;代码思路大致如下图：

![](./picture/v1.png)

&ensp;&ensp;&ensp;&ensp;网关流程：用户发起请求，server端接收到请求，将请求转给client，client发送请求给内部服务，得到结果以后将结果返回给用户。

&ensp;&ensp;&ensp;&ensp;代码编写中一个难点是，server端和client端的结合。这里采用的是，在server端处理请求的时候，将当前channel传递到client handler中，这样client
 handle得到结果后，直接使用server channel返回结果即可。代码比较少也比较简单，这里就不贴了。
 
 ## TODO
 - server 调用client 请求的方式，是否存在线程过多创建问题或者浪费问题，需要进行排查和改善，或者改进两者之间的通信方式
 - 路由模块的编写：目前是硬编码，难看的很，后期改善成动态配置型的
 - 过滤模块的编写：对用户请求的前置处理和后置处理

