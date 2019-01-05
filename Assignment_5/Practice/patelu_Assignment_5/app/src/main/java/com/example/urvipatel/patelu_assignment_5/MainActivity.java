package com.example.urvipatel.patelu_assignment_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends Activity {

    String channel = "";
    String favoriteChannelToDisplay = "";

    static String leftFavoriteChannelIndicatorText = "007";
    static String middleFavoriteChannelIndicatorText = "005";
    static String rightFavoriteChannelIndicatorText = "002";

    static String leftFavoriteButtonText = "ABC";
    static String middleFavoriteButtonText = "NBC";
    static String rightFavoriteButtonText = "CBS";

    static private final String TAG = "MainActivity";
    private static final int GET_CONFIG = 100; // request code

    TextView channelIndicator;
    Button leftFavoriteButton;
    Button middleFavoriteButton;
    Button rightFavoriteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView powerIndicator = (TextView) findViewById(R.id.powerIndicator);
        final TextView volumeIndicator = (TextView) findViewById(R.id.volumeIndicator);

        channelIndicator = (TextView) findViewById(R.id.channelIndicator);
        leftFavoriteButton = (Button) findViewById(R.id.leftFavoriteButton);
        middleFavoriteButton = (Button) findViewById(R.id.middleFavoriteButton);
        rightFavoriteButton = (Button) findViewById(R.id.rightFavoriteButton);

        final Switch powerSwitch = (Switch) findViewById(R.id.powerSwitch);
        final SeekBar volumeSeekbar = (SeekBar) findViewById(R.id.volumeSeekbar);

        final Button zero = (Button) findViewById(R.id.button0);
        final Button one = (Button) findViewById(R.id.button1);
        final Button two = (Button) findViewById(R.id.button2);
        final Button three = (Button) findViewById(R.id.button3);
        final Button four = (Button) findViewById(R.id.button4);
        final Button five = (Button) findViewById(R.id.button5);
        final Button six = (Button) findViewById(R.id.button6);
        final Button seven = (Button) findViewById(R.id.button7);
        final Button eight = (Button) findViewById(R.id.button8);
        final Button nine = (Button) findViewById(R.id.button9);

        final Button chPlus = (Button) findViewById(R.id.buttonChannelPlus);
        final Button chMinus = (Button) findViewById(R.id.buttonChannelMinus);



        final Button switchToDVR = (Button) findViewById(R.id.buttonSwitchToDVR);
        final Button configure = (Button) findViewById(R.id.buttonConfigure);

        CompoundButton.OnCheckedChangeListener powerListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked){
                zero.setEnabled(isChecked);
                one.setEnabled(isChecked);
                two.setEnabled(isChecked);
                three.setEnabled(isChecked);
                four.setEnabled(isChecked);
                five.setEnabled(isChecked);
                six.setEnabled(isChecked);
                seven.setEnabled(isChecked);
                eight.setEnabled(isChecked);
                nine.setEnabled(isChecked);
                chMinus.setEnabled(isChecked);
                chPlus.setEnabled(isChecked);
                leftFavoriteButton.setEnabled(isChecked);
                middleFavoriteButton.setEnabled(isChecked);
                rightFavoriteButton.setEnabled(isChecked);
                volumeSeekbar.setEnabled(isChecked);
                powerIndicator.setText(isChecked ? "On" : "Off");
            }
        };

        powerSwitch.setOnCheckedChangeListener(powerListener);

        volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                Log.d(TAG, "onProgressChanged");
                volumeIndicator.setText(String.format(Locale.getDefault(), "%d", i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch");
            }
        });


        View.OnClickListener channelListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                String c = ((Button) v).getText().toString();
                channel += c;
                channelIndicator.setText(channel);

                if(channel.equals("000"))
                {
                    channelIndicator.setText(R.string.one);
                }

                if(channel.length() > 3)
                {
                    channel = c;
                    channelIndicator.setText(channel);
                }
            }
        };

        View.OnClickListener incrementListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                String currentChannel = channelIndicator.getText().toString();
                if(currentChannel.equals("999"))
                {
                    channelIndicator.setText(R.string.one);
                    return;
                }

                if(currentChannel.charAt(0) == '0' && currentChannel.charAt(1) == '0')
                {
                    String s = Character.toString(currentChannel.charAt(2));
                    int lastNum = Integer.parseInt(s);
                    lastNum += 1;

                    String zeros;
                    if(lastNum <= 9)
                    {
                        zeros = "00";
                    }
                    else
                    {
                        zeros = "0";
                    }
                    String res = zeros + Integer.toString(lastNum);
                    channelIndicator.setText(res);
                    return;
                }

                if(currentChannel.charAt(0) == '0' && currentChannel.charAt(1) != '0')
                {
                    String s2 = currentChannel.substring(1);
                    int lastNum2 = Integer.parseInt(s2);
                    lastNum2 += 1;

                    String zerosInc = "";
                    if(lastNum2 <= 99)
                    {
                        zerosInc = "0";
                    }

                    String res2 =  zerosInc + Integer.toString(lastNum2);
                    channelIndicator.setText(res2);
                    return;
                }


                int channelInt = Integer.parseInt(channelIndicator.getText().toString());
                int newChannel = channelInt + 1;
                channelIndicator.setText(String.format(Locale.getDefault(), "%d", newChannel));
            }
        };
        View.OnClickListener decrementListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                String currentChannel = channelIndicator.getText().toString();

                if(currentChannel.equals("001"))
                {
                    channelIndicator.setText(R.string.all_nines);
                    return;
                }

                if(currentChannel.charAt(0) == '0' && currentChannel.charAt(1) == '0')
                {
                    String s = Character.toString(currentChannel.charAt(2));
                    int lastNum = Integer.parseInt(s);
                    lastNum -= 1;
                    String res = "00" + Integer.toString(lastNum);
                    channelIndicator.setText(res);
                    return;
                }

                if(currentChannel.charAt(0) == '0' && currentChannel.charAt(1) != '0')
                {
                    String s2 = currentChannel.substring(1);
                    int lastNum2 = Integer.parseInt(s2);
                    lastNum2 -= 1;

                    String zeros;
                    if(lastNum2 <= 9)
                    {
                        zeros = "00";
                    }
                    else
                    {
                        zeros = "0";
                    }
                    String res2 = zeros + Integer.toString(lastNum2);
                    channelIndicator.setText(res2);
                    return;
                }

                int channelInt = Integer.parseInt(channelIndicator.getText().toString());
                int newChannel = channelInt - 1;
                String res = Integer.toString(newChannel);

                if(newChannel < 100)
                {
                    res = "0" + Integer.toString(newChannel);
                }
                channelIndicator.setText((res));
            }
        };




        View.OnClickListener leftFavoriteButtonListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                channelIndicator.setText(leftFavoriteChannelIndicatorText);
            }
        };

        final View.OnClickListener middleFavoriteButtonListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                channelIndicator.setText(middleFavoriteChannelIndicatorText);
            }
        };

        View.OnClickListener rightFavoriteButtonListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                channelIndicator.setText(rightFavoriteChannelIndicatorText);
            }
        };

        View.OnClickListener switchToDVRListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, DvrActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener configureListener = new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, ConfigureActivity.class);
                startActivityForResult(intent, GET_CONFIG);
            }
        };
        zero.setOnClickListener(channelListener);
        one.setOnClickListener(channelListener);
        two.setOnClickListener(channelListener);
        three.setOnClickListener(channelListener);
        four.setOnClickListener(channelListener);
        five.setOnClickListener(channelListener);
        six.setOnClickListener(channelListener);
        seven.setOnClickListener(channelListener);
        eight.setOnClickListener(channelListener);
        nine.setOnClickListener(channelListener);

        chPlus.setOnClickListener(incrementListener);
        chMinus.setOnClickListener(decrementListener);

        switchToDVR.setOnClickListener(switchToDVRListener);
        configure.setOnClickListener(configureListener);

        leftFavoriteButton.setOnClickListener(leftFavoriteButtonListener);
        middleFavoriteButton.setOnClickListener(middleFavoriteButtonListener);
        rightFavoriteButton.setOnClickListener(rightFavoriteButtonListener);

        leftFavoriteButton.setText(leftFavoriteButtonText);
        middleFavoriteButton.setText(middleFavoriteButtonText);
        rightFavoriteButton.setText(rightFavoriteButtonText);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        String favLabelPosn;
        String favLabelText;
        String favChannelReturned;

        if (requestCode == GET_CONFIG)
        {
            if (resultCode == RESULT_OK)
            {
                favLabelPosn = data.getCharSequenceExtra("FavoriteLabelPosition").toString();
                favLabelText = data.getCharSequenceExtra("FavoriteLabelText").toString();
                favChannelReturned = data.getCharSequenceExtra("FavoriteChannel").toString();

                favoriteChannelToDisplay = getChannelToDisplay(favChannelReturned);
                processFavorite(favLabelPosn, favLabelText);
            }
        }
    }

    private String getChannelToDisplay(String channel)
    {
        int favChannelInt = Integer.parseInt(channel);
        String zeros = "";

        if(favChannelInt < 10)
        {
            zeros = "00";
        }
        else if(favChannelInt >= 10 && favChannelInt <= 99 )
        {
            zeros = "0";
        }
        return  zeros + channel;
    }


    private void processFavorite(String posn, String text)
    {
        switch (posn)
        {
            case "Left":
                leftFavoriteButton.setText(text);
                leftFavoriteButtonText = text;
                leftFavoriteChannelIndicatorText = favoriteChannelToDisplay;
                break;
            case "Middle":
                middleFavoriteButton.setText(text);
                middleFavoriteButtonText = text;
                middleFavoriteChannelIndicatorText = favoriteChannelToDisplay;
                break;
            case "Right":
                rightFavoriteButton.setText(text);
                rightFavoriteButtonText = text;
                rightFavoriteChannelIndicatorText = favoriteChannelToDisplay;
                break;
        }
    }
}
