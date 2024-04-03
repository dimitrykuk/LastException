import java.io.*;

public class Saver {
    public Saver (){
        savePerson();
    }

    public void savePerson() {
        Person person = new Person();
        try(FileReader fr = new FileReader(String.format("%s.txt", person.getSurname())); BufferedReader br = new BufferedReader(fr)) {
            try(FileWriter fw = new FileWriter(String.format("%s.txt", person.getSurname()),true)) {
                fw.write("\n" + person.getData());
                System.out.println(" Информация добавлена");
            } catch (IOException t) {
                throw new RuntimeException(" Непредвиденная ошибка");
            }
        } catch (IOException e) {
            try(FileWriter fw = new FileWriter(String.format("%s.txt", person.getSurname()))) {
                fw.write(person.getData());
                System.out.println(" Файл создан. Информация добавлена.");
            } catch (IOException t) {
                throw new RuntimeException(" Непредвиденная ошибка");
            }
        }
    }
}
