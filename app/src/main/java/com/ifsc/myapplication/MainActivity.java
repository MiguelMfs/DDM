package com.example.launcher;

import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView appGrid;
    private EditText searchBox;
    private List<AppModel> allApps;
    private AppAdapter adapter;
    private LinearLayout dockLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appGrid = findViewById(R.id.app_grid);
        searchBox = findViewById(R.id.searchBox);
        dockLayout = findViewById(R.id.dock_layout);

        loadApps("");
        setupSearch();
        setupDock();
        setupBackground();
    }

    private void loadApps(String query) {
        allApps = new ArrayList<>();
        PackageManager pm = getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> apps = pm.queryIntentActivities(mainIntent, 0);

        for (ResolveInfo info : apps) {
            String label = info.loadLabel(pm).toString();
            if (label.toLowerCase().contains(query.toLowerCase())) {
                Drawable icon = info.loadIcon(pm);
                Intent launchIntent = new Intent();
                launchIntent.setComponent(
                        new android.content.ComponentName(
                                info.activityInfo.packageName,
                                info.activityInfo.name
                        )
                );
                allApps.add(new AppModel(label, icon, launchIntent));
            }
        }

        adapter = new AppAdapter(this, allApps);
        appGrid.setAdapter(adapter);
    }

    private void setupSearch() {
        searchBox.addTextChangedListener(new android.text.TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                loadApps(s.toString());
            }
            @Override public void afterTextChanged(android.text.Editable s) {}
        });
    }

    private void setupDock() {
        // Adiciona os 4 primeiros apps à dock
        for (int i = 0; i < Math.min(4, allApps.size()); i++) {
            ImageView icon = new ImageView(this);
            AppModel app = allApps.get(i);
            icon.setImageDrawable(app.getIcon());
            icon.setPadding(16, 16, 16, 16);
            icon.setOnClickListener(v -> startActivity(app.getLaunchIntent()));
            dockLayout.addView(icon);
        }
    }

    private void setupBackground() {
        findViewById(R.id.main_layout).setBackgroundColor(Color.parseColor("#303F9F")); // azul escuro, por exemplo
    }


}
