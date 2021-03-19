package Bank;

public class Account {

	private int accountNo; 
	private int balance; 
	private int day;
	private String lamo;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getLamo() {
		return lamo;
	}

	public void setLamo(String lamo) {
		this.lamo = lamo;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Account(int i) { // 계좌를 입력받는 메소드
		this.accountNo = i;
	}

	public int lastMoney(String lamo) {
		this.lamo = lamo;
		int stm = Integer.parseInt(lamo);
		balance += stm;
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - -");
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("현재잔액 : " + balance + "원");
		System.out.println("- - - - - - - - - - - - - - - - -");
		return balance;
	}

	public void showSearch() {

	}

	public int deposit(int money) { // 잔액을 합산하는 메소드
		if (money > 0) { // 입금액이 양수일 경우
			balance += money; // 금액을 더한다
			System.out.println("정상 입금되었습니다.");
			System.out.print("현재 잔액은 : " + balance + "원 입니다.");
			return balance;
		} else { // 입금액이 양수가 아닐경우
			System.out.println("입금이 불가능 합니다."); // 오류 메시지를 출력한다
			System.out.println("다시 확인해 주세요.");
			return balance;
		}
	}

	public int withdraw(int money) { // 잔액을 차감하는 메소드
		if (money > 0 && balance >= money) { // 잔액이 더 클 경우
			balance -= money; // 잔액을 차감한다
			System.out.println("정상 출금되었습니다.");
			System.out.print("현재 잔액은 : " + balance + "원 입니다.");
			return balance;
		} else if (money <= 0) { // 출금액이 없거나 음수인 경우
			System.out.println("출금이 불가능 합니다."); // 오류 메시지를 출력한다
			System.out.println("다시 확인해 주세요.");
			return balance;
		} else { // 출금액이 더 클 경우
			System.out.println("잔액이 부족합니다."); // 오류 메시지를 출력한다
			System.out.println("다시 확인해 주세요.");
			return balance;
		}
	}

	public void showBalance() { // 잔액을 보여주는 메소드
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("현재잔액 : " + balance + "원");
	}

//	private void printList(String keyword) {
//		for (int i = 0; i < pList.size(); i++) {
//			String serchName = pList.get(i).getName();
//			if (serchName.contains(keyword)) {
//				System.out.print(i + 1 + ".   ");
//				System.out.print(pList.get(i).getName() + "\t");
//				System.out.print(pList.get(i).getHp() + "\t");
//				System.out.print(pList.get(i).getCompany() + "\t");
//				System.out.println("");
//			}
//		}
//	}
}

//public void Client(int day, int plusm, int minusm, int chan) {
//this.day = day;
//this.plusm = plusm;
//this.minusm = minusm;
//this.chan = chan;
//
//if (plusm > 0) {
//	balance += plusm;
//}
//if (minusm > 0) {
//	balance -= minusm;
//}
//System.out.println("계좌번호 : " + accountNo);
//System.out.println("현재잔액 : " + balance + "원");
//}
