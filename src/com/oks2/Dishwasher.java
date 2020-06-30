package com.oks2;

public class Dishwasher{
        public static void main(String[] args) {
            Dishwasher dis = new Dishwasher(18);
    }
    int volume;
    int amount;
    Status state;

    /**
     * Constructor of the class Dishwasher
     * @param cnt max volume
     * @return
     */
    public Dishwasher(int cnt){
        if(cnt>0){
            volume = cnt;
            state = Status.READY;
            amount = 0;
        }else{
            try {
                throw new ArithmeticException("Volume must be more than 0");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Puts one dish to Dishwasher
     * @param
     * @return amount of dishes in Dishwasher
     */
    public int putInOneDish(){
        if(state == Status.READY && amount < volume){
            ++amount;
        }
        return amount;
    }

    /**
     * Remove all dishes out of the dishwasher
     * @param
     * @return
     */
    public void removeDishes(){
        if(state == Status.STOPP){
            amount = 0;
            state = Status.READY;
        }
    }

    /**
     * Start of Dishwasher
     * @param
     * @return
     */
    public void start () throws DishwasherBusyException {
        if(amount!= 0 && state == Status.READY){
            state = Status.BUSY;
        } else {
            throw new DishwasherBusyException("Dishwasher cannot be started! It is already busy");
        }
    }

    /**
     * Stop of Dishwasher
     * @param
     * @return
     */
    public void stop(){
        if(state == Status.BUSY){
            state = Status.STOPP;
        }
    }
}