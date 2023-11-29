import com.example.jweb_final_test.dao.AccountDAO;
import com.example.jweb_final_test.dao.AccountDAOImpl;
import com.example.jweb_final_test.entity.Account;
import com.example.jweb_final_test.entity.TransactionHistory;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOImpl();
        System.out.println(accountDAO.getAccount("Phuoc1"));
    }
}
