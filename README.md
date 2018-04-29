# XTabLayout

### Copy of TabLayout add support for adjusting width of Indicator.

在对比几种修改TabLayout的Indicator的width的方法后，决定采用修改源码的方法来实现Indicator 宽度的自定义。

（主要因为两种反射版本会压缩Tab边距的方式。）

添加x_tabIndicatorWidth来支持TabLayout的Indicator的width的自定义。

截图：

![](http://ohazfcl3s.bkt.clouddn.com/TabLayout_1.jpeg)

```
<declare-styleable name="XTabLayout">
        <attr name="x_tabIndicatorColor" format="color"/>
        <attr name="x_tabIndicatorHeight" format="dimension"/>
        <attr name="x_tabIndicatorWidth" format="dimension"/>
        <attr name="x_tabContentStart" format="dimension"/>
        <attr name="x_tabBackground" format="reference"/>
        <attr name="x_tabMode">
            <enum name="scrollable" value="0"/>
            <enum name="fixed" value="1"/>
        </attr>
        <attr name="x_tabGravity">
            <enum name="fill" value="0"/>
            <enum name="center" value="1"/>
        </attr>
        <attr name="x_tabMinWidth" format="dimension"/>
        <attr name="x_tabMaxWidth" format="dimension"/>
        <attr name="x_tabTextAppearance" format="reference"/>
        <attr name="x_tabTextColor" format="color"/>
        <attr name="x_tabSelectedTextColor" format="color"/>
        <attr name="x_tabPaddingStart" format="dimension"/>
        <attr name="x_tabPaddingTop" format="dimension"/>
        <attr name="x_tabPaddingEnd" format="dimension"/>
        <attr name="x_tabPaddingBottom" format="dimension"/>
        <attr name="x_tabPadding" format="dimension"/>
    </declare-styleable>
```

博客链接：[关于TabLayout的indicator宽度的一次探索](https://blog.csdn.net/h_gao/article/details/79784325)
