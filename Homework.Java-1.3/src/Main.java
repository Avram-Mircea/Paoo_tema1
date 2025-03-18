class student
{
    String nume;
    int varsta;
    String facultate;

    student(String n, int v, String f)
    {
        nume = n;
        varsta = v;
        facultate = f;
    }

    @Override
    public String toString()
    {
        return "Nume student: " + nume + ", varsta: " + varsta + ", facultatea: " + facultate;
    }
}

public class Main {
    public static void main(String[] args) {
        student S = new student("Matei", 19, "Automatica");

        System.out.println(S.toString());
    }
}