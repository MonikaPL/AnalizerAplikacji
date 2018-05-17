package com.example.monia.analizeraplikacji;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Monia on 14.05.2018.
 */

public class OneAndroidPermission extends AppCompatActivity {

    //public List<PermissionList> installedApps;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        Intent intent = getIntent();
        String easyPuzzle = intent.getExtras().getString("epuzzle");

        Toast.makeText(getApplicationContext(),
                easyPuzzle, Toast.LENGTH_LONG)
                .show();

        PackageManager pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        final ListView userInstalledApps = (ListView)findViewById(R.id.list_permission);


       // AppAdapter installedAppAdapter = new AppAdapter(OneAndroidPermission.this, installedApps);
       // userInstalledApps.setAdapter(installedAppAdapter);

            try {
                List<PermissionList> res = new ArrayList<PermissionList>();


                PackageInfo packageInfo = pm.getPackageInfo(easyPuzzle, PackageManager.GET_PERMISSIONS);

                //Get Permissions
                String[] requestedPermissions = packageInfo.requestedPermissions;

                if(requestedPermissions != null) {

                    for (int i = 0; i < requestedPermissions.length; i++) {

                        res.add(new PermissionList(requestedPermissions[i]));



                    }
                }
                PermissionAdapter installedAppAdapter = new PermissionAdapter(OneAndroidPermission.this, res);
                userInstalledApps.setAdapter(installedAppAdapter);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }




    }
}
