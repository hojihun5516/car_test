package exception;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Data Not Found")
public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg){
        super(msg);
    }
}
