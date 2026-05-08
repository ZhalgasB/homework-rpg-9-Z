package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue =0;

    @Override
    public void visit(Weapon weapon) {
        int val = weapon.getValue() + weapon.getAttackBonus() * 3;
        totalValue += val;
        System.out.println("[Gold] Weapon '" + weapon.getName() + "  " + val);
    }

    @Override
    public void visit(Potion potion) {
        int val = potion.getValue() + potion.getHealing() * 2;
        totalValue += val;
        System.out.println("[Gold] Potion '" + potion.getName() + " " + val);
    }

    @Override
    public void visit(Scroll scroll) {
        totalValue += scroll.getValue() + 50;
        System.out.println("[Gold] Scroll '" + scroll.getName() + " " + (scroll.getValue() + 50));
    }

    @Override
    public void visit(Ring ring) {
        totalValue += ring.getValue() + ring.getMagicBonus() * 4;
        System.out.println("Gold] Ring '" + ring.getName() + " " + (ring.getValue() + ring.getMagicBonus() * 4));
    }

    @Override
    public void visit(Armor armor) {
        totalValue +=armor.getValue() + armor.getDefenseBonus() * 3;
        System.out.println("[Gold] Armor '" + armor.getName() + " " + (armor.getValue() + armor.getDefenseBonus() * 3));
    }

    public int getTotalValue() {
        return totalValue;
    }
}