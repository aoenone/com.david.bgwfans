package com.david.bgwfanspaid;

public class XMLData {
    int temp;
    String city;

    public String dataToString() {
        return temp + " and " + city;
    }

    public void setCity(String c) {
        city = c;
    }

    public void setTemp(int t) {
        temp = t;
    }

}
