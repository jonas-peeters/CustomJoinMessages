package de.YottaFLOPS.CJM;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

public class Main extends JavaPlugin {

    String opjoin = null;
    String nmjoin = null;
    String opleave = null;
    String nmleave = null;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
        loadConfig();
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = getServer().getPlayer(cs.getName());
        if(cs.isOp()) {
            if(cmd.getName().equalsIgnoreCase("setplayerjoin")) {
                writeToLine(1, args, p);
                writeToLine(2, args, p);
            } else if(cmd.getName().equalsIgnoreCase("setopjoin")) {
                writeToLine(2, args, p);
            } else if(cmd.getName().equalsIgnoreCase("setnormaljoin")) {
                writeToLine(1, args, p);
            } else if(cmd.getName().equalsIgnoreCase("setplayerleave")) {
                writeToLine(3, args, p);
                writeToLine(4, args, p);
            } else if(cmd.getName().equalsIgnoreCase("setopleave")) {
                writeToLine(4, args, p);
            } else if(cmd.getName().equalsIgnoreCase("setnormalleave")) {
                writeToLine(3, args, p);
            }
            String currentPath = getCurrentPath();
            Path path = Paths.get(currentPath + "/cjmconfig.txt");
            try {
                cs.sendMessage("");
                cs.sendMessage("");
                cs.sendMessage("");
                List<String> file = Files.readAllLines(path, Charset.defaultCharset());
                cs.sendMessage(ChatColor.GREEN + "CJM: Normal Players Join Message: \"" + ChatColor.WHITE + file.get(1) + ChatColor.GREEN + "\"");
                cs.sendMessage(ChatColor.GREEN + "CJM: Operators Join Message: \"" + ChatColor.WHITE + file.get(2) + ChatColor.GREEN + "\"");
                cs.sendMessage(ChatColor.GREEN + "CJM: Normal Players Leave Message: \"" + ChatColor.WHITE + file.get(3) + ChatColor.GREEN + "\"");
                cs.sendMessage(ChatColor.GREEN + "CJM: Operators Leave Message: \"" + ChatColor.WHITE + file.get(4) + ChatColor.GREEN + "\"");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!cmd.getName().equalsIgnoreCase("getjoinmessages")) {
                cs.sendMessage("");
                cs.sendMessage(ChatColor.GOLD + "To use color codes please edit the cmjconfig.txt in the server directory manually");
                cs.sendMessage("");
            }
            loadConfig();
            return true;
        }
        return false;
    }

    private void writeToLine(int lineNumber, String[] s, Player exception) {
        String currentPath = getCurrentPath();
        Path p = Paths.get(currentPath + "/cjmconfig.txt");
        byte[] data = null;
        String allLines = "";
        String newMessage = "";
        for(String n : s) {
            newMessage = newMessage + n + " ";
        }
        try {
            List<String> lines = Files.readAllLines(p, Charset.defaultCharset());
            lines.set(lineNumber, newMessage);
            for (String line : lines) {
                allLines = allLines + line + "\n";
            }
            data = allLines.getBytes(Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
            try {
                data = Files.readAllBytes(p);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        try {
            if(data != null) {
                Files.write(p, data, StandardOpenOption.WRITE);
            }
        } catch (IOException e) {
            exception.sendMessage(ChatColor.RED + "There was an error writing to the file. Please make sure there is a cjmconfig.txt in the main server directory");
        }
    }

    private void loadConfig() {
        String currentPath = getCurrentPath();
        Path p = Paths.get(currentPath + "/cjmconfig.txt");
        try {
            List<String> lines = Files.readAllLines(p, Charset.defaultCharset());
            nmjoin = lines.get(1);
            opjoin = lines.get(2);
            nmleave = lines.get(3);
            opleave = lines.get(4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentPath() {
        String workingDir = System.getProperty("user.dir");
        String[] stringParts = workingDir.split("/");
        String currentPath = "";
        for(int i = 1; i < stringParts.length; i++) {
            currentPath = currentPath + "/" + stringParts[i];
        }
        return currentPath;
    }
}
