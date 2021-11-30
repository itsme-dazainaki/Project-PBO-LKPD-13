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
public class MemberGold extends MemberSilver{ //janlupa di extends bestie biar yang sebelumnya bisa masuk
    //access modifier
    private int biaya;
    private int cashback = 5000;
    double diskon = 0.02;
    
    //setter untuk biaya
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
        poin = 5 * lama;
        System.out.println("Jumlah Poin          : " + poin + " poin");
    }
    
    //getter untuk cashback
    public int getCashback(){
        return this.cashback;
    }
}
