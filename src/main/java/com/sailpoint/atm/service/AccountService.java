package com.sailpoint.atm.service;

import com.sailpoint.atm.domain.Account;

public interface AccountService {
    Account createAccount(String fullName, String username, String pin);

    Account loginAccount(String username, String pin);
}
