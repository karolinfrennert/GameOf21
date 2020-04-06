import javax.sound.midi.Soundbank;

import java.util.Scanner;

public class GameOf21 {

    public static void main (String[] args) {

        System.out.println("Välkommen till 21!");

        // Skapar leken som vi spelar med
        Kortlek spelLek = new Kortlek();
        spelLek.skapaKortlek();
        spelLek.shuffle();
        // SKapar korten som spelaren använder
        Kortlek spelarKort = new Kortlek();
        //Skapar dealerns kortlek
        Kortlek dealerKort = new Kortlek();

        Scanner userInput = new Scanner(System.in);


        boolean avsluta = false;
        //Spelaren får sitt kort
        spelarKort.dra(spelLek);
        //Dealern får sitt kort
        dealerKort.dra(spelLek);



        while (true) {
            System.out.println("Din hand: " + spelarKort.toString() );
            System.out.println("Värde: " + spelarKort.kortVärde());
            System.out.println("Dealerns hand: " + dealerKort.toString());
            System.out.println("Värde " + dealerKort.kortVärde());


            //Vad vill man göra med handen
            System.out.println("Vill du fortsätta (1) eller avsluta (2)?");
            int response =userInput.nextInt();

            if(response == 1) {
                spelarKort.dra(spelLek);
                System.out.println(" Du drog en " + spelarKort.getKort(spelarKort.deckSize() - 1).toString());
               //OM man får mer än 21 så förlorar man
                if (spelarKort.kortVärde() > 21) {
                    System.out.println("Du fick över 21. Du förlorar");
                    avsluta = true;
                    break;
                }
                //Om delerns kort har värdet som är mindre än 17 eller 17 så ska dealern dra kort
                if (dealerKort.kortVärde()<=17 ){
                    System.out.println(" Dealerns kort är " + dealerKort.getKort(dealerKort.deckSize() - 1).toString());
                }



                   if ((dealerKort.kortVärde() <= 17) && avsluta == false) {
                        dealerKort.dra(spelLek);
                        System.out.println("Dealern drar " + dealerKort.getKort(dealerKort.deckSize() - 1).toString());
                        avsluta = true;}

                   else if ((dealerKort.kortVärde() <= 17) && avsluta == true) {
                       dealerKort.dra(spelLek);
                       System.out.println("Dealern drar " + dealerKort.getKort(dealerKort.deckSize()-1).toString());
                        //Om delern får mer än 21 så förlorar den
                       if(dealerKort.kortVärde() > 21){
                           System.out.println("Dealern fick över 21, dealern förlorar");
                           break;
                       }

                   }
            }

        //Om spelaren får 21 så vinner den
                    if((spelarKort.kortVärde() == 21)) {
                        System.out.println("Du fick 21! Grattis du vinner!");
                        break;
                    }
//Om man vill avsluta spelet så måste man fortfarande kolla värderna på de olika korten
                    if (response ==2 ) {
                        boolean keepGoing = true;
                        while (keepGoing){
                            //Om man vill avsluta och dealern fortfarande har under 17 så drar man kort till delern har 17 eller mer
                            if (dealerKort.kortVärde() < spelarKort.kortVärde() && dealerKort.kortVärde() <= 17 ) {
                                dealerKort.dra(spelLek);
                                System.out.println("Dealern drog " + dealerKort.getKort(dealerKort.deckSize() - 1).toString());
                                keepGoing = false;
                            }
                            
                            if (dealerKort.kortVärde()> spelarKort.kortVärde()&& dealerKort.kortVärde() <= 21 || dealerKort.kortVärde() == spelarKort.kortVärde()) {
                                System.out.println("Du förlorar");
                                keepGoing = false;
                            }

                            if (dealerKort.kortVärde () < spelarKort.kortVärde () && dealerKort.kortVärde() <= 21 || dealerKort.kortVärde() > 21){
                                System.out.println("Grattis du vinner");
                                keepGoing = false;
                            }
                        }

                        System.out.println("Dealerns värde är " + dealerKort.kortVärde () + " Ditt värde " + spelarKort.kortVärde ());

                        break;
                    }



            System.out.println("Dealerns kort har värdet " + dealerKort.kortVärde());
            if((dealerKort.kortVärde() > 21) && avsluta == false){
                System.out.println("Dealern förlorar. Du vinner");
                avsluta = true;
                break;
            }

            if((spelarKort.kortVärde()== dealerKort.kortVärde()) && avsluta == false){
                System.out.println("Samma nummer. Du förlorar, dealern vinner");
                avsluta = true;
                break;
            }

            if ((spelarKort.kortVärde() > dealerKort.kortVärde()) && avsluta == false){
                System.out.println("Du vinner eftersom du hade " + spelarKort.kortVärde());
                avsluta = true;
                break; }

                if (dealerKort.kortVärde() == 21){
                    System.out.println("Dealern vinner");
                }
            }


            }}


















