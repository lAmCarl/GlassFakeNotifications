package com.example.carl.glassfakenotifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.glass.app.Card;

/**
 * Created by Carl on 2014-08-31.
 */
public class Settings extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Card card = new Card(getApplicationContext());
        card.setText("Enable voice commands?");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if(item.getItemId() == R.id.yes){
            broadcastLog("voice commands enabled");
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("voicecommand", true);
            startActivity(intent);
            finish();
            return true;
        } else if(item.getItemId() == R.id.no){
            broadcastLog("voice commands disabled");
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("voicecommand", false);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onMenuItemSelected(featureId, item);
    }

    public void broadcastLog(String message){
        Intent logMessage = new Intent("log");
        logMessage.putExtra("message", message);
        getApplicationContext().sendBroadcast(logMessage);
    }
}
