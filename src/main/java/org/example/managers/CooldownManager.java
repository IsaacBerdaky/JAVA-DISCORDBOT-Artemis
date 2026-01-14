package org.example.managers;
import java.util.HashMap;


public class CooldownManager {
    private final HashMap<String, Long> cooldowns = new HashMap<>();
    private final long COOLDOWN_MS;

    public CooldownManager(int cooldownSeconds) {
        this.COOLDOWN_MS = cooldownSeconds * 1000L;
    }

    public boolean canUse(String userId) {
        long now = System.currentTimeMillis();

        if (!cooldowns.containsKey(userId)) {
            cooldowns.put(userId, now);
            return true;
        }

        long lastTime = cooldowns.get(userId);
        if (now - lastTime >= COOLDOWN_MS) {
            cooldowns.put(userId, now);
            return true;
        }

        return false;
    }

    public long timeLeft(String userId) {
        if (!cooldowns.containsKey(userId)) return 0;
        long now = System.currentTimeMillis();
        long diff = COOLDOWN_MS - (now - cooldowns.get(userId));
        return Math.max(diff / 1000, 0);
    }
}


