package jftha.spells;

public class HPMPDrain extends Spell{

    public HPMPDrain() {
        this.setMaxDuration(5);
        this.setmpCost(15);
    }
    
    //Saps 1-5 HP/MP per turn (saps when whomever the spell was cast on begins turn)
}
