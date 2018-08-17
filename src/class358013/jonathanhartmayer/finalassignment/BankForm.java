package class358013.jonathanhartmayer.finalassignment;

import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankForm extends Application {

	private TextField checkingBalance = new TextField();
	private TextField savingsBalance = new TextField();
	private TextField annualInterestRate = new TextField();
	private TextField overdraftLimit = new TextField();
	private TextField checkingAccountID = new TextField();
	private TextField savingsAccountID = new TextField();
	private TextField checkingTx1Amount = new TextField();
	private TextField checkingTx2Amount = new TextField();
	private ComboBox<String> checkingTx1AccountType = new ComboBox<String>();
	private ComboBox<String> checkingTx2AccountType = new ComboBox<String>();
	private TextField savingsTx1Amount = new TextField();
	private TextField savingsTx2Amount = new TextField();
	private ComboBox<String> savingsTx1AccountType = new ComboBox<String>();
	private ComboBox<String> savingsTx2AccountType = new ComboBox<String>();
	private Label output = new Label();
	public String outputEntries = "";
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		GridPane bankingPane = new GridPane();
		
		checkingBalance.setPrefWidth(100.0);
		savingsBalance.setPrefWidth(100.0);
		annualInterestRate.setPrefWidth(100.0);
		overdraftLimit.setPrefWidth(100.0);
		checkingAccountID.setPrefWidth(40.0);
		savingsAccountID.setPrefWidth(40.0);
		checkingTx1Amount.setPrefWidth(80.0);
		checkingTx2Amount.setPrefWidth(80.0);
		savingsTx1Amount.setPrefWidth(80.0);
		savingsTx2Amount.setPrefWidth(80.0);
		
		HBox hbox1 = new HBox();
		hbox1.setSpacing(5);
		hbox1.getChildren().add(new Label("Account Balance - Checking:"));
		hbox1.getChildren().add(checkingBalance);
		hbox1.getChildren().add(new Label("$  Savings:"));
		hbox1.getChildren().add(savingsBalance);
		hbox1.getChildren().add(new Label("$"));
		
		HBox hbox2 = new HBox();
		hbox2.setSpacing(5);
		hbox2.getChildren().add(new Label("Annual Interest Rate:"));
		hbox2.getChildren().add(annualInterestRate);
		hbox2.getChildren().add(new Label("%  Overdraft Limit:"));
		hbox2.getChildren().add(overdraftLimit);
		hbox2.getChildren().add(new Label("$"));
		
		HBox hboxTx1Checking = new HBox();
		hboxTx1Checking.setSpacing(5);
		checkingTx1AccountType.getItems().addAll("Withdraw", "Deposit");
		hboxTx1Checking.getChildren().addAll(checkingTx1Amount, new Label("$"), checkingTx1AccountType);
		
		HBox hboxTx1Savings = new HBox();
		hboxTx1Savings.setSpacing(5);
		savingsTx1AccountType.getItems().addAll("Withdraw", "Deposit");
		hboxTx1Savings.getChildren().addAll(savingsTx1Amount, new Label("$"), savingsTx1AccountType);
		
		HBox hboxTx2Checking = new HBox();
		hboxTx2Checking.setSpacing(5);
		checkingTx2AccountType.getItems().addAll("Withdraw", "Deposit");
		hboxTx2Checking.getChildren().addAll(checkingTx2Amount, new Label("$"), checkingTx2AccountType);
		
		HBox hboxTx2Savings = new HBox();
		hboxTx2Savings.setSpacing(5);
		savingsTx2AccountType.getItems().addAll("Withdraw", "Deposit");
		hboxTx2Savings.getChildren().addAll(savingsTx2Amount, new Label("$"), savingsTx2AccountType);
		
		Button submitBT = new Button("Submit");
		Button resetBT = new Button("Reset");
		
		HBox buttons = new HBox();
		buttons.setSpacing(5);
		buttons.getChildren().addAll(submitBT, resetBT);
		
		bankingPane.setVgap(5);
		bankingPane.setHgap(5);
		bankingPane.add(new Label("Account ID:"), 1, 0);
		bankingPane.add(new Label("Transaction 1 Amount"), 2, 0);
		bankingPane.add(new Label("Transaction 2 Amount"), 3, 0);
		bankingPane.add(new Label("Checking:"), 0, 1);
		bankingPane.add(new Label("Savings:"), 0, 2);
		bankingPane.add(checkingAccountID, 1, 1);
		bankingPane.add(savingsAccountID, 1, 2);
		bankingPane.add(hboxTx1Checking, 2, 1);
		bankingPane.add(hboxTx2Checking, 3, 1);
		bankingPane.add(hboxTx1Savings, 2, 2);
		bankingPane.add(hboxTx2Savings, 3, 2);
		bankingPane.add(buttons, 1, 4);
		
		submitBT.setOnAction(e -> bankOutput());
		resetBT.setOnAction(e -> resetForm());
		
		VBox bankInput = new VBox();
		bankInput.setSpacing(10.0);
		bankInput.setPadding(new Insets(10));
		bankInput.getChildren().addAll(hbox1, hbox2, bankingPane, output);
		output.setPadding(new Insets(0, 0, 0, 75));
		output.setWrapText(true);
		output.setPrefWidth(600);
		
		Scene scene = new Scene(bankInput, 700, 300);
		scene.getStylesheets().add(getClass().getResource("account.css").toExternalForm());
		primaryStage.setTitle("Account Detail");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		bankInput.requestFocus();
	}
	
	private void bankOutput() {
		// enter error handling. (if textfields are empty) (if textfields are wrong value types)
		String savingsTx1Action = savingsTx1AccountType.getValue();
		String savingsTx2Action = savingsTx2AccountType.getValue();
		String checkingTx1Action = checkingTx1AccountType.getValue();
		String checkingTx2Action = checkingTx2AccountType.getValue();
		
		if (savingsBalance.getText() == null || checkingBalance.getText() == null || annualInterestRate.getText() == null ||
				overdraftLimit.getText() == null || savingsAccountID.getText() == null || checkingAccountID.getText() == null || 
				savingsTx1Action == null || savingsTx2Action == null || checkingTx1Action == null || checkingTx2Action == null ||
				savingsTx1Amount == null || savingsTx2Amount == null || checkingTx2Amount == null || checkingTx2Amount == null) {
			output.setText("Please enter values for all fields!");
			primaryStage.setHeight(325);
		} else if (Pattern.matches("[a-zA-Z]+", savingsBalance.getText()) || Pattern.matches("[a-zA-Z]+", checkingBalance.getText()) ||
				Pattern.matches("[a-zA-Z]+", annualInterestRate.getText()) || Pattern.matches("[a-zA-Z]+", overdraftLimit.getText()) ||
				Pattern.matches("[a-zA-Z]+", savingsTx1Amount.getText()) || Pattern.matches("[a-zA-Z]+", savingsTx2Amount.getText()) ||
				Pattern.matches("[a-zA-Z]+", checkingTx1Amount.getText()) || Pattern.matches("[a-zA-Z]+", checkingTx2Amount.getText())){
			output.setText("Please enter only digits for Balances, Annual Interest Rate, Overdraft Limit, and Transaction Amounts!");
			primaryStage.setHeight(350);
		} else {
		
		SavingsAccount saving = new SavingsAccount(Integer.parseInt(savingsAccountID.getText()), 
				Double.parseDouble(savingsBalance.getText()));
		CheckingAccount checking = new CheckingAccount(Integer.parseInt(checkingAccountID.getText()), 
				Double.parseDouble(checkingBalance.getText()), Double.parseDouble(overdraftLimit.getText()));
		
		saving.setAnnualInterestRate(Double.parseDouble(annualInterestRate.getText()));
		checking.setAnnualInterestRate(Double.parseDouble(annualInterestRate.getText()));
		checking.setOverdraftLimit(Double.parseDouble(overdraftLimit.getText()));
		
		if (savingsTx1Action == "Withdraw") {
			saving.withdraw(Double.parseDouble(savingsTx1Amount.getText()));
		} else saving.deposit(Double.parseDouble(savingsTx1Amount.getText()));
		
		if (savingsTx2Action == "Withdraw") {
			saving.withdraw(Double.parseDouble(savingsTx2Amount.getText()));
		} else saving.deposit(Double.parseDouble(savingsTx2Amount.getText()));
		
		if (checkingTx1Action == "Withdraw") {
			checking.withdraw(Double.parseDouble(checkingTx1Amount.getText()));
		} else checking.deposit(Double.parseDouble(checkingTx1Amount.getText()));
		
		if (checkingTx2Action == "Withdraw") {
			checking.withdraw(Double.parseDouble(checkingTx2Amount.getText()));
		} else checking.deposit(Double.parseDouble(checkingTx2Amount.getText()));
		
		outputEntries = checking.toString() + "\n" + saving.toString() + "\n";
		output.setText(outputEntries);
		
		primaryStage.setHeight(550);}
	}
	
	private void resetForm() {
		checkingBalance.setText("");
		savingsBalance.setText("");
		annualInterestRate.setText("");
		overdraftLimit.setText("");
		checkingAccountID.setText("");
		savingsAccountID.setText("");
		checkingTx1Amount.setText("");
		checkingTx2Amount.setText("");
		savingsTx1Amount.setText("");
		savingsTx2Amount.setText("");
		checkingTx1AccountType.getSelectionModel().clearSelection();
		checkingTx2AccountType.getSelectionModel().clearSelection();
		savingsTx1AccountType.getSelectionModel().clearSelection();
		savingsTx2AccountType.getSelectionModel().clearSelection();
		output.setText("");
		outputEntries = "";
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
