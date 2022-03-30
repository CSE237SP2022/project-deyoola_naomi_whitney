package mainfolder;

import java.util.Scanner;


public class MainBearFunction{
  public static void main(String args[]) {
    System.out.println("Select the following items from the mobile menu:");
    System.out.println("1: Classic Logo Long Sleeved Tee");
    System.out.println("2: WashU Crop Hood");
    System.out.println("3: Nike Tri-Blend Fleece Jogger");
    System.out.println("4: Nike Sleeveless Dri-Fit Tank");
    System.out.println("5: School of Law Womens ¼ Zip");

Scanner selectedItem = new Scanner(System.in);
System.out.println();

int theSelection = 0;

    while(theSelection < 1 || theSelection > 5){

            System.out.println("Select \"1\", \"2\", \"3\"",\"4\",\"5\"");
            if(selectedItem.hasNextInt())
            theSelection = selectedItem.nextInt();

    }

     switch(theSelection){
        case 1:
           System.out.println("Classic Logo Long Sleeved Tee, $22.99, Classic Collegiate Logo makes this Tee a student favorite. Do you want to select this item and add it to your order?");
           break;
        case 2:
           System.out.println("WashU Crop Hood, $39.99, NEW! Cropped silhouette, raw hem, drawstring hood. Do you want to select this item and add it to your order?");
           break;
        case 3:
           System.out.println("Nike Tri-Blend Fleece Jogger, $59.99, Brushed back tri-blend fabric is soft & comfy. Pockets & rib ankle cuffs make this a perfect jogger, for campus or gym! Imprinted logo. Would you like to place order?");
           break;
        case 4:
           System.out.println("Nike Sleeveless Dri-Fit Tank, $29.99,  Nike Legend sleeveless tank, great for any workout! Would you like to place order?");
           break;
        case 5:
           System.out.println("School of Law Womens ¼ Zip, $64.99,  Official Law School logo is embroidered on this Charles River 1/4 zip.  100% polyester yarn dyed knit has a heathered appearance, and is brushed on the inside for amazing softness. It features a stand up collar lined with brushed tricot for softness. Flattering princess seams and comfortable elastic binding at the cuffs, hem and front pockets. Would you like to place order?");
           break;      
   }
  }
}