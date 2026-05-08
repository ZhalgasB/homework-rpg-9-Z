package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println("[Enchant] Weapon '" + weapon.getName() +
                "' has strong attack aura " + weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("[Enchant] Potion '" + potion.getName() +
                "' contains powerful healing magic " + potion.getHealing() + " HP");
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("[Enchant] Scroll '" + scroll.getName() +
                "' contains ancient spell: " + scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("[Enchant] Ring '" + ring.getName() +
                "' radiates strong magic " + ring.getMagicBonus() );
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("[Enchant] Armor '" + armor.getName() +
                "' is reinforced with protective runes " + armor.getDefenseBonus());
    }
}