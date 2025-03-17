public class Main {
    public static void main(String[] args) {
        // Tipul primitiv int
        int numarPrimitiv = 10;
        System.out.println("Valoare int: " + numarPrimitiv);

        // Tipul obiect Integer
        Integer numarObiect = 10;
        System.out.println("Valoare Integer: " + numarObiect);

        // Autoboxing și unboxing
        Integer autoboxed = numarPrimitiv; // Autoboxing
        int unboxed = numarObiect; // Unboxing
        System.out.println("Autoboxed: " + autoboxed);
        System.out.println("Unboxed: " + unboxed);

        // Utilizarea Integer în colecții
        java.util.List<Integer> lista = new java.util.ArrayList<>();
        lista.add(numarObiect);
        System.out.println("Lista: " + lista);
    }
}
