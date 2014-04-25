package jftha.spells;

public class HPMPDrain extends Spell{

    /**
     * Constructor
     */
    public HPMPDrain() {
        this.setGoldCost(10);
        this.setMaxDuration(5);
        this.setmpCost(15);
        this.setMessage("HP/MP Drain. Absorb HP/MP from enemy player for 5 turns. Cost " + this.getmpCost() + "MP");
    }
    
    //Saps 1-5 HP/MP per turn (saps when whomever the spell was cast on begins turn)
}
