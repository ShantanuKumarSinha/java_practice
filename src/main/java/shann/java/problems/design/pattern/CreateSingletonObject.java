package shann.java.problems.design.pattern;

public class CreateSingletonObject {

  private static CreateSingletonObject obj;

    private CreateSingletonObject() {

    }

    public static CreateSingletonObject getInstance(){
        if (obj == null)
                obj = new CreateSingletonObject();
        return obj;
    }


}
