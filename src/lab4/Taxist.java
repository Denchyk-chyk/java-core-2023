package lab4;

import java.util.Objects;

public class Taxist extends Driver
{
    private String company;

    @Name("Компанія")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Taxist(String firstName, String lastName, Mark mark, String model, String color, String company)
    {
        instant(firstName, lastName, mark, model, color);
        this.company = company;
    }

    public Taxist()
    {
        instant(null, null, null, null, null);
        count--;
    }

    @Override
    public String toString()
    {
        return super.toString() + " | компанія: " + company + "\n";
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(firstName, lastName, mark, model, color, company);
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Taxist taxist)) return false;
        return super.equals(o) && Objects.equals(company, taxist.company);
    }

    @Override
    protected Object clone()
    {
        return new Racer(firstName, lastName, mark, model, color, company);
    }

    @Override
    public void paint(String color)
    {
        this.color = color;
    }
}