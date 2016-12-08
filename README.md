# spring-cloud
Spring cloud是未来的趋势，所以，搭建一下。
以后为公司搭建后台服务架构。

服务注册发现--eureka-server
分布式配置——config-client-eureka和config-server-eureka
   没有和百度conf做比较?
断路器——Netflix Hystrix   compute-service中的调用
          Hystrix Dashboard 来可视化监控服务的断路状态 没有做，下一步
服务网关——Netflix Zuul  compute-gateway
          --网关检测还没有调通。
客服端负载均衡——Netflix Ribbon 下一步做成