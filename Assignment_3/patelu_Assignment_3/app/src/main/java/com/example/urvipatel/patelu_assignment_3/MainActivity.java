package com.example.urvipatel.patelu_assignment_3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.HashMap;

public class MainActivity extends Activity {

    Double runningTotal = 0.0;
    String orderSummary = "";
    DecimalFormat df = new DecimalFormat("#.00");

    private static final String[] menuItems = new String[]{
            "Spaghetti",
            "Lasagna",
            "Tiramisu",
            "Bread",
            "Merlot",
            "Minestrone"
    };

    private static final HashMap<String, Double> menuItemsPrices = new HashMap<>();

    static {
        menuItemsPrices.put("Spaghetti", 4.5);
        menuItemsPrices.put("Lasagna", 8.75);
        menuItemsPrices.put("Tiramisu", 6.5);
        menuItemsPrices.put("Bread", 2.25);
        menuItemsPrices.put("Merlot", 7.95);
        menuItemsPrices.put("Spaghetti", 4.0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button newOrder = (Button) findViewById(R.id.newOrder);
        final Button newItem = (Button) findViewById(R.id.newItem);
        final Button total = (Button) findViewById(R.id.totalBtn);


        final AutoCompleteTextView itemTextView = (AutoCompleteTextView) findViewById(R.id.item_tv);
        final TextView totalLbl = (TextView) findViewById(R.id.totalLabel);
        final EditText priceEditText = (EditText) findViewById(R.id.price);
        final EditText quantityEditText = (EditText) findViewById(R.id.qty);

        final TextView summaryLbl = (TextView) findViewById(R.id.summaryLabel);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, menuItems);
        itemTextView.setAdapter(adapter);



        newOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                itemTextView.setText("");
                quantityEditText.setText("1");
                priceEditText.setText("0.00");
                totalLbl.setText("$0.00");
                summaryLbl.setText("");
                runningTotal = 0.0;
                orderSummary = "";
            }
        });

        newItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                itemTextView.setText("");
                quantityEditText.setText("1");
                priceEditText.setText("0.00");
            }
        });

        total.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                double p = Double.parseDouble(priceEditText.getText().toString());
                int q = Integer.parseInt(quantityEditText.getText().toString());
                String menuSelection = itemTextView.getText().toString();
                orderSummary += menuSelection + " x" + q+ "\n";
                runningTotal += p * q;

                totalLbl.setText("$" + (df.format(runningTotal)).toString());
                summaryLbl.setText(orderSummary);
            }
        });

        itemTextView.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;

                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            String foodItem = itemTextView.getText().toString();
                            if (foodItem != null && !foodItem.isEmpty()) {
                                if (menuItemsPrices.containsKey(foodItem)) {
                                    priceEditText.setText(df.format(menuItemsPrices.get(foodItem)).toString());
                                }
                                else
                                {
                                    showToast();
                                }
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });
    }

    private void showToast()
    {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        int duration = Toast.LENGTH_SHORT;
        String msg = "Not on menu, enter price manually";
        //int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(this, msg, duration);
        toast.show();
    }
}