package Bank;

import java.util.List;

public interface AccountDAO {
	public List<AccountVO> getList();
	public AccountVO get(Long id);
	public boolean insert(AccountVO accountVO);
	public boolean delete(Long id);
	public boolean update(AccountVO accountVO);
	
	public List<AccountInfoVO> getList(String text);
}
