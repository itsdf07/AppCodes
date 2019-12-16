package com.itsdf07.app.activity.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ExamplesActivity界面二级列表中Item项的数据封装类
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public class ExamplesItemBean {
    private int itemIcon;//Item图标
    private String itemContent;//Item内容/大标题
    private String itemMark;//Item子内容/小标题
    private int itemChildCount;//Item子菜单数量
    private List<ExamplesItemBean> children;//Item的子级数据

    public int getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(int itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public String getItemMark() {
        return itemMark;
    }

    public void setItemMark(String itemMark) {
        this.itemMark = itemMark;
    }

    public int getItemChildCount() {
        return itemChildCount;
    }

    public void setItemChildCount(int itemChildCount) {
        this.itemChildCount = itemChildCount;
    }

    public List<ExamplesItemBean> getChildren() {
        if (null == children) {
            return new ArrayList<>();
        }
        return children;
    }

    public void setChildren(List<ExamplesItemBean> children) {
        this.children = children;
    }
}
