# 小学设计模式

> Writer : [mercymodest](https://www.mercymodest.com)
>
> GitHub: [mercymodest-design-patterns](https://github.com/mercymodest/mercymodest-design-patterns)
>
> <span style="color:red;">xx</span>

## 前置小提示

笔者只是一个开发行业的小学生，截止目前只会一点[Java](https://www.java.com/en/download/help/whatis_java.html)，故以下的所有设计模式的示例代码都是基于`Java`来实现的呢

## 什么是设计模式

> ​		在 1994 年，由 Erich Gamma、Richard Helm、Ralph Johnson 和 John Vlissides 四人合著出版了一本名为 Design Patterns - Elements of Reusable Object-Oriented Software（中文译名：设计模式 - 可复用的面向对象软件元素） 的书，该书首次提到了软件开发中设计模式的概念。

## 设计模式总览

### 组件的生命周期

![image-20220301234417245](https://img.mercymodest.com/public/image-20220301234417245.png)

### 创建型设计模式

- <span style="color:red;">单例模式（`Singleton`）</span>
- 原型模式 （`Prototype`）
- <span style="color:red;">工厂方法模式 （`FactoryMethod`）</span>
- <span style="color:red;">抽象工厂模式 （`AbstractFactory`）</span>
- <span style="color:red;">建造者模式 (`Builder`)</span>

### 行为型设计模式

- 模板方法模式 (`Template Method`)
- 策略模式 (`Strategy`)
- 命令模式 (`Command`)
- 责任链模式 (`Chain Of Responsibility`)
- 状态模式 （`State`）
- 观察者模式 (`Observer`)
- 中介者模式 (`Mediator`)
- 迭代器模式 (`Iterator`)
- 访问者模式 (`Vistor`)
- 备忘录模式 (`Memento`)
- 解释器模式 (Interpreter)

### 结构型设计模式

- 代理模式 (`Proxy`)
- 适配器模式 (`Adapter`)
- 桥接模式 (`Bridge`)
- 装饰模式 (`Decorator`)
- 外观模式(`Facade`)
- 享元模式(`Flyweight`)
- 组合模式 (`Composite`)
- 过滤器模式 （`Filter`)

> TIPS: <span style="color:red;">设计模式是一种思想，灵活运用思想远大于死记硬背和咬文嚼字呢</span> 

## 程序设计的七大原则

1. 开闭原则
   - Open Closed Principle. OCP
   - 软件实体应该对拓展开发，对修改关闭
   - <span style="color:red;">拓展新类而不是修改旧类</span>
2. 里氏替换原则
   - Liskov Substitution Principle LSP
   - 继承超类需要确保超类所具有的性质在子类中任然成立
   - <span style="color:red;">去继承父类而不是去改变父类</span>
3. 依赖倒置原则
   - Dependence Inversion Principle DIP
   - 高层模块不应该依赖底层模块,两者都应该依赖其抽象;抽象不应该依赖其细节，而细节应该依赖其抽象
   - <span style="color:red;">面向接口编程，而不是面向实现编程</span>
4. 单一职责原则
   - Single Responsibility Principle SRP
   - 一个类有且只有一个引起Ta变化的原因，否则这个类应该被拆分
   - <span style="color:red;">每个类最后只负责自己的事情，而不是朝万能的方向发展</span>
5. 接口隔离原则
   - Interface Segregation Principle ISP
   - 一个类对另外一个类的一个应该建立在最小接口上
   - <span style="color:red;">每个类都有自己专用的接口，而不是建立一个万能接口上</span>
6. 迪米特法则 
   - Law Of demeter  LoD
   - 最少知道原则
   - 只与你直接的朋友交谈，不跟陌生人说话
   - <span style="color:red;">无需直接交互的两个类，如果需要交互，优先使用中间者</span>
7. 合成复用原则
   - 又叫组合/聚合复用原则
   - Composite Reuse Principle   CRP
   - 软件复用的时候，尽量使用组合或者聚合等关联关系来实习，其次再去考虑继承
   - <span style="color:red;">优先考虑组合，其次再考继承</span>

## 为什么需要创建型模式

- 创建型模式关注的是怎么创建对象
- 将对象的创建和使用分离出来
- 使用者无需关注对象创建的细节
  - 对象的创建由工厂来完成 -- 工厂模式
  - 对象由一个建造者来完成  -- 建造者模式
  - 对象的创建由原对象克隆来完成   -- 原型模式
  - 对象在这个系统中始终只有一个对象实例  -- 单例模式

### 单例模式

#### 特点

- 类的实例只有一个
- 类的实例必须自行创建
- 需要向外暴露获取类实例的方法

#### 示例代码

######  我们每一个在这个世界上都是独一无二的

```java
/**
 * 双重校验饿汉式单例模式
 *
 * @author ZGH.MercyModest
 * @version V1.0.0
 */
@Setter
@Getter
public class Person {

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 姓名
     */
    private String name;

    /**
     * person 对象实例  tips: 保证多线程环境下的可见性
     */
    private static volatile Person INSTANCE;

    /**
     * 构造器私有化
     */
    private Person() {
    }

    /**
     * 获取 {@link  Person} 对象实例
     *
     * @return {@code person}  instance
     */
    public static Person getInstance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (Person.class) {
                if (Objects.isNull(INSTANCE)) {
                    INSTANCE = new Person();
                }
            }
        }
        return INSTANCE;
    }
}
```

