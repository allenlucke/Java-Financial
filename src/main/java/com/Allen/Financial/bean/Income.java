package main.java.com.Allen.Financial.bean;


//import javax.persistence.*;
import java.sql.Timestamp;


public class Income {

    private long id;
    private String income_name;
    private Boolean recieved;
    private Timestamp due_on;
    private Timestamp recieved_on;
    private Boolean recurring;
    private Long amount_expected;
    private Long amount_actual;
    private Long user_Id;
    
	public Income() {}

	//Getters and Setters
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIncome_name() {
		return income_name;
	}

	public void setIncome_name(String income_name) {
		this.income_name = income_name;
	}

	public Boolean getRecieved() {
		return recieved;
	}

	public void setRecieved(Boolean recieved) {
		this.recieved = recieved;
	}

	public Timestamp getDue_on() {
		return due_on;
	}

	public void setDue_on(Timestamp due_on) {
		this.due_on = due_on;
	}

	public Timestamp getRecieved_on() {
		return recieved_on;
	}

	public void setRecieved_on(Timestamp recieved_on) {
		this.recieved_on = recieved_on;
	}

	public Boolean getRecurring() {
		return recurring;
	}

	public void setRecurring(Boolean recurring) {
		this.recurring = recurring;
	}

	public Long getAmount_expected() {
		return amount_expected;
	}

	public void setAmount_expected(Long amount_expected) {
		this.amount_expected = amount_expected;
	}

	public Long getAmount_actual() {
		return amount_actual;
	}

	public void setAmount_actual(Long amount_actual) {
		this.amount_actual = amount_actual;
	}

	public Long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}


	//Constructor
	public Income(long id, String income_name, Boolean recieved, Timestamp due_on, Timestamp recieved_on, Boolean recurring, Long amount_expected, Long amount_actual, Long user_Id) {
		this.id = id;
        this.income_name = income_name;
        this.recieved = recieved;
        this.due_on = due_on;
        this.recieved_on = recieved_on;
        this.recurring = recurring;
        this.amount_expected = amount_expected;
        this.amount_actual = amount_actual;
        this.user_Id = user_Id;
		
		}
	
    @Override
    public String toString() {
    	return "Income [id=" + id + ", income_name=" + income_name + ", recieved" + recieved + ", due_on" + due_on + ", recieved_on" + recieved_on + 
    			", recurring" + recurring + ", amount_expected" + amount_expected + ", amount_actual" + amount_actual + ", user_Id" + user_Id + "]";
    }
    
}