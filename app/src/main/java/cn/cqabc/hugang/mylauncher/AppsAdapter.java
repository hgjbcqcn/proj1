package cn.cqabc.hugang.mylauncher;

import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppsAdapter extends BaseAdapter {

    private List<ResolveInfo> appsList;

    public AppsAdapter(List<ResolveInfo> appsList){
        this.appsList = appsList;
    }

    @Override
    public int getCount() {
        return appsList.size();
    }

    @Override
    public Object getItem(int position) {
        return appsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv;
        TextView tv;
        if (null == convertView) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        }
        iv = (ImageView) convertView.findViewById(R.id.image_item);
        tv = (TextView) convertView.findViewById(R.id.text_item);
        iv.setImageDrawable(appsList.get(position).activityInfo.loadIcon(parent.getContext().getPackageManager()));
        tv.setText(appsList.get(position).loadLabel(parent.getContext().getPackageManager()));
        return convertView;
    }
}
