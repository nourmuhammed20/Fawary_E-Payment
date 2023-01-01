package com.fawary.Fawary.controllers.ServiceProviders;

public class ServiceController {
    public static String ServiceName;


    public static String ServiceProvider;
    static double ServiceCharge;
    boolean AccCash;
    public ServiceController(){}

    public boolean isAccCash() {
        return AccCash;
    }
    public void setAccCash(boolean accCash) {
        AccCash = accCash;
    }
    public ServiceController(String s ,double c, String sp){
        setServiceName(s);
        setServiceProvider(sp);
        setServiceCharge(c);
    }
    public  String getServiceName(){
        return ServiceName;
    }

    public static void setServiceProvider(String serviceProvider) {
        ServiceProvider = serviceProvider;
    }
    public  String getServiceProvider() {
        return ServiceProvider;
    }

    public static void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }
    public static void setServiceCharge(double serviceCharge) {
        ServiceCharge = serviceCharge;
    }
}
