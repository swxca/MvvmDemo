package zhangtao.com.MvvmDemo.ui.home;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import zhangtao.com.MvvmDemo.BR;
import zhangtao.com.MvvmDemo.EventListener.CommentShareLikeListener;
import zhangtao.com.MvvmDemo.EventListener.FeedHeadImgListener;
import zhangtao.com.MvvmDemo.MainActivity;
import zhangtao.com.MvvmDemo.R;
import zhangtao.com.MvvmDemo.databinding.ItemUserfeedLayoutBinding;
import zhangtao.com.MvvmDemo.entity.FeedResource;
import zhangtao.com.MvvmDemo.entity.Status;
import zhangtao.com.MvvmDemo.utils.BaseAdapter;


/**
 * Created by zhangtao on 16/11/2.
 */

public class HomeAdapter extends BaseAdapter<Status> {
    ArrayList<ImageInfo> imageInfo;
    List<FeedResource> images;


    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onMyCreateViewHolder(ViewGroup parent, int viewType) {
        if (list==null){
            return getUnKnowViewHolder(parent);
        }else {
            ItemUserfeedLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_userfeed_layout, parent, false);
            StatusViewHolder statusViewHolder = new StatusViewHolder(binding.getRoot());
            statusViewHolder.setBinding(binding);
            return statusViewHolder;
        }
    }

    @Override
    public void onMyBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        StatusViewHolder statusViewHolder = (StatusViewHolder) viewHolder;
        Status status = bindData(position, statusViewHolder);
        loadLogoAndNineImages(statusViewHolder, status);
        initEvent(statusViewHolder);
        stateImg(statusViewHolder, status);
    }

    private void stateImg(StatusViewHolder statusViewHolder, Status status) {
        switch (status.getFeedCategory()){
            case 0 | 1:
                if (status.getOpState() == 2) {
                    statusViewHolder.binding.contentLayout.stateIm.setImageResource(R.mipmap.zhiding);
                } else if (status.getOpState() == 3) {
                    statusViewHolder.binding.contentLayout.stateIm.setImageResource(R.mipmap.tuijian_tag);
                }else {
                    statusViewHolder.binding.contentLayout.stateIm.setVisibility(View.GONE);
                }
                break;
            case 2:
                statusViewHolder.binding.contentLayout.stateIm.setImageResource(R.mipmap.huodong_tag);
                break;
            case 3:
                statusViewHolder.binding.contentLayout.stateIm.setImageResource(R.mipmap.huati_tag);
                break;
            case 4:
                statusViewHolder.binding.contentLayout.stateIm.setImageResource(R.mipmap.tuiguang_tag);
                break;
            default:
                statusViewHolder.binding.contentLayout.stateIm.setVisibility(View.GONE);
                break;
        }
    }

    private void initEvent(StatusViewHolder statusViewHolder) {
        statusViewHolder.binding.userInfoLayout.setEvent(new FeedHeadImgListener() {
            @Override
            public void headImgClick(View view) {
                mContext.startActivity(new Intent(mContext, MainActivity.class));
            }
        });
        statusViewHolder.binding.commentLikeShareLayout.setEvent(new CommentShareLikeListener() {
            @Override
            public void comment(View view) {
                mContext.startActivity(new Intent(mContext, MainActivity.class));

            }

            @Override
            public void share(View view) {
                mContext.startActivity(new Intent(mContext, MainActivity.class));

            }

            @Override
            public void like(View view) {
                mContext.startActivity(new Intent(mContext, MainActivity.class));

            }
        });
    }

    private Status bindData(int position, StatusViewHolder statusViewHolder) {
        Status status = getModel(position);
        statusViewHolder.getBinding().setVariable(BR.Status, status);
        statusViewHolder.getBinding().executePendingBindings();
        return status;
    }

    private void loadLogoAndNineImages(StatusViewHolder statusViewHolder, Status status) {
        imageInfo = new ArrayList<>();
        images = status.getResList();
        if (images != null) {
            for (FeedResource image : images) {
                ImageInfo info = new ImageInfo();
                info.setThumbnailUrl(image.getContent());
                info.setBigImageUrl(image.getContent());
                imageInfo.add(info);
            }
        }
        statusViewHolder.binding.nineGrid.setAdapter(new NineGridViewClickAdapter(mContext, imageInfo));

        if (images != null && images.size() == 1) {
            statusViewHolder.binding.nineGrid.setSingleImageRatio(1);
        }
        ImageLoader.getInstance().displayImage(status.getUserLogo()+"?imageMogr2/thumbnail/300x300", statusViewHolder.binding.userInfoLayout.itemMainpageHeadImg);

    }

    @Override
    public int getMyItemViewType(int position) {
       return 0;
    }

    public class StatusViewHolder extends RecyclerView.ViewHolder {
        ItemUserfeedLayoutBinding binding;

        public void setBinding(ItemUserfeedLayoutBinding binding) {
            this.binding = binding;
        }

        public ItemUserfeedLayoutBinding getBinding() {
            return binding;
        }

        public StatusViewHolder(View itemView) {
            super(itemView);
        }
    }
}
