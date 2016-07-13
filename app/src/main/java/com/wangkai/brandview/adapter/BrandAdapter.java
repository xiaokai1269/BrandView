package com.wangkai.brandview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangkai.brandview.R;
import com.wangkai.brandview.entity.Brand;

import java.util.List;

/**
 * Created by wangkai on 16/7/13.
 */
public class BrandAdapter extends BaseAdapter{

    private List<Brand> mBrands;
    private Context mContext;
    private LayoutInflater mInflater;

    public BrandAdapter(Context context, List<Brand> data){
        this.mContext = context;
        this.mBrands = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mBrands.size();
    }

    @Override
    public Object getItem(int position) {
        return mBrands.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null ;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.brand_listview_item, null);
            holder.brandImg = (ImageView) convertView.findViewById(R.id.brand_iv);
            holder.brandName = (TextView) convertView.findViewById(R.id.brand_tv);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.brandImg.setImageResource(mBrands.get(position).getImgUrl());
        holder.brandName.setText(mBrands.get(position).getBrandName());
        return convertView;
    }

    static class ViewHolder{
        ImageView brandImg;
        TextView brandName;
    }
}
