package zhangtao.com.MvvmDemo.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import zhangtao.com.MvvmDemo.R;
import zhangtao.com.MvvmDemo.entity.Status;
import zhangtao.com.MvvmDemo.fast.fastDevJson;
import zhangtao.com.MvvmDemo.utils.DividerItemDecoration;
import zhangtao.com.MvvmDemo.utils.RecyclerViewUtils;

/**
 * Created by zhangtao on 16/11/2.
 */

public class HomeActivity extends Activity {

    HomeAdapter adapter;
    RecyclerView recyclerView;
    List<Status> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        String response="{\n" +
                "        \"status\"          : 0,\n" +
                "        \"id\"              : 3095,\n" +
                "        \"content\"         : \"九张图测试\",\n" +
                "        \"resList\"         : [\n" +
                "          {\n" +
                "            \"id\"              : 1610,\n" +
                "            \"feedId\"          : 3095,\n" +
                "            \"createTime\"      : 1478487354000,\n" +
                "            \"resType\"         : 1,\n" +
                "            \"content\"         : \"http://oc3cqvvss.bkt.clouddn.com/10746ea6a707d2b1fdcfd2122316f5cf\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\"              : 1611,\n" +
                "            \"feedId\"          : 3095,\n" +
                "            \"createTime\"      : 1478487354000,\n" +
                "            \"resType\"         : 1,\n" +
                "            \"content\"         : \"http://oc3cqvvss.bkt.clouddn.com/c3c69f003a9c4c974a4f63754c0b9194\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\"              : 1612,\n" +
                "            \"feedId\"          : 3095,\n" +
                "            \"createTime\"      : 1478487354000,\n" +
                "            \"resType\"         : 1,\n" +
                "            \"content\"         : \"http://oc3cqvvss.bkt.clouddn.com/67d198871a638e5043b74871bd6bea94\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\"              : 1613,\n" +
                "            \"feedId\"          : 3095,\n" +
                "            \"createTime\"      : 1478487354000,\n" +
                "            \"resType\"         : 1,\n" +
                "            \"content\"         : \"http://oc3cqvvss.bkt.clouddn.com/a0b6c0f126e42c9bf4f6880c826fee7c\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\"              : 1614,\n" +
                "            \"feedId\"          : 3095,\n" +
                "            \"createTime\"      : 1478487354000,\n" +
                "            \"resType\"         : 1,\n" +
                "            \"content\"         : \"http://oc3cqvvss.bkt.clouddn.com/d51f3a14b9fe93e35385a9c2d2862f00\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\"              : 1615,\n" +
                "            \"feedId\"          : 3095,\n" +
                "            \"createTime\"      : 1478487354000,\n" +
                "            \"resType\"         : 1,\n" +
                "            \"content\"         : \"http://oc3cqvvss.bkt.clouddn.com/479bdbe2779495b904713882a88b703f\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\"              : 1616,\n" +
                "            \"feedId\"          : 3095,\n" +
                "            \"createTime\"      : 1478487354000,\n" +
                "            \"resType\"         : 1,\n" +
                "            \"content\"         : \"http://oc3cqvvss.bkt.clouddn.com/3315e34463e1c8a7324bb5b20b9e7d19\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\"              : 1617,\n" +
                "            \"feedId\"          : 3095,\n" +
                "            \"createTime\"      : 1478487354000,\n" +
                "            \"resType\"         : 1,\n" +
                "            \"content\"         : \"http://oc3cqvvss.bkt.clouddn.com/b6c9804d0913ea7420defe6e1d5bd888\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\"              : 1618,\n" +
                "            \"feedId\"          : 3095,\n" +
                "            \"createTime\"      : 1478487354000,\n" +
                "            \"resType\"         : 1,\n" +
                "            \"content\"         : \"http://oc3cqvvss.bkt.clouddn.com/e66c884d109531284d0a6fff1d828093\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"userId\"          : 360,\n" +
                "        \"createTime\"      : 1478487354000,\n" +
                "        \"userCategory\"    : 3,\n" +
                "        \"feedType\"        : 11,\n" +
                "        \"commentCount\"    : 0,\n" +
                "        \"likeCount\"       : 1,\n" +
                "        \"opState\"         : 3,\n" +
                "        \"pubTimeNice\"     : \"4 小时前\",\n" +
                "        \"pubTimeStamp\"    : 1478487354000,\n" +
                "        \"feedCategory\"    : 0,\n" +
                "        \"likeState\"       : 0,\n" +
                "        \"privateType\"     : 0,\n" +
                "        \"userLogo\"        : \"http://wx.qlogo.cn/mmopen/jJtbwFuzNwCY10TAFd9uXIoBrJr51iaCwULwkXvCSOMbk9qOrk8HSbPBumKIS6JCDgEf1zYb6qOdyEHPOibUNkl1tqXKRibMnDJ/0\",\n" +
                "        \"userName\"        : \"阿兔\",\n" +
                "        \"isReported\"      : false,\n" +
                "        \"acct\"            : null,\n" +
                "        \"userTag\"         : null,\n" +
                "        \"comments\"        : [ ],\n" +
                "        \"favoriteState\"   : 0,\n" +
                "        \"followerCount\"   : 0,\n" +
                "        \"shareUrl\"        : \"http://114.215.78.104/static/share/index.html?feedId=3095&feedCategory=0\",\n" +
                "        \"userCityCode\"    : null,\n" +
                "        \"favoiteState\"    : 0\n" +
                "      }";

        Status status= fastDevJson.UnmarshalFromString(response,Status.class);
        list.add(status);
        list.add(status);
        list.add(status);
        Log.e("sdsajhdksa",fastDevJson.MarshalToString(list));
        adapter.appendItems(list);
    }

    private void initView() {
        adapter=new HomeAdapter(this);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerViewUtils.setLinearManagerAndAdapter(recyclerView,adapter);
        recyclerView.addItemDecoration(DividerItemDecoration.newVertical(this,
                R.dimen.list_divider_height, R.color.line_color));
    }
}
