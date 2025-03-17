class Exceptii_ecuatie extends Exception
{
    public Exceptii_ecuatie(String mesaj)
    {
        super(mesaj);
    }
}

public class Main
{
    private int a, b;

    public Main(int x, int y)
    {
        a = x;
        b = y;
    }

    public float rezolvare() throws Exceptii_ecuatie
    {
        if(a == 0 && b == 0)
        {
            throw new Exceptii_ecuatie("O infinitate de solutii");
        }else if(a == 0 && b != 0)
        {
            throw new Exceptii_ecuatie("Nu exista solutii");
        }
        else
        {
            return -b/a;
        }
    }

    public void verifica()
    {
        try
        {
            float solutie = rezolvare();
            System.out.println("Soluția ecuației este: " + solutie);
        }catch (Exceptii_ecuatie e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Cazul 1: a != 0 && b != 0
        Main solver1 = new Main(2, -4);
        solver1.verifica();

        // Cazul 2: a = 0 && b != 0
        Main solver2 = new Main(0, 5);
        solver2.verifica();

        // Cazul 3: a = 0 && b = 0
        Main solver3 = new Main(0, 0);
        solver3.verifica();
    }
}