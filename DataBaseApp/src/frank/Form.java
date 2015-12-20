/*
this class handles every sngle operation related to form ranging from registration,
validation, prompting and pushing to file
 */
package frank;
import java.io.File;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;



public class Form{
    
    Image passportImage;
    Image defaultImage;
    DataBaseApp db;
    Button theBack;
    VBox imageVBox;
    HBox globalHBox;
    ImageView defaultImageView;
    TextField surNameTextField,firstNameTextField,otherNamesTextField,townTextField
            ,lgaTextField,stateTextField,countryTextField,dateofBirthTextField,phoneNumber1TextField
            ,phoneNumber2TextField,emailTextField;
    TextArea addressTextArea;
    DatePicker dateOfBirthDatePicker;
    RadioButton male,female;
    String[]information;
    public Form(DataBaseApp data){
    db=data;
    }
    
    
    public Scene start(){
        Group stack=new Group(); 
        Scene scene=new Scene(stack,585,800);
        
    Image formBackGround=new Image(getClass().getResourceAsStream("images/BackGround_MainFrame.jpg"));
    ImageView displayBackGround=new ImageView();
    displayBackGround.setImage(formBackGround); 
    VBox labelAllign1=getVBoxProperties();
    VBox labelAllign2=getVBoxProperties();
    VBox labelAllign=getVBoxProperties();
    VBox textFieldAllign1=getVBoxProperties();
    VBox textFieldAllign2=getVBoxProperties();
    VBox textFieldAllign=getVBoxProperties();
    
    textFieldAllign.setSpacing(19);
    HBox arrange=new HBox();
    ToggleGroup bind=new ToggleGroup();
    
    
    Label surName=getLabelProperties("SURNAME");
    Label firstName=getLabelProperties("FIRSTNAME");
    Label otherNames=getLabelProperties("OTHER NAMES");
    Label address=getLabelProperties("ADDRESS");
    Label town=getLabelProperties("TOWN");
    Label lga=getLabelProperties("L.G.A");
    Label state=getLabelProperties("STATE");
    Label country=getLabelProperties("COUNTRY");
    Label dateOfBirth=getLabelProperties("DATE OF BIRTH");
    Label sex=getLabelProperties("SEX");
    Label phoneNumber1=getLabelProperties("PHONE NUMBER 1");
    Label phoneNumber2=getLabelProperties("PHONE NUMBER 2");
    Label email=getLabelProperties("EMAIL");
    Label passport=getLabelProperties("PASSPORT");
    
    labelAllign1.getChildren().addAll(surName,firstName,otherNames,address);
    labelAllign2.getChildren().addAll(town,lga,state,country,dateOfBirth,sex,phoneNumber1,phoneNumber2,email,passport);
    labelAllign2.setSpacing(21);
    male=getRadioButtonProperties("MALE");
    female=getRadioButtonProperties("FEMALE");
    male.setToggleGroup(bind);
    female.setToggleGroup(bind);
    
    HBox radioButtonArranger=new HBox();
    radioButtonArranger.getChildren().addAll(male,female);
    radioButtonArranger.setSpacing(25); 
    surNameTextField=getTextFieldProperties();
    firstNameTextField=getTextFieldProperties();
    otherNamesTextField=getTextFieldProperties();
    addressTextArea=getTextAreaProperties();
    townTextField=getTextFieldProperties();
    lgaTextField=getTextFieldProperties();
    stateTextField=getTextFieldProperties();
    countryTextField=getTextFieldProperties();
    dateOfBirthDatePicker=new DatePicker();  
    phoneNumber1TextField=getTextFieldProperties();
    phoneNumber2TextField=getTextFieldProperties(); 
    emailTextField=getTextFieldProperties();
    Button passportButton=new Button("upload photo");
    HBox backAndSubmit=new HBox();
    Button back=getButtonProperties("Back","back.jpg");
    Button submit=getButtonProperties("Submit","submit.jpg");
    backAndSubmit.getChildren().addAll(back,submit);
    backAndSubmit.setSpacing(30);

    textFieldAllign1.getChildren().addAll(surNameTextField,firstNameTextField,otherNamesTextField,addressTextArea);
    textFieldAllign2.getChildren().addAll(townTextField,lgaTextField,stateTextField,countryTextField,dateOfBirthDatePicker);
    textFieldAllign2.getChildren().addAll(radioButtonArranger,phoneNumber1TextField,phoneNumber2TextField,emailTextField,passportButton);
    textFieldAllign2.getChildren().addAll(backAndSubmit);
    
    labelAllign.getChildren().addAll(labelAllign1,labelAllign2);
    textFieldAllign.getChildren().addAll(textFieldAllign1,textFieldAllign2);
   // textFieldAllign.setSpacing(200);
    labelAllign.setSpacing(200);
    ImageView imagePlaceHolder=getImageProperties("imagePlaceHolder.jpg");
    
    Button remove=getButtonProperties("remove","remove.jpg");
    VBox placeimage=new VBox();
    imageVBox=placeimage;  
    imageVBox.getChildren().addAll(imagePlaceHolder,remove);
    imageVBox.setSpacing(10);
    imageVBox.setPadding(new Insets(20,0,0,0));
    defaultImageView=imagePlaceHolder;
   // labelAllign.setPadding(new Insets(150,0,0,0));
   // textFieldAllign.setPadding(new Insets(150,0,0,0));
    ScrollBar sb=getScrollBarProperties();
    sb.setOrientation(Orientation.VERTICAL);
    
    VBox scrollBarHolder=new VBox();
    scrollBarHolder.getChildren().add(sb);
    //scrollBarHolder.setPadding(new Insets(0,0,300,0));
    
    passportButton.setOnAction(e-> chooseImage(e));
    back.setOnAction(e->navigateBack(e));
    remove.setOnAction(e->deletePix(e));
    submit.setOnAction(e->getFormDetailsAndValidate(e));
    arrange.getChildren().addAll(labelAllign,textFieldAllign,imageVBox,scrollBarHolder);
    arrange.setSpacing(20);
    
     
         
          
    
    stack.getChildren().addAll(displayBackGround,arrange);
    //sets the scroll bar to scroll the stack pane
    sb.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
        arrange.setLayoutY(-new_val.doubleValue()*1.98);
       
        });
   
    return scene;
    }
    
    public void upload(ActionEvent event){
    System.out.println("Action taken");
    }
    
    
    public void navigateBack(ActionEvent event){
    Scene backto=db.homePage();
    db.mainStage.setScene(backto);
    db.mainStage.show();
    }
    
    
    //defines properties of a textfield
    private TextField getTextFieldProperties(){
    TextField temp=new TextField();
    temp.setMinWidth(175);
    temp.setMaxWidth(175);
    temp.setFont(Font.font("Calibri", FontWeight.THIN, FontPosture.REGULAR, 14));
    return temp; 
    }
    
    //defines properties of a textarea
    private TextArea getTextAreaProperties(){
    TextArea input=new TextArea();
    input.setMinHeight(200);
    input.setMaxHeight(200);
    input.setMaxWidth(175);
    input.setMinWidth(175);
    return input;
    }
    
    //defines properties of a VBox
    private VBox getVBoxProperties(){
    VBox input=new VBox();
    input.setSpacing(20);
    input.setPadding(new Insets(5,0,0,10)); 
    return input;
    }
    
    //defines properties of a label
    private Label getLabelProperties(String text){
    Label name=new Label(text);
    name.setTextFill(javafx.scene.paint.Color.WHITE);
    name.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 16)); 
    return name;
    }
    
    //defines properties of a radio button
    private RadioButton getRadioButtonProperties(String text){
    RadioButton name=new RadioButton();
    name.setText(text);
    name.setTextFill(Color.WHITE);
    name.setFocusTraversable(true);
    name.setSelected(true);
    
    return name;
    }
    
    
    //defines properties of a button with image icon
     private Button getButtonProperties(String text,String imagename){
    Button name=new Button(text);
    Image back=new Image(getClass().getResourceAsStream("images/"+imagename));
    ImageView displayBack=new ImageView();
    displayBack.setImage(back);
    name.setGraphic(displayBack); 
    return name;
    }
    
     
     public ImageView getImageProperties(String name){
     Image placeHolder=new Image(getClass().getResourceAsStream("images/"+name));
     defaultImage=placeHolder;
     ImageView temp=new ImageView();
     temp.setImage(placeHolder);
     temp.resize(150, 200);
     temp.setPreserveRatio(true);
     return temp;
     }
     
     public ScrollBar getScrollBarProperties(){
     ScrollBar sb=new ScrollBar();
     sb.setMin(0);  
     sb.setMaxHeight(860);
     sb.setMinHeight(860);
     sb.setValue(0);
     sb.setMinWidth(17);
    // System.out.println(hboxHeight);
     return sb;
     }
     	//for creating the filechooser and filtering the extensions
	private FileChooser setInitialDirectory(String text){
	FileChooser temp=new FileChooser();
	temp.setTitle(text);
	temp.setInitialDirectory(new File(System.getProperty("user.home"))); 
	temp.getExtensionFilters().addAll(
			new FileChooser.ExtensionFilter("All Files", "*.*"),
			new FileChooser.ExtensionFilter("JPG", "*.jpg"),
			new FileChooser.ExtensionFilter("PNG", "*.png")
			);
	return temp;	
	}
	
	//for electing image fromroot folder
	public void chooseImage(ActionEvent event){
		FileChooser choose=setInitialDirectory("Select a Picture");
		File file=choose.showOpenDialog(db.mainStage);
		if(file!=null){		
			openFile(file);
		}
		
	}
	
	
	//sets the properties of the image added to the form
	public void openFile(File file){
		Image image=new Image("file:"+file.getAbsolutePath());
                passportImage=image;
		ImageView display=new ImageView();			
		display.setImage(image);
		display.setFitHeight(150);
		display.setFitWidth(150);
		display.setPreserveRatio(true);
                imageVBox.getChildren().remove(0);
                imageVBox.getChildren().add(0,display);
		
	}
        //handles the deletion of an already placed image
        public void deletePix(ActionEvent event){
        imageVBox.getChildren().remove(0);
        ImageView replace=getImageProperties("imagePlaceHolder.jpg");
        imageVBox.getChildren().add(0, replace);
        passportImage=null;
        }
     
        //obtains details from the form, validates it and takes appropriate action
        public void getFormDetailsAndValidate(ActionEvent event){
        String getsurname=surNameTextField.getText().trim().toUpperCase();
        String getfirstname=firstNameTextField.getText().trim().toUpperCase();
        String getothernames=otherNamesTextField.getText().trim().toUpperCase();
        String getaddress=addressTextArea.getText().trim().toUpperCase();
        String gettown=townTextField.getText().trim().toUpperCase();
        String getlga=lgaTextField.getText().trim().toUpperCase();
        String getstate=stateTextField.getText().trim().toUpperCase();
        String getcountry=countryTextField.getText().trim().toUpperCase();      
        String getbirthdate=dateOfBirthDatePicker.getEditor().getText().trim().toUpperCase();
        String getphonenumber1=phoneNumber1TextField.getText().trim().toUpperCase();
        String getphonenumber2=phoneNumber2TextField.getText().trim().toUpperCase();
        String getemail=emailTextField.getText().trim().toUpperCase();
        String gender;
        
        if(male.isSelected()){
             gender="MALE";
        }else{
             gender="FEMALE";
        }
        
        
        information=new String[]{getsurname,getfirstname,getothernames,getaddress,gettown,
        getlga,getstate,getcountry,getbirthdate,getphonenumber1,getphonenumber2,getemail,gender};
        int count=0;
        for (int i=0; i<information.length-1; i++) {
            if (!information[i].equals("")) {
                 count++;
            }
        }
        
        if(count!=information.length-1|passportImage==null){
             JOptionPane.showMessageDialog(null,"Partially Filled Form", "Fill in the required details", JOptionPane.INFORMATION_MESSAGE);
        }else{
             pushToFile();
        }
        }
        
        public void pushToFile(){
        People setValues=new People();
        setValues.setSurname(information[0]);
        setValues.setFirstname(information[1]);
        setValues.setOthername(information[2]);
        setValues.setAddress(information[3]);
        setValues.setTown(information[4]);
        setValues.setLga(information[5]);
        setValues.setState(information[6]);
        setValues.setCountry(information[7]);
        setValues.setBirthdate(information[8]);
        setValues.setPhonenumber1(information[9]);
        setValues.setPhonenumber2(information[10]);
        setValues.setEmail(information[11]);
        setValues.setImage(passportImage);
        setValues.setSex(information[12]);
        FileWrite fw=new FileWrite(setValues);
        fw.writeToFile(setValues);
        fw.readFromFile();
        }
        
        
        public void setToForm(){
        surNameTextField.setText(information[0]);
        firstNameTextField.setText(information[1]);
        otherNamesTextField.setText(information[2]);
        addressTextArea.setText(information[3]);
        townTextField.setText(information[4]);
        lgaTextField.setText(information[5]);
        stateTextField.setText(information[6]);
        countryTextField.setText(information[7]);      
        dateOfBirthDatePicker.getEditor().setText(information[8]);
        phoneNumber1TextField.setText(information[9]);
        phoneNumber2TextField.setText(information[10]);
        emailTextField.setText(information[11]);
        if(information[12].equals("MALE")){
            male.setSelected(true);
        }else{
            female.setSelected(true);
        }
        ImageView display=new ImageView();
        display.setImage(passportImage);
		display.setFitHeight(150);
		display.setFitWidth(150);
		display.setPreserveRatio(true);
                imageVBox.getChildren().remove(0);
                imageVBox.getChildren().add(0,display);
        }
}
