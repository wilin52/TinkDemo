package com.wilin.tinkdemo.main.cityGuide.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wilin.tinkdemo.R;
import com.wilin.tinkdemo.main.cityGuide.CityGuideType;
import com.wilin.tinkdemo.main.cityGuide.mode.CityGuideBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin WenLong on 2018/6/2.
 * <p>
 * display the city guide.
 */
class CityGuideAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CityGuideBean> cityGuideBeanList;
    private CityGuideFragment fragment;

    CityGuideAdapter(CityGuideFragment fragment) {
        this.fragment = fragment;
    }

    void setCityGuideBeanList(List<CityGuideBean> cityGuideBeanList) {
        this.cityGuideBeanList = cityGuideBeanList;
        notifyDataSetChanged();
    }

    void addCityGuideBeanList(List<CityGuideBean> list){
        if(null == cityGuideBeanList){
            cityGuideBeanList = new ArrayList<>();
        }
        this.cityGuideBeanList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == CityGuideType.IMAGE) {
            view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_city_guide_image, parent, false);
            return new CityImageViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_city_guide_description, parent, false);
            return new CityDescriptionViewHolder(view);
        }

    }

    @Override
    public int getItemCount() {
        return null == cityGuideBeanList ? 0 : cityGuideBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return cityGuideBeanList.get(position).getGuideType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CityGuideBean bean = cityGuideBeanList.get(position);

        if (holder instanceof CityImageViewHolder) {

            Glide.with(fragment).load(bean.getImageUrl()).skipMemoryCache(false).into(((CityImageViewHolder) holder).imageView);
        } else if (holder instanceof CityDescriptionViewHolder) {

            CityDescriptionViewHolder viewHolder = (CityDescriptionViewHolder) holder;
            Glide.with(fragment).load(bean.getImageUrl()).skipMemoryCache(false).into(viewHolder.imageView);
            viewHolder.titleTv.setText(bean.getDescriptionTitle());
            viewHolder.detailTv.setText(bean.getDescriptionDetail());
        }
    }

    private static class CityImageViewHolder extends RecyclerView.ViewHolder {
        /**
         * 大图显示, display with big image
         */
        ImageView imageView;

        CityImageViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.city_guide_full_image);
        }
    }

    private static class CityDescriptionViewHolder extends RecyclerView.ViewHolder {
        /**
         * display with small image
         * 预览图
         */
        ImageView imageView;
        /**
         * title of description.
         * 简介标题.
         */
        TextView titleTv;
        /**
         * detail of description.
         * 简介详细内容
         */
        TextView detailTv;

        CityDescriptionViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.city_guide_small_image);
            titleTv = view.findViewById(R.id.city_guide_title_tv);
            detailTv = view.findViewById(R.id.city_guide_detail_tv);
        }
    }
}
