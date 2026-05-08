package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;

import java.util.List;

/**
 * Orchestrates the Chronomancer's Vault demo run.
 */
public class ChronomancerEngine {

    /**
     * Runs the vault sequence for the supplied party.
     *
     * @param party the heroes entering the vault
     * @return a placeholder result in the scaffold
     */
    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("RUN STARTS\n");

        if (party.isEmpty()) return new VaultRunResult(0, 0, 0);

        Hero hero = party.get(0);

        Inventory inventory = new Inventory();
        inventory.addArtifact(new Weapon("Dragon Slayer", 120, 8, 25));
        inventory.addArtifact(new Potion("Elixir of Life", 80, 2, 50));
        inventory.addArtifact(new Scroll("Fireball Scroll", 150, 1, "Fireball"));
        inventory.addArtifact(new Ring("Ring of Power", 200, 1, 15));
        inventory.addArtifact(new Armor("Plate of Eternity", 180, 12, 30));
        inventory.addArtifact(new Potion("Minor Healing", 40, 2, 20));

        hero.setInventory(inventory);

        System.out.println("ARTIFACT APPRAISAL BEGINS");


        GoldAppraiser appraiser = new GoldAppraiser();
        inventory.accept(appraiser);
        System.out.println("Total value by GoldAppraiser: " +appraiser.getTotalValue() + " gold\n");

        EnchantmentScanner scanner = new EnchantmentScanner();
        inventory.accept(scanner);

        CurseDetector detector = new CurseDetector();
        inventory.accept(detector);
        System.out.println("Cursed items found: "+detector.getCursedCount() + "\n");


        WeightReporter weightReporter = new WeightReporter();
        inventory.accept(weightReporter);
        System.out.println("Total weight: " + weightReporter.getTotalWeight() +" units\n");


        System.out.println("SAVING HERO STATE (MEMENTO)");
        Caretaker caretaker = new Caretaker();
        caretaker.save(hero.createMemento());


        System.out.println("VAULT TRAP ACTIVATED!");
        hero.takeDamage(45);
        System.out.println("Hero after trap: " + hero);


        System.out.println("CHRONOMANCER REWINDS TIME ");
        HeroMemento memento = caretaker.undo();
        hero.restoreFromMemento(memento);
        System.out.println("Hero restored: "+ hero);

        System.out.println("RUN COMPLETED");

        return new VaultRunResult(6, 1, 1);
    }
}
