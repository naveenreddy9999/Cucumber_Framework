package practice;

public class singleton {

    private static  singleton singleTon = null;

    private singleton(){}

    public static singleton getInstance(){
        if(singleTon == null){
            singleTon = new singleton();
        }
        return singleTon;
    }



}
