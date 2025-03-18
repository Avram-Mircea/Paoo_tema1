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

    public void change_address(Adresa adr)
    {
        adresa = adr;
    }

    @Override
    public String toString() {
        return nume + ", " + adresa;
    }
}

class Turist extends Persoana
{
    Turist(String nume, Adresa adresa)
    {
        this.nume = nume;
        this.adresa = adresa;
    }

    @Override
    public void change_address(Adresa adr)
    {
        adresa = adr;
    }

    @Override
    public String toString() {
        return nume;
    }
}

class Hotel
{
    String nume_hotel;
    Adresa adresa;
    List<Turist> lista_turisti = new ArrayList<>();

    Hotel(String nume, Adresa adr)
    {
        nume_hotel = nume;
        adresa = adr;
    }

    public void change_address(Adresa adr)
    {
        adresa = adr;
    }

    @Override
    public String toString() {
        return "Hotelul: " + nume_hotel + ", adresa: " + adresa;
    }
}

class Oras
{
    String nume_oras;
    List<Hotel> lista_hoteluri = new ArrayList<>();

    Oras(String nume)
    {
        nume_oras = nume;
    }

    public void Tourist_moves_to_another_Hotel(Hotel hotel, Turist turist)
    {
        int i, numar_hoteluri = lista_hoteluri.size();

        for (i = 0; i < numar_hoteluri; i++)
        {
            if (lista_hoteluri.get(i).lista_turisti.remove(turist))
                hotel.lista_turisti.add(turist);
        }
    }

    public void get_all_hotels_in_a_city()
    {
        int i, numar_hoteluri = lista_hoteluri.size();

        for (i = 0; i < numar_hoteluri; i++)
        {
            System.out.println(lista_hoteluri.get(i));
        }
    }

    public void display_all_tourists_in_a_city_hotels()
    {
        int i, numar_hoteluri = lista_hoteluri.size();

        for (i = 0; i < numar_hoteluri; i++)
        {
            System.out.println(lista_hoteluri.get(i));
            lista_hoteluri.get(i).lista_turisti.forEach(System.out::println);
        }
    }

    public boolean person_accommodated_in_hotels(Turist turist)
    {
        int i, numar_hoteluri = lista_hoteluri.size();

        for (i = 0; i < numar_hoteluri; i++)
        {
            if (lista_hoteluri.get(i).lista_turisti.contains(turist))
                return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Adresa adresa1, adresa2, adresa3;
        adresa1 = new Adresa("Craiova", "Mihai Viteazu", 10);
        adresa2 = new Adresa("Turceni", "Bobelnicu Marian", 1);
        adresa3 = new Adresa("Bucuresti", "Eroilor", 39);

        Turist turist1, turist2;
        turist1 = new Turist("Larisa", adresa1);
        turist2 = new Turist("Alin", adresa2);

        Hotel hotel1, hotel2;
        hotel1 = new Hotel("Ramada", adresa3);
        hotel2 = new Hotel("Helin", adresa3);

        hotel1.lista_turisti.add(turist1);
        hotel1.lista_turisti.add(turist2);

        Oras oras = new Oras("Bucuresti");
        oras.lista_hoteluri.add(hotel1);
        oras.lista_hoteluri.add(hotel2);

        System.out.println("Afisare toate hotelurile:");
        oras.get_all_hotels_in_a_city();

        System.out.println("\n\nDaca exista turistul x:");
        if (oras.person_accommodated_in_hotels(turist1))
            System.out.println("Turistul " + turist1 + " exista");
        else
            System.out.println("Turistul " + turist1 + "nu exista");

        System.out.println("\n\nAfisare toti turistii din hoteluri:");
        oras.display_all_tourists_in_a_city_hotels();

        System.out.println("\n\nMutare turist:");
        oras.Tourist_moves_to_another_Hotel(hotel2, turist2);
        oras.display_all_tourists_in_a_city_hotels();
    }
}