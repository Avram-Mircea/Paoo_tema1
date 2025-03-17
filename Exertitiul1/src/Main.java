class numar
{
    int valoare;

    numar(int x)
    {
        valoare = x;
    }
}

public class Main {
    public static void Nu_se_modifica(int x) {
        x = 5;
    }

    /*public static void Se_modifica(int& x) {
        x = 20;
    }*/

    public static void Se_modifica_clasa(numar x) {
        x.valoare = 30;
    }

    public static void main(String[] args) {
        int a = 10;
        Nu_se_modifica(a);
        System.out.println(a);

        /* Java nu permite transmiterea de argumente prin referință folosind &
        Se_modifica(a);
        System.out.println(a);*/

        numar x = new numar(a);
        Se_modifica_clasa(x);
        System.out.println(x.valoare);
    }
}