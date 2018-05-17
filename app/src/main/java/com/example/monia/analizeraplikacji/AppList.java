package com.example.monia.analizeraplikacji;
import android.graphics.drawable.Drawable;

public class AppList {

    private String name;
    private String name_pack;
    Drawable icon;

    public AppList(String name, Drawable icon,String name_pack) {
        this.name = name;
        this.icon = icon;
        this.name_pack = name_pack;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getName_pack() {
        return name_pack;
    }
}