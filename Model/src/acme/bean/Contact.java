package acme.bean;

public class Contact {
    
    public String name;
    public String email;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Contact(String name, String email){
        this.name = name;
        this.email = email;
    }
    
    
    public Contact() {
        super();
    }
}
