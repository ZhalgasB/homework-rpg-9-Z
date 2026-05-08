package com.narxoz.rpg.artifact;

public class WeightReporter implements ArtifactVisitor {

    private int totalWeight = 0;

    @Override
    public void visit(Weapon weapon) {
        totalWeight += weapon.getWeight();
        System.out.println("[Weight] Weapon '" + weapon.getName() + "' weighs " + weapon.getWeight());
    }

    @Override
    public void visit(Potion potion) {
        totalWeight += potion.getWeight();
        System.out.println("[Weight] Potion '" + potion.getName() + "' weighs " + potion.getWeight());
    }

    @Override
    public void visit(Scroll scroll) {
        totalWeight += scroll.getWeight();
        System.out.println("[Weight] Scroll '" + scroll.getName() + "' weighs " + scroll.getWeight());
    }

    @Override
    public void visit(Ring ring) {
        totalWeight += ring.getWeight();
        System.out.println("[Weight] Ring '" + ring.getName() + "' weighs " + ring.getWeight());
    }

    @Override
    public void visit(Armor armor) {
        totalWeight +=armor.getWeight();
        System.out.println("[Weight] Armor '" + armor.getName() + "' weighs " + armor.getWeight());
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}