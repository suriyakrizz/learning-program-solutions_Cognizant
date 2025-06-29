SET SERVEROUTPUT ON;

BEGIN
  FOR cust IN (
    SELECT c.CustomerID
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
    WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = cust.CustomerID;

    DBMS_OUTPUT.PUT_LINE('Discount applied for Customer ID: ' || cust.CustomerID);
  END LOOP;
END;
/
