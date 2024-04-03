import java.util.Scanner;

public class Person {

     String surname;
     String name;
     String patronymic;
     String date;
     int phoneNum;
     char sex;
    public Person(){
        inputData();
    }

    private void checkCorrectInputParameters(String[] par) {
        if (par[5].length() > 1){
            throw new FormatParametrException(" Неверно введен пол. Необходим 1 символ");
        }
        if (!par[5].equals("m") && !par[5].equals("f")){
            throw new FormatParametrException(" Неверно введен пол. Необходимо ввести f или m");
        }
        sex = par[5].charAt(0);

        try{
            phoneNum = Integer.parseInt(par[4]);
        } catch (NumberFormatException e){
            throw new FormatParametrException(" В номере присутствуют неевалидные значения");
        }
        if (par[4].length() > 10) throw new FormatParametrException(" Длина номера больше 10");
        if (par[4].length() < 10) throw new FormatParametrException(" Длина номера меньше 10");

        date = par[3];
        String[] dateType = date.split("\\.");
        if (dateType.length != 3) throw new FormatParametrException(" Формат даты должен быть: dd.mm.yyyy");
        if (dateType[0].length() != 2 && dateType[1].length() != 2 && dateType[2].length() != 4){
            throw new FormatParametrException(" Неверный формат даты");
        }
        for (String s : dateType) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(" Недопустимые символы в дате");
            }
        }

        surname = par[0];
        name = par[1];
        patronymic = par[2];
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

    private void checkCorrectInput(String data){
        String[] arr = data.split(" ");
        if (arr.length < 6){
            throw new RuntimeException("количество введенных данных меньше 6");
        }
        if (arr.length > 6){
            throw new RuntimeException("количество введенных данных больше 6");
        }
        checkCorrectInputParameters(arr);
    }
    private void inputData(){
        System.out.println("Введите данные в следующем формате: \n Фамилия " +
                "Имя " +
                "Отчество " +
                "Дата(в формате хх.хх.хххх) " +
                "Номер(мобильный 10 цифр) " +
                "Пол(f или m) ");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        scanner.close();
        checkCorrectInput(data);
    }

    public String getSurname(){
        return surname;
    }

    public String getData(){
        return String.format("%s %s %s %s %d %c", surname, name,patronymic,date,phoneNum,sex );
    }
}
