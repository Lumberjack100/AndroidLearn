package com.dragon.androidlearn.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import com.dragon.androidlearn.R;
import com.kyleduo.switchbutton.SwitchButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class DASHomeFragment extends BaseFragment
{
    @BindView(R.id.bluetooth_connect_layout)
    View bluetoothConnectLayout;

    @BindView(R.id.device_enable_state_layout)
    View deviceEnableLayout;


    private TextView mTvBluetoothConnect, mTvDeviceActivation, mTvBreakAlarm;

    private SwitchButton mSbBluetoothConnect, mSbDeviceActivation, mSbBleakAlarm;

    public DASHomeFragment()
    {
        // Required empty public constructor
    }

    @Override
    protected int initContentView()
    {
        return R.layout.fragment_d_a_s_home;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return view;
    }

    private void initView() {
        ((TextView) bluetoothConnectLayout.findViewById(R.id.tv_config_name)).setText("蓝牙连接");
        mTvBluetoothConnect = bluetoothConnectLayout.findViewById(R.id.tv_device_state);
        mSbBluetoothConnect = bluetoothConnectLayout.findViewById(R.id.switchButton);

        ((TextView) deviceEnableLayout.findViewById(R.id.tv_config_name)).setText("设备启用状态");
        mTvDeviceActivation = deviceEnableLayout.findViewById(R.id.tv_device_state);
        mSbDeviceActivation = deviceEnableLayout.findViewById(R.id.switchButton);

    }
}
