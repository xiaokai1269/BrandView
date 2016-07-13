package com.wangkai.brandview.fragement;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wangkai.brandview.R;
import com.wangkai.brandview.adapter.BrandAdapter;
import com.wangkai.brandview.entity.Brand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangkai on 16/7/13.
 */
public class ResourceFragment extends Fragment{

    public static final String TAG = ResourceFragment.class.getSimpleName();

    private View ResourceView;
    private ListView mBrandListView;
    private BrandAdapter mAdapter;
    private List<Brand> mBrands;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ResourceView = inflater.inflate(R.layout.fragment_main_resourece,container,false);
        mBrandListView = (ListView) ResourceView.findViewById(R.id.resource_brand_listview);
        initData();
        mAdapter = new BrandAdapter(getActivity() , mBrands);
        mBrandListView.setAdapter(mAdapter);
        return ResourceView;
    }

    public void initData(){
        mBrands = new ArrayList<Brand>();
        for(int i=0; i < 20 ;i++){
            Brand item = new Brand(R.mipmap.ic_launcher , "宾利");
            mBrands.add(item);
        }
    }
}
