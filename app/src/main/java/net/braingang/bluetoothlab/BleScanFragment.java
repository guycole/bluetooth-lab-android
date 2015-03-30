package net.braingang.bluetoothlab;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;Ω
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 *
 */
public class BleScanFragment extends ListFragment {
    public static final String LOG_TAG = BleScanFragment.class.getName();

    private BluetoothAdapter _adapter;

    private CustomListener _customListener;

    private boolean _scanning;
    private Handler _handler;

    private BluetoothAdapter.LeScanCallback _scanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
            System.out.println(device.getAddress() + ":" + device.getName());
        }
    };

    private void scanLeDevice(final boolean enable) {
        if (enable) {
            _scanning = true;
            _adapter.startLeScan(_scanCallback);

            _handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    _scanning = false;
                    _adapter.stopLeScan(_scanCallback);
                }
            }, 10000L);
        } else {
            _scanning = false;
            if (_adapter != null) {
                _adapter.stopLeScan(_scanCallback);
            }
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // TODO: Rename and change types of parameters
    public static BleScanFragment newInstance(String param1, String param2) {
        BleScanFragment fragment = new BleScanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to
     * instantiate the fragment (e.g. upon screen orientation changes).
     */
    public BleScanFragment() {
        //empty
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BluetoothManager manager = (BluetoothManager) getActivity().getSystemService(Context.BLUETOOTH_SERVICE);
        _adapter = manager.getAdapter();
        Log.i(LOG_TAG, "adapter name:" + _adapter.getName() + ":" + _adapter.getAddress());

        _handler = new Handler();

        //////////

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        /*
        // TODO: Change Adapter to display your content
        mAdapter = new ArrayAdapter<DummyContent.DummyItem>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, DummyContent.ITEMS);
                */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blescan_list, container, false);

        Button scanStartButton = (Button) view.findViewById(R.id.buttonScanStart);
        scanStartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "start scan");
                if (_adapter == null || !_adapter.isEnabled()) {
                    _customListener.enableBlueToothDialog();
                } else {
                    scanLeDevice(true);
                }
            }
        });

        // Set the adapter
        //mListView = (AbsListView) view.findViewById(android.R.id.list);
        //((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
       // mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        _customListener = (CustomListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
