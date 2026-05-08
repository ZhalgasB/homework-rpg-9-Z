package com.narxoz.rpg.artifact;

/**
 * Detects cursed or dangerous artifacts.
 */
public class CurseDetector implements ArtifactVisitor {

    private int cursedCount = 0;

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus()> 20) {
            System.out.println("[CURSE] Weapon '" + weapon.getName() + " radiates dark energy!");
            cursedCount++;
        } else {
            System.out.println("[CURSE] Weapon '" + weapon.getName() + " is clean.");
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() >40) {
            System.out.println("[CURSE] Potion '" + potion.getName() + " might be corrupted...");
            cursedCount++;
        } else {
            System.out.println("[CURSE] Potion '" + potion.getName() + "is safe.");
        }
    }

    @Override
    public void visit(Scroll scroll) {
        if (scroll.getSpellName().toLowerCase().contains("fire") ||
                scroll.getSpellName().toLowerCase().contains("death")) {
            System.out.println("[CURSE] Scroll '" + scroll.getName() + " contains forbidden magic!");
            cursedCount++;
        } else {
            System.out.println("[CURSE] Scroll '" + scroll.getName() + " is safe.");
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus()> 12) {
            System.out.println("[CURSE] Ring '" + ring.getName() + "' is cursed with overwhelming power!");
            cursedCount++;
        } else {
            System.out.println("[CURSE] Ring '" + ring.getName() + "' is clean.");
        }
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("[CURSE] Armor '" + armor.getName() + "' appears blessed.");
    }

    public int getCursedCount() {
        return cursedCount;
    }
}