package com.example.monia.analizeraplikacji;

/**
 * Created by Monia on 16.05.2018.
 */

public class PermissionList {

    private String permission_name;

    public PermissionList(String permission_name){
        this.permission_name = permission_name;
    }
    public String get_permission(){
        return permission_name;

    }
}
