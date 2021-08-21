基于注解的策略模式实现
==================

##### **策略模式**，定义统一的行为（接口或抽象类），并实现不同策略下的处理逻辑（实现类）。客户端在使用时自己选择相应的处理类，利用工厂或其他方式。


`OrderHandler` 订单处理接口，定义统一的行为handle()

`MobileOrderHandler` 订单处理类，实现`OrderHandler`接口，定义移动端订单的处理逻辑

`PCOrderHandler` 订单处理类，实现`OrderHandler`接口，定义PC端订单的处理逻辑

`@OrderHandlerType(source="订单来源", payMethod="订单支付方式")` 此注解表明一个订单处理类的订单来源及订单支付方式，
作用是在真正处理订单逻辑时，通过此注解来决定选用哪个`OrderHandler`处理订单

`OrderHandlerTypeImpl` 注解`OrderHandlerType`的实现类，主要作用时重写了hashCode() and equals()方法，
以便在使用`OrderHandlerType`作为Map的key时，能正确匹配到对应的`OrderHandlerType`实例

`OrderService` 订单处理类，
初始化时会注入`OrderHandler`接口的所有实现类，以`OrderHandlerType`为key，`OrderHandler`的实现类为value，
在真正处理订单时会根据`OrderHandlerType`注解的具体情况获取到对应的`OrderHandler`实现类，然后调用handle()方法处理订单
