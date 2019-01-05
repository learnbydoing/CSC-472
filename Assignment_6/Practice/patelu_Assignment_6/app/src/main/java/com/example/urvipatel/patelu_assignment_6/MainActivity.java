package com.example.urvipatel.patelu_assignment_6;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity
{

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new EUNationsAdapter());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        Log.d(TAG, "onListItemClick position = " + position + " id = " + id + " " + NATIONS[position].getNationName().toString());
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("CountryName", NATIONS[position].getNationName().toString());
        intent.putExtra("CountryDetails", NATIONS[position].getInfo());
        intent.putExtra("CountryFlag", EUNation.getFlagIconResource(NATIONS[position].getNationName()));
        startActivity(intent);
    }

    class EUNationsAdapter extends BaseAdapter
    {
        private LayoutInflater inflater;

        @Override
        public int getCount() {
            return NATIONS.length;
        }

        @Override
        public Object getItem(int i) {
            return NATIONS[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (convertView == null) {
                if (inflater == null)
                    inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.nation_list_item, parent, false);
            }

            ImageView currIcon = (ImageView) row.findViewById(R.id.currencyImage);
            TextView name = (TextView) row.findViewById(R.id.name);
            TextView capital = (TextView) row.findViewById(R.id.capital);

            EUNation nation = NATIONS[position];
            name.setText(nation.getNationName().toString());
            capital.setText(nation.getCapital());
            currIcon.setImageResource(EUNation.getIconResource(nation.getCurrency()));
            return row;
        }
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

    private static final EUNation[] NATIONS = {
            new	EUNation(EUNation.NationName.Austria,
                    "1 January 1995",
                    "Vienna",
                    "83,879",
                    "8,507,786",
                    EUNation.Currency.Euro,
                    "Austria is a largely mountainous country due to its location at the eastern end of the Alps. This mountain range dominates the western and southern parts of Austria while the country’s lower-lying eastern provinces are in the Danube basin.  The most important sectors of Austria’s economy in 2014 were wholesale and retail trade, transport, accommodation and food services (22.8 %), industry (22.1 %) and public administration, defence, education, human health and social work activities (17.7 %).  Austria’s main export partners are Germany, Italy and the US, while its main import partners are Germany, Italy and Switzerland."),

            new	EUNation(EUNation.NationName.Belgium,
                    "1 January 1958",
                    "Brussels",
                    "30,528",
                    "11,203,992",
                    EUNation.Currency.Euro,
                    "Belgium is a federal state divided into three regions: Dutch-speaking Flanders in the north, francophone Wallonia in the south and Brussels, the bilingual capital, where French and Dutch share official status. There is also a small German-speaking minority in the eastern part of the country. Belgium’s varied landscape includes: 67 kilometres of sea coast and flat coastal plains along the North Sea, a central plateau and the rolling hills and forests of the Ardennes region in the south"),

            new	EUNation(EUNation.NationName.Bulgaria,
                    "1 January 2007",
                    "Sofia",
                    "111,002",
                    "7,245,677",
                    EUNation.Currency.BulgarianLev,
                    "Located in the southeast part of the Balkans, Bulgaria has a diverse topography. The north of the country is dominated by the vast lowlands of the Danube Plain with the river Danube defining the border with neighbouring Romania. The south of the country, by contrast, is dominated by highlands and elevated plains while, in the east, the Black Sea coast attracts tourists all year round."),

            new	EUNation(EUNation.NationName.Denmark,
                    "1 January 1973",
                    "Copenhagen",
                    "42,921",
                    "5,627,235",
                    EUNation.Currency.DanishKrone,
                    "Denmark is the smallest as well as the most southerly and most low-lying of the three Scandinavian countries and consists of the peninsula of Jutland and an archipelago of more than 400 islands of which 72 are inhabited. Denmark borders Germany to the south, is connected to Sweden by a road and rail bridge and has a tidal coastline of 7 314 km."),

            new	EUNation(EUNation.NationName.Estonia,
                    "1 May 2004",
                    "Tallinn",
                    "45,227",
                    "1,315,819",
                    EUNation.Currency.Euro,
                    "Estonia is the most northerly of the three Baltic States and is a predominantly flat country on the eastern shores of the Baltic Sea. The most important sectors of Estonia’s economy in 2014 were wholesale and retail trade, transport, accommodation and food services (22.5 %), industry (21.1 %) and public administration, defence, education, human health and social work activities (15.4 %)."),

            new	EUNation(EUNation.NationName.Finland,
                    "1 January 1995",
                    "Helsinki",
                    "338,435",
                    "5,451,270",
                    EUNation.Currency.Euro,
                    "Finland is one of the five Nordic countries and the northernmost country in the EU. Finland is one of the most sparsely-populated countries in the EU and is bordered by Sweden to the west, Norway to the north and Russia to the east."),

            new	EUNation(EUNation.NationName.France,
                    "1 January 1958",
                    "Paris",
                    "632,833",
                    "65,856,609",
                    EUNation.Currency.Euro,
                    "France is the largest country in the EU, stretching from the North Sea to the Mediterranean. The landscape is diverse, with mountains in the east and south, including the Alpine peak of Mont Blanc (4 810 m), which is western Europe's highest point."),

            new EUNation(EUNation.NationName.Germany,
                    "1 January 1958",
                    "Berlin",
                    "357,340",
                    "80,780,000",
                    EUNation.Currency.Euro,
                    "With a landmass that stretches from the North Sea and the Baltic Sea in the north to the Alps in the south, Germany has the largest population of any EU country. Germany borders Denmark to the north, Poland and the Czech Republic to the east, Austria and Switzerland to the south, France and Luxembourg to the southwest, and Belgium and the Netherlands to the northwest."),

            new	EUNation(EUNation.NationName.Hungary,
                    "1 May 2004",
                    "Budapest",
                    "93,024",
                    "9,879,000",
                    EUNation.Currency.HungarianForint,
                    "Hungary is a landlocked country in central Europe, which borders with no fewer than seven countries: Slovakia, Ukraine, Romania, Serbia, Croatia, Slovenia and Austria. The country is mostly flat, with low mountains in the north."),

            new EUNation(EUNation.NationName.Ireland,
                    "1 January 1973",
                    "Dublin",
                    "69,797",
                    "4,604,029",
                    EUNation.Currency.Euro,
                    "Ireland comprises five-sixths of the island of Ireland. The north-eastern part of the island is Northern Ireland which is part of the United Kingdom. Ireland has a long coastline. To the west is the northern Atlantic Ocean and to the south the Celtic Sea. To the east Ireland is separated from Great Britain by the Irish Sea."),

            new EUNation(EUNation.NationName.Italy,
                    "1 January 1958",
                    "Rome",
                    "302,073",
                    "60,782,668",
                    EUNation.Currency.Euro,
                    "To the north, Italy borders France, Switzerland, Austria, and Slovenia, and its borders are largely naturally defined by the Alpine watershed. To the south, it consists of the entirety of the Italian Peninsula and the two largest Mediterranean islands of Sicily and Sardinia as well as around 68 smaller islands. There are two small independent states within Italy: the Vatican City in Rome, and the Republic of San Marino."),

            new	EUNation(EUNation.NationName.Latvia,
                    "1 May 2004",
                    "Riga",
                    "64,573",
                    "2,001,468",
                    EUNation.Currency.Euro,
                    "With a coastline of 531km along the Baltic Sea, Latvia is bordered by Estonia, Lithuania, Russia and Belarus. Woodlands cover over 40 % of this low-lying country. Latvia also counts more than 3 000 lakes and 12 000 rivers."),

            new    EUNation(EUNation.NationName.Lithuania,
                    "1 May 2004",
                    "Vilnuis",
                    "65,300",
                    "2,943,472",
                    EUNation.Currency.Euro,
                    "Lithuania is the southernmost of the three Baltic States – and the largest and most populous of them. The country is predominantly flat, with a few low hills in the western uplands and eastern highlands. Forests cover just over 30 % of the country. "),


            new 	EUNation(EUNation.NationName.Luxemborg,
                    "1 January 1958",
                    "Luxemborg",
                    "2,586",
                    "549,280",
                    EUNation.Currency.Euro,
                    "The Grand Duchy of Luxembourg is a landlocked country in northern Europe surrounded by Belgium to the west, France to the south and Germany to the east. Per capita, it is the richest country in the EU as well as being one of its smallest. It is largely made up of rolling hills and forests."),


            new   EUNation(EUNation.NationName.Sweden,
                    "1 January 1995",
                    "Stockholm",
                    "438,574",
                    "9,644,864",
                    EUNation.Currency.DanishKrone,
                    "Sweden has the largest population among the Nordic countries and is the third-largest country in the European Union by surface area. To the west, Sweden is separated from Norway by mountains and is connected to the south by a road and rail bridge to Denmark."),
    };
}
