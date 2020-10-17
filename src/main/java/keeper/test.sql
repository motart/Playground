SQL:

employee | department
Kishore  | BI
Ibrahim  | BI
Nick     | BI
Gene     | KeeperAPP
Huy      | KeeperAPP
Matt     | BI


print all enployees in the same deparment in this format

employee | cowroker
Kishore  | Ibrahim
Kishore  | Nick
Kishore  | Matt
Ibrahim  | Kishore
Ibrahim  | Nick
Ibrahim  | Matt

select a.employee, b.employees from employees a
    join employees b
    on a.department ==  b.department and a.employee <> b.employee;
