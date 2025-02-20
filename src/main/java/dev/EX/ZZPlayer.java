package dev.EX;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ZZPlayer {
    Player p;

    public ZZPlayer(Player p) {
        this.p = p;
    }


    public void strikeFakeLB(){
        this.p.getWorld().strikeLightningEffect(p.getLocation());
    }
    public void strikeFakeLB(int count){
        for (int i = 0; i < count; i++) {
            this.p.getWorld().strikeLightningEffect(p.getLocation());
        }
    }

    public boolean isOp(String notOP){
        if(this.p.isOp()){
            return true;
        } else {
            Funcs.sendMsg(this.p, notOP);
            return false;
        }
    }

    public void sendMsg(String msg) {
        this.p.sendMessage(Funcs.colorize(msg));
    }

    public Player findNearestPlayer() {
        Player nearestPlayer = null;
        double nearestDistance = Double.MAX_VALUE;

        for (Player player : Bukkit.getOnlinePlayers()) {
            if(player.getWorld().equals(this.p.getWorld())) {
                double distance = player.getLocation().distance(this.p.getLocation());
                if (distance < nearestDistance) {
                    nearestDistance = distance;
                    nearestPlayer = player;
                }
            }
        }

        return nearestPlayer;
    }

    public void sendSpecialMsg(ChatMessageType type, String msg){
        this.p.spigot().sendMessage(type, new TextComponent(Funcs.colorize(msg)));
    }


}
