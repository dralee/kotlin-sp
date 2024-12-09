# kotlin-sp
kotlin somethin for

### 包
kotlin源文件不需要相匹配的目录和包，源文件可以放在任何文件目录
如没指定包名，默认为default包。

#### 默认包
有多个包会默认导入到每个 Kotlin 文件中：
```
kotlin.*
kotlin.annotation.*
kotlin.collections.*
kotlin.comparisons.*
kotlin.io.*
kotlin.ranges.*
kotlin.sequences.*
kotlin.text.*
```
### 类型
每种类型都有以下转换方法：
```
toByte(): Byte
toShort(): Short
toInt(): Int
toLong(): Long
toFloat(): Float
toDouble(): Double
toChar(): Char
```
#### Int和Long类型，还有位操作符
```
shl(bits) – 左移位 (Java’s <<)
shr(bits) – 右移位 (Java’s >>)
ushr(bits) – 无符号右移位 (Java’s >>>)
and(bits) – 与
or(bits) – 或
xor(bits) – 异或
inv() – 反向
```
### 类
类修改符
类的修饰符包括 classModifier 和_accessModifier_:
* classModifier: 类属性修饰符，标示类本身特性。
```
abstract    // 抽象类
final       // 类不可继承，默认属性
enum        // 枚举类
open        // 类可继承，类默认是final的
annotation  // 注解类
```
* accessModifier: 访问权限修饰符
```
private    // 仅在同一个文件中可见
protected  // 同一个文件中或子类可见
public     // 所有调用的地方都可见
internal   // 同一个模块中可见
```
#### 继承
Kotlin 中所有类都继承Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类
注意：Any 不是 java.lang.Object
如果一个类要被继承，可以使用 open 关键字进行修饰

