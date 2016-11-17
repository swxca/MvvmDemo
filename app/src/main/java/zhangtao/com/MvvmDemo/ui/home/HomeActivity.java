package zhangtao.com.MvvmDemo.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
import zhangtao.com.MvvmDemo.R;
import zhangtao.com.MvvmDemo.entity.KKKK;
import zhangtao.com.MvvmDemo.entity.Status;
import zhangtao.com.MvvmDemo.fast.fastDevJson;
import zhangtao.com.MvvmDemo.utils.DividerItemDecoration;
import zhangtao.com.MvvmDemo.utils.RecyclerViewUtils;
import zhangtao.com.MvvmDemo.utils.md5Sig;

/**
 * Created by zhangtao on 16/11/2.
 */

public class HomeActivity extends Activity  {

    HomeAdapter adapter;
    RecyclerView recyclerView;
    List<Status> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        OkGo.get("http://115.29.97.161/api/feed/home")
                .params("pageNo", "1")
                .params("pageSize", "20")
                .tag(this)
                .cacheKey("HomeFeedList")
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        list = fastDevJson.UnmarshalFromString(s, KKKK.class).getData().getList();
                        if (list != null) {
                            adapter.appendItems(list);
                        }
                        Log.e("daskdnakndad",fastDevJson.MarshalToString(list));
                    }

                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        try {
                            request.params("sig", md5Sig.getSignature(request.getParams().urlParamsMap, "b41ab2af0fb6368495662dfeda2c68d2"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                });
    }

    private void initView() {
        adapter = new HomeAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerViewUtils.setLinearManagerAndAdapter(recyclerView, adapter);
        recyclerView.addItemDecoration(DividerItemDecoration.newVertical(this,
                R.dimen.list_divider_height, R.color.line_color));
    }
}
