package com.mtelnet.myview.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.mtelnet.myview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongzhenyue on 17/2/16.
 */

public class BannerPageAdapter extends PagerAdapter {

    private Context mContext;
    List<String> mList=new ArrayList<>();

    public List<String> getList() {
        return mList;
    }

    public void setList(List<String> list) {
        if (null!=list&&list.size()>0){
            mList.clear();
            mList.addAll(list);
        }
    }

    public BannerPageAdapter(Context context) {
        this.mContext=context;
    }



    @Override
    public int getCount() {
        return mList.size()>0?mList.size()>1?Integer.MAX_VALUE:mList.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
//        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView img=new ImageView(container.getContext());
        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        img.setLayoutParams(params);
        img.setImageResource(R.drawable.bg_header);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(img);

        if ( mList.size() > 1){
            showImage(img,mList.get(position % mList.size()));
            setListener(img,position % mList.size());
        } else {
            showImage(img,mList.get(position));
            setListener(img,position);
        }

        return img;
//        return super.instantiateItem(container, position);
    }

    private void setListener(ImageView img, final int  position) {

         if (mListener != null){
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(position);
                }
            });
        }
    }

    private void showImage(ImageView img, String url) {
        BitmapImageViewTarget scaleType=null;
        scaleType=new BitmapImageViewTarget(img);
        Glide.with(mContext)
                .load(url)
                .asBitmap()
                .fitCenter()
                .placeholder(R.drawable.bg_header)
//                .into(scaleType);
                .into(img);
    }

    private OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
