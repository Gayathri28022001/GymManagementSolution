package com.example.gms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.gms.model.Batch;
import com.example.gms.model.Participants;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Batch> batches = new ArrayList<>();

		while (true) {
			System.out.println("\n--- Enter details for a new Batch ---");

			System.out.println("Enter Batch ID:");
			int bid = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter Batch Name:");
			String batchName = scanner.nextLine();

			System.out.println("Enter Time Slot (e.g., Morning/Evening):");
			String timeSlot = scanner.nextLine();

			System.out.println("Enter Trainer Name:");
			String trainerName = scanner.nextLine();

			Batch batch = new Batch(bid, batchName, timeSlot, trainerName);

			System.out.println("Enter number of participants for this batch:");
			int numParticipants = scanner.nextInt();
			scanner.nextLine();

			for (int i = 1; i <= numParticipants; i++) {
				System.out.println("\nEnter details for Participants " + i + ":");

				System.out.print("Participants ID: ");
				int pid = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Name: ");
				String name = scanner.nextLine();

				System.out.print("Phone: ");
				String phone = scanner.nextLine();

				System.out.print("Email: ");
				String email = scanner.nextLine();

				Participants participants = new Participants(pid, name, phone, email, bid);
				batch.addParticipant(participants);
			}

			batches.add(batch);

			System.out.print("\nDo you want to add another batch? (yes/no): ");
			String choice = scanner.nextLine();
			if (!choice.equalsIgnoreCase("yes")) {
				break;
			}
		}

		System.out.println("\n--- Starting All Batches ---");
		for (Batch batch : batches) {
			System.out.println("\n" + batch);
			batch.startBatch();
		}

		scanner.close();
	}
}
