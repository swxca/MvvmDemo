package zhangtao.com.MvvmDemo.EventListener;

import android.view.View;

/**
 * Created by zhangtao on 16/11/9.
 */

public interface CommentShareLikeListener {
    public void comment(View view);
    public void share(View view);
    public void like(View view);
}
