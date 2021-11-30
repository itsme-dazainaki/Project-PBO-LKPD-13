/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalconsoleimproved;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Radaza Putri
 */
public class RentalConsoleImproved {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ini buat atribut
        String id;
        
        //objek beserta tetekbengeknya
        WaktuSewa time = new WaktuSewa();
        DataMember data = new DataMember();
        Scanner input = new Scanner(System.in);
        DateTimeFormatter datetimeformat = DateTimeFormatter.BASIC_ISO_DATE;
        
        //array list data member
        data.tambahMember(new member ("M001", "Radaza","Silver"));
        data.tambahMember(new member ("M002", "Putri","Gold"));
        data.tambahMember(new member ("M003", "Hanaki","Platinum"));
        
        //input dari program
        System.out.println("+---------- Persewaan Console Game ----------+");
        System.out.print("Masukkan ID Member : ");
        id = input.nextLine();
        time.pinjam();
        time.kembali();
        
        //output program 
        
       //untuk mencari member
       data.cariMember(id.toUpperCase());
       
       //untuk menampilkan data waktu peminjaman
       LocalDate pinjam = LocalDate.of(time.thnpinjam, time.blnpinjam, time.tglpinjam);
       String FormatPinjam = pinjam.format(datetimeformat);
       LocalDate parsedPinjam = LocalDate.parse(FormatPinjam, datetimeformat);
       
       //untuk menampilkan data waktu pengembalian
       LocalDate kembali = LocalDate.of(time.thnkembali, time.blnkembali, time.tglkembali);
       String FormatKembali = kembali.format(datetimeformat);
       LocalDate parsedKembali = LocalDate.parse(FormatKembali, datetimeformat);
       
       //menghitung waktu sewa dalam hari
       long LamaWaktu = ChronoUnit.DAYS.between(pinjam, kembali);
       
       System.out.println();
       System.out.println("+-------------- Detal Waktu Sewa -------------+");
       System.out.println("Tanggal Peminjaman   : " + parsedPinjam);
       System.out.println("Tanggal Pengembalian : " + parsedKembali);
       System.out.println("Lama Waktu Sewa      : " + LamaWaktu + " hari");
       
       //menghitung detail transaksi yang terjadi
       System.out.println();
       System.out.println("+------- Detail Transaksi Pengembalian -------+");
       int index = -1;
       for(int i = 0; i < data.dataMember.size(); i++){
           if(data.dataMember.get(i).idMember.equals(id)){
               index = 1;
               switch (data.dataMember.get(i).jenisMember){
                    case "Silver":
                        MemberSilver silver = new MemberSilver();
                        silver.setBiaya(25000);
                        silver.benefit1(LamaWaktu);
                        silver.benefit2(LamaWaktu);
                        break;
                    
                    case "Gold":
                        MemberGold gold = new MemberGold();
                        gold.setBiaya(30000);
                        gold.benefit1(LamaWaktu);
                        gold.benefit2(LamaWaktu);
                        System.out.println("Jumlah CashBack      : Rp." + gold.getCashback());
                        break;
                        
                    case "Platinum":
                        MemberPlatinum platinum = new MemberPlatinum();
                        platinum.setBiaya(45000);
                        platinum.benefit1(LamaWaktu);
                        platinum.benefit2(LamaWaktu);
                        platinum.benefit4(LamaWaktu);
                        System.out.println("Jumlah CashBack      : Rp." + platinum.getCashback());
                        break;
                        
                    default:
                        System.out.println("Maaf ! Data Tidak ditemukan");
                        break;
               }                          
           }
       }
    }
    
}