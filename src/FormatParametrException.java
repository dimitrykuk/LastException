public class FormatParametrException extends RuntimeException{

    public FormatParametrException(String text){
        super(String.format(text));
    }

}
