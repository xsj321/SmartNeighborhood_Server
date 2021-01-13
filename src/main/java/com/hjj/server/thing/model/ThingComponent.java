package com.hjj.server.thing.model;

import com.hjj.server.thing.service.ThingFunc;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
public class ThingComponent implements Serializable {
    private String name;
    private String info;
    private String id;
    private String registerTime;
    private ThingFunc call;
    public ThingComponent(String name, String info){
        this.name = name;
        this.info = info;
        this.id = generateID();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        this.registerTime = df.format(new Date());
    }
    public ThingComponent(String name, String info, ThingFunc call){
        this.name = name;
        this.info = info;
        this.call = call;
        this.id = generateID();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        this.registerTime = df.format(new Date());
    }

    private String generateID(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }
}
