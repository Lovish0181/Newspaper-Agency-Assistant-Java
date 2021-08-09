package Signup;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

    	public class Signup_FormController {
    		Connection con;
    		PreparedStatement pst;

    	    @FXML
    	    private ResourceBundle resources;

    	    @FXML
    	    private URL location;

    	    @FXML
    	    private PasswordField txtpass;

    	    @FXML
    	    private TextField txtusername;

    	    @FXML
    	    private Button btnsignup;

    	    @FXML
    	    void dosignup(ActionEvent event) {
    	    	String user = txtusername.getText();
    	        String pass = txtpass.getText();
    	        if(user.isEmpty() && pass.isEmpty())
    	        {
          	        btnsignup.setText("Invalid");
    	        }
    	        else
    	        {
                try {
					pst = con.prepareStatement("insert into users values(?,?)");
					pst.setString(1,txtusername.getText());
	                pst.setString(2,txtpass.getText());
	                pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try{
       			  FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/Login/Login_Form.fxml"));
       	        	Parent root=(Parent)fxmlloader.load();
       	        	
       	        	Stage stage=new Stage();
       	        	stage.setScene(new Scene(root));
       	        	stage.show();

       	            Scene scene1 = (Scene)btnsignup.getScene();
       	            scene1.getWindow().hide();

       			}
       			catch(Exception e)
       			{
       				e.printStackTrace();
       			}

                
    	    	Alert alert = new Alert(AlertType.WARNING);
    	    	alert.setTitle("Warning Message");
    	    	alert.setHeaderText("ThankYou For Using Our Services");
    	    	alert.setContentText("Signed Up Successfully");
    	    	alert.showAndWait();
    	    }
    	    }
    	    @FXML
    	    void initialize() {
    	       con=Connect.getConnection();
    	    }
    	}
