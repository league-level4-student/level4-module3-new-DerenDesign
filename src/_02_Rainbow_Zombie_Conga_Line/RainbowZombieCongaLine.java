package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	Node<Zombie> Newhead = new Node<Zombie>(dancer);
    	Node<Zombie> Oldhead = congaLine.getHead();
    	if(Oldhead == null) {
    		congaLine.add(dancer);
    	}
    	else {
    	Oldhead.setPrev(Newhead);
    	Newhead.setNext(Oldhead);
    	congaLine.setHead(Newhead);
    	}
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	Node<Zombie> tail = new Node<Zombie>(dancer);
    	congaLine.size();
    	congaLine.add(dancer);
    	
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	LinkedList<Zombie> conga = new LinkedList<Zombie>();
    	for(int i = 0; i < congaLine.size(); i++) {
    		if(i == position) {
    			conga.add(dancer);
    		}
    		Zombie head = congaLine.getHead().getValue();
    		conga.add(head);
    		congaLine.remove(0);
    	}
    	congaLine = conga;
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	dancer.getZombieHatColor();
    	Zombie head = congaLine.getHead().getValue();
    	int pos = 0;
    	while(congaLine.getHead().getNext() != null) {
    		pos = pos+1;
    		if(dancer.getZombieHatColor().equals(congaLine.getHead().getValue().getZombieHatColor())) {
    			congaLine.remove(pos);
    		}
    	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	int pos = 0;
    	boolean done = true;
    	while(congaLine.getHead().getNext() != null && done) {
    		pos = pos+1;
    		if(dancer.getZombieHatColor().equals(congaLine.getHead().getValue().getZombieHatColor())) {
    			congaLine.remove(pos);
    			done = false;
    		}
    	}
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	int mid = (congaLine.size() /2);
    	boolean done = true;
    	ZombieHatColor z = dancer.getZombieHatColor();
    	Zombie zom = new Zombie(z);
    	Zombie zom2 = new Zombie(z);
    	engine(zom);
    	caboose(zom2);
    	congaLine.add(dancer);
    	jumpInTheLine(dancer, mid);
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	int mid = (congaLine.size() /2);
    	boolean done = true;
    	engine(dancer);
    	caboose(dancer);
    	congaLine.add(dancer);
    	jumpInTheLine(dancer, mid);
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
