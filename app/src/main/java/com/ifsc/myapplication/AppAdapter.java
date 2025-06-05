package com.example.launcher;

import android.content.Intent;
import android.graphics.drawable.Drawable;

public class AppModel {
    private String label;
    private Drawable icon;
    private Intent launchIntent;

    public AppModel(String label, Drawable icon, Intent launchIntent) {
        this.label = label;
        this.icon = icon;
        this.launchIntent = launchIntent;
    }

    public String getLabel() { return label; }
    public Drawable getIcon() { return icon; }
    public Intent getLaunchIntent() { return launchIntent; }
}
