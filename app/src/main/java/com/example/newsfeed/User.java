package com.example.newsfeed;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;

public class User {
    private Context mycontext;
    private String name;
    private String password;
    private String photo; //头像
    private String id;
    private Boolean logined; //是否已登录
    private String groups2;

    public User(Context context) {
        this.mycontext = context;
        this.name = getName();
        this.password = getPassword();
        this.photo = getPhoto();
        this.id = getId();
        this.logined = getLogined();
    }

    public String getName() {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        String result = sp.getString("name", "");
        return result;
    }

    public String getPassword() {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        String result = sp.getString("password", "");
        return result;
    }

    public String getId() {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        String result = sp.getString("id", "");
        return result;
    }

    public String getPhoto() {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        String result = sp.getString("photo", "");
        return result;
    }

    public Boolean getLogined() {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        String result = sp.getString("logined", "");
        return Boolean.parseBoolean(result);
    }

    public String[] getGroups2() {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        String result = sp.getString("groups2", "");
        Log.d(TAG, "getGroups2: groups1: " + result);
        String[] groups = result.split("\\$\\$");
        if (groups[0].length() > 0) {
            Log.d(TAG, "getGroups2: groups2: " + groups);
            groups[0] = groups[0].substring(1);
            groups[groups.length - 1] = groups[groups.length - 1].substring(0, groups[groups.length - 1].length() - 1);
            Log.d(TAG, "getGroups2: groups2: " + groups);
            return groups;
        } else {
            return new String[]{};
        }
    }

    public void setName(String name) {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name","");    // 先清空原始数据
        editor.putString("name",name);
        editor.commit();
    }

    public void setPassword(String password) {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("password","");    // 先清空原始数据
        editor.putString("password",password);
        editor.commit();
    }

    public void setPhoto(String photo) {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("photo","");    // 先清空原始数据
        editor.putString("photo",photo);
        editor.commit();
    }

    public void setId(String id) {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("id","");    // 先清空原始数据
        editor.putString("id",id);
        editor.commit();
    }

    public void setLogined(Boolean logined) {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("logined","");    // 先清空原始数据
        editor.putString("logined",logined.toString());
        editor.commit();
    }

    public void setGroups2(String groups2) {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("groups2","");    // 先清空原始数据
        editor.putString("groups2",groups2.toString());
        editor.commit();
    }

    public void addGroups2(String new_group) {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        String pre_groups = sp.getString("groups2", "");
        String new_groups = pre_groups + "$" + new_group + "$";
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("groups2","");    // 先清空原始数据
        editor.putString("groups2",new_groups.toString());
        editor.commit();
    }

    public void editGroups2(String pre_group, String new_group) {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        String pre_groups = sp.getString("groups2", "");
        String new_groups = pre_groups.replace("$" + pre_group + "$", "$" + new_group +"$");
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("groups2","");    // 先清空原始数据
        editor.putString("groups2",new_groups.toString());
        editor.commit();
    }

    public void deleteGroups2(String pre_group) {
        SharedPreferences sp = mycontext.getSharedPreferences("UserInfo", MODE_PRIVATE);
        String pre_groups = sp.getString("groups2", "");
        String new_groups = pre_groups.replace("$" + pre_group + "$", "");
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("groups2","");    // 先清空原始数据
        editor.putString("groups2",new_groups.toString());
        editor.commit();
    }
}
