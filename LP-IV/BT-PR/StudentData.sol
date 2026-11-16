// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract StudentData {
    // Structure to store student details
    struct Student {
        uint256 id;
        string name;
        uint256 age;
        string course;
    }

    // Array to store students
    Student[] public students;

    // Events for logging activity
    event StudentAdded(uint256 indexed id, string name, string course);
    event FallbackCalled(address sender, uint256 value, bytes data);
    event EtherReceived(address sender, uint256 value);

    // Add student data
    function addStudent(
        uint256 _id,
        string memory _name,
        uint256 _age,
        string memory _course
    ) public {
        students.push(Student(_id, _name, _age, _course));
        emit StudentAdded(_id, _name, _course);
    }

    // Get student data using array index
    function getStudent(uint256 index)
        public
        view
        returns (uint256, string memory, uint256, string memory)
    {
        require(index < students.length, "Student index out of bounds");
        Student memory s = students[index];
        return (s.id, s.name, s.age, s.course);
    }

    // Helper to check total number of students
    function getTotalStudents() public view returns (uint256) {
        return students.length;
    }

    // Triggered when Ether is sent with empty calldata
    receive() external payable {
        emit EtherReceived(msg.sender, msg.value);
    }

    // Fallback function triggered when calldata does not match any function
    fallback() external payable {
        emit FallbackCalled(msg.sender, msg.value, msg.data);
    }
}
