package main;

import java.util.Scanner;

import dao.Dao;
import dto.Dto;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			Dao dao = Dao.getInstance();
			
			System.out.println("-사원관리 프로그램-");
			System.out.println("1.사원추가");
			System.out.println("2.사원삭제");
			System.out.println("3.사원검색");
			System.out.println("4.사원수정");
			System.out.println("5.사원출력");
			System.out.print(">>>>> ");
			
			int work = scan.nextInt();
			
			switch(work) {
			case 1:
				dao.insert();
				break;
			case 2:
				dao.delete();
				break;
			case 3:
				dao.select();
				break;
			case 4:
				dao.update();
				break;	
			case 5:
				dao.allprint();
				break;	
		}
		
	}

}
}
