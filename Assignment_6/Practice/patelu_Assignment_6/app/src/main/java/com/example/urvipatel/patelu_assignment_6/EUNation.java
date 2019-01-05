package com.example.urvipatel.patelu_assignment_6;

/**
 * Created by urvipatel on 10/9/16.
 */

public class EUNation {
    enum Currency
    {
        Euro {
            public String toString() { return "euro"; }
        },

        BulgarianLev {
            public String toString() { return "bgn"; }
        },


        CroatianKuna {
            public String toString() { return "hrk"; }
        },

        DanishKrone {
            public String toString() { return "dkk"; }
        },

        HungarianForint {
            public String toString() { return "huf"; }
        },
    }

    enum NationName {
        Austria {
            public String toString() { return "Austria"; }
        },

        Belgium {
            public String toString() { return "Belguim"; }
        },

        Bulgaria {
            public String toString() { return "Bulgaria"; }
        },

        Denmark {
            public String toString() { return "Denmark"; }
        },

        Estonia {
            public String toString() { return "Estonia"; }
        },

        Finland {
            public String toString() { return "Finland"; }
        },

        France {
            public String toString() { return "France"; }
        },

        Germany {
            public String toString() { return "Germany"; }
        },

        Hungary {
            public String toString() { return "Hungary"; }
        },

        Ireland {
            public String toString() { return "Ireland"; }
        },

        Italy {
            public String toString() { return "Italy"; }
        },

        Latvia {
            public String toString() { return "Latvia"; }
        },

        Lithuania {
            public String toString() { return "Lithuania"; }
        },

        Luxemborg {
            public String toString() { return "Luxemborg"; }
        },

        Sweden {
            public String toString() { return "Sweden"; }
        },
    }

    NationName name;
    String jDate;
    String cptl;
    String area;
    Currency curr;
    String data;

    public EUNation(NationName countryName, String joinDate, String capital, String size, String population, Currency currency, String info)
    {
        this.name = countryName;
        this.jDate = joinDate;
        this.cptl = capital;
        this.area = size;
        this.curr = currency;
        this.data = info;
    }

    public String getJoinDate() { return jDate; }

    public String getCapital() { return  cptl; }

    public String getArea() { return area; }

    public Currency getCurrency() { return curr; }

    public NationName getNationName() { return name; }

    public String getInfo() { return data; };

    public String toString() { return name.toString(); }

    public static int getIconResource(Currency c)
    {
        switch(c)
        {
            case Euro: return R.drawable.euro;
            case BulgarianLev: return R.drawable.bgn;
            case CroatianKuna: return R.drawable.hrk;
            case DanishKrone: return R.drawable.dkk;
            case HungarianForint: return R.drawable.huf;
        }
        return -1;
    }

    public static int getFlagIconResource(NationName name)
    {
        switch(name)
        {
            case Austria: return R.drawable.austria;
            case Belgium: return R.drawable.belgium;
            case Bulgaria: return R.drawable.bulgaria;
            case Denmark: return R.drawable.denmark;
            case Estonia: return R.drawable.estonia;
            case Finland:return R.drawable.finland;
            case France: return R.drawable.france;
            case Germany: return R.drawable.germany;
            case Hungary: return R.drawable.hungary;
            case Ireland: return R.drawable.ireland;
            case Italy: return R.drawable.italy;
            case Latvia: return R.drawable.latvia;
            case Lithuania: return R.drawable.lithuania;
            case Luxemborg: return R.drawable.luxemborg;
            case Sweden: return R.drawable.sweden;
        }
        return -1;
    }
}
