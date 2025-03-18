import java.util.List;
import java.util.ArrayList;

class Adresa
{
    String orasul;
    String strada;
    int numarul;

    Adresa(String orasul, String strada, int numarul)
    {
        this.orasul = orasul;
        this.strada = strada;
        this.numarul = numarul;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return orasul + ", Strada: " + strada + ", numarul: " + numarul;
    }
}

class Persoana
{
    String nume;
    Adresa adresa;

    Persoana()
    {
        nume = null;
        adresa = null;
    }

    @Override
    public String toString() {
        return nume + ", " + adresa;
    }
}

class Angajat extends Persoana
{
    Angajat(String nume, Adresa adresa)
    {
        this.nume = nume;
        this.adresa = adresa;
    }
    @Override
    public String toString() {
        return "Angajat: " + super.toString();
    }
}

class Companie
{
    String nume_companie;
    List <Angajat> lista_angajati;

    Companie(String nume)
    {
        nume_companie = nume;
        lista_angajati = new ArrayList<>();
    }

    public void move_Employee_to_another_company(Companie c, Angajat a)
    {
        lista_angajati.remove(a);
        c.add_employees_to_company(a);
    }

    public void add_employees_to_company(Angajat a)
    {
        lista_angajati.add(a);
    }

    public void display_addresses_of_all_employees_working_for_a_company_at_certain_address(Adresa a)
    {
        int i, end_of_list = lista_angajati.size();

        for (i = 0; i < end_of_list; i++)
        {
            if(lista_angajati.get(i).adresa.equals(a))
            {
                System.out.println(lista_angajati.get(i));
            }
        }
    }

    public void list_all_employees()
    {
        System.out.println("Nume companie: " + nume_companie);
        lista_angajati.forEach(System.out::println);
    }
}

public class Main {
    public static void main(String[] args) {
        Adresa adresa1, adresa2;
        adresa1 = new Adresa("Craiova", "Mihai Viteazu", 23);
        adresa2 = new Adresa("Turceni", "Bobelnicul Marian", 1);

        Angajat angajat1, angajat2;
        angajat1 = new Angajat("Maria", adresa1);
        angajat2 = new Angajat("Florin", adresa2);

        Companie companie1, companie2;
        companie1 = new Companie("KFC");
        companie2 = new Companie("Burger King");

        companie1.add_employees_to_company(angajat1);
        companie1.add_employees_to_company(angajat2);

        System.out.println("Lista toti angajatii de la compania1:\n");
        companie1.list_all_employees();

        System.out.println("\n\nLista toti angajatii de la compania1 de la o anumita adresa:\n");
        companie1.display_addresses_of_all_employees_working_for_a_company_at_certain_address(adresa2);

        System.out.println("\n\nMutarea de la o companie la alta:\n");
        companie1.move_Employee_to_another_company(companie2, angajat2);
        companie1.list_all_employees();
        companie2.list_all_employees();
    }
}