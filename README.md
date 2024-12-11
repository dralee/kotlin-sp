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

#### 修饰符
如果一个声明有多个修饰符，请始终按照以下顺序安放：
```
public / protected / private / internal
expect / actual
final / open / abstract / sealed / const
external
override
lateinit
tailrec
vararg
suspend
inner
enum / annotation / fun // 在 `fun interface` 中是修饰符
companion
inline/ value
infix
operator
data
```
将所有注解放在修饰符前：
```
@Named("Foo")
private val foo: Foo
```

### 包
#### 默认导入
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
根据目标平台还会导入额外的包：

JVM:
```
java.lang.*
kotlin.jvm.*
```
JS:
```
kotlin.js.*
```
#### 导入包
除了默认导入之外，每个文件可以包含它自己的导入（import）指令。
可以导入一个单个名称：
```
import org.example.Message // 现在 Message 可以不用限定符访问
```
也可以导入一个作用域下的所有内容：包、类、对象等:
```
import org.example.* // “org.example”中的一切都可访问
```
如果出现名字冲突，可以使用 as 关键字在本地重命名冲突项来消歧义：
```
import org.example.Message // Message 可访问
import org.test.Message as TestMessage // TestMessage 代表“org.test.Message”
```
