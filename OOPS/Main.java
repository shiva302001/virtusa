import java.util.*;
import java.io.*;


public class Main
{
	public static void main(String[] args) {

        // [Default] Displaying choices
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Add Employee Details");
		System.out.println("2.View Single Employee Details");
		System.out.println("3.View All  Employee Details");
		System.out.println("4.Update Employee Details");
		System.out.println("5.DeleteEmployee Details");
		System.out.println("6.Exit");


        //choices
		int i=0; 

        //Create an object of AddEmployeeDetails class to access all methods
		AddEmployeeDetails add = new AddEmployeeDetails();
		while(i!=6)
		{
		    System.out.println("Enter a Choice :");
		    i=sc.nextInt();
		if(i>=1&&i<=6)
		{
		    switch(i)
		    {
                //Case 1 - Add Details
		        case 1:
		            {
		                
		                System.out.println("Enter Name of the Employee :");
		                String ename=sc.next();
		                System.out.println("Enter ID of the Employee :");
		                int eid=sc.nextInt();
		                System.out.println("Enter MobileNumber of the Employee :");
		                String emobile=sc.next();
		                System.out.println("Enter Email ID of the Employee :");
		                String eemailid=sc.next();
		                System.out.println("Enter Salary of the Employee :");
		                int esalary=sc.nextInt();
		                System.out.println("Enter Gender of the Employee :");
		                String egender=sc.next();
		                System.out.println("Enter Address of the Employee :");
		                String eaddress=sc.next();
		                System.out.println("Enter Date of Birth of the Employee :");
		                String edob=sc.next();
		                System.out.println("Enter Date of Joining  of the Employee :");
		                String edoj=sc.next();
		                System.out.println("Enter Experienceof the Employee :");
		                int eexp=sc.nextInt();

                        //Using 'add' object of class 'AddEmployeeDetails', we are accessing the method - 'AddDetails' to add the details.
		                add.AddDetails(ename,eid,esalary,emobile,eemailid,egender,eaddress,edob,edoj,eexp);
		                break;
		            }

                    //Case 2 - View Single Employee Details
		            case 2:
		                {

		                    System.out.println("Enter employee id :");
		                    int eid=sc.nextInt();

                            //166
		                    add.Search(eid);
		                    break;
		                }

                        //Case 3 - View all employee details
		                case 3:
		                    {
                                //190
		                        add.ShowAll();
		                        break;
		                    }

                            //Case 4 - Update Detials
		                    case 4:
		                        {
		                            System.out.println("Enter Employee Id :");
		                            int epid=sc.nextInt();
		                            System.out.println("Enter Employee new Salary :");
		                            int eesal=sc.nextInt();

                                    //257
		                            add.Update(epid,eesal);
		                        }
                        
                        //Case 5 - Delete Employee Detials
		                case 5:
		                    {
		                        System.out.println("Enter Employee id to delete");
		                        int eeid=sc.nextInt();
                                
                                //220
		                        add.Delete(eeid); 
		                        break;
		                    }
		    }
		}
		}
		
	}
}

// Class Node represents the Employee
class Node{
    Node next;
    String name;
    int id;
    int salary;
    String mobilenumber;
    String emailid;
    String gender;
    String address;
    String dob;
    String doj;
    int exp;


    Node(String name,
    int id,
    int salary,
    String mobilenumber,
    String emailid,
    String gender,
    String address,
    String dob,
    String doj,
    int exp)
    {
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.mobilenumber=mobilenumber;
        this.emailid=emailid;
        this.gender=gender;
        this.dob=dob;
        this.doj=doj;
        this.exp=exp;
        this.address=address;
    }
}




//This class contains all the necessary methods
class AddEmployeeDetails{
    Node head,newNode,temp;

    
    void AddDetails(
    String name,
    int id,
    int salary,
    String mobilenumber,
    String emailid,
    String gender,
    String address,
    String dob,
    String doj,                                                     
    int exp){
        newNode = new Node(name,id,salary,mobilenumber,emailid,gender,address,dob,doj,exp);
        if(head == null)
			head = newNode;
		else
		{
			for(temp = head;temp.next!=null;temp=temp.next);
			temp.next=newNode;
		}
		System.out.println("Employee details added successfully");
    }


    void Search(int n)
    {
		for(temp = head;temp!=null;temp=temp.next)
		{
			if(temp.id == n)
			{
				break;
			}
		}
		System.out.println("Employee Name: "+temp.name);
		System.out.println("Employee Id: "+temp.id);
		System.out.println("Employee Salary: "+temp.salary);
		System.out.println("Employee MobileNumber: "+temp.mobilenumber);
		System.out.println("Employee address: "+temp.address);
		System.out.println("Employee Email Id: "+temp.emailid);
		System.out.println("Employee gender: "+temp.gender);
		System.out.println("Employee Date Of Birth: "+temp.dob);
		System.out.println("Employee Date of Joining: "+temp.doj);
		System.out.println("Employee Experience: "+temp.exp+" Years");
}


void ShowAll()
{
    System.out.println("Details of all the Employees are :");
		for(temp=head;temp!=null;temp=temp.next)
		{
		System.out.println("Employee Name: "+temp.name);
		System.out.println("Employee Id: "+temp.id);
		System.out.println("Employee Salary: "+temp.salary);
		System.out.println("Employee MobileNumber: "+temp.mobilenumber);
		System.out.println("Employee address: "+temp.address);
		System.out.println("Employee Email Id: "+temp.emailid);
		System.out.println("Employee gender: "+temp.gender);
		System.out.println("Employee Date Of Birth: "+temp.dob);
		System.out.println("Employee Date of Joining: "+temp.doj);
		System.out.println("Employee Experience: "+temp.exp+" Years");
		System.out.println(" ");
		}
		
}


void Delete(int n)
{
        if(head == null)
        {
                System.out.println("No Details are present");
        }
		else if(head.next == null)
		{
			
			System.out.println("Employee Details with id :"+n+" is deleted");
			head = null;
		}
		else
		{
			Node prev = null;
			boolean found = false;
            
			for(temp = head;temp!=null;temp=temp.next)
			{
				if(temp.id == n)
				{
					found = true;
					break;
				}
				prev = temp;
			}
			if(found)
			{
				System.out.println("Employee Details with id :"+n+" is deleted");
				prev.next = temp.next;
				temp.next=null;
			}
			else
			{
				System.out.println("Enter valid Employee id");
			}
		}
}



void Update(int n,int eesal)
{
    for(temp = head;temp!=null;temp=temp.next)
		{
			if(temp.id == n)
			{
				temp.salary=eesal;
			}
		}
		System.out.println("Employee Details are updated");
    
}
}


