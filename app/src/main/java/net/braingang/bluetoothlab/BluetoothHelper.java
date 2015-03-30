package net.braingang.bluetoothlab;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;

import java.util.List;

/**
 * Created by gsc on 3/26/15.
 */
public class BluetoothHelper {
    BluetoothAdapter _adapter;

    /*
    ScanCallback _scanCallback = new ScanCallback() {
        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            super.onBatchScanResults(results);
            System.out.println("scan results:" + results.size());
        }
    };
    */

    public BluetoothAdapter setUp(Context context) {
        BluetoothManager manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter adapter = manager.getAdapter();

        _adapter = manager.getAdapter();

        System.out.println(manager);
        System.out.println(_adapter);
        System.out.println(_adapter.isEnabled());

        return _adapter;
    }

    public void scanner(Context context) {
        BluetoothLeScanner scan = _adapter.getBluetoothLeScanner();
        System.out.println(scan);
 //       scan.startScan(_scanCallback);

        /*
        if (enable) {
            // Stops scanning after a pre-defined scan period.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mScanning = false;
                    mBluetoothAdapter.stopLeScan(mLeScanCallback);
                }
            }, SCAN_PERIOD);

            mScanning = true;
            mBluetoothAdapter.startLeScan(mLeScanCallback);
        } else {
            mScanning = false;
            mBluetoothAdapter.stopLeScan(mLeScanCallback);
        }
        ...
        */
    }
}
