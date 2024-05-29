package Library;

public abstract class User {
    protected String name;
    protected String email;
    protected String phonenumber;

    public User(){

    }

    public User(String name){
        this.name = name;
    }

    public User(String name, String email, String phonenumber){
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
    }
    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhonenumber(){
        return this.phonenumber;
    }


    abstract public void menu();
}