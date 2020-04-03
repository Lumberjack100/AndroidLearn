package com.dragon.androidlearn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dragon.androidlearn.fragment.AdvanceSetFragment;
import com.dragon.androidlearn.fragment.DASHomeFragment;
import com.dragon.androidlearn.fragment.DeviceDetailsFragment;
import com.dragon.androidlearn.fragment.QueryDeviceDataFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView mToolbarTitle;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    private DASHomeFragment DASHomeFragment;
    private QueryDeviceDataFragment queryDataFragment;        //查询数据
    private DeviceDetailsFragment deviceDetailsFragment;//设备详情
    private AdvanceSetFragment advanceSetFragment;      //高级设置
    private Fragment currentFragment;

    private boolean isFirstCall = true;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity context = MainActivity.this;
        int code = this.hashCode();

        initView(savedInstanceState);
    }

    private void initView(Bundle savedInstanceState) {
        if (savedInstanceState != null) {  // “内存重启”时调用
            String curTag = savedInstanceState.getString("CurrentFragment");
            currentFragment = getSupportFragmentManager().findFragmentByTag(curTag);
//            DASHomeFragment = (DASHomeFragment) getSupportFragmentManager().findFragmentByTag(DASHomeFragment.class.getName());
//            queryDataFragment = (QueryDeviceDataFragment) getSupportFragmentManager().findFragmentByTag(QueryDeviceDataFragment.class.getName());
//            deviceDetailsFragment = (DeviceDetailsFragment) getSupportFragmentManager().findFragmentByTag(DeviceDetailsFragment.class.getName());
//            advanceSetFragment = (AdvanceSetFragment) getSupportFragmentManager().findFragmentByTag(AdvanceSetFragment.class.getName());
//
//            if (DASHomeFragment == null)
//                DASHomeFragment = new DASHomeFragment();
//
//            if (queryDataFragment == null)
//                queryDataFragment = new QueryDeviceDataFragment();
//
//            if (deviceDetailsFragment == null)
//                deviceDetailsFragment = new DeviceDetailsFragment();
//
//            if (advanceSetFragment == null)
//                advanceSetFragment = new AdvanceSetFragment();
//
//            // 解决重叠问题
//            getSupportFragmentManager().beginTransaction()
//                    .hide(DASHomeFragment)
//                    .hide(queryDataFragment)
//                    .hide(deviceDetailsFragment)
//                    .hide(advanceSetFragment)
//                    .show(currentFragment)
//                    .commit();
        } else {
//            DASHomeFragment = new DASHomeFragment();
//            queryDataFragment = new QueryDeviceDataFragment();
//            deviceDetailsFragment = new DeviceDetailsFragment();
//            advanceSetFragment = new AdvanceSetFragment();

            switchFrgment(0);
        }

        initBottomNavigationItemSelectedListener();
    }


    private void initBottomNavigationItemSelectedListener() {
        //为底部导航设置条目选中监听
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_parameter:
                        mToolbarTitle.setText("参数设置");
                        switchFrgment(0);
                        break;
                    case R.id.item_query_data:
                        mToolbarTitle.setText("查询数据");
                        switchFrgment(1);
                        break;
                    case R.id.item_device_details:
                        mToolbarTitle.setText("设备详情");
                        switchFrgment(2);
                        break;
                    case R.id.item_highsetting:
                        mToolbarTitle.setText("高级配置");
                        switchFrgment(3);
                        break;
                }

                return true;    //这里返回true，表示事件已经被处理。如果返回false，为了达到条目选中效果，还需要下面的代码
                // item.setChecked(true);  不论点击了哪一个，都手动设置为选中状态true（该控件并没有默认实现)
                // 。如果不设置，只有第一个menu展示的时候是选中状态，其他的即便被点击选中了，图标和文字也不会做任何更改
            }
        });
    }

    /**
     * switch the fragment accordting to id
     */
    private void switchFrgment(int i) {
        switch (i) {
            case 0:
                if(DASHomeFragment==null)
                    DASHomeFragment=new DASHomeFragment();
//                showFragment(DASHomeFragment);
                switchFragment(DASHomeFragment);
                break;
            case 1:
                if(queryDataFragment==null)
                    queryDataFragment=new QueryDeviceDataFragment();
//                showFragment(queryDataFragment);
                switchFragment(queryDataFragment);

//                getSupportFragmentManager().beginTransaction()
//                        .remove( DASHomeFragment)
//                        .commit();
//
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.content_frame, queryDataFragment, queryDataFragment.getClass().getName()) // 替换Fragment，实现切换
//                        .addToBackStack(null)
//                        .commit();
                break;
            case 2:
                if(deviceDetailsFragment==null)
                    deviceDetailsFragment=new DeviceDetailsFragment();
//                showFragment(deviceDetailsFragment);
                switchFragment(deviceDetailsFragment);
                break;
            case 3:
                if(advanceSetFragment==null)
                    advanceSetFragment=new AdvanceSetFragment();
//                showFragment(advanceSetFragment);
                switchFragment(advanceSetFragment);
                break;
        }
    }

    private void showFragment(Fragment fragment) {
        if (currentFragment != fragment) {//  判断传入的fragment是不是当前的currentFragmentgit
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!fragment.isAdded()) { //  判断传入的fragment是否已经被add()过
                transaction.add(R.id.content_frame, fragment, fragment.getClass().getName());
                if (currentFragment != null) {
                    transaction.hide(currentFragment);
                }
            } else {
                transaction.hide(currentFragment).show(fragment);
            }

            currentFragment = fragment;  //  然后将传入的fragment赋值给currentFragment
            transaction.commit();
        }
    }

    public void switchFragment(Fragment fragment) {
        if(currentFragment != fragment) {
            currentFragment = fragment;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment, fragment.getClass().getName()) // 替换Fragment，实现切换
//                    .addToBackStack(null)
                    .commit();

        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Activity context = MainActivity.this;
        int code = this.hashCode();
        outState.putString("CurrentFragment", currentFragment.getClass().getName());
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (isFirstCall) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFirstCall = false;
    }

}
