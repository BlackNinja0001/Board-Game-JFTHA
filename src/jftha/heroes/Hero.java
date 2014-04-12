package jftha.heroes;

import jftha.statchanges.statChangePerTurn;
import jftha.items.*;
import jftha.main.*;
import jftha.spells.*;
import java.util.*;
import java.lang.reflect.Method;
import jftha.statchanges.tempStatChange;

public class Hero {
    // Determines how much damage can be dealt to an enemy through weapons

    private int strength;
    // Determines how many spaces the player can move per turn
    private int agility;
    // Determines how many MP(magic points) the player has, what spells the player can cast,
    // and how much damage can be dealt to an enemy
    private int magic;
    // Determines how much HP(health point) a player has and how much damage a player can endure
    private int defense;
    // Affect all skills by a little bit
    private int luck;
    // Determines how many items a player can hold at any time
    private int storage_space;
    // The items the Hero is currently carrying
    private List<Item> items;
    // The items the Hero was carrying at time of last death
    private List<Item> lostItems;
    // The artifactPieces the Hero is currently carrying
    private List<ArtifactPiece> artifactPieces;
    // Determines how many spells a player is able to cast
    private int spell_slots;
    // The spells the Hero currently knows
    private List<Spell> spells;
    // The spells the Hero knew at time of last death
    private List<Spell> lostSpells;
    // Determined by Defense stat. Also known as health points
    private int maxHP;
    // Health the player currently has
    private int currentHP;
    // Determined by Magic stat. Also known as magic points
    private int maxMP;
    // Magic the player currently has
    private int currentMP;
    // Gold the player currently has
    private int gold;
    // Determines if player is a ghost
    private boolean isGhost = false;
    // Determines if the player had been a ghost and came back
    private boolean wasGhost = false;
    //Helper variable for attackEnemy, watched if Hero was attacked during Attack phase or not
    private boolean wasAttacked;
    //Determined whether someone is completely out of the game or not
    private boolean eliminated;
    //String name of the class
    private String className;
    //Used for certain special abilties
    private int curSpecCooldown, curSpecDuration, maxSpecCooldown, maxSpecDuration;
    //Measures what stat changes happen per turn
    private List<tempStatChange> tempStatChanges;
    private boolean hasPet;
    private SummonPet pet;

    //Constructor
    public Hero() {
        this.strength = 10;
        this.agility = 10;
        this.magic = 10;
        this.defense = 10;
        this.luck = 10;
        this.storage_space = 5;
        this.spell_slots = 2;
        this.maxHP = 60;
        this.currentHP = 60;
        this.maxMP = 30;
        this.currentMP = 30;
        this.items = new ArrayList<>(this.storage_space);
        this.spells = new ArrayList<>(this.spell_slots);
        this.artifactPieces = new ArrayList<>(5);
        this.isGhost = false;
        this.gold = 0;
        this.wasAttacked = false;
        this.eliminated = false;
        this.className = null;
        curSpecCooldown = curSpecDuration = maxSpecCooldown = maxSpecDuration = 0;
        this.tempStatChanges = new ArrayList<>();
        this.hasPet = false;
        pet = new SummonPet();
    }

    //Setter methods
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void setStorageSpace(int storage_space) {
        this.storage_space = storage_space;
    }

    public void setSpellSlots(int spell_slots) {
        this.spell_slots = spell_slots;
    }

    public void setMaxHP(int hp) {
        this.maxHP = hp;
    }

    public void setCurrentHP(int hp) {
        if (hp > maxHP) {
            currentHP = maxHP;
        } else {
            this.currentHP = hp;
        }
    }

    public void setMaxMP(int mp) {
        this.maxMP = mp;
    }

    public void setCurrentMP(int mp) {
        if (mp > maxMP) {
            currentMP = maxMP;
        } else {
            this.currentMP = mp;
        }
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setWasAttacked(boolean jA) {
        this.wasAttacked = jA;
    }

    public void setWasGhost(boolean wasGhost) {
        this.wasGhost = wasGhost;
    }

    public void setEliminated(boolean elim) {
        this.eliminated = elim;
    }

    public void setClassName(String name) {
        this.className = name;
    }

    public void setCurCooldown(int curCooldown) {
        this.curSpecCooldown = curCooldown;
    }

    public void setCurDuration(int curDuration) {
        this.curSpecDuration = curDuration;
    }

    public void setMaxCooldown(int maxCooldown) {
        this.maxSpecCooldown = maxCooldown;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxSpecDuration = maxDuration;
    }

    public void addTSC(tempStatChange tsc) {
        this.tempStatChanges.add(tsc);
    }

    public void removeTSC(tempStatChange tsc) {
        this.tempStatChanges.remove(tsc);
    }

    public void addPet() {
        this.hasPet = true;
        pet.randomizeHealth();
    }

    public void killPet() {
        this.hasPet = false;
        pet.setPetHealth(0);
    }

    //Getter Methods
    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getMagic() {
        return magic;
    }

    public int getDefense() {
        return defense;
    }

    public int getLuck() {
        return luck;
    }

    public int getStorageSpace() {
        return storage_space;
    }

    public int getSpellSlots() {
        return spell_slots;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public int getGold() {
        return gold;
    }

    public boolean getWasAttacked() {
        return wasAttacked;
    }

    public boolean getEliminated() {
        return eliminated;
    }

    public boolean isGhost() {
        return isGhost;
    }

    public boolean getWasGhost() {
        return wasGhost;
    }

    public List<Item> getLostItems() {
        return lostItems;
    }

    public String getClassName() {
        return className;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public List<ArtifactPiece> getArtifacts() {
        return artifactPieces;
    }

    public int getCurCooldown() {
        return curSpecCooldown;
    }

    public int getCurDuration() {
        return curSpecDuration;
    }

    public int getMaxCooldown() {
        return maxSpecCooldown;
    }

    public int getMaxDuration() {
        return maxSpecDuration;
    }

    public List<tempStatChange> getTempStatChanges() {
        return tempStatChanges;
    }

    /**
     * Allows a character to cast a damage inflicting spell at another player.
     *
     * @param spell The spell to be cast.
     * @param enemy The victim of the spell
     */
    public void castSpell(Spell spell, Hero enemy) {
        int spellDmg = spell.getDamage();
        double actualDmg = ((this.getMagic() * .5) + spellDmg + (this.getLuck() * .2))
                - ((enemy.getMagic() * .5) + (enemy.getDefense() * .5) + (enemy.getLuck() * .2));
        int finalDmg = (int) Math.round(actualDmg);
        this.setCurrentMP(this.getCurrentMP() - spell.getmpCost());
        if (finalDmg < 0) {
            finalDmg = 0;
        }
        enemy.setCurrentHP(enemy.getCurrentHP() - finalDmg);
    }

    //self heal spells
    public void castHealSpell(Spell spell) {
        //Damage is the heal amount
        if (spell.getCurrentCD() > 0) {
            int spellEffect = spell.getDamage();
            double actualEffect = ((this.getMagic() * .5) + spellEffect + (this.getLuck() * .2));
            int finalEffect = (int) Math.round(actualEffect);

            this.setCurrentMP(this.getCurrentMP() - spell.getmpCost());
            this.setCurrentHP(this.getCurrentHP() + finalEffect);
        }
    }

    //Self buff spells
    public void castBuffSpell(Spell spell) {
        //Damage is the buff amount
        if (spell.getCurrentCD() > 0) {
            int spellEffect = spell.getDamage();
            double actualEffect = ((this.getMagic() * .5) + spellEffect + (this.getLuck() * .2));
            int finalEffect = (int) Math.round(actualEffect);
            this.setCurrentMP(this.getCurrentMP() - spell.getmpCost());
            this.setDefense(this.getDefense() + finalEffect);
        }

        //need to remove buff after duration is over
    }

    /**
     * Turns a character into a ghost.
     */
    public void makeGhost() {
        this.isGhost = true;
        if (this.currentHP != 0) {
            this.setCurrentHP(0);
        }
        //Regen MP
        this.currentMP = this.maxMP;
        this.lostItems = new ArrayList<>();
        this.lostSpells = new ArrayList<>();
        //Cannot hold items, except spiritual items (see Items).
        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item item = iter.next();
            lostItems.add(item);
            if (!item.getSpiritual()) {
                iter.remove();
            }
        }
        for (Spell sp : spells) {
            lostSpells.add(sp);
        }
        //Can cast only Spectre Shot spell (cost 1 SE).
        this.spells.clear();
        this.spells.add(new SpectreShot()); // spectre shot;

        //If killed again (all of MP depleted), you are eliminated from the game.
        //if(isEliminated = true){ lose turn phase};
        //Note: Only certain items, such as spirit weapons, can drain SE.
    }

    /**
     * Restores a character from ghost state.
     *
     */
    public void unGhost() {
        this.isGhost = false;
        this.wasGhost = true;
        this.currentHP = this.maxHP;
        //ReLearn all spells they knew  //Lose Spectre Shots;
        this.spells = this.lostSpells;

        //If find soulStone(unghost)
    }

    /**
     * Allows a character to attack another character with a weapon and pet and
     * vice-versa
     *
     * @param attacked The character that is getting attacked
     */
    public void attackEnemy(Hero attacked) {
        Random rand = new Random();
        int randomDamage = rand.nextInt(3), 
                amt1 = this.strength - attacked.defense, 
                amt2 = (int)(0.2 * (this.luck - attacked.luck));
        if (amt1 < 0){
            amt1 = 0;
        }
        if (amt2 < 0){
            amt2 = 0;
        }
        double damage = amt1 - amt2 + randomDamage;
        if (this.hasPet) {
            damage += pet.randomizeDamage();
        }
        if (damage < 0) { //attacker sucks
            damage = 0;
        }
        int intDamage = (int) Math.round(damage);

        if ((attacked instanceof Knight) && (attacked.getCurDuration() != 0)) { //watch for Knight's special
            attacked.wasAttacked = !attacked.wasAttacked;
            return;
        }

        if (this.pet.getPetHealth() > 0) {
            this.pet.setPetHealth(this.pet.getPetHealth() - intDamage);
            attacked.wasAttacked = !attacked.wasAttacked;
            return;
        }


        if (attacked.isGhost == false) { //cannot attack ghost unless under certain circumstances
            attacked.currentHP -= intDamage;
            if (attacked.currentHP <= 0) {
                attacked.makeGhost();
            }
            attacked.wasAttacked = !attacked.wasAttacked;
            return;
        } else { //attacking ghost
            //handle spiritual items
            if (!items.isEmpty()) {
                for (Item i : items) {
                    if (i instanceof Equippable) {
                        Equippable eq = (Equippable) i; //cannot use isEquippedOn() right away, must downcast to child class
                        if (eq.isEquippedOn(this) && (eq.getSpiritual())) {
                            attacked.currentMP -= intDamage;
                            if (attacked.currentMP <= 0) {
                                attacked.eliminated = true;
                            }
                            attacked.wasAttacked = !attacked.wasAttacked;
                            return;
                        }
                    }
                }
                //if no spiritual items, the Attack phase is skipped
            }

        }
        if (this.wasAttacked && attacked.wasAttacked) {
            this.wasAttacked = false;
            attacked.wasAttacked = false;
        }
    }

    /**
     * Allows a character to buy an item in the store. This handles the specific
     * buy action. The gold cost of the item is taken from the character's gold
     *
     * @param buy The Buyable item that the player want to purchase
     * @return true if purchase is went through
     */
    public boolean buy(Buyable buy) {
        int currentGold = this.getGold();
        //If character has the gold
        if (this.getGold() >= buy.getGoldCost()) {
            setGold(currentGold - buy.getGoldCost());
            // buy is an Item
            if (buy.getClass().getSuperclass().equals(Item.class)) {
                addItem((Item) buy);
            } // buy is a Spell 
            else if (buy.getClass().getSuperclass().equals(Spell.class)) {
                addSpell((Spell) buy);
            }
            return true;
        }
        return false;
    }

    /**
     * Adds an item to character's inventory. Will only add item if: <\t>1) The
     * character does not already have this item <\t>2) The character has
     * storage space for the item.
     *
     * If the character's inventory is full, character has option to lose an
     * item in exchange for the new one.
     *
     * @param item The item to be added to the character's inventory
     * @return true if item was added
     */
    public boolean addItem(Item item) {
        for (Item i : items) {
            if (i.getClass().equals(item.getClass())) {
                return false;
            }
        }

        if (items.size() < storage_space) {
            if (items.add(item)) {
                return true;
            }
        } else {
            System.out.print("No storage space left. You have: ");
            int i;
            for (i = 0; i < items.size(); i++) {
                System.out.printf("%n%d.  %s", i + 1, items.get(i).getClass().getSimpleName());
            }
            System.out.printf("%nWhich do you want to lose. (%d for none)%n", storage_space + 1);
            Scanner scan = new Scanner(System.in);
            i = scan.nextInt();
            if (i == storage_space + 1) {
                return false;
            } else {
                items.remove(i);
                items.add(i, item);
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a spell to character's spells. Will only add spell if: <\t>1) The
     * character does not already know this spell <\t>2) The character has a
     * spell slot for the spell
     *
     * @param spell Spell to be added to the character
     * @return true if spell was added
     */
    public boolean addSpell(Spell spell) {
        for (Spell s : spells) {
            if (s.getClass().equals(spell.getClass())) {
                return false;
            }
        }
        if (spells.size() < spell_slots) {
            if (spells.add(spell)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes an item to character's inventory. Will only remove item if
     * character already has this item in inventory.
     *
     * Note: Removed by index, not by passing object to ArrayList.remove(Object
     * o), just to be safe.
     *
     * @param item The item to be removed to the character's inventory
     * @return true if item was removed
     */
    public boolean removeItem(Item item) {
        boolean result = false;
        int itemIndex = 0, itemCount = 0;
        if (!this.items.isEmpty()) {
            for (Item i : items) {
                if (i.getClass().isInstance(item)) {
                    itemIndex = itemCount;
                }
                itemCount++;
            }
            if (itemCount != -1) {
                result = true;
                items.remove(itemIndex);
            }
        }
        return result;
    }

    /**
     * Activates the special for this hero.
     */
    public void triggerSpecial() {
        this.setCurCooldown(this.getMaxCooldown());
        this.setCurDuration(this.getMaxDuration());
    }

    /**
     * If this hero has TSCs still occurring, activate their effects for the
     * current turn.
     */
    public void activateTSCs() {
        if (!this.tempStatChanges.isEmpty()) {
            for (tempStatChange scpt : tempStatChanges) {
                scpt.triggerEffect(this);
            }
        }
    }
}
