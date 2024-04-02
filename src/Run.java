import java.util.Scanner;

public class Run {

    public Run(){
        checkCorrectParameters();
    }
//    фамилия, имя, отчество - строки
//    дата _ рождения - строка формата dd.mm.yyyy
//    номер _ телефона - целое беззнаковое число без форматирования
//    пол - символ латиницей f или m.
    private void checkCorrectParameters() {
        String[] par = checkCorrectInput();

        if (par[5].length() > 1){
            throw new FormatParametrException(" Неверно введен пол. Необходим 1 символ");
        }
        if (!par[5].equals("m") && !par[5].equals("f")){
            throw new FormatParametrException(" Необходимо ввести f или m");
        }
        //char sex = par[5].charAt(0);

        //int number = 0;
        try{
            Integer.parseInt(par[4]);
        } catch (NumberFormatException e){
            throw new FormatParametrException(" В номере присутствуют неевалидные значения");
        }
        if (par[4].length() != 10) throw new FormatParametrException(" Недопустимо длинныйы номер");

        String[] date = par[3].split("\\.");
        if (date.length != 3) throw new FormatParametrException(" Формат даты должен быть: dd.mm.yyyy");
        if (date[0].length() != 2 && date[1].length() != 2 && date[2].length() != 4){
            throw new FormatParametrException(" Пересмотрите формат даты");
        }

        if (!par[0].chars().allMatch(Character::isLetter)){
            throw new FormatParametrException(" Недопустимые символы в фамилии");
        }
        if (!par[1].chars().allMatch(Character::isLetter)){
            throw new FormatParametrException(" Недопустимые символы в имени");
        }
        if (!par[2].chars().allMatch(Character::isLetter)){
            throw new FormatParametrException(" Недопустимые символы в отчестве");
        }
    }

    private String[] checkCorrectInput(){
        System.out.println("Введите данные в следующем формате: \n Фамилия Имя Отчество Дата Номер Пол ");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        scanner.close();
        String[] arr = data.split(" ");
        if (arr.length < 6){
            throw new RuntimeException("количество введенных данных меньше 6");
        }
        if (arr.length > 6){
            throw new RuntimeException("количество введенных данных больше 6");
        }
        return arr;
    }
}
