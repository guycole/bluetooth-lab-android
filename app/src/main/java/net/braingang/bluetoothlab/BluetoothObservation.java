package net.braingang.bluetoothlab;

import android.bluetooth.BluetoothDevice;
import android.text.format.Time;

import java.util.Comparator;

/**
 * Created by gsc on 3/31/15.
 */
public class BluetoothObservation {
    private Time timeStamp;
    private BluetoothDevice bluetoothDevice;
    private int signalStrength;

    public BluetoothObservation() {
        timeStamp = new Time();
        timeStamp.setToNow();
    }

    public Time getTimeStamp() {
        return timeStamp;
    }

    public BluetoothDevice getBluetoothDevice() {
        return bluetoothDevice;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
    }

    public Integer getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(int signalStrength) {
        this.signalStrength = signalStrength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BluetoothObservation that = (BluetoothObservation) o;

        if (bluetoothDevice != null ? !bluetoothDevice.equals(that.bluetoothDevice) : that.bluetoothDevice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return bluetoothDevice != null ? bluetoothDevice.hashCode() : 0;
    }
}
