package cn.edu.hqu.cst.android.chapter34;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SelectCityActivity extends ExpandableListActivity {

    private String[] provinces=new String[]{
            "广东","广西","福建","湖南"
    };
    private String[][] cities=new String[][]{
            {"广州","深圳","珠海","中山"},
            {"桂林","柳州","南宁"},
            {"厦门","福州","泉州"},
            {"长沙","岳阳","衡阳","株洲"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter=new BaseExpandableListAdapter(){

            @Override
            public int getGroupCount() {
                return provinces.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return cities[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return provinces[groupPosition];
            }

            @Override
            public Object getChild(int i, int i1) {
                return cities[i][i1];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            private TextView getTextView(){
                AbsListView.LayoutParams lp=new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView=new TextView(SelectCityActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                textView.setPadding(36,0,0,0);
                textView.setTextSize(20);
                return textView;
            }
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout l1=new LinearLayout(SelectCityActivity.this);
                l1.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo=new ImageView(SelectCityActivity.this);
                logo.setImageResource(android.R.drawable.ic_btn_speak_now);
                l1.addView(logo);
                TextView textView=getTextView();
                textView.setText(getGroup(groupPosition).toString());
                l1.addView(textView);
                return l1;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView=getTextView();
                textView.setText(getChild(groupPosition,childPosition).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }
        };
        setListAdapter(adapter);
        getExpandableListView().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPositon, int childPosition, long id) {
                Intent intent=getIntent();
                intent.putExtra("city",cities[groupPositon][childPosition]);
                SelectCityActivity.this.setResult(0,intent);
                SelectCityActivity.this.finish();
                return false;
            }
        });
    }
}
