package com.example.chatbluetooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private BluetoothAdapter bluetoothAdapter;
    private BroadcastReceiver bluetoothReceiver;

    private Dialog dialog;
    private ListView newDevices;
    private ListView bondedDevices;
    private Button btnStopSearch;

    private static final int REQUEST_ENABLE_BLUETOOTH = 1;
    private static final int REQUEST_ENABLE_BLUETOOTH_NEGATIVE = 0;
    private static final int REQUEST_ENABLE_BLUETOOTH_POSITIVE = -1;
    private final int REQUEST_READ_PHONE_STATE = 1;
    private final UUID myUUID = UUID.fromString("bf621b46-bbc5-4146-98fa-fa266e361ed8");

    private ArrayAdapter<String> bondedDevicesListArrayAdapter;
    private ArrayAdapter<String> newDevicesListArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        isBluetoothEnabled();
        showBluetoothDevices();

    }


    public void init(){
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_bluetooth_devices);
        dialog.setTitle("Dispositivos disponibles");

        bondedDevicesListArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1);
        bondedDevices = (ListView) dialog.findViewById(R.id.bondedDevices);
        bondedDevices.setAdapter(bondedDevicesListArrayAdapter);
        onListBondedItemClick();

        newDevicesListArrayAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1);
        newDevices = (ListView) dialog.findViewById(R.id.newDevices);
        newDevices.setAdapter(newDevicesListArrayAdapter);
        onListNewDevicesItemClick();

        btnStopSearch = (Button) dialog.findViewById(R.id.stopSearchButton);
        btnStopSearch.setOnClickListener(this);
    }

    public void isBluetoothEnabled(){
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth no esta disponible", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (!bluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BLUETOOTH);
        }else if(bluetoothAdapter.isEnabled()){
            getBluetoothBondedDevices();
            searchNewBluetoothDevices();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        //Si el usuario activa el bluetooth desde el dialogo mostrado se procedera a buscar y mostrar
        //dispositivos enlazados y disponibles
        if(requestCode == 1 && resultCode == REQUEST_ENABLE_BLUETOOTH_POSITIVE){
            getBluetoothBondedDevices();
            searchNewBluetoothDevices();
        }else if(requestCode ==1 && resultCode == REQUEST_ENABLE_BLUETOOTH_NEGATIVE){
            finish();
        }

    }

    public void getBluetoothBondedDevices(){
        //Compruebo que el adaptador no este buscando dispositivos, en caso de que lo este haciendo paro la busqueda
        if (bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.cancelDiscovery();
        }
        //Inicio la busqueda de dispositivos
        bluetoothAdapter.startDiscovery();

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        //Obtengo los dispositivos ya emparejados con el dispositivo y los iteramos para añadir su informacion a listaDispositivosEmparejados
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

        for (BluetoothDevice device : pairedDevices) {
            bondedDevicesListArrayAdapter.add(device.getName() + "\n" + device.getAddress());
            bondedDevicesListArrayAdapter.notifyDataSetChanged();
            //listaDispositivosEmparejadosArrayAdapter.notify();
        }
    }

    public void searchNewBluetoothDevices(){

        //Compruebo que el adaptador no este buscando dispositivos, en caso de que lo este haciendo paro la busqueda
        if (bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.cancelDiscovery();
        }
        //Inicio la busqueda de dispositivos
        bluetoothAdapter.startDiscovery();

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        bluetoothReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();

                //Finding devices
                if (BluetoothDevice.ACTION_FOUND.equals(action))
                {
                    // Get the BluetoothDevice object from the Intent
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    // Add the name and address to an array adapter to show in a ListView
                    newDevicesListArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                    Toast.makeText(context, device.getName() + "\n" + device.getAddress(), Toast.LENGTH_SHORT).show();
                    bondedDevicesListArrayAdapter.notifyDataSetChanged();
                    //listaDispositivosEmparejadosArrayAdapter.notify();
                }
            }
        };

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(bluetoothReceiver, filter);
    }

    public void showBluetoothDevices(){
        dialog.setCancelable(false);
        dialog.show();
    }

    public void onListBondedItemClick(){
        bondedDevices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tvDevice = (TextView) view;
                String deviceAddress = getDeviceAddresFromInfo(tvDevice.getText().toString());
            }
        });
    }

    public void onListNewDevicesItemClick(){
        newDevices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tvDevice = (TextView) view;
                String deviceAddress = getDeviceAddresFromInfo(tvDevice.getText().toString());
            }
        });
    }

    public String getDeviceAddresFromInfo(String info){
        String deviceAddress = info.substring(info.length() - 17);
        Toast.makeText(MainActivity.this, "" + deviceAddress, Toast.LENGTH_SHORT).show();
        return  deviceAddress;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.stopSearchButton:
                bluetoothAdapter.cancelDiscovery();
                Toast.makeText(this, "Parar", Toast.LENGTH_SHORT).show();
        }
    }
}