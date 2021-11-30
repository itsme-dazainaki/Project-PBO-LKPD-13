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
public class MemberSilver {
    //access modifier
    private long biaya = 25000;
    double diskon = 0.01;
    long poin;
    
    //setter untuk biaya
    public void setBiaya(long biaya){
        if(biaya > 0){
            this.biaya = biaya;
        } else {
            this.biaya=0;
        }
    }
    
    protected void benefit1(long lama){
        double biayaSewa = this.biaya * lama;
        double total = biayaSewa - (biayaSewa * diskon);
        System.out.println("Total Sewa           : Rp." + total);
    }
    
    protected void benefit2(long lama){
        poin = 1 * lama;
        System.out.println("Jumlah Poin          : " + poin + " poin");
    }
}