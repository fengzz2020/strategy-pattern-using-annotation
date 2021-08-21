基于注解的策略模式实现
==================

##### **策略模式**，定义统一的行为（接口或抽象类），并实现不同策略下的处理逻辑（实现类）。客户端在使用时自己选择相应的处理类，利用工厂或其他方式。


`OrderHandler` 订单处理接口，定义统一的行为handle()

`MobileOrderHandler` 实现OrderHandler接口，定义移动端订单的处理逻辑

`PCOrderHandler` 实现OrderHandler接口，定义PC端订单的处理逻辑

`@OrderHandlerType(source="订单来源", payMethod="订单支付方式")` 此注解表明一个订单处理类的订单来源及订单支付方式
作用是在真正处理订单逻辑时，通过此注解来决定选用哪个OrderHandler处理订单

`OrderHandlerTypeImpl` 注解OrderHandlerType的实现类，主要作用时重写了hashCode() and equals()方法，
以便在使用OrderHandlerType作为Map的key时，能正确匹配到对应的OrderHandlerType实例

`OrderService` 订单处理类
初始化时会注入OrderHandler接口的所有实现类，以OrderHandlerType为key，OrderHandler的实现类为value，
在真正处理订单时会根据OrderHandlerType注解的具体情况获取到对应的OrderHandler实现类，然后调用handle()方法处理订单
