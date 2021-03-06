package bean;

import lombok.Data;
import model.Helado;
import model.User;
import services.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("createdUserBean")
@ViewScoped
@Data
public class CreateUserBean implements Serializable {

    String name;

    @Inject
    UserService userService;

    private List<User> userList;

    public String linkHome() {
        return "index?faces-redirect=true";
    }

    public List<User> getAllUsers(){
        userList=userService.getAllUsers();
        return userList;
    }
    public void createUser(){
        User user=new User(name,"Prueba",new ArrayList<Helado>());
        userService.saveUser(user);
        getAllUsers();
    }
}
