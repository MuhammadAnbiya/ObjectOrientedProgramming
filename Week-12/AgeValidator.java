public class AgeValidator {
    public void validate(int age) throws ValidationException {
        if (age < 18) {
            throw new ValidationException("Age must be at least 18");
        }
    }

    public static void main(String[] args) {
        AgeValidator validator = new AgeValidator();
        try {
            validator.validate(17);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}

