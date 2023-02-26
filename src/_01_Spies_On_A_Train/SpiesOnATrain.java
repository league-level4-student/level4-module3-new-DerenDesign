package _01_Spies_On_A_Train;

import java.util.ArrayList;
import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	Node<TrainCar> head = train.getHead();
    	Node<TrainCar> tail = train.getTail();
    	Node<TrainCar> current = head;
    	ArrayList<String> PassengerClue = new ArrayList<String>();
    	HashMap<String, Integer> people = new HashMap<String, Integer>();
    	 while (current != null) {
    		 people.put("" + current.getValue(),0);
    		 String out = current.getValue().questionPassenger();
    		 PassengerClue.add(out);
    		 current = current.getNext();
    	 }
    	 for(int i = 0; i < clues.length; i++) {
    		 System.out.println(clues[i]);
    		 for(int j = 0; j < PassengerClue.size(); j++) {
    			 if(PassengerClue.get(j).contains(clues[i])) {
    				 for(String e: people.keySet()) {
    					 if(PassengerClue.get(j).contains(e)) {
    						 people.put(e,people.get(e) + 1);
    					 }
    				 }
    			 }
    		 }
    	 }
    	 for (String e : people.keySet()) {
     		if (people.get(e)==3) {
     			return e;
 			} 
    	 }
        return "";

    }

}

