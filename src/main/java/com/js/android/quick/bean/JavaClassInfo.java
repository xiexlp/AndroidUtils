package com.js.android.quick.bean;

public class JavaClassInfo {

    //NameActivity
    String fullName;
    //com.js.android
    String packageName;
    //activity_name
    String noSuffixXmlName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getNoSuffixXmlName() {
        return noSuffixXmlName;
    }

    public void setNoSuffixXmlName(String noSuffixXmlName) {
        this.noSuffixXmlName = noSuffixXmlName;
    }
}
