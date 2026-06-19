package mini_project.ems_backend.exception;

public class NotFoundException extends RuntimeException {
	
	String message;

	public NotFoundException(String message) {
	
		this.message = message;
	}
	
	public String getMessage() {
		
		return message;
		
	}
	
	

}
