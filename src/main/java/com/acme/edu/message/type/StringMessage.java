package com.acme.edu.message.type;

import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.message.Message;

public class StringMessage extends DataEqualMessage {

    private int counter = 1;

    public StringMessage(String msg, boolean isSum){
        setMsg(msg,isSum);
    }

    public StringMessage(String msg){
        this(msg,false);
    }

    public StringMessage(StringMessage message) {
        this((String) message.getData(), message.isSum());
    }

    @Override
    public void setMsg(Object message) {
        data = message;
    }

    @Override
    public void setMsg(Object message, boolean isSum) {
        setMsg(message);
        isSumming = isSum;
    }

    @Override
    public DataEqualMessage add(Message msg) {
        if (isSameType(msg)){
            if (isSame((DataEqualMessage) msg)){
                counter++;
                setEndLogging(false);
            } else {
                counter = 1;
                setEndLogging(false);
                DataEqualMessage tempMsg = new StringMessage(this);
                data = msg.getData();
                return tempMsg;
            }
        }
        return this;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public String toString() {
        if (isSumming){
           return sumString();
        } else {
            return prefix() + data;
        }
    }

    @Override
    public boolean isMAXMIN(DataEqualMessage message){
        return !isSame(message); //|| (MIN - bufferInteger > value);
    }

    @Override
    public String prefix() {
        return "string: ";
    }

    private String sumString(){
        if (counter != 1) {return String.format("%s (x%d)", (String)data,counter);}
        return (String) data;
    }

}
