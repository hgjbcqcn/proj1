package cn.cqabc.hugang.mylauncher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ResolveInfo> appsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        appsList = getAppsList();
        GridView gridView = (GridView)findViewById(R.id.apps_list);
        gridView.setAdapter(new AppsAdapter(appsList));
        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ResolveInfo info = appsList.get(position);
                String pkg = info.activityInfo.packageName;
                String cls = info.activityInfo.name;
                ComponentName cpt = new ComponentName(pkg, cls);
                Intent intent = new Intent();
                intent.setComponent(cpt);
                startActivity(intent);
            }
        };
        gridView.setOnItemClickListener(clickListener);
    }

    private List<ResolveInfo> getAppsList(){
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> apps = getPackageManager().queryIntentActivities(mainIntent, 0);
        return  apps;
    }
}
