package net.braingang.bluetoothlab;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gsc on 3/29/15.
 */
public class DeviceListAdapter extends BaseAdapter {
    public static final String LOG_TAG = DeviceListAdapter.class.getName();

    private final LayoutInflater _inflater;
    private final ArrayList<BluetoothDevice> _deviceList;

    public DeviceListAdapter(LayoutInflater inflater) {
        super();
        _inflater = inflater;
        _deviceList = new ArrayList<BluetoothDevice>();
    }

    public void addDevice(BluetoothDevice device, int rssi) {
        if (_deviceList.contains(device)) {
            Log.i(LOG_TAG, "duplicate device:" + device.getName() + ":" + device.getAddress());
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
            view = _inflater.inflate(R.layout.row_device, null);

            viewHolder = new ViewHolder();
            viewHolder.deviceAddress = (TextView) view.findViewById(R.id.device_address);
            viewHolder.deviceName = (TextView) view.findViewById(R.id.device_name);
            viewHolder.signalStrength = (TextView) view.findViewById(R.id.signal_strength);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        BluetoothDevice device = _deviceList.get(ii);
        final String deviceName = device.getName();
        if (deviceName != null && !deviceName.isEmpty()) {
            viewHolder.deviceName.setText(deviceName);
        } else {
            viewHolder.deviceName.setText("Empty Name");
        }

        viewHolder.deviceAddress.setText(device.getAddress());
        viewHolder.signalStrength.setText(Integer.toString(123));

        return view;
    }

    static class ViewHolder {
        TextView deviceName;
        TextView deviceAddress;
        TextView signalStrength;
    }
}
