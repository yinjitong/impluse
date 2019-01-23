package com.msp.impulse.constants;

public interface Constants {
    //监测类别
    enum  MonitorType{
        TYPE_ONE("类别1", 0),
        TYPE_TWO("类别2", 1);

        private MonitorType(String name, int value){
            this.name = name;
            this.value = value;
        }
        String name;
        int value;

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }



}
