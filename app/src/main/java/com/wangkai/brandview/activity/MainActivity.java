package com.wangkai.brandview.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.wangkai.brandview.R;
import com.wangkai.brandview.fragement.HomeFragment;
import com.wangkai.brandview.fragement.ResourceFragment;

import java.net.NoRouteToHostException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity{

    public static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager mFragmentManager;
    private Fragment mResourceFragment;
    private Fragment mHomeFragment;
    private TextView selecedBottom;
    private String currentTag;

    @Bind(R.id.main_bottom_home)
    TextView home_tv;

    @Bind(R.id.main_bottom_resource)
    TextView resource_tv;

    @Bind({R.id.main_bottom_home,R.id.main_bottom_resource})
    List<TextView> bottomTextList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFragmentManager = this.getFragmentManager();
        mFragmentManager.executePendingTransactions();

        String fragmentTag = HomeFragment.TAG;

        if(fragmentTag == null){
            clickTab(bottomTextList.get(0));
        }else{
            if (fragmentTag.equals(HomeFragment.TAG)) {
                clickTab(bottomTextList.get(0));
            }
            if (fragmentTag.equals(ResourceFragment.TAG)) {
                clickTab(bottomTextList.get(1));
            }
        }
    }


    @OnClick({R.id.main_bottom_home,R.id.main_bottom_resource})
    protected void clickTab(TextView view){


        if(selecedBottom != null){
            selecedBottom.setSelected(false);
        }
        selecedBottom = view;
        selecedBottom.setSelected(true);

        switch (view.getId()){
            case R.id.main_bottom_home:
                selectFragment(HomeFragment.TAG);
                break;
            case R.id.main_bottom_resource:
                selectFragment(ResourceFragment.TAG);
                break;
        }
    }

    private void selectFragment(String tag){
        if(tag == null){
            tag = HomeFragment.TAG;
        }
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        Fragment fragment = mFragmentManager.findFragmentByTag(tag);
        if(currentTag == null){
            if(fragment == null){
                if(HomeFragment.TAG.equals(tag)){
                    fragment = new HomeFragment();
                    transaction.add(R.id.main_content , fragment , HomeFragment.TAG);
                }
                if(ResourceFragment.TAG.equals(tag)){
                    fragment = new ResourceFragment();
                    transaction.add(R.id.main_content, fragment , ResourceFragment.TAG);
                }
            }else {
                transaction.show(fragment);

            }
        }else {
            if(tag.equals(currentTag)){
                return ;
            }else {
                Fragment currentFragment = mFragmentManager.findFragmentByTag(currentTag);
                if (currentFragment != null) {
                    transaction.hide(currentFragment);
                }
                if (fragment == null) {
                    if (HomeFragment.TAG.equals(tag)) {
                        fragment = new HomeFragment();
                        transaction.add(R.id.main_content, fragment, HomeFragment.TAG);
                    }
                    if (ResourceFragment.TAG.equals(tag)) {
                        fragment = new ResourceFragment();
                        transaction.add(R.id.main_content, fragment, ResourceFragment.TAG);
                    }
                } else {
                    transaction.show(fragment);
                }
            }
        }
        currentTag = tag;
        transaction.commit();
    }


}