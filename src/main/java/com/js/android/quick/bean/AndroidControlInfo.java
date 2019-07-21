package com.js.android.quick.bean;

public class AndroidControlInfo {

    String className;
    //id最好和instanceName一样，这样少写不少代码
    String instanceName;
    String id;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
