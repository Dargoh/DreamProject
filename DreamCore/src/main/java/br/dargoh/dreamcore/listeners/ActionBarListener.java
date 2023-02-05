package br.dargoh.dreamcore.listeners;

import br.dargoh.dreamcore.DreamCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ActionBarListener implements Listener {

    private HashMap<String, Long> last = new HashMap<>();
    private HashMap<String, String> lastInfo = new HashMap<>();

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        if (last.containsKey(p.getName())) {
            long l = last.get(p.getName());
            if (l > System.currentTimeMillis())
                return;
        }

        sendAction(e.getPlayer());

        last.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));
    }

    public void sendAction(Player player){
        new BukkitRunnable() {
            @Override
            public void run() {
                Player p = getTarget(player);

                if (p == null){
                    return;
                }

                if (lastInfo.containsKey(player.getName())) {
                    if (lastInfo.get(player.getName()).equalsIgnoreCase(p.getName())) {
                        return;
                    }
                }

                // Montar um texto de descricao do player target

                // Mandar actionbar para o player

                lastInfo.put(player.getName(), p.getName());

            }
        }.runTaskAsynchronously(DreamCore.PLUGIN);
    }

    public Player getTarget(Player player) {
        assert (player != null);

        Player target = null;
        double targetDistanceSquared = 0.0D;
        double radiusSquared = 6;

        Vector l = player.getEyeLocation().toVector();Vector n = player.getLocation().getDirection().normalize();

        double cos45 = Math.cos(0.7853981633974483D);

        for (Player other : player.getWorld().getPlayers()) {
            if (other != player) {
                if (other.getLocation().distance(player.getLocation()) <= 5) {
                    if ((target == null) || (targetDistanceSquared > other.getLocation().distanceSquared(player.getLocation())))
                    {
                        Vector t = other.getLocation().add(0.0D, 1.0D, 0.0D).toVector().subtract(l);
                        if ((n.clone().crossProduct(t).lengthSquared() < radiusSquared) && (t.normalize().dot(n) >= cos45))
                        {
                            target = other;
                            targetDistanceSquared = target.getLocation().distanceSquared(player.getLocation());
                        }
                    }
                }
            }
        }

        return target;
    }
}
