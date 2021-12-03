package Exams.Exam22February2020.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                this.roster.remove(i);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                this.roster.get(i).setRank("Member");
            }
        }
    }

    public void demotePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                this.roster.get(i).setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        int count = 0;
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getClazz().equals(clazz)) {
                count++;
            }
        }
        Player[] players = new Player[count];
        count = 0;
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getClazz().equals(clazz)) {
                players[count] = this.roster.get(i);
                this.roster.remove(i);
                i = -1;
                count++;
            }
        }
        return players;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Players in the guild: ").append(this.name).append(":").append(System.lineSeparator());
        for (int i = 0; i < this.roster.size(); i++) {
            if (i < this.roster.size() - 1) {
                report.append(this.roster.get(i)).append(System.lineSeparator());
            } else {
                report.append(this.roster.get(i));
            }
        }
        return report.toString();
    }
}
