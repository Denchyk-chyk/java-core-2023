package lab4;

import java.util.Objects;

public class Racer extends Driver
{
    private String team;

    @Name("Команда")
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Racer(String firstName, String lastName, Mark mark, String model, String color, String team)
    {
        instant(firstName, lastName, mark, model, color);
        this.team = team;
    }

    public Racer() {}
    @Override
    public String toString()
    {
        return super.toString() + " | команда: " + team + "\n";
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(firstName, lastName, mark, model, color, team);
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Racer racer)) return false;
        return super.equals(o) && Objects.equals(team, racer.team);
    }

    @Override
    protected Object clone()
    {
        return new Racer(firstName, lastName, mark, model, color, team);
    }

    @Override
    public void paint(String color)
    {
        this.color += "-" + color;
    }
}