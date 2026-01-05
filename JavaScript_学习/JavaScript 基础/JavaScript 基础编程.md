# JavaScript 基础编程

# ECMAScript 基础语法

# JavaScript概述

## 认识JavaScript

### JavaScript的起源

1. 诞生背景

在 1995 年之前，万维网（World Wide Web）是非常原始的。

- 网页是静态的：只有 HTML 和简单的 CSS。

- 交互的痛点：如果你在网页上填写一个表单（比如注册信息），浏览器无法检查你是否漏填了名字。你必须点击“提交”，数据传到服务器，服务器检查后发现错误，再把页面传回来告诉你“请填写名字”。

- 网速限制：当时的拨号上网速度极慢（28.8kbps），这种“提交-等待-重填”的循环让用户极其痛苦。


需求：Netscape（网景公司，当时的浏览器霸主）急需一种在浏览器端就能运行的小型脚本语言，用来处理简单的表单验证。

2. 十日奇迹

- 时间：1995 年 5 月。

- 人物：Brendan Eich (布兰登·艾克)。

- 任务：网景公司要求他在极短的时间内设计出一款像 Scheme 一样强大，但语法像 Java 一样（为了蹭热度）简单的语言。

- 结果：Brendan Eich 仅用了 10 天 就设计并实现了这门语言的原型。

3. 命名风波

JavaScript 的名字是计算机历史上最成功的“营销骗局”之一。它经历过三次更名：

- Mocha (摩卡)：开发阶段的代号。

- LiveScript：1995 年 9 月，随 Netscape Navigator 2.0 Beta 发布时的名字。

- JavaScript：1995 年 12 月，正式发布时改名。

4. 浏览器大战与标准化

看到 Netscape 的成功，微软在 1996 年推出了 IE 3.0 浏览器，并搭载了自己的脚本语言。为了避开商标版权，微软将其命名为 JScript。

此时市面上出现了两个版本：

- Netscape 的 JavaScript

- Microsoft 的 JScript

5. 混乱与统一

由于两家公司的实现标准不一致，开发者必须为不同的浏览器写两套代码。为了结束这种混乱，1997 年，网景公司将 JavaScript 提交给 ECMA 

International（欧洲计算机制造商协会）进行标准化。

6. ECMAScript 的诞生

ECMA 发布了标准 ECMA-262，该标准定义的脚本语言被称为 ECMAScript (简称 ES)。

ECMAScript：是标准（规格书）。

JavaScript：是该标准的实现（也是最流行的实现，其他实现还有 ActionScript 等）。

7. 版本演变时间轴

|  版本  | 年份 |  状态  |                           关键特征                           |
| :----: | :--: | :----: | :----------------------------------------------------------: |
|  ES1   | 1997 | 初始版 |                    确立了语言的基本语法。                    |
|  ES3   | 1999 | 里程碑 |   正则表达式、异常处理 (try-catch)。它统治了互联网 10 年。   |
|  ES4   |  -   |  流产  |         过于激进，导致各方无法达成一致，最终被废弃。         |
|  ES5   | 2009 | 稳定版 | 我们刚刚学完的所有内容。引入了 strict mode、JSON、数组高阶方法等。它是现代 JS 的基石。 |
|  ES6   | 2015 | 变革版 | 正式名称 ES2015。引入 class、module、arrow function、let/const。这是 JS 现代化的开始。 |
| ESNext | 每年 |  迭代  |    从 2015 年起，每年发布一个小版本 (ES2016, ES2017...)。    |

### JavaScript的作用

在浏览器端开发中，JavaScript 与 HTML、CSS 共同构成了网页的基石。

|    技术    | 角色隐喻  |                      核心职责                      |
| :--------: | :-------: | :------------------------------------------------: |
|    HTML    |   骨架    |     提供网页的结构和内容（标题、段落、图片）。     |
|    CSS     |   皮肤    |     负责网页的样式和布局（颜色、字体、排版）。     |
| JavaScript | 灵魂/肌肉 | 负责网页的行为和逻辑（交互、动态更新、数据处理）。 |

>没有 JavaScript，网页只是死板的电子文档；有了 JavaScript，网页就变成了可交互的应用程序。

作为脚本语言，JavaScript 在浏览器中主要执行以下四大类任务：

1. 页面交互与 DOM 操作

这是 JS 最原始也是最直观的作用。它允许代码实时修改网页内容。

- 修改内容：点击“登录”按钮，将“请登录”变为“欢迎您，User”。

- 修改样式：点击“夜间模式”开关，背景变黑，文字变白。

- 控制显隐：点击下拉菜单，显示隐藏的选项列表。

2. 数据交互

在不刷新整个页面的情况下，与服务器交换数据。

- 场景：您在浏览新闻流时，滚动到底部，自动加载更多新闻，而不需要跳转页面。
- 作用：JS 向服务器发送请求 $\rightarrow$ 拿到 JSON 数据 $\rightarrow$ 解析并插入到页面中。

3. 逻辑控制与表单验证 

将计算和检查逻辑从服务器转移到客户端（浏览器），减轻服务器压力，提升用户体验。

- 表单验证：在用户点击提交前，检查“密码是否少于 6 位”、“邮箱格式是否正确”。
- 复杂计算：网页版计算器、理财收益估算。

4. 本地存储

- Cookies / LocalStorage：记住用户的登录状态、购物车数据或浏览历史，即使用户关闭了浏览器再打开，数据依然存在。

超越浏览器的生态：
在 2009 年 Node.js 发布之前，JS 只能运行在浏览器里。但现在（2026年），JS 已经是一种全栈语言 (Full-stack Language)。

1. 服务端开发

- 通过 Node.js 环境，JavaScript 可以像 Java 或 Python 一样运行在服务器上。
- 能力：操作数据库、读写服务器文件、处理高并发网络请求。


2. 移动端与桌面端

- 移动应用：使用 React Native 或 Flutter (JS版)，可以用 JS 编写原生的 iOS 和 Android App。
- 桌面应用：使用 Electron，可以用 JS 开发跨平台的桌面软件（例如 VS Code, Discord 都是用 JS 写的）。

### JavaScript的基本特点

1. 解释型脚本语言
2. 动态弱类型
3. 基于原型的面向对象
4. 函数作为一等公民
5. 单线程与事件驱动
6. 跨平台

### JavaScript的组成

在浏览器环境中，JavaScript = ECMAScript + DOM + BOM。

## 第一个JavaScript

### JS 脚本编辑器

在 2025 年的软件开发和测试领域，JavaScript 编辑器主要分为两大阵营：轻量级编辑器和集成开发环境 (IDE)。

- Visual Studio Code
- WebStorm
- Sublime Text / Atom / Notepad++

### JS 脚本基本结构

JavaScript (JS) 是一门极其灵活的语言，它没有像 Java 那样强制的类结构，但为了代码的可读性、可维护性和执行效率，现代 JavaScript 脚本通常

遵循特定的组织结构。

一个编写良好的 JavaScript 文件（无论是 `.js` 还是 Vue 组件中的 `<script>`）通常遵循以下顺序：

1. 指令与元数据 (Directives): 如开启严格模式。

2. 导入依赖 (Imports): 引入其他模块、库或 CSS。

3. 常量与配置 (Constants & Config): 定义脚本中通用的静态变量。

4. 状态与变量 (State & Variables): 定义模块级变量。

5. 辅助函数 (Helper Functions): 具体的工具逻辑。

6. 主逻辑/类定义 (Main Logic/Class): 核心业务逻辑。

7. 导出/执行 (Exports/Execution): 暴露接口或启动脚本。

### JavaScript 的引用方式

在 HTML 中引入 JavaScript 脚本主要有三种方式：行内引用、内部引用和外部引用。

1. 行内引用

将 JavaScript 代码直接写在 HTML 标签的事件属性中

- 语法

```html
<标签名 事件="JS代码">
```

- 示例

```html
<button onclick="alert('你好，这是行内代码！')">点击我</button>

<a href="javascript:void(0)">点击无反应</a>
```

2. 内部引用

在 HTML 文件中使用 `<script>` 标签，将 JavaScript 代码包裹在其中。通常位于 `<head>` 部分或 `<body>` 的底部。

- 语法： 

```html
<script> ...代码... </script>
```

- 示例：

```html
<!DOCTYPE html>
<html>
<head>
    <title>内部引用示例</title>
</head>
<body>
    <script>
        // 在这里编写 JS 代码
        console.log("这是内部引用的代码");

        function sayHello() {
            console.log("Hello World");
        }
        sayHello();
    </script>
</body>
</html>
```

3. 外部引用

将 JavaScript 代码编写在独立的 `.js` 文件中，通过 HTML 的 `<script>` 标签的 `src` 属性引入。

- 语法： 

```html
<script src="文件路径.js"></script>
```

- 示例：

文件：script.js

```js
function showMessage() {
    console.log("这是来自外部文件的代码");
}
```

文件：index.html

```html
<!DOCTYPE html>
<html>
<body>
    <h1>我的网页</h1>

    <script src="script.js"></script>
</body>
</html>
```

>推荐：外部引用>内部引用

### JavaScript 注释与结束符

JavaScript 的注释与结束符不仅仅是基础语法规范，更是代码可维护性与解释器词法分析的关键组成部分。

#### 注释

注释是源代码中被解释器或编译器忽略的文本段落，主要用于提升代码的可读性、生成文档以及进行调试排错。在 JavaScript 中，注释分为三种主要形式：

1. 单行注释

语法符号： `//`

技术描述： 从 `//` 开始直到行尾的所有字符都会被 JavaScript 引擎视为注释并忽略。

```js
// 初始化最大重试次数 (常量定义)
const MAX_RETRIES = 5;
```

2. 多行注释

- 语法符号： `/* ... */`
- 技术描述： 解释器会忽略 `/*` 和 `*/` 之间的所有内容。它可以跨越多行，也可以嵌入在单行代码的中间。

```js
/*
  检测网络连接状态
  如果连接失败，将触发重试逻辑
*/
checkConnection();
```

3. 文档注释

- 语法符号： `/** ... */`
- 技术描述： 这是一种特定格式的多行注释，遵循 JSDoc 规范。现代 IDE（如 VS Code, WebStorm）会解析此类注释，为函数调用提供智能提示（IntelliSense）、参数类型检查和自动文档生成。

```js
/**
 * 发送 API 请求并返回结果
 * @param {string} url - 请求地址
 * @param {Object} data - 请求负载
 * @returns {Promise<Object>} 响应数据
 */
async function sendRequest(url, data) {
    // 逻辑实现...
}
```

#### 结束符

在 C 类语言家族中，分号（`;`）通常作为语句结束符，标志着一个指令序列的终结。

1. 显式分号

- 描述：开发者在每条语句末尾手动添加`;`。

2. 自动分号插入机制

JavaScript 引擎内置了一个名为 ASI 的机制。当解析器在解析代码流时，如果发现语法不符合预期，它会尝试自动在行尾插入分号以修正语法错误。

### JavaScript 输入与输出语句

#### 输出语句

JavaScript 并不像 C 或 Python 那样有标准的 `print`函数，它的输出取决于运行环境（浏览器或 Node.js）。

1. 控制台输出(Console)

这是最常用、最专业的调试方式。数据会输出到浏览器的开发者工具（F12 -> Console）或 Node.js 的终端中。它不会打断代码执行。

- 语法：

```js
 console.log(内容)
```

- 示例：

```js
// 基本输出
console.log("测试开始执行...");

// 输出变量
let score = 98;
console.log("当前分数:", score);

// 警告与错误（在控制台中会有不同颜色标记，方便快速定位问题）
console.warn("注意：内存占用过高");
console.error("致命错误：API 连接失败");
```

2. 警示框输出 (Alert)

浏览器提供的模态弹窗。

- 语法： 

```js
alert(内容)
```

- 特点： 会阻塞代码执行，用户点击“确定”前脚本暂停。

>在现代 Vue 开发或自动化测试中极少使用，因为体验差且阻断流程。仅用于极简单的调试。

- 示例：

```js
alert("密码错误！");
```

3. 页面内容输出 (Document Write)

直接将内容写入 HTML 文档流。

- 语法： 

```js
document.write(内容)
```

>极不推荐。如果在页面加载完成后执行此语句，它会覆盖整个页面。

#### 输入语句

1. 输入框 (Prompt)

弹出一个带输入框的对话框。

- 语法： 

```js
prompt("提示信息", "默认值")
```

- 返回值： 用户输入的字符串。如果用户点击取消，返回 null。
- 示例：

```js
let userName = prompt("请输入您的姓名:", "Guest");
console.log("用户名为: " + userName);
```

2. 确认框 (Confirm)

弹出一个带“确定”和“取消”按钮的对话框。

- 语法： 

```js
confirm("提示信息")
```

- 返回值： 布尔值 (true 或 false)。
- 适用场景： 删除操作前的二次确认。
- 示例：

```js
let isDelete = confirm("确定要删除这条测试用例吗？");
if (isDelete) {
    console.log("正在删除...");
} else {
    console.log("取消操作");
}
```

#### 字面量

字面量是指在代码中固定值的表示法。简单来说，就是“所见即所得”的数据。当您在代码中直接写出一个值时，那就是字面量。

以下是 JavaScript 中常见的字面量类型：

1. 数字字面量

JS 中不区分整数和浮点数，统一为 Number 类型。

```js
100      // 整数
3.14     // 小数
-5       // 负数
1.2e5    // 科学计数法 (120000)
```

2. 字符串字面量

可以使用单引号 `'` 或双引号 `"` 包裹。

```js
"Hello World"
'API Testing'
```

>模板字符串—— ES6 使用反引号 ` 包裹。
>
>它支持多行文本和变量插值。

3. 布尔字面量

只有两个值，用于逻辑判断。

```js
true
false
```

4. 对象字面量

使用花括号 `{}` 定义键值对数据。

```js
// 这是一个对象字面量
{
    name: "PetStore_API",
    version: "1.0",
    isActive: true
}
```

5. 数组字面量

使用方括号 `[]` 定义列表数据。

```js
// 数组字面量
["Unit Test", "Integration Test", "E2E Test"]
```

## Chrome 调试

Chrome 开发者工具是前端开发和自动化测试中最强大的工具。

### 元素面板

这里展示的是页面当前的 DOM 结构

- 选择元素: 点击左上角的小箭头图标，然后在页面上点击任意元素，可以直接定位到代码位置。
- 实时修改 CSS: 在右侧 `Styles` 栏，您可以直接修改 CSS 属性，页面会立即变化。
- 强制状态: 右键点击 DOM 节点 -> `Force state` -> `:hover`。可以调试鼠标悬停时的样式。

除了查看 `console.log`，这里也是一个实时的 JS 运行环境。

- 执行 JS: 可以在这里输入 JS 代码并回车执行。例如，输入 `document.title` 查看页面标题。
- 保留日志: 点击右上角的齿轮图标 -> 勾选 `Preserve log`。这对于调试页面跳转（刷新）时丢失报错信息非常有用。
- 过滤: 在过滤框输入文本，或按级别（Error/Warning）筛选，快速找到报错。

### 源代码面板

这是调试逻辑错误最重要的地方。

- 文件导航: 在左侧文件树中找到您的 `.vue` 或 `.js` 文件。

- 设置断点: 点击行号，会出现一个蓝色/红色的标记。当代码运行到这一行时，会暂停。

- 调试控制台: 暂停后，右上角会出现控制按钮：

  - Resume (F8): 继续执行直到下一个断点。

  - Step over (F10): 单步执行（不进入函数内部）。
  - Step into (F11): 进入函数内部（查看具体逻辑）。
  - Step out (Shift + F11): 跳出当前函数。

- 观察变量: 在右侧 `Watch` 面板点击 `+`，输入变量名，可以实时监控该变量值的变化。

### 网络面板

它记录所有的 HTTP 请求。

- 查看请求详情: 点击任意一个请求：
  - Headers: 查看请求头、请求方法、状态码。
  - Payload: 查看您发给后端的数据。
  - Response: 查看后端 Spring Boot 返回的 JSON 数据。检查这里可以确认后端是否返回了正确的数据。
  - Timing: 查看接口耗时，用于性能分析。
- 弱网测试: 在面板顶部的 `No throttling` 下拉菜单中选择 `Slow 3G`。这可以模拟网络由于延迟导致的加载问题，测试页面的 Loading 状态。

### 应用面板

用于查看浏览器本地存储的数据。

- Storage:
  - Local Storage / Session Storage: 查看前端持久化的数据（如用户偏好设置）。
  - Cookies: 查看登录凭证、。如果登录态失效，通常先检查这里。
- Clear Storage: 一键清除所有缓存，模拟“新用户”访问。

### 移动端模拟

点击左上角的“手机平板图标”。

- 可以模拟 iPhone、iPad 等设备的屏幕尺寸。
- 用处： 检查您的 Vue 项目在移动端布局是否崩坏，以及触摸事件是否正常。

# JavaScriptjc基础

## 变量

### 变量的定义

变量是**内存中用于存储数据的命名容器**，可理解为带标签的内存盒子：支持存入、读取、更新其中的数据。

- 声明: 向 JS 引擎声明。
- 赋值: 将数据写入已声明的变量容器。
- 初始化: 声明变量的同时，完成首次数据写入。

```js
let age;        // 声明变量age
age = 25;       // 为 age 容器存入数据 25
let name = "Jack"; // 声明 name 容器的同时，直接存入 "Jack"
```

### 变量的声明方式

JavaScript 的发展史（ES5 vs ES6）导致了三种声明方式。这是现代 JS 开发中最核心的概念。

|    特性    |          var          |           let           |          const          |
| :--------: | :-------------------: | :---------------------: | :---------------------: |
|   作用域   |      函数作用域       |       块级作用域        |       块级作用域        |
|  变量提升  | 是 (值为 `undefined`) | 否 (存在暂时性死区 TDZ) | 否 (存在暂时性死区 TDZ) |
|  重复声明  |         允许          |          禁止           |          禁止           |
|  重新赋值  |         允许          |          允许           |          禁止           |
| 初始化要求 |         可选          |          可选           |          必须           |
|  推荐指数  |           ⭐           |           ⭐⭐⭐           |          ⭐⭐⭐⭐⭐          |

### var 关键字

`var` 是 JavaScript 中最古老的变量声明关键字

1. 函数作用域

- 规则： var 声明的变量，其作用域限制在当前函数体内。
- 陷阱： 它无视块级代码块，即无视 if、for、while 或 `{}` 的边界。

```js
function testScope() {
    if (true) {
        var msg = "我在 if 块里面"; // 这里的 var 穿透了花括号
    }
    console.log(msg); //输出: "我在 if 块里面"
}
```

2. 变量提升

变量提升是`var`的专属特性：JS 引擎在代码执行前，会将当前作用域内的所有`var`声明，“提前” 到作用域的顶部。

- 只提升声明，不提升赋值。
- 结果： 在声明之前访问该变量，不会报错，而是得到 `undefined`。

```js
console.log(myName); //输出: undefined

var myName = "Jack";
```

3. 重复声明

`var` 允许你在同一作用域内多次声明同一个变量名。

```js
var price = 100;
var price = 200; //合法，覆盖前值
console.log(price); // 200
```

4. 全局对象挂载

如果在浏览器环境的最外层（全局作用域）使用 `var`，该变量会自动成为 `window` 对象的一个属性。

```js
var globalTool = "Fiddler";
console.log(window.globalTool); //"Fiddler"
```

### 变量命名规范

JavaScript 的命名规则与 Java 非常相似。

1. 强制规则:
   - 包含字母、数字、下划线 `_`、美元符号 `$`。
   - 不能以数字开头。
   - 不能是关键字。
   - 区分大小写。
2. 行业惯例:
   - 小驼峰命名法: 首字母小写，后续单词首字母大写。
     - 例: `userName`, `apiResponse`, `isLogin`.
   - 常量全大写: 仅用于那些写死在代码里、永远不变的配置项。
     - 例: `const MAX_TIMEOUT = 5000;`
   - 见名知意: 避免使用 `a`, `b`, `x`，使用 `userList`, `petId`。

### 变量提升

JS 引擎在执行代码前，会先扫描所有的变量声明，把它们“提升”到顶端。

- `var` 的提升：声明会被提升，赋值不会。所以你在声明前打印它，会得到`undefined`。
- `let/const` 的提升：也会被提升，但进入“暂时性死区”。在声明行之前访问它们，程序会直接报错。这是一种保护机制。

### 动态类型

JS 变量没有固定的类型，类型由值决定。

```js
let data = 100;     // 此时 data 是 Number
data = "Hello";     // 合法！此时 data 变成了 String
data = true;        // 合法！此时 data 变成了 Boolean
```

## 数据类型

JavaScript 的数据类型系统与 Java 有着本质的区别。Java 是强类型语言，变量在声明时必须指定类型；而 JavaScript 是弱类型/动态类型语言，变量的类型由当前存储的值决定，并且可以随时改变。

JavaScript 的数据类型主要分为两大类：基本数据类型和引用数据类型。

### 基本数据类型

这些类型的值直接存储在栈内存中，占据固定大小的空间。它们是不可变的。

目前 JavaScript 有 7 种基本数据类型：

1. Number (数值)
   - 特点： 不像 Java 区分 `int`, `long`, `double`，JS 只有一种 `Number` 类型，基于 IEEE 754 标准（双精度浮点数）。
   - 特殊值：
     - `NaN` : 计算错误的非数值结果（如 `"abc" / 2`）。注意：`NaN !== NaN`。
     - `Infinity` / `-Infinity`: 无穷大。
2. String (字符串)
   - 特点： 用单引号、双引号或反引号（模板字符串）包裹。
   - 区别： JS 中字符串是基本类型，不像 Java 中是引用对象。
3. Boolean (布尔)
   - 只有 `true` 和 `false`。
4. Undefined (未定义)
   - 特点： 只有一个值 `undefined`。
   - 出现场景： 变量声明了但未赋值；访问对象不存在的属性；函数没有返回值。
5. Null (空值)
   - 特点： 只有一个值 `null`。
   - 含义： 表示一个“意料之中”的空值，通常用来表示“这里应该有一个对象，但暂时没有”。
   - 坑： `typeof null` 会返回 `"object"`。
6. Symbol (符号 - ES6)
   - 特点： 表示独一无二的值。通常用于创建对象的唯一属性键，防止属性名冲突。
7. BigInt (大整数 - ES2020)
   - 特点： 用于表示超过 `Number` 安全范围（2^53 - 1）的超大整数。
   - 语法： 在数字后面加 `n`，如 `123n`。

### 引用数据类型

这些类型的值存储在堆内存中，而在栈内存中存储的是指向堆内存的地址指针。

1. Object (对象)
   - JS 中一切复杂结构的基础。如： `{ name: "Jack" }`。
2. Array (数组)
   - 一种特殊的对象，键是数字索引。
   - 区别： Java 数组定长，JS 数组不定长且可存储不同类型的数据。
3. Function (函数)
   - 在 JS 中，函数是“一等公民”，可以像变量一样被传递、赋值。

### 栈与堆内存

- 基本类型赋值： 是值复制。修改新变量不会影响旧变量。
- 引用类型赋值： 是地址复制。修改新变量的属性，会影响旧变量（它们指向同一个堆内存）。

```js
// --- 基本类型 ---
let a = 10;
let b = a;  // 复制值
b = 20;
console.log(a); // 输出 10 (a 不受影响)

// --- 引用类型 ---
const user1 = { name: "Jack" };
const user2 = user1; // 复制地址（引用）
user2.name = "Tom";
console.log(user1.name); //输出 "Tom" (user1 被修改了！)
```

### 判断数据类型

1. typeof 

```js
typeof "abc"   // "string"
typeof 123     // "number"
typeof null    // "object" 
typeof []      // "object" (无法区分数组和对象)
```

2. Array.isArray()

```js
Array.isArray([]) // true
```

## 常量

### 核心定义

`const` 用于声明一个只读的常量。一旦声明，其标识符（变量名）就不能再重新分配给其他值。

1. 必须立即初始化

```js
const PI = 3.14; // 正确
const TOKEN;     // 报错: Missing initializer in const declaration
```

2. 禁止重新赋值

```js
const MAX_COUNT = 10;
MAX_COUNT = 11; //报错: Assignment to constant variable
```

3. 块级作用域

- `const` 只在当前代码块 `{ ... }` 内有效，且不发生变量提升

### 核心难点

> `const` 保证的不是变量的值不得改动，而是变量指向的那个内存地址不得改动。

A. 对于基本数据类型

- 值就保存在栈内存的地址中。地址不能变，值自然也不能变。所以它们是真正的常量。


B. 对于引用数据类型

- 变量名在栈内存中存储的是一个指针。 const 锁死的是这个指针，不让你指向另一个对象。但是，对象内部的数据（属性）是可以修改的


```js
// 声明一个常量对象
const pet = {
    id: 101,
    name: "Kitty"
};

// 1. 修改属性：允许
// 指针没变，只是修改了房子里的家具
pet.name = "Mimi"; 
console.log(pet.name); //输出 "Mimi"

// 2. 增加属性：允许
pet.age = 2;

// 3. 重新赋值：禁止
// 这相当于要把 pet 指向另一座房子
pet = { id: 102, name: "Doggy" }; // 报错
```

### 命名规范

并不是所有 const 变量都要用全大写字母。

1. 全大写下划线

```js
const MAX_TIMEOUT = 5000;
const API_BASE_URL = "https://api.petstore.com";
```

2. 小驼峰

```js
// 这个 header 是运行时生成的，不是硬编码的，所以用小驼峰
const authHeader = `Bearer ${userToken}`; 

// 函数表达式
const calculateTax = function(price) { ... };

// 引入的模块
const fs = require('fs');
```

## 类型转换

### 显式转换

显式转换指开发者手动、明确地触发数据类型转换，可控性强，是开发中的首选方式。

1. 转为数值

通常用于处理从 HTML 表单 (`input`) 或 API 获取的字符串数据。

- **`Number()`**: 严格转换，含非法字符返回 `NaN`

```js
Number("123")   // 123
Number("123px") // NaN (注意这里)
Number(true)    // 1
Number(null)    // 0
```

- **`parseInt()` / `parseFloat()`**: 解析型转换，从左到右读取至非数字字符停止

```js
parseInt("123px")   // 123
parseFloat("3.14m") // 3.14
```

- `+` : 高频简写，效果等同于 `Number()`

```js
let id = "100";
console.log(+id); // 100 (变成了数字)
```

2. 转为字符串

- `String()`: 万能转换。

```js
String(123)  // "123"
String(null) // "null"
```

- `.toString()`: 方法调用。
  - 注意： null 和 undefined 没有这个方法，调用会报错。


3. 转为布尔值

- `Boolean()`: 标准方法。
- 双重取反 `!!`: 高频简写，效果等同于`Boolean()`

```js
!!123  // true
!!null // false
```

### 隐式转换

隐式转换是 JavaScript 引擎在执行代码时自动触发的类型转换，无需开发者干预，若不熟悉规则易产生预期外结果。

1. 字符串拼接

- 只要`+`号的一边是字符串，另一边就会自动变成字符串。

```js
// 数字相加
10 + 10 // 20

// 字符串拼接 (坑!)
10 + "10" // "1010"
```

2. 数学运算

除了`+`以外的运算符，都会把数据转为数字再计算。

```js
"10" - 2  // 8 (字符串 "10" 自动转成了数字 10)
"10" * 2  // 20
"10" / "2" // 5
```

3. 宽松相等vs 严格相等

宽松相等`==`: 先转换类型，再比较值。

```js
"100" == 100  // true (字符串转成了数字)
0 == false    // true
null == undefined // true
```

严格相等`===`: 不转换类型。类型不同直接返回 false。

```js
"100" === 100 // false (类型不同：String vs Number)
```

### 真值与假值

在 if 条件判断中，JS 会将任何值隐式转换为布尔值。

1. 假值

只有以下 6 种情况会被转为 false

- false

- 0 (包括 -0)

- "" (空字符串)

- null

- undefined

- NaN

2. 真值

除了上面 6 个，其他都是 true。

```js
let list = [];

// 注意：空数组 [] 在条件判断中为真值
// 通常应使用 list.length > 0 判断数组是否包含元素
if (list) {
    console.log("列表不为空"); // 执行！
}
```

## 运算符

### 概述

运算符是用于对一个或多个操作数进行计算或处理的符号。JavaScript 中的运算符主要分为一元、二元和三元运算符。

### 算术运算符

用于执行数学计算。除了标准的数学运算外，需特别注意 JavaScript 中的类型转换机制。

1. 基础运算

| 运算符 |    描述     |  示例  | 结果 |
| :----: | :---------: | :----: | :--: |
|   +    |    加法     | 2 + 2  |  4   |
|   -    |    减法     | 5 - 2  |  3   |
|   *    |    乘法     | 2 * 3  |  6   |
|   /    |    除法     | 10 / 2 |  5   |
|   %    | 取模 (余数) | 5 % 2  |  1   |
|   **   |   幂运算    | 2 ** 3 |  8   |

2. 自增与自减

用于对变量进行 +1 或 -1 操作。需严格区分前置与后置的区别。

- 前置：++i。先增加，后返回值。
- 后置：i++。先返回值，后增加。

```js
let a = 1;
let b = ++a; // a 变为 2, b 赋值为 2 (使用新值)

let c = 1;
let d = c++; // c 变为 2, d 赋值为 1 (使用旧值)
```

### 比较运算符

比较运算符返回布尔值 (true 或 false)。

1. 严格相等与抽象相等

这是 JavaScript 中最核心的逻辑陷阱，建议始终使用严格相等。

- `==` ：
  - 机制：比较前会进行类型转换

  - 示例：`"5" == 5` → true。

- `===`：
  - 机制：不进行类型转换。类型不同直接返回 false。

  - 示例：`"5" === 5` → false。

2. 其他比较

- `!=` (抽象不等) 与 `!==` (严格不等)。
- `>` (大于), `<` (小于), `>=` (大于等于), `<=` (小于等于)。

>字符串比较是基于字典序 (ASCII 码) 进行的。

### 逻辑运算符

现代 JavaScript 中，逻辑运算符不仅返回布尔值，还遵循短路求值原则，常用于控制流。

| 运算符 |  名称  |      逻辑描述      |             短路规则 (返回值)              |
| :----: | :----: | :----------------: | :----------------------------------------: |
|   &&   | 逻辑与 | 全真则真，一假即假 | 寻找第一个假值。若全为真，返回最后一个值。 |
|  \|\|  | 逻辑或 | 一真则真，全假即假 | 寻找第一个真值。若全为假，返回最后一个值。 |
|   !    | 逻辑非 |        取反        |        将操作数转化为布尔值并取反。        |

```js
// OR (||) 用于设置默认值
let user = null;
let name = user || "Anonymous"; // 结果："Anonymous"

// AND (&&) 用于前置检查
let isLogon = true;
isLogon && console.log("Welcome"); // 如果 isLogon 为真，才执行后面语句
```

### 赋值运算符

优先级极低，通常最后执行。

- 基础赋值：`x = y` (将 y 的值赋给 x)。
- 复合赋值：
  - `x += y` (等同于 `x = x + y`)
  - `x -= y`, `x *= y`, `x /= y` 等。

- 逻辑赋值

  - `||=` : `x ||= y` (仅当 x 为 Falsy 时赋值)

  - `&&=` : `x &&= y` (仅当 x 为 Truthy 时赋值)

  - `??=` : `x ??= y` (仅当 x 为 null/undefined 时赋值)

### 位运算符

JavaScript 中的数字默认是 64位双精度浮点数。 但是，当进行位运算时，JavaScript 引擎会在后台自动将数字转换为 32位有符号整数 (32-bit signed 

integer)，进行运算后再转回 64位浮点数。

- 操作对象：二进制位 (0 和 1)。

1. 逻辑位运算符

它们逐位比较两个数字的二进制形式。

- 按位与 (&) —— AND

1. 规则：只有两个数对应的位都为 1 时，结果才为 1。否则为 0。
2. 口诀：全是真才是真。

3. 用途：清零特定位，或检测某一位是否为 1（权限检测）。

```js
var a = 5;  // 二进制: 00000000 00000000 00000000 00000101
var b = 1;  // 二进制: 00000000 00000000 00000000 00000001

var res = a & b; 
// 运算:
//   ... 0101
// & ... 0001
// ----------
//   ... 0001  (十进制 1)

console.log(res); // 1
```

- 按位或 (|) —— OR

1. 规则：只要有一个位是 1，结果就是 1。
2. 口诀：有真就是真。

3. 用途：设置特定位为 1（添加权限），或取整。

```js
var a = 5;  // ... 0101
var b = 2;  // ... 0010

var res = a | b;
// 运算:
//   ... 0101
// | ... 0010
// ----------
//   ... 0111  (十进制 7)

console.log(res); // 7
```

- 按位异或 (^) —— XOR

1. 规则：两个位不同则为 1，相同则为 0。
2. 口诀：相异为真，相同为假。

3. 用途：切换状态（0变1，1变0），加密（两次异或还原）。

```js
var a = 5;  // ... 0101
var b = 1;  // ... 0001

var res = a ^ b;
// 运算:
//   ... 0101
// ^ ... 0001
// ----------
//   ... 0100  (十进制 4)

console.log(res); // 4
```

- 按位非 (~) —— NOT

1. 规则：将每一位取反（0 变 1，1 变 0）。包含符号位。
2. 数学公式：~N 等于 -(N + 1)。

3. 用途：曾经用于判断 indexOf 是否返回 -1（因为 ~-1 是 0，即 false）。

```js
var a = 5; 
console.log(~a); // -6
```

2. 移位运算符

移动二进制位的位置。

- 左移 (`<<`)

  - 规则：所有位向左移动指定次数，右边空出的位补 0。

  - 数学意义：$num \times 2^n$。

  - 图解：`0010 (2)` 左移一位 $\rightarrow$ `0100 (4)`。

```js
var a = 2;
console.log(a << 1); // 4  (2 * 2^1)
console.log(a << 2); // 8  (2 * 2^2)
```

- 有符号右移 (`>>`)
  - 规则：所有位向右移动，保留符号位（正数补0，负数补1）。
  - 数学意义：$num / 2^n$ (向下取整)。

```js
var a = 8;
console.log(a >> 1); // 4
```

- 无符号右移 (`>>>`)

  - 规则：所有位向右移动，左边空位一律补 0。

  - 区别：对于正数，>> 和 >>> 结果一样。对于负数，>>> 会使其变成一个巨大的正数（因为符号位的 1 被移走了，补进来了 0）。

### 特殊与现代运算符

1. 三元运算符

唯一需要三个操作数的运算符，常用于简化 if-else。

语法：

```js
条件 ? 表达式1 (真) : 表达式2 (假)
```

示例：

```js
let age = 18;
let status = (age >= 18) ? "Adult" : "Minor";
```

2. 空值合并运算符 `？？`

- 定义：当左侧操作数为 `null` 或 `undefined` 时，返回右侧操作数；否则返回左侧。

- 与 `||` 的区别：`||` 无法区分 `0`、`""` (空字符串) 和 `false`，因为它们都是假值。`??` 仅针对空值。

```js
let score = 0;
console.log(score || 10); // 输出 10 (错误逻辑，0 被视为假)
console.log(score ?? 10); // 输出 0 (正确逻辑，0 不是 null/undefined)
```

3. 可选链运算符

用于安全地访问深层嵌套的对象属性，防止报错。

- 语法：`obj?.prop`
- 机制：如果 `obj` 不存在 (null/undefined)，直接返回 `undefined` 而不是抛出 Error。

### 运算符优先级

优先级决定了表达式的计算顺序。以下从高到低排列：

1. 分组：`()` 
2. 成员访问/调用：`.`, `?.`, `[]`, `()`
3. 一元运算：`!`, `++`, `--`, `typeof`, `delete`
4. 算术/幂：`**`, `*`, `/`, `%`, `+`, `-`
5. 比较：`>`, `<`, `>=`
6. 相等：`===`, `!==`
7. 逻辑：`&&`, `||`, `??`
8. 赋值：`=`, `+=`, `-=` 等

## 条件判断

条件语句用于基于不同的条件执行不同的代码块。JavaScript 的核心条件逻辑构建在布尔值和真假值机制之上。

### if 语句体系

1. 基础语法

- 单分支结构：仅当条件满足时执行。

```js
if (expression) {
    // 当 expression 为真值时执行此处代码
    var message = "Condition met";
}
```

- 双分支结构 (if...else) 提供“非此即彼”的选择。

```js
if (expression) {
    // 分支 A：条件满足
} else {
    // 分支 B：条件不满足
}
```

- 多分支结构 (else if) 用于处理互斥的多个条件。

```js
if (condition1) {
    // 代码块 1
} else if (condition2) {
    // 代码块 2 (仅当 condition1 为假 且 condition2 为真时执行)
} else {
    // 默认代码块 (仅当上述所有条件均为假时执行)
}
```

2. 核心机制

if (expression) 括号内的表达式可以是任何类型。JavaScript 引擎会自动调用 Boolean() 转换规则，将其强制转换为布尔值。

判定规则： 在判断中，只有以下 6种值会被转化为 false，其余所有值（包括空对象 {} 和空数组 []）均视为 true。

- false (布尔型假)

- 0 (数字零)

- "" (空字符串)

- null

- undefined

- NaN (Not a Number)

```js
var score = 0;

// 危险写法：
if (score) {
    // 这里的代码不会执行，因为 0 被转换为 false
    // 这可能导致逻辑错误（如果 0 代表有效分数）
}

// 严谨写法：
if (score !== null && score !== undefined) {
    // 明确判断非空
}
```

### switch 语句
switch 语句用于多重分支结构，主要用于针对同一个变量的不同取值进行匹配。

1. 基础语法

```js
switch (expression) {
    case value1:
        // 当 expression === value1 时执行
        statement1;
        break; // 必须显式中断
    case value2:
        statement2;
        break;
    default:
        // 当没有任何 case 匹配时执行
        statementDefault;
}
```

2. 关键特性

- 严格相等匹配 switch 在比较表达式和 case 的值时，使用的是 === 运算符，不进行类型转换。

  - 如果 expression 是数字 10，而 case 是字符串 "10"，则不会匹配。


- 穿透效应如果省略 break 关键字，程序会忽略后续的 comparison（比较），直接执行下一个 case 的代码块，直到遇到 break 或代码结束。

```js
var rank = "B";

switch (rank) {
    case "A":
    case "B":
    case "C":
        // A, B, C 等级都会执行此处
        console.log("Pass");
        break;
    case "D":
        console.log("Fail");
        break;
}
```

### 三元运算符

这是 JavaScript 中唯一的三元运算符，通常用作 if...else 的简写形式。

1. 语法

```js
condition ? expressionIfTrue : expressionIfFalse
```

2. 特点与限制

- 作为表达式：三元运算会返回一个值，因此可以直接用于变量赋值。

- 不建议嵌套：虽然支持嵌套（多个 ? 连用），但极度降低代码可读性，在工业级代码规范中通常被禁止。

```js
// if-else 写法 (语句 Statement)
var status;
if (age >= 18) {
    status = "Adult";
} else {
    status = "Minor";
}

// 三元运算写法 (表达式 Expression)
var status = (age >= 18) ? "Adult" : "Minor";
```

## 循环控制

### 概述

循环是编程中用于重复执行某段代码的控制结构。其核心目的是减少重复代码并自动化处理批量数据。

三种主要的循环形式：

- for 循环：最常用的循环，适用于已知循环次数的场景。

- while 循环：适用于循环次数未知，但终止条件明确的场景。

- do...while 循环：while 的变体，保证循环体至少执行一次。

### for 循环

这是使用频率最高的循环结构，通常用于遍历数组或执行指定次数的操作。

1. 语法结构

```js
for (初始化表达式; 条件表达式; 更新表达式) {
    // 循环体 (Statement)
}
```

- 初始化表达式：在循环开始前执行一次。通常用于声明计数器变量（如 var i = 0）。

- 条件表达式：在每次循环迭代之前求值。如果为 true，执行循环体；如果为 false，终止循环。

- 更新表达式：在每次循环体执行之后执行。通常用于更新计数器（如 i++）。

2. 执行流程详解

- 执行初始化 (var i = 0)。
- 判断条件 (i < 10)。

  - 若假，退出循环。

  - 若真，进入步骤 3。

- 执行循环体代码。

- 执行更新表达式 (i++)。

- 回到步骤 2 重复。

```js
// 正序打印 0 到 4
for (var i = 0; i < 5; i++) {
    console.log(i);
}

// 倒序打印 10 到 1
for (var j = 10; j > 0; j--) {
    console.log(j);
}
```

### while 循环

while 循环是一种前测试循环，即先检查条件，再执行代码。

1. 语法结构

```js
while (condition) {
    // 只要 condition 为 true，这里就会一直执行
    // 注意：必须在内部包含改变 condition 的代码，否则会导致死循环
}
```

2. 适用场景

当不知道具体的循环次数，只知道循环结束的逻辑条件时使用。

```js
var n = 0;
var x = 0;
// 当 x 小于 100 时持续运行
while (x < 100) {
    n++;
    x += n;
}
```

### do...while 循环

do...while 循环是一种后测试循环

1. 语法结构

```js
do {
    // 循环体
} while (condition); // 注意：此处结尾需要分号
```

2. 核心区别

无论条件是否满足，do...while 的循环体至少会执行一次。

```js
var count = 10;

// while 循环：条件不满足，一次都不打印
while (count < 5) {
    console.log("Inside while");
}

// do...while 循环：先执行一次，再判断，打印一次
do {
    console.log("Inside do-while");
} while (count < 5);
```

### 循环控制语句

为了更精确地控制循环流程，JavaScript 提供了两个关键语句。

1. break (中断)

立即终止整个循环，跳出循环体，程序继续执行循环后面的代码。

```js
for (var i = 0; i < 10; i++) {
    if (i === 5) {
        break; // 当 i 等于 5 时，循环完全停止
    }
    console.log(i); // 只输出 0, 1, 2, 3, 4
}
```

2. continue (跳过)

立即停止当前迭代，跳过循环体中剩余的代码，直接进入下一次迭代（对于 for 循环，会直接跳转到“更新表达式”环节）。

```js
for (var i = 0; i < 5; i++) {
    if (i === 2) {
        continue; // 跳过 2，不打印
    }
    console.log(i); // 输出 0, 1, 3, 4
}
```

### for...in 循环

for...in 语句用于遍历对象的可枚举属性。

1. 语法

```js
for (var variable in object) {
    // variable 会被赋值为属性名（Key）
}
```

2. 关键行为

- 用途：主要用于调试或遍历普通对象（Object）。

- 禁忌：不推荐用于遍历数组（Array）。

  - 原因 1：for...in 无法保证遍历顺序。

  - 原因 2：它会遍历原型链上的属性，可能导致意外错误。

```js
var user = {
    name: "John",
    age: 30,
    isAdmin: true
};

for (var key in user) {
    // key 依次为 "name", "age", "isAdmin"
    // user[key] 用于获取对应的值
    console.log(key + ": " + user[key]);
}
```

## 函数

### 函数定义

在 ES5 中，定义函数主要有两种方式。

1. 函数声明

这是最标准的定义方式，使用 function 关键字开头，后跟函数名。

- 语法：

```js
function functionName(param1, param2) {
    // 函数体
    return result;
}
```

- 特点：函数提升

JavaScript 引擎在执行代码前，会先读取函数声明。这意味着你可以在定义函数之前调用它。

```js
sayHello(); //正常运行，输出 "Hello"

function sayHello() {
    console.log("Hello");
}
```

2. 函数表达式

将一个匿名函数赋值给一个变量。

- 语法：

```js
var functionName = function(param1, param2) {
    // 函数体
}; // 注意：这里通常需要分号，因为它是一个赋值语句
```

- 特点：不提升

在赋值语句执行之前，变量 functionName 的值为 undefined。如果在赋值前调用，会报错。

```js
sayHi(); //报错: TypeError: sayHi is not a function

var sayHi = function() {
    console.log("Hi");
};
```

### 调用与返回值

1. 函数调用

定义一个函数并不会自动执行它。定义只是创建了一个代码蓝图。只有通过调用，代码才会真正运行。

A. 调用运算符 `()`

在 JavaScript 中，圆括号 () 被称为调用运算符。

- 函数名：只是一个指向函数对象的引用（变量）。

- 函数名 `+ ()`：指令 JavaScript 引擎执行该函数体内的代码。

```js
function sayHello() {
    console.log("Hello World");
}

// 1. 仅引用函数
var funcRef = sayHello;
console.log(funcRef); 
// 输出: [Function: sayHello]
// 解释: 并没有执行函数，只是查看了变量 sayHello 里的内容。

// 2. 执行函数
sayHello(); 
// 输出: "Hello World"
// 解释: 加上 () 后，函数体被执行。
```

B. 调用的四种模式

在 ES5 标准中，根据调用方式的不同，函数内部的 this 指向也会不同。这里仅列出语法形式：

- 函数调用模式：直接调用孤立的函数。

```js
myFunction();
```

- 方法调用模式：作为对象的属性调用。

```js
object.myMethod();
```

- 构造器调用模式：使用 new 关键字。

```js
new Person();
```

- 间接调用模式：使用 call 或 apply。

```js
myFunction.call(thisContext);
```

2. 返回值机制

函数不仅仅是执行动作，通常还需要产生结果。return 语句是函数向调用者传递数据的唯一通道。

A. return 的双重作用

`return` 关键字在执行时具有两个同步发生的行为：

- 停止执行：立即终止当前函数的执行，后续代码将被忽略。
- 返回数据：将 `return` 关键字右侧表达式的值，作为整个函数调用的结果返回给调用者。

B. 接收返回值
调用者通常需要使用变量来存储这个返回结果。

```js
function square(x) {
    return x * x;
}

// 调用函数，并将结果赋值给变量 result
var result = square(5); 

console.log(result); // 25
console.log(square(4)); // 16 (也可以直接打印函数调用的结果)
```

C. 默认返回值

如果函数体内：

- 没有写 `return` 语句。
- 写了 `return` 但后面没有跟任何值（例如 `return;`）。

那么该函数的返回结果永远是 `undefined`。

```js
function noReturn() {
    var a = 1 + 1;
    // 没有 return
}

var test = noReturn();
console.log(test); // undefined
```

### 参数机制

1. 形参与实参

首先明确两个术语的区别，这在阅读技术文档时非常重要。

- 形参：
  - 定义：在函数声明时，括号内列出的变量名。
  - 本质：它们是函数内部的局部变量。
- 实参：
  - 定义：在函数调用时，括号内实际传入的具体值。
  - 本质：数据源。

```js
// a, b 是形参 (占位符)
function add(a, b) {
    return a + b;
}

// 10, 20 是实参 (实际值)
add(10, 20);
```

2. JavaScript 的“三不”原则

与其他强类型语言不同，JavaScript 在参数处理上遵循“三不”原则：

- 不检查类型：你可以给定义的数字参数传字符串，JS 不会报错（可能导致运行逻辑错误，但语法通过）。

- 不检查数量：定义的形参个数和实际传入的实参个数可以不一致。

- 不强制赋值：没有默认强制要求必须传参。

3. 参数数量不匹配的处理策略

A. 实参少于形参

当调用函数时，如果提供的实参个数少于定义的形参：

- 结果：未被赋值的形参会自动被赋值为 undefined。

- ES5 默认值模式：由于 ES5 没有默认参数语法（即不支持 func(a=1)），我们需要在函数体内手动处理。

```js
function greet(name, message) {
    // 惯用手法：短路求值设置默认值
    // 如果 message 是 undefined (假值)，则取 "Hello"
    message = message || "Hello";

    console.log(message + ", " + name);
}

greet("Alice"); // 输出: "Hello, Alice" (message 自动降级为默认值)
```

B. 实参多于形参

当调用函数时，如果提供的实参个数多于定义的形参：

- 结果：多余的实参会被赋值给 arguments 对象，但在命名参数中无法直接访问。

- 不会报错：JavaScript 引擎会静默忽略多余的参数（在命名变量层面）。

4. arguments 对象

arguments 是函数内部自动创建的一个隐式对象，它包含了函数调用时传入的所有实参。

A. 核心特征

- 它拥有 length 属性。

- 可以通过索引访问元素（arguments[0], arguments[1]）。

- 关键区别：它不是数组。它没有 push, pop, forEach 等数组方法。

B. 可变参数函数

在 ES5 中，如果想实现一个可以接收任意数量参数的函数，必须依赖 arguments。

```js
function sum() {
    var total = 0;
    // 遍历 arguments 对象
    for (var i = 0; i < arguments.length; i++) {
        total += arguments[i];
    }
    return total;
}

console.log(sum(1, 2));       // 3
console.log(sum(1, 2, 3, 4)); // 10
```

### 作用域

作用域是指程序中定义变量的区域。它决定了当前执行代码对变量的可见性和生命周期

在 ES5 标准中，JavaScript 采用的是词法作用域，也称为静态作用域。这意味着变量的作用域在代码写好时就已经确定了，而不是在代码运行时确定的。

ES5 只有两个主要的层级作用域：

- 全局作用域

- 函数作用域 


> 注：ES5 没有块级作用域（如 if 或 for 代码块内部）。

1. 全局作用域

最外层的作用域。任何不在函数内部声明的变量，都属于全局作用域。

- 访问权限：全局变量在代码的任何地方都可以被访问和修改。

- 生命周期：伴随页面的生命周期。只要网页不关闭，全局变量就一直占用内存。

- 宿主对象：在浏览器环境中，全局作用域即 window 对象。声明一个全局变量 var a = 1 等同于 window.a = 1。

2. 函数作用域

在函数内部声明的变量，属于局部作用域。

- 访问权限：只能在函数体内部访问。函数外部无法“看见”或操作函数内部的变量。

- 生命周期：通常情况下，函数执行完毕后，内部变量会被销毁（除非产生闭包）。

```js
var globalVar = "I am Global"; // 全局

function scopeTest() {
    var localVar = "I am Local"; // 局部
    console.log(globalVar); //可访问全局
    console.log(localVar);  //可访问局部
}

scopeTest();
console.log(localVar); // ❌ 报错: ReferenceError (外部无法访问内部)
```

3. 作用域链

当代码在一个环境中执行时，会创建变量对象的一个作用域链。作用域链保证了对执行环境有权访问的所有变量和函数的有序访问。

A. 查找规则：向外攀升

当代码尝试访问一个变量时，JavaScript 引擎会遵循以下查找步骤：

- 当前作用域：首先在当前正在执行的函数内部查找是否存在该变量的声明。

  - 如果找到：使用该变量，停止查找。

- 父级作用域：如果当前作用域没找到，则向上一层（定义该函数的外部环境）查找。

  - 全局作用域：如果一直向上查找直到全局作用域依然没找到。

  - 如果找到：使用全局变量。

  - 如果没找到：抛出 ReferenceError 异常。

B. 变量遮蔽

如果内部函数定义了与外部函数同名的变量，内部变量会遮蔽外部变量。在内部作用域中，外部的同名变量暂时失效。

```js
var value = "Global";

function outer() {
    var value = "Outer"; // 遮蔽了全局的 value
    
    function inner() {
        var value = "Inner"; // 遮蔽了 outer 的 value
        console.log(value); // 输出: "Inner"
    }
    
    inner();
    console.log(value); // 输出: "Outer"
}

outer();
console.log(value); // 输出: "Global"
```

4. 词法作用域

“函数的作用域取决于函数定义的地方，而不是调用的地方。”

这是初学者最容易混淆的难点。无论函数在哪里被调用，它的作用域链永远指向它最初被定义时的环境。

```js
var name = "Global Name";

function foo() {
    console.log(name);
}

function bar() {
    var name = "Bar Name";
    foo(); // 在这里调用 foo
}

bar();
```

5. 变量提升

在函数作用域内部，JavaScript 引擎有一个“预编译”阶段。在代码执行前，所有的变量声明（var）和函数声明都会被提升到当前作用域的顶部。

- 声明提升，赋值不提升

```js
function test() {
    console.log(a); // 输出: undefined (不会报错，但也不是 10)
    var a = 10;
    console.log(a); // 输出: 10
}
```

- 引擎的实际执行顺序：

```js
function test() {
    var a;          // 1. 变量声明被提升到顶部
    console.log(a); // 2. 此时 a 已存在，但未赋值，故为 undefined
    a = 10;         // 3. 执行赋值操作
    console.log(a); // 4. 输出 10
}
```

6. 无块级作用域

在 ES5 中，只有函数能创建新作用域。像 if、for、switch 这样的代码块不会创建作用域。这会导致变量意外泄漏到外部。

- if 块的泄漏

```js
if (true) {
    var color = "Blue";
}
console.log(color); //输出 "Blue"
// 变量 color 并没有被限制在 if 块中，它泄漏到了全局或包含它的函数中。
```

- for 循环的变量污染

这是最常见的错误源。循环变量 i 在循环结束后依然存在。

```js
for (var i = 0; i < 5; i++) {
    // 循环逻辑
}
console.log(i); //输出 5
// i 并没有被销毁，它污染了当前作用域。
```

### 立即执行函数表达式

1. 核心定义

IIFE 指的是一个被定义后立即被调用的函数表达式。它不需要被命名，也不需要被赋值给变量（除非你需要它的返回值）。

- 标准语法结构

```js
(function() {
    // 这里是私有作用域
    // 代码会立即执行
})();
```

- 语法拆解

IIFE 由两部分核心语法组成：

1. 第一对圆括号 `(...)`：将函数声明转换为函数表达式。这是欺骗 JS 解析器的关键步骤。
2. 第二对圆括号 `()`：调用运算符。它立即执行刚才定义的那个函数表达式。

2. 原理

在 JavaScript 语法解析规则中：

1. 如果一行代码以 `function` 关键字开头，引擎会将其解析为函数声明。
2. 函数声明必须有名字，且不能直接在后面跟 `()` 进行调用。

- 错误示范：

```js
function() { // 语法错误：缺少函数名
    console.log("Error");
}();

function foo() { 
    console.log("Error");
}(); //语法错误：虽然有名字，但声明语句不能直接被调用
```

- 正确示范：

通过用圆括号包裹，我们将 function 关键字从行首移开，引擎就会将其解析为表达式。表达式是可以被调用的。

```js
// 写法 1 (推荐/常见)：调用括号在包裹括号外
(function() {
    console.log("Run!");
})(); 

// 写法 2 (Douglas Crockford 风格)：调用括号在包裹括号内
(function() {
    console.log("Run too!");
}()); 
```

3. 核心作用：创建私有作用域

在 ES5 中，由于缺乏块级作用域，全局命名空间极易被污染。IIFE 的出现就是为了解决这个问题。

- 隔离变量

IIFE 内部定义的变量对外不可见，执行完毕后通常会被销毁（除非形成闭包）。

```js
// 全局环境
var a = 10;

(function() {
    // IIFE 内部环境
    var a = 20; // 这是一个全新的局部变量，与外面的 a 无关
    console.log("Inside IIFE: " + a); // 20
})();

console.log("Global: " + a); // 10
// 结论：IIFE 保护了全局变量不被意外修改
```

- 避免命名冲突

在多人协作或引入第三方库（如 jQuery 插件开发）时，为了防止变量名重复，通常将整个库的代码包裹在一个 IIFE 中。

4. 参数传递与返回值

IIFE 虽然是匿名的，但它依然是个函数，因此可以接收参数并返回值。

- 传递参数

通过传参，我们可以将全局对象注入到 IIFE 内部。这样做有两个好处：

1. 性能优化：在函数内部查找局部变量比查找全局变量快（减少作用域链查找）。

2. 代码压缩友好：压缩工具可以将形参（如 window）重命名为短字符（如 w）。

```js
(function(w, d, $) {
    // 在这里，w 代表 window，d 代表 document， $ 代表 jQuery
    // 即使外部没有定义 $，这里也可以安全使用形参名
    
    var title = d.title; // 访问 document.title
    console.log("Title: " + title);

})(window, document, jQuery); // 实参在最后传入
```

- 接收返回值

IIFE 可以返回一个对象，该对象包含我们希望公开的方法，而隐藏具体的实现细节。这就是著名的模块模式。

```js
var CounterModule = (function() {
    // 私有变量 (外部无法直接访问)
    var count = 0;

    // 返回一个公有对象
    return {
        increment: function() {
            count++;
        },
        getCount: function() {
            return count;
        },
        reset: function() {
            count = 0;
        }
    };
})();

CounterModule.increment();
console.log(CounterModule.getCount()); // 1
console.log(CounterModule.count);      // undefined (无法直接访问私有变量)
```

### 函数作为一等公民

1. 概念定义

在编程语言理论中，如果一个实体支持所有通常对其他实体（如数字、字符串、对象）可用的操作，那么它就被称为“一等公民”。

在 JavaScript 中，函数就是对象。这意味着函数不仅仅是可执行的代码块，它本质上是一种值。

“一等公民”的四大特权：

- 可以被赋值给变量。

- 可以作为参数传递给其他函数。

- 可以作为其他函数的返回值。

- 可以拥有属性和方法。

2. 特权详解

A. 特权一：赋值给变量

函数可以像数字 1 或字符串 "text" 一样，被存储在变量、数组或对象中。

- 变量赋值（即函数表达式）：

```js
// 将匿名函数赋值给变量 sayHello
var sayHello = function() {
    console.log("Hello!");
};

sayHello(); // 通过变量调用函数
```

- 存储在数组中：

```js
var actions = [
    function() { console.log("Action 1"); },
    function() { console.log("Action 2"); }
];

actions[0](); // 执行数组中的第一个函数
```

B. 特权二：作为参数传递

既然函数是值，它就可以作为参数传递给另一个函数。这种被传递的函数称为回调函数。这是 JavaScript 异步编程的核心。

```js
// 1. 定义一个通用的处理函数 (高阶函数)
function processUserInput(name, callback) {
    var greeting = "Hello, " + name;
    // 调用传入的函数
    callback(greeting);
}

// 2. 定义具体的行为函数
function printToConsole(text) {
    console.log("Console: " + text);
}

function alertUser(text) {
    alert("Alert: " + text);
}

// 3. 将函数作为参数传入
processUserInput("Alice", printToConsole); // 输出: Console: Hello, Alice
processUserInput("Bob", alertUser);        // 弹出: Alert: Hello, Bob
```

C. 特权三：作为返回值

函数可以作为另一个函数的执行结果被返回。这是闭包和柯里化的基础。

```js
// 工厂模式：创建一个能生成特定加法器的函数
function createAdder(x) {
    // 返回一个新的函数
    return function(y) {
        return x + y;
    };
}

var add5 = createAdder(5);  // add5 现在是一个函数，它“记住”了 x 是 5
var add10 = createAdder(10); // add10 现在是一个函数，它“记住”了 x 是 10

console.log(add5(2));  // 7  (5 + 2)
console.log(add10(2)); // 12 (10 + 2)
```

D. 特权四：拥有属性和方法
由于函数本质上是特殊的对象，它们可以拥有自己的属性和方法。

- 标准属性：

  - name: 函数的名字。

  - length: 函数定义时期望接收的参数个数（形参个数）。

- 自定义属性： 我们可以像给普通对象添加属性一样，给函数添加属性（例如用于缓存计算结果）。

```js
function speak(message) {
    console.log(message);
}

// 添加自定义属性
speak.description = "This is a speaking function";

console.log(speak.name);        // "speak"
console.log(speak.length);      // 1
console.log(speak.description); // "This is a speaking function"
```

3. 高阶函数

基于“一等公民”的特性，引出了一个重要概念：高阶函数。

定义：满足以下任一条件的函数，即为高阶函数：

- 接收一个或多个函数作为参数。

- 返回一个函数作为结果。


ES5 中的常见高阶函数（数组方法）： 虽然我们之前没有详细讲数组方法，但它们是高阶函数的典型应用。

```js
var numbers = [1, 2, 3];

// map 是一个高阶函数，它接收一个函数作为参数
var doubled = numbers.map(function(num) {
    return num * 2;
});

console.log(doubled); // [2, 4, 6]
```

### 闭包

1. 定义与本质

- 根据 MDN 的定义：闭包是指一个函数以及其捆绑的周边环境状态（词法环境）的引用的组合。
- 换句话说，闭包让开发者可以从内部函数访问外部函数的作用域。在 JavaScript 中，当一个函数从其定义的作用域之外被调用时，闭包就产生了。

$$闭包 = 函数 + 该函数定义时的词法作用域$$

2. 闭包的形成机制

通常情况下，函数执行完毕后，其内部变量（局部变量）会被垃圾回收机制销毁，内存被释放。

但是，如果一个外部函数返回了一个内部函数，并且这个内部函数引用了外部函数的变量：

- 外部函数执行完毕。

- 但内部函数依然持有对外部作用域的引用。

- 因此，外部函数的变量不会被销毁，而是保存在内存中，供内部函数随时调用。

3. 标准代码模型

以下代码展示了闭包最典型的形态：函数返回函数。

```js
function createCounter() {
    var count = 0; // 【私有变量】外部无法直接访问

    // 定义内部函数
    function increment() {
        count++; // 内部函数引用了外部变量 count
        console.log(count);
    }

    // 将内部函数作为返回值抛出
    return increment; 
}

// 1. 调用外部函数
// counter1 接收到了 increment 函数，同时也接收了 createCounter 的作用域环境
var counter1 = createCounter(); 

// 2. 执行
counter1(); // 输出: 1
counter1(); // 输出: 2
counter1(); // 输出: 3

// 3. 关键验证：count 变量依然活着，且被累加了
```

4. 闭包的实际应用

在 ES5 时代，闭包主要有两大用途：数据封装和状态保持

- 模拟私有变量

JavaScript (ES5) 没有 Java 中的 private 关键字。闭包是实现私有属性的唯一方式。

```js
function Person(name) {
    // _age 是私有变量，外部无法通过 person._age 访问
    var _age = 18;

    return {
        getName: function() {
            return name;
        },
        getAge: function() {
            return _age;
        },
        growOlder: function() {
            _age++;
        }
    };
}

var alice = Person("Alice");
console.log(alice.getAge()); // 18
alice.growOlder();
console.log(alice.getAge()); // 19

console.log(alice._age);     // undefined (实现了彻底的封装)
```

- 函数工厂

利用闭包生成配置不同的函数

```js
function makeAdder(x) {
    return function(y) {
        return x + y;
    };
}

var add5 = makeAdder(5);  // 创建一个“加5”的函数环境
var add10 = makeAdder(10); // 创建一个“加10”的函数环境

console.log(add5(2));  // 7
console.log(add10(2)); // 12
```

5. 内存泄漏

由于闭包会阻止垃圾回收器回收特定的变量，这些变量会一直占用内存。

- 现象

如果闭包使用不当（例如在庞大的循环中创建大量闭包，或者闭包持有了不再需要的 DOM 元素引用），会导致网页内存占用持续升高，最终导致页面卡顿甚至崩溃。

- 解决方案

当不再需要使用闭包时，应手动解除引用，以便垃圾回收器回收内存。

```js
var counter = createCounter();
counter(); // 使用中...

// 不再需要了，断开引用
counter = null; 
// 此时，之前那个闭包环境中的 count 变量失去了唯一的引用，将被垃圾回收。
```

### this 指向

1. 核心定义

this 是 JavaScript 语言中的一个关键字，它是函数在运行时自动生成的一个内部对象。

- 不要将 this 理解为函数自身。

- 不要将 this 理解为函数的作用域。

- 核心原则：this 的绑定完全取决于函数的调用位置，而不是声明位置。


> 谁调用了函数，this 就指向谁。

2. 四大绑定规则

在 ES5 中，判断 this 指向只需遵循以下四条规则。优先级从低到高排列。

- 默认绑定

这是最常见也是最基础的规则。当函数独立调用（即没有前缀对象，也没有 new）时，适用此规则。

1. 指向：全局对象 (window 在浏览器中)。

2. 严格模式 ("use strict")：this 会指向 undefined（防止污染全局）。

```js
function sayName() {
    console.log(this.name);
}

var name = "Global User";

// 独立调用
sayName(); 
// 非严格模式输出: "Global User" (this 指向 window)
// 严格模式输出: TypeError (Cannot read property 'name' of undefined)
```

- 隐式绑定

当函数作为对象的方法被调用时，this 会隐式绑定到那个上下文对象。

- 识别标志：函数调用时有点符号 (`.`)。

- 指向：点符号左侧的对象。

```js
function foo() {
    console.log(this.a);
}

var obj = {
    a: 2,
    foo: foo // 引用外部函数
};

// 隐式绑定：obj 调用了 foo
obj.foo(); // 输出: 2 (this 指向 obj)
```

> 隐式丢失这是初学者最容易踩的坑。如果将对象的方法赋值给一个变量，或者作为回调函数传递，隐式绑定会丢失，退化为默认绑定。

```js
var obj = {
    a: 2,
    foo: function() { console.log(this.a); }
};

var bar = obj.foo; // 只是函数引用，没有执行
var a = "Global";

bar(); // 输出: "Global"
// 原因：bar() 是独立调用，不再与 obj 有关。
```

- 显式绑定

通过 call、apply 或 bind 方法，我们可以强制指定函数执行时的 this 指向。

- `call(context, arg1, arg2...)`：立即执行函数，参数逐个传递。
- `apply(context, [argsArray])`：立即执行函数，参数以数组形式传递。
- `bind(context)`：不执行函数，而是返回一个永久绑定了指定 this 的新函数。

```js
function foo() {
    console.log(this.a);
}

var obj1 = { a: 2 };
var obj2 = { a: 3 };

foo.call(obj1); // 输出: 2 (强制指向 obj1)
foo.call(obj2); // 输出: 3 (强制指向 obj2)
```

- 硬绑定

```js
var bar = foo.bind(obj1); // 创建新函数 bar，其 this 锁死在 obj1 上
bar.call(obj2); // 输出: 2 
// 即使再次 call 也没用，bind 的优先级更高。
```

- `new` 绑定

这是优先级最高的绑定方式。当使用 new 关键字调用函数（构造函数）时，会发生以下步骤：

1. 创建一个全新的空对象。

2. 将这个新对象连接到原型链。

3. 将函数调用中的 this 绑定到这个新对象。

4. 如果函数没有返回其他对象，则自动返回这个新对象。

```js
function User(name) {
    // 此时 this 指向那个正在被创建的新对象
    this.name = name;
}

var u = new User("Alice");
console.log(u.name); // "Alice"
```

3. 优先级判定流程

当多种规则同时存在时，按照以下顺序判定：

- new 绑定：函数是否在 new 中调用？如果是，this 是新创建的对象。

- 显式绑定：函数是否通过 call, apply, bind 调用？如果是，this 是指定的对象。

- 隐式绑定：函数是否在某个上下文对象中调用 (obj.func())？如果是，this 是那个上下文对象。

- 默认绑定：如果以上都不是，this 是全局对象（严格模式下是 undefined）。

### 函数的内置属性与方法

1. 概述

在 JavaScript 中，所有的函数实际上都是全局构造函数 Function 的实例。因此，每个函数都继承了 Function.prototype 上的属性和方法。

2. 内置属性

这些属性提供了关于函数自身的元数据。

- length 属性
  - length 属性表示函数希望接收的命名参数（形参）的个数。术语称为函数的“元数” 。
  - 特性：只读。

  - 用途：常用于检查函数是否被正确调用，或在柯里化 (Currying) 算法中判断参数是否收集完毕。

  - 对比：

    - function.length: 定义时的形参个数。

    - arguments.length: 调用时的实参个数。

```js
function check(a, b, c) {}
function loose(a) {}

console.log(check.length); // 3
console.log(loose.length); // 1

// 典型场景：判断实参是否少于形参
function validation(a, b) {
    if (arguments.length < validation.length) {
        console.warn("参数缺失！");
    }
}
```

- name 属性

返回函数声明时的名称。

1. 用途：主要用于调试（报错堆栈中显示函数名）和递归调用。

2. 匿名函数：在早期的 ES5 浏览器实现中，匿名函数的 name 可能是空字符串。

```js
function foo() {}
console.log(foo.name); // "foo"

var bar = function() {};
console.log(bar.name); // "bar" (现代环境推断) 或 "" (旧环境)
```

- prototype 属性

这是函数最特殊的属性，仅函数拥有（普通对象没有）。

- 定义：当函数被用作构造函数（配合 new）时，该属性指向的对象将成为新创建实例的原型。

- 默认值：一个包含 constructor 属性（指向函数自身）的空对象。

- 用途：实现面向对象编程中的继承和共享方法。

3. 内置方法

函数原型 (Function.prototype) 提供了三个核心方法，用于手动控制函数的执行上下文 (this)。

- call() 方法

立即调用函数，并显式指定 this 的指向。

语法：

```js
func.call(thisArg, arg1, arg2, ...)
```

参数：

1. `thisArg`：在 func 运行时的 this 指向。
2. `arg1, arg2...`：传递给函数的参数列表，逐个列出。

```js
var person1 = {
    name: "Alice",
    greet: function(skill) {
        console.log("I am " + this.name + ", I can " + skill);
    }
};

var person2 = { name: "Bob" };

// person2 借用了 person1 的 greet 方法
// this 指向被强行改为了 person2，参数 "code" 被传入
person1.greet.call(person2, "code"); 
// 输出: "I am Bob, I can code"
```

- apply() 方法

与 call() 作用完全相同，唯一的区别在于参数的传递方式。

语法：

```js
func.apply(thisArg, [argsArray])
```

参数：

1. `thisArg`：this 指向。
2. `[argsArray]`：一个数组（或类数组对象），包含所有参数。

>Apply 接收 Array (数组)，Call 接收 Comma (逗号分隔)。

求数组最大值：Math.max 不接收数组，利用 apply 展开数组。

```js
var numbers = [5, 6, 2, 3, 7];
// 等同于 Math.max(5, 6, 2, 3, 7)
var max = Math.max.apply(null, numbers); 
console.log(max); // 7
```

数组合并：

```js
var arr1 = [1, 2];
var arr2 = [3, 4];
Array.prototype.push.apply(arr1, arr2); // 将 arr2 推入 arr1
console.log(arr1); // [1, 2, 3, 4]
```

- bind() 方法

bind 不会立即执行函数，而是创建一个新函数。

语法：

```js
var newFunc = func.bind(thisArg, arg1, ...)
```

1. 机制：返回一个新函数，该函数的 this 被永久锁定 (Hard Binding) 为 thisArg。

2. 柯里化预设参数：除了绑定 this，还可以预设部分参数。

```js
var obj = { x: 42 };

function getX() {
    console.log(this.x);
}

var boundGetX = getX.bind(obj);
boundGetX(); // 42

// 即使把 boundGetX 赋值给别人，this 也不会变了
var run = boundGetX;
run(); // 42
```

- toString() 方法

返回函数的源代码字符串。

用途：查看函数源码，或用于某些基于正则的源码分析库。

```js
function sum(a, b) { return a + b; }
console.log(sum.toString());
// 输出: "function sum(a, b) { return a + b; }"
```

4. 废弃与非标准属性

在阅读旧代码时可能会遇到以下属性，但在现代开发（特别是严格模式）中严禁使用。

- arguments.callee：

  - 在函数内部指向当前正在执行的函数自身。

  - 替代方案：使用命名函数表达式进行递归。

- Function.caller：

  - 指向调用当前函数的那个父函数。

  - 原因：破坏了编译器的优化，且存在安全隐患。

### 递归函数

1. 概念定义

递归是指一个函数在执行过程中调用自身的行为。

从数学角度看，递归是将一个复杂的大问题分解为若干个与原问题相似、但规模较小的问题来求解的方法。

公式化表达：

$$f(n) = \text{operation} + f(n-1)$$

2. 递归的核心二要素

编写递归函数时，必须严格遵守两个条件，否则会导致程序崩溃（死循环/栈溢出）。

- 基准情形

也称为“终止条件”。这是递归结束的出口。

1. 作用：防止无限递归。
2. 特征：当满足该条件时，函数直接返回一个具体的值，而不再调用自身。

- 递归步骤 (Recursive Step)

也称为“递推关系”。

1. 作用：将问题规模缩小。
2. 特征：函数调用自身，但传入的参数必须更接近基准情形。

斐波那契数列

```js
// 斐波那契数列: 1, 1, 2, 3, 5, 8...
function fibonacci(n) {
    // 基准情形：前两位都是 1
    if (n <= 2) return 1;
    // 递归步骤：前两项之和
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

## 对象

### 对象语法基础

1. 对象的结构

对象是由若干个属性组成的。每一个属性都是一个“键值对”。

键：也称为属性名。在 ES5 中，键始终被视为字符串。

值：也称为属性值。可以是 JavaScript 中的任意数据类型（数字、字符串、布尔值、数组、函数，甚至另一个对象）。

$$对象 = \{ 键_1: 值_1, 键_2: 值_2, \dots \}$$

2. 创建方式

在 JavaScript 中创建对象主要有两种方式。在实际开发中，方式一（字面量） 是绝对的主流，占据 99% 的使用场景。

A. 对象字面量

这是定义对象最简洁、最直观的方式。

- 语法：使用花括号 `{}` 包裹，内部属性用逗号`,`分隔。

- 格式：属性名: 属性值。

```js
var person = {
    name: "Alice",        // 字符串
    age: 25,              // 数字
    isAdmin: true,        // 布尔值
    hobbies: ["Reading", "Coding"], // 数组
    address: {            // 嵌套对象
        city: "New York",
        zip: 10001
    },
    sayHello: function() { // 函数（称为方法）
        console.log("Hi!");
    }
};
```

语法细节注意：

- 冒号 (`:`)：用于分隔“键”和“值”。

- 逗号 (`,`)：用于分隔不同的属性。

- 尾后逗号：最后一个属性后面可以加逗号，也可以不加。

2. 构造函数

这是使用 JavaScript 内置的 Object 构造函数来创建对象。这种方式较为繁琐，通常不推荐用于创建普通对象。

- 语法：使用 `new Object()` 创建空对象，然后逐个添加属性。

```js
var laptop = new Object(); // 创建一个空对象

// 逐个赋值
laptop.brand = "Apple";
laptop.model = "MacBook Pro";
laptop.year = 2026;
```

对比总结：

- 字面量：声明式，结构清晰，一次性定义所有属性，推荐使用。

- 构造函数：命令式，需要多行代码，通常仅在动态创建特定类型对象时提及。

3. 属性名的命名规则

虽然属性名本质上是字符串，但在字面量语法中，你可以省略引号，也可以加上引号。

A. 合法标识符

如果属性名符合 JavaScript 变量命名规则（由字母、下划线 `_`、`$` 开头，包含数字），则不需要加引号。

```js
var obj = {
    userName: "User1", // 合法，无引号
    _id: 101           // 合法，无引号
};
```

B. 特殊标识符

如果属性名包含空格、连字符 (`-`)，或者是数字开头，或者是保留字（如 `class`），则必须使用引号包裹。

```js
var data = {
    "first-name": "Alice", // 必须加引号，因为包含连字符 -
    "user age": 25,        // 必须加引号，因为包含空格
    "123code": true        // 必须加引号，因为以数字开头
};
```

4. 对象的嵌套

对象的值可以是另一个对象。这允许我们构建复杂的树形数据结构（如 JSON 数据）。

```js
var student = {
    id: 1001,
    info: {
        name: "Bob",
        contacts: {
            email: "bob@example.com",
            phone: "123-456-7890"
        }
    }
};

// 这种结构被称为“多维”对象或嵌套对象
```

5. 属性访问

A. 点符号

这是最常用、最简洁的访问方式，适用于已知的、合法的属性名。

- 语法结构

```js
object.property
```

- 核心机制

静态解析：点符号后面的 property 必须是一个有效的标识符。这意味着它不能包含空格、连字符，也不能以数字开头。

字面量匹配：JavaScript 引擎会将点号后面的字符直接视为属性名的字符串字面量。

```js
var book = {
    title: "JavaScript Guide",
    price: 59.9
};

console.log(book.title); // 输出: "JavaScript Guide"
console.log(book.price); // 输出: 59.9
```

- 局限性

无法访问命名不规范的属性。

```js
var data = {
    "user-id": 101 // 包含连字符，必须加引号才能定义
};

// console.log(data.user-id); //语法错误：引擎会解析为 "data.user" 减去 "id"
```

B. 方括号符号

这是更强大、更通用的访问方式，类似于访问数组元素（实际上，对象就是关联数组）。

- 语法结构

```js
object["property"]
```

> 方括号内部必须是一个计算结果为字符串的表达式。如果是直接访问，必须加上引号。

- 核心机制

1. 求值：JavaScript 引擎首先会对方括号内的表达式进行求值。

2. 转换：将求值结果强制转换为字符串。

3. 查找：使用该字符串作为键去查找属性。

场景 A：访问特殊字符属性：

```js
var data = {
    "user-id": 101,
    "first name": "Alice"
};

console.log(data["user-id"]);    //输出: 101
console.log(data["first name"]); //输出: "Alice"
```

场景 B：动态访问 (核心重点) 这是方括号最不可替代的功能——通过变量访问属性。

```js
var person = {
    name: "Bob",
    age: 30
};

var key = "age"; // 变量 key 存储了属性名字符串

console.log(person[key]); //输出: 30
// 解析过程：person[key] -> person["age"] -> 30
```

C. 访问不存在的属性

在 Java 或 C++ 中，访问不存在的字段通常会报错。但在 JavaScript 中，这被视为合法操作。

- 规则：如果访问一个对象中不存在的属性，返回 undefined。

- 不会报错：除非你尝试读取 undefined 的属性（例如 undefined.something）。

```js
var dog = { breed: "Husky" };

console.log(dog.age); // 输出: undefined (并没有报错)
```

D. 链式访问

对于嵌套对象，可以通过连续使用点符号或方括号来深入访问。

```js
var user = {
    id: 1,
    profile: {
        address: {
            city: "Beijing"
        }
    }
};

// 全点号
console.log(user.profile.address.city); // "Beijing"

// 混合使用
console.log(user["profile"].address["city"]); // "Beijing"
```

### 对象的基本操作

1. 添加与修改属性

在 JavaScript 中，赋值操作 (=) 兼具“添加”和“修改”的功能。

- 机制

添加：如果赋值时指定的属性名不存在，引擎会自动创建该属性并赋值。

修改：如果指定的属性名已存在，引擎会覆盖旧值。

```js
var car = {
    brand: "Toyota",
    color: "Red"
};

// 【修改】已存在的属性
car.color = "Blue";
console.log(car.color); // "Blue"

// 【添加】不存在的属性
car.model = "Camry";        // 点符号方式
car["year"] = 2026;         // 方括号方式

console.log(car);
// 输出: { brand: "Toyota", color: "Blue", model: "Camry", year: 2026 }
```

2. 删除属性

要彻底从对象中移除一个属性（包括键和值），必须使用 delete 操作符。

- 语法

```js
delete object.property;
// 或
delete object["property"];
```

- 核心特性

返回值：delete 操作通常返回 true（除非属性被设置为不可配置，这属于高级话题）。即便删除一个不存在的属性，它也会返回 true。

彻底性：删除后，该属性在对象中完全消失。再次访问该属性将返回 undefined。

- delete vs 赋值 null

1. obj.prop = null：属性依然存在，只是值变成了“空”。
2. delete obj.prop：属性完全移除。

```js
var user = { name: "Alice", age: 25 };

// 方式 A: 赋值 null
user.name = null;
console.log(user.name); // null (属性还在)

// 方式 B: delete 删除
delete user.age;
console.log(user.age);  // undefined (属性没了)
```

3. 属性检测

由于访问不存在的属性会返回 undefined，很多人习惯用 if (obj.prop) 来判断属性是否存在。但这存在逻辑漏洞。

- 逻辑漏洞

如果一个属性的值本身就是 `undefined`，简单的访问无法区分“属性不存在”还是“属性存在但值为 undefined”。

```js
var test = {
    data: undefined
};

console.log(test.data);      // undefined
console.log(test.notFound);  // undefined
// 仅凭结果无法区分 data 和 notFound 的区别
```

- 解决方案 A：in 操作符

1. 最通用的检测方式。如果属性在对象中（无论是自身的，还是继承自原型的），都返回 true。
2. 语法：`"key" in object` （注意键名必须是字符串）

```js
var person = { name: "Bob" };

console.log("name" in person); // true
console.log("age" in person);  // false
console.log("toString" in person); // true (继承自 Object.prototype)
```

- 解决方案 B：hasOwnProperty() 方法

语法：`object.hasOwnProperty("key")`

```js
var person = { name: "Bob" };

console.log(person.hasOwnProperty("name")); // true
console.log(person.hasOwnProperty("toString")); // false (虽然能用，但不是自有的)
```

4. 清空对象

如果想要删除对象中的所有属性，没有直接的 clear() 方法。通常有两种策略：

- 保留引用，逐个删除： 遍历对象键名，使用 delete 逐个删除（性能较差，但保留了原内存地址）。

- 重新赋值： 直接将变量指向一个新的空对象 `{}`（性能高，但旧对象的引用如果没有被切断，旧数据依然存在于内存中）。

```js
var data = { a: 1, b: 2 };

// 推荐方式：丢弃旧对象，指向新对象
data = {};
```

### 对象的遍历

1. for...in 循环

for...in 是 ES5 中遍历对象属性最基础、最通用的语法结构。

- 语法结构

```js
for (var variable in object) {
    // 循环体
    // variable 会被依次赋值为属性名（字符串）
}
```

- 执行逻辑

  - 枚举：循环会遍历对象中所有可枚举的属性。

  - 赋值：在每次迭代中，将当前属性的键名赋值给变量。

  - 求值：在循环体内，通过 方括号语法 `object[variable]` 获取对应的属性值。

- 标准示例

```js
var student = {
    name: "Alice",
    age: 20,
    major: "CS"
};

for (var key in student) {
    console.log("属性名: " + key);
    console.log("属性值: " + student[key]); // 注意：必须用方括号，不能用 student.key
    console.log("---");
}
```

2. 原型链污染

for...in 循环有一个极其重要的特性（或者说缺陷）：它不仅会遍历对象自身的属性，还会遍历对象原型链上所有可枚举的属性。

- 现象复现

如果在 Object.prototype 上添加了一个方法，所有的对象遍历都会受到影响。

```js
// 【危险操作】向原型添加公共方法
Object.prototype.sayHi = function() { console.log("Hi"); };

var dog = { breed: "Husky" };

for (var key in dog) {
    console.log(key);
}
// 输出结果:
// "breed"   (自身属性)
// "sayHi"   (继承自原型的属性 - 这是一个不需要的噪音！)
```

- 解决方案：hasOwnProperty 过滤

在 ES5 开发中，为了保证遍历的纯净性，必须在 for...in 内部配合 hasOwnProperty() 进行过滤。这是工业级代码的标准写法。

```js
for (var key in dog) {
    // 过滤守卫：只处理对象自身的属性
    if (dog.hasOwnProperty(key)) {
        console.log(key + ": " + dog[key]);
    }
}
// 输出结果: "breed": "Husky" (sayHi 被屏蔽了)
```

3. Object.keys()

ES5 引入了一个静态方法 Object.keys()，它提供了一种更现代、更安全的遍历方式。

- 语法与机制

语法：`Object.keys(obj)`

返回值：返回一个数组，包含对象自身所有可枚举属性的键名（不含继承属性）。

- 使用方式

获取到键名数组后，可以利用数组的遍历方法（如 forEach 或 for 循环）来处理。

```js
var student = { name: "Alice", age: 20 };

// 1. 获取所有键的数组
var keys = Object.keys(student); // ["name", "age"]

// 2. 遍历数组
for (var i = 0; i < keys.length; i++) {
    var key = keys[i];
    var value = student[key];
    console.log(key + " = " + value);
}
```

### 内存机制

1. 内存模型概览

JavaScript 引擎在执行代码时，会将内存划分为两个主要的区域来存储数据。划分的依据是数据的大小是否固定。

- 栈内存：用于存储简单、大小固定的数据。

- 堆内存：用于存储复杂、大小不固定的数据。

2. 栈内存

栈是一种线性结构，具有“先进后出” 的特性。它的管理由系统自动完成。

- 存储内容：原始类型

JavaScript 的 5 种基本数据类型（ES5）直接存储在栈内存中。因为它们占据的空间是固定的、较小的。

1. Number

2. String

3. Boolean

4. Null

5. Undefined

- 特性

1. 有序性：数据按顺序压入栈中。
2. 速度快：系统只需移动指针即可分配或释放内存，读写速度极快。

3. 按值访问：直接从栈中读取变量的值。

图解：

```
变量名   |  内存地址   |  值
-----------------------------
a       |  0x001     |  10
b       |  0x002     |  true
c       |  0x003     |  "hello"
```

3. 堆内存

堆是一块杂乱无章的大型内存区域。

- 存储内容：引用类型
- JavaScript 的所有对象类型都存储在堆内存中。因为对象的大小是不固定的（可以动态添加属性），无法直接放入栈中。
  - Object (普通对象)

  - Array (数组)

  - Function (函数)

- 特性
  - 无序性：数据随机存放，没有固定的顺序。
  - 动态大小：可以根据需要申请更多空间。

  - 速度慢：读取数据需要先找到地址，再通过地址去仓库找数据。

4. 引用的本质

这是理解 JS 对象的关键。

当我们声明一个对象变量时（例如 `var obj = { x: 1 };`），实际上发生了两件事：

- 在堆内存中：开辟一块空间，存储对象实体 `{ x: 1 }`。这个空间有一个唯一的内存地址（比如 0xFA01）。

- 在栈内存中：声明变量 `obj`，并将其值设置为那个内存地址 (0xFA01)。


结论：引用类型的变量，在栈中存储的不是数据本身，而是指向堆内存的“指针” (Pointer)。

5. 赋值操作

原始类型的赋值：深拷贝

当把一个原始变量赋值给另一个变量时，系统会在栈中复制一个新的值。

```js
var a = 10;
var b = a;  // 在栈中复制 10，给变量 b

b = 20;     // 修改 b，a 不受影响

console.log(a); // 10
console.log(b); // 20
```

> 原理：a 和 b 是两个独立的房间，互不干扰。

引用类型的赋值：浅拷贝

当把一个引用变量赋值给另一个变量时，系统在栈中复制的是内存地址。

```js
var obj1 = { name: "Alice" }; // 假设地址是 0x100
var obj2 = obj1;              // 将 0x100 复制给 obj2

obj2.name = "Bob";            // 通过 obj2 的地址找到堆内存，修改数据

console.log(obj1.name);       // "Bob" (obj1 也变了！)
```

> 原理：obj1 和 obj2 存储的是同一把钥匙。它们打开的是同一个房间。

6. 比较操作

- 原始类型比较

比较的是值是否相等。

```js
var a = 10;
var b = 10;
console.log(a === b); // true
```

- 引用类型比较

比较的是内存地址是否相同。这是新手常犯的错误。

```js
var arr1 = [1, 2, 3];
var arr2 = [1, 2, 3]; // 在堆内存中开辟了新空间，地址不同

console.log(arr1 === arr2); // false (虽然内容一样，但地址不同)

var arr3 = arr1;
console.log(arr1 === arr3); // true (地址相同)
```

### 数组对象

1. 核心定义与结构

- 数组 (Array) 是一个有序列表。
- 索引 (Index)：数组中的位置编号，从 0 开始。

- 元素 (Element)：数组中存储的数据，可以是任意类型（数字、字符串、对象、甚至另一个数组）。


本质：数组是对象的子类。`typeof []` 返回 `"object"`。

2. 创建方式

- 字面量

最简洁、最安全的创建方式。

```js
var arr = []; // 空数组
var colors = ["Red", "Green", "Blue"]; // 初始化数据的数组
```

- 构造函数

```js
var arr1 = new Array(3); // 创建一个长度为 3 的空数组 (容易混淆)
var arr2 = new Array(1, 2, 3); // 创建数组 [1, 2, 3]
```

3. 基础操作

- 访问与修改

使用方括号 `[]` 配合索引进行访问。

```js
var nums = [10, 20, 30];

// 读取
console.log(nums[0]); // 10 (第一个元素)
console.log(nums[2]); // 30 (第三个元素)
console.log(nums[99]); // undefined (索引越界不报错)

// 修改
nums[1] = 99; // [10, 99, 30]

// 新增 (自动扩容)
nums[3] = 40; // [10, 99, 30, 40]
```

- length 属性

`length` 属性表示数组的长度。它不仅仅是只读的，还可以被修改。

1. 截断数组：设置 `length` 小于当前长度，会删除多余元素。
2. 清空数组：设置 `length = 0`。

```js
var arr = [1, 2, 3, 4, 5];
arr.length = 2; 
console.log(arr); // [1, 2] (3, 4, 5 被删除了)
```

4. 增删改

这些方法会直接修改原数组（改变了堆内存中的数据）。

- 栈与队列操作

|    方法     |           描述           |    返回值    |
| :---------: | :----------------------: | :----------: |
|  push(el)   | 在末尾添加一个或多个元素 | 新数组的长度 |
|    pop()    |    删除末尾的一个元素    | 被删除的元素 |
| unshift(el) | 在开头添加一个或多个元素 | 新数组的长度 |
|   shift()   |    删除开头的一个元素    | 被删除的元素 |

- 万能方法：splice()

splice (拼接) 是数组最强大的方法，可以实现删除、插入、替换任意位置的元素。

语法：

```js
arr.splice(startIndex, deleteCount, item1, item2...)
```

```js
var arr = ["A", "B", "C", "D"];

// 1. 删除：从索引 1 开始，删除 2 个元素
arr.splice(1, 2); 
console.log(arr); // ["A", "D"]

// 2. 插入：从索引 1 开始，删除 0 个，插入 "X", "Y"
arr = ["A", "D"];
arr.splice(1, 0, "X", "Y");
console.log(arr); // ["A", "X", "Y", "D"]

// 3. 替换：删除 1 个，插入 1 个
arr.splice(1, 1, "M"); // 把 "X" 换成了 "M"
```

- 排序与反转

1. reverse()：颠倒数组元素的顺序。

2. sort()：对数组进行排序。

3. 陷阱：默认将元素转换为字符串后按 ASCII 码排序。10 会排在 2 前面。

4. 修正：传入比较函数。

```js
var nums = [2, 10, 5, 1];

// 错误写法
nums.sort(); // [1, 10, 2, 5] (按字符串排)

// 正确写法 (升序)
nums.sort(function(a, b) {
    return a - b; 
}); 
// [1, 2, 5, 10]
```

5. 访问与转换

这些方法不会修改原数组，而是返回一个新的数组或值。

- slice() (切片)

提取数组的一部分，返回新数组（类似于字符串的 substring）。

语法：`arr.slice(begin, end)` (包含 begin，不包含 end)

```js
var arr = ["A", "B", "C", "D", "E"];
var sub = arr.slice(1, 3); 
console.log(sub); // ["B", "C"]
console.log(arr); // 原数组不变
```

- concat() (合并)

合并两个或多个数组。

```js
var arr1 = [1, 2];
var arr2 = [3, 4];
var res = arr1.concat(arr2); // [1, 2, 3, 4]
```

- join() (转字符串)

将数组所有元素连接成一个字符串。

```js
var arr = ["2026", "01", "05"];
console.log(arr.join("-")); // "2026-01-05"
```

6. ES5 迭代方法 

- forEach()

单纯的遍历，没有返回值。

```js
var arr = ["Apple", "Banana"];
arr.forEach(function(item, index) {
    console.log(index + ": " + item);
});
```

- map() (映射)

遍历数组，对每个元素执行回调函数，并返回一个新数组（长度不变，内容变化）。

```js
var nums = [1, 2, 3];
var doubled = nums.map(function(item) {
    return item * 2;
});
console.log(doubled); // [2, 4, 6]
```

- filter() (过滤)

遍历数组，保留回调函数返回 true 的元素，返回一个新数组（长度可能变短）。

```js
var nums = [10, 5, 20, 3];
var bigNums = nums.filter(function(item) {
    return item > 9;
});
console.log(bigNums); // [10, 20]
```

### Date 日期对象

1. 创建日期对象

要创建一个日期对象，必须使用 new 操作符调用 Date 构造函数。主要有四种方式。

- 获取当前时间

不传任何参数，创建一个代表当前系统时刻的对象。

```js
var now = new Date();
console.log(now); // 输出当前日期和时间 (例如: Mon Jan 05 2026 14:30:00 GMT+0800)
```

- 基于时间戳创建

传入一个整数（毫秒数）。

```js
// 0 代表 1970-01-01 00:00:00 UTC
var epoch = new Date(0); 
console.log(epoch);
```

- 基于日期字符串创建

传入一个表示日期的字符串。

> 注意：不同浏览器对字符串格式的解析可能不一致。推荐使用标准的 ISO 格式 (YYYY-MM-DDTHH:mm:ss)。

```js
var date1 = new Date("2026-01-05");
var date2 = new Date("October 13, 2026 11:13:00");
```

- 基于数值参数创建 (年, 月, 日...)

传入具体的年、月、日、时、分、秒、毫秒。

语法：

```js
new Date(year, monthIndex, day, hours, minutes, seconds, ms)
```

> 必须项：至少需要传入 年 和 月。

```js
// 创建 2026年 1月 5日 10:30:00
var specific = new Date(2026, 0, 5, 10, 30, 0);
```

2. 月份从 0 开始

这是 Date 对象最大的设计坑。

- 年份：正常数值 (如 2026)。

- 日期：正常数值 (1 - 31)。

- 月份：从 0 开始计数！

  - 0 = 一月 (January)

  - 1 = 二月 (February)
  - ...

  - 11 = 十二月 (December)

```js
// 错误意图：想创建 2026年 2月
var wrong = new Date(2026, 2, 1); 
console.log(wrong); // 实际结果：2026年 3月 1日 (因为 2 代表三月)

// 正确写法
var right = new Date(2026, 1, 1); // 1 代表二月
```

3. 获取日期组件

Date 对象提供了一系列 get 方法来获取具体的时间分量。以下方法返回的都是本地时间（基于运行浏览器的电脑的时区）。

|      方法       |    描述    |     返回值范围     |             备注              |
| :-------------: | :--------: | :----------------: | :---------------------------: |
| `getFullYear()` |  获取年份  | 4位数字 (如 2026)  | 不要使用 `getYear()` (已废弃) |
|  `getMonth()`   |  获取月份  |       0 ~ 11       |           核心陷阱            |
|   `getDate()`   |  获取几号  |       1 ~ 31       |     注意是 Date 不是 Day      |
|   `getDay()`    | 获取星期几 |       0 ~ 6        |    0 代表周日，1 代表周一     |
|  `getHours()`   |  获取小时  |       0 ~ 23       |           24小时制            |
| `getMinutes()`  |  获取分钟  |       0 ~ 59       |                               |
| `getSeconds()`  |   获取秒   |       0 ~ 59       |                               |
|   `getTime()`   | 获取时间戳 | 1970年至今的毫秒数 |           极其常用            |

```js
var now = new Date();

console.log("年: " + now.getFullYear());
console.log("月: " + (now.getMonth() + 1)); // 通常显示时需要 +1
console.log("日: " + now.getDate());
console.log("星期: " + now.getDay());
```

4. 设置日期组件

对应 get 方法，有一系列 set 方法用于修改时间。

- setFullYear(year)

- setMonth(month)

- setDate(date)

- setHours(...) ...

自动校准特性

这是 Date 对象的一个极其强大的功能。如果你设置的数值超出了合理范围，它会自动进位或退位。

计算“35天后是几号”：

```js
var dt = new Date(2026, 0, 1); // 2026-01-01

// 直接设置日期为 36 (1 + 35)
// 1月显然没有 36号，引擎会自动计算
dt.setDate(dt.getDate() + 35); 

console.log(dt.toLocaleDateString()); 
// 输出: "2026/2/5" (自动跨越了月份)
```

5. 日期计算与时间戳

由于 Date 对象的底层是一个数字（时间戳），我们可以直接对其进行数学运算。

- 获取当前时间戳 

1. `Date.now()`：静态方法，性能最高，不创建对象直接返回当前毫秒数。
2. `new Date().getTime()`：旧式写法，兼容性极好。

- 计算时间差

两个日期对象相减，结果是毫秒差。

```js
var start = new Date();

// 模拟耗时操作 (例如循环)
for (var i = 0; i < 1000000; i++) {}

var end = new Date();

var duration = end - start; // 隐式转换，等同于 end.getTime() - start.getTime()
console.log("耗时: " + duration + "ms");
```

6. 日期格式化

如何将 Date 对象转换为用户可读的字符串？

|        方法        |          描述           |         输出示例 (视环境而定)          |
| :----------------: | :---------------------: | :------------------------------------: |
|    `toString()`    |      完整的字符串       | "Mon Jan 05 2026 14:30:00 GMT+0800..." |
|  `toDateString()`  |       仅日期部分        |           "Mon Jan 05 2026"            |
|  `toTimeString()`  |       仅时间部分        |          "14:30:00 GMT+0800"           |
| `toLocaleString()` |    本地化格式 (常用)    | "2026/1/5 14:30:00" (根据系统语言变化) |
|  `toISOString()`   | ISO 8601 标准 (API常用) |  "2026-01-05T06:30:00.000Z" (UTC时间)  |

### Math 数学对象

1. 静态性

Math 的所有属性和方法都是静态的。

调用方式：直接通过 `Math.方法名()` 调用。

错误写法：`var m = new Math();` (报错：Math is not a constructor)。

2. 数学常量

Math 对象包含了一些常用的数学常数，作为只读属性。

|     属性     |          描述           |   近似值   |
| :----------: | :---------------------: | :--------: |
|  `Math.PI`   |     圆周率 ($\pi$)      | 3.14159... |
|   `Math.E`   |  自然对数的底数 ($e$)   |  2.718...  |
| `Math.SQRT2` | 2 的平方根 ($\sqrt{2}$) |  1.414...  |

```js
// 计算半径为 5 的圆的面积
var radius = 5;
var area = Math.PI * radius * radius;
```

3. 取整方法

这是日常开发中使用频率最高的一组方法。务必区分它们处理小数的策略。

- Math.round(x)：四舍五入

标准的数学取整规则。

1. 小数部分 $\geq 0.5$ 向上取整。
2. 小数部分 $< 0.5$ 向下取整。

```js
console.log(Math.round(4.4)); // 4
console.log(Math.round(4.5)); // 5
console.log(Math.round(4.6)); // 5
console.log(Math.round(-4.5)); // -4 (注意负数的处理，-4.5 靠近 -4)
console.log(Math.round(-4.51)); // -5
```

- Math.ceil(x)：向上取整 

只要有小数部分，就往更大的整数靠拢。

1. 对于正数：进位。
2. 对于负数：舍去小数（因为 $-4.9$ 比 $-5$ 大）。

```js
console.log(Math.ceil(4.1));  // 5
console.log(Math.ceil(-4.9)); // -4
```

- Math.floor(x)：向下取整

往更小的整数靠拢。

- 对于正数：舍去小数。
- 对于负数：进位（$-4.1$ 会变成 $-5$）。

```js
console.log(Math.floor(4.9));  // 4
console.log(Math.floor(-4.1)); // -5
```

4. 基础运算方法

- 绝对值 Math.abs(x)

返回数的绝对值

```js
console.log(Math.abs(-10)); // 10
console.log(Math.abs(10));  // 10
```

- 幂运算 Math.pow(base, exponent)

返回基数 (base) 的指数 (exponent) 次幂。

```js
console.log(Math.pow(2, 3)); // 8 (即 2 的 3 次方)
console.log(Math.pow(4, 0.5)); // 2 (开平方的另一种写法)
```

- 平方根 Math.sqrt(x)

返回数的平方根。

```js
console.log(Math.sqrt(9)); // 3
console.log(Math.sqrt(-1)); // NaN (实数范围无法对负数开方)
```

5. 极值方法

Math.max() 和 Math.min() 用于获取一组数值中的最大值和最小值。

语法：接收任意数量的参数。

限制：它们不直接接收数组。

```js
console.log(Math.max(10, 5, 20, 3)); // 20
console.log(Math.min(10, 5, 20, 3)); // 3
```

6. 随机数

Math.random() 是生成随机数的唯一内置方法。

- 基础行为

1. 返回值：返回一个 `0` (包含) 到 `1` (不包含) 之间的伪随机浮点数。
2. 区间表示：$[0, 1)$

```js
console.log(Math.random()); // 例如 0.123456...
console.log(Math.random()); // 例如 0.987654...
```

- 通用公式：生成指定范围的随机整数

这是开发中生成随机 ID、随机颜色、抽奖算法的基础。

如果要生成一个在 `[min, max]` 范围内的随机整数（包含 min 和 max）：

公式推导：

1. `Math.random()` $\rightarrow$ $[0, 1)$
2. 乘以范围跨度 `(max - min + 1)` $\rightarrow$ $[0, \text{跨度})$
3. 向下取整 `Math.floor(...)` $\rightarrow$ 得到 $0$ 到 $\text{跨度}-1$ 的整数
4. 加上偏移量 `min` $\rightarrow$ $[min, max]$

标准函数代码：

```js
function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

// 示例：生成 1 到 10 之间的随机数
var randomNum = getRandomInt(1, 10);
```

### JSON 对象

1. 定义 

在 JavaScript 语言中，`JSON` 是一个全局内置对象（类似于 `Math`）。

- 不可构造：你不能使用 `new JSON()`。
- 静态工具：它提供了一组静态方法，用于在“JavaScript 对象”和“JSON 字符串”之间进行转换。

1.1 数据格式标准

JSON 格式基于 JavaScript 对象字面量语法，但更加严格。它本质上是一段字符串。

- JS 对象：内存中的数据结构。
- JSON 字符串：用于传输或存储的文本序列。

2. 严格的语法规则

这是新手最容易混淆的地方。编写 JSON 数据或手动拼接 JSON 字符串时，必须遵守以下铁律，否则解析时会报错。

|    规则    |            JSON 格式            | JS 对象字面量 (普通写法) |
| :--------: | :-----------------------------: | :----------------------: |
|  键名引号  |        必须用双引号 `"`         |    可省略，可用单引号    |
| 字符串引号 |        必须用双引号 `"`         |      可用单引号 `'`      |
|  数据类型  |  禁止 `Function`, `Undefined`   |       允许任意类型       |
|  尾后逗号  | 严禁 (最后一个属性后不能有逗号) |       允许 (ES5+)        |

正确示例：

```json
{
    "name": "Alice",
    "age": 25,
    "isAdmin": true
}
```

3. JSON.stringify()

该方法用于序列化 (Serialization)，即：JS 对象 $\rightarrow$ JSON 字符串。

3.1 基础用法

```js
var user = {
    name: "Bob",
    age: 30,
    courses: ["Math", "CS"]
};

var jsonStr = JSON.stringify(user);

console.log(typeof jsonStr); // "string"
console.log(jsonStr); 
// 输出: '{"name":"Bob","age":30,"courses":["Math","CS"]}'
```

3.2 数据丢失机制

由于 JSON 格式不支持函数和 undefined，`stringify` 会在转换过程中自动过滤这些数据。

```js
var data = {
    id: 1,
    doSomething: function() { console.log("Run"); }, // 函数
    memo: undefined                                  // undefined
};

console.log(JSON.stringify(data));
// 输出: '{"id":1}'
// 警告：函数和 undefined 属性直接消失了！
```

3.3 格式化输出

`stringify` 接收第三个参数，用于控制缩进，常用于调试打印。

```js
// 使用 4 个空格缩进
console.log(JSON.stringify(user, null, 4));
/* 输出:
{
    "name": "Bob",
    "age": 30,
    "courses": [
        "Math",
        "CS"
    ]
}
*/
```

4. JSON.parse()

该方法用于反序列化 (Deserialization)，即：JSON 字符串 $\rightarrow$ JS 对象。

4.1 基础用法

通常用于处理从服务器接收到的 API 数据。

```js
var response = '{"status": "success", "code": 200}'; // 模拟服务器返回的字符串

var resObj = JSON.parse(response);

console.log(resObj.status); // "success"
```

4.2 异常处理

如果传递给 `parse` 的字符串格式不合法（哪怕少了一个双引号），JavaScript 会抛出 `SyntaxError` 异常，并导致程序崩溃。

最佳实践：始终将 `JSON.parse` 包裹在 `try...catch` 代码块中。

```js
var badString = "{ name: 'Alice' }"; // 错误：键名未加引号，使用了单引号

try {
    var obj = JSON.parse(badString);
} catch (error) {
    console.error("解析失败，数据格式错误！");
}
```

5. 深拷贝

在 ES5 中，除了引入第三方库（如 Lodash），最简单的实现对象深拷贝（完全复制，修改新对象不影响旧对象）的方法就是利用 JSON。

- 原理：对象 $\rightarrow$ 字符串 (切断引用) $\rightarrow$ 新对象 (开辟新内存)。

```js
var original = {
    a: 1,
    b: { x: 10 } // 嵌套对象
};

// 1. 浅拷贝 (引用传递)
var shallow = original;
shallow.b.x = 999;
console.log(original.b.x); // 999 (原对象被改了)

// 2. 深拷贝 (JSON 暴力转换)
// 重置原数据
original.b.x = 10; 

var deepCopy = JSON.parse(JSON.stringify(original));

deepCopy.b.x = 888;
console.log(original.b.x); // 10 (原对象安全，未受影响)
```

局限性：这种方法不能拷贝函数、正则表达式，也会丢失 `undefined` 属性。但在处理纯数据（如后端返回的 JSON 数据）时非常有效。

### 原型对象

1. 核心概念

在传统的面向对象语言中，我们通过“类”定义属性和方法，然后实例化对象。

在 JavaScript (ES5) 中，没有真正的类。为了实现对象之间的方法共享和节省内存，JavaScript 设计了原型机制。

核心思想：

所有的 JavaScript 对象（null 除外）在创建时，都会与另一个对象关联起来。这个被关联的对象就叫做“原型”。每一个对象都会从原型“继承”属性。

2. 关键三角关系

要理解原型，必须在脑海中构建出**构造函数**、**原型对象**、**实例**这三者之间的指向关系网。

2.1 构造函数

用来初始化对象的函数。按照惯例，首字母大写。

```js
function Person() { ... }
```

2.2 原型对象

- 定义：任何函数在创建时，系统都会自动为它添加一个 `prototype` 属性。这个属性指向一个空对象，这个对象就是原型对象。
- 作用：它相当于一个公共仓库，所有通过该构造函数创建的实例，都可以去这个仓库里拿东西（访问属性和方法）。

2.3 实例

通过 `new` 关键字调用的结果。

```js
var p1 = new Person();
```

3. 三条核心链路

请务必死记硬背以下三个属性及其指向，这是理解原型链的基础。

3.1 `prototype` (显式原型)

- 持有者：只有函数（构造函数）才有此属性。
- 指向：指向原型对象。
- 代码：`Person.prototype`

3.2 `__proto__` (隐式原型)

- 持有者：所有的对象（包括实例）都有此属性。
  - *注：ES 标准中称为 `[[Prototype]]`，但在浏览器中通常通过 `__proto__` 访问。*
- 指向：指向创建该对象的构造函数的原型对象。
- 代码：`p1.__proto__`

```js
p1.__proto__ === Person.prototype // true
```

>p1 的隐式原型，就是 Person 的显式原型。它们指向内存中的同一个对象。

3.3 `constructor` (构造器)

- 持有者：原型对象拥有此属性。
- 指向：指回构造函数本身。
- 作用：用于记录“我是由谁创建的”。
- 代码：`Person.prototype.constructor === Person // true`

4. 原型机制的内存优势

为什么不直接把方法写在构造函数里？

方案 A：写在构造函数内 (浪费内存)

```js
function Person(name) {
    this.name = name;
    this.sayHi = function() { console.log("Hi"); };
}
var p1 = new Person("A");
var p2 = new Person("B");
```

后果：`p1` 和 `p2` 都有自己的 `sayHi` 方法。虽然功能一样，但在内存中是两个独立的函数副本。如果有 1000 个实例，就有 1000 个函数，极度浪费。

方案 B：写在原型对象上 (内存共享)

```js
function Person(name) {
    this.name = name; // 属性各不相同，写在构造函数里
}

// 方法是通用的，写在原型上
Person.prototype.sayHi = function() { 
    console.log("Hi"); 
};

var p1 = new Person("A");
var p2 = new Person("B");
```

- 后果：`p1` 和 `p2` 自身没有 `sayHi`。当调用 `p1.sayHi()` 时，它们都通过 `__proto__` 引用同一个原型对象上的 `sayHi`。
- 结论：无论创建多少实例，方法在内存中只有一份。

5. 原型链

这是 JavaScript 属性查找的底层机制。

当访问一个对象的属性 `obj.prop` 时：

1. 自身查找：检查 `obj` 自身是否有 `prop` 属性。
   - 有 $\rightarrow$ 返回属性值。
   - 无 $\rightarrow$ 下一步。
2. 原型查找：通过 `obj.__proto__` 找到原型对象，检查原型上是否有 `prop`。
   - 有 $\rightarrow$ 返回属性值。
   - 无 $\rightarrow$ 下一步。
3. 原型的原型：继续沿着 `__proto__` 向上查找。
4. 终点：一直找到 `Object.prototype`。
   - 如果 `Object.prototype` 里也没有，则查找 `Object.prototype.__proto__`，其值为 **`null`**。
   - 返回 `undefined`。

代码追踪：

```js
// 1. 构造函数
function Dog() {}
Dog.prototype.bark = "Woof";

// 2. 实例
var myDog = new Dog();

// 3. 原型链查找测试
myDog.toString(); 
// 过程：
// a. myDog 自身有 toString 吗？ -> 无
// b. myDog.__proto__ (即 Dog.prototype) 有 toString 吗？ -> 无
// c. Dog.prototype.__proto__ (即 Object.prototype) 有 toString 吗？ -> 有！
// d. 执行 Object.prototype.toString
```

6. 原型的动态性

JavaScript 的原型是动态的。这意味着我们在原型上添加属性，已经创建的实例也会立即拥有该属性。

```js
function User() {}
var u = new User();

// 此时 u.hello 是 undefined

// 动态添加方法
User.prototype.hello = function() { console.log("World"); };

// u 立即可以使用，因为它是通过引用（指针）查找的
u.hello(); // "World"
```

- 陷阱：重写原型

如果直接将 prototype 赋值为一个新对象，会切断旧实例的联系。

```js
User.prototype = { 
    run: function() {} 
};
// 之前创建的实例 u 依然指向旧的原型，无法访问 run
```

### String 字符串对象

1. 核心定义与创建

两种创建方式

在 JavaScript 中，创建字符串有两种方式。

字面量—— [推荐] 使用单引号 ' 或双引号 " 包裹文本。

```js
var str1 = "Hello World";
var str2 = 'Hello World';
console.log(typeof str1); // "string" (原始类型)
```

构造函数—— [不推荐] 使用 new String() 创建一个字符串对象。

```js
var strObj = new String("Hello World");
console.log(typeof strObj); // "object" (对象类型)
```

字符串的不可变性

字符串一旦创建，它的内容就永远无法改变。 所有看似修改字符串的方法（如 toUpperCase, replace），实际上都是返回了一个全新的字符串，原字符

串保持不变。

```js
var lang = "Java";
lang = lang + "Script"; 
// 过程：
// 1. 销毁原先的 "Java" 字符串
// 2. 创建一个新的 "JavaScript" 字符串
// 3. 将 lang 变量指向新字符串
```

错误操作示范：

```js
var str = "Hello";
str[0] = "B"; // 试图把 H 改成 B
console.log(str); // "Hello" (修改无效，且不会报错)
```

2. 基础属性与访问

- length 属性

返回字符串的长度（字符个数）。空格和标点符号也计算在内。

```js
var txt = "Hi JS";
console.log(txt.length); // 5 (中间的空格也算一个)
```

- 字符访问

获取指定位置的字符。

1. `charAt(index)`：返回指定索引位置的字符。如果越界返回空字符串 ""。
2. 方括号 [] (ES5+)：类似于数组下标。如果越界返回 undefined。

```js
var str = "Hello";
console.log(str.charAt(1)); // "e"
console.log(str[1]);        // "e"
```

3. 查找与搜索

|       方法       |                 描述                  |         返回值         |
| :--------------: | :-----------------------------------: | :--------------------: |
|   indexOf(str)   |  从前往后找，返回str第一次出现的索引  | 索引值 (找不到返回 -1) |
| lastIndexOf(str) | 从后往前找，返回str最后一次出现的索引 | 索引值 (找不到返回 -1) |
|  includes(str)   |         判断是否包含str (ES6)         |      true / false      |
| startsWith(str)  |        判断是否以str开头 (ES6)        |      true / false      |
|  endsWith(str)   |        判断是否以str结尾 (ES6)        |      true / false      |

```js
var email = "admin@example.com";

console.log(email.indexOf("@"));     // 5
console.log(email.includes("example")); // true
console.log(email.startsWith("admin")); // true
```

4. 截取与提取

用于从字符串中提取一部分内容。这三个方法都不会改变原字符串。

- slice(start, end)

规则：提取从 start 开始到 end 结束（不包含 end）的字符串。

特性：支持负数参数（表示从倒数第几个开始）。

```js
var str = "Apple, Banana, Kiwi";
var res = str.slice(7, 13); // "Banana"
var last = str.slice(-4);   // "Kiwi" (取最后4个)
```

- substring(start, end)

规则：类似于 slice，但不包含 end。

缺陷：不支持负数（负数会被当作 0）。通常建议用 slice 替代。

5. 修改与替换

再次强调：这些方法返回的是新字符串。

- replace(search, replacement)

查找并替换内容。

1. 默认行为：只替换第一个匹配项。

2. 全局替换：需使用正则表达式 /g (Global)。

```js
var text = "Visit Microsoft. Microsoft is big.";
var newText = text.replace("Microsoft", "Google");
console.log(newText); // "Visit Google. Microsoft is big." (只换了第一个)

// 全局替换 (正则)
var allNew = text.replace(/Microsoft/g, "Google");
```

- toUpperCase() / toLowerCase()

大小写转换。

```js
var str = "Hello";
console.log(str.toUpperCase()); // "HELLO"
```

- concat()

连接两个或多个字符串。

注意：通常直接使用 + 运算符更方便。

```js
var text1 = "Hello";
var text2 = "World";
var text3 = text1.concat(" ", text2); // "Hello World"
```

- trim()

去除字符串两端的空白字符（空格、换行符等）。

```js
var str = "   Hello World!   ";
console.log(str.trim()); // "Hello World!"
```

6. 转换

- split(separator)

将字符串按照指定的分隔符拆分成数组。

```js
var data = "a,b,c,d,e";
var arr = data.split(","); // 以逗号分割
console.log(arr); // ["a", "b", "c", "d", "e"] (变成了数组)

var txt = "Hello";
console.log(txt.split("")); // ["H", "e", "l", "l", "o"] (每个字符拆分)
```

7. 模板字面量

在 2026 年，这是处理字符串的标准方式，彻底取代了繁琐的 + 号拼接。

- 语法

使用 反引号 (`) 包裹字符串，而不是单引号或双引号。

- 变量插值

使用 ${variable} 直接在字符串中嵌入变量或表达式。

- 多行字符串

支持直接换行。

```js
var name = "Alice";
var age = 25;

// 旧式写法 (繁琐)
var oldMsg = "Hello, my name is " + name + " and I am " + age + " years old.";

// 模板字面量写法 (清晰)
var newMsg = `Hello, my name is ${name} and I am ${age} years old.`;

// 多行支持
var html = `
  <div>
    <h1>${name}</h1>
  </div>
`;
```

### 正则表达式

1. 创建方式

在 JavaScript 中，创建正则表达式有两种方式。

- 字面量


使用一对斜杠 / 包裹模式。脚本加载时编译，性能更好。

语法：`var reg = /pattern/flags;`

```js
var re = /ab+c/i; // 匹配 ab+c，忽略大小写
```

- 构造函数 

使用 `new RegExp()` 创建。适用于模式是动态的（由变量产生）情况。

语法：`var reg = new RegExp("pattern", "flags");`

注意：由于参数是字符串，字符串内部的转义字符 `\` 需要双重转义（`\\`）。

```js
var re = new RegExp("ab+c", "i");
var digit = new RegExp("\\d+"); // 匹配数字，必须写 \\d
```

2. 模式修饰符

修饰符位于正则表达式的尾部，用于控制匹配的模式。可以组合使用。

| 修饰符 |    含义     |                         描述                         |
| :----: | :---------: | :--------------------------------------------------: |
|   i    | Ignore Case |           忽略大小写（A 和 a 视为一样）。            |
|   g    |   Global    | 全局匹配（找到所有匹配，而不是在第一个匹配后停止）。 |
|   m    |  Multiline  |   多行匹配（使 ^ 和 $ 能匹配每一行的开始和结束）。   |

```js
var str = "A a A";
console.log(str.match(/a/));   // ["a"] (只匹配第一个，区分大小写)
console.log(str.match(/a/gi)); // ["A", "a", "A"] (全局且忽略大小写)
```

3. 语法规则

- 字符类

用于匹配特定类型的字符。

| 符号 |                       描述                       |    等价于    |
| :--: | :----------------------------------------------: | :----------: |
|  .   |      通配符。匹配除换行符外的任意单个字符。      |              |
|  \d  |                匹配数字 (Digit)。                |    [0-9]     |
|  \D  |                   匹配非数字。                   |    [^0-9]    |
|  \w  |  匹配单词字符 (Word)。包含字母、数字、下划线。   | [A-Za-z0-9_] |
|  \W  |         匹配非单词字符（如标点、空格）。         |              |
|  \s  | 匹配空白字符 (Space)。包含空格、制表符、换行符。 |              |
|  \S  |                 匹配非空白字符。                 |              |

- 字符集合

使用方括号 `[]` 自定义匹配范围。

`[abc]`：匹配 a 或 b 或 c 中的任意一个。

`[^abc]`：匹配除了 a、b、c 之外的任意字符（取反）。

`[a-z]`：匹配任意小写字母。

- 边界锚点

用于限制匹配的位置，不消耗字符。

```js
符号,描述
^,匹配输入的开始。
$,匹配输入的结束。
\b,"匹配单词边界 (Word Boundary)。(例如 ""moon"" 中的 m 前面)"
```

- 量词

用于指定前面的字符出现的次数。

|  符号   |            描述            |  次数   |
| :-----: | :------------------------: | :-----: |
|  `\*`   |     出现 0 次或多次。      | `{0,}`  |
|   `+`   |     出现 1 次或多次。      | `{1,}`  |
|   `?`   | 出现 0 次或 1 次（可选）。 | `{0,1}` |
|  `{n}`  |      精确出现 n 次。       |         |
| `{n,}`  |      至少出现 n 次。       |         |
| `{n,m}` |      出现 n 到 m 次。      |         |

- 分组与逻辑

1. `|`：逻辑。 ab|cd 匹配 "ab" 或 "cd"。
2. `()`：分组。将多个字符看作一个整体，并捕获匹配结果。

```js
var reg = /(abc)+/; // 匹配 "abc" 重复 1 次或多次
```

4. 操作方法

正则的操作分为两类：正则对象的方法和字符串对象的方法。

- 正则对象的方法
  - test(string) 

作用：检测字符串是否匹配模式。

返回：true 或 false。

场景：表单验证 (if 判断)。

```js
var reg = /^\d{11}$/; // 11位数字
console.log(reg.test("13800138000")); // true
```

> exec(string)

作用：检索字符串中的匹配项。

返回：如果有匹配，返回一个数组（包含匹配信息）；否则返回 `null`。

特性：配合 `g` 修饰符，可以循环调用提取所有匹配项。

- 字符串对象的方法

这些是 String 对象的方法，但接收正则作为参数。

> search(reg)

返回第一个匹配项的索引。找不到返回 -1。

> match(reg)

非全局 (/a/)：返回数组，包含捕获组信息（类似 exec`）。

全局 (/a/g)：返回所有匹配子串组成的数组，不包含捕获组信息。

> split(reg)

使用正则作为分隔符拆分字符串。

```js
var str = "a,  b, c";
// 匹配逗号及后面任意数量的空格
console.log(str.split(/,\s*/)); // ["a", "b", "c"]
```

> replace(reg, newStr)

替换匹配的子串。

高级用法：在 newStr 中使用 $1, $2 引用正则中的分组 () 内容。

```js
var date = "2026-01-05";
// 将 YYYY-MM-DD 替换为 MM/DD/YYYY
// 分组1: (\d{4}), 分组2: (\d{2}), 分组3: (\d{2})
var reg = /^(\d{4})-(\d{2})-(\d{2})$/;

var newDate = date.replace(reg, "$2/$3/$1");
console.log(newDate); // "01/05/2026"
```

5. 贪婪与惰性

贪婪模式 (默认)：量词（如 *, +）会尽可能多地匹配字符。

惰性模式：在量词后面加 ?，尽可能少地匹配字符。

```js
var str = "<div>hello</div>";

// 贪婪匹配：从第一个 < 到最后一个 >
console.log(str.match(/<.*>/)); // ["<div>hello</div>"]

// 惰性匹配：从第一个 < 到第一个 >
console.log(str.match(/<.*?>/)); // ["<div>"]
```

## 异常处理

### 核心语法

```js
try...catch...finally
```

这是处理运行时错误的标准结构。

1. 语法结构

```js
try {
    // 【尝试区】
    // 放入可能会报错的“危险代码”
    // 一旦这里报错，立即停止执行 try 块内的剩余代码，跳到 catch 块
} catch (error) {
    // 【捕获区】
    // 只有当 try 块报错时，这里才会执行
    // error 参数包含了错误的详细信息
} finally {
    // 【终结区】(可选)
    // 无论是否报错，无论是否 return，这里**一定**会执行
    // 通常用于清理工作（如关闭数据库连接、清除 Loading 状态）
}
```

2. 实战演示

```js
console.log("1. 开始执行");

try {
    console.log("2. 尝试执行危险代码");
    // 故意调用一个不存在的函数，触发错误
    myFunction(); 
    console.log("3. 这行代码永远不会执行"); // 被跳过
} catch (e) {
    console.log("4. 捕获到错误！");
    console.log("错误信息: " + e.message);
} finally {
    console.log("5. 清理现场，无论如何我都会运行");
}

console.log("6. 程序继续运行，没有崩溃");
```

### 错误对象

在 catch(e) 中捕获到的变量 e，是一个标准的错误对象。它主要包含三个属性：

|  属性   |         描述         |                  示例                  |
| :-----: | :------------------: | :------------------------------------: |
|  name   |  错误的名称（类型）  |            "ReferenceError"            |
| message |  错误的具体描述信息  |      "myFunction is not defined"       |
|  stack  | 堆栈追踪（调试神器） | 显示错误发生在哪一行、哪个函数调用栈中 |

常见的原生错误类型：

- SyntaxError: 语法错误（如少写了括号）。

- ReferenceError: 引用错误（使用了未声明的变量）。

- TypeError: 类型错误（如对 null 读取属性，或把字符串当函数调用）。

### 主动抛出错误

除了等待浏览器报错，我们还可以根据业务逻辑主动报错。这在封装函数或组件时非常有用。

1. 语法

throw 语句可以抛出任何类型的数据（字符串、数字、对象），但强烈建议抛出 Error 对象（因为它包含堆栈信息）。

```js
function divide(a, b) {
    if (b === 0) {
        // 主动抛出一个错误对象
        throw new Error("除数不能为零！");
    }
    return a / b;
}

try {
    var result = divide(10, 0);
} catch (e) {
    console.error("计算失败: " + e.message); // 输出：计算失败: 除数不能为零！
}
```
