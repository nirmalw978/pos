package com.devstack.pos;

import com.devstack.pos.dao.custom.UserRoleDao;
import com.devstack.pos.dao.custom.impl.UserRoleDaoImpl;
import com.devstack.pos.db.HibernateUtil;
import com.devstack.pos.entity.User;
import com.devstack.pos.entity.UserRole;
import com.devstack.pos.util.KeyGenerator;
import com.devstack.pos.util.PasswordGenerator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        initializeData();
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("./view/LoginForm.fxml"))));
        primaryStage.setTitle("pos");
        primaryStage.show();


    }

    private void initializeData(){
        UserRoleDao userRoleDao = new UserRoleDaoImpl();
            if (!userRoleDao.isExists()){

                try(Session session= HibernateUtil.getSession()){
                    Transaction transaction = session.beginTransaction();
                    UserRole admin= new UserRole();
                    UserRole user= new UserRole();

                    admin.setPropertyId(KeyGenerator.generateId());
                    admin.setRoleName("manager");
                    admin.setRoleDescription("manage");

                    user.setPropertyId(KeyGenerator.generateId());
                    user.setRoleName("user");
                    user.setRoleDescription("be user");



                    //===============================
                    User user1= new User();
                    user1.setPropertyId(KeyGenerator.generateId());
                    user1.setUsername("nero");
                    user1.setPassword(PasswordGenerator.passwordGen(6));
                    user1.setDisplayName("D1");
                    user1.setActiveState(true);
                    user1.setUserRole(admin);

                    session.save(admin);
                    session.save(user);
                    session.save(user1);

                    transaction.commit();
                }

            }
            else {
                return;
            }

    }
}
