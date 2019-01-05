package com.example.urvipatel.patelu_assignment_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DvrActivity extends Activity {

    public enum States
    {
        STOPPED {
            public String toString() {
                return "Stopped";
            }
        },

        PLAYING {
            public String toString() {
                return "Playing";
            }
        },

        PAUSED {
            public String toString() {
                return "Paused";
            }
        },

        FAST_FORWARDING {
            public String toString() {
                return "Fast Forwarding";
            }
        },

        FAST_REWINDING {
            public String toString() {
                return "Fast Rewinding";
            }
        },

        RECORDING {
            public String toString() {
                return "Recording";
            }
        },
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvr);


        final Button switchToTV = (Button) findViewById(R.id.buttonSwitchToTV);
        final Button play = (Button) findViewById(R.id.buttonPlay);
        final Button stop = (Button) findViewById(R.id.buttonStop);
        final Button pause = (Button) findViewById(R.id.buttonPause);
        final Button fastForward = (Button) findViewById(R.id.buttonFastForward);
        final Button fastRewind = (Button) findViewById(R.id.buttonFastRewind);
        final Button record = (Button) findViewById(R.id.buttonRecord);

        final Switch dvrPowerSwitch = (Switch) findViewById(R.id.DvrPowerSwitch);

        final TextView dvrPowerIndicator = (TextView) findViewById(R.id.DvrPowerIndicator);
        final TextView dvrStateIndicator = (TextView) findViewById(R.id.DvrStateIndicator);



        CompoundButton.OnCheckedChangeListener powerListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked){
                play.setEnabled(isChecked);
                stop.setEnabled(isChecked);
                pause.setEnabled(isChecked);
                fastForward.setEnabled(isChecked);
                fastRewind.setEnabled(isChecked);
                record.setEnabled(isChecked);
                dvrPowerIndicator.setText(isChecked ? "On" : "Off");
                dvrStateIndicator.setText(States.STOPPED.toString());
            }
        };

        dvrPowerSwitch.setOnCheckedChangeListener(powerListener);

        View.OnClickListener switchToTVListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(DvrActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener playListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                String state = dvrStateIndicator.getText().toString();

                if(!state.equals(States.RECORDING.toString()))
                {
                    dvrStateIndicator.setText(States.PLAYING.toString());
                }
                else
                {
                    Toast.makeText(DvrActivity.this, "Playing is not allowed when DVR is in the "
                            + state + " state", Toast.LENGTH_SHORT).show();
                }
            }
        };

        View.OnClickListener stopListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                dvrStateIndicator.setText(States.STOPPED.toString());
            }
        };
        View.OnClickListener pauseListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                String state = dvrStateIndicator.getText().toString();
                if(state.equals(States.PLAYING.toString()))
                {
                    dvrStateIndicator.setText(States.PAUSED.toString());
                }
                else
                {
                    Toast.makeText(DvrActivity.this, "Pausing is not allowed when DVR is in the "
                      + state + " state", Toast.LENGTH_SHORT).show();
                }
            }
        };

        View.OnClickListener fastForwardListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                String state = dvrStateIndicator.getText().toString();
                if(state.equals(States.PLAYING.toString()))
                {
                    dvrStateIndicator.setText(States.FAST_FORWARDING.toString());
                }
                else
                {
                    Toast.makeText(DvrActivity.this, "Fast forwarding is not allowed when DVR is in the "
                            + state + " state", Toast.LENGTH_SHORT).show();
                }
            }
        };
        View.OnClickListener fastRewindListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                String state = dvrStateIndicator.getText().toString();
                if(state.equals(States.PLAYING.toString()))
                {
                    dvrStateIndicator.setText(States.FAST_REWINDING.toString());
                }
                else
                {
                    Toast.makeText(DvrActivity.this, "Fast rewinding is not allowed when DVR is in the "
                            + state + " state", Toast.LENGTH_SHORT).show();
                }
            }
        };
        View.OnClickListener recordListener = new View.OnClickListener() {
            public void onClick(View v)
            {
                String state = dvrStateIndicator.getText().toString();
                if(state.equals(States.STOPPED.toString()))
                {
                    dvrStateIndicator.setText(States.RECORDING.toString());
                    return;
                }
                if(state.equals(States.RECORDING.toString()))
                {
                    return;
                }
                Toast.makeText(DvrActivity.this, "Recording is not allowed when DVR is in the "
                            + state + " state", Toast.LENGTH_SHORT).show();

            }
        };

        switchToTV.setOnClickListener(switchToTVListener);
        play.setOnClickListener(playListener);
        stop.setOnClickListener(stopListener);
        pause.setOnClickListener(pauseListener);
        stop.setOnClickListener(stopListener);
        fastForward.setOnClickListener(fastForwardListener);
        fastRewind.setOnClickListener(fastRewindListener);
        record.setOnClickListener(recordListener);
    }
}
