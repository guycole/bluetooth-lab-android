package net.braingang.bluetoothlab;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by gsc on 3/29/15.
 */
public class DeviceListAdapter extends BaseAdapter {
    private ArrayList<BluetoothDevice> _deviceList;
    private LayoutInflater _inflator;

    public DeviceListAdapter() {
        super();
        _deviceList = new ArrayList<BluetoothDevice>();
        _inflator = MainActivity.this.getLayoutInflater();
    }

    public void addDevice(BluetoothDevice device) {
        if (_deviceList.contains(device)) {

        } else {
            _deviceList.add(device);
        }
    }

    public BluetoothDevice getDevice(int position) {
        return _deviceList.get(position);
    }

    public void clear() {
        _deviceList.clear();
    }

    @Override
    public int getCount() {
        return _deviceList.size();
    }

    @Override
    public Object getItem(int ii) {
        return _deviceList.get(ii);
    }

    @Override
    public long getItemId(int ii) {
        return ii;
    }

    @Override
    public View getView(int ii, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = _inflator.inflate()
        }
    }
}
