package br.com.jsn.desafio.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {
    

       public static String formatarDateParaString(Date date){

        if (date != null) {
            
            String pattern = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }


    public static Date formatarStringParaDate(String data){

        String dateFormat = "dd/MM/yyyy";
    
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        try {
            Date date = formatter.parse(data);
            return date;
        } catch (ParseException e) {
            System.err.println("Falha no parsing da data : " + e.getMessage());
        }
        return null;
    }
}
