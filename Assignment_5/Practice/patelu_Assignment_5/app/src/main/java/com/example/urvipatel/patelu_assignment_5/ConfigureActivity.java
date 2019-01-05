package com.example.urvipatel.patelu_assignment_5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class ConfigureActivity extends Activity {

    String channel = "";
    String radioButtonText = "";
    String userLabel = "";
    String userChannel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        final Button configButton0 = (Button) findViewById(R.id.configButton0);
        final Button configButton1 = (Button) findViewById(R.id.configButton1);
        final Button configButton2 = (Button) findViewById(R.id.configButton2);
        final Button configButton3 = (Button) findViewById(R.id.configButton3);
        final Button configButton4 = (Button) findViewById(R.id.configButton4);
        final Button configButton5 = (Button) findViewById(R.id.configButton5);
        final Button configButton6 = (Button) findViewById(R.id.configButton6);
        final Button configButton7 = (Button) findViewById(R.id.configButton7);
        final Button configButton8 = (Button) findViewById(R.id.configButton8);
        final Button configButton9 = (Button) findViewById(R.id.configButton9);

        final Button configChannelPlus = (Button) findViewById(R.id.configButtonChPlus);
        final Button configChannelMinus = (Button) findViewById(R.id.configButtonChMinus);

        final Button configCancelButton = (Button) findViewById(R.id.configCancelButton);
        final Button configSaveButton = (Button) findViewById(R.id.configSaveButton);

        final RadioGroup radioButtonGroup = (RadioGroup) findViewById(R.id.leftMiddleRight);

        final EditText userFavoriteLabel = (EditText) findViewById(R.id.userFavoriteLabel);
        final TextView userFavoriteChannelIndicator = (TextView) findViewById(R.id.userFavoriteChannelIndicator);

        userFavoriteLabel.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;

                        if (actionId == EditorInfo.IME_ACTION_SEND)
                        {
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                            handled = true;
                        }
                        return handled;
                    }
                });

        View.OnClickListener cancelListener = new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
            }
        };

        View.OnClickListener saveListener = new View.OnClickListener()
        {
            public void onClick(View v)
            {
                int selectedRadioButtonId = radioButtonGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonId);
                radioButtonText = selectedRadioButton.getText().toString();

                if(userFavoriteLabel.getText().toString().length() < 2 || userFavoriteLabel.getText().toString().length() > 4)
                {
                    showToast("Label must be 2 - 4 letters in length");
                    return;
                }

                int c = Integer.parseInt(userFavoriteChannelIndicator.getText().toString());

                if(c < 1 || c > 999)
                {
                    showToast("Channel must be between 1 and 999");
                    return;
                }

                userLabel = userFavoriteLabel.getText().toString();
                userChannel = userFavoriteChannelIndicator.getText().toString();

                Intent data = new Intent();
                data.putExtra("FavoriteLabelPosition", radioButtonText);
                data.putExtra("FavoriteLabelText", userLabel);
                data.putExtra("FavoriteChannel", userChannel);
                setResult(RESULT_OK, data);
                finish();
            }
        };

        View.OnClickListener channelButtonLisenter = new View.OnClickListener() {
            public void onClick(View v)
            {
                String c = ((Button) v).getText().toString();
                channel += c;
                userFavoriteChannelIndicator.setText(channel);

                if(channel.length() > 3)
                {
                    channel = c;
                    userFavoriteChannelIndicator.setText(channel);
                }
            }
        };

        View.OnClickListener channelIncrementButtonLisenter = new View.OnClickListener() {
            public void onClick(View v)
            {
                int channelInt = Integer.parseInt(userFavoriteChannelIndicator.getText().toString());
                int newChannel = channelInt + 1;
                userFavoriteChannelIndicator.setText(String.format(Locale.getDefault(), "%d", newChannel));
            }
        };

        View.OnClickListener channelDecrementButtonLisenter = new View.OnClickListener() {
            public void onClick(View v)
            {
                int channelInt = Integer.parseInt(userFavoriteChannelIndicator.getText().toString());
                int newChannel = channelInt + 1;
                userFavoriteChannelIndicator.setText(String.format(Locale.getDefault(), "%d", newChannel));
            }
        };

        configCancelButton.setOnClickListener(cancelListener);

        configButton0.setOnClickListener(channelButtonLisenter);
        configButton1.setOnClickListener(channelButtonLisenter);
        configButton2.setOnClickListener(channelButtonLisenter);
        configButton3.setOnClickListener(channelButtonLisenter);
        configButton4.setOnClickListener(channelButtonLisenter);
        configButton5.setOnClickListener(channelButtonLisenter);
        configButton6.setOnClickListener(channelButtonLisenter);
        configButton7.setOnClickListener(channelButtonLisenter);
        configButton8.setOnClickListener(channelButtonLisenter);
        configButton9.setOnClickListener(channelButtonLisenter);
        configChannelPlus.setOnClickListener(channelIncrementButtonLisenter);
        configChannelMinus.setOnClickListener(channelDecrementButtonLisenter);
        configSaveButton.setOnClickListener(saveListener);
    }

    private void showToast(String msg)
    {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, msg, duration);
        toast.show();
    }
}
