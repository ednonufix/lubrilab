package cu.cupet.cubalub.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
@SpringBootApplication
public class LubriLab extends Application {

    public static void main(String[] args) {

        SpringApplication.run(LubriLab.class,args);

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Principal.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("LubriLab");
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();

        //ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringContext.xml");

    }
}
