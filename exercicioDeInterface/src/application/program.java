package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.Paypalservice;

public class program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com dados do contrato: ");
		System.out.println("Número: ");
		int number = sc.nextInt();
        System.out.println("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.println("Valor do contrato: ");
        double toalvalue = sc.nextDouble();        
        
        Contract obj = new Contract(number,date,toalvalue );
        
        System.out.println("Entre com o numero de parcelas: ");
        int n = sc.nextInt();
        
        ContractService  contractService = new  ContractService(new Paypalservice());
         
        contractService.processContract(obj, n);
        
        System.out.println("Parcelas: ");
        for (Installment installment : obj.getInstalments()) {
        	System.out.println(installment);
        }
        
	   sc.close();
	}

}
