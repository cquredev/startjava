package com.basejava.model;

public class Resume {
    private String uuid;

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    public String getUuid (){
        return this.uuid;
    }

    @Override
    public String toString(){
        return uuid;
    }
}
