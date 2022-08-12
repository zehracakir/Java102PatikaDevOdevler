package FixtureBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TeamsController {
    List<String> list = new LinkedList<>();


    public void ligFixture() {

        
        if (list.size() % 2 != 0) {
            list.add("Bay");
        }

        if (list.size() != 0) {
            System.out.println("the teams");
            for (String a : list) {
                System.out.println("-" + a);
            }


        } else {
            System.out.println("no teams");
        }
        System.out.println();
        round();

    }


    private void round() {

        List<String> listWeek = new LinkedList<>();


        int rount = 2 * (list.size() - 1);



        List<String> backUpList = new LinkedList<>(list);


        int value = (list.size() / 2);




        for (int i = 1; i < rount / 2 + 1; i++) {

            for (int k = 0; k <= value + 2; k += 2) {
                listWeek.add(backUpList.get(k) + " " + backUpList.get(k + 1));
            }



         backUpList.add(1, backUpList.get(value));
         backUpList.add(value, backUpList.get (backUpList.size() - 1));
         backUpList.remove(backUpList.size() - 1);
         backUpList.remove (backUpList.size() - 2);

        }

       

        for (int i = rount / 2 + 2; i <= rount + 1; i++) {
            for (int k = 0; k <= value + 2; k += 2) {
                listWeek.add (backUpList.get(k + 1) + " " + backUpList.get(k));
            }


         backUpList.add(1, backUpList.get(value));
         backUpList.add(value, backUpList.get (backUpList.size() - 1));
         backUpList.remove (backUpList.size() - 1);
         backUpList.remove (backUpList.size() - 2);
        }

        int count = 0;
        int num;



        for (int i = 1; i <= rount; i++) {

            System.out.println("***** " + i+" *****");

            List<String> backup = new LinkedList<>();
            
            for (int n = count; n < count + value; n++) {

                backup.add(listWeek.get(n));

            }

            for (int m = 0; m < value; m++) {

                num = new Random().nextInt(backup.size());
                System.out.println(backup.get(num));
                backup.remove(num);


            }


            count += value;

        }


    }

}