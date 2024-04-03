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
            throw new FormatParametrException(" Необходимо ввести f или m");
        }
        sex = par[5].charAt(0);

        try{
            phoneNum = Integer.parseInt(par[4]);
        } catch (NumberFormatException e){
            throw new FormatParametrException(" В номере присутствуют неевалидные значения");
        }
        if (par[4].length() != 10) throw new FormatParametrException(" Недопустимо длинный номер");

        date = par[3];
        String[] dateTipe = date.split("\\.");
        if (dateTipe.length != 3) throw new FormatParametrException(" Формат даты должен быть: dd.mm.yyyy");
        if (dateTipe[0].length() != 2 && dateTipe[1].length() != 2 && dateTipe[2].length() != 4){
            throw new FormatParametrException(" Неверный формат даты");
        }
        for (int i = 0; i < date.length(); i++) {
            try {
                Integer.parseInt(dateTipe[i]);
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
        System.out.println("Введите данные в следующем формате: \n Фамилия Имя Отчество Дата Номер Пол ");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        scanner.close();
        checkCorrectInput(data);
    }
}
