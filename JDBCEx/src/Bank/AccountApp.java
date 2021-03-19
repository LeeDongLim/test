package Bank;

import java.io.BufferedReader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int money;
		Account account = new Account(100100);
		System.out.println("- - - - - - - - - - - - - - - - -");
		System.out.println("        국민은행 모바일 뱅킹");
		System.out.println("       계좌번호를 입력해 주세요");
		System.out.println("- - - - - - - - - - - - - - - - -");
		System.out.print("입력>");
		int Clientinfo = sc.nextInt();

		
		// 계좌내역이 일치하면 정보 불러오기
//		if (account.equals(Clientinfo)) {
		if (Clientinfo == 100100) {
			try {
				File txt = new File("D:/Eclipse/eclipse/Client_20210225_001.txt");
				String fileLine = "";
				FileReader txt_reader = new FileReader(txt);
				int x = 0;
				while ((x = txt_reader.read()) != -1) {
//					System.out.print((char) x);
				}
				String k = String.valueOf(x);
				String[] s = k.split(",");
				fileLine = s[(s.length) - 1];
				account.lastMoney(fileLine);
				txt_reader.close();
			} catch (FileNotFoundException e) {
				e.getStackTrace();
			} catch (IOException e) {
				e.getStackTrace();
			}

			
		} else { // 계좌내역이 없을 경우 계좌 생성하기
			System.out.println("- - - - - - - - - - - - - - - - -");
			System.out.println("     등록된 계좌 정보가 없습니다");
			System.out.println("      새로 등록하시겠습니까?");
			System.out.println("  | 1.등록 | 2.취소 | 3.무통장입금 |");
			System.out.println("- - - - - - - - - - - - - - - - -");
			System.out.print("선택>");
			int NewClient = sc.nextInt();

			switch (NewClient) {
			case 1:

				break;

			case 2:
				System.out.print("프로그램 종료");
				break;

			case 3:
				System.out.println("- - - - - - - - - - - - - - - - -");
				System.out.println("   송금할 계좌를 입력하시겠습니까?");
				System.out.println("     | 1.바로입력 | 2.검색 |");
				System.out.println("- - - - - - - - - - - - - - - - -");
				System.out.println("선택 > ");
				int search = sc.nextInt(); 
				if (search == 1) {
					System.out.println("- - - - - - - - - - - - - - - - -");
					System.out.println("송금할 계좌를 입력해주세요");
					System.out.println("입력 > ");
					System.out.println("- - - - - - - - - - - - - - - - -");
					int anotherClient  = sc.nextInt(); 
					System.out.println("송금액 >");
					System.out.println("- - - - - - - - - - - - - - - - -");
					int mone = sc.nextInt();
					System.out.println("정상 송금되었습니다.");
					System.out.println("송금계좌 : " + anotherClient);
					System.out.println("송금액 : " + mone + " 원");
					System.out.println("- - - - - - - - - - - - - - - - -");
				} else if (search ==2 ) {
					System.out.println("송금하고자 하는 사람의 성명을 입력해주세요");
					System.out.println("성명 > ");
//						String keyword = sc.nextLine();
//						account.showSearch(keyword);
	}
			default:
				System.out.println("다시 입력해 주세요.");
				break;

				
			}		
	}



	while(run) { // 앱 정상 접속 시
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - -");
		System.out.println("        국민은행 모바일 뱅킹");

		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String today = now.format(time);
		System.out.println("접속시간 : " + time);
		System.out.println("| 1.예금 | 2.출금 | 3.잔고 | 4.종료 |");
		System.out.println("- - - - - - - - - - - - - - - - -");
		System.out.print("선택>");
		int menuNo = sc.nextInt(); // 메뉴에서 입력하는 값 불러오기
		switch (menuNo) {
		case 1:
			System.out.print("입금액 >");
			money = sc.nextInt(); // 값 읽어오기(정수형)
			account.deposit(money); // 잔액 합산
			break;
		case 2:
			System.out.print("출금액 >");
			money = sc.nextInt(); // 값 읽어오기(정수형)
			account.withdraw(money); // 잔액 차감
			break;
		case 3:
			// System.out.print("");
			account.showBalance(); // 계좌 잔액 보여주기(정수형)
			break;
		case 4:
			System.out.print("프로그램 종료");
			run = false; // 런은 거짓(while문 종료)
			break;
		default: // 케이스에 없는 값이 나왔을때
			System.out.println("다시 입력해 주세요.");
			break;
		}// switch
			// 키워드로 검색한 리스트를 출력한다

	} // while
	sc.close();
			
		}
}

// 통장내역 인식, 내역별 분리
//for (int i = 0; i < 9; i++) {
//	Integer[] sArr = x.split(" "); // 띄워쓰기 기준으로 인식
////		Integer.parseInt(sArr); // 정수형으로 변환
//	account.Client(sArr);
//}
