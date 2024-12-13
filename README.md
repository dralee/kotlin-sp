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
### 函数式(SAM)接口
函数式接口和类型别名用途并不相同。 类型别名只是现有类型的名称——它们不会创建新的类型，而函数式接口却会创建新类型。
类型别名只能有一个成员，而函数式接口可以有多个非抽象成员以及一个抽象成员。 函数式接口还可以实现以及继承其他接口。
函数式接口比类型别名更灵活并且提供了更多的功能, 但它们在语法上和运行时的代价都会更高，因为它们可能需要转换到特定的接口。 当您选择在代码中使用哪种类型时，请考虑您的需求：如果您的应用程序接口需要接受具有某些特定参数和返回类型的函数（任何函数），请使用简单的功能类型或定义一个类型别名，为相应的功能类型提供一个更简短的名称。 如果您的应用程序接口接受比函数更复杂的实体，例如，它具有无法用功能类型的签名来表达的非难合约和/或操作，请为它声明一个单独的功能接口。

### 可见性
在 Kotlin 中有这四个可见性修饰符：private、 protected、 internal 和 public。 默认可见性是 public。
#### 包
* 如果你不使用任何可见性修饰符，默认为 public，这意味着你的声明将随处可见。
* 如果你声明为 private，它只会在声明它的文件内可见。
* 如果你声明为 internal，它会在相同模块内随处可见。
* protected 修饰符不适用于顶层声明。
要使用另一包中可见的顶层声明，需要将其导入进来。

#### 类成员
对于类内部声明的成员：
* private 意味着只该成员在这个类内部（包含其所有成员）可见；
* protected 意味着该成员具有与 private 一样的可见性，但也在子类中可见。
* internal 意味着能见到类声明的本模块内的任何客户端都可见其 internal 成员。
* public 意味着能见到类声明的任何客户端都可见其 public 成员。
|在 Kotlin 中，外部类不能访问内部类的 private 成员。
如果你覆盖一个 protected 或 internal 成员并且没有显式指定其可见性，该成员还会具有与原始成员相同的可见性。

#### 构造函数
默认情况下，所有构造函数都是公开（public）的，这实际上等于类可见的地方它就可见（即 一个 internal 类的构造函数只能在相同模块内可见).

#### 模块
可见性修饰符 internal 意味着该成员只在相同模块内可见。更具体地说， 一个模块是编译在一起的一套 Kotlin 文件，例如：
* 一个 IntelliJ IDEA 模块
* 一个 Maven 项目
* 一个 Gradle 源代码集（例外是 test 源代码集可以访问 main 的 internal 声明）
* 一次 <kotlinc> Ant 任务执行所编译的一套文件

#### 扩展
Kotlin 能够对一个类或接口扩展新功能而无需继承该类或者使用像装饰者这样的设计模式。 这通过叫做扩展的特殊声明完成。
例如，你可以为一个你不能修改的、来自第三方库中的类或接口编写一个新的函数。 这个新增的函数就像那个原始类本来就有的函数一样，可以用寻常方式调用。 这种机制称为扩展函数。此外，也有扩展属性， 允许你为一个已经存在的类添加新的属性。
声明一个扩展函数需用一个接收者类型也就是被扩展的类型来作为他的前缀。

### 数据类
编译器自动从主构造函数中声明的所有属性导出以下成员：
* equals()/.hashCode() 对。
* toString() 格式是 "User(name=John, age=42)"。
* componentN() 函数 按声明顺序对应于所有属性。
* copy() 函数（见下文）
为了确保生成的代码的一致性以及有意义的行为，数据类必须满足以下要求：
* 主构造函数必须至少有一个参数。
* 主构造函数的所有参数必须标记为 val 或 var。
* 数据类不能是抽象、开放、密封或者内部的。
此外，数据类成员的生成遵循关于成员继承的这些规则：
* 如果在数据类体中有显式实现 .equals()、 .hashCode() 或者 .toString()，或者这些函数在父类中有 final 实现，那么不会生成这些函数，而会使用现有函数。
* 如果超类型具有 open 的 .componentN() 函数并且返回兼容的类型， 那么会为数据类生成相应的函数，并覆盖超类的实现。如果超类型的这些函数由于签名不兼容或者是 final 而导致无法覆盖，那么会报错。
* 不允许为 .componentN() 以及 .copy() 函数提供显式实现。
数据类可以扩展其他类





