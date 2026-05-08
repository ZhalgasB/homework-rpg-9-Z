package com.narxoz.rpg;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.List;

/**
 * Entry point for Homework 9 — Chronomancer's Vault: Visitor + Memento.
 *
 * The scaffold prints the banner only; students fill in the vault demo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        // 1. Create at least 2 heroes with different starting states
        System.out.println("1 heroes: ");
        Hero lelouch = new Hero("Lelouch", 150, 35, 25);
        Hero cc = new Hero("CC", 90, 15, 45, 18, 520, null);

        System.out.println(lelouch);
        System.out.println(cc + "\n");

        // 2. Build an artifact inventory and exercise the visitor interface
        System.out.println("2 artifact inventory...");
        Inventory inventory = buildDemoInventory();

        System.out.println(" visitors: ");
        applyVisitors(inventory);
        System.out.println();

        // 3. Capture a hero snapshot through the memento workflow
        System.out.println("3 Saving hero state(Memento Pattern): ");
        Caretaker caretaker = new Caretaker();
        caretaker.save(lelouch.createMemento());
        System.out.println("Caretaker size: " + caretaker.size() + "\n");

        // 4. Rewind the hero after a vault trap changes state
        System.out.println("4 Simulating vault trap: ");
        lelouch.takeDamage(70);
        System.out.println("Leluoch after trap: " + lelouch);

        System.out.println("\n   Rewinding time using memento: ");
        lelouch.restoreFromMemento(caretaker.undo());
        System.out.println("Lelouch after rewind: " + lelouch + "\n");

        // 5. Run the ChronomancerEngine demo sequence
        System.out.println("5 Running full ChronomancerEngine: ");
        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(lelouch, cc));

        // 6. Print a final VaultRunResult summary
        System.out.println("6 Final Run Result:");
        System.out.println("   " + result);

        System.out.println(" DEMO COMPLETED SUCCESSFULLY ");
    }

    private static Inventory buildDemoInventory() {
        Inventory inventory = new Inventory();
        inventory.addArtifact(new Weapon("Dragon Slayer", 120, 8, 25));
        inventory.addArtifact(new Potion("Elixir of Life", 80, 2, 50));
        inventory.addArtifact(new Scroll("Fireball Scroll", 150, 1, "Fireball"));
        inventory.addArtifact(new Ring("Ring of Power", 200, 1, 15));
        inventory.addArtifact(new Armor("Plate of Eternity", 180, 12, 30));
        inventory.addArtifact(new Potion("Minor Healing Potion", 45, 2, 25));
        return inventory;
    }


    private static void applyVisitors(Inventory inventory) {
        // Visitor 1
        GoldAppraiser goldAppraiser = new GoldAppraiser();
        inventory.accept(goldAppraiser);
        System.out.println("Total value: " + goldAppraiser.getTotalValue() +" gold");

        // Visitor 2
        EnchantmentScanner scanner = new EnchantmentScanner();
        inventory.accept(scanner);

        // Visitor 3
        CurseDetector curseDetector = new CurseDetector();
        inventory.accept(curseDetector);
        System.out.println("Cursed items detected: " +curseDetector.getCursedCount());

        // Visitor 4 (Open/Closed demonstration)
        WeightReporter weightReporter = new WeightReporter();
        inventory.accept(weightReporter);
        System.out.println("Total weight: " + weightReporter.getTotalWeight() + " units");
    }
}
