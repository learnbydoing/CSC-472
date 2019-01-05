package com.example.urvipatel.patelu_assignment_4;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Locale;


public class MainActivity extends Activity
{

    String channel = "";
    static private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView powerIndicator = (TextView) findViewById(R.id.powerIndicator);
        final TextView volumeIndicator = (TextView) findViewById(R.id.volumeIndicator);
        final TextView channelIndicator = (TextView) findViewById(R.id.channelIndicator);

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

        final Button abc = (Button) findViewById(R.id.buttonABC);
        final Button nbc = (Button) findViewById(R.id.buttonNBC);
        final Button cbs = (Button) findViewById(R.id.buttonCBS);




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
                abc.setEnabled(isChecked);
                nbc.setEnabled(isChecked);
                cbs.setEnabled(isChecked);
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
                volumeIndicator.setText(String.format(Locale.getDefault(), "%d",i));
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
                channelIndicator.setText(String.format(Locale.getDefault(),"%d", newChannel));
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

        View.OnClickListener abcListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                channelIndicator.setText(R.string.seven);
            }
        };

        View.OnClickListener nbcListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                channelIndicator.setText(R.string.five);
            }
        };

        View.OnClickListener cbsListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                channelIndicator.setText(R.string.two);
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

        abc.setOnClickListener(abcListener);
        cbs.setOnClickListener(cbsListener);
        nbc.setOnClickListener(nbcListener);
    }
}
