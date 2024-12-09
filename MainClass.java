package app;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			DBCode db=new DBCode();
			while(true) {
				System.out.println("Dashboard");
				System.out.println("1.Add\n2.View\n3.Edit\n4.Delete\n5.Exit");
				System.out.print("Enter Choice : ");
				int ch=sc.nextInt();
				sc.nextLine();
				if(ch==1) {
					System.out.print("Enter Name :");
					String n=sc.nextLine();
					System.out.print("Enter Expiry Date (YYYY-MM-DD) :");
					String e=sc.nextLine();
					System.out.print("Enter Price : ");
					float p=sc.nextFloat();
					int res=db.insert(n, e, p);
					System.out.println((res!=0)?"Registered":"Failed");
				}
				
				else if(ch==2) {
					db.view();
				}
				else if(ch==3) {
					System.out.print("Enter ID :");
					int i=sc.nextInt();
					db.view(i);
					System.out.println("Press Y to Modify? ");
					char q=sc.next().charAt(0);	
					if(q=='Y' || q=='y') {
						System.out.print("Enter New Price : ");
						float p=sc.nextFloat();
						int r=db.edit(i, p);
						System.out.println((r!=0)?"Modified":"Failed");
					}
					else {
						System.out.println("Cancelled");
					}
				}
				else if(ch==4) {
					System.out.print("Enter ID :");
					int i=sc.nextInt();
					System.out.println("Press Y to Delete? ");
					char q=sc.next().charAt(0);	
					if(q=='Y' || q=='y') {
						int r=db.delete(i);
						System.out.println((r!=0)?"Deleted":"Failed");
					}
					else {
						System.out.println("Cancelled");
					}
				}
				else if(ch==5) {
					System.out.println("App Closed");
					break;
				}
				else {
					System.out.println("Invalid Choice");
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			sc.close();
		}
	}
}
