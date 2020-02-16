package com.hamidsultanzadeh.justblogapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AllConfig {

    public static String replaceAllText(String text){
        StringBuffer content = new StringBuffer(text);


        int loc = (new String(content).indexOf('\n'));
        while(loc > 0){
            content.replace(loc,loc+1,"<BR>");
            loc = (new String(content).indexOf('\n'));
        }

        loc = (new String(content).indexOf("<div>"));
        if(loc >= 0) content.replace(loc,loc+1,">");
        loc = (new String(content).indexOf("</div>"));
        if(loc >= 0) content.replace(loc,loc+1,">");

        return content.toString();
    }

    public static String backAllText(String text){

        StringBuffer content = new StringBuffer(text);

        int loc = (new String(content).indexOf("<BR>"));
        while(loc > 0){
            content.replace(loc,loc+4, "\n");
            loc = (new String(content).indexOf("<BR>"));
        }

        return content.toString();

    }
}
