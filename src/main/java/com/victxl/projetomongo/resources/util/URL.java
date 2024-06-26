package com.victxl.projetomongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

    public static  String decodParam(String texto){
        try {
            return URLDecoder.decode(texto,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return " ";
        }
    }

    public static Date convertDate(String textoData, Date defaultValue){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(textoData);
        } catch (ParseException e) {
            return defaultValue;
        }
    }
}
