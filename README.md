# XTabLayout

### 背景
XTabLayout主要是基于原生TabLayout的改造，最早的需求是想可以手动调整TabLayout的下划线宽度，由于项目中TabLayout和ViewPager这样的使用方式很多，所以不想改动太多现有代码，在对比了各种改动TabLayout的下划线宽度之后，发现这种基于系统TabLayout改造的XTabLayout这种实现更好，另外可定制性也更高。

### 比较

各种改动 | 优势 | 局限
---|--- |---
系统TabLayout | 无需代码改动 | 不够灵活，各种属性不能定制
基于系统TabLayout反射一 | 改动小| 不够灵活，容易有兼容问题，TabLayout一些属性会失效，比如tabMode设置scrollable会失效
基于系统TabLayout反射二 | 改动小 | 不够灵活，容易有兼容问题，会压缩TabLayout的Tab左右padding，这样tab的可点击区域会变小
XTabLayout | 灵活，定制性高 | 需要修改不少TabLayout的逻辑

可以看下面的截图效果比较：

![](https://raw.githubusercontent.com/JasonGaoH/XTabLayout/master/gif/tablayout_compare.png)

GIF展示：

![](https://raw.githubusercontent.com/JasonGaoH/XTabLayout/master/gif/xtablayout.gif)

### 另外

在支持用x_tabIndicatorWidth属性来动态设置下划线高度的同时，还增加了以下新功能：

1. 添加x_tabIndicatorAnimation来控制是否支持类似微博的导航条动效，默认false不支持
2. 添加x_tabIndicatorRoundRect来控制Indicator下划线的圆角效果，默认false没有圆角
3. 支持在Tab上加入红点和红点数字

详情请见博客链接：[关于TabLayout的indicator宽度的一次探索](https://jasongaoh.github.io/2019/03/22/%E5%85%B3%E4%BA%8ETabLayout%E7%9A%84indicator%E5%AE%BD%E5%BA%A6%E7%9A%84%E4%B8%80%E6%AC%A1%E6%8E%A2%E7%B4%A2/)

关于
--

博客：[https://jasongaoh.github.io](https://jasongaoh.github.io)

邮箱：jasongaohui@gmail.com

License
--
Copyright 2018 JasonGaoH

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
