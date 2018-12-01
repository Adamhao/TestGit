package com.etoak.util;

import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2018/11/7 11:47.
 */
public class TreeNode {
    /*
        id：绑定节点的标识值。
        text：显示的节点文本。
        iconCls：显示的节点图标CSS类ID。
        checked：该节点是否被选中。
        state：节点状态，'open' 或 'closed'。
        attributes：绑定该节点的自定义属性。
    */
    private Integer id;
    private String text;
    private String state;
    private Boolean checked;
    private String iconCls;
    private Map<String,Object> attributes;
    private List<TreeNode> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

}
