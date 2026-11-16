
// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract BankAccount {

    address public owner;
    uint256 private balance;

    constructor() {
        owner = msg.sender;
    }

    // Deposit Ether
    function deposit() public payable {
        require(msg.value > 0, "Amount must be greater than zero");

        balance += msg.value;
    }

    // Withdraw Ether
    function withdraw(uint256 amount) public {
        require(msg.sender == owner, "Only owner can withdraw");
        require(amount > 0, "Amount must be greater than zero");
        require(amount <= balance, "Insufficient balance");

        balance -= amount;

        payable(owner).transfer(amount);
    }

    // Display account balance
    function getBalance() public view returns (uint256) {
        return balance;
    }
}
