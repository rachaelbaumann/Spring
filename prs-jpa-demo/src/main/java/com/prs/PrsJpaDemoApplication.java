package com.prs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.User;
import com.prs.business.UserDB;
import com.prs.util.Console;

@SpringBootApplication
public class PrsJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemoApplication.class, args);
		System.out.println("Welcome to the 'JPA Demonstration' application!");
		
		String command = "";
		while (!command.equals("6")) {
			displayMenu();
			command = Console.getString("Enter a command (1-6):  ");
			if (command.equals("1")) {
				// list users
				List<User> users = UserDB.list();
				System.out.println("List of users:");
				for (User u : users) {
					System.out.println(u);
				}
			} else if (!command.equals("6")) {// validate that data
				System.out.println("Invalid command!");
			}
		}
		
		System.out.println("Thanks for stopping by!");
	}
	
	private static void displayMenu() {
		StringBuilder sb = new StringBuilder("COMMAND MENU\n");
		sb.append("1 - List users\n");
		sb.append("6 - Exit\n");
		System.out.println(sb);
	}
}
