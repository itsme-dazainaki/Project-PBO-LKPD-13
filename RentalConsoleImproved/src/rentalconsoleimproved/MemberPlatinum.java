/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalconsoleimproved;

/**
 *
 * @author Radaza Putri
 */
public class MemberPlatinum extends MemberGold { //janlupa di extends bestie biar yang sebelumnya bisa masuk
    private int biaya;
    long pulsa;
    double diskon = 0.03;
    int cashback = 10000;
    
    //setter untuk biaya
    @Override
    public void setBiaya(int biaya){
        if(biaya > 0){
            this.biaya = biaya;
        } else {
            this.biaya=0;
        }
    }
    
    @Override
    protected void benefit1(long lama){
        double biayaSewa = biaya * lama;
        double total = biayaSewa - (biayaSewa * diskon);
        System.out.println("Total Sewa           : Rp." + total);
    }
    
    @Override
    protected void benefit2(long lama){
        poin = 10 * lama;
        System.out.println("Jumlah Poin          : " + poin + " poin");
    }
    
    //getter untuk cashback
    @Override
    public int getCashback(){
        return this.cashback;
    }
    
    protected void benefit4(long lama){
        pulsa = 5000*lama;
        System.out.println("Bonus Pulsa          : " + pulsa);
    }
}