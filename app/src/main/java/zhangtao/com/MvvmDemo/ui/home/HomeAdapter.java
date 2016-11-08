package zhangtao.com.MvvmDemo.ui.home;

import android.content.Context;
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
import zhangtao.com.MvvmDemo.R;
import zhangtao.com.MvvmDemo.databinding.ItemUserfeedLayoutBinding;
import zhangtao.com.MvvmDemo.entity.FeedResource;
import zhangtao.com.MvvmDemo.entity.Status;
import zhangtao.com.MvvmDemo.utils.BaseAdapter;
import zhangtao.com.MvvmDemo.widget.CircleImageView;

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
        ItemUserfeedLayoutBinding binding= DataBindingUtil.inflate(inflater, R.layout.item_userfeed_layout,parent,false);
        StatusViewHolder statusViewHolder=new StatusViewHolder(binding.getRoot());
        statusViewHolder.setBinding(binding);
        return statusViewHolder;
    }

    @Override
    public void onMyBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        StatusViewHolder statusViewHolder= (StatusViewHolder) viewHolder;
        Status status = bindData(position, statusViewHolder);
        loadLogoAndNineImages(statusViewHolder, status);
    }

    private Status bindData(int position, StatusViewHolder statusViewHolder) {
        Status status = getModel(position);
        statusViewHolder.getBinding().setVariable(BR.Status,status);
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
        ImageLoader.getInstance().displayImage(status.getUserLogo(),statusViewHolder.headImg);
    }

    @Override
    public int getMyItemViewType(int position) {
        return 0;
    }
    public class StatusViewHolder extends RecyclerView.ViewHolder {
        CircleImageView headImg;
        ItemUserfeedLayoutBinding binding;

        public void setBinding(ItemUserfeedLayoutBinding binding) {
            this.binding = binding;
        }

        public ItemUserfeedLayoutBinding getBinding() {
            return binding;
        }

        public StatusViewHolder(View itemView) {
            super(itemView);
            headImg= (CircleImageView) itemView.findViewById(R.id.item_mainpage_headImg);
        }
    }
}
