package lotr;

import lombok.AllArgsConstructor;
import lombok.Data;

import lotr.strategy.KickStrategy;

@AllArgsConstructor
@Data
public abstract class Character {
    private int power;
    private int hp;
    private KickStrategy kickStrategy;

    public boolean isAlive() {
        return hp > 0;
    }

    public void setHp(int hp) { 
        this.hp = Math.max(0, hp); 
    }

    public void kick(Character main) {
        kickStrategy.kick(this, main);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{hp=" + hp + ", power=" + power + "}";
    }
}
