# XTabLayout

### Copy of TabLayout add support for adjusting width of Indicator.

主要对比集中修改TabLayout的Indicator的width的方法优缺点。

针对两种反射版本会压缩Tab边距的方式，采取最好的改源码的方式来支持TabLayout的Indicator的宽度的自定义。


添加<attr name="xy_tabIndicatorWidth" format="dimension"/>，支持TabLayout的Indicator的width的自定义。
```
<declare-styleable name="XTabLayout">
        <attr name="xy_tabIndicatorColor" format="color"/>
        <attr name="xy_tabIndicatorHeight" format="dimension"/>
        <attr name="xy_tabIndicatorWidth" format="dimension"/>
        <attr name="xy_tabContentStart" format="dimension"/>
        <attr name="xy_tabBackground" format="reference"/>
        <attr name="xy_tabMode">
            <enum name="scrollable" value="0"/>
            <enum name="fixed" value="1"/>
        </attr>
        <attr name="xy_tabGravity">
            <enum name="fill" value="0"/>
            <enum name="center" value="1"/>
        </attr>
        <attr name="xy_tabMinWidth" format="dimension"/>
        <attr name="xy_tabMaxWidth" format="dimension"/>
        <attr name="xy_tabTextAppearance" format="reference"/>
        <attr name="xy_tabTextColor" format="color"/>
        <attr name="xy_tabSelectedTextColor" format="color"/>
        <attr name="xy_tabPaddingStart" format="dimension"/>
        <attr name="xy_tabPaddingTop" format="dimension"/>
        <attr name="xy_tabPaddingEnd" format="dimension"/>
        <attr name="xy_tabPaddingBottom" format="dimension"/>
        <attr name="xy_tabPadding" format="dimension"/>
    </declare-styleable>
```


截图：

![](http://ohazfcl3s.bkt.clouddn.com/TabLayout_1.jpeg)

博客链接：[关于TabLayout的indicator宽度的一次探索](https://blog.csdn.net/h_gao/article/details/79784325)