package dev.EX;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Funcs {

    public static void sendMsg(CommandSender sender, String msg) {
        sender.sendMessage(colorize(msg));
    }

    public static void sendAll(String msg) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            sendMsg(p, msg);
        }

    }

    public static void sendAllPlus(JavaPlugin jp, String msg) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            sendMsg(p, msg);
        }

        // ПОТОМУ ЧТО КОСНОЛЬ ЕБАНАЯ КОЛОРАЙЗ НЕ САППОРТИТ

        jp.getLogger().info(msg.replaceAll("&.", ""));

    }

    public static String colorize(String msg) {
        msg = msg.replaceAll("<aqua>", "&b").replaceAll("<red>", "&c").replaceAll("<green>", "&a").replaceAll("<yellow>", "&e").replaceAll("<blue>", "&9").replaceAll("<pink>", "&d").replaceAll("<black>", "&0").replaceAll("<white>", "&f").replaceAll("<gray>", "&7").replaceAll("<darkgray>", "&8").replaceAll("<gold>", "&6").replaceAll("<purple>", "&5").replaceAll("<darkred>", "&4").replaceAll("<darkblue>", "&1").replaceAll("<darkgreen>", "&2").replaceAll("<darkaqua>", "&3");
        msg = msg.replaceAll("<reset>", "&r").replaceAll("<bold>", "&l").replaceAll("<italic>", "&o").replaceAll("<underline>", "&n").replaceAll("<strike>", "&m").replaceAll("<magic>", "&k");
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    public static void atEnable(JavaPlugin jp, String log) {
        jp.getLogger().info(log+" Enabled");
        jp.getLogger().info("Developed by BM");
    }



    public static boolean equal(String text1, String text2){
        return text1.equalsIgnoreCase(text2);
    }

//    public static boolean isMsgReload(String[] args, JavaPlugin jp){
//        if (args.length==1 && eIC(args[0],"reload")){
//            jp.reloadConfig();
//            return true;
//        } else {
//            return false;
//        }
//    }
//    public static boolean isMsgReload(String[] args, JavaPlugin jp, int index){
//        if (args.length==index+1 && eIC(args[index],"reload")){
//            jp.reloadConfig();
//            return true;
//        } else {
//            return false;
//        }
//    }

    public static boolean itIs(String[] args, int index, String text){
       // if (args.length==index+1 && eIC(args[index],text)){
        if (equal(args[index],text)){
            return true;
        } else {
            return false;
        }
    }
    public static boolean itIs(String[] args, int index, String text, int length){
       if (args.length==length && equal(args[index],text)){
            return true;
        } else {
            return false;
        }
    }

    public static Player findNearestPlayer(Location location) {
        Player nearestPlayer = null;
        double nearestDistance = Double.MAX_VALUE;

        for (Player player : Bukkit.getOnlinePlayers()) {
            if(player.getWorld().equals(location.getWorld())) {
                double distance = player.getLocation().distance(location);
                if (distance < nearestDistance) {
                    nearestDistance = distance;
                    nearestPlayer = player;
                }
            }
        }

        return nearestPlayer;
    }

    public static void setupCfg(JavaPlugin jp){
        jp.getConfig().options().copyDefaults();
        jp.saveDefaultConfig();
    }



//    public static void regCommands(JavaPlugin jp, CommandExecutor ce) {
//        String fullPath = ce.toString().substring(0, ce.toString().length() - 9);
//        String[] parts = fullPath.split("\\.");
//        for (String part : parts) {
//            //Funcs.sendMsg(p, part);
//            if (part.endsWith("CMD")) {
//                jp.getCommand(part.substring(0, part.length() - 3)).setExecutor(ce);
//                break;
//            }
//        }
//    }

    public static void regCommands(JavaPlugin jp, String command, CommandExecutor ce) {
        jp.getCommand(command).setExecutor(ce);
    }

    public static void regEvent(JavaPlugin jp, Listener listener) {
        jp.getServer().getPluginManager().registerEvents(listener, jp);
    }


    public static boolean toggleBoolean(boolean bool) {
        return !bool;
    }








//        Class<?> cls = Class.forName(command+"CMD");
//        Object obj = cls.newInstance();
//        jp.getCommand(command).setExecutor((CommandExecutor) obj);









}
