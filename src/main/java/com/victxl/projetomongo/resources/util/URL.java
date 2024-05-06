package com.victxl.projetomongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

    public static  String decodParam(String texto){
        try {
            return URLDecoder.decode(texto,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return " ";
        }
    }
}
