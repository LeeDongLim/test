package Bank;

public class AccountInfoVO {

	private Long seqId; // 일련번호
	private String deposit; // 예금액
	private String withdraw; // 출금액
	private String balance; // 잔액
	private String trdate; // 거래일
	
//	public BookInfoVO(long bookId, String title, String pubs, String pubDate, String authorId) {
//	}

	public AccountInfoVO(Long seqId, String deposit, String withdraw, String balance, String trdate) {
			super();
			this.seqId = seqId;
			this.deposit = deposit;
			this.withdraw = withdraw;
			this.balance = balance;
			this.trdate = trdate;
	}

	// Getters/Setters
	public Long getSeqId() {
		return seqId;
	}

	public void setSeqId(Long seqId) {
		this.seqId = seqId;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String gettrDate() {
		return trdate;
	}

	public void settrDate(String trdate) {
		this.trdate = trdate;
	}

	
	public String toString() {
		return "AccountVO [seqId=" + seqId +
				", deposit=" + deposit +
				", withdraw=" + withdraw +
				", balance=" + balance +
				", trdate=" + trdate +
				"]";
	}
}