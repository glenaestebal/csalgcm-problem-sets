import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Umbrella {

    public class Solution {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            long numZombie = sc.nextLong();
            int queries = sc.nextInt();

            // two arraylists, one for the current query, one for backup for any future queries
            ArrayList<Long> HPZombie = new ArrayList<>();
            ArrayList<Long> copyHPZombie = new ArrayList<>();

            // inputs for each query
            long stun;
            long clip;
            long zoAttack;
            long thres;
            long zoDa;
            long result;

            for (int i = 0; i < numZombie; i++)
                HPZombie.add(sc.nextLong());

            // sorted so that we can take out the zombie with lowest HP
            Collections.sort(HPZombie);
            copyHPZombie.addAll(HPZombie);

            // number of queries
            for (int i = 0; i < queries; i++) {
                stun = sc.nextLong();
                clip = sc.nextLong();
                zoAttack = sc.nextLong();
                thres = sc.nextLong();
                zoDa = sc.nextLong();

                // main calculation method
                result = game(HPZombie, stun, clip, zoAttack, thres, zoDa);

                // if HP exceeds 1000
                if (result == -1)
                    System.out.println("You're gonna need a flashbang.");

                    // print if not
                else
                    System.out.println(result);

                // if there's an upcoming query, then prepare next batch of zombies
                if (i != queries - 1) {
                    HPZombie.clear();
                    HPZombie.addAll(copyHPZombie);
                }

            }
        }


        // shooty shoot method
        public static long shoot(ArrayList<Long> HPZombie, long currentClip, long stun) {

            long damage;
            // number of stunned zombies
            long noStun = 0;
            while (currentClip > 0 && HPZombie.size() != 0) {
                // calculates leftover hp for zombie
                damage = HPZombie.get(0) - currentClip;

                // remove bullets
                currentClip -= HPZombie.get(0);

                HPZombie.set(0, damage);

                // zombie has been unalived
                if (HPZombie.get(0) <= 0)
                    HPZombie.remove(0);

                else {
                    // damage meets stun threshold
                    if (Math.abs(damage) >= stun)
                        noStun++;
                }
            }
            return noStun;
        }

        // literally the main game
        public static long game(ArrayList<Long> HPZombie, long stun, long clip, long zoAttack, long thres, long zoDa) {
            // hp
            long HP = 1;
            // bullets on hand
            long currentClip = clip;
            // number of not stunned zombies
            long noStunZo;
            // number of stunned zombies
            long stunnedZo = 0;

            long tenFive = 100000;

            // leon got the vaccine
            boolean goal = false;

            // while hp hasn't met 1000
            while (HP < tenFive) {
                // zombies still on-field
                if (HPZombie.size() != 0) {
                    // reload
                    if (currentClip == 0)
                        currentClip = clip;

                        // shoot
                    else {
                        stunnedZo = shoot(HPZombie, currentClip, stun);
                        currentClip = 0;
                    }
                }

                noStunZo = HPZombie.size() - stunnedZo;

                // number of stunned zombies is less than threshold
                if (noStunZo < thres) {

                    HP += (Math.min(noStunZo, zoAttack) * zoDa);


                    if (goal) {
                        if (HP < tenFive)
                            return HP;
                        else
                            return -1;
                    } else
                        goal = true;

                } else
                    HP += (Math.min(noStunZo, zoAttack) * Math.floor(zoDa / 2));
                stunnedZo = 0;

            }
            return -1;

        }
    }
}