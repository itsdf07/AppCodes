package com.itsdf07.app.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itsdf07.app.R;
import com.itsdf07.app.activity.bean.ExamplesItemBean;

import java.util.List;


/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public class ExamplesElvAdapter extends BaseExpandableListAdapter {
    private List<ExamplesItemBean> examplesItemBeanList;
    Context context;

    public ExamplesElvAdapter(Context context, List<ExamplesItemBean> examplesItemBeanList) {
        if (null == this.examplesItemBeanList) {
            this.examplesItemBeanList = examplesItemBeanList;
        } else {
            this.examplesItemBeanList.clear();
            this.examplesItemBeanList.addAll(examplesItemBeanList);
        }
        this.context = context;
    }

    public void updateDatas(List<ExamplesElvAdapter> channels) {
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return examplesItemBeanList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return examplesItemBeanList.get(groupPosition).getChildren().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return examplesItemBeanList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return examplesItemBeanList.get(groupPosition).getChildren().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们
    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder itemViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_examples_item_group, parent, false);
            itemViewHolder = new GroupViewHolder();
            itemViewHolder.ivItemIcon = convertView.findViewById(R.id.iv_icon);
            itemViewHolder.tvItemContent = convertView.findViewById(R.id.tv_content);
            itemViewHolder.tvItemChildCount = convertView.findViewById(R.id.tv_children);
            itemViewHolder.layoutItem = convertView.findViewById(R.id.layout_item);
            convertView.setTag(itemViewHolder);
        } else {
            itemViewHolder = (GroupViewHolder) convertView.getTag();
        }
        convertView.setPadding(0, 15, 0, 0);//设置一级菜单的Item间隔
//        itemViewHolder.ivItemIcon.setImageResource(examplesItemBeanList.get(groupPosition).getItemIcon());
        itemViewHolder.tvItemContent.setText(examplesItemBeanList.get(groupPosition).getItemContent());
        itemViewHolder.tvItemChildCount.setText(examplesItemBeanList.get(groupPosition).getChildren().size() + "");
        if (isExpanded) {
            itemViewHolder.layoutItem.setBackgroundResource(R.drawable.bg_examples_item_group_expanded);
        } else {
            itemViewHolder.layoutItem.setBackgroundResource(R.drawable.bg_examples_item_group_unexpanded);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder itemViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_examples_item_child, parent, false);
            itemViewHolder = new ChildViewHolder();
            itemViewHolder.ivItemIcon = convertView.findViewById(R.id.iv_icon);
            itemViewHolder.tvItemContent = convertView.findViewById(R.id.tv_content);
            itemViewHolder.tvItemMark = convertView.findViewById(R.id.tv_mark);
            convertView.setTag(itemViewHolder);
        } else {
            itemViewHolder = (ChildViewHolder) convertView.getTag();
        }

        itemViewHolder.tvItemContent.setText(examplesItemBeanList.get(groupPosition).getChildren().get(childPosition).getItemContent());
        itemViewHolder.tvItemMark.setText(examplesItemBeanList.get(groupPosition).getChildren().get(childPosition).getItemMark());
        if (isLastChild) {
            convertView.setBackgroundResource(R.drawable.bg_examples_item_child_expanded);
        }

        return convertView;
    }

    //指定位置上的子元素是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class GroupViewHolder {
        ImageView ivItemIcon;//Item图标
        TextView tvItemContent;//Item内容/大标题
        TextView tvItemChildCount;//Item子菜单数量
        View layoutItem;
    }

    static class ChildViewHolder {
        ImageView ivItemIcon;//Item图标
        TextView tvItemContent;//Item内容/大标题
        TextView tvItemMark;//Item子内容/小标题
    }
}
