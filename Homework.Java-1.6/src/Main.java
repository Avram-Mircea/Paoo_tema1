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

    @Override
    public String toString() {
        return nume + ", " + adresa;
    }
}

class Profesor extends Persoana
{
    String materie;

    Profesor(String nume, Adresa adresa, String materie)
    {
        this.nume = nume;
        this.adresa = adresa;
        this.materie = materie;
    }

    public void changeTeacherAddress(Adresa a)
    {
        adresa = a;
    }

    @Override
    public String toString() {
        return super.toString() + ", Materie: " + materie;
    }
}

class Student extends Persoana
{
    int anul;

    Student(String nume, Adresa adresa, int anul)
    {
        this.nume = nume;
        this.adresa = adresa;
        this.anul = anul;
    }

    public void ChangeStudentAddress(Adresa a)
    {
        adresa = a;
    }

    @Override
    public String toString() {
        return super.toString() + " Anul: " + anul;
    }
}

class Curs
{
    String nume_curs;
    Profesor profesor;
    List <Student> lista_studenti;

    Curs(String nume)
    {
        nume_curs = nume;
        lista_studenti = new ArrayList<>();
    }

    public void addStudentToCourse(Student s)
    {
        lista_studenti.add(s);
    }

    public void removeStudentFromCourse(Student s)
    {
        lista_studenti.remove(s);
    }

    public void addTeacherToCourse(Profesor p)
    {
        profesor = p;
    }

    public void RemoveTeacherFromCourse()
    {
        profesor = null;
    }

    public void createNewCourse(Curs c)
    {
        nume_curs = c.nume_curs;
        profesor = c.profesor;
        lista_studenti = c.lista_studenti;
    }

    @Override
    public String toString() {
        return nume_curs + " - Profesor: " + profesor + " - Studenti: " + lista_studenti.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Adresa adresa_profesor = new Adresa("Craiova", "Lalelelor", 10);
        Profesor profesor = new Profesor("Cerbulescu", adresa_profesor, "Paoo");

        Adresa adresa_student = new Adresa("Turceni", "Marian", 34);
        Student student = new Student("Bobelnicu", adresa_student, 2);

        Curs curs = new Curs("Paoo");

        System.out.println("Cursul dupa adaugarea profesorului si studentului:");
        curs.addTeacherToCourse(profesor);
        curs.addStudentToCourse(student);
        System.out.println(curs + "\n");

        System.out.println("Cursul dupa schimbarea adreselor:");
        Adresa adresa_noua = new Adresa("Craiova", "Mihai Viteazu", 73);
        profesor.changeTeacherAddress(adresa_noua);
        adresa_noua = new Adresa("Craiova", "Ispirescu", 81);
        student.ChangeStudentAddress(adresa_noua);
        System.out.println(curs + "\n");

        System.out.println("Copiere a cursului:");
        Curs copie_curs = new Curs("Matematica");
        System.out.println(copie_curs);
        copie_curs.createNewCourse(curs);
        System.out.println(copie_curs + "\n");

        System.out.println("Cursul dupa eliminarea profesorului si studentului:");
        curs.removeStudentFromCourse(student);
        curs.RemoveTeacherFromCourse();
        System.out.println(curs);
    }
}