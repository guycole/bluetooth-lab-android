package net.braingang.bluetoothlab;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements CustomListener {
    public static final String LOG_TAG = MainActivity.class.getName();

    private ViewPager _viewPager;

    private BluetoothAdapter _adapter;
    private BluetoothHelper _helper = new BluetoothHelper();
    private int REQUEST_ENABLE_BT = 123;

    public void enableBlueToothDialog() {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(intent, REQUEST_ENABLE_BT);
    }

    public void onCustomEvent(String arg) {
        System.out.println("event:" + arg);
    }

    /*
    private View.OnClickListener _listener = new View.OnClickListener() {

        public void onClick(View vv) {
            switch (vv.getId()) {
                case R.id.button1:
                    System.out.println("hit hit hit");
                    _adapter = _helper.setUp(getBaseContext());

                    if (_adapter == null || !_adapter.isEnabled()) {
                        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(intent, REQUEST_ENABLE_BT);
                    }

                    _helper.scanner(getBaseContext());
                    break;
            }
        }
    };
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _viewPager = (ViewPager) findViewById(R.id.pager);
        _viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.i(LOG_TAG, "result test:" + requestCode);
    }
}
