package practice_20;


public class practice_07 {


    public static double powerMethods(int base,int power){
        double result=1;
        if(power==0){
            return 1;
        }else if(base==0){
            return 0;
        }else if(power <0){
            power=-power;
            for(int i=0;i<power;i++){
                result*=base;
            }
            return 1/result;
        }else{
            for(int i=0;i<power;i++){
                result*=base;
            }
            return result;
        }
    }

    public static void main(String [] args){
        System.out.println(powerMethods(2,5));
    }
}
